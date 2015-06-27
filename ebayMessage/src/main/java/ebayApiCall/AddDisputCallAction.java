package ebayApiCall;

import bean.Bean;
import bean.callBean.AddDisputeBean;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.AddDisputeCall;

public class AddDisputCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new AddDisputeCall();
		bean = (AddDisputeBean) b;
		apicall.setApiContext(((AddDisputeBean) b).getApiContext());
		((AddDisputeCall) apicall).setDisputeExplanation(((AddDisputeBean) b)
				.getDisputeExplanation());
		((AddDisputeCall) apicall).setDisputeReason(((AddDisputeBean) b)
				.getDisputeReason());
		((AddDisputeCall) apicall).setItemID(((AddDisputeBean) b).getItemID());
		((AddDisputeCall) apicall).setTransactionID(((AddDisputeBean) b)
				.getTransactionID());
		((AddDisputeCall) apicall).setOrderLineItemID(((AddDisputeBean) b)
				.getOrderLineItemID());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub

		AddDisputeCall addDisputeCall = (AddDisputeCall) apicall;
		try {
			addDisputeCall.addDispute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
