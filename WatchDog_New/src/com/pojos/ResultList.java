package com.pojos;

public class ResultList {
	private int firm_id;
	private int trader_id;
	private int broker_id;
	public int getFirm_id() {
		return firm_id;
	}
	public void setFirm_id(int firm_id) {
		this.firm_id = firm_id;
	}
	public int getTrader_id() {
		return trader_id;
	}
	public void setTrader_id(int trader_id) {
		this.trader_id = trader_id;
	}
	public int getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(int broker_id) {
		this.broker_id = broker_id;
	}
	
	public ResultList() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultList(int firm_id, int trader_id, int broker_id) {
		super();
		this.firm_id = firm_id;
		this.trader_id = trader_id;
		this.broker_id = broker_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Trader_id: "+ trader_id +" Broker_id: "+ broker_id +" firm_id: "+ firm_id;
	}
	
	

}
