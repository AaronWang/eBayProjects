package ebayApiCall;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.ebay.sdk.call.EndItemsCall;
import com.ebay.soap.eBLBaseComponents.EndItemRequestContainerType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;

import ebayContext.EbayContext;

public class EndingItems {
	ArrayList<EndItemRequestContainerType> endingItemList;

	public EndingItems() {
		endingItemList = new ArrayList<EndItemRequestContainerType>();
	}

	public void addItemID(String itemID) {
		EndItemRequestContainerType newItem = new EndItemRequestContainerType();
		newItem.setItemID(itemID);
		newItem.setEndingReason(EndReasonCodeType.NOT_AVAILABLE);
		endingItemList.add(newItem);
	}
	public int size(){
		return endingItemList.size();
	}
	public void clear(){
		endingItemList.clear();
	}

	public void endingItem() {
		EndItemsCall enditemscall = new EndItemsCall(EbayContext.apiContext);
		EndItemRequestContainerType[] enditemContainer = enditemscall
				.getEndItemRequestContainer();

		enditemContainer = endingItemList
				.toArray(new EndItemRequestContainerType[endingItemList.size()]);
		enditemscall.setEndItemRequestContainer(enditemContainer);
		
		try {
			enditemscall.endItems();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"failed");
			return;
		}
		
		JOptionPane.showMessageDialog(null,"sucessful");
	}
}
