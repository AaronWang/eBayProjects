package ebayApiCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetUserBean;

import com.ebay.sdk.call.GetUserCall;

public class GetUserCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetUserCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());
		// callBackListener.addEbayCallBackHandler(handler);

		// ((GetSessionIDBean)
		// b).setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");

		// ((GetSessionIDCall) apicall).setRuName(((GetSessionIDBean) b)
		// .getRuName());

	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetUserCall getUserCall = (GetUserCall) apicall;
		try {
			getUserCall.getUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((GetUserBean) bean).setReturnedUser(getUserCall.getReturnedUser());
		// ((GetUserBean) bean).setUserID(getUserCall.getReturnedUser()
		// .getUserID());
		System.out.println(getUserCall.getReturnedUser().getUserID());
	}
}
