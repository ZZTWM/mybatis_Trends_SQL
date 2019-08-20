package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Product;
/**
 * for each ±Í«©
 * @author Administrator
 *
 */
public class TestMybatis07_Threads_SQL_ForEach {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		List<Integer> ids = new ArrayList();
		ids.add(1);
		ids.add(3);
		ids.add(5);
		
		List<Product> ps = session.selectList("listProduct_For_Each",ids);
		for (Product product : ps) {
			System.out.println(product);
		}
		
		session.commit();
		session.close();
	}

}
