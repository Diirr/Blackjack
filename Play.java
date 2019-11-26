public class Play{

  public static void main(String[] args){

    //Dealer d;
    //Player p;
      GameMaster gm = new GameMaster();

      if(gm.start()==2){
        System.out.println("Vielen Dank für Ihre Teilnahme!!!!");
      }else{
        gm.playAGame();
      }
  }
}
