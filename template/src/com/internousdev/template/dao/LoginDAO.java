package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;


public class LoginDAO {
	private DBConnector dbConnecter =new DBConnector();
	private Connection connection = dbConnecter.getConnection();
	private LoginDTO loginDTO = new LoginDTO();
	//メソッド名getLoginUserInfo
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
		String sql = "SELECT * FROM login_user_transaction where login_id = ?AND login_pass = ? ";
		
	try {
		/*セキュリティに考慮してjavaではPreparedStatementを使う*/
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		/*SQL文の「？」パラメーターに指定した値を挿入することができます。*/
		preparedStatement.setString(1,loginUserId);
		preparedStatement.setString(2,loginPassword);
		
		//SELECT命令を実行するためのもの
		ResultSet resultSet = preparedStatement.executeQuery();
	if(resultSet.next()) {
		loginDTO.setLoginId(resultSet.getString("login_id"));
		loginDTO.setLoginPassword(resultSet.getString("login_pass"));
		loginDTO.setUserName(resultSet.getString("user_name"));
		
		if(!(resultSet.getString("login_id").equals(null))) {
			loginDTO.setLoginFlg(true);
		}
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return loginDTO;
	}
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
