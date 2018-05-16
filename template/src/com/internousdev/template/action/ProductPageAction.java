package com.internousdev.template.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	
	private BuyItemDAO buyItemDAO =new BuyItemDAO();
	
	private List<BuyItemDTO> buyItemDTOList;
	
	public String execute() {
		String ret;
		
		if(session.containsKey("id")) {
			buyItemDTOList = buyItemDAO.getBuyItemInfo();
			session.put("buyItemDTOList", buyItemDTOList);
			ret = SUCCESS;
			
		}else if(session.containsKey("masterld")) {
			
			buyItemDTOList = buyItemDAO.getBuyItemInfo();
			session.put("buyItemDTOList", buyItemDTOList);
			ret = "master";
			
		}else{
			
			ret=ERROR;
			buyItemDTOList = buyItemDAO.getBuyItemInfo();
			session.put("buyItemDTOList", buyItemDTOList);
			
		}
		return ret;
	}

	public List<BuyItemDTO> getBuyItemDTOList(){
		return buyItemDTOList;
	}
	
	public void setBuyItemDTOList(List<BuyItemDTO>buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}
	
	public Map<String,Object>getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
