package com.titanomachy.Blackjack.Deck;


import java.util.ArrayList;
import java.util.List;

public class Hand
{
    private List<Card> cards;

    //constructors
    public Hand()
    {
        this.cards = new ArrayList<Card>();
    }

    //setMethods
    public  void add(Card card)
    {
        this.cards.add(card);
    }

    //getMethods
    public int total()
    {
        int count = 0;
        for(Card c:this.cards)
        {
            if((c.getValue() == 1) && (count>=10))
            {
                c.setAce();
            }
            count += c.getScore();
        }
        return count;
    }

    public int handSize()
    {
        return this.cards.size();
    }

    public void printHand()
    {
        for(Card c:this.cards)
        {
            System.out.println(c);
        }
    }

    @Override
    public String toString()
    {
        String out = "";
        for(Card c:this.cards)
        {
            out += c.toString() + "\n";
        }
        return out;
    }
}
