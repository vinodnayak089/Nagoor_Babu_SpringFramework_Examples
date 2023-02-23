package com.durgasoft.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

import com.durgasoft.beans.Employee;

public class test34 {

	public static void main(String[] args) {
		
		Employee emp=new Employee();
		BeanWrapper bw=new BeanWrapperImpl(emp);
		bw.setPropertyValue("eid",1);
		bw.setPropertyValue("ename", "vin");
		bw.setPropertyValue("eaddr","alw");
		System.out.println(bw.getPropertyValue("eid"));
		System.out.println(bw.getPropertyValue("ename"));
		System.out.println(bw.getPropertyValue("eaddr"));
		System.out.println("emp ref : "+emp);
		System.out.println("empolyee wrappers : "+emp);
		Map<String,String> map=new HashMap<>();
		map.put("eid", "2");
		map.put("ename", "vin2");
		map.put("eaddr", "alw2");
		bw.setPropertyValues(map);
		System.out.println("empolyee wrappers 2: "+emp);
		Employee emp2=new Employee();
		BeanUtils.copyProperties(emp,emp2);
		System.out.println("copied : "+emp2);

		
		
		

		
	}

}
