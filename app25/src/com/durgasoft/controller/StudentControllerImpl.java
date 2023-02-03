package com.durgasoft.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.durgasoft.model.Student;
import com.durgasoft.service.StudentService;
import com.durgasoft.service.StudentServiceImpl;

@Controller("studentController")
public class StudentControllerImpl implements StudentController {

	@Autowired
	StudentService studentService;

	Scanner sc = new Scanner(System.in);

	@Override
	public void insert() throws Exception {
		try {
			System.out.println("Now you should enter Student Details");
			Student stu = new Student();
			System.out.println("Enter student ID");
			stu.setSid(sc.nextInt());
			System.out.println("Enter student Name");
			stu.setSname(sc.next());
			System.out.println("Enter student Address");
			stu.setSaddr(sc.next());
			String status = studentService.insert(stu);
			if (status == "Existed") {
				System.out.println("Student Data Already Existed in DB");
			} else if (status == "Success") {
				System.out.println("Student Data inserted Successfully");
			} else {
				System.out.println("Student Data insertion is failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void search() {
		System.out.println("Enter student ID");
		int sid = sc.nextInt();
		Student stu = studentService.search(sid);
		if (stu == null) {
			System.out.println("Student does not exist");
		} else
			System.out.println(stu);
	}

	@Override
	public void update() {
		System.out.println("Enter student ID");
		int sid = sc.nextInt();
		Student stu = studentService.search(sid);
		if (stu == null) {
			System.out.println("Student does not exist");
		} else {
			System.out.println("Student Old Values");
			System.out.println("Student ID :" + stu.getSid());
			System.out.println("Student Old Name :" + stu.getSname() + "  Enter New Name :");
			stu.setSname(sc.next());
			System.out.println("Student Old Address :" + stu.getSaddr() + "  Enter New Address :");
			stu.setSaddr(sc.next());
			String status = studentService.update(stu);
			if (status == "Success") {
				System.out.println("Student Updated details");
				System.out.println(stu);
			} else
				System.out.println("Failure in updating ");
		}
	}

	@Override
	public void delete() {
		System.out.println("Enter student ID");
		int sid = sc.nextInt();
		String status = studentService.delete(sid);
		if (status == "Success") {
			System.out.println("Student row deleted Successfully");
		} else if (status == "Not Exist") {
			System.out.println("Student does Not Exist");
		} else
			System.out.println("Failure in deleting");
	}

}
