package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *������ 
 */
public class MybatisUtil {

	// ��ThreadLocal���ص㷽��������: get() set() remove()
		// �����ֲ��̶߳���,���ں�SqlSession��
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
	
	//sqlSessionFactory����
	private static SqlSessionFactory sqlSessionFactory;
	
	// ˽�й���
		private MybatisUtil() {
		}

	
	/**
	 * ��̬�����, ��������������<br>
	 * ��Ϊ�˻�ȡ��sqlSessionFactory����
	 */
	static {
		try {
			/**
			 * ͨ��mybatis�е�Resources��,���������ļ�����������.
			 */
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			/**
			 * ��ȡ�����������߶���
			 */
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			/**
			 * ��ȡ����������
			 */
			sqlSessionFactory = builder.build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ��sqlSession����
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {

		// ���ȴӾֲ�[��ǰ]�߳��л�ȡsqlSession�Ķ���.
		SqlSession sqlSession = threadLocal.get();

		// ����ڵ�ǰ�߳���û���õ�����
		if (sqlSession == null) {
			// ��sqlSessionFactory�л�ȡ����
			sqlSession = sqlSessionFactory.openSession();
			// �Ѵ�sqlSessionFactory�����л�ȡ����sqlSession����,�󶨵��߳���
			threadLocal.set(sqlSession);
		}

		return sqlSession;
	}
	
	/**
	 * �رջỰ
	 */
	public static void closeSqlSession() {
		// ���Ȼ�ȡ����ǰ�߳��е�sqlSession����
		SqlSession sqlSession = threadLocal.get();

		// �������ǿ�, ���ͷŵ�
		if (sqlSession != null) {
			sqlSession.close();
			// ��sqlSession����ӵ�ǰ�߳����Ƴ�
			threadLocal.remove();
		}
	}
		
}
