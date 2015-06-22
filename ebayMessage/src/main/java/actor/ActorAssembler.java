package actor;

import moduals.EbayContextModule;

import com.ebay.sdk.ApiContext;

import core.CallAction;
import core.Module;
import core.SystemContext;
import bean.callInputBean.AddDisputeBean;
import bean.callInputBean.FetchTokenBean;
import bean.callInputBean.GetSessionIDBean;
import ebayApiCall.GetSessionIDCallAction;
import ebayClient.EbayClient;
import exception.EbayException;

public class ActorAssembler implements Module {
	// public static ActorAssembler instance = new ActorAssembler();
	//
	// public static ActorAssembler getInstance() {
	// if (instance == null)
	// instance = new ActorAssembler();
	// return instance;
	// }

	private ApiContext getApiContext(String userID) {
		return ((EbayContextModule) EbayClient.getInstance().getModule(
				Module.Type.EBAYCONTEXT)).getApiContext(userID);
	}

	public EbayActor createGetSessionIDActor(GetSessionIDBean bean,
			String userID) {
		GetSessionIDCallAction newAction = new GetSessionIDCallAction();
		newAction.initialize(bean, getApiContext(userID));
		EbayCallActor actor = new EbayCallActor();
		actor.setAction(newAction);
		actor.despatch();
		return actor;
	}

	public EbayActor createFetchTokenActor(FetchTokenBean bean, String userID) {
		GetSessionIDCallAction newAction = new GetSessionIDCallAction();
		newAction.initialize(bean, getApiContext(userID));
		EbayCallActor actor = new EbayCallActor();
		actor.setAction(newAction);
		return actor;
	}

	public EbayActor createAddDisputActor(AddDisputeBean bean, String userID) {
		GetSessionIDCallAction newAction = new GetSessionIDCallAction();
		newAction.initialize(bean, getApiContext(userID));
		EbayCallActor actor = new EbayCallActor();
		actor.setAction(newAction);
		return actor;
	}

	@Override
	public void init(SystemContext systemContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() throws EbayException {
		// TODO Auto-generated method stub

	}
}
