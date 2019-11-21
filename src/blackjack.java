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
	
	void spelen(card[] cards) {
		ArrayList<card> hand = new ArrayList<>();
		for (int beurt = 0; beurt < 52; beurt++) { //beurt < cards.length
			// user input
			String input = getInput();
			
			if (input.equals("k")) { // kaart trekken
				hand.add(cards[beurt]);
				showHand(hand);
			} else if(input.equals("p")) { // passen
				showHand(hand);
			} else {
				break;
			}
		}
	}
	
	void showHand(ArrayList<card> hand) {
		System.out.print("Hand: ");
		for (int kaart = 0; kaart < hand.size(); kaart++) {
			System.out.print(hand.get(kaart).type + hand.get(kaart).value);
		}
		System.out.println();
	}
}






