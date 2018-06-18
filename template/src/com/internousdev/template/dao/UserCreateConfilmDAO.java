package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.internousdev.template.util.DBConnector;

public class UserCreateConfilmDAO {

	/**
	 * 新規登録時にIDが重複していないか確認するメソッド
	 */

	private DBConnector db = new DBConnector();

	private Connection con = db.getConnection();

	private boolean result =false;

	public Map<String, Object> session;

	public boolean getUserInfo(String loginUserId, String loginPassword){

		String sql="SELECT * FROM login_user_transaction";

		try{
			//データベースに対するSQL文を実行するために使われます
			PreparedStatement ps = con.prepareStatement(sql);
			//result =結果 executeQuery=実行したクエリ（SQL文）
			ResultSet rs = ps.executeQuery();
			
			//ResultSet 対象要素の次に配置されている要素だけを取得
			//次の対象があるだけ　while文で回す　
			while(rs.next()){
				
				//持ってきた結果の中の文字列login_idをloginIdに代入
				String loginId = rs.getString("login_id");
				String password = rs.getString("login_pass");
				
				//もしloginIdが等しかったら　かつ　passwordも等しかったら
				//equals = 等しい
				if(loginId.equals(loginUserId) || password.equals(loginPassword)){


					//もしIDが　IDが重複していたらfalse
					if(loginId.equals(loginUserId)){
						//falseをresultに代入
						result = false;
						//resultを返す
						return result;

						//パスワードのみ重複していたらtrue
					}else{
						result = true;
					}

				}else{

					//IDもパスワードも同じではない時はtrue
					result = true;
				}
			}

		}catch(Exception e){
			//エラーをだす
			e.printStackTrace();
		}

		return result;
	}



	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session=session;
	}
}


