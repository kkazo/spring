package com.kkazo.core.type;

public enum Boolean implements Symbolic {

	TRUE("T"), FALSE("F");

	private String symbol;

	Boolean(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}
