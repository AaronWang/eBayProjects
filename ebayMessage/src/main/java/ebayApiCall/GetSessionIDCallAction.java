package ebayApiCall;

import handler.future.DefaultGetSessionIDCallHandler;
import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetSessionIDBean;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetSessionIDCall;

public class GetSessionIDCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetSessionIDCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetSessionIDBean) b).setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");

		((GetSessionIDCall) apicall).setRuName(((GetSessionIDBean) b)
				.getRuName());
		getCallBackListener().addEbayCallBackHandler(
				new DefaultGetSessionIDCallHandler());

	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetSessionIDCall getsessionIDCall = (GetSessionIDCall) apicall;
		try {
			getsessionIDCall.getSessionID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		((GetSessionIDBean) bean).setReturnedSessionID(getsessionIDCall
				.getReturnedSessionID());

//		System.out.println("GetSessionIDCallAction finished : "
//				+ getsessionIDCall.getReturnedSessionID());
	}
}
