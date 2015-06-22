package ebayApiCall;

import bean.callInputBean.AbstractInputBean;
import bean.callInputBean.AddDisputeBean;

import com.ebay.sdk.ApiCall;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.AddDisputeCall;

public class AddDisputCallAction extends AbstractCallAction {


	public void setInput() {

	}

	@Override
	public void excecute() throws Exception {
		// TODO Auto-generated method stub

		AddDisputeCall addDisputeCall = (AddDisputeCall) apicall;
		addDisputeCall.addDispute();
	}

	@Override
	public void initialize(AbstractInputBean b, ApiContext ctx) {
		// TODO Auto-generated method stub
		apicall = new AddDisputeCall();
		bean = new AddDisputeBean();
	}
}
