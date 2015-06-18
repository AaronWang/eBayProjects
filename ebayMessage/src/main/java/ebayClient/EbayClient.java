package ebayClient;

import java.util.HashMap;
import java.util.Map;

import moduals.EbayContextModule;
import actor.EbayActor;
import actor.EbayActorDispatcher;
import core.Module;
import core.Service;
import core.SystemContext;
import event.EbayNotifyEvent;
import event.EbayNotifyListener;

public class EbayClient implements SystemContext {

	private Map<Service.Type, Service> services;
	private Map<Module.Type, Module> modules;
	private EbayActorDispatcher actorDispatcher;
	private EbayNotifyListener notifyListener;

	public EbayClient() {
		services = new HashMap<Service.Type, Service>();
		modules = new HashMap<Module.Type, Module>();
		modules.put(Module.Type.EBAYCONTEXT, new EbayContextModule());
	}

	@Override
	public void pushActor(EbayActor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fireNotify(EbayNotifyEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Module> T getModule(Module.Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Service> T getSerivce(Service.Type type) {
		// TODO Auto-generated method stub
		return null;
	}
}
