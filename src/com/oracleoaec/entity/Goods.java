package com.oracleoaec.entity;

public class Goods {
	private Long g_id;
	private String g_name;
	private Long g_count;
	private float g_price;
	public Goods() {
		super();
	}
	public Goods(String g_name, Long g_count, float g_price) {
		this.g_name = g_name;
		this.g_count = g_count;
		this.g_price = g_price;
	}
	public Goods(Long g_id, String g_name, Long g_count, float g_price) {
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_count = g_count;
		this.g_price = g_price;
	}
	public Long getG_id() {
		return g_id;
	}
	public void setG_id(Long g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public Long getG_count() {
		return g_count;
	}
	public void setG_count(Long g_count) {
		this.g_count = g_count;
	}
	public float getG_price() {
		return g_price;
	}
	public void setG_price(float g_price) {
		this.g_price = g_price;
	}
	@Override
	public String toString() {
		return "Goods [g_id=" + g_id + ", g_name=" + g_name + ", g_count=" + g_count + ", g_price=" + g_price + "]";
	}
	
	
}
