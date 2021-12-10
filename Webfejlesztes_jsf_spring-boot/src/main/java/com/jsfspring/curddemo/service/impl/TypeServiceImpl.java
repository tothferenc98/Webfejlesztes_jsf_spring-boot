/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.TypeDTO;
import com.jsfspring.curddemo.repositry.TypeRepo;
import com.jsfspring.curddemo.service.TypeService;
import com.jsfspring.curddemo.uito.TypeUITO;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeRepo typeRepo;

	@Override
	public List<TypeUITO> getAllDepartment() {
		List<TypeUITO> departmentUITOLst = new ArrayList<>();
		List<TypeDTO> typeDTOLst = typeRepo.findAll();

		typeDTOLst.forEach(dto -> {
			TypeUITO tmpUiTO = new TypeUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			departmentUITOLst.add(tmpUiTO);
		});

		return departmentUITOLst;
	}

	@Override
	public TypeUITO getDepartment(TypeUITO departmentUITO) {
		System.out.println(">>>>> "+departmentUITO.getTypeName());
		TypeDTO dto = typeRepo.findTitleByTypeName(departmentUITO.getTypeName());
		TypeUITO uito = new TypeUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}