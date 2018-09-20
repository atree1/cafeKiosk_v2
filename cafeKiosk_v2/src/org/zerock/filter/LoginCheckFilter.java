package org.zerock.filter;

import lombok.extern.log4j.Log4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebFilter(urlPatterns = {"/board/list"})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("-----------------------------------------------------------------");
        log.info("Login Check Filter");
        log.info("-----------------------------------------------------------------");

        HttpServletRequest req=(HttpServletRequest)servletRequest; //쿠키는 http 에서만 쓰이므로 다운캐스팅 필요
        HttpServletResponse resp=(HttpServletResponse) servletResponse; //쿠키는 http 에서만 쓰이므로 다운캐스팅 필요
        Cookie[] cks=req.getCookies();
        log.info(cks);

        if(cks==null ||cks.length==0){
            resp.sendRedirect("/main");
        }
        boolean check=false;
        for (Cookie ck:cks) {
            log.info(ck.getName());
            if(ck.getName().equals("login")) {
                check=true;
                break;
            }
        }//end for
        log.info(check);
        if(!check){
            resp.sendRedirect("/main");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
