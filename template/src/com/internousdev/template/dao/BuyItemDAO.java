package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;


public class BuyItemDAO {

		DBConnector dbConnector = new DBConnector();
		
		Connection connection = dbConnector.getConnection();
		
		private List<BuyItemDTO> buyItemDTOList=new ArrayList<BuyItemDTO>();
		
		//商品情報取得メソッド
		public List<BuyItemDTO> getBuyItemInfo(){
			String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction";
		
		
		try {
			PreparedStatement PreparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = PreparedStatement.executeQuery();
			
			while(resultSet.next()) {
				BuyItemDTO dto = new BuyItemDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrics(resultSet.getString("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				buyItemDTOList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTOList;
	}
		public List<BuyItemDTO> getBuyItemDTO() {
			return buyItemDTOList;
		}
}
	


