package com.internousdev.template.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	
	public Map<String,Object>session;
	
	// List <データ型> オブジェクト名 = new ArrayList<データ型>();
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	
	//商品購入情報メソッド
	@SuppressWarnings("unchecked")
	public String execute() throws SQLException{
		String result = ERROR;
		/**
		 * 実行メソッド（商品一覧に載せる商品情報の取得）
		 */
		
		//BuyItemActionの キー"List" で色々詰め込んだbuyItemDTOList値を取得
		//そしてnewしたbuyItemDTOListに代入
		//最初のbuyItemDTOListはnewしたlist型
		
		buyItemDTOList = (ArrayList<BuyItemDTO>) session.get("list");
		
		for(int i = 0; i < buyItemDTOList.size(); i++) {
			
			int stock = buyItemDTOList.get(i).getItem_stock();
					
			int id = buyItemDTOList.get(i).getId();	
			
			int total_price = buyItemDTOList.get(i).getTotal_price();
			
			int count = buyItemDTOList.get(i).getCount();
			
			int item_stock = stock - count;
			
			
			if(item_stock < 0) {
				result = ERROR;
			}else {
				//buyItemCompleteDAOで定義したメソッドを使う
				BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
				
				buyItemCompleteDAO.buyItemeInfo(
						id,
						session.get("login_user_id").toString(),
						total_price,
						count,
						buyItemDTOList.get(i).getPay(),
						item_stock);
				result = SUCCESS;
			}
		}
		return result;
	}
	@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
	}
		}
