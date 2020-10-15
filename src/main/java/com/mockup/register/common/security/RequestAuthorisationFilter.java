package com.mockup.register.common.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class RequestAuthorisationFilter extends OncePerRequestFilter {
    private static final List<String> IGNORE_URLS = Arrays.asList("/v1/health");

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = httpServletRequest.getHeader("Authorization");
        setSecurityContextToAuthenticated(httpServletRequest, 1);

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void setSecurityContextToAuthenticated(HttpServletRequest httpServletRequest, Integer id) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(id,
                null, AuthorityUtils.commaSeparatedStringToAuthorityList("ALL"));
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return IGNORE_URLS.contains(path);
    }
}
