//
// Andy Cervantes (acervant)
//
// Project 1: Kings in the Corner
//
// Description:
//	Card class used to contain generic card properties used in CardPile class
//

package HW1.FINAL;

public class Card {
	private int rank;
	private int suit;

	// basic card constructor
	public Card(int rank, int suit) {
		this.rank = rank; // initialize rank of card
		this.suit = suit; // initialize suit of card
	}

	// default constructor
	Card() {
		this.rank = 0;
		this.suit = 0;
	}

	// return the rank of the card
	public int getRank() {
		return this.rank;
	}

	// return the suit of the card
	public int getSuit() {
		return this.suit;
	}

	// return true if two cards equal each other based on rank and suit
	public boolean equals(Card c) {
		return (this.getRank() == c.getRank() && this.getSuit() == c.getSuit());
	}

	// return true if card is king, false otherwise
	public boolean isKing() {
		return (this.getRank() == 13);
	}

	// return color of card as an integer
	public int color() {
		if (getSuit() == 3 || getSuit() == 2)
			return 1;// red
		// black
		return 0;
	}

	// used to compare cards based on rank and suit
	public int compareTo(Card c) {
		// find the difference based on suit
		int difference = this.getSuit() - c.getSuit();

		// if they are the same then return the difference between ranks
		if (difference == 0)
			return this.getRank() - c.getRank();
		else
			return difference;
	}

	public int toInt(char rs[])
	{
		return 0;
	}

	// function that converts numbers to characters
	public String toString() {
		// initialize string
		String text = "";

		// switch based on ranks
		switch (rank) {
		case 1:
			text += "A";
			break;
		case 10:
			text += "T";
			break;
		case 11:
			text += "J";
			break;
		case 12:
			text += "Q";
			break;
		case 13:
			text += "K";
			break;
		default:
			text += rank;
			break;
		}

		// switch based on suits
		switch (suit) {
		case 1:
			text += "H";
			break;
		case 2:
			text += "D";
			break;
		case 3:
			text += "C";
			break;
		case 4:
			text += "S";
			break;
		}
		return text;
	}
}
