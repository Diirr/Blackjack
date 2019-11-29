import java.util.ArrayList;

public class CardDeck {

  int zufallsindex = 0;

  ArrayList<Integer> cards = new ArrayList<Integer> ();
  ArrayList<String> cardsColors = new ArrayList<String>();

  int[] cardsNumbers = {2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,
        10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,
      11,11,11,11};

  String[] colorDE =
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

  String[] colorEN =
  {
  "2 of hearts","2 of cross","2 of spade","2 of diamond",
  "3 of hearts","3 of cross","3 of spade","3 of diamond",
  "4 of hearts","4 of cross","4 of spade","4 of diamond",
  "5 of hearts","5 of cross","5 of spade","5 of diamond",
  "6 of hearts","6 of cross","6 of spade","6 of diamond",
  "7 of hearts","7 of cross","7 of spade","7 of diamond",
  "8 of hearts","8 of cross","8 of spade","8 of diamond",
  "9 of hearts","9 of cross","9 of spade","9 of diamond",
  "10 of hearts","10 of cross","10 of spade","10 of diamond",
  "Jack of hearts","Jack of cross","Jack of spade","Jack of diamond",
  "Queen of hearts","Queen of cross","Queen of spade","Queen of diamond",
  "King of hearts","King of cross","King of spade","King of diamond",
  "Ass of hearts","Ass of corss","Ass of spade","Ass of diamond"
  };

  public void createDeck (int x){
      for (int i=0; i<cardsNumbers.length; i++) {
      cards.add (cardsNumbers[i]);

      if(x==1){
        cardsColors.add(colorDE[i]);
      }
      if(x==2){
        cardsColors.add(colorEN[i]);
      }
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
