package test;

import com.sun.nio.sctp.Association;
import main.Card;
import main.CardDeck;
import main.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void getCard() {
        CardDeck cardDeck = new CardDeck();
        Card card = cardDeck.getCard(2,0);
        Assertions.assertEquals("A", card.getNumber() );

        Card queenCard = cardDeck.getCard(2,11);
        Assertions.assertEquals("Q", queenCard.getNumber());

        Card kingCard = cardDeck.getCard(2,12);
        Assertions.assertEquals("K", kingCard.getNumber());

    }

    @Test
    void getMaxCardList() {
        CardDeck cardDeck = new CardDeck();
        ArrayList<Card> cardList = new ArrayList<>();
        Card card1 = cardDeck.getCard(2,0);
        Card card2 = cardDeck.getCard(0,0);
        Card card3 = cardDeck.getCard(1,0);

        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        Result result = cardDeck.getMaxCardList(cardList);
        Result actualResult = new Result(4,14);
        Assertions.assertEquals(0, actualResult.compareTo(result), "Precedence are same");

    }
}