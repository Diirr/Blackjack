import java.util.*;

public class Play{

  public static void main(String[] args){
    Language language = new Language();
    language.chooseLanguage();

    GameMaster gm = new GameMaster(language);

    try{
      while(gm.start()!=2){
          gm.playAGame();
          Thread.sleep(2000);
      }
    }catch(Exception e){

    }
    try{
      System.out.println(language.printWait(1,14,0,0,""));
    }catch(Exception e){
      
    }
  }
}
