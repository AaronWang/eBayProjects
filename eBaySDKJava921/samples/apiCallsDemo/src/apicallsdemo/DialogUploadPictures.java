/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package apicallsdemo;

import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.border.*;
import com.ebay.sdk.*;
import com.ebay.sdk.pictureservice.*;
import com.ebay.sdk.pictureservice.eps.*;
import com.ebay.soap.eBLBaseComponents.*;

/**
 * <p>Title: DialogUploadPictures</p>
 * <p>Description: upload pictures using EPS</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: </p>
 * @author William Yang
 * @version 1.0
 */

@SuppressWarnings("serial")
public class DialogUploadPictures extends JDialog {
	
	public PictureService picService;

	public JDialog dialog;
	public JList list;
	public JTextArea text;
	public DefaultListModel model;

	public JCheckBox checkBox;
	public JTextField textField;
	
	public File currentDir;
	public DropTarget target;

	JButton addButton, removeButton, uploadButton;
	
	public DialogUploadPictures(Frame frame, String title, boolean modal) {
	    super(frame, title, modal);
	    try {
	      jbInit();
	      pack();

	      FrameDemo fd = (FrameDemo)frame;
	      ApiContext apiContext = fd.getApiContext();
	      
	      //initialize picture service
	      picService = eBayPictureServiceFactory.getPictureService(apiContext);
	      
	      dialog = this;
	    }
	    catch(Exception ex) {
	      ex.printStackTrace();
	    }
	}

	public void jbInit() {
		Action uploadAction = new UploadAction("Upload");
		Action browseAction = new BrowseAction("Browse...");
		Action removeAction = new RemoveAction("Remove");
		Action selectAllAction = new SelectAllAction("Select All");
		
		JPanel cp = new JPanel();
		cp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		cp.setLayout(new BorderLayout());

		setContentPane(cp);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenuItem item;
		int metaKey = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
		fileMenu.add(item = new JMenuItem(browseAction));
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, metaKey));		
		fileMenu.add(item = new JMenuItem(uploadAction));
		editMenu.add(item = new JMenuItem(selectAllAction));
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, metaKey));		
		editMenu.add(item = new JMenuItem(removeAction));
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
		
		model = new DefaultListModel();
		
		list = new JList(model);
		list.getInputMap().put(KeyStroke.getKeyStroke(65,KeyEvent.META_MASK),"selectAllAction");
		list.getActionMap().put("selectAllAction",selectAllAction);
		list.getInputMap().put(KeyStroke.getKeyStroke(8,0),"removeAction");
		list.getActionMap().put("removeAction",removeAction);
		list.setVisibleRowCount(12);
		list.setCellRenderer(new ImageCellRenderer());
		
		target = new DropTarget(list,new FileDropTargetListener());
		
		JScrollPane listPane = new JScrollPane(list);
		listPane.setBorder(BorderFactory.createTitledBorder("Pictures:"));
		cp.add(listPane,BorderLayout.CENTER);
		
		text = new JTextArea();
		text.setRows(6);
		//text.setText("test");
		JScrollPane textPane = new JScrollPane(text);
		textPane.setBorder(BorderFactory.createTitledBorder("Uploaded Pictures URLs:"));
		
		
		cp.add(textPane, BorderLayout.SOUTH);
		

		JPanel ctrPane = new JPanel();
		ctrPane.setLayout(new FlowLayout(FlowLayout.RIGHT,5,10));
		
		JLabel label = new JLabel("ExtInDays:");
		ctrPane.add(label);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(28,20));
		ctrPane.add(textField);
		
		checkBox = new JCheckBox();
		checkBox.setText("Watermark");
		ctrPane.add(checkBox);
		
		uploadButton = new JButton(uploadAction);
		ctrPane.add(uploadButton);
	
		addButton = new JButton(browseAction);
		removeButton = new JButton(removeAction);
		
		ctrPane.add(removeButton);
		ctrPane.add(addButton);

		cp.add(ctrPane,BorderLayout.NORTH);
	
		currentDir = new File(System.getProperty("user.dir"));

	}
	
	public int addToListModel(ArrayList filenames) {
		int count = 0;
		for ( Iterator i = filenames.iterator(); i.hasNext(); ) {
			String filename = (String)i.next();
			model.addElement(filename);
			count++;
		}
		return count;
	}

	class BrowseAction extends AbstractAction {
		public BrowseAction(String text,Icon icon) { super(text,icon); }
		public BrowseAction(String text) { super(text);}

		public void actionPerformed(ActionEvent evt) {			
			JFileChooser chooser = new JFileChooser(currentDir);
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setMultiSelectionEnabled(true);
			chooser.setDragEnabled(true);
			chooser.showOpenDialog(dialog);

			currentDir = chooser.getCurrentDirectory();
			
			File [] files = chooser.getSelectedFiles();
			ArrayList filenames = new ArrayList(files.length);
			for (int i = 0; i < files.length; i++)
				filenames.add(files[i].getPath());
			addToListModel(filenames);
		}
	}
	
	class ImageFileFilter extends javax.swing.filechooser.FileFilter {
		public boolean accept(File file) {
			if (file.isDirectory()) return false;
			String name = file.getName().toLowerCase();
			return (name.endsWith(".jpg") || name.endsWith(".png"));
		}
		public String getDescription() { return "Images ( *.jpg, *.png )"; }
	}

	//Picture Uploading Action
	class UploadAction extends AbstractAction {
		public UploadAction(String text,Icon icon) { super(text,icon); }
		public UploadAction(String text) {super(text);}
		
		public void actionPerformed(ActionEvent evt) {
			try {
			    //upload pictures one by one
			    int size = model.getSize();
			    String result = "";
			    for(int i = 0; i < size; i++) {
			    	String path = (String)model.getElementAt(i);
			    	PictureInfo picInfo = new PictureInfo();
			    	picInfo.setPictureFilePath(path);
			    	UploadSiteHostedPicturesRequestType request = new UploadSiteHostedPicturesRequestType();
			    	//enable watermark
			    	if(checkBox.isSelected()) {
			    		request.setPictureWatermark(new PictureWatermarkCodeType[] {PictureWatermarkCodeType.USER});
			    	}
			    	//extension in days
			    	String extInDays = textField.getText();
			    	if(extInDays != null && extInDays.length() > 0) {
			    		try {
			    			int days = Integer.parseInt(extInDays);
			    			if (days >= 0) {
			    				request.setExtensionInDays(days);
			    			}
			    		} catch(NumberFormatException nfe) {}
			    	}
			    	File file = new File(path);
			    	boolean success = picService.UpLoadSiteHostedPicture(picInfo, request);
			    	if (success) {
			    		result += file.getName() + " : " + picInfo.getURL() + "\r\n";
			    	} else {
			    		result += file.getName() + " : upload failure!" + "\r\n";
			    	}
			    }
			    //output
			    text.setText(result);
			} catch (Exception ex)
			{
		      ((FrameDemo)dialog.getParent()).showErrorMessage(ex.getMessage());
			}
		}
	}

	class RemoveAction extends AbstractAction {
		public RemoveAction(String text,Icon icon) { super(text,icon); }
		public RemoveAction(String text) {super(text);}
		
		public void actionPerformed(ActionEvent evt) {
			int selected [] = list.getSelectedIndices();
			if (selected.length == 0) return;
			for ( int i = selected.length-1; i >= 0; i-- )
				model.removeElementAt(selected[i]);
		}
	}

	class SelectAllAction extends AbstractAction {
		public SelectAllAction(String text) { super(text); }
		
		public void actionPerformed(ActionEvent evt) {
			int num = model.getSize();
			int [] intArray = new int [num];
			for ( int i = 0; i < num; i++ )
				intArray[i] = i;
			list.setSelectedIndices(intArray);
		}
	}
	
	class ImageCellRenderer extends JLabel implements ListCellRenderer {
		public ImageCellRenderer() { 
			setOpaque(true);
			setIconTextGap(12); 
		}
		
		public Component getListCellRendererComponent(
			JList list,
			Object value,
			int index,
			boolean isSelected,
			boolean cellHasFocus)
		{

			File f = new File(value.toString());
		
			Border empty = BorderFactory.createEmptyBorder(3,3,3,3);
			Border matte = BorderFactory.createMatteBorder(0,0,1,0,Color.white);
			setBorder(BorderFactory.createCompoundBorder(matte,empty));
			
			setText(f.getName());
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Image icon = toolkit.getImage(f.getPath());
			Image scaledIcon = icon.getScaledInstance(40,40,Image.SCALE_FAST);
			setIcon(new ImageIcon(scaledIcon));			
			
			if (isSelected) {
				setBackground(new Color(61,128,223));
				setForeground(Color.white);
			} else if (index % 2 == 0) {
				setBackground(new Color(237,243,254));
				setForeground(Color.darkGray);
			} else {
				setBackground(Color.white);
				setForeground(Color.darkGray);
			}		
			return this;
		}
	}

	class FileDropTargetListener extends DropTargetAdapter {
		public void dragEnter(DropTargetDragEvent evt) {
			dialog.requestFocusInWindow();
		}
		
		public void drop(DropTargetDropEvent evt) {
			try {
				Transferable tr = evt.getTransferable();
				DataFlavor [] flavors = tr.getTransferDataFlavors();
				for ( int i = 0; i < flavors.length; i++ ) {
					if ( flavors[i].isFlavorJavaFileListType() ) {
						evt.acceptDrop(DnDConstants.ACTION_COPY);
						java.util.List list2 = (java.util.List)tr.getTransferData(flavors[i]);
						ArrayList filenames = new ArrayList();
						for ( int j = 0; j < list2.size(); j++ ) {
							String path = list2.get(j).toString();
							filenames.add(path);
						}
						if (filenames.size() > 0 ) {
							int numAdded = addToListModel(filenames);
							evt.dropComplete(true);
							return;
						}
					}
					evt.rejectDrop();
				}
			
			} catch (Exception e) {
				e.printStackTrace();
				evt.rejectDrop();
			} 
		}
	}

}
