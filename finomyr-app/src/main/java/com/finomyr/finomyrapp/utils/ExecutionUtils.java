/**
 * 
 */
package com.finomyr.finomyrapp.utils;

/**
 * Contains utility functions for controlling execution flow
 * @author amalvar
 * @since 0.0.3
 * @version 0.1
 */
public class ExecutionUtils {
	
	/**
	 * Adds time delay for cache testing purpose
	 * @param time
	 * @since 0.1
	 */
	public static void simulateSlowService(Long time) {
        try {
           /* long time = 5000L;*/
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
	}
}
