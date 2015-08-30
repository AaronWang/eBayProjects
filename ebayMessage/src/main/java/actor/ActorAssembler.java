package actor;

import com.ebay.sdk.ApiContext;

import handler.future.CallBackHandler;
import modules.EbayContextModule;
import MultiAction.LoginActions;
import SequenceAction.SequenceActions;
import bean.Bean;
import bean.callBean.EbayCallBean;
import core.Action;
import core.Module;
import core.SystemContext;
import ebayApiCall.CompleteSaleCallAction;
import ebayApiCall.EbayCallAction;
import ebayApiCall.FetchTokenCallAction;
import ebayApiCall.GetCategoriesCallAction;
import ebayApiCall.GetItemCallAction;
import ebayApiCall.GetMyeBaySellingCallAction;
import ebayApiCall.GetOrdersCallAction;
import ebayApiCall.GetSellingManagerSaleRecordCallAction;
import ebayApiCall.GetSellingManagerSoldListingsCallAction;
import ebayApiCall.GetSessionIDCallAction;
import ebayApiCall.GetStoreCallAction;
import ebayApiCall.GetUserCallAction;
import ebayClient.EbayClient;

public class ActorAssembler implements Module {

	private ApiContext getApiContext(String userID) {
		return ((EbayContextModule) EbayClient.getInstance().getModule(Module.Type.EBAYCONTEXT)).getApiContext(userID);
	}

	public Actor createSequenceActionActor(SequenceActions actionName, Bean bean, CallBackHandler handler) {

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

	public Actor createSingleEbayCallActionActor(EbayCallAction.ActionNames actionName, Bean bean, CallBackHandler handler) {
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
			break;
		case GETMYEBAYSELLING:
			newAction = new GetMyeBaySellingCallAction();
			break;
		case GETITEM:
			newAction = new GetItemCallAction();
			break;
		case GETSTORE:
			newAction = new GetStoreCallAction();
			break;
		case GETORDERS:
			newAction = new GetOrdersCallAction();
			break;
		case COMPLETESALE:
			newAction = new CompleteSaleCallAction();
			break;
		case GetSellingManagerSaleRecord:
			newAction = new GetSellingManagerSaleRecordCallAction();
			break;
		case GetSellingManagerSoldListings:
			newAction = new GetSellingManagerSoldListingsCallAction();
			break;
		case GetCategories:
			newAction = new GetCategoriesCallAction();
			break;
		default:
			// newAction = new GetSessionIDCallAction();
			break;
		}

		// ((EbayCallBean) bean).setUserID("");
		if (((EbayCallBean) bean).getApiContext() == null)
			((EbayCallBean) bean).setApiContext(getApiContext(((EbayCallBean) bean).getMyUserID()));

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
