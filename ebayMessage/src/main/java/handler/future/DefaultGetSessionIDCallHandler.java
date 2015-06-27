package handler.future;

import java.awt.Desktop;
import java.net.URI;

import bean.Bean;
import bean.callBean.GetSessionIDBean;

public class DefaultGetSessionIDCallHandler extends CallBackHandler {

	@Override
	public void handle(Bean bean) {
		// TODO Auto-generated method stub
		GetSessionIDBean b = (GetSessionIDBean) bean;

		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop()
				: null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(new URI(
						"https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&RUName="
								+ b.getRuName() + "&SessID="
								+ b.getReturnedSessionID()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Default GetSessionIDCallHandler : "
				+ b.getReturnedSessionID());
	}
}
