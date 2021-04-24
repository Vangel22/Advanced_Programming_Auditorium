package auditoriska2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {

    private PlayingCard[] cards;
    private boolean[] picked;
    private int pickedTotal;

    public Deck(){
        cards = new PlayingCard[52];
        picked = new boolean[52];
        pickedTotal = 0;
        for(int i=0; i<PlayingCard.TYPE.values().length; i++){
            for(int j=0; j<13; j++){
                cards[i + 13*i] = new PlayingCard(PlayingCard.TYPE.values()[i],j+1);
            }
        }
    }

    public PlayingCard[] getCards() {
        return cards;
    }

    public void setCards(PlayingCard[] cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;

        if(this.getClass() != obj.getClass()) return false;

        Deck other = (Deck) obj; //moram da go dodelam objektot na other bidejki obj e od klasata Object i samo
        //se prima kako argument vo funkcijata equals
        return Arrays.equals(cards, other.cards);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(cards);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PlayingCard card: cards){
            sb.append(card);
            sb.append("\n");
        }
        return sb.toString();
    }
    public PlayingCard[] shuffle(){
        List<PlayingCard> playingCardsList = Arrays.asList(cards);
        Collections.shuffle(playingCardsList);
        return cards;
    }
    public PlayingCard dealCards(){
        if(pickedTotal == 52) return null;
        int card = (int)(52 * Math.random()); //random karta se bira
        if(!picked[card]){ //ako ne e izbrana
            picked[card] = true; //ja pravime vozmozna da se izbere
            pickedTotal++;
            return cards[card];
        }
        return dealCards(); //probaj da podelis nekoja druga karta
    }
    public boolean hasCards(){
        return cards.length > 0;
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);

        deck.shuffle();
        System.out.println(deck);

        PlayingCard card;
        while ((card = deck.dealCards()) != null){ //dokolku postoi karta koja e izbrana vo spilot od karti
            System.out.println(card); //ispecati ja taa karta
        }
    }
}
