package com.titanomachy.Blackjack.Deck;

public class Card implements Comparable<Card>
{
    public static final int SPADES = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;

    public static final String[] SUITS = {"Spades", "Diamonds", "Hearts", "Clubs"};
    public static final String[] VALUES = {"-", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "-"};
    private int value;
    private int suit;
    private int score;


    //Constructors
    public Card(int value, int suit)
    {
        if(value == 1)
        {
            this.score = 11;
        }
        else if(value <= 10)
        {
            this.score = value;
        }
        else
        {
            this.score = 10;
        }
        this.value = value;
        this.suit = suit;

    }


    //getMethods

    public int getScore()
    {
        return this.score;
    }

    public int getValue()
    {
        return this.value;
    }
    public int getSuit()
    {
        return this.suit;
    }

    //setMethods
    public void setAce()
    {
        this.score = 1;
    }

    //ovverrides


    @Override
    public String toString()
    {
        return VALUES[this.value] + " of " + SUITS[this.suit];
    }

    @Override
    public int compareTo(Card card)
    {
        return this.value - card.getScore();
    }

    //misc.

}
