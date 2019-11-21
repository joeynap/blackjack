class blackjackApp {
	public static void main(String[] args) {
		
		blackjack Blackjack = new blackjack();
		// get cards
		String[] cards = Blackjack.getCards();
		// schuffle cards
		Blackjack.shuffleCards(cards);
		// start spel
		Blackjack.spelen(cards);
	}
}
