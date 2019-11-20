package a.dao;

import org.apache.ibatis.session.SqlSession;

import a.entity.User;
import util.MybatisUtil;

public class UserDao {
	public void addUser1() {
		SqlSession sqlSession = null;

		try {
			/**
			 * 获取到sqlSession对象, 默认是开启事务的.
			 */
			sqlSession = MybatisUtil.getSqlSession();

			// sqlSession.insert("insert into user values (4,'tom','tom123',44.44)");

			/**
			 * 调用insert方法时, 里面传入的参数为: mapper中的namespace + insert标签中的id值
			 */
			int line = sqlSession.insert("com.ztt.a.entity.User.addUser1");
			System.out.println("影响了 " + line + " 行");

			/**
			 * 一定要提交事务
			 */
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * 如果遇到异常, 则回滚
			 */
			sqlSession.rollback();
		} finally {
			/**
			 * 关闭会话
			 */
			MybatisUtil.closeSqlSession();
		}
	}
	
	public void addUser2(User user) {
		SqlSession sqlSession = null;

		try {
			/**
			 * 获取到sqlSession对象, 默认是开启事务的.
			 */
			sqlSession = MybatisUtil.getSqlSession();

			// sqlSession.insert("insert into user values (4,'tom','tom123',44.44)");

			/**
			 * 调用insert方法时, 里面传入的参数为: mapper中的namespace + insert标签中的id值
			 */
			int line = sqlSession.insert("com.ztt.a.entity.User.addUser2", user);
			System.out.println("影响了 " + line + " 行");

			/**
			 * 一定要提交事务
			 */
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * 如果遇到异常, 则回滚
			 */
			sqlSession.rollback();
		} finally {
			/**
			 * 关闭会话
			 */
			MybatisUtil.closeSqlSession();
		}
	}

}
