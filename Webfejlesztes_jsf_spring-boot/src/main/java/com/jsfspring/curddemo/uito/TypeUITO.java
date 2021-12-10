package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class TypeUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long typeId;
	private String typeName;

	private List<CarUITO> carUITOLst;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<CarUITO> getCarUITOLst() {
		return carUITOLst;
	}

	public void setCarUITOLst(List<CarUITO> carUITOLst) {
		this.carUITOLst = carUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		TypeUITO other = (TypeUITO) obj;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}

}
