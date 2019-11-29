import java.util.*;

public class Play{

  public static void main(String[] args){
    Language language = new Language();
    language.chooseLanguage();

    GameMaster gm = new GameMaster(language);

    try{
      if(gm.start()!=2){
        while(gm.furtherRound()!=2){
            gm.playAGame();
        }
      }
      System.out.println(gm.cashOut());
      System.out.println(gm.result());
    }catch(Exception e){
      //Fehlerbeschreibung
    }
  }
}
