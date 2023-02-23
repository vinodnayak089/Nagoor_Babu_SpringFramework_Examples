package com.durgasoft.handler;

import org.springframework.context.ApplicationListener;

import com.durgasoft.event.AccountEvent;

public class AccountEventHandler implements ApplicationListener<AccountEvent> {

	@Override
	public void onApplicationEvent(AccountEvent ae) {

		ae.generateLog();
	}

}
