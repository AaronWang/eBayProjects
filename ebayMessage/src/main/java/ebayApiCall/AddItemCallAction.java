package ebayApiCall;

import com.ebay.sdk.call.AddItemCall;
import com.ebay.sdk.call.GetUserCall;

import Listener.EbayCallBackListener;
import bean.Bean;
import bean.callBean.AddDisputeBean;
import bean.callBean.AddItemBean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetUserBean;

public class AddItemCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new AddItemCall();
		bean = b;

		apicall.setApiContext(((EbayCallBean) b).getApiContext());
		((AddItemCall) apicall).setItem(((AddItemBean) b).getItem());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		AddItemCall addItemCall = (AddItemCall) apicall;

		try {
			addItemCall.addItem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		((AddItemBean) bean).setReturnedItemID(addItemCall.getReturnedItemID());
		((AddItemBean) bean).setReturnedStartTime(addItemCall.getReturnedStartTime());
		((AddItemBean) bean).setReturnedEndTime(addItemCall.getReturnedEndTime());
		((AddItemBean) bean).setReturnedFees(addItemCall.getReturnedFees());
		((AddItemBean) bean).setReturnedCategoryID(addItemCall.getReturnedCategoryID());
		((AddItemBean) bean).setReturnedCategory2ID(addItemCall.getReturnedCategory2ID());
		((AddItemBean) bean).setReturnedDiscountReason(addItemCall.getReturnedDiscountReason());
		((AddItemBean) bean).setReturnedProductSuggestions(addItemCall.getReturnedProductSuggestions());
		((AddItemBean) bean).setReturnedListingRecommendations(addItemCall.getReturnedListingRecommendations());
	}

}
