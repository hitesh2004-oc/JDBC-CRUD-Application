package in.biduaedtech.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.biduaedtech.dto.Student;

public class StudentDaoImplementation implements RStudentDao {
	private static final String DBURL = "jdbc:mysql://localhost:3306/MainCrudApp";
	private static final String DBUSERNAME = "root";
	private static final String DBPASS = "1234";
	Student s1 = new Student();
	
	@Override
	public String addStudent(Integer sId,String sName, Integer sAge, String sAddress) {
		final String QUERY = "Insert into Student(sId,sName,sAge,sAddress) Values(?,?,?,?);";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, sId);
			pstmt.setString(2, sName);
			pstmt.setInt(3, sAge);
			pstmt.setString(4, sAddress);
			int rowsAffected = pstmt.executeUpdate();
			if(rowsAffected>0) return "success";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "fail";
	}

	@Override
	public Student searchStudent(Integer sid) {
		final String QUERY = "Select * from Student where sid=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, sid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				s1.setsId(rs.getInt("sId"));
				s1.setsName(rs.getString("sName"));
				s1.setsAge(rs.getInt("sAge"));
				s1.setsAddress(rs.getString("sAddress"));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return s1;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		final String QUERY = "update Student set sName = ?,sAge = ?,sAddress = ? where sid=?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, sname);
			pstmt.setInt(2, sage);
			pstmt.setString(3, saddress);
			pstmt.setInt(4, sid);
			int rowsAffected = pstmt.executeUpdate();
			if(rowsAffected>0) return "success";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "fail";
	}

	@Override
	public String deleteStudent(Integer sid) {
		final String QUERY = "DELETE FROM Student WHERE sid = ?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASS);
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, sid);
			int rowsAffected = pstmt.executeUpdate();
			if(rowsAffected>0) return "success";
		} catch (Exception e) {
			System.out.println(e);
		}
		return "fail";
	}

}
