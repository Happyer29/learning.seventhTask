package ru.vsu.cs.yagodintsevNikitaAndreevich;

import java.util.*;
import java.util.Scanner;
import ru.vsu.cs.yagodintsevNikitaAndreevich.*;


public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        ru.vsu.cs.util.ArrayUtils arrayUtils = new ru.vsu.cs.util.ArrayUtils();

        int[] test1 = {1, 2, -2, 1, 10, 3, 105, 4, -5, 4, 10, 1, 1, 3, 4, 7, 12, 10 };
        test(test1);

        int[] test2 = {0, 0, 0, 0, 0, 0, 0};
        test(test2);

        int[] test3 = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 0};
        test(test3);

        int[] test4 = {3, 1, 5, 4, 5, 0};
        test(test4);

        int[] test5 = { 0, 2, 1, 0, 0};
        test(test5);




        int[] numbers = arrayUtils.readIntArrayFromConsole("numbers");
        String[] res = solution(numbers);

        System.out.println("Haystack:  " + res[0] + "\n\n");
        System.out.println("Максимальная длина элементов: " + res[1]);
    }

    public static void test(int[] numbers) {
        String arrStr = ru.vsu.cs.util.ArrayUtils.toString(numbers);
        System.out.println("Тест: " + arrStr);
        String[] res = solution(numbers);

        System.out.println("Haystack:  " + res[0]);
        System.out.println("Максимальная длина элементов: " + res[1] + "\n\n");
    }

    public static String[] solution(int[] numbers){

        //numbers = {1, 2, -2, 1, 10, 3, 105, 4, -5, 4, 10, 1, 1, 3, 4, 7, 12, 10 };
        String maxLine = "";
        int maxLength = 0;
        String tmpLine = "";
        int tmpLength = 0;

        int tmpRemain = 0;

        for(int i = 0; i <= numbers.length - 1; i++){
            //после рефакторинга
            if(tmpLength == 0){
                tmpRemain = Math.abs(numbers[i]) % 2 == 0 ? 0 : 1;
            }

            if(Math.abs(numbers[i]) % 2 == tmpRemain) {
                tmpRemain = Math.abs(tmpRemain - 1);
                tmpLine += " " + numbers[i];
                tmpLength += 1;
            }
            else{
                tmpLength = 1;
                tmpRemain = Math.abs(numbers[i]) % 2 == 1 ? 0 : 1;
                tmpLine = "" + numbers[i];
            }

            if(maxLength <= tmpLength){
                maxLength = tmpLength;
                maxLine = tmpLine;
            }


            //до рефакторинга
//            if(tmpLength == 0){
//                tmpLength += 1;
//                tmpRemain = Math.abs(numbers[i]) % 2 == 0 ? 1 : 0;
//                tmpLine += numbers[i];
//            }
//            else{
//                if(Math.abs(numbers[i]) % 2 == tmpRemain) {
//                    tmpRemain = Math.abs(tmpRemain - 1);
//                    tmpLine += " " + numbers[i];
//                    tmpLength += 1;
//                    if(maxLength <= tmpLength){
//                        maxLength = tmpLength;
//                        maxLine = tmpLine;
//                    }
//                }
//                else{
//                    if(maxLength <= tmpLength){
//                        maxLength = tmpLength;
//                        maxLine = tmpLine;
//                    }
//                    tmpLength = 0;
//                    tmpLine = "";
//
//                    tmpLength += 1;
//                    tmpRemain = Math.abs(numbers[i]) % 2 == 0 ? 1 : 0;
//                    tmpLine += numbers[i];
//                }
//            }

        }
        return new String[]{maxLine, Integer.toString(maxLength)};
    }
}
