package picasaWeb;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.test.TestInterface;

public class Test {

	public static void main(String[] args) throws FlickrException {

		String apiKey = "e7b9471b11abc7d216a5e63ce29269ea";
		String sharedSecret = "8e0c2a3d61c9b41d";
		Flickr f = new Flickr(apiKey, sharedSecret, new REST());
		TestInterface testInterface = f.getTestInterface();
		Collection results = testInterface.echo(Collections.EMPTY_MAP);

//		AuthExample example;
	}
}
