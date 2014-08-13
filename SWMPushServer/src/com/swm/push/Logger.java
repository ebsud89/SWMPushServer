package com.swm.push;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Logger {
	private Calendar calender = null;
	private final int MAX_LOG_NUM = 5;
	private PrintWriter os = null;
	private File file = null;
	
	
	//Global log
	public Logger() {
		setOsAsGlobal();
	}
	
	//Specific log
	public Logger(int option) {
		//Check option exception
		if ( option<0 || option>MAX_LOG_NUM ) {
			//Set as global log
			setOsAsGlobal();
		}
		else {
			//Set as specific log
			setOsAsSpecific(option);
		}
	}
	
	
	public void log(String str) {
		try {
			//Set output stream
			os = new PrintWriter(file);
			
			//Set time stamp & append the log
			Date currentTimeStamp = new Timestamp(calender.getTime().getTime());
			String ret = currentTimeStamp.toString() + "\t" + str + "\n";
			
			//Write to file
			os.write(ret);
			
			//Close file output stream
			os.close();
		}
		catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				//No log directory.
				System.out.println("No log directory");
				e1.printStackTrace();
			}
		}
	}
	
	private void setOsAsSpecific(int option) {
		//Set calender
		calender = Calendar.getInstance();
		
		//Set file
		if ( option==0 )
			file = new File("./log/parser.log");
		else if ( option==1 )
			file = new File("./log/pushManager.log");
		else if ( option==2 )
			file = new File("./log/database.log");
		else
			file = new File("./log/global.log");
	}
	
	private void setOsAsGlobal() {
		//Set calender
		calender = Calendar.getInstance();
		
		//Set file
		file = new File("./log/global.log");			
	}
}
