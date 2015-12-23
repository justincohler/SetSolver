package set;

public enum Symbol {
	DIAMOND("diamond"), SQUIGGLE("squiggle"), OVAL("oval");
	
	String symbol;
	
	Symbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getValue() {
		return symbol;
	}
}
