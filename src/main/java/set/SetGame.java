package set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetGame {

	public List<List<Card>> findSets(List<Card> cards) {
		List<List<Card>> sets = new ArrayList<List<Card>>();
		List<List<Card>> combos = combinations(cards, new ArrayList<List<Card>>());
		for (List<Card> combo : combos) {
			if (isSet(combo.get(0), combo.get(1), combo.get(2))) {
				sets.add(combo);
			}
		}
		return sets;
	}

	public boolean isSet(Card c1, Card c2, Card c3) {
		boolean colorCheck = false;
		boolean symbolCheck = false;
		boolean shadingCheck = false;
		boolean countCheck = false;
		// find falsehoods in sets
		// color
		if (c1.getColor().equals(c2.getColor()) || c2.getColor().equals(c3.getColor())
				|| c1.getColor().equals(c3.getColor())) {
			// check if all colors are the same
			if (c1.getColor().equals(c2.getColor()) && c2.getColor().equals(c3.getColor())) {
				colorCheck = true;
			}
		} else {
			colorCheck = true;
		}
		// symbol
		if (c1.getSymbol().equals(c2.getSymbol()) || c2.getSymbol().equals(c3.getSymbol())
				|| c1.getSymbol().equals(c3.getSymbol())) {
			// check if all symbols are the same
			if (c1.getSymbol().equals(c2.getSymbol()) && c2.getSymbol().equals(c3.getSymbol())) {
				symbolCheck = true;
			}
		} else {
			symbolCheck = true;
		}
		// shading
		if (c1.getShading().equals(c2.getShading()) || c2.getShading().equals(c3.getShading())
				|| c1.getShading().equals(c3.getShading())) {
			// check if all shadings are the same
			if (c1.getShading().equals(c2.getShading()) && c2.getShading().equals(c3.getShading())) {
				shadingCheck = true;
			}
		} else {
			shadingCheck = true;
		}
		
		// count
		if (c1.getCount() == c2.getCount() || c2.getCount() == c3.getCount()
				|| c1.getCount() == c3.getCount()) {
			// check if all counts are the same
			if (c1.getCount() == c2.getCount() && c2.getCount() == c3.getCount()) {
				countCheck = true;
			}
		} else {
			countCheck = true;
		}

		return colorCheck && symbolCheck && shadingCheck && countCheck;
	}

	public List<List<Card>> combinations(List<Card> cards, List<List<Card>> combos) {
		int i, j, k;

		for (i = 0; i < cards.size() - 2; i++) {
			for (j = i + 1; j < cards.size() - 1; j++) {
				for (k = j + 1; k < cards.size(); k++)
					combos.add(Arrays.asList(cards.get(i), cards.get(j), cards.get(k)));
			}
		}
		return combos;
	}

}
