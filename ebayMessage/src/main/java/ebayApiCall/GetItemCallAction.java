package ebayApiCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetItemBean;

import com.ebay.sdk.call.GetItemCall;

public class GetItemCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetItemCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetItemCall) apicall).setItemID(((GetItemBean) b).getItemID());
		((GetItemCall) apicall).setIncludeWatchCount(((GetItemBean) b).isIncludeWatchCount());
		((GetItemCall) apicall).setIncludeCrossPromotion(((GetItemBean) b).isIncludeCrossPromotion());
		((GetItemCall) apicall).setIncludeItemSpecifics(((GetItemBean) b).isIncludeItemSpecifics());
		((GetItemCall) apicall).setIncludeTaxTable(((GetItemBean) b).isIncludeTaxTable());
		((GetItemCall) apicall).setSKU(((GetItemBean) b).getSku());
		((GetItemCall) apicall).setVariationSKU(((GetItemBean) b).getVariationSKU());
		((GetItemCall) apicall).setVariationSpecifics(((GetItemBean) b).getVariationSpecifics());
		((GetItemCall) apicall).setTransactionID(((GetItemBean) b).getTransactionID());
		((GetItemCall) apicall).setIncludeItemCompatibilityList(((GetItemBean) b).isIncludeItemCompatibilityList());

		((GetItemCall) apicall).setDetailLevel(((GetItemBean) b).getDetailLevel());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetItemCall getItemCall = (GetItemCall) apicall;

		try {
			getItemCall.getItem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((GetItemBean) bean).setReturnedItem(getItemCall.getReturnedItem());
	}

}
