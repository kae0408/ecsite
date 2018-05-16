package com.internousdev.template.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.CategorySearchDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CategorySearchAction extends ActionSupport implements SessionAware{
	
	public Map<String,Object>session;
	
	private String sortCategory;
	
	private List<BuyItemDTO> buyItemDTOList;
	
	public String execute() {
		String result = ERROR;
		
		if(session.containsKey("id")) {
			session.put("sortCategory",sortCategory);
			
			CategorySearchDAO categorySearchDAO = new CategorySearchDAO();
			
			buyItemDTOList = categorySearchDAO.getBuyItemInfo(sortCategory);
			
			session.put("buyItemDTOList", buyItemDTOList);
			
			if(sortCategory == "all") {
				BuyItemDAO buyItemDAO =new BuyItemDAO();
				
				buyItemDTOList = buyItemDAO.getBuyItemInfo();
				
				session.put("buyItemDTOList",buyItemDTOList);
			}
			
			result = SUCCESS;
			
			if(session.containsKey("masterld")) {
				session.put("sortCategory", sortCategory);
				
				buyItemDTOList = categorySearchDAO.getBuyItemInfo(sortCategory);
				
				session.put("buyItemDTOList", buyItemDTOList);
				
				if(sortCategory == "all") {
					BuyItemDAO buyItemDAO =new BuyItemDAO();
					
					buyItemDTOList = buyItemDAO.getBuyItemInfo();
					
					session.put("buyItemDTOList", buyItemDTOList);
				}
				result = SUCCESS;
			}
		}else {
			
			session.put("sortCategory", sortCategory);
			
			CategorySearchDAO categorySearchDAO = new CategorySearchDAO();
			
			buyItemDTOList = categorySearchDAO.getBuyItemInfo(sortCategory);
			
			session.put("buyItemDTOList", buyItemDTOList);
			
			if(sortCategory == "all") {
				BuyItemDAO buyItemDAO = new BuyItemDAO();
				
				buyItemDTOList = buyItemDAO.getBuyItemInfo();
				
				session.put("buyItemDTOList", buyItemDTOList);
			}
			result = ERROR;
			
		}
		return result;
	}

	public String getSortCategory() {
		return sortCategory;
	}

	public void setSortCategory(String sortCategory) {
		this.sortCategory = sortCategory;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

