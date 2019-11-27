import java.util.*;

public class GameMaster{

  public int start(){

      Scanner scanner = new Scanner(System.in);
      int auswahl;
      System.out.println("*************************************\nHerzlich Willkommen zu BLACKJACK!!!!\n*************************************");
      System.out.println("1: Neues Spiel");
      System.out.println("2: Beenden");

      auswahl = scanner.nextInt();
      return auswahl;
  }

  public boolean playAGame() throws Exception{

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

    System.out.println("Der Dealer hat eine "+tmpDealer+" erhalten. Der aktuelle Kartenwert beträgt "+dealerFirst+".");
    Thread.sleep(2000);
    System.out.println("Sie haben eine "+tmpPlayer+" erhalten. Der aktuelle Kartenwert beträgt "+player+".\n");
    Thread.sleep(2000);

    //Runde 2
    tmpDealer = cd.getCard();
    tmpPlayer = cd.getCard();

    dealerSecond += tmpDealer;
    player += tmpPlayer;

    if(player == 22){
      player=12;
    }

    System.out.println("Der Dealer hat eine verdeckte Karte erhalten. Der aktuelle Kartenwert beträgt "+dealerFirst+".");
    Thread.sleep(2000);
    System.out.println("Sie haben eine "+tmpPlayer+" erhalten. Der aktuelle Kartenwert beträgt "+player+".\n");
    Thread.sleep(3000);

    if(player==21){
      System.out.println("Herzlichen Glückwunsch - BlackJack!!!\n");
      return true;
    }

    if(dealerSecond == 22){
      dealerSecond=12;
    }

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
        player += karte;
        Thread.sleep(1000);
        System.out.println("Sie haben eine "+karte+" erhalten. Der aktuelle Kartenwert beträgt "+player+".");
        }

      if(auswahl == 1 && karte == 11){
        Thread.sleep(1000);
        System.out.println("Sie haben ein Ass erhalten. Soll es als 1 oder 11 gewertet werden?\n");
        System.out.println("1. Ass als 1 werten! \n2. Ass als 11 werten!\n");
        elevenOrOne  = scanner.nextInt();

        if(elevenOrOne == 1){
          player += 1;
          Thread.sleep(1000);
          System.out.println("Sie haben sich für eine 1 entschieden. Ihr neuer Kartenwert beträgt: "+player+"\n");
        }

        if(elevenOrOne == 2){
          player += 11;
          Thread.sleep(1000);
          System.out.println("Sie haben sich für eine 11 entschieden. Ihr neuer Kartenwert beträgt: "+player+"\n");
        }
      }
    }

      if(player == 21){
        Thread.sleep(1000);
        System.out.println("Sie haben gewonnen - BLACKJACK!!!!!!!\n\n");
        return true;
      }
      if(player > 21){
        Thread.sleep(1000);
        System.out.println("Der Dealer gewinnt mit "+dealerSecond+". Sie verlieren mit "+player+" Augen.\n\n");
        return false;
      }
/*---------------------------------------------------------------------------------------------------------------*/
    // Dealer spielt nachdem alle gespielt haben
    Thread.sleep(1000);
    System.out.println("Der Dealer hat "+dealerSecond+" Augen. \n");

    while(dealerSecond<17){
      System.out.println("Der Dealer zieht eine Karte");
      Thread.sleep(2000);
      tmpDealer = cd.getCard();
      dealerSecond += tmpDealer;
      // Prüfung ob der Dealer mit einem Ass mehr als 21 Punkte hätte
      if(tmpDealer==11&&dealerSecond>21){
        dealerSecond -=10;
      }

      System.out.println("Der Dealer hat eine "+tmpDealer+" erhalten. Der aktuelle Kartenwert beträgt "+dealerSecond+".\n");
    }

    if(dealerSecond<22&&dealerSecond>player){
      Thread.sleep(1000);
      System.out.println("Der Dealer gewinnt mit "+dealerSecond+". Sie verlieren mit "+player+" Augen.\n\n");
      return false;
    }
    if (dealerSecond<22&&dealerSecond<player){
      Thread.sleep(1000);
      System.out.println("Der Dealer verliert mit "+dealerSecond+". Sie gewinnen mit "+player+" Augen.\n\n");
      return true;
    }
    if (dealerSecond<22&&dealerSecond==player){
      Thread.sleep(1000);
      System.out.println("Unentschieden. Beide haben "+dealerSecond+" Augen.\n\n");
      return true;
    }
    if(dealerSecond>21&&player<22){
      Thread.sleep(1000);
      System.out.println("Der Dealer verliert mit "+dealerSecond+". Sie gewinnen mit "+player+" Augen.\n\n");
      return true;
    }
    return true;
  }
}
