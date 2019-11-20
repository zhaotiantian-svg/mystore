package a.dao;

import org.apache.ibatis.session.SqlSession;

import a.entity.User;
import util.MybatisUtil;

public class UserDao {
	public void addUser1() {
		SqlSession sqlSession = null;

		try {
			/**
			 * ��ȡ��sqlSession����, Ĭ���ǿ��������.
			 */
			sqlSession = MybatisUtil.getSqlSession();

			// sqlSession.insert("insert into user values (4,'tom','tom123',44.44)");

			/**
			 * ����insert����ʱ, ���洫��Ĳ���Ϊ: mapper�е�namespace + insert��ǩ�е�idֵ
			 */
			int line = sqlSession.insert("com.ztt.a.entity.User.addUser1");
			System.out.println("Ӱ���� " + line + " ��");

			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * ��������쳣, ��ع�
			 */
			sqlSession.rollback();
		} finally {
			/**
			 * �رջỰ
			 */
			MybatisUtil.closeSqlSession();
		}
	}
	
	public void addUser2(User user) {
		SqlSession sqlSession = null;

		try {
			/**
			 * ��ȡ��sqlSession����, Ĭ���ǿ��������.
			 */
			sqlSession = MybatisUtil.getSqlSession();

			// sqlSession.insert("insert into user values (4,'tom','tom123',44.44)");

			/**
			 * ����insert����ʱ, ���洫��Ĳ���Ϊ: mapper�е�namespace + insert��ǩ�е�idֵ
			 */
			int line = sqlSession.insert("com.ztt.a.entity.User.addUser2", user);
			System.out.println("Ӱ���� " + line + " ��");

			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();

			/**
			 * ��������쳣, ��ع�
			 */
			sqlSession.rollback();
		} finally {
			/**
			 * �رջỰ
			 */
			MybatisUtil.closeSqlSession();
		}
	}

}
