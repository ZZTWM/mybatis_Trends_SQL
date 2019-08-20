package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Product;
/**
 * trim±êÇ©£ºset
 * @author Administrator
 *
 */
public class TestMybatis05_Threads_SQL_Trim_Set {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		Product p = new Product();
		p.setId(7);
		p.setName("product_ÐÞ¸Ä");
		p.setPrice(99.99f);
		session.update("updateProduct_Trim_Set",p);
		
		listAll(session);
		
		session.commit();
		session.close();		
	}

	private static void listAll(SqlSession session) {
        List<Product> ps = session.selectList("listProduct");
        
        for (Product product : ps) {
			System.out.println(product);
		}		
	}
}
