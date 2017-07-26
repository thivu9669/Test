package model;
import java.sql.*;
import java.util.*;
import entities.Student;
import dbConnect.MyConnect;
import dbConnect.MyConnect;

public class StudentDAO {
	
	public static int insert(Student s) {
		// 1. tao ket noi den sem2_demo
		Connection cn = MyConnect.getcn();
		if (cn == null)
			return 0;

		try {

			// 2. tao doi tuong statement chua lech insert
			String sql = "insert Student values(?,?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sql);

			// 3. dien gia tri cho doi so ? trong lenh insert
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getParentName());
			ps.setString(4, s.getPhone());
			ps.setString(5, s.getStandard());
			ps.setString(6, s.getRegDate());
		
sdfsfsfsdf
			// 4. cho thi hanh lenh insert

			int r = ps.executeUpdate();

			// 5. dong resource dang su dung
			cn.close();
			return r;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
