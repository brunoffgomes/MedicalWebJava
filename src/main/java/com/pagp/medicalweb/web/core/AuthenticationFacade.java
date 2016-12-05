package com.pagp.medicalweb.web.core;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.pagp.medicalweb.web.core.dto.AuthenticatedUser;

@Component
public class AuthenticationFacade {
 
    public AuthenticatedUser getAuthentication() {
        return (AuthenticatedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
