package set;

public enum Shading {
	SOLID("solid"), STRIPED("striped"), OPEN("open");
	
	String shading;
	
	Shading(String shading) {
		this.shading = shading;
	}
	
	public String getValue() {
		return shading;
	}
}
