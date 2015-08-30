package ebayApiCall;

import com.ebay.sdk.call.GetCategoriesCall;
import com.ebay.sdk.call.GetItemCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetCategoriesBean;
import bean.callBean.GetItemBean;

public class GetCategoriesCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetCategoriesCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetCategoriesCall) apicall).setCategorySiteID(((GetCategoriesBean) b).getCategorySiteID());
		((GetCategoriesCall) apicall).setParentCategories(((GetCategoriesBean) b).getParentCategories());
		((GetCategoriesCall) apicall).setLevelLimit(((GetCategoriesBean) b).getLevelLimit());
		((GetCategoriesCall) apicall).setViewAllNodes(((GetCategoriesBean) b).getViewAllNodes());
		((GetCategoriesCall) apicall).setDetailLevel(((GetCategoriesBean) b).getDetailLevel());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub

		GetCategoriesCall getCategoriesCall = (GetCategoriesCall) apicall;

		try {
			getCategoriesCall.getCategories();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((GetCategoriesBean) bean).setReturnedCategoryArray(getCategoriesCall.getReturnedCategoryArray());
		((GetCategoriesBean) bean).setReturnedCategoryCount(getCategoriesCall.getReturnedCategoryCount());
		((GetCategoriesBean) bean).setReturnedCategoryUpdateTime(getCategoriesCall.getReturnedCategoryUpdateTime());
		((GetCategoriesBean) bean).setReturnedCategoryVersion(getCategoriesCall.getReturnedCategoryVersion());
		((GetCategoriesBean) bean).setReturnedReservePriceAllowed(getCategoriesCall.getReturnedReservePriceAllowed());
		((GetCategoriesBean) bean).setReturnedReduceReserveAllowed(getCategoriesCall.getReturnedReduceReserveAllowed());
		((GetCategoriesBean) bean).setMinimumReservePrice(getCategoriesCall.getMinimumReservePrice());
	}
}
