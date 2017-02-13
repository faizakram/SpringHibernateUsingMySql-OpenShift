package com.Accer.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Entity
@Table(name = "users", catalog = "accer", uniqueConstraints = @UniqueConstraint(columnNames = "User_Email_Id"))
public class Users implements java.io.Serializable {

 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserProfile userProfile;
	private String password;
	private boolean enable;
	private Set<Roles> roleses = new HashSet<Roles>(0);
 
	public Users() {
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "User_Email_Id", unique = true, nullable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "password", nullable = false, length = 60)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enable", nullable = false)

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "accer", uniqueConstraints = { @UniqueConstraint(columnNames = "user_id"),
	@UniqueConstraint(columnNames = "role_id") }, joinColumns = {
    @JoinColumn(name = "User_Id", unique = true, nullable = false, updatable = false) }, inverseJoinColumns = {
	@JoinColumn(name = "Role_Id", unique = true, nullable = false, updatable = false) })

	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

}