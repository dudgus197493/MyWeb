package com.tonic.web.entity;

public class QuoteVO {
	private int id;
	private String engContent;
	private String korContent;
	private String source;
	
	public QuoteVO(int id, String engContent, String korContent, String source) {
		this.id = id;
		this.engContent = engContent;
		this.korContent = korContent;
		this.source = source;
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
	@Override
	public String toString() {
		return "QuoteVO [id=" + id + ", korContent=" + korContent + ", engContent=" + engContent + ", source=" + source
				+ "]";
	}
	
}
