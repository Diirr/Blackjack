import java.util.*;

public class Language{

    int language = 1;
    String strDefault;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    String str11;
    String str12;
    String str13;

  public int getLanguage(){
    return this.language;
  }

  public void chooseLanguage(){
    Scanner scanner = new Scanner(System.in);
    int auswahl;
    System.out.println("In welcher Sprache möchten Sie Spielen\n1.Deutsch\n2.Englisch\n");
    auswahl = scanner.nextInt();
    this.language = auswahl;
  }

  public String printWait(int s, int str, int x, int y, String color) throws Exception {

    //Deutsch
    if(language ==1){
      strDefault = "Fehler 404";
      str1 = "Der Dealer hat eine "+x+" ("+color+") erhalten. Der aktuelle Kartenwert des Dealers beträgt "+y+".";
      str2 = "Sie haben eine "+x+" ("+color+") erhalten. Ihr aktueller Kartenwert beträgt "+y+".\n";
      str3 = "Der Dealer hat eine verdeckte Karte erhalten. Der aktuelle Kartenwert des Dealers beträgt "+x+".";
      str4 = "Herzlichen Glückwunsch - BlackJack!!!\n";
      str5 = "Der Dealer verliert mit "+x+". Sie gewinnen mit "+y+" Augen.\n\n";
      str6 = "Der Dealer gewinnt mit "+x+". Sie verlieren mit "+y+" Augen.\n\n";
      str7 = "Der Dealer hat "+x+" Augen. \n";
      str8 = "Der Dealer zieht eine Karte";
      str9 = "Sie haben sich für eine "+x+" entschieden. Ihr neuer Kartenwert beträgt: "+y+"\n";
      str10 = "Möchten sie weiter spielen? Ihr akuteller Kartenwert beträgt: "+x+ "\n\n1. Neue Karte! \n2. Keine Karte!\n";
      str11 = "Sie haben ein Ass ("+color+") erhalten. Soll es als 1 oder 11 gewertet werden?\n\n 1. Ass als 1 werten! \n2. Ass als 11 werten!\n";
      str12 = "Unentschieden. Beide haben "+x+" Augen.\n\n";
      str13 = "*************************************\nHerzlich Willkommen zu BLACKJACK!!!!\n*************************************\n1: Neues Spiel?\n2: Beenden?";
    }

    //Englisch
    if(language==2){
      strDefault = "Fehler 404";
      str1 = "The dealer has a "+x+" ("+color+"). The currently hand has "+y+".";
      str2 = "You've got a "+x+" ("+color+"). Your currently Hand is "+y+".\n";
      str3 = "Der Dealer hat eine verdeckte Karers beträgt "+x+".";
      str4 = "Herzlichen Glückwunsch - BlackJack!!!\n";
      str5 = "Der Dealer verliert mit "+x+". Sie gewinnen mit "+y+" Augen.\n\n";
      str6 = "Der Dealer gewinnt mit "+x+". Sie verlieren mit "+y+" Augen.\n\n";
      str7 = "Der Dealer hat "+x+" Augen. \n";
      str8 = "Der Dealer zieht eine Karte";
      str9 = "Sie haben sich für eine "+x+" entrt beträgt: "+y+"\n";
      str10 = "Möchten sie weiter spielen? Ihr akgt: "+x+ "\n\n1. Neue Karte! \n2. Keine Karte!\n";
      str11 = "Sie haben ein Ass ("+color+") erhalten. Soll es als 1 oerden?\n\n 1. Ass als 1 werten! \n2. Ass als 11 werten!\n";
      str12 = "Unentschieden. Beide haben "+x+" Augen.\n\n";
      str13 = "*************************************\nWelcome to BLACKJACK!!!!\n*************************************\n1: New Game?\n2: End?";
    }

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
      case 13:
          return str13;
      default:
          return strDefault;
    }
  }
}
