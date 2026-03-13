package in.biduaedtech.Service;

import in.biduaedtech.dto.Student;

public interface RStudentService {
	//Operation to be implemented
		public String addStudent(Integer sid,String sName, Integer sAge, String sAddress);
		public Student searchStudent(Integer sid);
		public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
		public String deleteStudent(Integer sid);
}