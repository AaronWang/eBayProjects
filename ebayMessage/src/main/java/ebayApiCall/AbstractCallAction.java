package ebayApiCall;

import bean.callInputBean.AbstractInputBean;

import com.ebay.sdk.ApiCall;
import com.ebay.sdk.ApiContext;

import core.CallAction;
import event.EbayCallBackListener;

public abstract class AbstractCallAction implements CallAction {
	ApiCall apicall;
	AbstractInputBean bean;
	EbayCallBackListener callBackListener;

	public AbstractCallAction() {
		// TODO Auto-generated constructor stub
	}

	public abstract void initialize(AbstractInputBean b, ApiContext ctx);

	public void excecute() {
		excecuteAction();
		callBack();
	}

	@Override
	public void callBack() {
		// TODO Auto-generated method stub
		callBackListener.ebayCallBack(bean);
	}

	abstract void excecuteAction();
}
