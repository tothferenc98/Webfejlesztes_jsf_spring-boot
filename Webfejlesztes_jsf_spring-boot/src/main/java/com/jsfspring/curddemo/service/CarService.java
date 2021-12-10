
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.CarUITO;

public interface CarService {
	CarUITO doSaveEmp(CarUITO carUiTO);

	List<CarUITO> doFetchAllEmp();

	CarUITO doGetEmp(CarUITO carUiTO);

	void doDeleteEmp(CarUITO carUiTO);
}