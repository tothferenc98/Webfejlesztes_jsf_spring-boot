package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "TYPE_MASTER")
public class TypeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TYPE_ID")
	private Long typeId;
	@Column(name = "Type_Name")
	private String typeName;

	@OneToMany(mappedBy = "typeDTO")
	private List<CarDTO> cardtolst;

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

	public List<CarDTO> getCardtolst() {
		if (null == cardtolst) {
			cardtolst = new ArrayList<>();
		}
		return cardtolst;
	}

	public void setCardtolst(List<CarDTO> cardtolst) {
		this.cardtolst = cardtolst;
	}
}
