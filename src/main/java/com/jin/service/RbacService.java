package com.jin.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jinpeng
 * @date 2019/3/15.
 */
public interface RbacService {

    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
