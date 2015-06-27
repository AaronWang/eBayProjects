package Listener;

import java.util.ArrayList;

import bean.Bean;
import core.Handler;
import core.Listener;

public abstract class AbstractListener implements Listener {
	ArrayList<Handler> handler;

	public AbstractListener() {
		handler = new ArrayList<Handler>();
	}

	@Override
	public void activateHandler(Bean bean) {
		for (Handler h : handler) {
			h.handle(bean);
		}
	}

	public ArrayList<Handler> getHandler() {
		return handler;
	}

	public void setHandler(ArrayList<Handler> handler) {
		this.handler = handler;
	}
}
