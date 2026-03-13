package in.biduaedtech.daofactory;

import in.biduaedtech.persistence.RStudentDao;
import in.biduaedtech.persistence.StudentDaoImplementation;

public class StudentDaoFactory {
	private StudentDaoFactory() {}
	
	private static RStudentDao studentDao = null;
	
	public static RStudentDao getStudentDao() {
		if(studentDao==null) {
			studentDao = new StudentDaoImplementation();
		}
		return studentDao;
	}

}
