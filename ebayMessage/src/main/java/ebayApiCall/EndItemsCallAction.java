package ebayApiCall;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bean.Bean;
import bean.callBean.AddDisputeBean;
import bean.callBean.EbayCallBean;
import bean.callBean.EndItemsBean;
import bean.callBean.GetSessionIDBean;

import com.ebay.sdk.call.EndItemsCall;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.ebay.soap.eBLBaseComponents.EndItemRequestContainerType;
import com.ebay.soap.eBLBaseComponents.EndReasonCodeType;

public class EndItemsCallAction extends EbayCallAction {

	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub
		apicall = new EndItemsCall();
		bean = (EndItemsBean) b;
		apicall.setApiContext(((EbayCallBean) b).getApiContext());

		((EndItemsCall) apicall).setEndItemRequestContainer(((EndItemsBean) b).getEndItemRequestContainer());

	}

	@Override
	public void executeAction() {
		// TODO Auto-generated method stub
		EndItemsCall endItemsCall = (EndItemsCall) apicall;
		try {
			endItemsCall.endItems();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((EndItemsBean) bean).setReturnedEndItemResponseContainer(endItemsCall.getReturnedEndItemResponseContainer());

	}
}
