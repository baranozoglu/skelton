package com.github.baranozoglu.security.filter;

import com.github.baranozoglu.security.service.JsonWebTokenAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthenticationTokenFilter extends GenericFilterBean {

    private final JsonWebTokenAuthenticationService authenticationService;

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final Authentication authentication = authenticationService.authenticate(httpRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
