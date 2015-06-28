/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import javax.xml.ws.BindingProvider;

/**
 *
 * @author aaron
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try { // Call Web Service Operation
            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService service = new com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService();
            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort port = service.getSellerProfilesManagementServiceHttpPort();
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://svcs.ebay.com/services/selling/v1/SellerProfilesManagementService");
            bp.getRequestContext().put("X-EBAY-SOA-OPERATION-NAME", "getSellerProfiles");

            System.out.println(bp.getRequestContext().toString());
            // TODO initialize WS operation arguments here
            com.ebay.marketplace.selling.v1.services.GetVersionRequest params = new com.ebay.marketplace.selling.v1.services.GetVersionRequest();
            // TODO process result here
            com.ebay.marketplace.selling.v1.services.GetVersionResponse result = port.getVersion(params);

            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            System.out.println(ex.toString());
        }

        try { // Call Web Service Operation
            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService service = new com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService();
            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort port = service.getSellerProfilesManagementServiceSOAPPort();
            // TODO initialize WS operation arguments here
            com.ebay.marketplace.selling.v1.services.GetVersionRequest params = new com.ebay.marketplace.selling.v1.services.GetVersionRequest();

            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://svcs.ebay.com/services/selling/v1/SellerProfilesManagementService");

            // TODO process result here
            com.ebay.marketplace.selling.v1.services.GetVersionResponse result = port.getVersion(params);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            System.out.println("failed!!!!");
            System.out.println(ex.toString());
        }

    }

}
