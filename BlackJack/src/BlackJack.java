
class BlackJack {
	public static void main(String[] args) {
		CardSet kaarten = new CardSet();
		kaarten.shuffleCards();
		Player laszlo = new Player("laszlo", kaarten);
		laszlo.askInput();
		laszlo.procesInput();
//		laszlo.askInput();
//		laszlo.procesInput();
//		laszlo.askInput();
//		laszlo.procesInput();
//		
	}
}
