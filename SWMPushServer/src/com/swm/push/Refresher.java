package com.swm.push;

import com.swm.chat.pusher.*;
import java.util.Timer;
import java.util.TimerTask;

public class Refresher {
	//Set refresh time as 1 hour.
	private int refreshTime = 300;
	private Timer timer = null;
	private DatabaseManager dbManager = null;
	
	// get User divce list 
	// private ArrayList<UserDeviceVO> udidList = null;
	
	//Start method.
	public void start() {
		//Set timer.
		timer = new Timer();
		timer.schedule(new RefreshTimerTask(), 1000, 1000*refreshTime);
	}
	
	
	public void stopRefresher() {
		if ( timer!=null )
			timer.cancel();
	}
	
	//Connection timer
	class RefreshTimerTask extends TimerTask {
		@Override
		public void run() {
			//Get parsing sites list.
			dbManager = new DatabaseManager();
//			sudidList = dbManager.getAllUser();
			
//			ArrayList<ArrayList<ContentVO>> lists = new ArrayList<ArrayList<ContentVO>>();
//			for (int tag=1; tag < 6 ; tag++) {
//				ArrayList<ContentVO> list = new ArrayList<ContentVO>();
//				list = dbManager.getListbyTaglist(tag);
//				lists.add(list);
//			}
//			
//			for (int tag=1; tag<6 ; tag++) {
//				
//				CheckContentList.check( lists.get(tag), udidList );
//			}
			
			
//			while ( udidList.isEmpty()!=true ) {
//				//Set parser and do parsing.
////				Parser parser = new Parser(udidList.remove(0));
////				parser.start();
//			}
			
			
		}
	}
	
	public void pushApple ( ) {
		
	}
	
	public void pushMail ( ) {
		
	}
}


