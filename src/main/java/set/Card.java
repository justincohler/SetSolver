package set;

public class Card {

	private Color color;
	private Symbol symbol;
	private Shading shading;
	private Integer count;

	Card() {

	}

	Card(Color color, Symbol symbol, Shading shading, int count) {
		this.color = color;
		this.symbol = symbol;
		this.shading = shading;
		this.count = count;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public Shading getShading() {
		return shading;
	}

	public void setShading(Shading shading) {
		this.shading = shading;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Card [" + color + ", " + symbol + ", " + shading + ", " + count + "]";
	}

}
