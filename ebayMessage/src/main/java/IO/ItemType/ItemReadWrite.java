package IO.ItemType;

import java.util.ArrayList;
import java.util.LinkedList;

import IO.Excel.CellDetails;

import com.ebay.marketplace.selling.v1.services.GetSellerProfilesResponse;
import com.ebay.marketplace.selling.v1.services.PaymentProfile;
import com.ebay.marketplace.selling.v1.services.ReturnPolicyProfile;
import com.ebay.marketplace.selling.v1.services.ShippingPolicyProfile;
import com.ebay.sdk.helper.ConsoleUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.SellerPaymentProfileType;
import com.ebay.soap.eBLBaseComponents.SellerProfilesType;
import com.ebay.soap.eBLBaseComponents.SellerReturnProfileType;
import com.ebay.soap.eBLBaseComponents.SellerShippingProfileType;
import com.ebay.soap.eBLBaseComponents.StorefrontType;
import com.ebay.soap.eBLBaseComponents.VariationType;
import com.ebay.soap.eBLBaseComponents.VariationsType;

public class ItemReadWrite {
	CellDetails itemTypeDetails;
	CellDetails variationDetails;
	CellDetails modelDetails;
	CellDetails colorDetails;
	CellDetails packDetails;
	CellDetails patternDetails;
	CellDetails storeCategoryDetails;
	CellDetails profilesDetails;
	String fileName = "ItemType.xlsx";

	ItemType item;
	LinkedList<ItemType> itemList;
	ArrayList<VariationsType> variationsList;
	// NameValueListArrayType nvList;
	NameValueList modelA;
	NameValueList modelD;
	NameValueList modelG;
	NameValueList modelJ;
	NameValueList modelM;
	NameValueList modelP;
	NameValueList modelS;
	NameValueList modelV;
	NameValueList colorList;
	NameValueList packList;
	NameValueList patternList;

	// NameValueListType;

	public static void main(String[] args) {
		ItemReadWrite itemReadWrite = new ItemReadWrite();
	}

	public ItemReadWrite() {
		itemList = new LinkedList<ItemType>();
		variationsList = new ArrayList<VariationsType>();
		// nvList = new NameValueListArrayType();
		// sellerProfles = new GetSellerProfilesResponse();

		itemTypeDetails = new CellDetails();
		variationDetails = new CellDetails();
		modelDetails = new CellDetails();
		colorDetails = new CellDetails();
		packDetails = new CellDetails();
		patternDetails = new CellDetails();
		storeCategoryDetails = new CellDetails();
		profilesDetails = new CellDetails();

		itemTypeDetails.openFile(fileName, 0);
		variationDetails.openFile(fileName, 1);
		modelDetails.openFile(fileName, 2);
		colorDetails.openFile(fileName, 3);
		packDetails.openFile(fileName, 4);
		patternDetails.openFile(fileName, 5);
		storeCategoryDetails.openFile(fileName, 6);
		profilesDetails.openFile(fileName, 7);

		LoadNameValueList();
		LoadVariations();
		ReadItems();
	}

	public void ReadItems() {
		itemList.clear();
		int row = itemTypeDetails.getRowNumber();
		for (int i = 1; i < row; i++) {
			item = new ItemType();
			item.setApplicationData(itemTypeDetails.getCellDetails(i, 0));
			item.setItemID(itemTypeDetails.getCellDetails(i, 1));
			item.setTitle(itemTypeDetails.getCellDetails(i, 2));

			StorefrontType storeFrontType = new StorefrontType();
			if (itemTypeDetails.getCellDetails(i, 3) != "")
				storeFrontType.setStoreCategoryID(Long.valueOf(itemTypeDetails.getCellDetails(i, 3)));
			else
				storeFrontType.setStoreCategoryID(0);
			item.setStorefront(storeFrontType);

			CategoryType categoryType = new CategoryType();
			categoryType.setCategoryID(itemTypeDetails.getCellDetails(i, 4));
			item.setPrimaryCategory(categoryType);

			AmountType amountType = new AmountType();
			amountType.setCurrencyID(CurrencyCodeType.AUD);

			if (itemTypeDetails.getCellDetails(i, 5) != "")
				amountType.setValue(Double.valueOf(itemTypeDetails.getCellDetails(i, 5)));
			else
				amountType.setValue(0.0d);
			item.setBuyItNowPrice(amountType);

			item.setListingDuration(itemTypeDetails.getCellDetails(i, 6));

			if (itemTypeDetails.getCellDetails(i, 7) != "")
				item.setListingType(ListingTypeCodeType.fromValue(itemTypeDetails.getCellDetails(i, 7)));
			else
				item.setListingType(ListingTypeCodeType.fromValue("FixedPriceItem"));
			item.setDescription(itemTypeDetails.getCellDetails(i, 8));

			// seller profiles
			// Create Seller Profile container
			SellerProfilesType sellerProfile = new SellerProfilesType();

			// Set payment ProfileId
			SellerPaymentProfileType sellerPaymentProfile = new SellerPaymentProfileType();
			sellerPaymentProfile.setPaymentProfileID(Long.valueOf(itemTypeDetails.getCellDetails(i, 9)));
			sellerProfile.setSellerPaymentProfile(sellerPaymentProfile);

			// Set Shipping ProfileId
			SellerShippingProfileType sellerShippingProfile = new SellerShippingProfileType();
			sellerShippingProfile.setShippingProfileID(Long.valueOf(itemTypeDetails.getCellDetails(i, 10)));
			sellerProfile.setSellerShippingProfile(sellerShippingProfile);

			// Set Return Policy ProfileId
			SellerReturnProfileType sellerReturnProfile = new SellerReturnProfileType();
			sellerReturnProfile.setReturnProfileID(Long.valueOf(itemTypeDetails.getCellDetails(i, 11)));
			sellerProfile.setSellerReturnProfile(sellerReturnProfile);

			// Add Seller Profile to Item
			item.setSellerProfiles(sellerProfile);

			item.setSKU(itemTypeDetails.getCellDetails(i, 12));
			item.setVariations(variationsList.get(Integer.valueOf(itemTypeDetails.getCellDetails(i, 13))));

			item.setLocation("Murrumbeena, Victoria");
			item.setCountry(CountryCodeType.AU);

			itemList.add(item);
		}
	}

	public void WriteItmes() {
	}

	public void LoadNameValueList() {

		modelA = new NameValueList();
		modelD = new NameValueList();
		modelG = new NameValueList();
		modelJ = new NameValueList();
		modelM = new NameValueList();
		modelP = new NameValueList();
		modelS = new NameValueList();
		modelV = new NameValueList();
		colorList = new NameValueList();
		packList = new NameValueList();
		patternList = new NameValueList();

		modelA.setName("Model");
		modelD.setName("Model");
		modelG.setName("Model");
		modelJ.setName("Model");
		modelM.setName("Model");
		modelP.setName("Model");
		modelS.setName("Model");
		modelV.setName("Model");

		int row = modelDetails.getRowNumber();

		for (int i = 1; i < row; i++) {
			NameValue namevalue = new NameValue();

			namevalue.id = modelDetails.getCellDetails(i, 0);
			namevalue.value = modelDetails.getCellDetails(i, 1);
			namevalue.sku = modelDetails.getCellDetails(i, 2);
			modelA.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 3);
			namevalue.value = modelDetails.getCellDetails(i, 4);
			namevalue.sku = modelDetails.getCellDetails(i, 5);
			modelD.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 6);
			namevalue.value = modelDetails.getCellDetails(i, 7);
			namevalue.sku = modelDetails.getCellDetails(i, 8);
			modelG.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 9);
			namevalue.value = modelDetails.getCellDetails(i, 10);
			namevalue.sku = modelDetails.getCellDetails(i, 11);
			modelJ.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 12);
			namevalue.value = modelDetails.getCellDetails(i, 13);
			namevalue.sku = modelDetails.getCellDetails(i, 14);
			modelM.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 15);
			namevalue.value = modelDetails.getCellDetails(i, 16);
			namevalue.sku = modelDetails.getCellDetails(i, 17);
			modelP.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 18);
			namevalue.value = modelDetails.getCellDetails(i, 19);
			namevalue.sku = modelDetails.getCellDetails(i, 20);
			modelS.getValues().add(namevalue);

			namevalue = new NameValue();
			namevalue.id = modelDetails.getCellDetails(i, 21);
			namevalue.value = modelDetails.getCellDetails(i, 22);
			namevalue.sku = modelDetails.getCellDetails(i, 23);
			modelV.getValues().add(namevalue);
		}

		row = colorDetails.getRowNumber();
		for (int i = 1; i < row; i++) {
			NameValue namevalue = new NameValue();
			namevalue.id = colorDetails.getCellDetails(i, 0);
			namevalue.value = colorDetails.getCellDetails(i, 1);
			namevalue.sku = colorDetails.getCellDetails(i, 2);
			colorList.getValues().add(namevalue);
		}
		row = packDetails.getRowNumber();
		for (int i = 1; i < row; i++) {
			NameValue namevalue = new NameValue();
			namevalue.id = packDetails.getCellDetails(i, 0);
			namevalue.value = packDetails.getCellDetails(i, 1);
			namevalue.sku = packDetails.getCellDetails(i, 2);
			packList.getValues().add(namevalue);
		}
		row = patternDetails.getRowNumber();
		for (int i = 1; i < row; i++) {
			NameValue namevalue = new NameValue();
			namevalue.id = patternDetails.getCellDetails(i, 0);
			namevalue.value = patternDetails.getCellDetails(i, 1);
			namevalue.sku = patternDetails.getCellDetails(i, 2);
			patternList.getValues().add(namevalue);
		}
	}

	public void LoadVariations() {
		int row = variationDetails.getRowNumber();
		VariationsType variationsType;
		for (int i = 1; i < row; i++) {
			variationsType = new VariationsType();
			String model = variationDetails.getCellDetails(i, 1);
			String color = variationDetails.getCellDetails(i, 2);
			String pack = variationDetails.getCellDetails(i, 3);
			String pattern = variationDetails.getCellDetails(i, 4);

			NameValueListArrayType nvListArrayTMP = new NameValueListArrayType();
			NameValueListType nvListTMP = null;
			ArrayList<NameValueListType> nvListTempArray = new ArrayList<NameValueListType>();
			if (model != "") {
				nvListTMP = new NameValueListType();
				nvListTMP.setName("Model");
				char firstChar;
				firstChar = model.charAt(0);
				model = model.substring(1);

				switch (firstChar) {
				case 'A':
					nvListTMP.setValue(modelA.getValueList(model));
					break;
				case 'D':
					nvListTMP.setValue(modelD.getValueList(model));
					break;
				case 'G':
					nvListTMP.setValue(modelG.getValueList(model));
					break;
				case 'J':
					nvListTMP.setValue(modelJ.getValueList(model));
					break;
				case 'M':
					nvListTMP.setValue(modelM.getValueList(model));
					break;
				case 'P':
					nvListTMP.setValue(modelP.getValueList(model));
					break;
				case 'S':
					nvListTMP.setValue(modelS.getValueList(model));
					break;
				case 'V':
					nvListTMP.setValue(modelV.getValueList(model));
					break;
				default:
					break;
				}
				// nvList;
				nvListTempArray.add(nvListTMP);
			}
			if (color != "") {
				nvListTMP = new NameValueListType();
				nvListTMP.setName("Color");
				nvListTMP.setValue(colorList.getValueList(color));
				// nvList;
				nvListTempArray.add(nvListTMP);
			}
			if (pack != "") {
				nvListTMP = new NameValueListType();
				nvListTMP.setName("Pack");
				nvListTMP.setValue(packList.getValueList(color));
				// nvList;
				nvListTempArray.add(nvListTMP);
			}
			if (pattern != "") {
				nvListTMP = new NameValueListType();
				nvListTMP.setName("Pattern");
				nvListTMP.setValue(patternList.getValueList(color));
				// nvList;
				nvListTempArray.add(nvListTMP);
			}
			nvListArrayTMP.setNameValueList(nvListTempArray.toArray(new NameValueListType[nvListTempArray.size()]));
			variationsType.setVariationSpecificsSet(nvListArrayTMP);

			ArrayList<VariationType> allVriationlist = new ArrayList<VariationType>();
			VariationType oneVariation;
			NameValueListArrayType nvArray1;
			NameValueListType nv1;
			NameValueListType nv2;
			NameValueListType nv3;
			NameValueListType nv4;
			NameValueListType nv5;

			if (nvListArrayTMP.getNameValueListLength() > 0) {
				for (String s0 : nvListArrayTMP.getNameValueList(0).getValue()) {
					String s00 = nvListArrayTMP.getNameValueList(0).getName();
					if (nvListArrayTMP.getNameValueListLength() > 1) {
						for (String s1 : nvListArrayTMP.getNameValueList(1).getValue()) {
							String s11 = nvListArrayTMP.getNameValueList(1).getName();
							if (nvListArrayTMP.getNameValueListLength() > 2) {
								for (String s2 : nvListArrayTMP.getNameValueList(2).getValue()) {
									String s22 = nvListArrayTMP.getNameValueList(2).getName();
									if (nvListArrayTMP.getNameValueListLength() > 3) {
										for (String s3 : nvListArrayTMP.getNameValueList(3).getValue()) {
											String s33 = nvListArrayTMP.getNameValueList(3).getName();
											if (nvListArrayTMP.getNameValueListLength() > 4) {
												for (String s4 : nvListArrayTMP.getNameValueList(4).getValue()) {
													String s44 = nvListArrayTMP.getNameValueList(4).getName();

													nv1 = new NameValueListType();
													nv1.setName(s00);
													nv1.setValue(new String[] { s0 });

													nv2 = new NameValueListType();
													nv2.setName(s11);
													nv2.setValue(new String[] { s1 });

													nv3 = new NameValueListType();
													nv3.setName(s22);
													nv3.setValue(new String[] { s2 });

													nv4 = new NameValueListType();
													nv4.setName(s33);
													nv4.setValue(new String[] { s3 });

													nv5 = new NameValueListType();
													nv5.setName(s44);
													nv5.setValue(new String[] { s4 });

													nvArray1 = new NameValueListArrayType();
													nvArray1.setNameValueList(new NameValueListType[] { nv1, nv2, nv3, nv4, nv5 });
													oneVariation = new VariationType();
													oneVariation.setVariationSpecifics(nvArray1);
													allVriationlist.add(oneVariation);
												}
											} else {
												nv1 = new NameValueListType();
												nv1.setName(s00);
												nv1.setValue(new String[] { s0 });

												nv2 = new NameValueListType();
												nv2.setName(s11);
												nv2.setValue(new String[] { s1 });

												nv3 = new NameValueListType();
												nv3.setName(s22);
												nv3.setValue(new String[] { s2 });

												nv4 = new NameValueListType();
												nv4.setName(s33);
												nv4.setValue(new String[] { s3 });

												nvArray1 = new NameValueListArrayType();
												nvArray1.setNameValueList(new NameValueListType[] { nv1, nv2, nv3, nv4 });
												oneVariation = new VariationType();
												oneVariation.setVariationSpecifics(nvArray1);
												allVriationlist.add(oneVariation);
											}
										}
									} else {
										nv1 = new NameValueListType();
										nv1.setName(s00);
										nv1.setValue(new String[] { s0 });

										nv2 = new NameValueListType();
										nv2.setName(s11);
										nv2.setValue(new String[] { s1 });

										nv3 = new NameValueListType();
										nv3.setName(s22);
										nv3.setValue(new String[] { s2 });

										nvArray1 = new NameValueListArrayType();
										nvArray1.setNameValueList(new NameValueListType[] { nv1, nv2, nv3 });
										oneVariation = new VariationType();
										oneVariation.setVariationSpecifics(nvArray1);
										allVriationlist.add(oneVariation);
									}
								}
							} else {
								nv1 = new NameValueListType();
								nv1.setName(s00);
								nv1.setValue(new String[] { s0 });

								nv2 = new NameValueListType();
								nv2.setName(s11);
								nv2.setValue(new String[] { s1 });

								nvArray1 = new NameValueListArrayType();
								nvArray1.setNameValueList(new NameValueListType[] { nv1, nv2 });
								oneVariation = new VariationType();
								oneVariation.setVariationSpecifics(nvArray1);
								allVriationlist.add(oneVariation);
							}
						}
					} else {
						nv1 = new NameValueListType();
						nv1.setName(s00);
						nv1.setValue(new String[] { s0 });

						nvArray1 = new NameValueListArrayType();
						nvArray1.setNameValueList(new NameValueListType[] { nv1 });
						oneVariation = new VariationType();
						oneVariation.setVariationSpecifics(nvArray1);
						allVriationlist.add(oneVariation);
					}
				}
			}

			variationsType.setVariation(allVriationlist.toArray(new VariationType[allVriationlist.size()]));
			variationsList.add(variationsType);
		}
	}

	public void WriteProfiles(GetSellerProfilesResponse sellerProfles) {
		int i = 1;
		for (PaymentProfile p : sellerProfles.getPaymentProfileList().getPaymentProfile()) {
			profilesDetails.setCellDetails(i, 0, p.getProfileId().toString());
			profilesDetails.setCellDetails(i, 1, p.getProfileName());
			profilesDetails.setCellDetails(i, 2, p.getProfileType().toString());
			i++;
		}
		for (ReturnPolicyProfile p : sellerProfles.getReturnPolicyProfileList().getReturnPolicyProfile()) {
			profilesDetails.setCellDetails(i, 0, p.getProfileId().toString());
			profilesDetails.setCellDetails(i, 1, p.getProfileName());
			profilesDetails.setCellDetails(i, 2, p.getProfileType().toString());
			i++;
		}
		for (ShippingPolicyProfile p : sellerProfles.getShippingPolicyProfile().getShippingPolicyProfile()) {
			profilesDetails.setCellDetails(i, 0, p.getProfileId().toString());
			profilesDetails.setCellDetails(i, 1, p.getProfileName());
			profilesDetails.setCellDetails(i, 2, p.getProfileType().toString());
			i++;
		}
	}

	
}
