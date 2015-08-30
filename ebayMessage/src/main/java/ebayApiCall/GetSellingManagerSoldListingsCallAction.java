package ebayApiCall;

import com.ebay.sdk.call.GetOrdersCall;
import com.ebay.sdk.call.GetSellingManagerSaleRecordCall;
import com.ebay.sdk.call.GetSellingManagerSoldListingsCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetOrdersBean;
import bean.callBean.GetSellingManagerSaleRecordBean;
import bean.callBean.GetSellingManagerSoldListingsBean;

public class GetSellingManagerSoldListingsCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new GetSellingManagerSoldListingsCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetSellingManagerSoldListingsCall) apicall).setSearch(((GetSellingManagerSoldListingsBean) b).getSearch());
		((GetSellingManagerSoldListingsCall) apicall).setStoreCategoryID(((GetSellingManagerSoldListingsBean) b).getStoreCategoryID());
		((GetSellingManagerSoldListingsCall) apicall).setFilter(((GetSellingManagerSoldListingsBean) b).getFilter());
		((GetSellingManagerSoldListingsCall) apicall).setArchived(((GetSellingManagerSoldListingsBean) b).getArchived());
		((GetSellingManagerSoldListingsCall) apicall).setSort(((GetSellingManagerSoldListingsBean) b).getSort());
		((GetSellingManagerSoldListingsCall) apicall).setSortOrder(((GetSellingManagerSoldListingsBean) b).getSortOrder());
		((GetSellingManagerSoldListingsCall) apicall).setPagination(((GetSellingManagerSoldListingsBean) b).getPagination());
		((GetSellingManagerSoldListingsCall) apicall).setSaleDateRange(((GetSellingManagerSoldListingsBean) b).getSaleDateRange());
		((GetSellingManagerSoldListingsCall) apicall).setDetailLevel(((GetSellingManagerSoldListingsBean) b).getDetailLevel());
	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetSellingManagerSoldListingsCall getSellingManagerSoldListingsCall = (GetSellingManagerSoldListingsCall) apicall;

		try {
			getSellingManagerSoldListingsCall.getSellingManagerSoldListings();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((GetSellingManagerSoldListingsBean) bean).setReturnedPaginationResult(getSellingManagerSoldListingsCall.getReturnedPaginationResult());
		((GetSellingManagerSoldListingsBean) bean).setReturnedSaleRecord(getSellingManagerSoldListingsCall.getReturnedSaleRecord());
	}

}
