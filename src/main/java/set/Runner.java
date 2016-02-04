package set;

import java.util.*;

public class Runner {

	public static final int BOARD_SIZE = 12;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		SetGame game = new SetGame();

		List<Card> cards = new ArrayList<Card>();
		while (true) {
			System.out.println("\nAction: (N)ew Card | (F)ind Sets | (C)lear board | (S)how Board | (R)andom Board: ");
			String action = in.next();

			if (action.equalsIgnoreCase("N")) {
				Card c = new Card();

				/*
				 * Color input
				 */
				System.out.println("Color: (R)ed | (G)reen | (P)urple: ");
				String color = in.next();

				if (color.equalsIgnoreCase("R"))
					c.setColor(Color.RED);
				else if (color.equalsIgnoreCase("G"))
					c.setColor(Color.GREEN);
				else if (color.equalsIgnoreCase("P"))
					c.setColor(Color.PURPLE);
				else {
					System.out.println("Not a valid input, bro.");
					continue;
				}

				/*
				 * Symbol Input
				 */
				System.out.println("Symbol: (D)iamond | (S)quiggle | (O)val: ");
				String symbol = in.next();

				if (symbol.equalsIgnoreCase("D"))
					c.setSymbol(Symbol.DIAMOND);
				else if (symbol.equalsIgnoreCase("S"))
					c.setSymbol(Symbol.SQUIGGLE);
				else if (symbol.equalsIgnoreCase("O"))
					c.setSymbol(Symbol.OVAL);
				else {
					System.out.println("Not a valid input, bro.");
					continue;
				}

				/*
				 * Shading input
				 */
				System.out.println("Solid: (So)lid | (St)riped | (O)pen: ");
				String shading = in.next();

				if (shading.equalsIgnoreCase("So"))
					c.setShading(Shading.SOLID);
				else if (shading.equalsIgnoreCase("St"))
					c.setShading(Shading.STRIPED);
				else if (shading.equalsIgnoreCase("O"))
					c.setShading(Shading.OPEN);
				else {
					System.out.println("Not a valid input, bro.");
					continue;
				}
				
				/*
				 * Count input
				 */
				System.out.println("Count: 1 | 2 | 3: ");
				Integer count = in.nextInt();

				if (count >= 1 && count <=3 )
					c.setCount(count);
				else {
					System.out.println("Not a valid input, bro.");
					continue;
				}

				cards.add(c);
			} else if (action.equalsIgnoreCase("C")) {
				cards.clear();
			} else if (action.equalsIgnoreCase("R")) {
				cards.clear();
				List<Card> deck = game.constructSet();
				for (int i = 0; i < BOARD_SIZE; i++) {
					Random r = new Random();
					Card c = deck.get(r.nextInt(deck.size()));
					deck.remove(c);
					cards.add(c);
				}
			} else if (action.equalsIgnoreCase("S")) {
				if (cards == null || cards.isEmpty()) {
					System.out.println("No cards on the board yet..");
					continue;
				}
				System.out.println("\n************************");
				System.out.println("Board");
				System.out.println("************************\n");
				for (Card card : cards) {
					System.out.println(card);
				}
			} else if (action.equalsIgnoreCase("F")) {
				List<List<Card>> sets = game.findSets(cards);
				if (sets != null && !sets.isEmpty()) {
					for (List<Card> set : sets) {
						System.out.println("Set: " + set);
						try {
							for (Card card : set) {
								cards.remove(card);
							}
						} catch (Exception e) {
						}
					}
				}
			} else {
				System.out.println("Not a valid input, bro.");
				continue;
			}
		}
	}

}
