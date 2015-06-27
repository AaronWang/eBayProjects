package handler.future;

import bean.Bean;
import bean.callBean.FetchTokenBean;

public class DefaultFetchTokenCallHandler extends CallBackHandler {

	@Override
	public void handle(Bean bean) {
		// TODO Auto-generated method stub
		FetchTokenBean b = (FetchTokenBean) bean;
		b.getApiContext().getApiCredential().seteBayToken(b.getReturnedToken());
		System.out.println("Default FetchTokenCallHandler : "
				+ b.getReturnedToken());
	}
}
