package jp.co.bol.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "climbing")
public class Climbing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//場所の名前
	@Column(name = "name")
	private String bolName; 
	
	//ジムの種類
	@Column(name = "Jim")
	private String bolJim; 
	
	@Column(name = "text")
	private String bolText;
	
	@Column(name = "month")
	private int bolMonth;
	
	@Column(name = "date")
	private int bolDate;
	
	@Column(name = "year")
	private int bolYear;
	
	
	public String getBolJim() {
		return bolJim;
	}
	public void setBolJim(String bolJim) {
		this.bolJim = bolJim;
	}
	public int getBolYear() {
		return bolYear;
	}
	public void setBolYear(int bolYear) {
		this.bolYear = bolYear;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBolName() {
		return bolName;
	}
	public void setBolName(String bolName) {
		this.bolName = bolName;
	}
	public String getBolText() {
		return bolText;
	}
	public void setBolText(String bolText) {
		this.bolText = bolText;
	}
	public int getBolMonth() {
		return bolMonth;
	}
	public void setBolMonth(int bolMonth) {
		this.bolMonth = bolMonth;
	}
	public int getBolDate() {
		return bolDate;
	}
	public void setBolDate(int bolDate) {
		this.bolDate = bolDate;
	}

}
