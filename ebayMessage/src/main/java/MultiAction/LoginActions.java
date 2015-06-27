package MultiAction;

import handler.future.CallBackHandler;
import actor.Actor;
import actor.ActorAssembler;
import bean.Bean;
import bean.callBean.FetchTokenBean;
import bean.callBean.GetUserBean;
import core.Module;
import ebayApiCall.EbayCallAction;
import ebayClient.EbayClient;

public class LoginActions extends CreateEbayActorAction {

	Actor actor;

	// input GetSessionIDBean
	@Override
	public void initialize(Bean b) {
		// TODO Auto-generated method stub

		actor = ((ActorAssembler) EbayClient.getInstance().getModule(
				Module.Type.ACTORASSEMBLER)).createSingleEbayCallActionActor(
				EbayCallAction.ActionNames.GETSESSIONID, b, new LoginAction1());
	}

	class LoginAction1 extends CallBackHandler {
		// input GetSessionBean
		@Override
		public void handle(Bean bean) {
			// TODO Auto-generated method stub
			// GetSessionIDBean out = (GetSessionIDBean) bean;
			// FetchTokenBean b = new FetchTokenBean();
			//
			// b.setApiContext(out.getApiContext());
			// b.setSessionID(out.getReturnedSessionID());
			//
			// actor = ((ActorAssembler) EbayClient.getInstance().getModule(
			// Module.Type.ACTORASSEMBLER))
			// .createSingleEbayCallActionActor(
			// AbstractEbayCallAction.ActionNames.FETCHTOKEN, b,
			// new LoginAction2());
			// EbayClient.getInstance().getActorDispatcher().pushActor(actor);
		}
	}

	class LoginAction2 extends CallBackHandler {
		// input FetchTokenBean

		@Override
		public void handle(Bean bean) {
			// TODO Auto-generated method stub
			FetchTokenBean out = (FetchTokenBean) bean;
			GetUserBean b = new GetUserBean();

			b.setApiContext(out.getApiContext());

			actor = ((ActorAssembler) EbayClient.getInstance().getModule(
					Module.Type.ACTORASSEMBLER))
					.createSingleEbayCallActionActor(
							EbayCallAction.ActionNames.GETUSER, b,
							new LoginAction3());
			EbayClient.getInstance().pushActor(actor);
		}
	}

	class LoginAction3 extends CallBackHandler {
		// input GetUserBean
		@Override
		public void handle(Bean bean) {
			// TODO Auto-generated method stub
			GetUserBean out = (GetUserBean) bean;

			System.out.println("Token"
					+ out.getApiContext().getApiCredential().geteBayToken());
			System.out.println("userID" + out.getReturnedUser().getUserID());

		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		EbayClient.getInstance().pushActor(actor);
		callBack();
	}

	@Override
	public void callBack() {
		// TODO Auto-generated method stub

	}
}
