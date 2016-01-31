/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banknotesandcoins;

import java.util.Scanner;

/**
 *
 * @author lefty
 */
public class BankNotesAndCoins {

    /**
     * @param args the command line arguments
     */
    public static int[] NotesAndCoins(int[] notes_and_coins) {

        int index = notes_and_coins[0];
        int sum = notes_and_coins[1];
        int banknote = notes_and_coins[index];
        int counter = notes_and_coins[index + 1];
        int array_size = notes_and_coins.length - 2;

//        System.out.println("index: "+index);
//        System.out.println("sum: "+sum);
//        System.out.println("array size: "+array_size);
//        System.out.println("----------------");
//        System.out.println("");
        if (index == array_size || sum == 0) {
            return notes_and_coins;
        } else {
            counter = (int) sum / banknote;
            notes_and_coins[index + 1] = counter;

            int remainder = sum % banknote;
            notes_and_coins[1] = remainder;

            index = index + 2;
            notes_and_coins[0] = index;

            NotesAndCoins(notes_and_coins);
        }

        return notes_and_coins;
    }

    public static void DenominationPrinter(int[] notes_and_coins) {
        for (int i = 2; i < notes_and_coins.length - 1; i = i + 2) {
            System.out.print("Denomination: " + notes_and_coins[i]);
            System.out.println(" - Number of notes to be issued: " + notes_and_coins[i + 1]);

        }
        if (notes_and_coins[1] > 0) {
            System.out.println("Remainder: " + notes_and_coins[1]);
        }
    }

    public static int HowMuchCash() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How much cash do you need:");
        int cash = keyboard.nextInt();

        return cash;
    }

    public static void main(String[] args) {
        int sum = HowMuchCash();
        int index = 2; // banknote denominations start here; [0] is used as index [1] as sum store
        int[] notes_and_coins = {index, sum, 20000, 0, 10000, 0, 5000, 0, 2000, 0, 1000, 0, 500, 0};

        NotesAndCoins(notes_and_coins);
        DenominationPrinter(notes_and_coins);

    }

}
