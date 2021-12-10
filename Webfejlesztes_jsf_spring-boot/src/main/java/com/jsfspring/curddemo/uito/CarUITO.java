/**
 * 
 */
package com.jsfspring.curddemo.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class CarUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840260415183676656L;
	private Long carId;
	private String carName;
	private String license;
	private String cartypeId;
	private TypeUITO typeUITO;

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

	public TypeUITO getTypeUITO() {
		return typeUITO;
	}

	public void setTypeUITO(TypeUITO typeUITO) {
		this.typeUITO = typeUITO;
	}

	@Override
	public String toString() {
		return "CarUITO [carId=" + carId + ", carName=" + carName + ", license="
				+ license + ", cartypeId=" + cartypeId + ", typeUITO=" + typeUITO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarUITO other = (CarUITO) obj;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		return true;
	}

}
