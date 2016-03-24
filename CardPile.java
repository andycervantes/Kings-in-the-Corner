//
// Andy Cervantes (acervant)
//
// Project 1: Kings in the Corner
//
// Description:
//	CardPile class used to contain generic card pile properties
//

package HW1.FINAL;

import java.util.Random;

public class CardPile {
	// array of Card type holding cards
	private Card[] cards;

	// the current number of cards in the card pile
	private int pileSize;

	// total cards in the deck
	protected int totalCards = 52;

	// constructor for specific size
	public CardPile(int size) {
		// set the card array for the size
		cards = new Card[size];
//		pileSize = size;
		// set pileSize to 0 since we just made a placeholder for the incoming cards
		pileSize = 0;
		int index = 0;

		// initialize the deck
		for (int count = 1; count <= size; count++)
			cards[index++] = new Card();
	}

	// default constructor
	public CardPile() {
		cards = new Card[totalCards];
		pileSize = totalCards;
		int index = 0;

		// initialize the deck
		for (int suit = 1; suit <= 4; suit++)
			for (int rank = 1; rank <= 13; rank++)
				cards[index++] = new Card(rank, suit);
	}

	// returns the number of cards in the card pile
	public int pileSize() {
		return this.pileSize;
	}

	// returns true if the card pile is full
	public boolean isFull() {
		return (this.pileSize == this.cards.length);
	}
	
	// returns true if the card pile is empty
	public boolean isEmpty() {
		return (this.pileSize == 0);
	}
	
	// deal a card and return it and make the old reference to it null
	public Card dealCard() {
		Card c = cards[--this.pileSize];
		cards[this.pileSize] = null;
//		System.out.println("Size:"+this.pileSize);
		return c;
	}
	
	// delete and return the card found
	public Card findCard(int rank, int suit) {

		// create temporary card with given properties
		Card temp = new Card(rank,suit);
		
		// has to be negative since we have an array
		int index = -1;
		for (int i = 0; i < this.pileSize && index < 0; i++)
//		for (int i = 0; i < this.pileSize; i++)
			if (cards[i].equals(temp))
				index = i;
		
		// not found
		if (index < 0)
		{
			System.out.println("Couldn't find card " + temp.toString() + ".");
			return null;
		}
		
		// save the card found
		Card found = cards[index];

		// move the cards over
		for (; index < this.pileSize - 1; index++)
			cards[index] = cards[index + 1];
		this.pileSize--;
		
		// set the removed card location to null
		cards[this.pileSize] = null;
		return found;
	}
	
	// shuffle the card pile using typical array swap method
	public void shuffle() {
		Random random = new Random();

		for (int i = 0; i < pileSize; i++) {
			// used to pick a random index between 0 and pileSize - 1
			int index = random.nextInt(pileSize);

			// swap cards[i] and cards[index]
			Card temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	}

	// shuffle the card pile n times using typical array swap method
	public void shuffle(int numberOftime) {
		Random random = new Random();

		for (int i = 0; i < numberOftime; i++) {
			// used to pick a random index between 0 and pileSize - 1
			int m = random.nextInt(pileSize);
			int n = random.nextInt(pileSize);

			// swap cards[m] and cards[n]
			Card temp = cards[m];
			cards[m] = cards[n];
			cards[n] = temp;
		}
	}

	// add a card to the deck.
	public void addCard(Card c) {
//		System.out.println(c.toString());
//		System.out.println(this.pileSize);
		this.cards[this.pileSize] = c;
		this.pileSize++;
	}

	// used for cardPile class
	public String toString() {

		// check for an empty CardPile
		if (pileSize == 0)
			return "<empty>";

		// print the first card
		String text = cards[0].toString() + ' ';

		// print the rest of the cards, can't divide by 0 so we start at index 1
		for (int i = 1; i < pileSize; i++) {

			// newline every 13 cards
			if (i % 13 == 0)
				text += '\n';

			text += cards[i].toString() + ' ';
		}
		return text;
	}

	public static void main(String[] args) {
		CardPile deck = new CardPile();

//		System.out.println(deck.pileSize());
//		while (deck.pileSize() != 0) {
//			Card C = deck.dealCard();
//			System.out.println(C.toString());
//		}

		System.out.println("Creating Deck");
		System.out.println(deck);

		System.out.println("Shuffling Deck");
		deck.shuffle();
		System.out.println(deck);

		System.out.println("Dealing Cards");
		Card[] hand = new Card[7];
		for (int i = 0; i < 7; i++)
			hand[i] = deck.dealCard();

		System.out.println("Cards In Hand");
		for (int i = 0; i < 7; i++)
			System.out.println(hand[i] + " ");

		System.out.println("Cards Left After Dealing");
		System.out.println(deck);

		System.out.println("Shuffling Deck After Dealing");
		deck.shuffle();
		System.out.println(deck);

//		System.out.println("Dealing More Cards");
//		for (int i = 0; i < 30; i++)
//			deck.dealCard();
//		System.out.println(deck);
	}
}
