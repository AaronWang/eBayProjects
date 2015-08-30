package UI.Tools;

import handler.future.CallBackHandler;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelLayer.ItemTypeTable;
import modelLayer.StoreCustomCategoryTable;
import modules.StorageBox;

import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryArrayType;
import com.ebay.soap.eBLBaseComponents.StoreCustomCategoryType;

import core.Module;
import ebayApiCall.EbayCallAction;
import ebayApiCall.GetMyeBaySellingCallAction;
import ebayClient.EbayClient;
import actor.Actor;
import actor.ActorAssembler;
import bean.Bean;
import bean.callBean.GetCategoriesBean;
import bean.callBean.GetItemBean;
import bean.callBean.GetMyeBaySellingBean;
import bean.callBean.GetStoreBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DataDownLoader extends JFrame {

	private final JPanel contentPanel = new JPanel();
	String accountName = "aaroncollection2015";
	ArrayList<String> activeListItemID = new ArrayList<String>();

	ArrayList<StoreCustomCategoryType> storeCustomCategory = new ArrayList<StoreCustomCategoryType>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DataDownLoader dialog = new DataDownLoader();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DataDownLoader() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton getActiveListingButton = new JButton("Get My Active Listing");
			getActiveListingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activeListItemID.clear();

					GetMyeBaySellingBean getMyeBaySellingBean = new GetMyeBaySellingBean();

					ItemListCustomizationType activeList = new ItemListCustomizationType();
					activeList.setInclude(true);
					activeList.setIncludeNotes(false);
					PaginationType page = new PaginationType();
					page.setEntriesPerPage(3);
					page.setPageNumber(1);
					activeList.setPagination(page);

					getMyeBaySellingBean.setHideVariations(false);
					getMyeBaySellingBean.setActiveList(activeList);
					getMyeBaySellingBean.setMyUserID(accountName);
					// bean.setMyUserID("onlyleaf520");

					class GetMyeBaySellingCallBackHandler extends CallBackHandler {

						@Override
						public void handle(Bean bean) {
							// TODO Auto-generated method stub
							GetMyeBaySellingBean b = (GetMyeBaySellingBean) bean;
							for (ItemType i : b.getReturnedActiveList().getItemArray().getItem()) {
								activeListItemID.add(i.getItemID());
							}
							if (b.getActiveList().getPagination().getPageNumber() < b.getReturnedActiveList().getPaginationResult().getTotalNumberOfPages()) {
								b.getActiveList().getPagination().setPageNumber(b.getActiveList().getPagination().getPageNumber() + 1);
								EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETMYEBAYSELLING, b, new GetMyeBaySellingCallBackHandler());
							} else {
								for (Object o : activeListItemID.toArray()) {
									// System.out.println(o.toString());
									GetItemBean getItemBean = new GetItemBean();
									getItemBean.setMyUserID(accountName);
									getItemBean.setItemID(o.toString());
									getItemBean.setIncludeItemSpecifics(true);
									getItemBean.setDetailLevel(new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL });
									EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETITEM, getItemBean, new CallBackHandler() {

										@Override
										public void handle(Bean bean) {
											// TODO Auto-generated method stub
											GetItemBean b = (GetItemBean) bean;
											ItemType newItem = b.getReturnedItem();
											newItem.setApplicationData(b.getMyUserID());
											ItemTypeTable itemTable = new ItemTypeTable();
											itemTable.insert(newItem);
											// item ID = 252068484297 test
											// listing
											if (b.getReturnedItem().getItemID().equals("252068484297"))
												System.out.println();

										}
									});
								}
							}
						}
					}

					EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETMYEBAYSELLING, getMyeBaySellingBean, new GetMyeBaySellingCallBackHandler());
				}
			});
			getActiveListingButton.setBounds(23, 208, 177, 23);
			contentPanel.add(getActiveListingButton);
			getActiveListingButton.setActionCommand("OK");
			getRootPane().setDefaultButton(getActiveListingButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(254, 208, 134, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JButton btnNewButton = new JButton("Test Item");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					GetItemBean getItemBean = new GetItemBean();
					getItemBean.setMyUserID(accountName);
					getItemBean.setItemID("252068484297");
					getItemBean.setIncludeItemSpecifics(true);
					getItemBean.setDetailLevel(new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL });
					EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETITEM, getItemBean, new CallBackHandler() {

						@Override
						public void handle(Bean bean) {
							// TODO Auto-generated method stub
							GetItemBean b = (GetItemBean) bean;
							ItemType newItem = b.getReturnedItem();
							newItem.setApplicationData(b.getMyUserID());
							ItemTypeTable itemTable = new ItemTypeTable();
							itemTable.insert(newItem);
							// item ID = 252068484297 test
							// listing
							if (b.getReturnedItem().getItemID().equals("252068484297"))
								System.out.println();
						}
					});
				}
			});
			btnNewButton.setBounds(23, 39, 177, 30);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("eBay Categories");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GetCategoriesBean getCategoriesBean = new GetCategoriesBean();
					getCategoriesBean.setMyUserID(accountName);
					getCategoriesBean.setViewAllNodes(true);
					getCategoriesBean.setCategorySiteID(SiteCodeType.AUSTRALIA);
					getCategoriesBean.setParentCategories(new String[] { "15032" });
					DetailLevelCodeType[] details = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
					getCategoriesBean.setDetailLevel(details);
					EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GetCategories, getCategoriesBean, new CallBackHandler() {

						@Override
						public void handle(Bean bean) {
							// TODO Auto-generated method stub
							GetCategoriesBean b = (GetCategoriesBean) bean;
							for (CategoryType c : b.getReturnedCategoryArray()) {
								System.out.println(c.getCategoryID() + "  :" + c.getCategoryName());
							}
							System.out.println();
						}
					});
				}
			});
			btnNewButton_1.setBounds(23, 81, 177, 30);
			contentPanel.add(btnNewButton_1);
		}

		JButton btnNewButton_2 = new JButton("Get Store Categories");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GetStoreBean getStoreBean = new GetStoreBean();
				getStoreBean.setMyUserID(accountName);
				getStoreBean.setCategoryStructureOnly(true);
				getStoreBean.setUserID(accountName);
				EbayClient.getInstance().StartEbayAPICall(EbayCallAction.ActionNames.GETSTORE, getStoreBean, new CallBackHandler() {

					@Override
					public void handle(Bean bean) {
						// TODO Auto-generated method stub
						GetStoreBean b = (GetStoreBean) bean;
						StoreCustomCategoryTable table = new StoreCustomCategoryTable();
						table.deleteAll();
						for (StoreCustomCategoryType c : b.getReturnedStoreType().getCustomCategories().getCustomCategory()) {
							getEndCategory(c);
						}

						for (int i = 0; i < storeCustomCategory.size(); i++) {
							// System.out.println(storeCustomCategory.get(i).getCategoryID()
							// + " :" + storeCustomCategory.get(i).getName());
							table.insert(storeCustomCategory.get(i));
						}
						System.out.println();
					}
				});
			}
		});
		btnNewButton_2.setBounds(22, 136, 178, 30);
		contentPanel.add(btnNewButton_2);
	}

	public void getEndCategory(StoreCustomCategoryType category) {

		if (category.getChildCategory().length == 0) {
			storeCustomCategory.add(category);
		} else {
			for (StoreCustomCategoryType sub : category.getChildCategory()) {
				sub.setName(category.getName() + "-" + sub.getName());
				getEndCategory(sub);
			}
		}
	}
}
