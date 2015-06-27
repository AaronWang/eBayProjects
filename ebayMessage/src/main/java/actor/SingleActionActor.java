package actor;

import core.Action;

public class SingleActionActor extends Actor {

	@Override
	public void addAction(Action action) {
		clearAction();
		super.addAction(action);
	}

	public void setAction(Action action) {
		// TODO Auto-generated method stub
		clearAction();
		super.addAction(action);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		actionList.get(0).execute();
	}

}
