import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Sudoku {


    public static void main(String args[]) {


        int[][] sudokuTable;

        sudokuTable = new int[9][9];

        String inputPath = "C:/Users/Lukasz/Desktop/Programowanie/sudoku.txt";

        File file = new File(inputPath);

        //Program load sudoku board from a file and print it.

        System.out.println("This is Your sudoku table:");

        try (Scanner scanner = new Scanner(file)) {

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {

                    if (scanner.hasNext()) {

                        sudokuTable[i][j] = scanner.nextInt();

                    } else {

                        throw new IOException("File input error");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                System.out.print((sudokuTable[i][j]) + " ");
            }
            System.out.println();


        }

        boolean answer = sudokuChecker(sudokuTable);

        if (answer) {
            System.out.println("Your sudoku board is correct!!!");
        }
        else {
            System.out.println("Your sudoku board is wrong");
        }




    }


    public static int suma ( int[] numbers){

        int total = 0;

        for (int i = 0; i < numbers.length; i++) {

            total = total + numbers[i];

        }
        return total;

    }

    public static boolean sudokuChecker(int sudokuTab[][]){

        int goodNumbers[] = new int[9];

        int sum = 0;

        int row = 0;

        int col = 0;

        int sortedNumbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};




        for (row = 0; row < sudokuTab.length; row++) {

            for (col = 0; col < sudokuTab.length; col++) {

                goodNumbers[col] = sudokuTab[row][col];

            }

            System.out.println();

            System.out.println(Arrays.toString(goodNumbers));

            Arrays.sort(goodNumbers);

            sum = suma(goodNumbers);

            System.out.println(sum);

            //Program check if numbers in row are not duplicated.

            if (!Arrays.equals(goodNumbers, sortedNumbers)) {


                return false;
            //Program check if sum of numbers in a row equal 45.

            } else if (sum != 45) {


                return false;

            }


        }
        return true;

    }
}