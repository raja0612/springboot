package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.User;

/**
 * @author RAJASHEKHAR
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	
	/**
	 * @param email
	 * @return
	 */
	public User findUserByEmail(String email);

}
