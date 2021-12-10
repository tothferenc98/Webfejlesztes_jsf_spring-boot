/**
 * 
 */
package com.jsfspring.curddemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

/**
 * @author s727953
 *
 */

@Entity
@Table(name = "CAR_INFO")
@NamedQuery(name = "CarDTO.findAll", query = "SELECT a FROM CarDTO a")
public class CarDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long carId;
	@Column(name = "CAR_NAME", nullable = false)
	private String carName;
	@Column(name = "LICENSE")
	private String license;
	@Column(name = "CARTYPE_ID")
	private String cartypeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	private TypeDTO typeDTO;

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}


	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getCartypeId() {
		return cartypeId;
	}

	public void setCartypeId(String cartypeId) {
		this.cartypeId = cartypeId;
	}

	public TypeDTO getTypeDTO() {

		return typeDTO;
	}

	public void setTypeDTO(TypeDTO typeDTO) {
		this.typeDTO = typeDTO;
	}

}
