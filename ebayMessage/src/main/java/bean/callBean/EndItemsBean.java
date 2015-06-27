package bean.callBean;

import com.ebay.soap.eBLBaseComponents.EndItemRequestContainerType;
import com.ebay.soap.eBLBaseComponents.EndItemResponseContainerType;

public class EndItemsBean extends EbayCallBean {
	// input
	EndItemRequestContainerType[] endItemRequestContainer;

	// output
	EndItemResponseContainerType[] ReturnedEndItemResponseContainer;

	public EndItemRequestContainerType[] getEndItemRequestContainer() {
		return endItemRequestContainer;
	}

	public void setEndItemRequestContainer(
			EndItemRequestContainerType[] endItemRequestContainer) {
		this.endItemRequestContainer = endItemRequestContainer;
	}

	public EndItemResponseContainerType[] getReturnedEndItemResponseContainer() {
		return ReturnedEndItemResponseContainer;
	}

	public void setReturnedEndItemResponseContainer(
			EndItemResponseContainerType[] returnedEndItemResponseContainer) {
		ReturnedEndItemResponseContainer = returnedEndItemResponseContainer;
	}
	
	
}
