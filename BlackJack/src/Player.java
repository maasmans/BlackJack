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
	
	Player(String naam, CardSet kaarten){
		this.kaarten = kaarten;
		this.naam = naam;
		}
	
	public void askInput() {
		Scanner input = new Scanner(System.in);
		if (gamePhase.equals("Neutral")) {
			System.out.println("Wil je een ronde spelen? Voer in y/n:");
			
		}
		else if (gamePhase.equals("Ongoing")) {
			System.out.println("Kies wat je wilt doen 'k' voor kaart, 'q' om te stoppen:");	
		}
		inputChar = input.next().charAt(0);	
		input.close();
	}
	
	public void procesInput() {
		if(gamePhase.equals("Ongoing")) {
			if(inputChar == 'k') {
				System.out.println("Je hebt gekozen om een kaart te trekken");
				count++;
				System.out.println("Dit is je "+ count + "e kaart");
				kaarten.textShowCard(count);
				points += kaarten.getPointsOfCard(kaarten.cardSet.get(count)); // deze is beetje moeilijk, kaarten is object van class CardSet. Met kaarten.getPointsOfCard roep je een object methode, deze methode heeft een kaart nodig de Arraylist kaarten krijg je door (kaarten.CardSet()) dan de count neemt de eerste of zoveelste kaart van het deck. 
				System.out.println("Je hebt nu in totaal " + points + " punten.");
						}
			else if (inputChar == 'q') {
				System.out.println("Je hebt gekozen om te stoppen met spelen");
				count = 0;
				gamePhase = "Neutral";
			//Nog toepassen
			}
			else {
				System.out.println("Je input was geen 'q' of 'k' probeer opnieuw");
			}
		}
		if(gamePhase.equals("Neutral")) {
			if(inputChar == 'y') {
				System.out.print("You decided to start a game! LETS GO!");
				kaarten.textShowCard(count);
				points += kaarten.getPointsOfCard(kaarten.cardSet.get(count));
				count++;
								
				kaarten.textShowCard(count);
				points += kaarten.getPointsOfCard(kaarten.cardSet.get(count));
				count++;
				
				System.out.println("Je hebt nu in totaal " + points + " punten.");		
				gamePhase = "Ongoing";
			}
			else {
				System.out.println("Je hebt geen y ingedrukt, jammer dan niet he.");
				
			}
		}
	}
}
