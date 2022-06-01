package com.tonic.web.entity;

public class QuoteVO {
	private int id;
	private String engContent;
	private String korContent;
	private String source;
	private String category;
	
	public QuoteVO(int id, String engContent, String korContent, String source, String category) {
		this.id = id;
		this.engContent = engContent;
		this.korContent = korContent;
		this.setSource(source);
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKorContent() {
		return korContent;
	}
	public void setKorContent(String korContent) {
		this.korContent = korContent;
	}
	public String getEngContent() {
		return engContent;
	}
	public void setEngContent(String engContent) {
		this.engContent = engContent;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		if(source == null) {
			this.source = "Anonymous";
		}else {
			this.source = source;			
		}
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "QuoteVO [id=" + id + ", engContent=" + engContent + ", korContent=" + korContent + ", source=" + source
				+ ", category=" + category + "]";
	}
	
	
}
