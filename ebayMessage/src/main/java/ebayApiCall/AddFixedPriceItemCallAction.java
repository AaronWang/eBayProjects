package ebayApiCall;

import com.ebay.sdk.call.AddFixedPriceItemCall;
import com.ebay.sdk.call.AddItemCall;
import com.ebay.sdk.call.GetUserCall;

import Listener.EbayCallBackListener;
import bean.Bean;
import bean.callBean.AddDisputeBean;
import bean.callBean.AddFixedPriceItemBean;
import bean.callBean.AddFixedPriceItemBean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetUserBean;

public class AddFixedPriceItemCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new AddFixedPriceItemCall();
		bean = b;

		apicall.setApiContext(((EbayCallBean) b).getApiContext());
		((AddFixedPriceItemCall) apicall).setItem(((AddFixedPriceItemBean) b).getItem());
		
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		AddFixedPriceItemCall addFixedPriceItemCall = (AddFixedPriceItemCall) apicall;

		try {
			addFixedPriceItemCall.addFixedPriceItem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		((AddFixedPriceItemBean) bean).setReturnedItemID(addFixedPriceItemCall.getReturnedItemID());
		((AddFixedPriceItemBean) bean).setReturnedSKU(addFixedPriceItemCall.getReturnedSKU());
		((AddFixedPriceItemBean) bean).setReturnedStartTime(addFixedPriceItemCall.getReturnedStartTime());
		((AddFixedPriceItemBean) bean).setReturnedEndTime(addFixedPriceItemCall.getReturnedEndTime());
		((AddFixedPriceItemBean) bean).setReturnedFees(addFixedPriceItemCall.getReturnedFees());
		((AddFixedPriceItemBean) bean).setReturnedCategoryID(addFixedPriceItemCall.getReturnedCategoryID());
		((AddFixedPriceItemBean) bean).setReturnedCategory2ID(addFixedPriceItemCall.getReturnedCategory2ID());
		((AddFixedPriceItemBean) bean).setReturnedDiscountReason(addFixedPriceItemCall.getReturnedDiscountReason());
		((AddFixedPriceItemBean) bean).setReturnedProductSuggestions(addFixedPriceItemCall.getReturnedProductSuggestions());
		((AddFixedPriceItemBean) bean).setReturnedListingRecommendations(addFixedPriceItemCall.getReturnedListingRecommendations());

	}
}
