package vn.iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.configs.DBConnectSQL;
import vn.iostar.dao.IUserDao;
import vn.iostar.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		
		List <UserModel> list = new ArrayList<>(); //Tạo một list để truyền dữ liệu
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*next từng dòng đến cuối bảng */) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("images"), rs.getString("fullname")));
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE id = " + id + "";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				UserModel user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("images"), rs.getString("fullname"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		
		String sql = "INSERT INTO users(id, username, password, images, fullname) VALUES (?, ?, ?, ?, ?)";
		
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImages());
			ps.setString(5, user.getFullname());
			
			int t = ps.executeUpdate();
			
			if(t>0)
				System.out.println("Them Thanh Cong");
			else
				System.out.println("Them That Bai");

		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
		}
		
	}

	

	public static void main(String[] arg) {

		UserDaoImpl userDao = new UserDaoImpl();
		
		/* 
		UserModel user1 = userDao.findById(1);
		if (user1 != null) 
			System.out.println(user1);
		else 
			System.out.println("Khong tim thay user");
		*/
		
		
		List<UserModel> list = userDao.findAll();
		for (UserModel user : list) {
			System.out.println(user);
		}
		
		
		/*
		UserModel user = new UserModel(5, "hokimtri4", "14", null, "Tri Kim");
		userDao.insert(user);
		*/
}



}
