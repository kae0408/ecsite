package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;

public class CategorySearchDAO {
	
	private DBConnector dbConnector = new DBConnector();
	
	private Connection connection = dbConnector.getConnection();
	
	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	
	/**
	 * カテゴリソートのメソッド
	 * 選択されたカテゴリの商品のみ商品情報を取得する
	 */
	
	public List<BuyItemDTO>getBuyItemInfo(String sortCategory){
		String sql = "SELECT*FROM item_info_transaction WHERE item_category =?";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			
			preparedStatement.setString(1,sortCategory);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				BuyItemDTO dto = new BuyItemDTO();
				
				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getInt("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				dto.setItem_category(resultSet.getString("item_category"));
				dto.setItem_description(resultSet.getString("item_description"));
				dto.setImage_file_path(resultSet.getString("image_file_path"));

				buyItemDTOList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return buyItemDTOList;
	}
	public List<BuyItemDTO>getBuyItemDTOList(){
		return buyItemDTOList;
	}
	}


