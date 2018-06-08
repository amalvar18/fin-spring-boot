package com.finomyr.finomyrapp.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Util class for generating password hash
 * @author amalvar
 * @version 0.1
 * @since 0.6.2
 */
public class QuickPasswordEncodingGenerator {

	public static void main(String[] args) {
		
		String password = "amalvar";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
	}

}
