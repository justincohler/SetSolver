package set;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SetTest {
	
	@Test
	public void noSet() {
		SetGame game = new SetGame();
		Card c1 = new Card(Color.GREEN, Symbol.DIAMOND, Shading.OPEN, 1);
		Card c2 = new Card(Color.GREEN, Symbol.SQUIGGLE, Shading.OPEN, 1);
		Card c3 = new Card(Color.GREEN, Symbol.OVAL, Shading.SOLID, 1);
		List<List<Card>> sets = game.findSets(Arrays.asList(c1, c2, c3));
		assertEquals(0, sets.size());		
	}
	
	@Test
	public void oneSet() {
		SetGame game = new SetGame();
		Card c1 = new Card(Color.GREEN, Symbol.DIAMOND, Shading.OPEN, 1);
		Card c2 = new Card(Color.GREEN, Symbol.SQUIGGLE, Shading.OPEN, 1);
		Card c3 = new Card(Color.GREEN, Symbol.OVAL, Shading.OPEN, 1);
		List<List<Card>> sets = game.findSets(Arrays.asList(c1, c2, c3));
		assertEquals(1, sets.size());		
	}
	
	@Test
	public void oneSetAllDifferent() {
		SetGame game = new SetGame();
		Card c1 = new Card(Color.GREEN, Symbol.DIAMOND, Shading.OPEN, 1);
		Card c2 = new Card(Color.PURPLE, Symbol.OVAL, Shading.SOLID, 2);
		Card c3 = new Card(Color.RED, Symbol.SQUIGGLE, Shading.STRIPED, 3);
		List<List<Card>> sets = game.findSets(Arrays.asList(c1, c2, c3));
		assertEquals(1, sets.size());		
	}
	
	@Test
	public void twoSets() {
		SetGame game = new SetGame();
		Card c1 = new Card(Color.GREEN, Symbol.DIAMOND, Shading.OPEN, 1);
		Card c2 = new Card(Color.GREEN, Symbol.SQUIGGLE, Shading.OPEN, 1);
		Card c3 = new Card(Color.GREEN, Symbol.OVAL, Shading.OPEN, 1);
		Card c4 = new Card(Color.RED, Symbol.OVAL, Shading.OPEN, 1);
		Card c5 = new Card(Color.PURPLE, Symbol.OVAL, Shading.OPEN, 1);

		List<List<Card>> sets = game.findSets(Arrays.asList(c1, c2, c3, c4, c5));
		assertEquals(2, sets.size());	
	}
	

}
