package com.durgasoft.beans;

public class CurrentAccount implements Account {

	@Override
	public void getAccountDetails() {
          System.out.println(" current account details");		
	}

	@Override
	public void create() {
		System.out.println("current account created");
		
	}

	@Override
	public void delete() {
		System.out.println("current account deleted");
		
	}

	@Override
	public void update() {
		System.out.println("current account updated");
		
	}

}
