package in.biduaedtech.Service;

import in.biduaedtech.daofactory.StudentDaoFactory;
import in.biduaedtech.dto.Student;
import in.biduaedtech.persistence.RStudentDao;

public class StudentServiceImplementation implements RStudentService {

	RStudentDao daoService;
	public String addStudent(Integer sId,String sName, Integer sAge, String sAddress) {
		daoService = StudentDaoFactory.getStudentDao();//new StudentDaoImplementation();
		String msg = daoService.addStudent(sId,sName, sAge, sAddress);
		return msg;
	}

	@Override
	public Student searchStudent(Integer sid) {
		daoService = StudentDaoFactory.getStudentDao();
		Student s1 = daoService.searchStudent(sid);
		return s1;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		daoService = StudentDaoFactory.getStudentDao();
		String msg = daoService.updateStudent(sid, sname, sage, saddress);
		return msg;
	}

	@Override
	public String deleteStudent(Integer sid) {
		daoService = StudentDaoFactory.getStudentDao();
		String msg = daoService.deleteStudent(sid);
		return msg;
	}
	
}
