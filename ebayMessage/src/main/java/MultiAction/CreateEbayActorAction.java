package MultiAction;

import bean.Bean;
import Listener.EbayCallBackListener;
import actor.Actor;
import core.Action;

public abstract class CreateEbayActorAction implements Action {
	Actor actor;
	EbayCallBackListener callBackListener;

	public abstract void initialize(Bean b);

	@Override
	public Bean getResult() {
		return null;
	}
}
