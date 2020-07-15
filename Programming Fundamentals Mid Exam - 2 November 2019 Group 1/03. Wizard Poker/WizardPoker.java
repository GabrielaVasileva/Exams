package com.company;

import java.util.*;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> Deck = new ArrayList<>(Arrays.asList(scanner.nextLine().split(":")));

        List<String> deck = new ArrayList<>();

        String Command;
        while (!("Ready".equals(Command = scanner.nextLine()))) {
            String commands[] = Command.split(" ");

            switch (commands[0]){
                case "Add":
                    if(Deck.contains( commands[1])){
                        deck.add( commands[1]);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);
//                    Insert {card name} {index}
                    if(!Deck.contains( commands[1]) && ! (index >= Deck.size())){
                        System.out.println("Error!");

                    }else {
                        deck.remove( commands[1]);
                        deck.add(index, commands[1]);
                    }
                    break;
                case "Remove":
                    if(deck.contains( commands[1])){
                        deck.remove( commands[1]);
                    }else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String cardName1 = commands[1];
                    String cardName2 = commands[2];

                    Collections.swap(deck,deck.indexOf(cardName1),deck.indexOf(cardName2));

                    break;
                 case "Shuffle":
                     Collections.reverse(deck);
                     break;
            }
        }

        for (int i = 0; i < deck.size(); i++) {
            System.out.print(deck.get(i)+" ");
        }

    }
}
