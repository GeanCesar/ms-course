package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

public class Worker implements Serializable {
		
	private static final long serialVersionUID = 1L;	
	
	private long id;
	private String name;
	private Double dailyIncome;
	
	public Worker() {}	
	
	public Worker(long id, String name, Double daileIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = daileIncome;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getDailyIncome() {
		return dailyIncome;
	}
	
	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Worker other = (Worker) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
