import java.util.*;

public class GameMaster{

  //Dealer dealer;
  //Player player;

  /*public GameMaster(Dealer d, Player p){
    this.dealer = d;
    this.player = p;
  }*/

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
    int dealer=0;
    int player=0;

    //Runde 1
    dealer += cd.getCard();
    player += cd.getCard();
    System.out.println("Runde 1!");
    System.out.println("Dealer: "+dealer);
    System.out.println("Player: "+player);

    //Runde 2
    dealer += cd.getCard();
    player += cd.getCard();
    System.out.println("Runde 2!");
    System.out.println("Dealer: "+dealer);
    System.out.println("Player: "+player);

    if(player==21){
      System.out.println("Herzlichen Glückwunsch");
      return true;
    }

    if(player == 22){
      player=12;
    }

    //Ab Runde 3 spielt der Spieler
    int auswahl = 1;
    while(auswahl!=2){
      System.out.println("Möchten sie weiter spien? Ihr akuteller Kartenwert beträgt: "+player);
      System.out.println("1. Neue Karte! \n2. Ke      dealer += cd.getCard();
ine Karte!");
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
        System.out.println("Sie haben verloren. Aktuelle Punktzahl: "+player+" Der Deahler hat: "+dealer);
        return false;
      }
    }

    // Dealer spielt nachdem alle gespielt haben
    while(dealer<17){
      dealer += cd.getCard();
      System.out.println("Der Dealer hat aktuell: "+dealer);
    }

    if(dealer<22&&dealer>player){
      System.out.println("Das Haus gewinnt: "+dealer+"Sie haben: "+player);
      return false;
    }
    if(dealer>21&&player<22){
      System.out.println("Sie gewinnen: "+player+" Der Deahler hat: "+dealer);
      return true;
    }

    System.out.println("Sie haben verloren + letzte Ausgabe");
    return true;
  }
}
