package com.durgasoft.beans;

public class SavingAccount implements Account{

	@Override
	public void getAccountDetails() {
          System.out.println(" saving account details");		
	}

	@Override
	public void create() {
		System.out.println("saving account created");
		
	}

	@Override
	public void delete() {
		System.out.println("Saving account deleted");
		
	}

	@Override
	public void update() {
		System.out.println("Saving account updated");
		
	}

	
}
