package model;

//MO ta thao tac truy xuat du lieu trong bang TBBATCH: SELECT, INSERT, UPDATE VA DELETE

import java.sql.*;
import java.util.*;
import entities.Batch;
import dbConnect.MyConnect;

public class BatchDAO {
	// lay danh sach lop hoc trong BATCH

	public static List<Batch> getList() {
		List<Batch> ds = new ArrayList<>();

		// 1. tao ket noi den sem2_demo
		Connection cn = MyConnect.getcn();
		if (cn == null)
			return null;

		try {
			// ket noi thanh cong
			// 2. tao doi tuong statement chua link select sql
			String sql = "select * from tbBatch";
			Statement st = cn.createStatement();

			// 3. cho thi hanh link select, kq tra ve se dat trong 1 resultset
			ResultSet rs = st.executeQuery(sql);

			// 4. duyet kq --> luu vao ds
			while (rs.next()) {
				// doc du lieu tren dong
				String id = rs.getString(1); // ma lophoc
				String desc = rs.getString(2); // chuong trinh hoc
				int fee = rs.getInt(3); // hoc phi

				ds.add(new Batch(id, desc, fee));

			}
			cn.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;
	}

	// them mot lop hoc moi vao bang BATCH
	public static int insert(Batch b) {
		// 1. tao ket noi den sem2_demo
		Connection cn = MyConnect.getcn();
		if (cn == null)
			return 0;

		try {

			// 2. tao doi tuong statement chua lech insert
			String sql = "insert tbBatch values(?,?,?)";
			PreparedStatement st = cn.prepareStatement(sql);

			// 3. dien gia tri cho doi so ? trong lenh insert
			st.setString(1, b.getBatchno());
			st.setString(2, b.getDescription());
			st.setInt(3, b.getFee());

			// 4. cho thi hanh lenh insert

			int r = st.executeUpdate();

			// 5. dong resource dang su dung
			cn.close();
			return r;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
	public static int update(Batch b) {
		// 1. tao ket noi den sem2_demo
		Connection cn = MyConnect.getcn();
		if (cn == null)
			return 0;

		try {

			// 2. tao doi tuong statement chua lech update
			String sql = "update tbBatch set description =?, fee=? where batchno=?";
			PreparedStatement st = cn.prepareStatement(sql);

			// 3. dien gia tri cho doi so ? trong lenh insert
			st.setString(1, b.getDescription());
			st.setInt(2, b.getFee());
			st.setString(3, b.getBatchno());

			// 4. cho thi hanh lenh update

			int r = st.executeUpdate();

			// 5. dong resource dang su dung
			cn.close();
			return r;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	
	public static int delete(String b) {
		// 1. tao ket noi den sem2_demo
		Connection cn = MyConnect.getcn();
		if (cn == null)
			return 0;

		try {

			// 2. tao doi tuong statement chua lech update
			String sql = "delete tbBatch where batchno=?";
			PreparedStatement st = cn.prepareStatement(sql);

			// 3. dien gia tri cho doi so ? trong lenh insert
			st.setString(1, b);

			// 4. cho thi hanh lenh update

			int r = st.executeUpdate();

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
