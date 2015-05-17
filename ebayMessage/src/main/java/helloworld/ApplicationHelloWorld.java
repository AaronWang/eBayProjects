/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
 */

package helloworld;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.ebay.sdk.call.GetUserCall;

/**
 * A Hello World-like sample, showing how to call eBay API using eBay SDK.
 * 
 * @author boyang
 *
 */
public class ApplicationHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			System.out.print("\n");
			System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
			System.out.print("+ Welcome to eBay SDK for Java Sample +\n");
			System.out.print("+  - HelloWorld                   +\n");
			System.out.print("+++++++++++++++++++++++++++++++++++++++\n");
			System.out.print("\n");

			// [Step 1] Initialize eBay ApiContext object
			System.out.println("===== [1] Account Information ====");
			ApiContext apiContext = getApiContext();

			// [Step 2] Create call object and execute the call
			// GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(
			// apiContext);
			// apiCall.geteBayOfficialTime();
			// System.out.println("Begin to call eBay API, please wait ... "+apiCall.getRequestXml());

			// Calendar cal = apiCall.geteBayOfficialTime();
			// System.out.println("End to call eBay API, show call result ...");
			// System.out.println("Official eBay Time : "
			// + cal.getTime().toString());
			// System.out.println();

			GetSessionIDCall sessionCall = new GetSessionIDCall(apiContext);
			sessionCall.setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");

			String sessionID = sessionCall.getSessionID();
			if (sessionID != null)
				System.out.println(sessionID);

			Desktop desktop = Desktop.isDesktopSupported() ? Desktop
					.getDesktop() : null;
			if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				try {
					desktop.browse(new URI(
							"https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&RUName=Xin_Wang-XinWang0c-6a0c--wyipcandl&SessID="
									+ sessionID));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			FetchTokenCall getToken = new FetchTokenCall(apiContext);
			getToken.setSessionID(sessionID);
			System.out.println(getToken.fetchToken());
			GetUserCall userCall = new GetUserCall(apiContext);
			// userCall.setUserID("TESTUSER_aarontest");
			// userCall.setUserID("angelahurry");
			// userCall.setUserID("tes.au5");
			// UserType userType = userCall.getUser();
			// System.out.println("A selection of data from the call:");
			// System.out.println("    In good standing: "
			// + userType.isEBayGoodStanding().toString());
			// System.out.println("    Email: " + userType.getEmail());
			// System.out.println("    Positive feedback: "
			// + userType.getPositiveFeedbackPercent().toString() + "%");
			// System.out.println("    Registration date: "
			// + userType.getRegistrationDate().getTime().toString());
			
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			e.printStackTrace();
		}
	}

	/**
	 * Populate eBay SDK ApiContext object with data input from user
	 * 
	 * @return ApiContext object
	 */
	private static ApiContext getApiContext() throws IOException {

		String input;
		ApiContext apiContext = new ApiContext();

		// set Api Token to access eBay Api Server
		ApiCredential cred = apiContext.getApiCredential();
		// input =
		// ConsoleUtil.readString("Enter your eBay Authentication Token: ");

		// sandbox
		// input =
		// "AgAAAA**AQAAAA**aAAAAA**xLtMVA**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhDJiLpQ2dj6x9nY+seQ**9hMDAA**AAMAAA**WFfQiChb6ABX7wrJdsOPkxvCbmdvIIJbFDj7aJVa6qcz9wNYzv3OOOIv3QmdstSGnN/b7IwaykBrvHcJDD7C3Z0ao/9t7tYFDlwSHX6KNLjPLstQ+7Mk81YUtgrTjWsCwQt/bvc++sk1b4oXGDzkoft05mdVD0UWvbIXew2VztEWfvYLN0FZZhiy22NJ0MvYevSCDakvml6gaNPB+x8zeK86xrE/fBC/Y9unQMe3FlMTqpUcVmi3oChogr/gH/Nap7mWbize22YHXIy//eQ3kFbEvMiR4ilhKT0PfnEsjCVeOAhd34zCPbThwd0EXhS5sQas9WARAbWue5XEKb+XnPnF7CFSY8COmgU7C43VZUr5E16uZD7cblCBFbQceICpAlBoZjhUMx9tTnlS6CxFvt0vPhf6uPqkWdXAACbkSTKqmbJmAf+84YzBfZYVFGeBUAEk+0F3qn0oFZ1VZZlh/AbI8PVrAKayThsx1fGj+eOP0iApCzlYXlnTX1kPyhYQIGjVJO5SJ3UtplUoRiOUd8/j6ZCQ5mOAHHhUTj+B8I+f4dR+K3TZgB5iUt8Yoqn2OyoVcE8xGGFJcCoYlNZd4BjqS/BwFsEVUDnByIaP9cStGxseGam6WNbHWonXN5qXyyeNvDxWH0wlU0jK7RYrTlwwjIexE6s1W8Za8+duNsihgSjqmjt1bIjknjig1DxqktD3WKzPSfXZsMlQkR72a+HVPUbOW+n8WyUK3bHUtGLzMoVbOjgIBfkXb0uITsIH";
		// pruduction
		// ebaytestusera
		// input =
		// "AgAAAA**AQAAAA**aAAAAA**kihcVA**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AGmYaiAJKFogudj6x9nY+seQ**44YCAA**AAMAAA**rE7v/45vp8q3SzYkG83nEpwt9aa9ne5UDa5OgXslsCCKuVjUjmMO2/6gDuWEVn9tdSXLzzEmLOEI/pHe3XVdpUomA5LxUIaEsdXoamSsnpDnBOjX4Xk0MwdGC13f+MlbUPO3yLMV/Y0vy2Y/Bqhlw4L3lHM0eAjz/NVbrxhOHHwMFTp7wjqkXBSpLwEu5vCLwG0cAta6GWzgJs8kDgQTlQSgM+/UoH77Bvv4gEJFxFTDgD8tLZJB4+KIQNUvpZYJ7reXRK2i+TxfMb26XND4Vj2Guv2sXD0NmZU8w62ktZ7ZoDLDi0NcuZLpch0oeiNHmREw4tW7IrCRjBeD4HxjghwallPXmaJCwpkLVIPL1mUd4bvFZ5bbvz9xKCGOOrIKYHQA8EBkir/Q+yqCF5graTveVh0wt3tRAdL1/Ah0DKBAY3sHkoHEn067bLKVV/Ph7hRufFS6kqvQglBW3P5QFwHs8t/NKx/iwZ+Tsoh6h0C5BoAgHIG2wawlUde33uGTtHKKDsHPRFYPte5EuB1x+PvxGMJdUy6Y6mbeLnp7kvKAAWwdxOQA/C6AaXNiYaE1l3vvLrzVbpyTFEnQzCE/K8undctzNa3eIYAVEuNsHrPa8K7TirKxVaq5Z4QBwetpo/AENKTaurqLuVlmt5IW7yfB88rgNgGkiTgMm4GBxDpWjgUNbUC7g/Icd06ZzCnaQH2NY6nEvTVIfHY6TNiqqV7h4nhNfns2/skgNcesfkLO7rB3ggKvZwoE8454t3Pd";
		// cred.seteBayToken(input);

		Properties keys = new Properties();
		try {
			keys.load(new FileInputStream("keys.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}
		// set devId, appId, certId in ApiAccount
		ApiAccount account = new ApiAccount();
		account.setDeveloper(keys.getProperty("devId"));
		account.setApplication(keys.getProperty("appId"));
		account.setCertificate(keys.getProperty("certId"));
		cred.setApiAccount(account);

		// set Api Server Url
		// input =
		// ConsoleUtil.readString("Enter eBay SOAP server URL (e.g., https://api.sandbox.ebay.com/wsapi): ");
		// input = "https://api.sandbox.ebay.com/wsapi";

		input = "https://api.ebay.com/wsapi";
		apiContext.setApiServerUrl(input);

		return apiContext;
	}

	private void setToken(ApiContext apiContext, String token) {
		// set Api Token to access eBay Api Server
		ApiCredential cred = apiContext.getApiCredential();
		// input =
		// ConsoleUtil.readString("Enter your eBay Authentication Token: ");

		// sandbox
		// input =
		// "AgAAAA**AQAAAA**aAAAAA**xLtMVA**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhDJiLpQ2dj6x9nY+seQ**9hMDAA**AAMAAA**WFfQiChb6ABX7wrJdsOPkxvCbmdvIIJbFDj7aJVa6qcz9wNYzv3OOOIv3QmdstSGnN/b7IwaykBrvHcJDD7C3Z0ao/9t7tYFDlwSHX6KNLjPLstQ+7Mk81YUtgrTjWsCwQt/bvc++sk1b4oXGDzkoft05mdVD0UWvbIXew2VztEWfvYLN0FZZhiy22NJ0MvYevSCDakvml6gaNPB+x8zeK86xrE/fBC/Y9unQMe3FlMTqpUcVmi3oChogr/gH/Nap7mWbize22YHXIy//eQ3kFbEvMiR4ilhKT0PfnEsjCVeOAhd34zCPbThwd0EXhS5sQas9WARAbWue5XEKb+XnPnF7CFSY8COmgU7C43VZUr5E16uZD7cblCBFbQceICpAlBoZjhUMx9tTnlS6CxFvt0vPhf6uPqkWdXAACbkSTKqmbJmAf+84YzBfZYVFGeBUAEk+0F3qn0oFZ1VZZlh/AbI8PVrAKayThsx1fGj+eOP0iApCzlYXlnTX1kPyhYQIGjVJO5SJ3UtplUoRiOUd8/j6ZCQ5mOAHHhUTj+B8I+f4dR+K3TZgB5iUt8Yoqn2OyoVcE8xGGFJcCoYlNZd4BjqS/BwFsEVUDnByIaP9cStGxseGam6WNbHWonXN5qXyyeNvDxWH0wlU0jK7RYrTlwwjIexE6s1W8Za8+duNsihgSjqmjt1bIjknjig1DxqktD3WKzPSfXZsMlQkR72a+HVPUbOW+n8WyUK3bHUtGLzMoVbOjgIBfkXb0uITsIH";
		// pruduction
		// ebaytestusera
		String input = token;
		cred.seteBayToken(input);
	}
}
