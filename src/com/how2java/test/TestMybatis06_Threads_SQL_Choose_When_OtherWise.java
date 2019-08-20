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
 * choose±Í«©
 * @author Administrator
 *
 */
public class TestMybatis06_Threads_SQL_Choose_When_OtherWise {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
        Map<String,Object> params = new HashMap<>();
//      params.put("name","a");
//      params.put("price","10");
	    List<Product> ps = session.selectList("listProduct_Choose",params);
	    for (Product p : ps) {
	        System.out.println(p);
	    }
	 
	    session.commit();
	    session.close();
		
	}

}
