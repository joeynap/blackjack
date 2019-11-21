import java.util.Random;

public class Cards {
	Cards() {
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
}
