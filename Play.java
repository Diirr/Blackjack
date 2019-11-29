import java.util.*;

public class Play{

  public static void main(String[] args){
    Language language = new Language();
    language.chooseLanguage();

    GameMaster gm = new GameMaster(language);
    try{
      while(gm.start()!=2){
          gm.playAGame();
          Thread.sleep(3000);
      }
    }catch(Exception e){

    }
    System.out.println("Vielen Dank für Ihre Teilnahme!!!");
  }
}
