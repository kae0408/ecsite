package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.ItemInsertDTO;
import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;


public class ItemSearchDAO {
	private DBConnector dbConnector = new DBConnector();
	
	private Connection connection = dbConnector.getConnection();
	
	private ItemInsertDTO itemInsertDTO = new ItemInsertDTO();
	
	private DateUtil dateUtil = new DateUtil();
	
	private String sql="INSERT INTO item_info_transaction (item_name, item_price, item_stock, insert_date) VALUES (?, ?, ?, ?)";
	
	public ItemInsertDTO itemInsertInfo(String itemName,String itemPrice, String itemStock) throws SQLException{
		
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, itemPrice);
			ps.setString(3, itemStock);
			ps.setString(4, dateUtil.getDate());
			
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return itemInsertDTO;
	}

	public static List<BuyItemDTO> getItemInfo(String searchWord) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
			

}
