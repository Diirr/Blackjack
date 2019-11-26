import java.util.ArrayList;

public class CardDeck {

  ArrayList<Integer> cards = new ArrayList<Integer> ();
  Integer[] cardsNumbers = {2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,
        10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,
      11,11,11,11};

public void createDeck (){
    for (int i=0; i<cardsNumbers.length; i++) {
    cards.add (cardsNumbers[i]);
  }
}

  public int getCard () {
    int zufallsindex = (int) (Math.random() * cards.size());
    int newCard = cardsNumbers[zufallsindex];
    cards.remove (zufallsindex);

    return newCard;

  }


}
