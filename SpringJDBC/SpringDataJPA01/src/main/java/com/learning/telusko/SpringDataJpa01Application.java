package com.learning.telusko;

import com.learning.telusko.persistence.IStudentDao;
import com.learning.telusko.persistence.StudentTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpa01Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(SpringDataJpa01Application.class, args);

		IStudentDao dao = context.getBean(IStudentDao.class); //inject the class who is implmenting IStudentDAO.class interface
		//spring will inject the object of this class
		StudentTable st=new StudentTable();
		st.setSid(5);
		st.setSage(10);
		st.setScity("NYC");
		st.setSname("Manish");
		dao.save(st);

		Optional<StudentTable> stu= dao.findById(2);
		//Optional is object holder just like any variable
		System.out.println(stu);
	}

}

/**
 * all implementation done by spring data jpa, we just make one function call
 *  we need not write any query/ crud operation login, / get any connection object/ initialse driver/ user jdbc template .. all this is already done by spring data jpa
 *  100% abstraction
 */

