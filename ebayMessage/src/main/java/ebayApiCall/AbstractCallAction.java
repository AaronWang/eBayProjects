package ebayApiCall;

import com.ebay.sdk.ApiCall;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.SdkSoapException;
import com.ebay.soap.eBLBaseComponents.AbstractRequestType;

import core.CallAction;

public abstract class AbstractCallAction implements CallAction {
	ApiCall apicall;

	public AbstractCallAction() {
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	public void callBack() {
		// TODO Auto-generated method stub

	}

}
