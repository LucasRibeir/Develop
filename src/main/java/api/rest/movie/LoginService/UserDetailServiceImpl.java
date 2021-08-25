package api.rest.movie.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import api.rest.movie.entity.Login;
import api.rest.movie.repository.LoginRepository;

public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	LoginRepository dao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException{
		Login login = dao.findByUsername(username);
		if (login == null) {
			throw new UsernameNotFoundException("Email not found");

		}

		return (UserDetails) login;

	}

}