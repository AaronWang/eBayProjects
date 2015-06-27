package Listener;

import bean.Bean;

import com.ebay.sdk.ApiCall;

import core.Handler;

public class EbayCallBackListener extends AbstractListener {

	public void addEbayCallBackHandler(Handler handler) {
		if (handler != null)
			this.handler.add(handler);
	}
}
