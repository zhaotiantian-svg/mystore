package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *工具类 
 */
public class MybatisUtil {

	// 在ThreadLocal中重点方法有三个: get() set() remove()
		// 创建局部线程对象,用于和SqlSession绑定
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
	
	//sqlSessionFactory对象
	private static SqlSessionFactory sqlSessionFactory;
	
	// 私有构造
		private MybatisUtil() {
		}

	
	/**
	 * 静态代码块, 加载重量级对象<br>
	 * 就为了获取到sqlSessionFactory对象
	 */
	static {
		try {
			/**
			 * 通过mybatis中的Resources类,加载配置文件到输入流中.
			 */
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			/**
			 * 获取到工厂建造者对象
			 */
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			/**
			 * 获取到工厂对象
			 */
			sqlSessionFactory = builder.build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取到sqlSession对象
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {

		// 首先从局部[当前]线程中获取sqlSession的对象.
		SqlSession sqlSession = threadLocal.get();

		// 如果在当前线程中没有拿到对象
		if (sqlSession == null) {
			// 从sqlSessionFactory中获取对象
			sqlSession = sqlSessionFactory.openSession();
			// 把从sqlSessionFactory对象中获取到的sqlSession对象,绑定到线程中
			threadLocal.set(sqlSession);
		}

		return sqlSession;
	}
	
	/**
	 * 关闭会话
	 */
	public static void closeSqlSession() {
		// 首先获取到当前线程中的sqlSession对象
		SqlSession sqlSession = threadLocal.get();

		// 如果对象非空, 则释放掉
		if (sqlSession != null) {
			sqlSession.close();
			// 把sqlSession对象从当前线程中移除
			threadLocal.remove();
		}
	}
		
}
