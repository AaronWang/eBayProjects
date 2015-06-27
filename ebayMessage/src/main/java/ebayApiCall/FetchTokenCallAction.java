package ebayApiCall;

import handler.future.DefaultFetchTokenCallHandler;
import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.FetchTokenBean;

import com.ebay.sdk.call.FetchTokenCall;

public class FetchTokenCallAction extends EbayCallAction {
	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new FetchTokenCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());
		((FetchTokenCall) apicall).setSessionID(((FetchTokenBean) b)
				.getSessionID());
		callBackListener
				.addEbayCallBackHandler(new DefaultFetchTokenCallHandler());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		FetchTokenCall fetchTokenCall = (FetchTokenCall) apicall;

		try {
			fetchTokenCall.fetchToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FetchTokenBean b = (FetchTokenBean) bean;

		b.setReturnedToken(fetchTokenCall.getReturnedToken());
		b.setReturnedRESTToken(fetchTokenCall.getReturnedRESTToken());
		b.setHardExpirationTime(fetchTokenCall.getHardExpirationTime());

		// b.getApiContext().getApiCredential()
		// .seteBayToken(fetchTokenCall.getReturnedToken());
	}

}
