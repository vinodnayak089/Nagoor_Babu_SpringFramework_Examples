package com.gtmarttiles.service;

import com.gtmarttiles.dto.Account;
import com.gtmarttiles.dto.Cheque;

public interface TilesService {
	
	public void debit(Account acc, Cheque cheque);

}
