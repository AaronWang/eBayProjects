package UI.Listing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.helper.ConsoleUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
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
		if (true) {
			item.setVariations(buildVariationsType());
		} else {
			AmountType startPrice = new AmountType();
			startPrice.setCurrencyID(CurrencyCodeType.AUD);
			startPrice.setValue(10.0);
			item.setStartPrice(startPrice);
		}

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
//		input = ConsoleUtil.readString("Enter your Seller Policy Payment ProfileId : ");

		SellerPaymentProfileType sellerPaymentProfile = new SellerPaymentProfileType();
		sellerPaymentProfile.setPaymentProfileID(Long.valueOf(input));
		sellerProfile.setSellerPaymentProfile(sellerPaymentProfile);

		// Set Shipping ProfileId
		SellerShippingProfileType sellerShippingProfile = new SellerShippingProfileType();
//		input = ConsoleUtil.readString("Enter your Seller Policy Shipping ProfileId : ");
		sellerShippingProfile.setShippingProfileID(Long.valueOf(input));
		sellerProfile.setSellerShippingProfile(sellerShippingProfile);

		// Set Return Policy ProfileId
		SellerReturnProfileType sellerReturnProfile = new SellerReturnProfileType();
//		input = ConsoleUtil.readString("Enter your Seller Policy Return ProfileId : ");
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
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addGroup(
						gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(comboBox_1, Alignment.LEADING, 0, 290, Short.MAX_VALUE).addComponent(comboBox, 0, 290,
								Short.MAX_VALUE)).addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_1.createSequentialGroup().addContainerGap().addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fixed Price");

		JRadioButton rdbtnAuctionPrice = new JRadioButton("Auction Price");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblStartingPrice = new JLabel("Starting Price");

		JLabel lblBuyItNow = new JLabel("Buy it Now Price");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JLabel lblPrice = new JLabel("Price");

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Item Descriptions", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_2.createSequentialGroup().addContainerGap().addGroup(
						gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE).addGroup(
								gl_panel_2.createSequentialGroup().addComponent(lblTitle).addContainerGap(264, Short.MAX_VALUE)).addGroup(
								gl_panel_2.createSequentialGroup().addComponent(lblCondition).addContainerGap(234, Short.MAX_VALUE)).addComponent(comboBox_2, 0, 287,
								Short.MAX_VALUE).addGroup(
								gl_panel_2.createSequentialGroup().addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblDuration).addComponent(lblPhotos))
										.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
												gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(comboBox_3, 0, 222, Short.MAX_VALUE).addComponent(btnAddPhotos,
														GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)).addContainerGap()).addGroup(
								gl_panel_2.createSequentialGroup().addComponent(rdbtnNewRadioButton).addContainerGap(205, Short.MAX_VALUE)).addGroup(
								gl_panel_2.createSequentialGroup().addComponent(lblPrice).addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE).addContainerGap(25, Short.MAX_VALUE)).addGroup(
								gl_panel_2.createSequentialGroup().addGroup(
										gl_panel_2.createParallelGroup(Alignment.TRAILING, false).addGroup(
												Alignment.LEADING,
												gl_panel_2.createSequentialGroup().addComponent(rdbtnAuctionPrice).addPreferredGap(ComponentPlacement.RELATED, 169,
														GroupLayout.PREFERRED_SIZE)).addGroup(
												Alignment.LEADING,
												gl_panel_2.createSequentialGroup().addGroup(
														gl_panel_2.createParallelGroup(Alignment.TRAILING, false).addComponent(lblStartingPrice, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(textField_1, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18).addGroup(
														gl_panel_2.createParallelGroup(Alignment.LEADING, false).addComponent(lblBuyItNow, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))).addContainerGap(25, Short.MAX_VALUE)))));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_2.createSequentialGroup().addGap(18).addComponent(lblTitle).addPreferredGap(ComponentPlacement.RELATED).addComponent(textField,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(lblCondition)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(btnAddPhotos).addComponent(lblPhotos)).addGap(42).addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblDuration).addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(27).addComponent(rdbtnNewRadioButton).addPreferredGap(
								ComponentPlacement.RELATED).addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).addComponent(lblPrice)).addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE).addComponent(
								rdbtnAuctionPrice).addPreferredGap(ComponentPlacement.RELATED).addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(lblStartingPrice).addComponent(lblBuyItNow)).addPreferredGap(
								ComponentPlacement.RELATED).addGroup(
								gl_panel_2.createParallelGroup(Alignment.BASELINE).addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE).addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(15)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Business Policies", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblNewLabel = new JLabel("New label");

		comboBox_4 = new JComboBox();

		JLabel lblNewLabel_1 = new JLabel("New label");

		JLabel lblNewLabel_2 = new JLabel("New label");

		comboBox_5 = new JComboBox();

		comboBox_6 = new JComboBox();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_3.createSequentialGroup().addContainerGap().addGroup(
						gl_panel_3.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel).addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)).addPreferredGap(
						ComponentPlacement.RELATED, 99, Short.MAX_VALUE).addGroup(
						gl_panel_3.createParallelGroup(Alignment.LEADING, false).addComponent(comboBox_6, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(comboBox_5, 0,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(comboBox_4, 0, 356, Short.MAX_VALUE)).addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_3.createSequentialGroup().addContainerGap().addGroup(
						gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)).addGap(18).addGroup(
						gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18).addGroup(
						gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addContainerGap(33, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addGroup(
						groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
								groupLayout.createSequentialGroup().addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(
										239).addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(123)).addGroup(
								Alignment.TRAILING,
								groupLayout.createSequentialGroup().addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE).addComponent(btnConfirm).addGap(115)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE).addGap(324).addComponent(
						panel_3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE).addGap(15)).addGroup(
				Alignment.TRAILING,
				groupLayout.createSequentialGroup().addGap(14).addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE).addGap(111).addComponent(btnConfirm)
						.addGap(77)));
		setLayout(groupLayout);
	}

}
