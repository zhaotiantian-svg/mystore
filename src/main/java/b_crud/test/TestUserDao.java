package b_crud.test;

import org.junit.Test;

import b_crud.dao.UserDao;
import b_crud.entity.User;


public class TestUserDao {

	@Test
	public void test() {
		
		UserDao dao = new UserDao();
		dao.addUser1();
		
	}
	
	@Test
	public void test2() {
		
		UserDao dao = new UserDao();
		
		//User user = new User();
		
	}
	
	@Test
	public void test3() {
		UserDao dao = new UserDao();
		dao.delete(1);
		
	}
	
	@Test
	public void test4() {
		UserDao dao = new UserDao();
		dao.findUserById(1);
	}
}
