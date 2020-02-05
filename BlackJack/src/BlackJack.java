
class BlackJack {
	public static void main(String[] args) {
		CardSet kaarten = new CardSet();
		kaarten.shuffleCards();
		Player laszlo = new Player("laszlo", kaarten);

		// TRY NESTED LOOP :)
		while (true) {

			laszlo.askInput();
			laszlo.procesInput();

			while (laszlo.gamePhase == "Ongoing") {
				laszlo.askInput();
				laszlo.procesInput();
				System.out.println("EINDE VAN DE RONDE \n\n");
			}
		}

//		
	}
}
