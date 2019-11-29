import java.util.*;

public class Play{

  public static void main(String[] args){
    Language language = new Language();
    language.chooseLanguage();

    GameMaster gm = new GameMaster(language);

    try{
      gm.start();
      gm.playAGame();
      while(gm.furtherRound()!=2){
          gm.playAGame();
      }
    }catch(Exception e){

    }
    try{
      System.out.println(language.printWait(1,14,0,0,""));
    }catch(Exception e){

    }
  }
}
