package com.petrocompany;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //  twoSum(new int[] {3,2,3}, 6);
        //  runningSum(new int[] {3,1,2,10,1});
        //guessNumber();
        guessWord();
    }

    public static void guessWord(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int countX = 15, ind = r.nextInt(words.length-1);
        char blank = '#';
        String output = "", userWord = "";
        System.out.println(words[ind]);
        do{
            for (int i = output.length(); i < countX; i++) {
                output = output + blank;
            }
            System.out.println("The word is hidden. Try to guess. If you input several words the first one will be the answer.");
            System.out.println(output);
            userWord = sc.next();
            output = "";
            for (int i = 0; (i < userWord.length()) && (i < words[ind].length()); i++) {
                if (userWord.charAt(i) == words[ind].charAt(i)){
                    output = output + userWord.charAt(i);
                }
                else {
                    output = output + blank;
                }
            }
        }while (userWord.equals(words[ind]) == false);
        System.out.println("The game is over. The word guessed.");
    }

    public static void guessNumber() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int min = 0, max = 9, numToGuess = r.nextInt(max), countTry = 3;
        String message = "Введите число от " + min + " до " + max;
        int numFromUser;
        for (int i = 0; i <= countTry; i++) {
            if (i == countTry) {
                int input;
                do {
                    System.out.println("У вас не осталось попыток, игра окончена. Повторить игру еще раз? Да - нажмите 1. Нет - Нажмите 0.");
                    input = sc.nextInt();
                    switch (input) {
                        case 1:
                            i = -1;
                            numToGuess = r.nextInt(max);
                            break;
                        case 0:
                            System.out.println("Счастливого пути!");
                            break;
                        default:
                            break;
                    }
                } while (input != 0 && input != 1);
                continue;
            }
            System.out.println(message);
            numFromUser = sc.nextInt();
            if (numFromUser < min || numFromUser > max) {
                System.out.println("Введенное значение выходит за пределы допустимого диапазона!");
                continue;
            } else {
                if (numFromUser < numToGuess) {
                    System.out.println("Введенное значение меньше загаданного.");
                    continue;
                }
                if (numFromUser > numToGuess) {
                    System.out.println("Введенное значение больше загаданного.");
                    continue;
                }
                if (numFromUser == numToGuess) {
                    System.out.println("Поздравляем! Вы отгадали!");
                    break;
                }
            }
        }
    }
    public static int getNumFromScanner(String message, int min, int max, int countTry) {
        Scanner sc = new Scanner(System.in);
        int num, i = 0;
        do {
            System.out.println(message);
            num = sc.nextInt();
            if (i < countTry) {
                i++;
            }
            else
            {
                return -1;
            }
        } while (num < min || num > max);
        return num;
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = sum + nums[i];
            sum = result[i];
        }
        return result;

    }

    public static int[] twoSum(int[] numbs, int target){
        System.out.println("Input: " + Arrays.toString(numbs) + ", target = " + target);
        int[] out = new int[] {0,0};
        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numbs.length; j++) {
                if (i != j) {
                    if (numbs[i] + numbs[j] == target) {
                        out = new int[] {i, j};
                        System.out.println("Output: " + Arrays.toString(out));
                        return out;
                    }
                }
            }
        }
        if (out[0] == 0 && out[1] == 0){
            System.out.println("No such numbers. Returned default value: [0,0]");
        }
        return out;
    }

}
