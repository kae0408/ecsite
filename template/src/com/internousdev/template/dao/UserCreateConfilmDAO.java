package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.internousdev.template.util.DBConnector;

public class UserCreateConfilmDAO {
	
	/*新規登録にIDが重複してないか確認するメソッド*/
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	
	private boolean resurt = false;
	
	public Map<String, Object> session;
	public boolean getUserInfo(String loginUserId, String loginPassword){
		String sql = "SELECT * FROM login_user_transaction";
	}


}
