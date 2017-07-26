package model;

import java.sql.*;
import java.util.*;

import entities.Student;
import entities.Student;
import dbConnect.MyConnect;

public class StudentDAO {
	// lay danh sach Sinh vien trong Student

		public static List<Student> getList() {
			List<Student> ds = new ArrayList<>();

			// 1. tao ket noi den sem2_demo
			Connection cn = MyConnect.getcn();
			if (cn == null)
				return null;

			try {
				// ket noi thanh cong
				// 2. tao doi tuong statement chua link select sql
				String sql = "select * from tbStudent";
				Statement st = cn.createStatement();

				// 3. cho thi hanh link select, kq tra ve se dat trong 1 resultset
				ResultSet rs = st.executeQuery(sql);

				// 4. duyet kq --> luu vao ds
				while (rs.next()) {
					// doc du lieu tren dong
					String st_id = rs.getString(1); // ma Sinh vien6
					String lastname = rs.getString(2); // ho
					String firstname = rs.getString(3); //ten
					boolean gender = rs.getBoolean(4); //Giới tính
					int phone = rs.getInt(5); //SDT
					String batchno = rs.getString(6); //Mã lớp

					ds.add(new Student(st_id, lastname, firstname, gender, phone, batchno));

				}
				cn.close();
				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ds;
		}

}
