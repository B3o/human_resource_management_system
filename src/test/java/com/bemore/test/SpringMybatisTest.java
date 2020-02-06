package com.bemore.test;

import com.bemore.domain.Admin;
import com.bemore.service.AdminService;
import com.bemore.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Bmo
 * @date 2020/2/6 13:05
 * 配置Spring和junit整合，junit启动时加载SpringIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SpringMybatisTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PostService postService;

    @Test
    public void testLogin() {
        Admin admin = new Admin();
        admin.setUsername("superadmin");
        admin.setPassword("123456");
        System.out.println(adminService.login(admin).toString());
    }

}
