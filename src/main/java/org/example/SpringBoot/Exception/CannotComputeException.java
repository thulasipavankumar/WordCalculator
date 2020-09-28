package org.example.SpringBoot.Exception;

public class CannotComputeException extends Exception {
	public CannotComputeException(){
		super("Cannot Compute Exception");
	}
	public CannotComputeException(String msg){
		super(msg);
	}
	
}
