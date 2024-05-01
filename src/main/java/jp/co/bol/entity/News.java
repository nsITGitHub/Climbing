package jp.co.bol.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//ジムの種類
	@Column(name = "Jim")
	private String bolJim;
	
	@Column(name = "month")
	private int bolMonth;
	
	@Column(name = "date")
	private int bolDate;
	
	@Column(name = "year")
	private int bolYear;
	
	@Column(name = "news")
	private String bolnews; 
	
	@Column(name = "link")
	private String bollink;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBolJim() {
		return bolJim;
	}
	public void setBolJim(String bolJim) {
		this.bolJim = bolJim;
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
	public int getBolYear() {
		return bolYear;
	}
	public void setBolYear(int bolYear) {
		this.bolYear = bolYear;
	}
	public String getBolnews() {
		return bolnews;
	}
	public void setBolnews(String bolnews) {
		this.bolnews = bolnews;
	}
	public String getBollink() {
		return bollink;
	}
	public void setBollink(String bollink) {
		this.bollink = bollink;
	}
}
