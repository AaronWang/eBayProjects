package examples.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import modelLayer.ImageEntityTable;

import org.persistence.ImageEntity;
import org.scribe.model.Token;
import org.xml.sax.SAXException;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.people.PeopleInterface;
import com.flickr4java.flickr.people.User;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.Size;
import com.flickr4java.flickr.photosets.Photoset;
import com.flickr4java.flickr.photosets.Photosets;
import com.flickr4java.flickr.photosets.PhotosetsInterface;
import com.flickr4java.flickr.prefs.PrefsInterface;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.AuthStore;
import com.flickr4java.flickr.util.FileAuthStore;

import examples.java.UploadPhoto.UploadFilenameFilter;

public class UploadPhotoSimple {

	String apiKey = null;
	String sharedSecret = null;
	String username = null;
	String nsid = null;
	Flickr flickr;
	AuthStore authStore;
	boolean setOrigFilenameTag;
	private int privacy = -1;
	// setid + photoset
	HashMap<String, Photoset> allSetsMap = new HashMap<String, Photoset>();
	// set title + setid
	HashMap<String, ArrayList<String>> setNameToId = new HashMap<String, ArrayList<String>>();

	private String setid = null;
	private String basefilename = null;
	// all photos
	private final PhotoList<Photo> photos = new PhotoList<Photo>();
	// photo titile + photo
	private final HashMap<String, Photo> filePhotos = new HashMap<String, Photo>();
	// photo id + photo
	private final HashMap<String, Photo> IdPhotos = new HashMap<String, Photo>();

	private static final String[] photoSuffixes = { "jpg", "jpeg", "png", "gif", "bmp", "tif", "tiff" };
	private static final String[] videoSuffixes = { "3gp", "3gp", "avi", "mov", "mp4", "mpg", "mpeg", "wmv", "ogg", "ogv", "m2v" };
	private boolean replaceSpaces = false;

	UploadPhotoSimple(String apiKey, String nsid, String sharedSecret, File authsDir, String username) throws FlickrException {

		flickr = new Flickr(apiKey, sharedSecret, new REST());
		this.username = username;
		this.nsid = nsid;
		// this.sharedSecret = sharedSecret;

		String authsDirStr = System.getProperty("user.home") + File.separatorChar + ".flickrAuth";
		authsDir = new File(authsDirStr);

		if (authsDir != null) {
			this.authStore = new FileAuthStore(authsDir);
		}

		// If one of them is not filled in, find and populate it.
		if (username == null || username.equals(""))
			setUserName();
		if (nsid == null || nsid.equals(""))
			setNsid();
	}

	UploadPhotoSimple() throws Exception {
		Properties properties = new Properties();
		InputStream in = null;
		String apiKey = null, sharedSecret = null, nsid = null;

		try {
			// in = UploadPhoto.class.getResourceAsStream("/setup.properties");
			in = new FileInputStream("setup.properties");
			if (in != null) {
				properties.load(in);
				apiKey = properties.getProperty("apiKey");
				sharedSecret = properties.getProperty("secret");
				nsid = properties.getProperty("nsid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}

		flickr = new Flickr(apiKey, sharedSecret, new REST());
		this.username = "wrq3530";
		this.nsid = nsid;
		// this.sharedSecret = sharedSecret;

		String authsDirStr = System.getProperty("user.home") + File.separatorChar + ".flickrAuth";
		File authsDir = new File(authsDirStr);

		if (authsDir != null) {
			this.authStore = new FileAuthStore(authsDir);
		}

		// If one of them is not filled in, find and populate it.
		if (username == null || username.equals(""))
			setUserName();
		if (nsid == null || nsid.equals(""))
			setNsid();

		boolean settagname = true; // Default to true to add tag while
		// uploading.
		setSetorigfilenametag(settagname);
		setAuth();
		if (!canUpload())
			System.exit(1);

		getPrivacy();

		getPhotosetsInfo();

	}

	private void setUserName() throws FlickrException {
		if (nsid != null && !nsid.equals("")) {
			Auth auth = null;
			if (authStore != null) {
				auth = authStore.retrieve(nsid);
				if (auth != null) {
					username = auth.getUser().getUsername();
				}
			}
			// For this to work: REST.java or PeopleInterface needs to change to
			// pass apiKey
			// as the parameter to the call which is not authenticated.

			if (auth == null) {
				// Get nsid using flickr.people.findByUsername
				PeopleInterface peopleInterf = flickr.getPeopleInterface();
				User u = peopleInterf.getInfo(nsid);
				if (u != null) {
					username = u.getUsername();
				}
			}
		}
	}

	private void setNsid() throws FlickrException {
		if (username != null && !username.equals("")) {
			Auth auth = null;
			if (authStore != null) {
				auth = authStore.retrieve(username); // assuming FileAuthStore
														// is enhanced else need
														// to
				// keep in user-level files.
				if (auth != null) {
					nsid = auth.getUser().getId();
				}
			}
			if (auth != null)
				return;

			Auth[] allAuths = authStore.retrieveAll();
			for (int i = 0; i < allAuths.length; i++) {
				if (username.equals(allAuths[i].getUser().getUsername())) {
					nsid = allAuths[i].getUser().getId();
					return;
				}
			}
			// For this to work: REST.java or PeopleInterface needs to change to
			// pass apiKey
			// as the parameter to the call which is not authenticated.

			// Get nsid using flickr.people.findByUsername
			PeopleInterface peopleInterf = flickr.getPeopleInterface();
			User u = peopleInterf.findByUsername(username);
			if (u != null) {
				nsid = u.getId();
			}
		}
	}

	public void setAuth(String authToken, String username, String tokenSecret) throws IOException, SAXException, FlickrException {
		RequestContext rc = RequestContext.getRequestContext();
		Auth auth = null;

		if (authToken != null && !authToken.equals("") && tokenSecret != null && !tokenSecret.equals("")) {
			auth = constructAuth(authToken, tokenSecret, username);
			rc.setAuth(auth);
		} else {
			if (this.authStore != null) {
				auth = this.authStore.retrieve(this.nsid);
				if (auth == null) {
					this.authorize();
				} else {
					rc.setAuth(auth);
				}
			}
		}
	}

	public void setAuth() throws IOException, SAXException, FlickrException {
		setAuth("", "", "");
	}

	/**
	 * If the Authtoken was already created in a separate program but not saved
	 * to file.
	 * 
	 * @param authToken
	 * @param tokenSecret
	 * @param username
	 * @return
	 * @throws IOException
	 */

	private Auth constructAuth(String authToken, String tokenSecret, String username) throws IOException {

		Auth auth = new Auth();
		auth.setToken(authToken);
		auth.setTokenSecret(tokenSecret);

		// Prompt to ask what permission is needed: read, update or delete.
		auth.setPermission(Permission.fromString("delete"));

		User user = new User();
		// Later change the following 3. Either ask user to pass on command line
		// or read
		// from saved file.
		user.setId(nsid);
		user.setUsername((username));
		user.setRealName("");
		auth.setUser(user);
		this.authStore.store(auth);
		return auth;
	}

	private void authorize() throws IOException, SAXException, FlickrException {
		AuthInterface authInterface = flickr.getAuthInterface();
		Token accessToken = authInterface.getRequestToken();

		// Try with DELETE permission. At least need write permission for upload
		// and add-to-set.
		String url = authInterface.getAuthorizationUrl(accessToken, Permission.DELETE);
		System.out.println("Follow this URL to authorise yourself on Flickr");
		System.out.println(url);
		System.out.println("Paste in the token it gives you:");
		System.out.print(">>");

		Scanner scanner = new Scanner(System.in);
		// String tokenKey = scanner.nextLine();
		//
		// Token requestToken = authInterface.getAccessToken(accessToken, new
		// Verifier(tokenKey));
		Token requestToken = new Token("72157656246587881-6e68cc3c1790defd", "6345f7f59fd1e328");

		Auth auth = authInterface.checkToken(requestToken);
		RequestContext.getRequestContext().setAuth(auth);
		this.authStore.store(auth);
		scanner.close();
		System.out.println("Thanks.  You probably will not have to do this every time. Auth saved for user: " + auth.getUser().getUsername() + " nsid is: "
				+ auth.getUser().getId());
		System.out.println(" AuthToken: " + auth.getToken() + " tokenSecret: " + auth.getTokenSecret());
	}

	/**
	 * @param setOrigFilenameTag
	 *            the setOrigFilenameTag to set
	 */

	public void setSetorigfilenametag(boolean setOrigFilenameTag) {
		this.setOrigFilenameTag = setOrigFilenameTag;
	}

	private boolean canUpload() {
		RequestContext rc = RequestContext.getRequestContext();
		Auth auth = null;
		auth = rc.getAuth();
		if (auth == null) {
			System.out.println(" Cannot upload, there is no authorization information.");
			return false;
		}
		Permission perm = auth.getPermission();
		if ((perm.getType() == Permission.WRITE_TYPE) || (perm.getType() == Permission.DELETE_TYPE))
			return true;
		else {
			System.out.println(" Cannot upload, You need write or delete permission, you have : " + perm.toString());
			return false;
		}
	}

	public int getPrivacy() throws Exception {

		PrefsInterface prefi = flickr.getPrefsInterface();
		privacy = prefi.getPrivacy();

		return (privacy);
	}

	public void getPhotosetsInfo() {

		PhotosetsInterface pi = flickr.getPhotosetsInterface();
		allSetsMap.clear();
		setNameToId.clear();
		try {
			int setsPage = 1;
			while (true) {
				Photosets photosets = pi.getList(nsid, 500, setsPage, null);
				Collection<Photoset> setsColl = photosets.getPhotosets();
				Iterator<Photoset> setsIter = setsColl.iterator();
				while (setsIter.hasNext()) {
					Photoset set = setsIter.next();
					allSetsMap.put(set.getId(), set);

					// 2 or more sets can in theory have the same name. !!!
					ArrayList<String> setIdarr = setNameToId.get(set.getTitle());
					if (setIdarr == null) {
						setIdarr = new ArrayList<String>();
						setIdarr.add(new String(set.getId()));
						setNameToId.put(set.getTitle(), setIdarr);
					} else {
						setIdarr.add(new String(set.getId()));
					}
				}

				if (setsColl.size() < 500) {
					break;
				}
				setsPage++;
			}
			// all_sets_retrieved = true;
			// Print dups if any.

			Set<String> keys = setNameToId.keySet();
			Iterator<String> iter = keys.iterator();
			while (iter.hasNext()) {
				String name = iter.next();
				ArrayList<String> setIdarr = setNameToId.get(name);
				if (setIdarr != null && setIdarr.size() > 1) {
					System.out.println("There is more than 1 set with this name : " + setNameToId.get(name));
					for (int j = 0; j < setIdarr.size(); j++) {
						System.out.println("           id: " + setIdarr.get(j));
					}
				}
			}

		} catch (FlickrException e) {
			e.printStackTrace();
		}
	}

	// current setphotos
	String currentSetPhots = "";

	private void getSetPhotosAgain(String setName) throws FlickrException {
		currentSetPhots = "";
		getSetPhotos(setName);
	}

	private void getSetPhotos(String setName) throws FlickrException {
		// Check if this is an existing set. If it is get all the photo list to
		// avoid reloading already
		// loaded photos.
		if (setName.equals(currentSetPhots))
			return;
		currentSetPhots = setName;
		ArrayList<String> setIdarr;
		setIdarr = setNameToId.get(setName);
		filePhotos.clear();
		photos.clear();
		IdPhotos.clear();
		if (setIdarr != null) {
			setid = setIdarr.get(0);
			PhotosetsInterface pi = flickr.getPhotosetsInterface();

			Set<String> extras = new HashSet<String>();
			/**
			 * A comma-delimited list of extra information to fetch for each
			 * returned record. Currently supported fields are: license,
			 * date_upload, date_taken, owner_name, icon_server,
			 * original_format, last_update, geo, tags, machine_tags, o_dims,
			 * views, media, path_alias, url_sq, url_t, url_s, url_m, url_o
			 */

			extras.add("date_upload");
			extras.add("original_format");
			extras.add("media");
			// extras.add("url_o");
			extras.add("tags");

			int setPage = 1;
			while (true) {
				PhotoList<Photo> tmpSet = pi.getPhotos(setid, extras, Flickr.PRIVACY_LEVEL_NO_FILTER, 500, setPage);

				int tmpSetSize = tmpSet.size();
				photos.addAll(tmpSet);
				if (tmpSetSize < 500) {
					break;
				}
				setPage++;
			}
			for (int i = 0; i < photos.size(); i++) {
				filePhotos.put(photos.get(i).getTitle(), photos.get(i));
				IdPhotos.put(photos.get(i).getId(), photos.get(i));
			}
		} else
			setid = null;// does find any photoSet;
	}

	public Collection<Size> getPhotoSizeByID(String id) throws FlickrException {
		PhotosInterface photointerface = flickr.getPhotosInterface();
		return photointerface.getSizes(id);
		// return photointerface.getPhoto(id);
	}

	public String uploadOnePhoto(String setName, String file) throws Exception {
		ArrayList<String> fileList = new ArrayList<String>();
		fileList.add(file);
		return uploadallPhotos(setName, fileList);
	}

	// upload one set of photos
	public String uploadallPhotos(String setName, ArrayList<String> uploadfileArgs) throws Exception {

		if (setName != null && !setName.equals("")) {
			getSetPhotos(setName);
		}

		String photoid = null;
		int i;
		for (i = 0; i < uploadfileArgs.size(); i++) {
			String filename = uploadfileArgs.get(i);

			File f = new File(filename);
			if (f.isDirectory()) {// process all images in this folder.
				String[] filelist = f.list(new UploadFilenameFilter());
				for (int j = 0; j < filelist.length; j++) {
					photoid = processFileArg(uploadfileArgs.get(i) + File.separatorChar + filelist[j], setName);
				}
			} else {
				photoid = processFileArg(filename, setName);// process one image
															// file
			}
		}
		return photoid;// return the last photoid;
	}

	
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ImageEntityTable imagetable = new ImageEntityTable();
		List<ImageEntity> imageList = imagetable.getAll();

		UploadPhotoSimple uploadPhotoSimple = new UploadPhotoSimple();

		// upload a folder photos.

		// Map<String, String> prepareUpload = new HashMap<String, String>();
		// for (ImageEntity image : imageList) {
		// prepareUpload.put(image.getAlbum(), image.getFolder());
		// }
		// for (String key : prepareUpload.keySet()) {
		// ArrayList<String> folder = new ArrayList<String>();
		// folder.add(prepareUpload.get(key));
		// uploadPhotoSimple.uploadallPhotos(key, folder);
		// }

		// uploadPhotoSimple.getPhotosetsInfo();

		// upload one photo.
		for (ImageEntity image : imageList) {
			if (!(image.getURL() == null) && !image.getURL().equals(""))
				continue;

			String photoid = uploadPhotoSimple.uploadOnePhoto(image.getAlbum(), image.getPath());
			if (photoid == null)
				continue;

			Collection<Size> photo = uploadPhotoSimple.getPhotoSizeByID(photoid);
			Size original = null;
			for (Object s : photo.toArray()) {
				if (((Size) s).getLabel() == Size.ORIGINAL) {
					original = (Size) s;
					break;
				}
			}
			image.setPhotoID(photoid);
			image.setURL(original.getSource());
			imagetable.update(image);
			// photo.get
			// image.setURL(uRL);
		}
	}

	private String processFileArg(String filename, String setName) throws Exception {
		String photoid;
		if (filename.equals("")) {
			System.out.println("filename must be entered for uploadfile ");
			return null;
		}
		if (filename.lastIndexOf(File.separatorChar) > 0)
			basefilename = filename.substring(filename.lastIndexOf(File.separatorChar) + 1, filename.length());
		else
			basefilename = filename;

		Photo fileUploaded = checkIfLoaded(filename);

		if (fileUploaded == null) {
			if (!isValidSuffix(basefilename)) {
				System.out.println(" File: " + basefilename + " is not a supported filetype for flickr (invalid suffix)");
				return null;
			}

			File f = new File(filename);
			if (!f.exists() || !f.canRead()) {
				System.out.println(" File: " + filename + " cannot be processed, does not exist or is unreadable.");
				return null;
			}

			photoid = uploadfile(filename, null);
			// Add to Set. Create set if it does not exist.
			if (photoid != null) {
				addPhotoToSet(photoid, setName);
			}
			return photoid;
		} else
			return fileUploaded.getId();
	}

	/**
	 * The assumption here is that for a given set only unique file-names will
	 * be loaded and the title field can be used. Later change to use the tags
	 * field ( OrigFileName) and strip off the suffix.
	 * 
	 * @param filename
	 * @return
	 */
	private Photo checkIfLoaded(String filename) {

		String title;
		if (basefilename.lastIndexOf('.') > 0)
			title = basefilename.substring(0, basefilename.lastIndexOf('.'));
		else
			return null;

		if (filePhotos.containsKey(title))
			return filePhotos.get(title);

		return null;
	}

	private static boolean isValidSuffix(String basefilename) {
		if (basefilename.lastIndexOf('.') <= 0) {
			return false;
		}
		String suffix = basefilename.substring(basefilename.lastIndexOf('.') + 1).toLowerCase();
		for (int i = 0; i < photoSuffixes.length; i++) {
			if (photoSuffixes[i].equals(suffix))
				return true;
		}
		for (int i = 0; i < videoSuffixes.length; i++) {
			if (videoSuffixes[i].equals(suffix))
				return true;
		}
		return false;
	}

	public String uploadfile(String filename, String inpTitle) throws Exception {
		String photoId;

		RequestContext rc = RequestContext.getRequestContext();

		if (this.authStore != null) {
			Auth auth = this.authStore.retrieve(this.nsid);
			if (auth == null) {
				this.authorize();
			} else {
				rc.setAuth(auth);
			}
		}

		// PhotosetsInterface pi = flickr.getPhotosetsInterface();
		// PhotosInterface photoInt = flickr.getPhotosInterface();
		// Map<String, Collection> allPhotos = new HashMap<String,
		// Collection>();
		/**
		 * 1 : Public 2 : Friends only 3 : Family only 4 : Friends and Family 5
		 * : Private
		 **/
		if (privacy == -1)
			getPrivacy();

		UploadMetaData metaData = new UploadMetaData();

		if (privacy == 1)
			metaData.setPublicFlag(true);
		if (privacy == 2 || privacy == 4)
			metaData.setFriendFlag(true);
		if (privacy == 3 || privacy == 4)
			metaData.setFamilyFlag(true);

		if (basefilename == null || basefilename.equals(""))
			basefilename = filename; // "image.jpg";

		String title = basefilename;
		boolean setMimeType = true; // change during testing. Doesn't seem to be
									// supported at this time in flickr.
		if (setMimeType) {
			if (basefilename.lastIndexOf('.') > 0) {
				title = basefilename.substring(0, basefilename.lastIndexOf('.'));
				String suffix = basefilename.substring(basefilename.lastIndexOf('.') + 1);
				// Set Mime Type if known.

				// Later use a mime-type properties file or a hash table of all
				// known photo and video types
				// allowed by flickr.

				if (suffix.equalsIgnoreCase("png")) {
					metaData.setFilemimetype("image/png");
				} else if (suffix.equalsIgnoreCase("mpg") || suffix.equalsIgnoreCase("mpeg")) {
					metaData.setFilemimetype("video/mpeg");
				} else if (suffix.equalsIgnoreCase("mov")) {
					metaData.setFilemimetype("video/quicktime");
				}
			}
		}

		if (inpTitle != null && !inpTitle.equals("")) {
			title = inpTitle;
			metaData.setTitle(title);
		} // flickr defaults the title field from file name.

		// UploadMeta is using String not Tag class.

		// Tags are getting mangled by yahoo stripping off the = , '.' and many
		// other punctuation characters
		// and converting to lower case: use the raw tag field to find the real
		// value for checking and
		// for download.
		if (setOrigFilenameTag) {
			List<String> tags = new ArrayList<String>();
			String tmp = basefilename;
			basefilename = makeSafeFilename(basefilename);
			tags.add("OrigFileName='" + basefilename + "'");
			metaData.setTags(tags);

			if (!tmp.equals(basefilename)) {
				System.out.println(" File : " + basefilename + " contains special characters.  stored as " + basefilename + " in tag field");
			}
		}

		// File imageFile = new File(filename);
		// InputStream in = null;
		Uploader uploader = flickr.getUploader();

		// ByteArrayOutputStream out = null;
		try {
			// in = new FileInputStream(imageFile);
			// out = new ByteArrayOutputStream();

			// int b = -1;
			/**
			 * while ((b = in.read()) != -1) { out.write((byte) b); }
			 **/

			/**
			 * byte[] buf = new byte[1024]; while ((b = in.read(buf)) != -1) {
			 * // fos.write(read); out.write(buf, 0, b); }
			 **/

			metaData.setFilename(basefilename);
			// check correct handling of escaped value

			File f = new File(filename);
			photoId = uploader.upload(f, metaData);

		} finally {
		}
		return (photoId);
	}

	private String makeSafeFilename(String input) {
		byte[] fname = input.getBytes();
		byte[] bad = new byte[] { '\\', '/', '"', '*' };
		byte replace = '_';
		for (int i = 0; i < fname.length; i++) {
			for (byte element : bad) {
				if (fname[i] == element) {
					fname[i] = replace;
				}
			}
			if (replaceSpaces && fname[i] == ' ')
				fname[i] = '_';
		}
		return new String(fname);
	}

	public void addPhotoToSet(String photoid, String setName) throws Exception {

		ArrayList<String> setIdarr;

		// all_set_maps.

		PhotosetsInterface psetsInterface = flickr.getPhotosetsInterface();

		Photoset set = null;

		if (setid == null) {
			// In case it is a new photo-set.
			setIdarr = setNameToId.get(setName);
			if (setIdarr == null) {
				// setIdarr should be null since we checked it getSetPhotos.
				// Create the new set.
				// set the setid .

				String description = "";
				set = psetsInterface.create(setName, description, photoid);
				setid = set.getId();

				setIdarr = new ArrayList<String>();
				setIdarr.add(new String(setid));
				setNameToId.put(setName, setIdarr);

				allSetsMap.put(set.getId(), set);
			}
		} else {
			set = allSetsMap.get(setid);
			psetsInterface.addPhoto(setid, photoid);
		}
		// Add to photos .

		// Add Photo to existing set.
		PhotosInterface photoInt = flickr.getPhotosInterface();
		Photo p = photoInt.getPhoto(photoid);
		if (p != null) {
			photos.add(p);
			String title;
			if (basefilename.lastIndexOf('.') > 0)
				title = basefilename.substring(0, basefilename.lastIndexOf('.'));
			else
				title = p.getTitle();
			filePhotos.put(title, p);
		}
	}
}
