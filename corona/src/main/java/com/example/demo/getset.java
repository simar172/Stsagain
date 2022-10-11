package com.example.demo;

public class getset {
	String state;
	String cntry;
	int Case;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCntry() {
		return cntry;
	}

	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	public int getCase() {
		return Case;
	}

	public void setCase(int case1) {
		Case = case1;
	}

	public getset(String state, String cntry, int case1) {
		super();
		this.state = state;
		this.cntry = cntry;
		Case = case1;
	}

	@Override
	public String toString() {
		return "getset [state=" + state + ", cntry=" + cntry + ", Case=" + Case + "]";
	}
}
