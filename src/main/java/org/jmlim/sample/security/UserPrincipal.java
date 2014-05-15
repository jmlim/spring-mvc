package org.jmlim.sample.security;

import java.util.Collection;
import java.util.List;

import org.jmlim.sample.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Administrator
 * 
 */
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -1343925114258012037L;

	private User user;

	private List<GrantedAuthority> authorities;

	public UserPrincipal(User user, List<GrantedAuthority> authorities) {
		super();
		this.user = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		if (user != null) {
			return user.getPassword();
		}
		return null;
	}

	@Override
	public String getUsername() {
		if (user != null) {
			return user.getUid();
		}
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
}
