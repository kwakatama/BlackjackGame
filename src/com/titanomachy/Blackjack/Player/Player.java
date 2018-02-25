package com.titanomachy.Blackjack.Player;

import com.titanomachy.Blackjack.Deck.Card;
import com.titanomachy.Blackjack.Deck.Hand;

public class Player
{
    private Hand hand;
    private String name;
    public Player(String name)
    {
        this.hand = new Hand();
        this.name = name;
    }

    public void hit(Card card)
    {
        this.hand.add(card);
    }

    public String getName()
    {
        return this.name;
    }

    public int handSize()
    {
        return this.hand.handSize();
    }


    @Override
    public String toString()
    {
        if(this.getPlayerScore() > 21)
        {
            return this.name + ": \n" + this.hand.toString() + "Score: " + this.getPlayerScore() + "\nBust!";
        }
        else if(this.getPlayerScore() == 21)
        {
            return this.name + ": \n" + this.hand.toString() + "Score: " + this.getPlayerScore() + "\nBLACKJACK";
        }
        return this.name + ": \n" + this.hand.toString() + "Score: " + this.getPlayerScore();
    }

    public int getPlayerScore()
    {
        return this.hand.total();
    }
}
