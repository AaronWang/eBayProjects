package ebayApiCall;

import bean.callInputBean.AbstractInputBean;
import bean.callInputBean.GetSessionIDBean;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.GetSessionIDCall;

public class GetSessionIDCallAction extends AbstractCallAction {

	@Override
	void excecuteAction() {
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
		System.out.println("GetSessionIDCallAction finished : "
				+ getsessionIDCall.getReturnedSessionID());
	}

	@Override
	public void initialize(AbstractInputBean b, ApiContext ctx) {
		// TODO Auto-generated method stub
		apicall = new GetSessionIDCall();
		// bean = new GetSessionIDBean();
		bean = b;
		apicall.setApiContext(ctx);

		((GetSessionIDBean) b).setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");

		((GetSessionIDCall) apicall).setRuName(((GetSessionIDBean) b)
				.getRuName());

	}
}
