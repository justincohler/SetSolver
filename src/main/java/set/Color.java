package set;

public enum Color {
	RED("red"), GREEN("green"), PURPLE("purple");
	
	String color;
	
	Color(String color) {
		this.color = color;
	}
	
	public String getValue() {
		return color;
	}
}
