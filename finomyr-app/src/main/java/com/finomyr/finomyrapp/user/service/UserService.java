/**
 * 
 */
package com.finomyr.finomyrapp.user.service;

import com.finomyr.finomyrapp.model.User;

/**
 * @author amalvar
 *
 */
public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
