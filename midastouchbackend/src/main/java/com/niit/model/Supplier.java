package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Supplier
{
	@Id
	int SupplierId;
	String SuppDesc, SuppName;
	public int getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(int supplierId) {
		SupplierId = supplierId;
	}
	public String getSuppDesc() {
		return SuppDesc;
	}
	public void setSuppDesc(String suppDesc) {
		SuppDesc = suppDesc;
	}
	public String getSuppName() {
		return SuppName;
	}
	public void setSuppName(String suppName) {
		SuppName = suppName;
	}
	

}
