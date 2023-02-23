package com.durgasoft.beans;

import com.durgasoft.publisher.AccountEventPublisher;

public class Account {
	
	private AccountEventPublisher accountEventPublisher;
	
	public void setAccountEventPublisher(AccountEventPublisher accountEventPublisher) {
		this.accountEventPublisher = accountEventPublisher;
	}
	
	public void accountCreated() {
		System.out.println("****accountCreated****");
		accountEventPublisher.publish("accountCreated");
	}
	
	public void accountUpdated() {
		System.out.println("****accountUpdated****");
		accountEventPublisher.publish("accountUpdated");
	}

	public void accountDeleted() {
		System.out.println("****accountDeleted****");
		accountEventPublisher.publish("accountDeleted");
	}

	public void accountDetails() {
		System.out.println("****accountDetails****");
		accountEventPublisher.publish("accountDetails");
	}
}
