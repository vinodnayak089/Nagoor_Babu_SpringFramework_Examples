package com.durgasoft.service;

import com.durgasoft.model.Student;

public interface StudentService {
	
	public String insert(Student stu);
	public Student search(int sid);
	public String update(Student stu);
	public String delete(int sid);

}
