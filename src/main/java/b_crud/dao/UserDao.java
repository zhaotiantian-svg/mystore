package b_crud.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import b_crud.entity.User;
import util.MybatisUtil;

public class UserDao {

	public void addUser1() {

		SqlSession sqlSession = null;
		try {

			/**
			 * ��ȡ��sqlSession����,Ĭ���ǿ��������
			 */
			sqlSession = MybatisUtil.getSqlSession();

			/**
			 * ���÷���ʱ,���洫��Ĳ���Ϊ:mapper�е�namespace+insert��ǩ�е�idֵ
			 * 
			 */
			int line = sqlSession.insert("b_crud.entity.User.addUser1");
			System.out.println("Ӱ���� " + line + " ��");

			/**
			 * һ��Ҫ�ύ����
			 */

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * ��������쳣,��ع�
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
			 * ��ȡ��sqlSession����,Ĭ���ǿ��������
			 */
			sqlSession = MybatisUtil.getSqlSession();

			/**
			 * ���÷���ʱ,���洫��Ĳ���Ϊ:mapper�е�namespace+insert��ǩ�е�idֵ
			 * 
			 */
			int line = sqlSession.insert("b_crud.entity.User.addUser2", user);
			System.out.println("Ӱ����" + line + "��");

			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * �������쳣,��ع�
			 */
			sqlSession.rollback();
		} finally {

			/**
			 * �رջỰ
			 */
			MybatisUtil.closeSqlSession();
		}

	}

	public void updateUser(User user) {

		SqlSession sqlSession = null;

		try {
			/**
			 * ��ȡ��sqlSession����,Ĭ���ǿ��������
			 */
			sqlSession = MybatisUtil.getSqlSession();

			int line = sqlSession.update(User.class.getName() + ".updateUser", user);
			System.out.println("Ӱ����" + line + "��");
			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * ��������쳣,��ع�
			 */
			sqlSession.rollback();
		} finally {

			/**
			 * �رջỰ
			 */
			MybatisUtil.closeSqlSession();

		}

	}

	public void delete(int id) {

		SqlSession sqlSession = null;

		try {
			/**
			 * ��ȡ��sqlSession����
			 */
			sqlSession = MybatisUtil.getSqlSession();

			int line = sqlSession.delete(User.class.getName() + ".deleteUser", id);
			System.out.println("Ӱ����" + line + "��");

			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * ��������쳣,��ع�
			 * 
			 */
			sqlSession.rollback();
		} finally {
			/**
			 * �رջỰ
			 */
			MybatisUtil.closeSqlSession();

		}

	}

	public User findUserById(int id) {

		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();

			User user = sqlSession.selectOne(User.class.getName() + "findUserById", id);

			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();
		
			return user;
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

		return null;
	}

	public List<User> findAllUser() {
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
			List<User> list = sqlSession.selectList(User.class.getName() + ".findAllUser");

			/**
			 * һ��Ҫ�ύ����
			 */
			sqlSession.commit();

			return list;
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

		return null;
	}
	
}
