package com.xuke.dao;

import com.xuke.tool.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatistext {
    @Test
    public void testfindAll() throws IOException {
        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //

        Userdao mapper = sqlSession.getMapper(Userdao.class);

        List<Person> all = mapper.findAll();
        System.out.println("all = " + all);
        sqlSession.close();
        inputStream.close();
    }
}
