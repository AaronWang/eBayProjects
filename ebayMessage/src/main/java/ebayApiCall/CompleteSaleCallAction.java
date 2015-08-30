package ebayApiCall;

import com.ebay.sdk.call.AddItemCall;
import com.ebay.sdk.call.CompleteSaleCall;

import bean.Bean;
import bean.callBean.AddItemBean;
import bean.callBean.CompleteSaleBean;
import bean.callBean.EbayCallBean;

public class CompleteSaleCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new CompleteSaleCall();
		bean = b;

		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((CompleteSaleCall) apicall).setItemID(((CompleteSaleBean) b).getItemID());
		((CompleteSaleCall) apicall).setTransactionID(((CompleteSaleBean) b).getTransactionID());
		((CompleteSaleCall) apicall).setFeedbackInfo(((CompleteSaleBean) b).getFeedbackInfo());
		((CompleteSaleCall) apicall).setShipped(((CompleteSaleBean) b).getShipped());
		((CompleteSaleCall) apicall).setPaid(((CompleteSaleBean) b).getPaid());
		((CompleteSaleCall) apicall).setListingType(((CompleteSaleBean) b).getListingType());
		((CompleteSaleCall) apicall).setShipment(((CompleteSaleBean) b).getShipment());
		((CompleteSaleCall) apicall).setOrderID(((CompleteSaleBean) b).getOrderID());
		((CompleteSaleCall) apicall).setOrderLineItemID(((CompleteSaleBean) b).getOrderLineItemID());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		CompleteSaleCall addItemCall = (CompleteSaleCall) apicall;

		try {
			addItemCall.completeSale();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
