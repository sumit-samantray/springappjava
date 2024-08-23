package com.oracle.team1.exceptions;

public class JwtTokenMissingException extends RuntimeException{
	public JwtTokenMissingException(String message) {
        super(message);
    }
}
