package actor;

import core.Action;

public class MultiActionActor extends Actor {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (Action a : actionList) {
			a.execute();
		}
	}

}
