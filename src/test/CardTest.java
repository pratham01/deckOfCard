package test;

import main.Card;
import org.junit.jupiter.api.Assertions;

class CardTest {

    @org.junit.jupiter.api.Test
    void getNumber() {

        Card card = new Card("SPADE", "2");
        Assertions.assertEquals("2" , card.getNumber());
    }
}