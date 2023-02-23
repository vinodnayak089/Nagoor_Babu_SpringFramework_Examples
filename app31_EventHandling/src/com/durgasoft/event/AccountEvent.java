package com.durgasoft.event;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.context.ApplicationEvent;

public class AccountEvent extends ApplicationEvent {

	private String message;
	
	private static FileOutputStream fos;
	
	static {
		try {
			fos=new FileOutputStream("D:/Eclipse_pratice/logs/log.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public AccountEvent(Object obj, String message) {
		super(obj);
		this.message=message;
	}
	
	public void generateLog() {
		
		try {
			message=new Date().toString()+" : "+message+"\n";
			byte[] bs=message.getBytes();
			fos.write(bs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
