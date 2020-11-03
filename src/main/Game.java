package main;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Game {

    final int CARDCOUNT= 3;
    private  CardDeck cardDeck = new CardDeck();
    private AtomicInteger id = new AtomicInteger(0);
    private List<Player> playerList = new ArrayList<>(4);
    private Map<Player, List<Card>> playerPosition = new HashMap<>();

    private Map<Player, Result> resultMap = new HashMap<>();

    public void registerPlayer(String name){
        Player player = new Player(id.incrementAndGet(), name);
        playerList.add(player);
    }

    public void start(){
        Set<Card> consumeCardSet = new HashSet<>();

        for(Player playerCounter: playerList){
            List<Card> list = new ArrayList<>(3);
            for(int i=0;i<CARDCOUNT;i++){
                int randCategory = (int)(Math.random()*4);
                int randNumber =  (int)(Math.random()*13);
                Card card = cardDeck.getCard(randCategory, randNumber);
                if(!consumeCardSet.contains(card)){
                    consumeCardSet.add(card);
                    list.add(card);
                } else{
                    i-=1;
                }
            }
            playerPosition.put(playerCounter, list );
        }

        //print current state
        System.out.println("Current state is");
        playerPosition.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        //get result
        for(Player playerCounter: playerList){
            resultMap.put(playerCounter, cardDeck.getMaxCardList(playerPosition.get(playerCounter)));
        }
        //map result
        Map<Player, Result> result = resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new));

        result.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });



        Map.Entry<Player, Result> entry = result.entrySet().iterator().next();
        Player key = entry.getKey();
        Result value = entry.getValue();

        System.out.println("Winner is  "+ key);
        System.out.println("Player cards are "+ Arrays.toString(playerPosition.get(key).toArray()) );
    }
}
