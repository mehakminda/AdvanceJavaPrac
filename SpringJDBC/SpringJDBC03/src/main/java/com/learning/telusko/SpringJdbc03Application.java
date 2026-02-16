package com.learning.telusko;

import com.learning.telusko.dao.StudentDaoImpl;
import com.learning.telusko.dao.StudentTableBo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbc03Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbc03Application.class, args);
		StudentDaoImpl dao= (StudentDaoImpl) context.getBean("dao");
		StudentTableBo bo=dao.getStudentById(1);
		System.out.println(bo);

		StudentTableBo bo2=dao.getStudentById(1,"Hyderabad");
		System.out.println(bo2);

		dao.getStudents().forEach((bo3)->{
			System.out.println(bo3);
		});
	}

}
