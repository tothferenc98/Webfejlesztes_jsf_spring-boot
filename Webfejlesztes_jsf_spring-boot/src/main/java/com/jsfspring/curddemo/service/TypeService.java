
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.TypeUITO;

public interface TypeService {

	List<TypeUITO> getAllDepartment();

	TypeUITO getDepartment(TypeUITO departmentUITO);

}