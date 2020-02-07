package com.bemore.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Bmo
 * @date 2020/2/6 14:08
 * 将用HttpServletResponse返回前台JSON格式数据，同时减少Controller层代码的冗余
 */
public class ResponseUtil {
    public static void write(HttpServletResponse response, Object o) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        //允许所有域名访问，正式项目不建议这么干
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
