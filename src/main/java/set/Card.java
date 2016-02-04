package set;

import java.util.Random;

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

    /**
     * For testing only -- in a game of set, the cards are not random, but rather all permutations of color, shade, symbol, and count
     *
     * @param random
     */
    @Deprecated
	Card(boolean random) {
		if (random) {
			int vcolors = Color.values().length;
			int vsymbols = Symbol.values().length;
			int vshading = Shading.values().length;
			int vcount = 3;

			Random r = new Random();
            int cint = r.nextInt(vcolors);
            int syint = r.nextInt(vsymbols);
            int shint = r.nextInt(vshading);
			this.color = Color.values()[cint];
			this.symbol = Symbol.values()[syint];
			this.shading = Shading.values()[shint];
			this.count = 1+ r.nextInt(vcount-1);
		}
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
