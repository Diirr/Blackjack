import java.util.*;

public class GameMaster{

  Language language;
  int dealerCount = 0;
  int playerCount = 0;
  int money = 0;
  int bet = 0;

  public GameMaster(Language language){
    this.language = language;
  }

  public int start() throws Exception{
      Scanner scanner = new Scanner(System.in);
      int auswahl;
      System.out.println(language.printWait(2,13,0,0,""));
      auswahl = scanner.nextInt();
      if(auswahl==1){
        playAGame();
      }
      return auswahl;
  }

  public int furtherRound() throws Exception{
    Scanner scanner = new Scanner(System.in);
    int auswahl;
    System.out.println(language.printWait(2,15,0,0,""));
    auswahl = scanner.nextInt();
    return auswahl;
  }

  public String result() throws Exception{
    if(dealerCount>playerCount){
      return language.printWait(1,14,dealerCount,playerCount,"");
    }
    if(dealerCount<playerCount){
      return language.printWait(1,16,dealerCount,playerCount,"");
    }else{
      return language.printWait(1,17,dealerCount,playerCount,"");
    }
  }

  public int bet() throws Exception{
    Scanner scanner = new Scanner(System.in);
    int bet;
    System.out.println(language.printWait(2,18,0,0,""));
    bet = scanner.nextInt();
    this.money = this.money - bet;
    return bet;
  }

  public void calculateWinnings(boolean bj) throws Exception {
    if(bj){
      this.money = this.money + (bet*3);
      System.out.println(language.printWait(1,19,this.money,0,""));
    }else{
      this.money = this.money + (bet*2);
      System.out.println(language.printWait(1,19,this.money,0,""));
    }
  }

  public String cashOut() throws Exception {
    return language.printWait(1,19,money,0,"");
  }

  public boolean playAGame() throws Exception{

    CardDeck cd = new CardDeck();
    cd.createDeck(language.getLanguage());
    //Kartenwerte der Spieler
    int dealerFirst=0;
    int dealerSecond=0;
    int player=0;

    this.bet = bet();
    //Runde 1
    int tmpDealer = cd.getCard();
    dealerFirst += tmpDealer;
    dealerSecond = dealerFirst;
    System.out.println(language.printWait(2,1,tmpDealer, dealerFirst,cd.getCardColor()));

    int tmpPlayer = cd.getCard();
    player += tmpPlayer;
    System.out.println(language.printWait(2,2, tmpPlayer, player,cd.getCardColor()));

    //Runde 2
    tmpDealer = cd.getCard();
    cd.getCardColor();
    dealerSecond += tmpDealer;
    System.out.println(language.printWait(2,3,dealerFirst,0,""));

    tmpPlayer = cd.getCard();
    player += tmpPlayer;
    //Sollte der Spieler 2 Asse erhalten spielt er automatisch mit 12 weiter. Spiel mit Split ist nicht vorgesehen.
    if(player == 22){
      player=12;
    }
    System.out.println(language.printWait(2,2,tmpPlayer, player,cd.getCardColor()));

    if(player==21){
      System.out.println(language.printWait(2,4,0,0,""));
      playerCount++;
      calculateWinnings(true);
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
      System.out.println(language.printWait(1,10,player,0,""));
      Scanner scanner = new Scanner(System.in);
      auswahl = scanner.nextInt();
      karte = cd.getCard();

      //Der Spieler zieht eine neue Karte und es kein Ass
      if(auswahl == 1 && karte != 11){
        player += karte;
        System.out.println(language.printWait(2,2,karte,player,cd.getCardColor()));
        }

      //Der Spieler zieht eine Karte und hat ein Ass gezogen
      if(auswahl == 1 && karte == 11){
        System.out.println(language.printWait(1,11,0,0,cd.getCardColor()));
        elevenOrOne  = scanner.nextInt();

        if(elevenOrOne == 1){
          player += 1;
          System.out.println(language.printWait(1,9,1,player,""));
        }

        if(elevenOrOne == 2){
          player += 11;
          System.out.println(language.printWait(1,9,11,player,""));
        }
      }
    }

      if(player == 21){
        System.out.println(language.printWait(2,4,0,0,""));
        playerCount++;
        calculateWinnings(true);
        return true;
      }
      if(player > 21){
        System.out.println(language.printWait(2,6,dealerSecond, player,""));
        System.out.println(cashOut());
        dealerCount++;
        return false;
      }
/*---------------------------------------------------------------------------------------------------------------*/
    // Dealer spielt nachdem alle gespielt haben
    System.out.println(language.printWait(1,7,dealerSecond,0,""));

    while(dealerSecond<17){
      System.out.println(language.printWait(2,8,0,0,""));
      tmpDealer = cd.getCard();
      dealerSecond += tmpDealer;
      // Prüfung ob der Dealer mit einem Ass mehr als 21 Punkte hätte
      if(tmpDealer==11&&dealerSecond>21){
        dealerSecond -=10;
      }
      System.out.println(language.printWait(1,1,tmpDealer,dealerSecond,cd.getCardColor()));
    }

    if(dealerSecond<22&&dealerSecond>player){
      System.out.println(language.printWait(2,6,dealerSecond, player,""));
      System.out.println(cashOut());
      dealerCount++;
      return false;
    }
    if (dealerSecond<22&&dealerSecond<player){
      System.out.println(language.printWait(2,5,dealerSecond,player,""));
      calculateWinnings(false);
      playerCount++;
      return true;
    }
    if (dealerSecond<22&&dealerSecond==player){
      System.out.println(language.printWait(1,12,dealerSecond,0,""));
      this.money = this.money + this.bet;
      System.out.println(cashOut());
      dealerCount++;
      playerCount++;

      return true;
    }
    if(dealerSecond>21&&player<22){
      System.out.println(language.printWait(2,5,dealerSecond,player,""));
      calculateWinnings(false);
      playerCount++;
      return true;
    }
    return true;
  }
}
