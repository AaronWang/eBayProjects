package actor;

import core.CallAction;

public class EbayCallActor extends AbstractEbayActor {
	CallAction callAction;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		callAction.excecute();
	}

	@Override
	public void setAction(CallAction action) {
		// TODO Auto-generated method stub
		callAction = action;
	}

	@Override
	public void despatch() {
		// TODO Auto-generated method stub
		this.defaultDispatcher.pushActor(this);
	}
}
