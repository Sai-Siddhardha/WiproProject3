package com.wipro.eb.exception;

public class InvalidConnectionException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String toString()
	{
		return "Invalid Connection Type";
	}
	public InvalidConnectionException(String str)
	{
		super(str);
	}
}
