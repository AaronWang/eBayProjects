package configuration;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoadXmlPropertiesTest {

	@Test
	public void testLoadAccounts() {
		LoadXmlProperties instance = new LoadXmlProperties();
		instance.loadAccounts();
		assertEquals(instance.getAccounts().get(0).getName(), "aaa");
		assertEquals(instance.getAccounts().get(0).getToken(), "bbb");
		// fail("Not yet implemented");
	}

	@Test
	public void testGetAccounts() {
		LoadXmlProperties instance = new LoadXmlProperties();

		// fail("Not yet implemented");
	}

	@Test
	public void testGetToken() {
		LoadXmlProperties instance = new LoadXmlProperties();
		assertEquals(instance.getToken("aaa"), "bbb");
		// fail("Not yet implemented");
	}

	@Test
	public void testIsExsit() {
		LoadXmlProperties instance = new LoadXmlProperties();

		assertNotNull(instance.isExsit("aaa"));

		// fail("Not yet implemented");
	}

	@Test
	public void testSaveAccount() {
		LoadXmlProperties instance = new LoadXmlProperties();

		instance.saveAccount("ssssss", "gggsssggggggggggaaaa");
		// fail("Not yet implemented");
	}

	@Test
	public void testRemoveAccount() {
		LoadXmlProperties instance = new LoadXmlProperties();

		instance.removeAccount("sss");
		// fail("Not yet implemented");
	}
}
