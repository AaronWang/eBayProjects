package ebayApiCall;

import Listener.EbayCallBackListener;
import bean.Bean;

import com.ebay.sdk.ApiCall;
import com.ebay.sdk.ApiContext;

import core.Action;

public abstract class EbayCallAction implements Action {
	ApiCall apicall;
	Bean bean;
	EbayCallBackListener callBackListener;

	public EbayCallAction() {
		// TODO Auto-generated constructor stub
		callBackListener = new EbayCallBackListener();
	}

	public abstract void initialize(Bean b);

	public void execute() {
		executeAction();
		callBack();
	}

	@Override
	public void callBack() {
		// TODO Auto-generated method stub
		callBackListener.activateHandler(bean);
	}

	public abstract void executeAction();

	public EbayCallBackListener getCallBackListener() {
		return callBackListener;
	}

	public enum ActionNames {
		GETSESSIONID, GETORDERS, FETCHTOKEN, GETUSER,
	}

	@Override
	public Bean getResult() {
		return bean;
	}

}
