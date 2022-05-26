package com.kingland.neusoft.course.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponsiveAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.setContentType("application/json;charset=UTF-8");
    	response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    	response.setHeader("Access-Control-Max-Age", "3600");
    	response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        // ���Ҫ��Cookie��������������Ҫָ��Access-Control-Allow-Credentials�ֶ�Ϊtrue
    	response.setHeader("Access-Control-Allow-Credentials", "true");                                
    	response.setHeader("Access-Control-Expose-Headers", "*"); 
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(new ObjectMapper().writeValueAsString(authentication));
        out.flush();
    }
}
