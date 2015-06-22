package actor;

import core.CallAction;
import ebayClient.EbayClient;

public abstract class AbstractEbayActor implements EbayActor {
	EbayActorDispatcher defaultDispatcher;

	public AbstractEbayActor() {
		defaultDispatcher = EbayClient.getInstance().getActorDispatcher();
	}
}
