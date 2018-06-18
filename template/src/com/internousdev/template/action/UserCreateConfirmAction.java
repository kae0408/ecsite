package com.internousdev.template.action;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateConfilmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	
	private String loginUserId;

	private String loginPassword;

	private String userName;

	private String userAddress;

	private String userSex;

	private String userTell;

	private String userMail;

	public Map<String,Object> session;

	private String errorMessage;

	public String execute() {

		String result = SUCCESS;

		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))
				&& !(userAddress.equals(""))
				&& !(userTell.equals(""))
				&& !(userMail.equals(""))) {

			UserCreateConfilmDAO userCreateConfirmDAO = new UserCreateConfilmDAO();
			boolean checkId = userCreateConfirmDAO.getUserInfo(loginUserId,loginPassword);

			if(checkId){
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName", userName);
				session.put("userAddress", userAddress);
				session.put("userSex", userSex);
				session.put("userTell", userTell);
				session.put("userMail", userMail);

			} else {

					setErrorMessage("同じID、もしくはパスワードが存在します。");

					result = ERROR;
				}

		}else{
				setErrorMessage("未入力の項目があります。");

				result = ERROR;

				}return result;

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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
