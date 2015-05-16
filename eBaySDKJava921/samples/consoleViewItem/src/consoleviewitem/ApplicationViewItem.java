/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package consoleviewitem;

import com.ebay.sdk.*;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.*;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.sdk.helper.ConsoleUtil;

/**
 * A simple view item sample,
 * show how to listing information from eBay Server using eBay SDK.
 * 
 * @author boyang
 *
 */
public class ApplicationViewItem {

  //Main method
  public static void main(String[] args) {

    String input;

    try {

      System.out.print("\n");
      System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
      System.out.print("+ Welcome to eBay SDK for Java Sample +\n");
      System.out.print("+  - ConsoleViewItem                  +\n");
      System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
      System.out.print("\n");

      // [1] Create ApiContext object.
      System.out.println("===== [1] Collect Account Information ====");

      ApiContext apiContext = new ApiContext();
      ApiCredential cred = apiContext.getApiCredential();

      input = ConsoleUtil.readString("Enter your eBay Authentication Token: ");
      cred.seteBayToken(input);
     

      input = ConsoleUtil.readString("Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi): ");
      apiContext.setApiServerUrl(input);

      // [2] Ask for itemID.
      System.out.println("===== [2] Call GetItemCall ====");
      String itemIDStr = ConsoleUtil.readString("Enter ID of the item that you want to get: ");

      GetItemCall gc = new GetItemCall(apiContext);
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };
      gc.setDetailLevel(detailLevels);

      ItemType item = gc.getItem(itemIDStr);

      // [3] Display result.
      System.out.println("===== [3] Display Returned Item Information ====");

      ApplicationViewItem.print("ItemType", item.getListingType().toString());
      ApplicationViewItem.print("Title: ",  item.getTitle());
      ApplicationViewItem.print("StartPrice", item.getStartPrice().getValue());
      ApplicationViewItem.print("Quantity", item.getQuantity().toString());
      ApplicationViewItem.print("PrimaryCategory", item.getPrimaryCategory().getCategoryID());
      SellingStatusType sst = item.getSellingStatus();
      ApplicationViewItem.print("CurrentPrice", sst.getCurrentPrice().getValue());
      ApplicationViewItem.print("BidCount", sst.getBidCount().toString());
      ApplicationViewItem.print("QuantitySold", sst.getQuantitySold() == null ? "" : sst.getQuantitySold().toString());

      ListingDetailsType ldt = item.getListingDetails();
      UserType hb = sst.getHighBidder();
      if( hb != null )
        ApplicationViewItem.print("HighBidder", hb.getUserID());

      ApplicationViewItem.print("StartTime", eBayUtil.toAPITimeString(ldt.getStartTime().getTime()));
      ApplicationViewItem.print("EndTime", eBayUtil.toAPITimeString(ldt.getEndTime().getTime()));
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  static void print(String name, String value)
  {
    System.out.println(name + ": " + value);
  }

  static void print(String name, double value)
  {
    System.out.println(name + ": " + new Double(value).toString());
  }

  static void print(String name, int value)
  {
    System.out.println(name + ": " + new Integer(value).toString());
  }
}
