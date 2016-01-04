package com.xoriant.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author raote_g
 * 
 */
public class NotAuthorizedException extends WebApplicationException {

	private static final long serialVersionUID = 1L;
	static final Logger logger = LogManager
			.getLogger(NotAuthorizedException.class.getName());

	/**
	 * Custom exception method , logs the error message
	 * 
	 * @param message
	 */
	public NotAuthorizedException(String message) {
		super(Response.status(Response.Status.BAD_REQUEST).entity(message)
				.type(MediaType.TEXT_PLAIN).build());
		logger.error(message);

	}
}
