package com.durgasoft.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.durgasoft.model.Student;

@Repository("studentRepo")
public class StudentRepoImpl implements StudentRepo {
	
//	@Autowired
//	private DataSource dataSource;
	
	String url="jdbc:mysql://localhost:3306/naveen_durga_database";
	String user="root";
	String password="system";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
	
	@Override
	public String insert(Student stu) {
		String status="";
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select *from student where sid=?");
			pst.setLong(1, stu.getSid());
			ResultSet rs=pst.executeQuery();
			boolean b=rs.next();
			if(b)
			{
				status="Existed";
			}
			else {
				pst=con.prepareStatement("insert into student values(?,?,?)");
				pst.setInt(1, stu.getSid());
				pst.setString(2, stu.getSname());
				pst.setString(3, stu.getSaddr());
				int rowCount=pst.executeUpdate();
				if(rowCount==1)
				{
					status="Success";
				}
				else {
					status="Failure";
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public Student search(int sid) {
		Student stu = new Student();
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select *from student where sid=?");
		    pst.setInt(1, sid);
			ResultSet rs=pst.executeQuery();
		    boolean b=rs.next();
		    if(b==true)
		    {
		       	stu.setSid(rs.getInt("sid"));
		       	stu.setSname(rs.getString("sname"));
		       	stu.setSaddr(rs.getString("saddr"));
		    }
		    else stu=null;
		}
		catch (Exception e) {
           e.printStackTrace();
           }
		
		return stu;
	}

	@Override
	public String update(Student stu) {
		//Student stu = new Student();
		String status="";
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("update student set sname=?, saddr=? where sid=?");
            pst.setString(1, stu.getSname());
            pst.setString(2, stu.getSaddr());
            pst.setInt(3, stu.getSid());
            int rowCount=pst.executeUpdate();
            
            if(rowCount==1)
            {
               status="Success";	
            }
            else {
            	status="Failure";
            }       
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int sid) { 
		String status="";
		try {
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select * from student where sid=?");
			pst.setInt(1, sid);
			ResultSet rs=pst.executeQuery();
		    boolean b=rs.next();
		    if(b==true)
		    {
		    	pst=con.prepareStatement("delete from student where sid=?");
	            pst.setInt(1, sid);
	            int rowCount=pst.executeUpdate();
	            if(rowCount==1)
	            {
	               status="Success";	
	            }
	            else {
	            	status="Failure";
	            }         
		    }
		    else {
		    	status="Not Exist";
		    }

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
