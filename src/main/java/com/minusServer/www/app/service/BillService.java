package com.minusServer.www.app.service;

import java.util.List;

import com.minusServer.www.app.dto.BillDto;


public interface BillService {

	public BillDto save(BillDto billDTO);

	public BillDto findOne(Integer id);

	public List<BillDto> findAll();

	public void delete(Integer id);

	public void deleteAll();

	public List<BillDto> findUserBills(Integer userId);
}
