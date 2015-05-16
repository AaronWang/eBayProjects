/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.sanitytest;

import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.GetNotificationPreferencesResponseType;
import com.ebay.soap.eBLBaseComponents.GetStoreOptionsResponseType;
import com.ebay.soap.eBLBaseComponents.GetUserPreferencesResponseType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.MemberMessageExchangeType;
import com.ebay.soap.eBLBaseComponents.ProductSearchPageType;
import com.ebay.soap.eBLBaseComponents.ProductSearchResultType;
import com.ebay.soap.eBLBaseComponents.PromotionRuleType;
import com.ebay.soap.eBLBaseComponents.StoreCustomPageArrayType;
import com.ebay.soap.eBLBaseComponents.StorePreferencesType;
import com.ebay.soap.eBLBaseComponents.StoreType;
import com.ebay.soap.eBLBaseComponents.TaxTableType;
import com.ebay.soap.eBLBaseComponents.TransactionType;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public abstract class TestData {

  public static ItemType itemForBid = null;
  
  public static boolean hasBid = false;
	
  public static String[] itemIDs = null;

  public static ItemType NewItem = null;
  public static ItemType NewFixedPriceItem = null;

  public static String UserID = null;
  
  public static ItemType EndedItem = null;
  public static ItemType EndedFixedPriceItem = null;

  public static CategoryType[] Categories = null;
  public static CategoryType[] Category2CS = null;

  public static StoreType Store = null;

  public static StoreCustomPageArrayType StoreCustomPages = null;

  public static GetStoreOptionsResponseType StoreOptionsResponse = null;

  public static StorePreferencesType StorePreferences = null;

  public static GetUserPreferencesResponseType UserPreferencesResponse = null;

  public static TaxTableType TaxTable = null;

  public static GetNotificationPreferencesResponseType NotificationPreferencesResponse = null;

  public static MemberMessageExchangeType[] MemberMessages = null;

  public static TransactionType[] SellerTransactions = null;

  public static PromotionRuleType ItemPromotionRule = null;

  public static ProductSearchPageType[] ProductSearchPages = null;

  public static ProductSearchResultType[] ProductSearchResults = null;
  public static String AudioChallengeURL = null;
  public static String ChallengeToken = null;
  public static String ImageChallengeURL = null;
  //token for another eBay account, for item bid test case
  public static String testUserName = "apitest11";
  public static String testToken = "AgAAAA**AQAAAA**aAAAAA**FcP3Sg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wJnY+gD5iFoA+dj6x9nY+seQ**tgAAAA**AAMAAA**B+c0eBpWnTZH6Y/MMuij7Zd1ySMgPzJt+wN7gWp3S7UuD8q+9rgaGJ2LUx3xYzG76BHvf++YNXCIaMLjuoC509GpkLwFhALZcwby7ak9JIxdhrLcVlu7sp9bo/dGqwhRaYYT7Dk6MzLvK7dQmqAGP6ON+tS96KXQzeGffSHwSfPIh/f5Wbcb3JazL9Ot10+jyV354wdOF+tdDs2zUNBKmKQkGzsyXvW40kvhD6Ia9Bj7aWhEzYjd1vf7fVUxMUg0PRBb1yaZhXlhuN+L6hnK9XxMtewrOu9QyjNMOqHp99EOfWMo8uINoNXzafw+u4luJ99wdOmhmKYc7hGaFO1MGirV52tOjWHT87ZmLmplnQFZjO5EeMKnAnOjTjeldSJPLTNGFBKFQPHWwA91W27ze7LzqN/53/f9L/cokA+AEhx8awNSqFAg2usihGWusghq10qCN9bjbe+2ReTVh9naU9SU1VGhwPRmZwxhqfyziZQrb/r5+eYRX2kKG1q25DmpyXEc4uvdFgaH4d3eSRlW+aKEDRzjTo2n6umuvV62DXvPin0uWaJ4ZQRR6wJ6P/AlCTR7tEvuONIWfNo7yE9EYXQQNSgldn4l57mRLP1K/9lNOOGeU8PhOFY91GHH8tVynvCtEO6hoQ0p/El+CYIUs5owgGZ7fJOd3OhlmdNWS/eMxVgD/avT+apevYAhzALNv6LbD/2xtzB9QoMeAyNtqbSRpJGsEQE1586ORIoas6UjR3GUPtFRlax0sVueBGac";

  //data for selling manager
  public static Long folder_id1 = null;
  public static Long folder_id2 = null;
  public static Long saleTemplateId = null;
  public static Long productId = null;
  public static String itemId = null;
  public static String soldItemId = null;
}
