package es.ucm.fdi.iw;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import es.ucm.fdi.iw.controller.RootController;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {
	private static final Logger log = Logger.getLogger(RootController.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@PersistenceContext
	private EntityManager entityManager;
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication)
      throws IOException {
  
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication)
      throws IOException {
  
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            log.debug(
              "Response has already been committed. Unable to redirect to "
              + targetUrl);
            return;
        }
        
        //response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    protected String determineTargetUrl(Authentication authentication) {
        boolean isPaciente = false;
        boolean isAdmin = false;
        boolean isMedico = false;
        boolean isFarmacia = false;
        Collection<? extends GrantedAuthority> authorities
         = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_PAC")) {
                isPaciente = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_MED")) {
                isMedico = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_FAR")) {
                isFarmacia = true;
                break;
            }
        }
 
        if (isPaciente) {
            return "/paciente";
        } else if (isAdmin) {
            return "/admin";
        } else if (isMedico) {
            return "/medico";
        }else if (isFarmacia) {
            return "/farmacia";
        }else {
            throw new IllegalStateException();
        }
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}