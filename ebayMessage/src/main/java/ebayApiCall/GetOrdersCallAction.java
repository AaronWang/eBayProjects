package ebayApiCall;

import bean.Bean;
import bean.callBean.EbayCallBean;
import bean.callBean.GetOrdersBean;

import com.ebay.sdk.call.GetOrdersCall;

public class GetOrdersCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub

		apicall = new GetOrdersCall();
		bean = b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((GetOrdersCall) apicall).setOrderIDArray(((GetOrdersBean) b).getOrderIDArray());
		((GetOrdersCall) apicall).setCreateTimeFrom(((GetOrdersBean) b).getCreateTimeFrom());
		((GetOrdersCall) apicall).setCreateTimeTo(((GetOrdersBean) b).getCreateTimeTo());
		((GetOrdersCall) apicall).setOrderRole(((GetOrdersBean) b).getOrderRole());
		((GetOrdersCall) apicall).setOrderStatus(((GetOrdersBean) b).getOrderStatus());
		((GetOrdersCall) apicall).setListingType(((GetOrdersBean) b).getListingType());
		((GetOrdersCall) apicall).setPagination(((GetOrdersBean) b).getPagination());
		((GetOrdersCall) apicall).setModTimeFrom(((GetOrdersBean) b).getModTimeFrom());
		((GetOrdersCall) apicall).setModTimeTo(((GetOrdersBean) b).getModTimeTo());
		((GetOrdersCall) apicall).setNumberOfDays(((GetOrdersBean) b).getNumberOfDays());
		((GetOrdersCall) apicall).setIncludeFinalValueFee(((GetOrdersBean) b).isIncludeFinalValueFee());
		((GetOrdersCall) apicall).setSortingOrder(((GetOrdersBean) b).getSortingOrder());

	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		GetOrdersCall getOrdersCall = (GetOrdersCall) apicall;

		try {
			getOrdersCall.getOrders();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		((GetOrdersBean) bean).setReturnedPaginationResult(getOrdersCall.getReturnedPaginationResult());
		((GetOrdersBean) bean).setReturnedHasMoreOrders(getOrdersCall.getReturnedHasMoreOrders());
		((GetOrdersBean) bean).setReturnedOrderArray(getOrdersCall.getReturnedOrderArray());
		((GetOrdersBean) bean).setReturnedOrdersPerPage(getOrdersCall.getReturnedOrdersPerPage());
		((GetOrdersBean) bean).setReturnedPageNumber(getOrdersCall.getReturnedPageNumber());
		((GetOrdersBean) bean).setReturnedReturnedOrderCountActual(getOrdersCall.getReturnedReturnedOrderCountActual());
	}
}
