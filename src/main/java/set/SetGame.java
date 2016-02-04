package set;

import java.util.*;

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
		if (intersects(c1.getColor(), c2.getColor(), c3.getColor())) {
			if (allEquals(c1.getColor(), c2.getColor(), c3.getColor()))
				colorCheck = true;
		} else {
			colorCheck = true;
		}
		// symbol
		if (intersects(c1.getSymbol(), c2.getSymbol(), c3.getSymbol())) {
			if (allEquals(c1.getSymbol(), c2.getSymbol(), c3.getSymbol()))
				symbolCheck = true;
		} else {
			symbolCheck = true;
		}
		// shading
		if (intersects(c1.getShading(), c2.getShading(), c3.getShading())) {
			if (allEquals(c1.getShading(), c2.getShading(), c3.getShading()))
				shadingCheck = true;
		} else {
			shadingCheck = true;
		}

		// count
		if (intersects(c1.getCount(), c2.getCount(), c3.getCount())) {
			if (allEquals(c1.getCount(), c2.getCount(), c3.getCount()))
				countCheck = true;
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

	public boolean intersects(Object... objects) {
		int i, j;

		for (i = 0; i < objects.length - 1; i++){
			for (j = i + 1; j < objects.length; j++) {
				if (objects[i].equals(objects[j])) 
					return true;
			}
		}
		return false;
	}

	public boolean allEquals(Object... objects) {
		int i, j;

		for (i = 0; i < objects.length - 1; i++){
			for (j = i + 1; j < objects.length; j++) {
				if (!objects[i].equals(objects[j])) 
					return false;
			}
		}
		return true;
	}

	public List<Card> constructSet() {
		List<Card> set = new ArrayList<Card>();
		for (Color color : Color.values())
			for (Shading shading : Shading.values())
				for (Symbol symbol : Symbol.values())
					for (int count = 1; count <= 3; count++)
						set.add(new Card(color,symbol,shading,count));
		return set;
	}

}
