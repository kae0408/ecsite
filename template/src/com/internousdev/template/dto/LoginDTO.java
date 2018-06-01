package com.internousdev.template.dto;

public class LoginDTO {

		/**
		 * ユーザー情報を保管する変数
		 */

		private String loginId;

		private String loginPassword;

		private String userName;

		private String userAddress;

		private String userSex;

		private String userTell;

		private String userMail;

		//↓idを格納する変数
		private String userNumber;

		//ログインチェックに使用
		private boolean loginFlg = false;

		//管理者IDでのログインチェックに使用
		private boolean loginMaster = false;



		public String getLoginId() {
			return loginId;
		}

		public void setLoginId(String loginId) {
			this.loginId = loginId;
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

		public String getUserNumber() {
			return userNumber;
		}

		public void setUserNumber(String userNumber) {
			this.userNumber = userNumber;
		}

		public boolean getLoginFlg() {
			return loginFlg;
		}

		public void setLoginFlg(boolean loginFlg) {
			this.loginFlg = loginFlg;
		}

		public boolean getLoginMaster(){
			return loginMaster;
		}

		public void setLoginMaster(boolean loginMaster){
			this.loginMaster = loginMaster;
		}
	}

