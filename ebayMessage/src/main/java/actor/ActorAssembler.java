package actor;

import handler.future.CallBackHandler;
import modules.EbayContextModule;
import MultiAction.LoginActions;
import SequenceAction.SequenceActions;
import bean.Bean;
import bean.callBean.EbayCallBean;

import com.ebay.sdk.ApiContext;

import core.Action;
import core.Module;
import core.SystemContext;
import ebayApiCall.EbayCallAction;
import ebayApiCall.FetchTokenCallAction;
import ebayApiCall.GetSessionIDCallAction;
import ebayApiCall.GetUserCallAction;
import ebayClient.EbayClient;

public class ActorAssembler implements Module {

	private ApiContext getApiContext(String userID) {
		return ((EbayContextModule) EbayClient.getInstance().getModule(
				Module.Type.EBAYCONTEXT)).getApiContext(userID);
	}

	public Actor createSequenceActionActor(SequenceActions actionName,
			Bean bean, CallBackHandler handler) {

		SequenceActionActor actor = new SequenceActionActor();

		Action newAction = null;

		switch (actionName) {
		case LOGIN:
			newAction = new LoginActions();
			break;
		default:
			// newAction = new GetSessionIDCallAction();
			break;
		}

		newAction.initialize(bean);
		// newAction.getCallBackListener().addEbayCallBackHandler(handler);
		actor.setAction(newAction);
		return actor;
	}

	public Actor createSingleEbayCallActionActor(
			EbayCallAction.ActionNames actionName, Bean bean,
			CallBackHandler handler) {
		SingleActionActor actor = new SingleActionActor();
		EbayCallAction newAction = null;

		switch (actionName) {
		case GETSESSIONID:
			newAction = new GetSessionIDCallAction();
			break;
		case FETCHTOKEN:
			newAction = new FetchTokenCallAction();
			break;
		case GETUSER:
			newAction = new GetUserCallAction();
		default:
			// newAction = new GetSessionIDCallAction();
			break;
		}

		// ((EbayCallBean) bean).setUserID("");
		if (((EbayCallBean) bean).getApiContext() == null)
			((EbayCallBean) bean)
					.setApiContext(getApiContext(((EbayCallBean) bean)
							.getUserID()));
		
		newAction.initialize(bean);
		newAction.getCallBackListener().addEbayCallBackHandler(handler);
		actor.setAction(newAction);
		return actor;
	}

	@Override
	public void init(SystemContext systemContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
