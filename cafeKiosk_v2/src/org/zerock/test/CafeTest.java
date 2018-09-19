package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.StoreDAO;

public class CafeTest {
	@Test
	public void getStore() {
		new StoreDAO().getStore(1);
	}
}
