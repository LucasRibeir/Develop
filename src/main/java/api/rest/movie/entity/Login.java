package api.rest.movie.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="login")

public class Login implements Serializable {
	public static final long SerialVersionUID=1;


	private Long IdLogin;

	@Column(length=50)
	private String email;

	@Column(length= 20)
	private String password;

	
	
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(Long idLogin, String email, String senha) {
		super();
		IdLogin = idLogin;
		this.email = email;
		this.password = password;
	}

	public Long getIdLogin() {
		return IdLogin;
	}

	public void setIdLogin(Long idLogin) {
		IdLogin = idLogin;
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

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}



}