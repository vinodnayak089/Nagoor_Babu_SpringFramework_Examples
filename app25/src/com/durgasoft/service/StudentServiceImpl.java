package com.durgasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgasoft.model.Student;
import com.durgasoft.repository.StudentRepo;
import com.durgasoft.repository.StudentRepoImpl;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public String insert(Student stu) {
		return studentRepo.insert(stu);
	}

	@Override
	public Student search(int sid) {
		return studentRepo.search(sid);
	}

	@Override
	public String update(Student stu) {
		return studentRepo.update(stu);
	}

	@Override
	public String delete(int sid) {
		return studentRepo.delete(sid);
	}

}
