package com.durgasoft.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.durgasoft.event.AccountEvent;

public class AccountEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
           this.publisher=publisher;	
	}
	
	public void publish(String message) {
		AccountEvent ae=new AccountEvent(this, message);
		publisher.publishEvent(ae);
	}
 
}
