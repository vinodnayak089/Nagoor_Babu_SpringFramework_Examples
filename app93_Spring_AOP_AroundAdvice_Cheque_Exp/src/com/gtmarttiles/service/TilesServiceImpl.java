package com.gtmarttiles.service;

import com.gtmarttiles.dto.Account;
import com.gtmarttiles.dto.Cheque;

public class TilesServiceImpl implements TilesService {
	

	@Override
	public void debit(Account acc, Cheque cheque) {
		
		int updatedbalance = acc.getBalance() - cheque.getAmount();
		//System.out.println(updatedbalance);
		acc.setBalance(updatedbalance);
		System.out.println("##### Transaction successfull ##### ");
		
	}
}
