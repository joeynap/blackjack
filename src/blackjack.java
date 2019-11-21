import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class blackjack {
	String[] getCards() {
		String[] types = {"H", "K", "S", "R"};
		String[] nummers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Vrouw", "Koning", "Aas"};
		String[] kaarten = new String[52];
		int indexNum = 0;
		for (String type : types ) {
			for (String nummer : nummers) {
				kaarten[indexNum] = type + nummer;
				indexNum++;
			}
		}
	return kaarten;
	}
	
	void shuffleCards(String[] oldCards) {
		Random random = new Random();
		for (int index = 0; index < oldCards.length; index++) {
			int randCard = random.nextInt(oldCards.length);
			String card = oldCards[randCard];
			oldCards[randCard] = oldCards[index];
			oldCards[index] = card;
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
	
	void spelen(String[] cards) {
		ArrayList<String> hand = new ArrayList<>();
		for (int beurt = 0; beurt < 3; beurt++) { //beurt < cards.length
			// user input
			String input = getInput();
			// kaart trekken
			if (input.equals("k")) {
				hand.add(cards[beurt]);
			}
			System.out.print("Hand: ");
			for (int kaart = 0; kaart < hand.size(); kaart++) {
				System.out.print(hand.get(kaart));
			}
			System.out.println();
		}
	}
}






