package com.gtmarttiles.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TilesDaoImpl implements TilesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	@Override
	public void transfer(String fromAcc, int transferAmount, String toAcc) {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
		int rowCount = 0;
		String status;
        try {
            int debitCount = debit(fromAcc, transferAmount);
			
            if(debitCount==1) {
            	status="debit Transaction Success";
    			System.out.println("Status : "+status);
                System.out.println("amount debited from acc: "+fromAcc +" is :"+transferAmount);
            }
            else {
            	System.out.println("debit failed");
            }

    		int creditCount = credit(toAcc, transferAmount);
            if(creditCount==1) {
    			status="Credit Transaction Success";
    			System.out.println("Status : "+status);
    			System.out.println("amount credited to acc: "+toAcc +" is :"+transferAmount);
                
            }
            else {
            	System.out.println("credit failed");
            }

    		if(debitCount==creditCount && debitCount==1 && creditCount==1)
    		{
    		    transactionManager.commit(transactionStatus);
    			System.out.println("Total Transaction is successful");
    		}
    		else {System.out.println("Total transaction failed");}

		} 
        		catch (Exception e) {
        			transactionManager.rollback(transactionStatus);
        			status="Total Transaction failed";
        			System.out.println(status);
		}
	}	

	public int debit(String fromAcc, int transferAmount) {
		String query="update account set balance = balance - "+transferAmount +" where acc = '"+fromAcc+"'";
		int rowCount = 0;
		try {
			rowCount=jdbcTemplate.update(query);
		} catch (Exception e) {
		}
		return rowCount;
	}

	public int credit(String toAcc, int transferAmount) {
		String query="update account set balance = balance + "+transferAmount +" where acc = '"+toAcc+"'";
		int rowCount = 0;
		try {
			rowCount=jdbcTemplate.update(query);
		} catch (Exception e) {
		}
		return rowCount;
	}
}
