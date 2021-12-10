/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.TypeService;
import com.jsfspring.curddemo.service.CarService;
import com.jsfspring.curddemo.uito.TypeUITO;
import com.jsfspring.curddemo.uito.CarUITO;

@Controller("carController")
@SessionScope
public class CarController {
	@Autowired
	private CarService carService;

	@Autowired
	private TypeService typeService;

	private String actionLabel;
	private CarUITO carUiTO;
	private List<CarUITO> carUiToList;

	private List<TypeUITO> typeUiToList;

	/**
	 * add or update new Record in DB
	 * 
	 * @return
	 */
	public void doSaveInfoEmpl() {
		System.out.println(this.getCarUiTO());
		carService.doSaveEmp(this.getCarUiTO());
		getAllEmpl();
		this.setCarUiTO(new CarUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Car Details", "Car Details added/Updated Successfully."));

	}

	/**
	 * Default load all the Employee info
	 */
	@PostConstruct
	public void getAllEmpl() { 
		if (!this.getCarUiToList().isEmpty()) {
			this.getCarUiToList().clear();
			this.getTypeUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + carService);
		this.getCarUiToList().addAll(carService.doFetchAllEmp());
		this.getTypeUiToList().addAll(typeService.getAllDepartment());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected Employee info
	 * 
	 * @return
	 */

	public void deleteEmployee(CarUITO carUiTO) {
		carService.doDeleteEmp(carUiTO);
		getAllEmpl();
	}

	public void editEmployee(CarUITO carUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(carUiTO, this.getCarUiTO());
		System.out.println(this.getCarUiTO());
	}

	public CarUITO getCarUiTO() {
		if (carUiTO == null) {
			carUiTO = new CarUITO();
		}
		return carUiTO;
	}

	public void setCarUiTO(CarUITO carUiTO) {
		this.carUiTO = carUiTO;
	}

	public List<CarUITO> getCarUiToList() {
		if (null == carUiToList) {
			carUiToList = new ArrayList<>();
		}
		return carUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<TypeUITO> getTypeUiToList() {
		if (typeUiToList == null) {
			typeUiToList = new ArrayList<>();
		}
		return typeUiToList;
	}

	public void setTypeUiToList(List<TypeUITO> typeUiToList) {
		this.typeUiToList = typeUiToList;
	}
}