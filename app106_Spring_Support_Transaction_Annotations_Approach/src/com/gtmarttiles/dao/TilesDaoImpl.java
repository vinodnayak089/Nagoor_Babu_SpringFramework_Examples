package com.gtmarttiles.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TilesDaoImpl implements TilesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
		
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	@Override
	public void transfer(String fromAcc, int transferAmount, String toAcc) {
		String status;
            int debitCount = debit(fromAcc, transferAmount);
			
            if(debitCount==1) {
            	status="debit Transaction Success";
    			System.out.println("Status : "+status);
                System.out.println("amount debited from acc: "+fromAcc +" is :"+transferAmount);
            }
            else {
            	System.out.println("debit failed");
            }
            System.out.println("raised AE for checking automacity property: "+100/0);
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
    			System.out.println("Total Transaction is successful");
    		}
    		else {System.out.println("Total transaction failed");}
 
	}	

	

	public int credit(String toAcc, int transferAmount) {
		String query="update account set balance = balance + "+transferAmount +" where acc = '"+toAcc+"'";
		int	rowCount=jdbcTemplate.update(query);
		return rowCount;
	}
	
	public int debit(String fromAcc, int transferAmount) {
		String query="update account set balance = balance - "+transferAmount +" where acc = '"+fromAcc+"'";
		int rowCount=0;
		rowCount=jdbcTemplate.update(query);
		return rowCount;
	}
}
