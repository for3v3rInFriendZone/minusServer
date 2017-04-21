package com.minusServer.www.app.service;

import com.minusServer.www.app.model.Bill;

public interface BillService {

	public Bill save(Bill bill);

	public Bill findOne(Long id);

	public Iterable<Bill> findAll();

	public void delete(Long id);

	public void delete(Bill bill);

	public void deleteAll();

}
