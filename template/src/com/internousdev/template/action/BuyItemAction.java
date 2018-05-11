package com.internousdev.template.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	
	private ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<>();
	/*アイテム購入個数*/
	private List<String> count;
	
	/*支払い方法*/
	private int pay;
	
	/*アイテム情報を格納*/
	public Map<String,Object> session;
	
	/*商品情報取得メソッド*/
	public String execute() {
		String result = SUCCESS;
		// LoginActionで保管したbuyItemDTOListの値を使いたい。
		// "buyItemDTOList"という鍵にbuyItemDTOListが保管されているから取得している。
		//= (List<BuyItemDTO>) session.get("buyItemDTOList");
		
		session.put("count", count);
		@SuppressWarnings("unchecked")
		List<BuyItemDTO> list = (List<BuyItemDTO>) session.get("buyItemDTOList");
		
		/*ここから繰り返したい*/
		/*List型*/
		/*取得値 : get(添字)
		 * サイズ取得 * .size();
		 */
		/*ここから合計金額を計算する処理*/
		for(int i =0; i <count.size(); i++) {
			BuyItemDTO buyItemDTO = new BuyItemDTO();
			
			String buyItemName = list.get(i).getItemName();
			session.put("itemName",buyItemName);
			
			String buyItemPrice = list.get(i).getItemPrice();
			session.put("itemPrice",buyItemPrice);
			
			int buyItemId = list.get(i).getId();
			session.put("id", buyItemId);
			
			int item_stock = list.get(i).getItem_stock();
			
			int intCount = Integer.parseInt(count.get(i));
			int intPrice = Integer.parseInt(list.get(i).getItemPrice());
			
			/*引数がString型のため、toStringでString型に変換する。->int型で保管したいのでparseIntでintに変換している。*/
			
			if(intCount != 0) {
				buyItemDTO.setId((int) session.get("Id"));
				buyItemDTO.setItemName(session.get("itemPrice").toString());
				buyItemDTO.setCount(intCount);
				buyItemDTO.setItem_stock(item_stock);
				buyItemDTO.setTotal_price(intCount * intPrice);
				session.put("total_price",intCount * intPrice);
				/** ここまで合計 */


				/** ここから支払い方法を選択する処理 */
				String payment;
				if(pay == 1) {
					payment = "現金払い";
					session.put("pay",payment);
				}
			}
		}
	}
	
	
	private int stock;
	private String pay;
	public Map<String, Object> session;
	private String result;
	
	public String execute() {
		result = SUCCESS;
		
		session.put ("stock",stock);
		int intStock = Integer.parseInt(session.get("stock").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		
		session.put("buyItem_price",intStock * intPrice);
		String payment;
		
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay",payment);
		}else {
			payment = "クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	@Override
	public void setSession(Map<String, Object>session) {
		this.session = session;
	}

}
