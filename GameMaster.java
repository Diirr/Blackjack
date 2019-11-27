import java.util.*;

public class GameMaster{

  public int start(){

      Scanner scanner = new Scanner(System.in);
      int auswahl;
      System.out.println("*************************************\nWelcome to BLACKJACK!!!!\n*************************************");
      System.out.println("1: New Game!");
      System.out.println("2: End!");

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
      System.out.println("Congratulations, you win - BlackJack!!!");
      return true;
    }

    if(player == 22){
      player=12;
    }
    System.out.println();
/*---------------------------------------------------------------------------------------------------------------*/
//Ab Runde 3 spielt der Spieler
    int auswahl = 1;
    int elevenOrOne;
    int karte= 0;
    while(auswahl!=2){
      System.out.println("Möchten sie weiter spielen? Ihr akuteller Kartenwert beträgt: "+player);
      System.out.println("\n1. Neue Karte! \n2. Keine Karte!\n");
      Scanner scanner = new Scanner(System.in);
      auswahl = scanner.nextInt();
      karte = cd.getCard();

      if(auswahl == 1 && karte != 11){

        player += kauswahlarte;
        System.out.println("\nSie haben eine "+ karte + " erhalten.\n");
        }
      if(auswahl == 1 && karte == 11){
        System.out.println("Sie haben ein Ass erhalten. Soll es als 1 oder 11 gewertet werden?\n");
        System.out.println("1. Ass als 1 werten! \n2. Ass als 11 werten!\n");
        elevenOrOne  = scanner.nextInt();
      if(elevenOrOne == 1){
        player += 1;
        System.out.println("Sie haben sich für eine 1 entschieden. Ihr neuer Kartenwert beträgt: "+player);
      }
      if(elevenOrOne == 2){
        player += 11;
        System.out.println("Sie haben sich für eine 11 entschieden. Ihr neuer Kartenwert beträgt: "+player);

      }
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
    System.out.println("The dealer has: "+dealerSecond);

    while(dealerSecond<17){
      System.out.println("The dealer draws a card!");
      tmpDealer = cd.getCard();
      dealerSecond += tmpDealer;
      // Prüfung ob der Dealer mit einem Ass mehr als 21 Punkte hätte
      if(tmpDealer==11&&dealerSecond>21){
        dealerSecond -=10;
      }

      System.out.println("Card: "+tmpDealer+" The dealer currently has: "+dealerSecond);
    }

    if(dealerSecond<22&&dealerSecond>player){
      System.out.println("The house wins with: "+dealerSecond+". You've got: "+player+" points.\n\n");
      return false;
    }
    if (dealerSecond<22&&dealerSecond<player){
    System.out.println("The house loses with: "+dealerSecond+". You win with: "+player+" points.\n\n");
    return true;
    }
    if (dealerSecond<22&&dealerSecond==player){
    System.out.println("We've got a draw with: "+dealerSecond+" points\n\n");
    return true;
    }
    if(dealerSecond>21&&player<22){
      System.out.println("You win with: "+player+" The dealer has: "+dealerSecond+" points\n\n");
      return true;
    }
    return true;
  }
}
