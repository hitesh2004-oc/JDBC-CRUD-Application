package in.biduaedtech.persistence;

import in.biduaedtech.dto.Student;

public interface RStudentDao {
	//Operation to be implemented
	public String addStudent(Integer sId,String sName, Integer sAge, String sAddress);
	public Student searchStudent(Integer sid);
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	public String deleteStudent(Integer sid);
}
