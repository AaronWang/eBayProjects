package ebayClient;

import handler.future.CallBackHandler;

import java.util.HashMap;
import java.util.Map;

import configuration.LoadXmlProperties;
import modules.EbayContextModule;
import modules.StorageBox;
import actor.Actor;
import actor.ActorAssembler;
import actor.ActorDispatcher;
import actor.ThreadActorDispatcher;
import bean.Bean;
import bean.callBean.FetchTokenBean;
import bean.callBean.GetSessionIDBean;
import bean.callBean.GetUserBean;
import core.Module;
import core.Service;
import core.SystemContext;
import ebayApiCall.EbayCallAction;

public class EbayClient implements SystemContext {
	private static EbayClient instance = new EbayClient();

	private Map<Service.Type, Service> services;
	private Map<Module.Type, Module> modules;
	private ActorDispatcher actorDispatcher;

	public EbayClient() {
		// System.out.println("initialize EbayClient ..");
		services = new HashMap<Service.Type, Service>();
		modules = new HashMap<Module.Type, Module>();
		modules.put(Module.Type.EBAYCONTEXT, new EbayContextModule());
		modules.put(Module.Type.ACTORASSEMBLER, new ActorAssembler());
		modules.put(Module.Type.STORAGEBOX, new StorageBox());
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
	public void pushActor(Actor actor) {
		// TODO Auto-generated method stub
		actorDispatcher.pushActor(actor);
	}

	@SuppressWarnings("unchecked")
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

	public void StartAuthentication() {
		pushActor(((ActorAssembler) getModule(Module.Type.ACTORASSEMBLER))
				.createSingleEbayCallActionActor(
						EbayCallAction.ActionNames.GETSESSIONID,
						new GetSessionIDBean(), new CallBackHandler() {

							@Override
							public void handle(Bean bean) {
								// TODO Auto-generated method stub
								((StorageBox) ((EbayClient) systemContext)
										.getModule(Module.Type.STORAGEBOX))
										.setBean("login", bean);
							}
						}));
	}

	public void FinishAuthentication() {
		FetchTokenBean bean = new FetchTokenBean();
		GetSessionIDBean out = (GetSessionIDBean) ((StorageBox) getModule(Module.Type.STORAGEBOX))
				.getBean("login");
		bean.setApiContext(out.getApiContext());
		bean.setSessionID(out.getReturnedSessionID());

		pushActor(((ActorAssembler) getModule(Module.Type.ACTORASSEMBLER))
				.createSingleEbayCallActionActor(
						EbayCallAction.ActionNames.FETCHTOKEN, bean,
						new CallBackHandler() {

							@Override
							public void handle(Bean bean) {
								// TODO Auto-generated method stub

								GetUserBean b = new GetUserBean();
								FetchTokenBean out = (FetchTokenBean) bean;

								b.setApiContext(out.getApiContext());

								pushActor(((ActorAssembler) getModule(Module.Type.ACTORASSEMBLER))
										.createSingleEbayCallActionActor(
												EbayCallAction.ActionNames.GETUSER,
												b, new CallBackHandler() {

													@Override
													public void handle(Bean bean) {
														// TODO Auto-generated
														GetUserBean out = (GetUserBean) bean;
														((EbayContextModule) getModule(Module.Type.EBAYCONTEXT))
																.saveAccount(
																		out.getReturnedUser()
																				.getUserID(),
																		out.getApiContext()
																				.getApiCredential()
																				.geteBayToken());
														// LoadXmlProperties
														// loadXmlProperties =
														// new
														// LoadXmlProperties();
														// loadXmlProperties
														// .saveAccount(
														// out.getReturnedUser()
														// .getUserID(),
														// out.getApiContext()
														// .getApiCredential()
														// .geteBayToken());
													}
												}));
							}
						}));
	}
}
