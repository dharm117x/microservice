/**
 * 
 */
package com.javacoder.userservice.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javacoder.userservice.entity.User;

/**
 * @author dharm
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(Long userId);

}
