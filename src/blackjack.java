import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class blackjack {
	card[] getCards() {
		card[] kaarten = new card[52];
		for (int x = 0; x < kaarten.length; x++) {
			kaarten[x] = new card();
		}
		
		String[] types = {"H", "K", "S", "R"};
		String[] nummers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Vrouw", "Koning", "Aas"};
		int indexNum = 0;
		for (String type : types ) {
			for (String nummer : nummers) {
				kaarten[indexNum].type = type;
				kaarten[indexNum].value = nummer;
				indexNum++;
			}
		}
	return kaarten;
	}
	
	void shuffleCards(card[] oldCards) {
		Random random = new Random();
		for (int index = 0; index < oldCards.length; index++) {
			int randCard = random.nextInt(oldCards.length);
			card originalCard = oldCards[randCard];
			oldCards[randCard] = oldCards[index];
			oldCards[index] = originalCard;
		}
	}
	
	void spelen(card[] cards) {
		ArrayList<card> hand = new ArrayList<>();
		ArrayList<card> dealer = new ArrayList<>();
		start(cards, hand, dealer);
		showHands(hand, dealer);
		game:for (int beurt = 4; beurt < 52; beurt++) { //beurt < cards.length
			// user input
			String input = getInput();
			if (input.equals("k")) { // kaart trekken
				hand.add(cards[beurt]);
				showHands(hand, dealer);
				if (countTotal(hand) == 21) {
					System.out.println("U heeft blackjack!");
					break game;
				} else if(countTotal(hand) > 21) {
					System.out.println("U bent bust. De dealer wint.");
				}
			} else if(input.equals("q")) { // stoppen
				break;
			} else if(input.equals("p")) {
				while (countTotal(dealer) <= 17) {
					dealer.add(cards[beurt]);
					showHands(hand, dealer);
				}
				if (countTotal(dealer) == 21) {
					System.out.println("Dealer heeft blackjack.");
					break game;
				} else if(countTotal(dealer) > 21) {
					System.out.println("De dealer is bust. U Wint!");
				}
			}
		}
	}
	
	String getInput() {
		System.out.print("k - pak een kaart\np - passen\nq - stop het spel\n");
		Scanner scan = new Scanner(System.in);
		String input = scan.next().toLowerCase();
		while (!input.equals("k") && !input.equals("p") && !input.equals("q")) {
			System.out.print("Typ k, p of q: ");
			input = scan.next().toLowerCase();
		}
		return input;
	}
	
	void showHands(ArrayList<card> hand, ArrayList<card> dealer) {
		System.out.println("Dealer: " + dealer.get(0).type + dealer.get(0).value + " "
	+ dealer.get(1).type + dealer.get(1).value);
		System.out.println("Value: " + countTotal(dealer));
		System.out.print("Hand: ");
		for (int kaart = 0; kaart < hand.size(); kaart++) {
			System.out.print(hand.get(kaart).type + hand.get(kaart).value + " ");
		}
		System.out.println();
		System.out.println("Value: " + countTotal(hand));
	}
	
	void start(card[] cards, ArrayList<card> hand, ArrayList<card> dealer) {
		//geef dealer 2 kaarten
		dealer.add(cards[0]);
		dealer.add(cards[1]);
		//geef speler 2 kaarten
		hand.add(cards[2]);
		hand.add(cards[3]);
	}
	
	int countTotal(ArrayList<card> cards) {
		int total = 0;
		for (int card = 0; card < cards.size(); card++) {
			total += cards.get(card).getValue();
		}
		return total;
	}
}






