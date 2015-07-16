package ebayApiCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetStoreBean;

import com.ebay.sdk.call.GetStoreCall;
import com.ebay.sdk.call.GetStoreCall;

public class GetStoreCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetStoreCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());


		((GetStoreCall) apicall).setCategoryStructureOnly(((GetStoreBean) b).isCategoryStructureOnly());

//		((GetStoreCall) apicall).setRootCategoryID(((GetStoreBean) b).getRootCategoryID());
//		((GetStoreCall) apicall).setLevelLimit(((GetStoreBean) b).getLevelLimit());
		((GetStoreCall) apicall).setUserID(((GetStoreBean) b).getUserID());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetStoreCall getStoreCall = (GetStoreCall) apicall;

		try {
			getStoreCall.getStore();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((GetStoreBean) bean).setReturnedStoreType(getStoreCall.getReturnedStoreType());
	}
}
