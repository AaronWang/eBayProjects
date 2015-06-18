package ebayApiCall;

import com.ebay.sdk.ApiCall;
import com.ebay.sdk.call.AddDisputeCall;

public class AddDisputCallAction extends AbstractCallAction {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		apicall = new AddDisputeCall();
	}

	
	public void setInput() {

	}

	@Override
	public void excecute() throws Exception {
		// TODO Auto-generated method stub

		AddDisputeCall addDisputeCall = (AddDisputeCall) apicall;
		addDisputeCall.addDispute();
	}
}
