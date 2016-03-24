//
// Andy Cervantes (acervant)
//
// Project 1: Kings in the Corner
//
// Description:
//	Game class used to initialize the game and allow game control
//

package HW1.FINAL;

import java.util.Scanner;
import java.util.Arrays;

public class Game {

	private static int maxDrawSize = 7;
	private static int maxHandSize = 13;
	private static int maxDeckSize = 13;
	private boolean playerTurn;
	// initiate card piles, at this point i'm just trying to hurry up and turn
	// it in on time...
	public static CardPile deck = new CardPile();
	public static CardPile draw = new CardPile(34);

	// max cards in a pile is 13...
	public static CardPile lpile1 = new CardPile(maxDeckSize);
	public static CardPile lpile2 = new CardPile(maxDeckSize);
	public static CardPile lpile3 = new CardPile(maxDeckSize);
	public static CardPile lpile4 = new CardPile(maxDeckSize);
	public static CardPile kpile5 = new CardPile(maxDeckSize);
	public static CardPile kpile6 = new CardPile(maxDeckSize);
	public static CardPile kpile7 = new CardPile(maxDeckSize);
	public static CardPile kpile8 = new CardPile(maxDeckSize);

	// hand piles
	// public static Card[] hand = new Card[maxHandSize];
	// public static Card[] ai = new Card[maxHandSize];

	public static CardPile hand = new CardPile(maxHandSize);
	public static CardPile ai = new CardPile(maxHandSize);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// initialize the game
		initializeGame();
		display();

		// command processor
		Game game = new Game();
		game.processCommandLoop(sc);

		System.out.println("Goodbye!");
		sc.close();
	}

	public void processCommandLoop(Scanner sc) {
		// loop until all integers are read from the file
		while (sc.hasNext()) {
			String command = sc.next();

			System.out.println("*" + command + "*");

			if (command.equals("q") == true)
				System.exit(1);
			else if (command.equals("h") == true)
				showCommands();
			else if (command.equals("a") == true)
				about();
			else if (command.equals("l") == true)
				doLay(sc);
			else if (command.equals("d") == true)
				doDraw(sc);
			else if (command.equals("m") == true)
				doMove(sc);
			else
				System.out.println("Command is not known: " + command + ".");

			// display all the decks and hands
			display();

			playerTurn = false;

			sc.nextLine();
		}
	}

	// function used to initialize
	public static void initializeGame() {
		// System.out.println("Creating Deck");
		// System.out.println(deck);

		// System.out.println("Shuffling Deck");
		deck.shuffle();
		// System.out.println(deck);

		// System.out.println("Dealing Cards");
		for (int i = 0; i < maxDrawSize; i++) {
			// hand[i] = deck.dealCard();
			// ai[i] = deck.dealCard();
			hand.addCard(deck.dealCard());
			ai.addCard(deck.dealCard());
		}

		// System.out.println("Player Hand");
		// for (int i = 0; i < maxHandSize; i++)
		// System.out.println(hand[i] + " ");

		// System.out.println("AI Hand");
		// for (int i = 0; i < maxHandSize; i++)
		// System.out.println(ai[i] + " ");

		// System.out.println("Laying Down Cards in Pile 1 to 4");
		lpile1.addCard(deck.dealCard());
		lpile2.addCard(deck.dealCard());
		lpile3.addCard(deck.dealCard());
		lpile4.addCard(deck.dealCard());

		// System.out.println("Transferring Cards From Deck to Draw Pile");
		for (int i = deck.pileSize(); i != 0; i--)
			draw.addCard(deck.dealCard());
	}

	public void showCommands() {
		System.out.println("The commands for this project are:");
		System.out.println(" q - quit the program");
		System.out.println(" h - this command table");
		System.out.println(" a - info about the program and the author");
		System.out.println(" l <card> <pile> - lay a card down on a pile");
		System.out.println(" m <pile1> <pile2> - move a pile to another pile");
	}

	public static void display() {
		System.out.println("Pile 1: " + lpile1);
		System.out.println("Pile 2: " + lpile2);
		System.out.println("Pile 3: " + lpile3);
		System.out.println("Pile 4: " + lpile4);
		System.out.println("Pile 5: " + kpile5);
		System.out.println("Pile 6: " + kpile6);
		System.out.println("Pile 7: " + kpile7);
		System.out.println("Pile 8: " + kpile8);
		System.out.println("AI Hand: " + ai);
		// Arrays.sort(hand);
		// for (int i = 0; i < maxHandSize; i++)
		// System.out.print(ai[i] + " ");
		// System.out.println();

		System.out.println("Your Hand: " + hand);
		// for (int i = 0; i < maxHandSize; i++)
		// System.out.print(hand[i] + " ");
		// System.out.println();

		System.out.print("Your Move: ");
	}

	public void about() {
		System.out.println("Programmer: Andy Cervantes");
		System.out.println("Program uses an array of cards to simulate Kings in the Corner.");
	}

	public void doLay(Scanner sc) {

		int val2 = 0;
		int rank = 0;
		int suit = 0;
		char rs[] = {0,0};
		String card = "";
		
		if ((card = sc.next()) != null)
			rs = card.toCharArray();
		else {
			System.out.println("Card expected.");
			return;
		}
		
		switch (rs[0]) {
		case 'a':
			rank = 1;
			break;
		case 't':
			rank = 10;
			break;
		case 'j':
			rank = 11;
			break;
		case 'q':
			rank = 12;
			break;
		case 'k':
			rank = 13;
			break;
		case '2':
			rank = 2;
			break;
		case '3':
			rank = 3;
			break;
		case '4':
			rank = 4;
			break;
		case '5':
			rank = 5;
			break;
		case '6':
			rank = 6;
			break;
		case '7':
			rank = 7;
			break;
		case '8':
			rank = 8;
			break;
		case '9':
			rank = 9;
			break;
		}

		switch (rs[1]) {
		case 'h':
			suit = 1;
			break;
		case 'd':
			suit = 2;
			break;
		case 'c':
			suit = 3;
			break;
		case 's':
			suit = 4;
			break;
		}

		if (sc.hasNextInt() == true)
		{
			val2 = sc.nextInt();
			if ( val2 < 1 || val2 > 8 )
			{
				System.out.println("Pile selection is from 1 to 8 only.");
				return;
			}
			
			Card temp = hand.findCard(rank, suit);
			
			if (temp == null) {
//				System.out.println("Couldn't find card " + temp.toString() + ".");
				return;
			}
			
			switch (val2) {
			case 1:
				lpile1.addCard(temp);
				break;
			case 2:
				lpile2.addCard(temp);
				break;
			case 3:
				lpile3.addCard(temp);
				break;
			case 4:
				lpile4.addCard(temp);
				break;
			case 5:
				kpile5.addCard(temp);
				break;
			case 6:
				kpile6.addCard(temp);
				break;
			case 7:
				kpile7.addCard(temp);
				break;
			case 8:
				kpile8.addCard(temp);
				break;
			}
			System.out.println("Laying card " + temp.toString() + " to Pile " + val2 + ".");
		}
		else {
			System.out.println("Pile number expected.");
			return;
		}
	}

	public void doMove(Scanner sc) {
		int val1 = 0;
		int val2 = 0;

		if (sc.hasNextInt() == true)
			val1 = sc.nextInt();
		else {
			System.out.println("Pile number expected.");
			return;
		}

		if (sc.hasNextInt() == true)
			val2 = sc.nextInt();
		else {
			System.out.println("Pile number expected");
			return;
		}

		System.out.println("Moving Pile " + val1 + " to Pile " + val2 + ".");
		// fun.fun(val1, val2);
	}

	public void doDraw(Scanner sc) {
		System.out.println("Drawing Card From Deck");

//		int index = -1;
		// for (int i = 0; i < maxHandSize; i++)
		// if ( hand[i] == null )
		// {
		// index = i;
		// break;
		// }

		// temp for now
		// if (index == -1)
		// {
		// hand[index] = draw.dealCard();
		Card temp = draw.dealCard();
		hand.addCard(temp);
		System.out.println("Added card " + temp.toString() + " to your hand.");
		// }
		// else
		// System.out.println( "Hand is full." );
	}

}
