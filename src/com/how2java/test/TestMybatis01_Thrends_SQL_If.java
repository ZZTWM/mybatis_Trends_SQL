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
 * 动态SQL:If
 * @author Administrator
 *
 */
public class TestMybatis01_Thrends_SQL_If {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        /**
         * 查询所有
         */
        System.out.println("查询所有的");
        List<Product> ps = session.selectList("listProduct");
        
        for (Product product : ps) {
			System.out.println(product);
		}
        /**
         * 模糊查询
         */
        System.out.println("模糊查询");
        Map<String,Object> params = new HashMap<>();
        params.put("name", "华为");   
        List<Product> ps2 = session.selectList("listProduct",params);
        for (Product product : ps2) {
			System.out.println(product);
		}
        session.commit();
        session.close();
    }
}