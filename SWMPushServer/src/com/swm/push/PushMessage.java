package com.swm.push;

public class PushMessage {

	String uid;
	String divToken;
	String msg;
	
	public PushMessage (String uid){
		
		this.uid = uid;
		this.msg = "test messgage";	
		
	}
	
	public PushMessage (String uid, String utoken, String msg) {
		
		this.uid = uid;
		this.divToken = utoken;
		this.msg = msg;
	}
	
	
	
}
