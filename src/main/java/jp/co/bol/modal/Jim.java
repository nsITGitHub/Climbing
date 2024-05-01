package jp.co.bol.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class Jim {

	private String bolName; 

	private String bolJim;


	public String getBolName() {
		return bolName;
	}

	public void setBolName(String bolName) {
		this.bolName = bolName;
	}

	public String getBolJim() {
		return bolJim;
	}

	public void setBolJim(String bolJim) {
		this.bolJim = bolJim;
	} 
	
}
