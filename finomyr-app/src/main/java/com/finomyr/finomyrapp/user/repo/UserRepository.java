/**
 * 
 */
package com.finomyr.finomyrapp.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finomyr.finomyrapp.model.User;

/**
 * DAO/Repository for User
 * 
 * @author amalvar
 * @version 0.1
 * @since 0.7.1
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
