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
    while(auswahl!=2){
      System.out.println("Möchten sie weiter spien? Ihr akuteller Kartenwert beträgt: "+player);
      System.out.println("1. Neue Karte! \n2. Keine Karte!");
      Scanner scanner = new Scanner(System.in);
      auswahl = scanner.nextInt();
      if(auswahl == 1){
        player += cd.getCard();
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
