package ebayApiCall;

import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.sdk.call.GetSellingManagerSaleRecordCall;
import com.ebay.sdk.call.GetSellingManagerSoldListingsCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetOrdersBean;
import bean.callBean.GetSellingManagerSaleRecordBean;

public class GetSellingManagerSaleRecordCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetSellingManagerSaleRecordCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetSellingManagerSaleRecordCall) apicall).setItemID(((GetSellingManagerSaleRecordBean) b).getItemID());
		((GetSellingManagerSaleRecordCall) apicall).setTransactionID(((GetSellingManagerSaleRecordBean) b).getTransactionID());
		((GetSellingManagerSaleRecordCall) apicall).setOrderID(((GetSellingManagerSaleRecordBean) b).getOrderID());
		((GetSellingManagerSaleRecordCall) apicall).setOrderLineItemID(((GetSellingManagerSaleRecordBean) b).getOrderLineItemID());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetSellingManagerSaleRecordCall getSellingManagerSaleRecordCall = (GetSellingManagerSaleRecordCall) apicall;

		try {
			getSellingManagerSaleRecordCall.getSellingManagerSaleRecord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((GetSellingManagerSaleRecordBean) bean).setReturnedSellingManagerSoldOrder(getSellingManagerSaleRecordCall.getReturnedSellingManagerSoldOrder());
	}

}
