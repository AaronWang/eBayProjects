/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import bean.Account;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aaron
 */
public class LoadTextPropertiesTest {

	/**
	 * Test of loadAccounts method, of class LoadTextProperties.
	 */
	@Test
	public void testLoadAccounts() {
	}

	/**
	 * Test of getAccounts method, of class LoadTextProperties.
	 */
	@Test
	public void testGetAccounts() {
		System.out.println("getAccounts");
		LoadTextProperties instance = new LoadTextProperties();
		ArrayList<Account> expResult = null;
		//
		// assertNotSame(expResult, result);
		// assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");
	}
}
