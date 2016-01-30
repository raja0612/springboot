package com.springboot.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springboot.security.Authorities;

/**  Persistence class for USERS Table.
 * @author RAJASHEKHAR
 *
 */
@Entity
@Table(name= "users")
public class User {
	
	//User   has 1...* relationship to Authorities
	
	private Long id;
	private String email;
	private String password;
	
	private Set<Authorities> authorities = new HashSet<Authorities>();
	
	public User() {
		
	}
	public User(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		//this.authorities = userDeatils.getAuthorities();
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user")
	public Set<Authorities> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	
	
}
