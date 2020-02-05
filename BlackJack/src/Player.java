import java.util.Scanner;

public class Player {
	String naam;
	char inputChar;
	String inputString;
	int points = 0;
	int count = 0;
	CardSet kaarten;
	String gamePhase = "Neutral";

//	Player(){
//		this("Unknown", kaarten);
//	}

//	Player(String naam){
//		this(naam, kaarten);
//	}

	Player(String naam, CardSet kaarten) {
		this.kaarten = kaarten;
		this.naam = naam;
	}

	public void askInput() {
		Scanner input = new Scanner(System.in);
		if (gamePhase.equals("Neutral")) {
			System.out.println("Wil je een ronde spelen? Voer in y/n:");

		} else if (gamePhase.equals("Ongoing")) {
			System.out.println("Kies wat je wilt doen 'k' voor kaart, 'q' om te stoppen:");
		} else {
			System.out.println("ERROR gamePhase zou neutral or ongoing moeten zijn");
		}
		inputChar = input.next().charAt(0);
	}

	public void ongoingProcesInput() {
		if (inputChar == 'k') {
			System.out.println("Je hebt gekozen om een kaart te trekken");
			count++;
			System.out.println("Dit is je " + count + "e kaart");
			System.out.println("Het is een " + kaarten.getCard(count));
			points += kaarten.getPointsOfCard(kaarten.cardSet.get(count));
			System.out.println("Je hebt nu in totaal " + points + " punten.");
		} else if (inputChar == 'q') {
			System.out.println("Je hebt gekozen om te stoppen met spelen");
			count = 0;
			gamePhase = "Neutral";
			points = 0;

		} else {
			System.out.println("Je input was geen 'q' of 'k' probeer opnieuw");
		}
	}

	public void neutralProcesInput() {
		if (inputChar == 'y') {
			System.out.println("You decided to start a game! LETS GO!");
			System.out.println("You've pulled a: ");
			System.out.println(kaarten.getCard(count) + " AND " + kaarten.getCard(count + 1));

			points += kaarten.getPointsOfCard(kaarten.cardSet.get(count));
			count++;

			points += kaarten.getPointsOfCard(kaarten.cardSet.get(count));
			count++;

			System.out.println("You've got " + points + " points in total now.");
			gamePhase = "Ongoing";
		} else {
			System.out.println("Je hebt geen y ingedrukt, jammer dan niet he.\n\n");
		}
	}

	public void procesInput() {
		if (gamePhase.equals("Neutral")) {
			neutralProcesInput();
		} else if (gamePhase.equals("Ongoing")) {
			ongoingProcesInput();
			if(inputChar == 'k') {
				scoreCheck();
			}
		
		}
	}

	public void scoreCheck() {
		if (points < 21) {
			System.out.println("Je kan weer een keuze maken je hebt minder dan 21 punten");
		} else if (points == 21) {
			System.out.println("BLACKJACK!!!");
			gamePhase = "Neutral";
			count = 0;
			points = 0;
		} else if (points > 21) {
			System.out.println("YOUR DEAD!!!");
			gamePhase = "Neutral";
			count = 0;
			points = 0;
		}

	}
}
