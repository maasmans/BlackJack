import java.util.*;
import java.util.ArrayList;

public class CardSet{
	//String[] kleuren = {"rood", "zwart"};
	String[] types = {"2","3","4","5","6","7","8","9","10","B","V","K","A"};
	String[] namen = {"Harten","Schoppen","Klaveren","Ruiten"};
	ArrayList<String[]> cardSet = new ArrayList<String[]>();
	int cardsCount;

	CardSet() {
		cardsCount = 0;
		for (String type : types) {
			for (String naam : namen) {
				String[] kaart = { type, naam };
				cardSet.add(kaart);
				cardsCount++;
			}
		}
	}

	public void printCardSet() {
		for (String[] kaart : cardSet) {
			for (String kaartElement : kaart) {
				System.out.println(kaartElement);
			}
			System.out.println("\n");
		}
	}
	public void shuffleCards() {
		Collections.shuffle(cardSet);

	}

	public void textShowCard(int x) { // laat kaart positie x zien in kaart deck
		String[] kaart = cardSet.get(x);
		System.out.println("De kaart is een " + kaart[1] + " " + kaart[0]);
	}
	// input bijvoorbeeld String[] kaart = { "2", "harten")
	public int getPointsOfCard(String[] kaart) {
		String kaartType = kaart[0];
		int kaartPunten = 0;
		switch (kaartType) {
		  case "2":
		    //System.out.println("Type kaart is een twee");
		    kaartPunten = 2;
		    break;
		  case "3":
			//  System.out.println("Type kaart is een drie");
			  kaartPunten = 3;
			  break;
		  case "4":
			//  System.out.println("Type kaart is een vier");
			  kaartPunten = 4;
			  break;
		  case "5":
			//  System.out.println("Type kaart is een vijf");
			  kaartPunten = 5;
			  break;
		  case "6":
			//  System.out.println("Type kaart is een zes");
			  kaartPunten = 6;
			  break;
		  case "7":
			//  System.out.println("Type kaart is een zeven");
			  kaartPunten = 7;
			  break;
		  case "8":
			//  System.out.println("Type kaart is een acht");
			  kaartPunten = 8;
			  break;
		  case "9":
			//  System.out.println("Type kaart is een negen");
			  kaartPunten = 9;
			  break;
		  case "10":
			//  System.out.println("Type kaart is een tien");
			  kaartPunten = 10;
			  break;
		  case "B":
			//  System.out.println("Type kaart is een boer");
			  kaartPunten = 10;
			  break;
		  case "V":
			//  System.out.println("Type kaart is een vrouw");
			  kaartPunten = 10;
			  break;
		  case "K":
			//  System.out.println("Type kaart is een koning");
			  kaartPunten = 10;
			  break;
		  case "A":
			//  System.out.println("Type kaart is een Aas");
			  kaartPunten = 11;
			  break;
			 }
		return kaartPunten;
	}
} 
		
