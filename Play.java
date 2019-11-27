public class Play{

  public static void main(String[] args){

    //Dealer d;
    //Player p;
      GameMaster gm = new GameMaster();

      while(gm.start()!=2){
        System.out.println();
        System.out.println();
        gm.playAGame();
      }
      System.out.println("Thank you for playing!!!");
  }
}
