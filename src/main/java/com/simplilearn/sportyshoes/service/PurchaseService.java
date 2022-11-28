package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplilearn.sportyshoes.dao.PurchaseDao;
import com.simplilearn.sportyshoes.entity.Purchase;

@Service
@Transactional
public class PurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;

	@Transactional
	public Purchase getPurchaseById(long id) {
		return purchaseDao.getPurchaseById(id);
	}

	@Transactional
	public List<Purchase> getAllItems() {
		return purchaseDao.getAllItems();
	}

	@Transactional
	public List<Purchase> getAllItemsByUserId(long userId) {
		return purchaseDao.getAllItemsByUserId(userId);
	}

	@Transactional
	public long updatePurchase(Purchase purchase) {
		if(purchase.getID() == Long.valueOf(0)) {
			return purchaseDao.createPurchase(purchase);
		}
		
		return purchaseDao.updatePurchase(purchase);
	}

	@Transactional
	public void deletePurchase(long id) {
		purchaseDao.deletePurchase(id);
	}

}
