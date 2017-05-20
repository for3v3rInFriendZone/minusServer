package com.minusServer.www.app.mapper.service;

import java.util.List;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.model.Bill;

public interface BillMapperService {
	
	BillDto billToBillDTO(Bill bill);

	List<BillDto> billsToBillDTOs(List<Bill> bills);

	Bill billDTOToBill(BillDto billDTO);

	void updateBillFromBillDto(Bill bill, BillDto billDTO);

	List<Bill> billDTOsToBills(List<BillDto> billDTOs);

}
