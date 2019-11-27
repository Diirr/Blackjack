import java.util.ArrayList;

public class CardDeck {

  int zufallsindex = 0;

  ArrayList<Integer> cards = new ArrayList<Integer> ();
  ArrayList<String> cardsColors = new ArrayList<String>();

  int[] cardsNumbers = {2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,
        10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,
      11,11,11,11};

  String[] color =
  {
  "Herz 2","Kreuz 2","Pik 2","Karo 2",
  "Herz 3","Kreuz 3","Pik 3","Karo 3",
  "Herz 4","Kreuz 4","Pik 4","Karo 4",
  "Herz 5","Kreuz 5","Pik 5","Karo 5",
  "Herz 6","Kreuz 6","Pik 6","Karo 6",
  "Herz 7","Kreuz 7","Pik 7","Karo 7",
  "Herz 8","Kreuz 8","Pik 8","Karo 8",
  "Herz 9","Kreuz 9","Pik 9","Karo 9",
  "Herz 10","Kreuz 10","Pik 10","Karo 10",
  "Herz Bube","Kreuz Bube","Pik Bube","Karo Bube",
  "Herz Dame","Kreuz Dame","Pik Dame","Karo Dame",
  "Herz König","Kreuz König","Pik König","Karo König",
  "Herz Ass","Kreuz Ass","Pik Ass","Karo Ass"
  };

  public void createDeck (){
      for (int i=0; i<cardsNumbers.length; i++) {
      cards.add (cardsNumbers[i]);
      cardsColors.add(color[i]);
    }
  }

  public int getCard () {
    this.zufallsindex = (int) (Math.random() * cards.size());
    int newCard = cards.get(zufallsindex);

    cards.remove (zufallsindex);
    return newCard;
  }

  public String getCardColor(){
    String tmpColor = cardsColors.get(zufallsindex);
    cardsColors.remove(zufallsindex);
    return tmpColor;
  }
}
