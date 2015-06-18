package core;

import com.ebay.sdk.ApiCall;

import exception.EbayException;

public interface CallAction {
	public void init();

	public void excecute() throws Exception;

	public void callBack();
	
}
