public class Player {

  public Player (String name, int punkte) {
    this.name = name;
    this.punkte = punkte;
  }

public void drawCard (int augen){
  this.punkte = punkte+augen;

}

  public aufdecken (int dealersPoints{
    if (this.punkte<dealersPoints){
        System.out.println (this.name+" ist raus aus dem Spiel. Was'n Looser ;-)");
    };
    if (this.punkte==21){
      System.out.println (this.name+" HAT GEWONNEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!);
    }
  }

}
