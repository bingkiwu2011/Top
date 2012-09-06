package com.top.action;

import java.util.Iterator;

import javax.annotation.security.RolesAllowed;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RolesAllowed({ "ROLE_ADMIN" })
public class AdminUserController {
	private static Log log = LogFactory.getLog(AdminUserController.class);

	@SuppressWarnings("rawtypes")
	@RequestMapping("/bingki")
	public String getUsersList(Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			System.out.println(username);
			Iterator it = ((UserDetails) principal).getAuthorities().iterator();
			String authority = "";
			while (it.hasNext()) {
				authority = ((GrantedAuthority) it.next()).getAuthority();
				System.out.println("Authority:" + authority);
			}
		}

		
		return "/bingki";
	}
}