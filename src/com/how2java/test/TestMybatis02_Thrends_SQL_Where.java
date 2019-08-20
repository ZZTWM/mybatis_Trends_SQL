package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.pojo.Product;
/**
 * 动态SQL:where
 * @author Administrator
 *
 */
public class TestMybatis02_Thrends_SQL_Where {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		System.out.println("多条件查询:使用where");
		Map<String,Object> params = new HashMap<>();
		//params.put("name", "华为");
		params.put("price", "5000");
		List<Product> ps2 = session.selectList("listProduct_Where",params);
		
		for (Product product : ps2) {
			System.out.println(product);
		}
		
		session.commit();
		session.close();
	}
}
