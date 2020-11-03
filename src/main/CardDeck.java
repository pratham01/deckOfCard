package main;

import main.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CardDeck {

    private Map<String, Integer> cardMap = new HashMap<>();
    private List<String> cardList ;
    private List<String> categoryList;

    public CardDeck(){
        this.cardList = List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K");
        this.categoryList = List.of("HEARTS","DIAMONDS","SPADE","CLUB");
        this.cardMap.put("2",2);
        this.cardMap.put("3",3);
        this.cardMap.put("4",4);
        this.cardMap.put("5",5);
        this.cardMap.put("6",6);
        this.cardMap.put("7",7);
        this.cardMap.put("8",8);
        this.cardMap.put("9",9);
        this.cardMap.put("10",10);
        this.cardMap.put("J",11);
        this.cardMap.put("Q",12);
        this.cardMap.put("K",13);
        this.cardMap.put("A",14);
    }


    public Card getCard(int categoryIndex, int numberIndex ){
        return new Card(categoryList.get(categoryIndex), cardList.get(numberIndex));
    }

    
    public Result getMaxCardList(List<Card> cardList){
        System.out.println();
        cardList.sort((Card card1, Card card2)->cardMap.get(card1.getNumber()).compareTo(cardMap.get(card2.getNumber())));
        String ele1 = cardList.get(0).getNumber();
        String ele2 = cardList.get(1).getNumber();
        String ele3 = cardList.get(2).getNumber();
        if( (cardMap.get(ele1) == cardMap.get(ele2) ) && (cardMap.get(ele2)== cardMap.get(ele3))){
            return new Result(4,cardMap.get(ele1) );
        }else if((cardMap.get(ele2) -cardMap.get(ele2) ==1 ) && (cardMap.get(ele3)- cardMap.get(ele2) ==1)) {
            return new Result(3,cardMap.get(ele3) );
        }  else if((cardMap.get(ele1) == cardMap.get(ele2) ) || (cardMap.get(ele2)== cardMap.get(ele3))) {
//            String temp_ele = cardMap.get(ele2) >(cardMap.get(ele3))? cardMap.get(ele2).toString() : cardMap.get(ele3).toString();
            return new Result(2,cardMap.get(ele2) );
        } else{
            return new Result(1,cardMap.get(ele3) );
        }
    }
}
