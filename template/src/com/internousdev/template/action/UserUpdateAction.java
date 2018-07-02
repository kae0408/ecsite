package com.internousdev.template.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateConfirmDAO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateAction extends ActionSupport implements SessionAware{

	private String loginUserId;

	private String loginPassword;

	private String userName;

	private String userAddress;

	private String userSex;

	private String userTell;

	private String userMail;

	public Map<String,Object> session;

	private String errorMessage;

private UserCreateConfirmDAO dao = new UserCreateConfirmDAO();

//実行メソッド
public String execute(){
	String result = SUCCESS;

	boolean idCheck = false;

	if(!(loginUserId.length() == 0) && !(loginPassword.length() == 0)
			&&!(userName.length() ==0) &&!(userAddress.length() ==0)
			&&!(userTell.length() ==0) &&!(userMail.length() ==0)){

		String defaultLoginId = ((LoginDTO) session.get("loginUser")).getLoginId();

		String defaultPassword =((LoginDTO) session.get("loginUser")).getLoginPassword();

		session.put("defaultLoginId", defaultLoginId);

		if(defaultLoginId.equals(loginUserId) || defaultPassword.equals(loginPassword)){

			//IDはそのままでPASSのみ変更する場合
			//IDの重複確認は不要なのでtrueを返す
			if(defaultLoginId.equals(loginUserId)){

			idCheck = true;

		}else{

			//IDを変更する場合(IDが既存のものと重複していないか
			//userCreateDAOで作ったメソッドで確認
			idCheck = dao.getUserInfo(loginUserId, loginPassword);

		}

		}
		else{

			//IDとPASSの両方を変更する
			idCheck = dao.getUserInfo(loginUserId, loginPassword);
		}

	if(idCheck){

		session.put("loginUserId", loginUserId);
		session.put("loginPassword", loginPassword);
		session.put("userName", userName);
		session.put("userAddress", userAddress);
		session.put("userSex", userSex);
		session.put("userTell", userTell);
		session.put("userMail", userMail);

	}else{

		setErrorMessage("同じIDまたはパスワードが存在します。");

		result = ERROR;
	}
	}

		//一番最初のifに合致しなかった場合
		//（（入力項目の長さが0の時）は下記の警告文を出す。
		else{

			setErrorMessage("未入力の項目があります。");

			result = ERROR;
		}

	return result;

	}


public String getLoginUserId() {
	return loginUserId;
}


public void setLoginUserId(String loginUserId) {
	this.loginUserId = loginUserId;
}


public String getLoginPassword() {
	return loginPassword;
}


public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getUserAddress() {
	return userAddress;
}


public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}


public String getUserSex() {
	return userSex;
}


public void setUserSex(String userSex) {
	this.userSex = userSex;
}


public String getUserTell() {
	return userTell;
}


public void setUserTell(String userTell) {
	this.userTell = userTell;
}


public String getUserMail() {
	return userMail;
}


public void setUserMail(String userMail) {
	this.userMail = userMail;
}


@Override
public void setSession(Map<String,Object> session){
	this.session = session;
}

public String getErrorMessage() {
	return errorMessage;
}

public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

}
