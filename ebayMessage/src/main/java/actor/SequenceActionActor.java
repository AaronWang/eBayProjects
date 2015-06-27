package actor;

import core.Action;

public class SequenceActionActor extends Actor {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (int i = 0; i < actionList.size(); i++) {
			// actionList.get(i).initialize(actionList.get(i - 1).getResult());
			actionList.get(i).execute();
		}
	}

	public void setAction(Action action) {
		clearAction();
		super.addAction(action);
	}

	public void addAction(Action action) {
		setAction(action);
	}
}
