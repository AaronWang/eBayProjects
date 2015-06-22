package ebayClient;

import java.util.HashMap;
import java.util.Map;

import moduals.EbayContextModule;
import actor.ActorAssembler;
import actor.EbayActor;
import actor.EbayActorDispatcher;
import actor.ThreadActorDispatcher;
import core.Module;
import core.Service;
import core.SystemContext;

public class EbayClient implements SystemContext {
	private static EbayClient instance = new EbayClient();

	private Map<Service.Type, Service> services;
	private Map<Module.Type, Module> modules;
	private EbayActorDispatcher actorDispatcher;

	public EbayClient() {
		// System.out.println("initialize EbayClient ..");
		services = new HashMap<Service.Type, Service>();
		modules = new HashMap<Module.Type, Module>();
		modules.put(Module.Type.EBAYCONTEXT, new EbayContextModule());
		modules.put(Module.Type.ACTORASSEMBLER, new ActorAssembler());
		actorDispatcher = new ThreadActorDispatcher();

		this.init();
	}

	public static EbayClient getInstance() {
		if (instance == null)
			instance = new EbayClient();
		return instance;
	}

	void init() {
		for (Service.Type type : services.keySet()) {
			Service service = services.get(type);
			service.init(this);
		}

		for (Module.Type type : modules.keySet()) {
			Module module = modules.get(type);
			module.init(this);
		}

		actorDispatcher.init(this);
	}

	@Override
	public void pushActor(EbayActor actor) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Module> T getModule(Module.Type type) {
		// TODO Auto-generated method stub
		return (T) modules.get(type);
	}

	@Override
	public <T extends Service> T getSerivce(Service.Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public EbayActorDispatcher getActorDispatcher() {
		return actorDispatcher;
	}
}
