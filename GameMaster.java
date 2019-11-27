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

  public String printWait(int s, int str, int x, int y, String color) throws Exception {

    String strDefault = "Fehler 404";
    String str1 = "Der Dealer hat eine "+x+" ("+color+") erhalten. Der aktuelle Kartenwert des Dealers beträgt "+y+".";
    String str2 = "Sie haben eine "+x+" ("+color+") erhalten. Ihr aktueller Kartenwert beträgt "+y+".\n";
    String str3 = "Der Dealer hat eine verdeckte Karte erhalten. Der aktuelle Kartenwert des Dealers beträgt "+x+".";
    String str4 = "Herzlichen Glückwunsch - BlackJack!!!\n";
    String str5 = "Der Dealer verliert mit "+x+". Sie gewinnen mit "+y+" Augen.\n\n";
    String str6 = "Der Dealer gewinnt mit "+x+". Sie verlieren mit "+y+" Augen.\n\n";
    String str7 = "Der Dealer hat "+x+" Augen. \n";
    String str8 = "Der Dealer zieht eine Karte";
    String str9 = "Sie haben sich für eine "+x+" entschieden. Ihr neuer Kartenwert beträgt: "+y+"\n";
    String str10 = "Möchten sie weiter spielen? Ihr akuteller Kartenwert beträgt: "+x+ "\n\n1. Neue Karte! \n2. Keine Karte!\n";
    String str11 = "Sie haben ein Ass ("+color+") erhalten. Soll es als 1 oder 11 gewertet werden?\n\n 1. Ass als 1 werten! \n2. Ass als 11 werten!\n";
    String str12 = "Unentschieden. Beide haben "+x+" Augen.\n\n";

    Thread.sleep(s*1000);

    switch(str){
      case 1:
          return str1;
      case 2:
          return str2;
      case 3:
          return str3;
      case 4:
          return str4;
      case 5:
          return str5;
      case 6:
          return str6;
      case 7:
          return str7;
      case 8:
          return str8;
      case 9:
          return str9;
      case 10:
          return str10;
      case 11:
          return str11;
      case 12:
          return str12;
      default:
          return strDefault;
    }
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
    dealerFirst += tmpDealer;
    dealerSecond = dealerFirst;
    System.out.println(printWait(2,1,tmpDealer, dealerFirst,cd.getCardColor()));

    int tmpPlayer = cd.getCard();
    player += tmpPlayer;
    System.out.println(printWait(2,2, tmpPlayer, player,cd.getCardColor()));

    //Runde 2
    tmpDealer = cd.getCard();
    cd.getCardColor();
    dealerSecond += tmpDealer;
    System.out.println(printWait(2,3,dealerFirst,0,""));

    tmpPlayer = cd.getCard();
    player += tmpPlayer;

    if(player == 22){
      player=12;
    }

    System.out.println(printWait(2,2,tmpPlayer, player,cd.getCardColor()));

    if(player==21){
      System.out.println(printWait(2,4,0,0,""));
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

    // Weiterspielen und neue Karte ziehen oder seinen Spielzug beenden
    while(auswahl!=2&&player<21){
      System.out.println(printWait(1,10,player,0,""));
      Scanner scanner = new Scanner(System.in);
      auswahl = scanner.nextInt();
      karte = cd.getCard();

      //Der Spieler zieht eine neue Karte und es kein Ass
      if(auswahl == 1 && karte != 11){
        player += karte;
        System.out.println(printWait(2,2,karte,player,cd.getCardColor()));
        }

      //Der Spieler zieht eine Karte und hat ein Ass gezogen
      if(auswahl == 1 && karte == 11){
        System.out.println(printWait(1,11,0,0,cd.getCardColor()));
        elevenOrOne  = scanner.nextInt();

        if(elevenOrOne == 1){
          player += 1;
          System.out.println(printWait(1,9,1,player,""));
        }

        if(elevenOrOne == 2){
          player += 11;
          System.out.println(printWait(1,9,11,player,""));
        }
      }
    }

      if(player == 21){
        System.out.println(printWait(2,4,0,0,""));
        return true;
      }
      if(player > 21){
        System.out.println(printWait(2,6,dealerSecond, player,""));
        return false;
      }
/*---------------------------------------------------------------------------------------------------------------*/
    // Dealer spielt nachdem alle gespielt haben
    System.out.println(printWait(1,7,dealerSecond,0,""));

    while(dealerSecond<17){
      System.out.println(printWait(2,8,0,0,""));
      tmpDealer = cd.getCard();
      dealerSecond += tmpDealer;
      // Prüfung ob der Dealer mit einem Ass mehr als 21 Punkte hätte
      if(tmpDealer==11&&dealerSecond>21){
        dealerSecond -=10;
      }
      System.out.println(printWait(1,1,tmpDealer,dealerSecond,cd.getCardColor()));
    }

    if(dealerSecond<22&&dealerSecond>player){
      System.out.println(printWait(2,6,dealerSecond, player,""));
      return false;
    }
    if (dealerSecond<22&&dealerSecond<player){
      System.out.println(printWait(2,5,dealerSecond,player,""));
      return true;
    }
    if (dealerSecond<22&&dealerSecond==player){
      System.out.println(printWait(1,12,dealerSecond,0,""));
      return true;
    }
    if(dealerSecond>21&&player<22){
      System.out.println(printWait(2,5,dealerSecond,player,""));
      return true;
    }
    return true;
  }
}
