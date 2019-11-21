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
		//pak beginkaarten en laat zien
		ArrayList<card> hand = new ArrayList<>();
		ArrayList<card> dealer = new ArrayList<>();
		start(cards, hand, dealer);
		//check of dealer/speler blackjack heeft
		if (countTotal(hand) == 21) {
			showHands(hand, dealer);
			System.out.println("U heeft blackjack!");
			return;
		} else if (countTotal(dealer) == 21) {
			showHands(hand, dealer);
			System.out.println("Dealer heeft blackjack.");
			return;
		}
		showHands(hand, dealer, true);
		
		//geef speler opties
		for (int beurt = 4; beurt < 52; beurt++) { //beurt < cards.length
			// user input
			String input = getInput();
			if (input.equals("k")) { // kaart trekken
				hand.add(cards[beurt]);
				if (countTotal(hand) == 21) {
					showHands(hand, dealer);
					System.out.println("U heeft blackjack!");
					break;
				} else if(countTotal(hand) > 21) {
					showHands(hand, dealer);
					System.out.println("U bent bust. De dealer wint.");
					break;
				}
				showHands(hand, dealer, true);
				
			} else if(input.equals("q")) { //stoppen
				break;
				
			} else if(input.equals("p")) {
				while (countTotal(dealer) <= 17 || countTotal(dealer) <= countTotal(hand)) {
					dealer.add(cards[beurt]);
					beurt++;
				}
				if (countTotal(dealer) == 21) {
					showHands(hand, dealer);
					System.out.println("Dealer heeft blackjack.");
				} else if(countTotal(dealer) > 21) {
					showHands(hand, dealer);
					System.out.println("De dealer is bust. U Wint!");
				} else if (countTotal(dealer) > countTotal(hand)) {
					showHands(hand, dealer);
					System.out.println("De dealer wint.");
				} else {
					showHands(hand, dealer);
					System.out.println("U wint!");
				}
				break;
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
		System.out.print("Dealer: ");
		for (int kaart = 0; kaart < dealer.size(); kaart++) {
			System.out.print(dealer.get(kaart).type + dealer.get(kaart).value + " ");
		}
		System.out.println();
		System.out.println("Value: " + countTotal(dealer));
		System.out.print("Hand: ");
		for (int kaart = 0; kaart < hand.size(); kaart++) {
			System.out.print(hand.get(kaart).type + hand.get(kaart).value + " ");
		}
		System.out.println();
		System.out.println("Value: " + countTotal(hand));
	}
	
	void showHands(ArrayList<card> hand, ArrayList<card> dealer, boolean hidden) {
		System.out.println("Dealer: " + dealer.get(0).type + dealer.get(0).value + " ?");
		System.out.println("Value: ?");
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
		boolean aasInHand = false;
		for (int card = 0; card < cards.size(); card++) {
			total += cards.get(card).getValue();
			if (cards.get(card).value.equals("Aas")) {
				aasInHand = true;
			}
		}
		if (total > 21 && aasInHand) {
			total-=10;
		}
		return total;
	}
}






