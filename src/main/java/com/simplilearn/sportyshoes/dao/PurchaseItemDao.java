package com.simplilearn.sportyshoes.dao;

import java.util.List;

import com.simplilearn.sportyshoes.entity.PurchaseItem;

public interface PurchaseItemDao {

	public PurchaseItem getItemById(long id);

	public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId);

	void createItem(PurchaseItem item);
	
	public void updateItem(PurchaseItem item);

	public void deleteItem(long id);

	public void deleteAllItemsForPurchaseId(long purchaseId);

}
