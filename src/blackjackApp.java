class blackjackApp {
	public static void main(String[] args) {
		blackjack Blackjack = new blackjack();
		// get cards
		card[] deck = Blackjack.getCards();
		// schuffle cards
		Blackjack.shuffleCards(deck);
		// start spel
		Blackjack.spelen(deck);
	}
}
