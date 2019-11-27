public class Play{

  public static void main(String[] args){

      GameMaster gm = new GameMaster();

      while(gm.start()!=2){
        try{
          gm.playAGame();
          Thread.sleep(3000);
        }catch(Exception e){

        }
      }

      System.out.println("Vielen Dank für Ihre Teilnahme!!!");
  }
}
