package com.internousdev.template.action;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


/*
 * ログイン認証処理
 * Login.jspからログインID、ログインパスワードを受け取り
 * DBへ問い合わせを行います。
 * @author internous
 * @param loginUserId
 * @param loginPassword
 *
 * @return result
 */
public class LoginAction extends ActionSupport implements SessionAware {
	//ログインID
	private String loginUserId;
	//ログインパスワード
	private String loginPassword;
	//ログイン情報を格納
	public Map<String, Object> session;
	//ログイン情報DAO
	private LoginDAO loginDAO = new LoginDAO();
	//ログイン情報DTO
	private LoginDTO loginDTO = new LoginDTO();
	
	//アイテム情報を取得
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private List<BuyItemDTO> buyItemDTOList;
	
	//実行メソッド
public String execute(){
	String result = ERROR;
	//ログイン実行
	//loginDAOでデータベースから検索した(ログイン画面で入力した)ID PASSをloginDTOに代入
	loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
	//sessionにキーloginUserでloginDTOを保存
	session.put("loginUser", loginDTO);
	
	//マスターのユーザーと分ける
	//もしLoginMasterだったら
	if(((LoginDTO) session.get("loginUser")).getLoginMaster()){
		//getBuyItemInfoの情報をbuyItemDTOListに代入
		buyItemDTOList=buyItemDAO.getBuyItemInfo();
		session.put("buyItemDTOList", buyItemDTOList);
		session.put("masterId", loginUserId);
		//masterのmaster.jspに行く
		result = "master";
	}
	
	//もしmasterじゃなかったらSUCCESSでbuyItem.jspに行く
	if(result != "master") {
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
			
			//アイテム情報を取得
			//buyItemDAOのBuyItemInfoに入ってるBuyItemInfoの情報をbuyItemDTOListに代入
			buyItemDTOList = buyItemDAO.getBuyItemInfo();
			
			//BuyItemActionで利用したいので"buyItemDTOList"と言う鍵でbuyItemDTOListのデータを保管する
			session.put("buyItemDTOList", buyItemDTOList);
			session.put("id",buyItemDTO.getId());
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("userName", loginDTO.getUserName());
			session.put("userAddress", loginDTO.getUserAddress());
			session.put("userSex", loginDTO.getUserSex());
			session.put("userTell", loginDTO.getUserTell());
			session.put("userMail", loginDTO.getUserMail());
		}
	}

	return result;
	/*resultは結果と言う意味*/
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
		
		public List<BuyItemDTO> getBuyItemDTOList(){
			return buyItemDTOList;
		}
		public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList){
			this.buyItemDTOList=buyItemDTOList;
		}


@Override
		public void setSession(Map<String, Object> session) {
		this.session = session;
		}

}




