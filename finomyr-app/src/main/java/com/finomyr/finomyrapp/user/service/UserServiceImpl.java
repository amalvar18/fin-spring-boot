/**
 * 
 */
package com.finomyr.finomyrapp.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finomyr.finomyrapp.model.Role;
import com.finomyr.finomyrapp.model.User;
import com.finomyr.finomyrapp.user.repo.RoleRepository;
import com.finomyr.finomyrapp.user.repo.UserRepository;
import com.finomyr.finomyrapp.utils.FinomyrServerConstants;

/**
 * @author amalvar
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.finomyr.finomyrapp.user.service.UserService#findUserByEmail(java.lang
     * .String)
     */
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.finomyr.finomyrapp.user.service.UserService#saveUser(com.finomyr.
     * finomyrapp.model.User)
     */
    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole(FinomyrServerConstants.USER_ROLE);
        /* If USER role doesn't exist, create it */
        if (userRole == null) {
            userRole = new Role();
            userRole.setRole(FinomyrServerConstants.USER_ROLE);
            roleRepository.save(userRole);
        }
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    private UserDetails buildUserForAuthentication(User user,
            List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isActive(), true,
                true, true, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(
                roles);
        return grantedAuthorities;
    }

}
