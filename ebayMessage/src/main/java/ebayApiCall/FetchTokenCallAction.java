package ebayApiCall;

import bean.callInputBean.AbstractInputBean;
import bean.callInputBean.FetchTokenBean;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.FetchTokenCall;

public class FetchTokenCallAction extends AbstractCallAction {

	@Override
	public void excecute() throws Exception {
		// TODO Auto-generated method stub
		FetchTokenCall fetchTokenCall = (FetchTokenCall) apicall;
		fetchTokenCall.fetchToken();
	}

	@Override
	public void initialize(AbstractInputBean b, ApiContext ctx) {
		// TODO Auto-generated method stub
		apicall = new FetchTokenCall();
		bean = b;
	}

}
