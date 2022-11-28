package com.simplilearn.sportyshoes.dao;

import java.util.List;

import com.simplilearn.sportyshoes.entity.Purchase;

public interface PurchaseDao {

	public Purchase getPurchaseById(long id);

	public List<Purchase> getAllItems();

	public List<Purchase> getAllItemsByUserId(long userId);

	public long updatePurchase(Purchase purchase);

	public void deletePurchase(long id);

	long createPurchase(Purchase purchase);

}
