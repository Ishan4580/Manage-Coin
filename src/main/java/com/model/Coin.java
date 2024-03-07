package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class Coin {
	int id;
	String Country;
	String denomination;
	int yearOfMinting;
	BigDecimal currentValue;
	Date acquiredDate;
	
	public Coin() {
		// TODO Auto-generated constructor stub
	}

	public Coin(int id, String country, String denomination, int yearOfMinting, BigDecimal currentValue,
			Date acquiredDate) {
		super();
		this.id = id;
		Country = country;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.currentValue = currentValue;
		this.acquiredDate = acquiredDate;
	}

	public Coin(String country, String denomination, int yearOfMinting, BigDecimal currentValue, Date acquiredDate) {
		super();
		Country = country;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.currentValue = currentValue;
		this.acquiredDate = acquiredDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getYearOfMinting() {
		return yearOfMinting;
	}

	public void setYearOfMinting(int yearOfMinting) {
		this.yearOfMinting = yearOfMinting;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}

	public Date getAcquiredDate() {
		return acquiredDate;
	}

	public void setAcquiredDate(Date acquiredDate) {
		this.acquiredDate = acquiredDate;
	}

	@Override
	public String toString() {
		return "Coin [id=" + id + ", Country=" + Country + ", denomination=" + denomination + ", yearOfMinting="
				+ yearOfMinting + ", currentValue=" + currentValue + ", acquiredDate=" + acquiredDate + "]";
	}
	
	
}

