package com.titanomachy.Blackjack.Deck;

import java.util.*;

public class Deck
{
    private Map<Integer, Card> deck;
    private Random ran;

    public Deck()
    {
        this.deck = new HashMap<Integer, Card>();
        this.ran = new Random();
    }

    public void buildDeck()
    {
        int count = 1;
        for(int i =0; i <= 3; i++)
        {
            for (int j=1; j<=13; j++)
            {

                    this.deck.put(count, new Card(j, i));
                    count++;

            }
        }
    }

    public void printCards()
    {
        for(int i:this.deck.keySet())
        {
            System.out.println("Key: " + i + ". Card: " + this.deck.get(i).toString() + ". Score: " + this.deck.get(i).getScore());
        }
    }

    public Card deal()
    {
            ArrayList<Integer> tracking = new ArrayList<Integer>();

            int r = ran.nextInt(51) + 1;
            if(!this.deck.containsKey(r))
            {
                deal();
            }
            else if(tracking.contains(r))
            {
                deal();
            }
            tracking.add(r);
            return this.deck.get(r);


    }


}
