package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{

	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;


	/**
	 * マイページ情報格納DTO
	 */
	//DTOをArrayList大きさが決まっていない配列としてインスタンス化
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	/**
	 * 削除フラグ
	 */
	private String deleteFlg;

	private String message;

	private List<BuyItemDTO> buyItemDTOList;


	/**
	 * 商品履歴取得メソッド
	 */
	//thorws例外処理 
	public String execute() throws SQLException {
		@SuppressWarnings("unchecked")
		List<BuyItemDTO> buyItemDTOList=(List<BuyItemDTO>) session.get("list");
		//containsKeyは指定したキーが存在するか確認を行い、キーが存在する場合はtrueを返します。
		if (!session.containsKey("id")) {
			//containsKeyは指定したキーが存在するか確認を行い、キーが存在する場合はtrueを返します。
			if(session.containsKey("masterId")){
				
			
				return "master";
			}

			return ERROR;
		}
		
		// 商品履歴を削除しない場合
		if(deleteFlg == null) {

			if(buyItemDTOList != null){
			for(int i=0; i<buyItemDTOList.size(); i++){

			String user_master_id = session.get("login_user_id").toString();

			//myPageDAO = メソッドを使うためのインスタンス
			MyPageDAO myPageDAO = new MyPageDAO();


			myPageList= myPageDAO.getMyPageUserInfo(user_master_id);
			session.put("myPageList", myPageList);
			}


			}else{
				String user_master_id = session.get("login_user_id").toString();
				MyPageDAO myPageDAO = new MyPageDAO();
				myPageList = myPageDAO.getMyPageUserInfo(user_master_id);
				session.put("myPageList", myPageList);
			}



			Iterator<MyPageDTO> iterator = myPageList.iterator();

			if (!(iterator.hasNext())) {
				myPageList = null;
			}

		// 商品履歴を削除する場合（下記のdeleteメソッド使用）
		} else{

			delete();
		}

		String result = SUCCESS;
		session.put("buyItemDTOList",buyItemDTOList);
		
		System.out.println("myPageList():"+myPageList);
		return result;
	}

	/**
	 * 商品履歴削除
	 */
	public void delete() throws SQLException {


		String user_master_id = session.get("login_user_id").toString();

		MyPageDAO myPageDAO = new MyPageDAO();
		int res = myPageDAO.buyItemHistoryDelete(user_master_id);

		if(res > 0) {

			myPageList = null;

			setMessage("商品情報を正しく削除しました。");

		} else if(res == 0) {

			setMessage("商品情報の削除に失敗しました。");
		}


	}



	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
