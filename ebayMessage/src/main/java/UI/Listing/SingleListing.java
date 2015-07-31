package UI.Listing;

import handler.future.CallBackHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import modules.StorageBox;
import IO.ItemType.ItemReadWrite;
import actor.Actor;
import actor.ActorAssembler;
import bean.Bean;
import bean.callBean.GetItemBean;
import bean.callBean.GetMyeBaySellingBean;
import bean.callBean.GetStoreBean;

import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.SellerPaymentProfileType;
import com.ebay.soap.eBLBaseComponents.SellerProfilesType;
import com.ebay.soap.eBLBaseComponents.SellerReturnProfileType;
import com.ebay.soap.eBLBaseComponents.SellerShippingProfileType;
import com.ebay.soap.eBLBaseComponents.VariationType;
import com.ebay.soap.eBLBaseComponents.VariationsType;

import core.Module;
import ebayApiCall.EbayCallAction;
import ebayClient.EbayClient;

public class SingleListing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private ItemType item = new ItemType();

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JComboBox comboBox_5;
	private JComboBox comboBox_6;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblNewLabel_3;

	public void updateValue(ItemType updateItem) {
		item = updateItem;
		item.setTitle("");
		item.setDescription("");
		item.setListingType(ListingTypeCodeType.FIXED_PRICE_ITEM);
		item.setCurrency(CurrencyCodeType.AUD);
		item.setListingDuration(ListingDurationCodeType.DAYS_5.value());

		// item location and country
		item.setLocation("Murrumbeena, Victoria");
		item.setCountry(CountryCodeType.AU);
		item.setPostalCode("3163");

		// listing category
		CategoryType cat = new CategoryType();
		String catID = "12542151";
		cat.setCategoryID(catID);
		item.setPrimaryCategory(cat);
		// item.setSecondaryCategory(cat);

		// item condition, New
		item.setConditionID(1000);

		// item variations
		// if (true) {
		// item.setVariations(buildVariationsType());
		// } else {
		// AmountType startPrice = new AmountType();
		// startPrice.setCurrencyID(CurrencyCodeType.AUD);
		// startPrice.setValue(10.0);
		// item.setStartPrice(startPrice);
		// }

		/*
		 * The Business Policies API and related Trading API fields are
		 * available in sandbox. It will be available in production for a
		 * limited number of sellers with Version 775. 100 percent of sellers
		 * will be ramped up to use Business Polcies in July 2012
		 */

		// Create Seller Profile container
		SellerProfilesType sellerProfile = new SellerProfilesType();

		// Set payment ProfileId
		String input = "";
		// input =
		// ConsoleUtil.readString("Enter your Seller Policy Payment ProfileId : ");

		SellerPaymentProfileType sellerPaymentProfile = new SellerPaymentProfileType();
		sellerPaymentProfile.setPaymentProfileID(Long.valueOf(input));
		sellerProfile.setSellerPaymentProfile(sellerPaymentProfile);

		// Set Shipping ProfileId
		SellerShippingProfileType sellerShippingProfile = new SellerShippingProfileType();
		// input =
		// ConsoleUtil.readString("Enter your Seller Policy Shipping ProfileId : ");
		sellerShippingProfile.setShippingProfileID(Long.valueOf(input));
		sellerProfile.setSellerShippingProfile(sellerShippingProfile);

		// Set Return Policy ProfileId
		SellerReturnProfileType sellerReturnProfile = new SellerReturnProfileType();
		// input =
		// ConsoleUtil.readString("Enter your Seller Policy Return ProfileId : ");
		sellerReturnProfile.setReturnProfileID(Long.valueOf(input));
		sellerProfile.setSellerReturnProfile(sellerReturnProfile);

		// Add Seller Profile to Item
		item.setSellerProfiles(sellerProfile);
	}

	public VariationsType buildVariationsType() {
		// listing variations
		VariationsType variations = new VariationsType();

		// first variation
		VariationType variation1 = new VariationType();
		// create the content of VariationSpecifics
		NameValueListArrayType nvArray1 = new NameValueListArrayType();
		NameValueListType nv11 = new NameValueListType();
		nv11.setName("Color");
		nv11.setValue(new String[] { "RED" });
		NameValueListType nv12 = new NameValueListType();
		nv12.setName("Size");
		nv12.setValue(new String[] { "M" });
		nvArray1.setNameValueList(new NameValueListType[] { nv11, nv12 });
		// set variation-level specifics for first variation
		variation1.setVariationSpecifics(nvArray1);
		// set start price
		AmountType amount1 = new AmountType();
		amount1.setValue(Double.valueOf(100));
		variation1.setStartPrice(amount1);
		// set quantity
		variation1.setQuantity(new Integer(10));
		// set variation name
		variation1.setVariationTitle("RED,M");

		// second variation
		VariationType variation2 = new VariationType();
		// create the content of specifics for each variation
		NameValueListArrayType nvArray2 = new NameValueListArrayType();
		NameValueListType nv21 = new NameValueListType();
		nv21.setName("Color");
		nv21.setValue(new String[] { "BLACK" });
		NameValueListType nv22 = new NameValueListType();
		nv22.setName("Size");
		nv22.setValue(new String[] { "L" });
		nvArray2.setNameValueList(new NameValueListType[] { nv21, nv22 });
		// set variation-level specifics for first variation
		variation2.setVariationSpecifics(nvArray2);
		// set start price
		AmountType amount2 = new AmountType();
		amount2.setValue(Double.valueOf(110));
		variation2.setStartPrice(amount2);
		// set quantity
		variation2.setQuantity(new Integer(20));
		// set variation name
		variation2.setVariationTitle("BLACK,L");

		// set variation
		variations.setVariation(new VariationType[] { variation1, variation2 });

		// create the content of specifics for variations
		NameValueListArrayType nvArray3 = new NameValueListArrayType();
		NameValueListType nv31 = new NameValueListType();
		nv31.setName("Color");
		nv31.setValue(new String[] { "BLACK", "RED" });
		NameValueListType nv32 = new NameValueListType();
		nv32.setName("Size");
		nv32.setValue(new String[] { "M", "L" });
		nvArray3.setNameValueList(new NameValueListType[] { nv31, nv32 });

		// set variationSpecifics
		variations.setVariationSpecificsSet(nvArray3);
		return variations;
	}

	public SingleListing() {

		comboBox = new JComboBox();

		comboBox_1 = new JComboBox();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Categories where your listing will appear", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_panel_1
						.createSequentialGroup()
						.addGroup(
								gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(comboBox_1, 0, 290, Short.MAX_VALUE)
										.addComponent(comboBox, Alignment.TRAILING, 0, 290, Short.MAX_VALUE)).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_1.createSequentialGroup().addContainerGap().addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(171, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblTitle = new JLabel("Title");

		JLabel lblCondition = new JLabel("Condition");

		comboBox_2 = new JComboBox();

		JLabel lblPhotos = new JLabel("Photos");

		JButton btnAddPhotos = new JButton("add photos");

		JLabel lblDuration = new JLabel("Duration");

		comboBox_3 = new JComboBox();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Item Descriptions", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		JLabel lblUcp = new JLabel("UPC");

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel lblFeatures = new JLabel("Features");

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JLabel lblCompatible = new JLabel("Compatible Brand");

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		JLabel lblCompatibleModel = new JLabel("Compatible Model");

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel_2.createSequentialGroup().addGap(10).addComponent(lblDuration, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(comboBox_3, 0, 392, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(lblCondition).addContainerGap(416, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(lblTitle).addContainerGap(441, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap(10, Short.MAX_VALUE).addComponent(textField, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
				.addGroup(
						gl_panel_2.createSequentialGroup().addGap(10).addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
				.addGroup(
						Alignment.LEADING,
						gl_panel_2.createSequentialGroup().addContainerGap().addComponent(lblCompatibleModel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(212, Short.MAX_VALUE))
				.addGroup(
						gl_panel_2
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel_2
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(comboBox_2, Alignment.LEADING, 0, 249, Short.MAX_VALUE)
												.addGroup(
														gl_panel_2
																.createSequentialGroup()
																.addGroup(
																		gl_panel_2.createParallelGroup(Alignment.LEADING, false)
																				.addComponent(lblCompatible, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(lblPhotos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(lblUcp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(lblFeatures, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(
																		gl_panel_2.createParallelGroup(Alignment.LEADING)
																				.addComponent(btnAddPhotos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
																				.addComponent(textField_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
																				.addComponent(textField_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
																				.addComponent(textField_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
								.addGap(212)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addGap(18)
						.addComponent(lblTitle)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblCondition)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(btnAddPhotos).addComponent(lblPhotos))
						.addGap(18)
						.addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblUcp)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblFeatures)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblCompatible)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblCompatibleModel)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblDuration)
										.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(17)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Fixed Price", null, panel, null);
		panel.setLayout(null);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(23, 28, 76, 14);
		panel.add(lblPrice);

		textField_3 = new JTextField();
		textField_3.setBounds(136, 25, 168, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Auction Price", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblBuyItNow = new JLabel("Buy it Now Price");
		lblBuyItNow.setBounds(195, 11, 134, 14);
		panel_4.add(lblBuyItNow);

		textField_2 = new JTextField();
		textField_2.setBounds(195, 31, 134, 20);
		panel_4.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblStartingPrice = new JLabel("Starting Price");
		lblStartingPrice.setBounds(57, 11, 86, 14);
		panel_4.add(lblStartingPrice);

		textField_1 = new JTextField();
		textField_1.setBounds(57, 31, 86, 20);
		panel_4.add(textField_1);
		textField_1.setColumns(10);

		panel_2.setLayout(gl_panel_2);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Business Policies", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblNewLabel = new JLabel("Payment Policy");

		comboBox_4 = new JComboBox();

		JLabel lblNewLabel_1 = new JLabel("Postage Policy");

		JLabel lblNewLabel_2 = new JLabel("Return Policy");

		comboBox_5 = new JComboBox();

		comboBox_6 = new JComboBox();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel_3.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								gl_panel_3.createParallelGroup(Alignment.LEADING, false).addComponent(comboBox_4, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBox_6, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(comboBox_5, 0, 262, Short.MAX_VALUE))
						.addContainerGap(104, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
										.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
										.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
										.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(35, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JComboBox comboBox_7 = new JComboBox();

		lblNewLabel_3 = new JLabel("Create a new listing");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAccount = new JLabel("Account");

		JButton btnGetMySelling = new JButton("Get My Selling");
		btnGetMySelling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GetMyeBaySellingBean bean = new GetMyeBaySellingBean();
				ItemListCustomizationType activeList = new ItemListCustomizationType();
				activeList.setInclude(true);
				activeList.setIncludeNotes(true);

				bean.setHideVariations(false);
				bean.setActiveList(activeList);
				bean.setMyUserID("aaroncollection2015");
				// bean.setMyUserID("onlyleaf520");
				Actor actor = ((ActorAssembler) EbayClient.getInstance().getModule(Module.Type.ACTORASSEMBLER)).createSingleEbayCallActionActor(
						EbayCallAction.ActionNames.GETMYEBAYSELLING, bean, new CallBackHandler() {
							@Override
							public void handle(Bean bean) {
								// TODO Auto-generated method stub
								GetMyeBaySellingBean b = (GetMyeBaySellingBean) bean;

								((StorageBox) ((EbayClient) systemContext).getModule(Module.Type.STORAGEBOX)).setBean("login", bean);
							}
						});

				EbayClient.getInstance().pushActor(actor);

			}
		});

		JButton btnGetItem = new JButton("Get Item");
		btnGetItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GetItemBean bean = new GetItemBean();
				bean.setItemID("252014256572");
				bean.setIncludeItemSpecifics(true);
				bean.setMyUserID("aaroncollection2015");
				Actor actor = ((ActorAssembler) EbayClient.getInstance().getModule(Module.Type.ACTORASSEMBLER)).createSingleEbayCallActionActor(EbayCallAction.ActionNames.GETITEM,
						bean, new CallBackHandler() {
							@Override
							public void handle(Bean bean) {
								// TODO Auto-generated method stub
								GetItemBean b = (GetItemBean) bean;

								((StorageBox) ((EbayClient) systemContext).getModule(Module.Type.STORAGEBOX)).setBean("login", bean);
							}
						});

				EbayClient.getInstance().pushActor(actor);
			}
		});

		JButton btnGetstore = new JButton("GetStore");
		btnGetstore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GetStoreBean bean = new GetStoreBean();
				// bean.setCategoryStructureOnly(false);
				// bean.setRootCategoryID((long) 0);
				// bean.setLevelLimit(0);
				// bean.setUserID("aaroncollection2015");
				bean.setMyUserID("aaroncollection2015");
				Actor actor = ((ActorAssembler) EbayClient.getInstance().getModule(Module.Type.ACTORASSEMBLER)).createSingleEbayCallActionActor(
						EbayCallAction.ActionNames.GETSTORE, bean, new CallBackHandler() {
							@Override
							public void handle(Bean bean) {
								// TODO Auto-generated method stub
								GetStoreBean b = (GetStoreBean) bean;

								((StorageBox) ((EbayClient) systemContext).getModule(Module.Type.STORAGEBOX)).setBean("login", bean);
							}
						});

				EbayClient.getInstance().pushActor(actor);

			}
		});

		JButton btnGetprofles = new JButton("GetProfles");
		btnGetprofles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService service = new com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService();
				com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort port = service.getSellerProfilesManagementServiceSOAPPort();
				com.ebay.marketplace.selling.v1.services.GetSellerProfilesRequest params = new com.ebay.marketplace.selling.v1.services.GetSellerProfilesRequest();
				String token = "AgAAAA**AQAAAA**aAAAAA**5S+JVQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AHl4eoAJSApw+dj6x9nY+seQ**44YCAA**AAMAAA**bsbgf2dlnMfZsCeklbkTP9Krp7Jia56BUhpo3K40o1d2fa/drZdtRLVCyM97/R83xGPZwkhhLx4Y79whLPUuHZcYgv48+Nw6YOnrVvI86lqdspmQa+g3P7GNL+mc+tBkBl/UusR/OpQSOie9ANWocRZJmO0kKI6j9ZPiZuRw4oLjv/L6jY8WCdDMnqxPSjAYWjWR82qfEcOJF4Fh1YfJK+/Xsu3ZRVLzE3OZdbsN4Jj0oL8sezjRLUNlmgxtFkaD3JNHULQu/LuzrgnJAX7pl/CN3Pk7DOYy6n9nFtm9iWDZQ4o/3wK2lR8jUYbk4OBTcaRr8aCrwn0xGmqGOWASv1AH+J+td2PdA2Hobi+KdBnYHlZtFdWjg2WHx2wGmQ7ByHq3C8KeufCnHpn6YGaZjMJGh32jMeetxjsjMNYLQjCALFKwgzMNUVM4xT/nyvykyAmyf63DLOWxBj5Jdz3xiRAW4y62Xo6ZdpzunmCm4faFO2SvrA8pk2hL/NeFv6ZCv23BuG+IOU3Uk8JtRrsBYoaH3qN4Zux1m66YT8YViFYKuct6HZje645DD2iYV9ZT6bDNWmfkUFmVIJ/QgmKDflHEd31dTjwFyNPNPToBcULgocvMeX3uAs8f6Y2Y1HyM9jQk/WznvHcBqPxzxSmBt2OS4Fzoe2Nb8qQS+NgxwhpQensJt9j4BB7F49qnYDuVDQV4xurJI9kMNzlYQvK35KuFLd8NMompnRqUmVoZr8tSPJplUolPmeNgRKqDiG38";
				BindingProvider bp = (BindingProvider) port;
				Map<String, List<String>> requestHeaders = new HashMap<>();
				requestHeaders.put("X-EBAY-SOA-OPERATION-NAME", Arrays.asList("getSellerProfiles"));
				requestHeaders.put("X-EBAY-SOA-SECURITY-TOKEN", Arrays.asList(token));
				requestHeaders.put("X-EBAY-SOA-GLOBAL-ID", Arrays.asList("EBAY-AU"));

				bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);

				bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://svcs.ebay.com/services/selling/v1/SellerProfilesManagementService");
				// TODO process result here
				params.setIncludeDetails(Boolean.TRUE);
				com.ebay.marketplace.selling.v1.services.GetSellerProfilesResponse result = port.getSellerProfiles(params);
				ItemReadWrite itemreadwrite = new ItemReadWrite();
				itemreadwrite.WriteProfiles(result);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addGroup(
																groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(
																				groupLayout.createSequentialGroup()
																						.addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
																						.addGap(86)
																						.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
																		.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(
																groupLayout
																		.createParallelGroup(Alignment.LEADING, false)
																		.addGroup(
																				groupLayout
																						.createSequentialGroup()
																						.addGap(51)
																						.addGroup(
																								groupLayout
																										.createParallelGroup(Alignment.LEADING, false)
																										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 357,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 414,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGroup(
																				groupLayout
																						.createSequentialGroup()
																						.addGroup(
																								groupLayout
																										.createParallelGroup(Alignment.LEADING)
																										.addGroup(
																												groupLayout.createSequentialGroup().addGap(179)
																														.addComponent(btnConfirm).addGap(40))
																										.addGroup(
																												Alignment.TRAILING,
																												groupLayout.createSequentialGroup().addComponent(btnGetprofles)
																														.addGap(29)))
																						.addGroup(
																								groupLayout
																										.createParallelGroup(Alignment.LEADING)
																										.addComponent(btnGetItem)
																										.addComponent(btnGetMySelling, GroupLayout.PREFERRED_SIZE, 123,
																												GroupLayout.PREFERRED_SIZE).addComponent(btnGetstore)))))
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)).addContainerGap(130, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(14)
						.addComponent(lblNewLabel_3)
						.addGap(18)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(lblAccount))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE).addGap(18)
														.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE).addGap(79)
														.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnConfirm).addComponent(btnGetMySelling))
														.addGap(27).addComponent(btnGetItem).addGap(18)
														.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnGetstore).addComponent(btnGetprofles)))
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)).addGap(394)));
		setLayout(groupLayout);
	}
}
