package com.bemore.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Bmo
 * @date 2020/2/9 16:24
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 不拦截 "/login" 请求
    private static final String[] IGNORE_URI = { "/login" };

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        boolean flag = false;
        String url = request.getServletPath();
        for (String s: IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
            if (!flag) {
                String username = (String)request.getSession().getAttribute("username");
                if (username == null) {
                    request.setAttribute("message", "Please log in first");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    flag = true;
                }
            }
        return flag;
    }

}
