package event;

import java.util.ArrayList;

import event.future.CallBackHandler;
import bean.callInputBean.AbstractInputBean;

public abstract class AbstractEbayCallBackListener implements CallBackListener {
	ArrayList<CallBackHandler> handler;

	public AbstractEbayCallBackListener() {
		handler = new ArrayList<CallBackHandler>();
	}

	@Override
	public void ebayCallBack(AbstractInputBean bean) {
		// TODO Auto-generated method stub
		// handler.handle(bean);
		for (CallBackHandler h : handler) {
			h.handle(bean);
		}
	}

	public void addEbayCallBackHandler(CallBackHandler handler) {
		this.handler.add(handler);
	}
}
