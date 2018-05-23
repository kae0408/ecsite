package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.util.DBConnector;


public class BuyItemDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	/**
	 * 商品情報取得メソッド
	 */

	public List<BuyItemDTO> getBuyItemInfo() {

		String sql = "SELECT id, item_name, item_price, item_stock, item_category, item_description, img_file_path FROM item_info_transaction";

		//DBから取得した値をBuyItemDTOの変数に格納
		//BuyItemDTOに格納した値をBuyItemDTOListに格納

		try {
			//sqlに接続します
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//検索結果を持ってくる
			ResultSet resultSet = preparedStatement.executeQuery();
			//もし一文でもあったら下記を実行
			while(resultSet.next()) {

				BuyItemDTO dto = new BuyItemDTO();

				dto.setId(resultSet.getInt("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getInt("item_price"));
				dto.setItem_stock(resultSet.getInt("item_stock"));
				dto.setItem_category(resultSet.getString("item_category"));
				dto.setItem_description(resultSet.getString("item_description"));
				dto.setImage_file_path(resultSet.getString("img_file_path"));

				buyItemDTOList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return buyItemDTOList;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}
}