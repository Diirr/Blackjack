import java.util.*;

public class GameMaster{

  public int start(){

      Scanner scanner = new Scanner(System.in);
      int auswahl;
      System.out.println("*****************************************************\nHerzlich Willkommen zu einer Runde Blackjack!!!!\n*****************************************************");
      System.out.println("Möchten Sie ein neues Spiel starten dann drücken sie die 1!");
      System.out.println("zum Beenden drücken Sie bitte die 2.");

      auswahl = scanner.nextInt();
      return auswahl;
  }

  public boolean playAGame(){

    CardDeck cd = new CardDeck();
    cd.createDeck();
    int dealerFirst=0;
    int dealerSecond=0;
    int player=0;

    //Runde 1
    dealerFirst += cd.getCard();
    dealerSecond = dealerFirst;
    player += cd.getCard();
    System.out.println("Runde 1!");
    System.out.println("Dealer: "+dealerFirst);
    System.out.println("Player: "+player);
    System.out.println();
    //Runde 2
    dealerSecond += cd.getCard();
    player += cd.getCard();
    System.out.println("Runde 2!");
    System.out.println("Dealer: "+dealerFirst);
    System.out.println("Player: "+player);

    if(player==21){
      System.out.println("Herzlichen Glückwunsch");
      return true;
    }

    if(player == 22){
      player=12;
    }
/*---------------------------------------------------------------------------------------------------------------*/
    //Ab Runde 3 spielt der Spieler
    int auswahl = 1;
    int karte= 0;
    while(auswahl!=2){
      System.out.println("Möchten sie weiter spielen? Ihr akuteller Kartenwert beträgt: "+player);
      System.out.println("\n1. Neue Karte! \n2. Keine Karte!\n");
      Scanner scanner = new Scanner(System.in);
      auswahl = scanner.nextInt();
      if(auswahl == 1){
	karte = cd.getCard();
        player += karte;
	System.out.println("\nSie haben eine "+ karte + " erhalten.\n");
      }
	

      if(player == 21){
        System.out.println("Sie haben gewonnen: "+player);
        return true;
      }
      if(player > 21){
        System.out.println("Sie haben verloren. Aktuelle Punktzahl: "+player+" Der Deahler hat: "+dealerFirst);
        return false;
      }
    }

/*---------------------------------------------------------------------------------------------------------------*/
    // Dealer spielt nachdem alle gespielt haben
    while(dealerSecond<17){
      dealerSecond += cd.getCard();
      System.out.println("Der Dealer hat aktuell: "+dealerSecond);
    }

    if(dealerSecond<22&&dealerSecond>player){
      System.out.println("Das Haus gewinnt: "+dealerSecond+"Sie haben: "+player);
      return false;
    }
    if(dealerSecond>21&&player<22){
      System.out.println("Sie gewinnen: "+player+" Der Deahler hat: "+dealerSecond);
      return true;
    }

    System.out.println("Sie haben verloren + letzte Ausgabe");
    return true;
  }
}
