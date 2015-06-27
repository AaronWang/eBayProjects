package handler.future;

import bean.Bean;
import core.Handler;
import core.SystemContext;
import ebayClient.EbayClient;

public abstract class CallBackHandler implements Handler {
	protected SystemContext systemContext;

	public CallBackHandler() {
		systemContext = EbayClient.getInstance();
	}

	public abstract void handle(Bean bean);
}
