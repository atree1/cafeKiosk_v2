package org.zerock.test;

import org.junit.Test;
import org.zerock.dao.StoreDAO;

public class CafeTest {
	@Test
	public void getStore() {
		System.out.println(new StoreDAO().getStore(1));
	}
}
