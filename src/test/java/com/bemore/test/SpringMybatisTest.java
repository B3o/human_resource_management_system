package com.bemore.test;

import com.bemore.domain.Admin;
import com.bemore.service.AdminService;
import com.bemore.service.PostService;
import com.bemore.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Test
    public void testSelectPost() {
        Map map = new HashMap<String, Object>(5);
        map.put("title", "%no%");
        List posts = postService.findPosts(map);
        System.out.println(posts.size());
    }
    @Test
    public void testRealAdminLogin() {
        Admin admin = new Admin();
        admin.setUsername("superadmin");
        Map map = new HashMap<String, Object>(5);
        map.put("username", admin.getUsername());
        List<Admin> adminList = adminService.findAdmins(map);
        Integer total = adminService.getCount(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(adminList);
        result.put("rows", jsonArray);
        result.put("total", total);
        System.out.println(result.toString());
    }

}
