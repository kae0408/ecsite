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
	//ログインで入力したIDとPASSをデータベースから検索する
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword) {
		String sql = "SELECT * FROM login_user_transaction where login_id = ?AND login_pass = ? ";
		
	try {
		/*セキュリティに考慮してjavaではPreparedStatementを使う*/
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		//SQL文のlogin_id = ?が１で　login_pass = ?が２preparedStatementにセット
		preparedStatement.setString(1,loginUserId);
		preparedStatement.setString(2,loginPassword);
		
		//データベースから持ってきた上の情報をresultSetに代入
		ResultSet resultSet = preparedStatement.executeQuery();
		//resultSetに次のデータだ入っている限りifで回し続ける
	if(resultSet.next()) {
		//loginDTOに入れていく
		loginDTO.setLoginId(resultSet.getString("login_id"));
		loginDTO.setLoginPassword(resultSet.getString("login_pass"));
		loginDTO.setUserName(resultSet.getString("user_name"));
		loginDTO.setUserAddress(resultSet.getString("user_address"));
		loginDTO.setUserSex(resultSet.getString("user_sex"));
		loginDTO.setUserTell(resultSet.getString("user_tell"));
		loginDTO.setUserMail(resultSet.getString("user_mail"));
		
		//もしresultSetにlogin_idが空だったらエラー
		if(!(resultSet.getString("login_id").equals(null))) {
			loginDTO.setLoginFlg(true);
		}
	}
	}catch(Exception e) {
		e.printStackTrace();
	}
	//上で作ったものをloginDTOとして返す。
	return loginDTO;
	}
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
