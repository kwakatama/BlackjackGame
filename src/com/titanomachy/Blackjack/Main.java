package com.titanomachy.Blackjack;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);


        TextUI ui = new TextUI(scan);
        //UI start used in active dynamic gameplay
        //ui.start();

        //test case game
        ui.testCase();
    }
}
