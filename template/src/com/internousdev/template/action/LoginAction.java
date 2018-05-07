package com.internousdev.template.action;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	
	private String loginUserId;
	private String loginPassword;
	private String result;
	public Map<String, Object> session;
	
public String execute(){
	LoginDAO loginDAO =new LoginDAO();
	LoginDTO loginDTO =new LoginDTO();
	BuyItemDAO buyItemDAO =new BuyItemDAO();
	/*resultは結果と言う意味*/
	result = ERROR;
	/*loginDAOのgetLoginUserInfoメソッドを呼び出しインスタンス化したloginDTOに代入*/
	loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
	/*ページ間で変数の内容を維持するための仕組みSessionAwareインターフェースを利用します。*/
	/**/
	session.put("loginUser",loginDTO);
		
	//入力値からユーザーの情報の検索をします。ログイン情報が成功した場合、つぎの画面で「商品情報」が必要なため商品情報を取得します。
	if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
		
		result = SUCCESS;
		BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
		session.put("login_user_id",loginDTO.getLoginId());
		session.put("id", buyItemDTO.getId());
		session.put("buyItem_name", buyItemDTO.getItemName());
		session.put("buyItem_price", buyItemDTO.getItemPrice());
			 return result;
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

@Override
		public void setSession(Map<String, Object> session) {
		this.session = session;
		}

}




