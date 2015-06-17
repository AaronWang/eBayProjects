package authentication;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetAccountCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.ebay.sdk.call.GetUserCall;

import ebayContext.EbayContext;

public class GetToken {

    static String sessionID;
    static String runame = "Xin_Wang-XinWang0c-6a0c--wyipcandl";
    static String token;
    static boolean tokenSeccess = false;

    public GetToken() {
    }

    public boolean getSessionID() {
        GetSessionIDCall sessionCall = new GetSessionIDCall(
                EbayContext.getApiContext());
        sessionCall.setRuName("Xin_Wang-XinWang0c-6a0c--wyipcandl");
        JOptionPane.showMessageDialog(null, sessionCall.getRuName());

        try {
            sessionID = sessionCall.getSessionID();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "get session id failed");
            return false;
        }
        JOptionPane.showMessageDialog(null, sessionID);
        if (sessionID != null) {
            System.out.println("Got session ID :" + sessionID);
        }
        return true;
    }

    public void openBrowser() {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop()
                : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URI(
                        "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&RUName=Xin_Wang-XinWang0c-6a0c--wyipcandl&SessID="
                        + sessionID));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean getToken() {
        FetchTokenCall getToken = new FetchTokenCall(
                EbayContext.getApiContext());
        getToken.setSessionID(sessionID);
        try {
            token = getToken.fetchToken();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            tokenSeccess = false;
            JOptionPane.showMessageDialog(null, "get token failed");
            return false;
        }
        System.out.println(token);
        JOptionPane.showMessageDialog(null, "get token success");
        tokenSeccess = true;
        EbayContext.getApiContext().getApiCredential().seteBayToken(token);

        GetUserCall getuser = new GetUserCall(EbayContext.getApiContext());

        try {
            getuser.getUser();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        EbayContext.accounts.saveAccount(getuser.getReturnedUser().getUserID(), token);
        return true;
    }
}
