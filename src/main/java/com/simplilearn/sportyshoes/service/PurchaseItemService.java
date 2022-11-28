package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.sportyshoes.dao.PurchaseItemDao;
import com.simplilearn.sportyshoes.entity.PurchaseItem;

@Service
@Transactional
public class PurchaseItemService {

	@Autowired
	private PurchaseItemDao purchaseItemDao;

	@Transactional
	public PurchaseItem getItemById(long id) {
		return purchaseItemDao.getItemById(id);

	}

	@Transactional
	public List<PurchaseItem> getAllItemsByPurchaseId(long purchaseId) {
		return purchaseItemDao.getAllItemsByPurchaseId(purchaseId);
	}

	@Transactional
	public void updateItem(PurchaseItem item) {
		if(item.getID() == Long.valueOf(0)) {
			purchaseItemDao.createItem(item);
			return;
		}
		
		purchaseItemDao.updateItem(item);
	}

	@Transactional
	public void deleteItem(long id) {
		purchaseItemDao.deleteAllItemsForPurchaseId(id);
	}

	@Transactional
	public void deleteAllItemsForPurchaseId(long purchaseId) {
		purchaseItemDao.deleteAllItemsForPurchaseId(purchaseId);
	}

}
