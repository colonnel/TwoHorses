package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n = 8; //quantity cells in chessboard
    static int[][] boardG = new int[n][n];
    static int[][] boardR = new int[n][n];

    public static void main(String[] args) throws IOException {
        System.out.println("Input coordinate for GreenHorse:");
        input(boardG);
        System.out.println("Input coordinate for RedHorse:");
        input(boardR);
        int count = 0;
        boolean result = false;

        for (int i = 1; i < 1000; i++) {
            if (result == false) {
                boardG = turns(boardG);
                boardR = turns(boardR);
                result = check(boardG, boardR);
                count = i;
            }
        }
        if (result == true) {
            System.out.println("Quantity of turns is: " + count);
        } else {
            System.out.println("Impossible!");
        }


    }

    /**
     * Method checks possible combinations
     * @param array
     * @return
     */
    private static int[][] turns(int array[][]) {
        int[][] tmp = new int[n][n];
        int newRow;
        int newCol;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    //up and right
                    newRow = i - 2;
                    newCol = j + 1;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // up and left
                    newRow = i - 2;
                    newCol = j - 1;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // down and left
                    newRow = i + 2;
                    newCol = j - 1;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // down and right
                    newRow = i + 2;
                    newCol = j + 1;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // left and up
                    newRow = i - 1;
                    newCol = j - 2;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // left and down
                    newRow = i + 1;
                    newCol = j - 2;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // right and up
                    newRow = i - 1;
                    newCol = j + 2;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                    // right and down
                    newRow = i + 1;
                    newCol = j + 2;
                    if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                        tmp[newRow][newCol] = 1;
                    }
                }

            }

        }
        return tmp;

    }

    private static boolean check(int arrayGreen[][], int arrayRed[][]) {
        boolean match = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arrayGreen[i][j] == arrayRed[i][j] && arrayGreen[i][j] == 1) {
                    match = true;
                }
            }
        }
        return match;
    }

    /**
     * Method takes a position of figure entered from keyboard
     * @param array
     * @return board with position o figure
     * @throws IOException
     */
    private static int[][] input(int array[][]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String coordinate = reader.readLine();
        char xChar = coordinate.charAt(0);
        int x = convert(xChar);
        int y = Integer.parseInt(String.valueOf(coordinate.charAt(1))) - 1;
        array[x][y] = 1;
        return array;
    }

    /**
     * Method converts a letter from position
     * @param xChar
     * @return index in array
     */
    private static int convert(char xChar) {
        int intX = 0;
        switch (xChar) {
            case 'a':
                intX = 1;
                break;
            case 'b':
                intX = 2;
                break;
            case 'c':
                intX = 3;
                break;
            case 'd':
                intX = 4;
                break;
            case 'e':
                intX = 5;
                break;
            case 'f':
                intX = 6;
                break;
            case 'g':
                intX = 7;
                break;
            case 'h':
                intX = 8;
                break;
        }
        return intX - 1;
    }
}
