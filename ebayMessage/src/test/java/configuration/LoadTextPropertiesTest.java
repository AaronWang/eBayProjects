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
		System.out.println("loadAccounts");
		LoadTextProperties instance = new LoadTextProperties();
		instance.loadAccounts();
		// TODO review the generated test code and remove the default call to
		// fail.
		ArrayList<Account> accounts = instance.getAccounts();
		assertNotNull(accounts.get(0).getName());
		assertNotNull(accounts.get(1).getToken());
		assertNotNull(accounts.get(2).getName());
		assertNotNull(accounts.get(3).getToken());
		// fail("The test case is a prototype.");
	}

	/**
	 * Test of getAccounts method, of class LoadTextProperties.
	 */
	@Test
	public void testGetAccounts() {
		System.out.println("getAccounts");
		LoadTextProperties instance = new LoadTextProperties();
		ArrayList<Account> expResult = null;
		ArrayList<Account> result = instance.getAccounts();

		assertNotSame(expResult, result);
		// assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");
	}

	/**
	 * Test of getToken method, of class LoadTextProperties.
	 */
	@Test
	public void testGetToken() {
		System.out.println("getToken");
		String account = "aaa";
		LoadTextProperties instance = new LoadTextProperties();
		String expResult = "b";
		String result = instance.getToken(account);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");
	}

	/**
	 * Test of saveAccount method, of class LoadTextProperties.
	 */
	@Test
	public void testSaveAccount() {
		System.out.println("saveAccount");
		String userID = "aaa";
		String token = "b";
		LoadTextProperties instance = new LoadTextProperties();
		instance.saveAccount(userID, token);
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");
	}

	/**
	 * Test of IsExsit method, of class LoadTextProperties.
	 */
	@Test
	public void testIsExsit() {
		System.out.println("IsExsit");
		String account = "aaa";
		LoadTextProperties instance = new LoadTextProperties();
		boolean expResult = true;
		boolean result = instance.isExsit(account);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");
	}

	@Test
	public void testRemoveAccount() {
		System.out.println("removeAccount");
		String account = "aaa";
		LoadTextProperties instance = new LoadTextProperties();
		boolean expResult = true;
		boolean result = instance.isExsit(account);
		instance.removeAccount(account);
		assertNull(instance.getToken(account));
		// TODO review the generated test code and remove the default call to
		// fail.
		// fail("The test case is a prototype.");
	}
}
