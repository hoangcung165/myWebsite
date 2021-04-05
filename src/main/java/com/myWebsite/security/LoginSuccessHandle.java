package com.myWebsite.security;

import com.myWebsite.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginSuccessHandle extends SimpleUrlAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    public void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication,request);

        if (response.isCommitted()) {
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    private String determineTargetUrl(Authentication authentication,HttpServletRequest request){
       String url="";
        HttpSession session=request.getSession();
        List<String> roles= SecurityUtils.getAuthorites();
        if(isAdmin(roles)){
            url="/admin";
        }
        else if(session!=null){
            url=(String) session.getAttribute("url_prior_login");
            if(url!=null){
                session.removeAttribute("url_prior_login");
            }
        }
        else if(isUser(roles)){
            url="/home";
        }
        return url;
    }
    private boolean isAdmin(List<String> roles){
        if(roles.contains("ROLE_ADMIN")){
            return true;
        }
        return false;
    }
    private boolean isUser(List<String> roles){
        if(roles.contains("ROLE_USER")){
            return true;
        }
        return false;
    }
}
