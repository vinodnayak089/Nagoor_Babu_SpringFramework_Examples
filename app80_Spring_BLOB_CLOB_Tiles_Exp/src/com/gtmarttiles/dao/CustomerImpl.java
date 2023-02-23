package com.gtmarttiles.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;

import com.gtmarttiles.dto.Customer;

public class CustomerImpl implements CustomerDao {
	
	private DataSource dataSource;
	private LobHandler lobHandler;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public LobHandler getLobHandler() {
		return lobHandler;
	}
	
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertCustomer(Customer cus) {
		try {
		String query="insert into customer_tiles_table values(?,?,?,?)";
		jdbcTemplate.execute(query, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
			
			@Override
			protected void setValues(PreparedStatement pst, LobCreator lobCreator) throws SQLException, DataAccessException {
                           pst.setInt(1, cus.getCno());
                           pst.setString(2, cus.getName());
                   		FileInputStream fis=null;
						FileReader fr=null;
                           try {
							fis= new FileInputStream(cus.getCus_Img());
							fr= new FileReader(cus.getCus_Resume());
							lobCreator.setBlobAsBinaryStream(pst, 3, fis, (int)cus.getCus_Img().length());
							lobCreator.setClobAsCharacterStream(pst, 4, fr, (int) cus.getCus_Resume().length());
							
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}			
			}
		});
		}catch (Exception e) {
                        e.printStackTrace();
		}

		
	}

	@Override
	public Customer readCustomer() {
        Customer customer= new Customer();
        String query= "select * from customer_tiles_table";
        jdbcTemplate.query(query, new AbstractLobStreamingResultSetExtractor<Object>() {

			@Override
			protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
				customer.setCno(rs.getInt(1));
				customer.setName(rs.getString(2));
				File file1= new File("D:/GT_MART_Images/db/my_card.jpg");
				FileOutputStream fos= new FileOutputStream(file1);
			    FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(rs, 3), fos);
			    customer.setCus_Img(file1);
			    
				File file2= new File("D:/GT_MART_Images/db/my_resume.docx");
				FileWriter fw= new FileWriter(file2);
			    FileCopyUtils.copy(lobHandler.getClobAsCharacterStream(rs, 4), fw);
			    customer.setCus_Resume(file2);
			}
		});
        
		return customer;
	}

}
