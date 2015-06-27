package actor;

import java.util.ArrayList;

import core.Action;

public abstract class Actor {

	ArrayList<Action> actionList;

	public Actor() {
		actionList = new ArrayList<Action>();
	}

	public abstract void execute();

	// public void execute() {

	// }

	public void addAction(Action action) {
		actionList.add(action);
	}

	public void clearAction() {
		actionList.clear();
	}

}
