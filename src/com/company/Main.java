package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map letterMap = new HashMap<String, Integer>();

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "_"};

        Integer[] values = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};


        //Creates HashMap for referencing alphabet to values.
        for (int i = 0; i < alphabet.length; i++){
            letterMap.put(alphabet[i], values[i]);
        }

        System.out.println("Please enter your current tiles:");
        String input = in.next();

        input = input.toUpperCase();


        //Decrement each value within the user's input
        for (int i = 0; i < input.length(); i++) {
            String letter = String.valueOf(input.charAt(i));
            Object value = letterMap.get(letter);

            letterMap.replace(letter, ((Integer) value) - 1);

        }
        //The remainingCount label allows us to quit the remaining tiles printout should an invalid number of letters be selected
        remainingCount:
        for (int i = 12; i >= 0; i --){

            boolean exists = false;

            String remainTiles = i + ": ";


            Iterator iterate = letterMap.entrySet().iterator();

            while (iterate.hasNext()){
                Map.Entry current = (Map.Entry)iterate.next();
                if (i == (Integer) current.getValue()){
                    remainTiles += current.getKey().toString() + ", ";

                    exists = true;

                } else if ((Integer) current.getValue() < 0) {
                    System.out.println("Invalid Input.  More " + current.getKey().toString() + "'s have been taken from the bag than possible.");
                    break remainingCount;
                }

            }

            //Only prints output if a letter exists with the associated value.  Removes 2 spaces at the end to remove trailing comma.
            if (exists) {
                System.out.println(remainTiles.substring(0, remainTiles.length() - 2));
            }
        }



    }
}
