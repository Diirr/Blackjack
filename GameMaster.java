import java.util.*;

public class GameMaster{

  public int start(){

      Scanner scanner = new Scanner(System.in);
      int auswahl;
      System.out.println("*************************************\nHerzlich Willkommen zu BLACKJACK!!!!\n*************************************");
      System.out.println("1: Neue Runde!");
      System.out.println("2: Beenden!");

      auswahl = scanner.nextInt();
      return auswahl;
  }

  public boolean playAGame(){

    CardDeck cd = new CardDeck();
    cd.createDeck();
    //Kartewerte der Spieler
    int dealerFirst=0;
    int dealerSecond=0;
    int player=0;

    //Runde 1
    int tmpDealer = cd.getCard();
    int tmpPlayer = cd.getCard();

    dealerFirst += tmpDealer;
    dealerSecond = dealerFirst;
    player += tmpPlayer;

    System.out.println("Round 1!");
    System.out.println("Card: "+tmpDealer+" Dealer: "+dealerFirst);
    System.out.println("Card: "+tmpPlayer+" Player: "+player);
    System.out.println();

    //Runde 2
    tmpDealer = cd.getCard();
    tmpPlayer = cd.getCard();

    dealerSecond += tmpDealer;
    player += tmpPlayer;

    System.out.println("Round 2!");
    System.out.println("Card: hidden! Dealer: "+dealerFirst);
    System.out.println("Card: "+tmpPlayer+" Player: "+player);

    if(player==21){
      System.out.println("Herzlichen Glückwunsch, Sie haben gewonnen- BlackJack!!!");
      return true;
    }

    if(player == 22){
      player=12;
    }
    System.out.println();
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
    if(dealerSecond == 22){
      dealerSecond=12;
    }
    System.out.println("Der Dealer hat: "+dealerSecond);

    while(dealerSecond<17){
      tmpDealer = cd.getCard();
      dealerSecond += tmpDealer;

      // Prüfung ob der Dealer mit einem Ass mehr als 21 Punkte hätte
      if(tmpDealer==11&&dealerSecond>21){
        dealerSecond -=10;
      }

      System.out.println("Der Dealer hat aktuell: "+dealerSecond);
    }

    if(dealerSecond<22&&dealerSecond>player){
      System.out.println("Das Haus gewinnt mit: "+dealerSecond+". Sie haben: "+player+" Augen.");
      return false;
    }
    if (dealerSecond<22&&dealerSecond<player){
    System.out.println("Das Haus verliert mit: "+dealerSecond+". Sie haben gewonnen: "+player+" Augen.");
    return true;
    }
    if (dealerSecond<22&&dealerSecond==player){
    System.out.println("Unentschieden. Das Haus und Sie haben jeweils: "+dealerSecond);
    return true;
    }
    if(dealerSecond>21&&player<22){
      System.out.println("Sie gewinnen mit: "+player+" Der Deahler hat: "+dealerSecond);
      return true;
    }

    return true;
  }
}
