package ebayApiCall;

import java.util.ArrayList;
import java.util.Calendar;

import com.ebay.sdk.call.AddDisputeCall;
import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.soap.eBLBaseComponents.DisputeExplanationCodeType;
import com.ebay.soap.eBLBaseComponents.DisputeReasonCodeType;
import com.ebay.soap.eBLBaseComponents.OrderStatusCodeType;
import com.ebay.soap.eBLBaseComponents.OrderType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.TradingRoleCodeType;

public class GetOrders {

	private ArrayList<OrderType> orderList = new ArrayList<OrderType>();

	public void getorders() {
		GetOrdersCall goc = new GetOrdersCall(EbayContext.getApiContext());

		Calendar calendarFrom = Calendar.getInstance();
		Calendar calendarTo = Calendar.getInstance();
		calendarFrom.add(Calendar.DATE, -31);
		calendarTo.add(Calendar.DATE, -5);

		goc.setOrderRole(TradingRoleCodeType.SELLER);
		goc.setCreateTimeFrom(calendarFrom);
		goc.setCreateTimeTo(calendarTo);
		PaginationType page = new PaginationType();
		page.setEntriesPerPage(100);
		page.setPageNumber(1);
		goc.setPagination(page);
		goc.setOrderStatus(OrderStatusCodeType.ACTIVE);

		int pageMax = 1;
		OrderType[] orderarray;
		try {
			orderList.clear();
			do {
				goc.getOrders();
				String responseXML = goc.getResponseXml();
				pageMax = goc.getReturnedPaginationResult()
						.getTotalNumberOfPages();
				orderarray = goc.getReturnedOrderArray();
				for (int i = 0; i < orderarray.length; i++)
					orderList.add(orderarray[i]);
				page.setPageNumber(goc.getReturnedPageNumber() + 1);
			} while (page.getPageNumber() <= pageMax);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddDisputeCall adddispute = new AddDisputeCall(EbayContext.getApiContext());
		adddispute
				.setDisputeExplanation(DisputeExplanationCodeType.BUYER_NOT_PAID);
		adddispute.setDisputeReason(DisputeReasonCodeType.BUYER_HAS_NOT_PAID);
		for (int i = 0; i < orderList.size(); i++) {
			adddispute.setOrderLineItemID(orderList.get(i).getOrderID());
			try {
				adddispute.addDispute();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(orderList.get(i).getBuyerUserID()+"    "+" failed!~");
				continue;
			}
			System.out.println(orderList.get(i).getBuyerUserID()+"    "+" success!~");
		}
		// adddispute.setOrderLineItemID("required");

	}
}
