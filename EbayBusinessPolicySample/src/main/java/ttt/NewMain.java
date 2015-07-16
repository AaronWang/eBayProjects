/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import com.sun.xml.internal.ws.api.message.Headers;
import com.sun.xml.internal.ws.developer.WSBindingProvider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

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
            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort port = service.getSellerProfilesManagementServiceSOAPPort();
            // TODO initialize WS operation arguments here
            com.ebay.marketplace.selling.v1.services.GetVersionRequest params = new com.ebay.marketplace.selling.v1.services.GetVersionRequest();

//            System.out.println("request params :"+params.toString());
            BindingProvider bp = (BindingProvider) port;

            WSBindingProvider wsBP = (WSBindingProvider) port;

            ((WSBindingProvider) port).setOutboundHeaders(Headers.create(new QName("", "X-EBAY-SOA-OPERATION-NAME"), "getVersion"));
//            ((WSBindingProvider) port).setOutboundHeaders(Headers.create(new QName("X-EBAY-SOA-GLOBAL-ID"),"EBAY-AU"));
//            ((WSBindingProvider) port).setOutboundHeaders(Headers.create(new QName("X-EBAY-SOA-SERVICE-NAME"),"SellerProfilesManagementService"));

//            System.out.println(((WSBindingProvider) port).toString());
            bp.getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://svcs.ebay.com/services/selling/v1/SellerProfilesManagementService");

            // TODO process result here
            com.ebay.marketplace.selling.v1.services.GetVersionResponse result = port.getVersion(params);
            System.out.println("Result = " + result);
            System.out.println("?????????????????????Result = " + result.toString());
            System.out.println("?????????????????????Result = " + result.getVersion());
            System.out.println("Result ack= " + result.getAck());
            System.out.println("Result error message = " + result.getErrorMessage());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
//			System.out.println("failed!!!!");
//			System.out.println(ex.toString());
        }

        try { // Call Web Service Operation
            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService service = new com.ebay.marketplace.selling.v1.services.SellerProfilesManagementService();
            service.setHandlerResolver(new HeaderHandlerResolver());

            com.ebay.marketplace.selling.v1.services.SellerProfilesManagementServicePort port = service.getSellerProfilesManagementServiceSOAPPort();
            // TODO initialize WS operation arguments here
            com.ebay.marketplace.selling.v1.services.GetSellerProfilesRequest params = new com.ebay.marketplace.selling.v1.services.GetSellerProfilesRequest();

            String token = "AgAAAA**AQAAAA**aAAAAA**5S+JVQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AHl4eoAJSApw+dj6x9nY+seQ**44YCAA**AAMAAA**bsbgf2dlnMfZsCeklbkTP9Krp7Jia56BUhpo3K40o1d2fa/drZdtRLVCyM97/R83xGPZwkhhLx4Y79whLPUuHZcYgv48+Nw6YOnrVvI86lqdspmQa+g3P7GNL+mc+tBkBl/UusR/OpQSOie9ANWocRZJmO0kKI6j9ZPiZuRw4oLjv/L6jY8WCdDMnqxPSjAYWjWR82qfEcOJF4Fh1YfJK+/Xsu3ZRVLzE3OZdbsN4Jj0oL8sezjRLUNlmgxtFkaD3JNHULQu/LuzrgnJAX7pl/CN3Pk7DOYy6n9nFtm9iWDZQ4o/3wK2lR8jUYbk4OBTcaRr8aCrwn0xGmqGOWASv1AH+J+td2PdA2Hobi+KdBnYHlZtFdWjg2WHx2wGmQ7ByHq3C8KeufCnHpn6YGaZjMJGh32jMeetxjsjMNYLQjCALFKwgzMNUVM4xT/nyvykyAmyf63DLOWxBj5Jdz3xiRAW4y62Xo6ZdpzunmCm4faFO2SvrA8pk2hL/NeFv6ZCv23BuG+IOU3Uk8JtRrsBYoaH3qN4Zux1m66YT8YViFYKuct6HZje645DD2iYV9ZT6bDNWmfkUFmVIJ/QgmKDflHEd31dTjwFyNPNPToBcULgocvMeX3uAs8f6Y2Y1HyM9jQk/WznvHcBqPxzxSmBt2OS4Fzoe2Nb8qQS+NgxwhpQensJt9j4BB7F49qnYDuVDQV4xurJI9kMNzlYQvK35KuFLd8NMompnRqUmVoZr8tSPJplUolPmeNgRKqDiG38";
            BindingProvider bp = (BindingProvider) port;
//            bp.getRequestContext();
//            WSBindingProvider wsBP = (WSBindingProvider) port;

//            ((WSBindingProvider) port).setOutboundHeaders(Headers.create(new QName("http://www.ebay.com/marketplace/selling/v1/services", "X-EBAY-SOA-OPERATION-NAME"), "getSellerProfiles"));
            Map<String, List<String>> requestHeaders = new HashMap<>();
            requestHeaders.put("X-EBAY-SOA-OPERATION-NAME", Arrays.asList("getSellerProfiles"));
            requestHeaders.put("X-EBAY-SOA-SECURITY-TOKEN", Arrays.asList(token));
            requestHeaders.put("X-EBAY-SOA-GLOBAL-ID", Arrays.asList("EBAY-AU"));

            bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);

            bp.getRequestContext().put(
                    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                    "https://svcs.ebay.com/services/selling/v1/SellerProfilesManagementService"
            );
            // TODO process result here
            params.setIncludeDetails(Boolean.TRUE);
            com.ebay.marketplace.selling.v1.services.GetSellerProfilesResponse result = port.getSellerProfiles(params);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            System.out.println(ex.toString());
        }
    }

}
