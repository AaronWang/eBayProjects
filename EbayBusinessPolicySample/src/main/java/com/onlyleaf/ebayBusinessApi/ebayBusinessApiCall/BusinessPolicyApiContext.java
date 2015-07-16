/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlyleaf.ebayBusinessApi.ebayBusinessApiCall;

/**
 *
 * @author aaron
 */
public class BusinessPolicyApiContext {

    private String content_type = null;
    private String global_id = "EBAY-AU";// enum EBAY-AU / EBAY-US
    private String message_encoding = "UTF-8";
    private String message_protocol = "SOAP11";
    private String service_name = "SellerProfilesManagementService";
    private String operation_name = null;
    private String request_data_format = null;
    private String response_data_format = null;
    private String security_token = null;
    private String service_version = null;

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getGlobal_id() {
        return global_id;
    }

    public void setGlobal_id(String global_id) {
        this.global_id = global_id;
    }

    public String getMessage_encoding() {
        return message_encoding;
    }

    public void setMessage_encoding(String message_encoding) {
        this.message_encoding = message_encoding;
    }

    public String getMessage_protocol() {
        return message_protocol;
    }

    public void setMessage_protocol(String message_protocol) {
        this.message_protocol = message_protocol;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getOperation_name() {
        return operation_name;
    }

    public void setOperation_name(String operation_name) {
        this.operation_name = operation_name;
    }

    public String getRequest_data_format() {
        return request_data_format;
    }

    public void setRequest_data_format(String request_data_format) {
        this.request_data_format = request_data_format;
    }

    public String getResponse_data_format() {
        return response_data_format;
    }

    public void setResponse_data_format(String response_data_format) {
        this.response_data_format = response_data_format;
    }

    public String getSecurity_token() {
        return security_token;
    }

    public void setSecurity_token(String security_token) {
        this.security_token = security_token;
    }

    public String getService_version() {
        return service_version;
    }

    public void setService_version(String service_version) {
        this.service_version = service_version;
    }

}
