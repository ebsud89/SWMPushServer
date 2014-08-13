package com.swm.push;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;


public class DatabaseManager {

	//Database Information
	private String mysqlUrl = "jdbc:mysql://localhost/boardpusher";
	private String mysqlID = "boardpusher";
	private String mysqlPW = "kkyuingpusher";

	//Database
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//Static values
	public static int ORDERBY_CONTENTNUMBER = 0;
	public static int ORDERBY_TIMESTAMP = 1;
	public static int DEFAULT_PARSING_COUNT = 10;
	
	public static int ENABLE = 1;
	public static int DISABLE = 0;
	
	
	//Logger
	private Logger logger = null;
	
	//Check for is loading done.
	private boolean isClosed = false;
	
	
	public DatabaseManager () {
	
		// initialize logger
		logger = new Logger(2);
		
		// try-catch : connection
		try {
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	// 상황 별 푸시 종류 
	
	// 1. msg 왔을 때의 푸시
	// 2. 입주 신청이 있을때 
	// 3. 질문글이 올라왔을때
	// 4. 답변이 달렸을때
	// 5. 입력했던 정보에 대해서 새로운 방이 떳을때
	// 6. 
	

//	public ArrayList<E>> getAllmsg () {
//		
//	}
	
}
