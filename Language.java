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
    String str14;
    String str15;
    String str16;
    String str17;
    String str18;
    String str19;

  public int getLanguage(){
    return this.language;
  }

  public void chooseLanguage(){
    Scanner scanner = new Scanner(System.in);
    int auswahl;
    System.out.println("Please choose your language:\n1.Deutsch\n2.English\n");
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
      str10 = "Möchten sie weiter spielen? Ihr akuteller Kartenwert beträgt: "+x+ "\n\n1. Neue Karte? \n2. Keine Karte?\n";
      str11 = "Sie haben ein Ass ("+color+") erhalten. Soll es als 1 oder 11 gewertet werden?\n\n1. Ass als 1 werten? \n2. Ass als 11 werten?\n";
      str12 = "Unentschieden. Dealer und Spieler haben "+x+" Augen.\n\n";
      str13 = "*************************************\nHerzlich Willkommen zu BLACKJACK!!!!\n*************************************\n1: Neues Spiel?\n2: Beenden?";
      str14 = "Der Dealer hat das Spiel gewonnen.\n Der Dealer hat: "+x+"\n Sie haben: "+y+"\nVielen Dank für Ihre Teilnahme!!!";
      str15 = "Möchten Sie weiter spielen oder das Spiel beenden?\n1. Neue Runde?\n2. Beenden?";
      str16 = "Sie haben das Spiel gewonnen. Herzlichen Glückwunsch!!\nDer Dealer hat: "+x+"\nSie haben: "+y+"\nVielen Dank für Ihre Teilnahme!!!";
      str17 = "Das Spiel endet unentschieden.\nDer Dealer hat: "+x+"\nSie haben: "+y+"\nVielen Dank für Ihre Teilnahme!!!";
      str18 = "Bitte machen Sie Ihren Einsatz.\n";
      str19 = "Sie haben "+x+"€ gewonnen.\n";
    }

    //Englisch
    if(language==2){
      strDefault = "Fehler 404";
      str1 = "The dealer has received a "+x+" ("+color+"). The dealer currently has "+y+".";
      str2 = "You have received a "+x+" ("+color+"). You currently have "+y+".\n";
      str3 = "The dealer has received a face down card. The dealer currently has "+x+".";
      str4 = "Congratulations - BlackJack!!!\n";
      str5 = "The dealer loses with "+x+". You win with "+y+".\n\n";
      str6 = "The dealer wins with "+x+". You lose with "+y+".\n\n";
      str7 = "The dealer has "+x+" points. \n";
      str8 = "The dealer draws a card.";
      str9 = "You have chosen a "+x+". Your new card value is: "+y+"\n";
      str10 = "Would you like to draw a card? Your current card value is: "+x+"\n\n1. New card?\n2. No card?\n";
      str11 = "You have received an ace ("+ color +"). Should it be counted as 1 or 11?\n\n1. Ass as value 1? \n2. Ass as value 11?\n";
      str12 = "Draw. Dealer and player have "+x+".\n\n";
      str13 = "*************************************\nWelcome to BLACKJACK!!!!\n*************************************\n1: New Game?\n2: End?";
      str14 = "We're afraid you lost. \nThe dealer wins with: "+x+" points\n You only have: "+y+"\nThank you for your participation!!";
      str15 = "Would you like to continue playing or end the game?\n1. Continue playing?\n2.Stop playing?";
      str16 = "Congratulations - you win!!!!\nThe dealer has: "+x+"\nYou have: "+y+"\nThank you for your participation!!";
      str17 = "The game ends with a draw. \nThe dealer has: "+x+"\nYou have: "+y+"\nThank you for your participation!!";
      str18 = "Please place your bet\n";
      str19 = "You won "+x+"$\n";
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
      case 14:
          return str14;
      case 15:
          return str15;
      case 16:
          return str16;
      case 17:
          return str17;
      case 18:
          return str18;
      case 19:
          return str19;
      default:
          return strDefault;
    }
  }
}
