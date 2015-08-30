package ebayApiCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetMyeBaySellingBean;

import com.ebay.sdk.call.GetMyeBaySellingCall;

public class GetMyeBaySellingCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetMyeBaySellingCall();
		bean = b;

		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetMyeBaySellingCall) apicall).setScheduledList(((GetMyeBaySellingBean) b).getScheduledList());
		((GetMyeBaySellingCall) apicall).setActiveList(((GetMyeBaySellingBean) b).getActiveList());
		((GetMyeBaySellingCall) apicall).setSoldList(((GetMyeBaySellingBean) b).getSoldList());
		((GetMyeBaySellingCall) apicall).setUnsoldList(((GetMyeBaySellingBean) b).getUnsoldList());
		((GetMyeBaySellingCall) apicall).setBidList(((GetMyeBaySellingBean) b).getBidList());
		((GetMyeBaySellingCall) apicall).setDeletedFromSoldList(((GetMyeBaySellingBean) b).getDeletedFromSoldList());
		((GetMyeBaySellingCall) apicall).setDeletedFromUnsoldList(((GetMyeBaySellingBean) b).getDeletedFromUnsoldList());
		((GetMyeBaySellingCall) apicall).setSellingSummary(((GetMyeBaySellingBean) b).getSellingSummary());
		((GetMyeBaySellingCall) apicall).setHideVariations(((GetMyeBaySellingBean) b).isHideVariations());

//		((GetMyeBaySellingCall) apicall).addDetailLevel(((GetMyeBaySellingBean) b).getDetailLevel());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetMyeBaySellingCall getMyeBaySellingCall = (GetMyeBaySellingCall) apicall;

		try {
			getMyeBaySellingCall.getMyeBaySelling();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		((GetMyeBaySellingBean) bean).setReturnedSellingSummary(getMyeBaySellingCall.getReturnedSellingSummary());
		((GetMyeBaySellingBean) bean).setReturnedScheduledList(getMyeBaySellingCall.getReturnedScheduledList());
		((GetMyeBaySellingBean) bean).setReturnedActiveList(getMyeBaySellingCall.getReturnedActiveList());
		((GetMyeBaySellingBean) bean).setReturnedSoldList(getMyeBaySellingCall.getReturnedSoldList());
		((GetMyeBaySellingBean) bean).setReturnedUnsoldList(getMyeBaySellingCall.getReturnedUnsoldList());
		((GetMyeBaySellingBean) bean).setReturnedSummary(getMyeBaySellingCall.getReturnedSummary());
		((GetMyeBaySellingBean) bean).setReturnedBidList(getMyeBaySellingCall.getReturnedBidList());
		((GetMyeBaySellingBean) bean).setReturnedDeletedFromSoldList(getMyeBaySellingCall.getReturnedDeletedFromSoldList());
		((GetMyeBaySellingBean) bean).setReturnedDeletedFromUnsoldList(getMyeBaySellingCall.getReturnedDeletedFromUnsoldList());
	}
}
