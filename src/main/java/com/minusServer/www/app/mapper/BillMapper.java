package com.minusServer.www.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.minusServer.www.app.dto.BillDto;
import com.minusServer.www.app.model.Bill;

@Mapper(componentModel = "spring", uses = { ReferenceMapper.class, ItemMapper.class })
public interface BillMapper {

	@Mapping(source = "user.id", target = "userId")
	BillDto billToBillDTO(Bill bill);

	List<BillDto> billsToBillDTOs(List<Bill> bills);

	@Mapping(source = "userId", target = "user")
	Bill billDTOToBill(BillDto billDTO);

	@Mapping(source = "userId", target = "user")
	void updateBillFromBillDto(@MappingTarget Bill bill, BillDto billDTO);

	List<Bill> billDTOsToBills(List<BillDto> billDTOs);
	
}
