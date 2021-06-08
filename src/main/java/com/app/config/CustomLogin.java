package com.app.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomLogin extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String targetUrl = "/Nextpoint";
        if (response.isCommitted()) {
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    // private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    // @Override
    // public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1,
    //         Authentication authentication) throws IOException, ServletException {

    //             if (r) {
                    
    //             }
    //     redirectStrategy.sendRedirect(arg0, arg1, "/Nextpoint");
    // };

}
