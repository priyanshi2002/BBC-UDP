package com.bbc.ubp.BBCUBP.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	CustomerNotFoundException(String message){
		super(message);
	}
  CustomerNotFoundException(){
	  super();
  }
}
