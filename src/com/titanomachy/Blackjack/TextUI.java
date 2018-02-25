package com.titanomachy.Blackjack;


import com.titanomachy.Blackjack.Deck.Card;
import com.titanomachy.Blackjack.Deck.Deck;
import com.titanomachy.Blackjack.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUI
{
    private List<Player> players;
    private Deck deck;
    private Scanner scan;

    public TextUI(Scanner scan)
    {
        this.players = new ArrayList<Player>();
        this.deck = new Deck();
        this.scan = scan;
    }

    //starts the gme and prompts for player names until an empty string is entered
    public void start()
    {
        String input =  " ";
        System.out.println("BLACKJACK!");
        this.players.add(new Player("Dealer"));


        while (!input.isEmpty())
        {
            System.out.println("Enter Player name: ");
            input = this.scan.nextLine();
            if(input.isEmpty())
            {
                System.out.println("Let the games begin!!!! \n\nDealing cards... \n\nTable shows: \n");
                break;
            }
            players.add(new Player(input));
        }
        this.shuffle();
    }

    public void shuffle()
    {
        this.deck.buildDeck();
        //this.deck.printCards();
        this.deal();
    }

    //deals each player two cards
    public void deal()
    {
        for(Player p:this.players)
        {
            p.hit(deck.deal());
            p.hit(deck.deal());

        }

        for(Player p:this.players)
        {
            System.out.println(p + "\n") ;
        }
        System.out.println("\nRound 1: ");
        this.gamePlay();
    }

    //game logic
    public void gamePlay()
    {
        String input;

        for(Player p: this.players)
        {
            input = " ";
            //System.out.println(p.getName() + ". Hit or stand?");
            while(!input.isEmpty())
            {
                if(p.getPlayerScore() >= 21)
                {
                    break;
                }
                System.out.println("\n" + p.getName() + ". Hit or stand?");
                System.out.println(p);
                input = scan.nextLine();
                if(input.equals("hit"))
                {
                    p.hit(deck.deal());
                    System.out.println(p);
                }
                else
                {
                    break;
                }

            }
        }

        this.getWinners();
    }

    //prints the scores an winner of the round
    public void getWinners()
    {
        String victor = "";
        int topScore =0;
        for(Player p:this.players)
        {
            if((p.getPlayerScore() > topScore) && (p.getPlayerScore() <= 21))
            {
                topScore = p.getPlayerScore();
                victor = p.getName();
            }
        }

        //who beat the dealer
        int dealerScore =0;
        for(Player p:this.players)
        {
            if(p.getName().equals("Dealer"))
            {
                dealerScore = p.getPlayerScore();
            }
        }
        String winners = "";
        for(Player p:this.players)
        {
            if((p.getPlayerScore() > dealerScore) && (p.getPlayerScore() <= 21) || ((p.handSize() == 5) && (p.getPlayerScore() <= 21)))
            {
                winners += p.getName() + "\n";
            }
        }

        System.out.println("\nWho beat the dealer? " + "\n" + winners);

        System.out.println("Winner is: " + victor + " with: " + topScore);

    }

    //test case used to confirm functionality
    public void testCase()
    {
        this.players.add(new Player("Dealer"));
        this.players.add(new Player("Billy"));
        this.players.add(new Player("Andrew"));
        this.players.add(new Player("Carla"));

        for(Player p:this.players)
        {
            switch (p.getName())
            {
                case "Dealer":
                {
                    p.hit(new Card(11,0));
                    p.hit(new Card(7,1));
                    break;
                }
                case "Billy":
                {
                    p.hit(new Card(2,0));
                    p.hit(new Card(2,1));
                    p.hit(new Card(2,2));
                    p.hit(new Card(4, 1));
                    p.hit(new Card(5, 3));
                    break;
                }
                case "Andrew":
                {
                    p.hit(new Card(13,1));
                    p.hit(new Card(4,0));
                    p.hit(new Card(4,3));
                    break;
                }
                case "Carla":
                {
                    p.hit(new Card(12,3));
                    p.hit(new Card(6,0));
                    p.hit(new Card(9,1));
                    break;
                }
            }
        }

        this.getWinners();
    }


}
