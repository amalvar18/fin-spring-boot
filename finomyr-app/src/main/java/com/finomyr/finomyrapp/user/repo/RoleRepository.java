/**
 * 
 */
package com.finomyr.finomyrapp.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finomyr.finomyrapp.model.Role;

/**
 * DAO/Repository for Roles
 * 
 * @author amalvar
 *
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);

}
