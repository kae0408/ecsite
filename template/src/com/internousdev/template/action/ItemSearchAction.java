package com.internousdev.template.action;

import java.util.ArrayList;
/*ArrayListクラスはJavaで配列を扱う為のクラスです
ArrayListクラスの最も便利な点の１つは、配列のサイズが自動的に拡張されていく為、作成時にサイズが解らなくとも使用できる事です。*/
import java.util.List;
/*配列と違い格納できるデータは参照型のみです。*/
import java.util.Map;

/*インターフェースは1つのキーに対して1つの値を保持するコレクションであり、
 * マップとしての振る舞いを規定しています。キーの重複は許可されておらず、格納できるデータは参照型のみになります。*/
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ItemSearchDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ItemSearchAction extends ActionSupport implements SessionAware {
	/*検索ワード*/
	private String searchWord;
	private String message;
	
	public Map<String,Object> session;
	
	/*検索結果格納List　インスタンス化*/
	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	
	/*検索結果取得 インスタンス化*/
	private ItemSearchDAO itemSearchDAO = new ItemSearchDAO();

	/*実行メソッド*/
	@SuppressWarnings("unchecked")
	public String execute() {
		String result = ERROR;
		
		//ワードを入力した時のみ実行
		if(searchWord.equals("")) {
			
			result = ERROR;
			buyItemDTOList = (List<BuyItemDTO>) session.get("buyItemDTOList");
			setMessage("該当する商品が見つかりませんでした。");
		}else {
			buyItemDTOList = ItemSearchDAO.getItemInfo(searchWord);
			
			if(buyItemDTOList.size() > 0) {
				session.put("buyItemDTOList",buyItemDTOList);
				int itemCount = buyItemDTOList.size();
				String count = Integer.toString(itemCount);
				setMessage(count + "件の商品が見つかりました");
				
				result = SUCCESS;
			}else {
				result = ERROR;
				buyItemDTOList = (List<BuyItemDTO>) session.get("BuyItemDTOList");
				setMessage("該当する商品が見つかりませんでした。");
			}
		}
		return result;
	}
	
	public String getsearchWord() {
		return searchWord;
	}
	public void setSearchWord() {
		this.searchWord = searchWord;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String string) {
		this.message = message;
	}
	
	public List<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}
	
	public void setBuyItemDTOList(List<BuyItemDTO>buyItemDTOList) {
		this. buyItemDTOList = buyItemDTOList;
	}
	
	@Override
	public void setSession(Map<String, Object> session){
		this.session=session;
	}
	
}
