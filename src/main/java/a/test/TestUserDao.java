package a.test;

import org.junit.Test;

import a.dao.UserDao;
import a.entity.User;

public class TestUserDao {

	@Test
	public void test() {
		
		UserDao dao = new UserDao();
		dao.addUser1(); 
		
	}
	
	@Test
	public void test2() {
		UserDao dao = new UserDao();
		
		User user = new User(7, "rose", "rose123", 77.77);
		
		dao.addUser2(user);
		
	}
}
