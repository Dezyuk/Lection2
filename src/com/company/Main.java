package com.company;

import java.util.Random;

public class Main {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String BLACK = "\u001B[30m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    static int N = 30;
    /**
     * N - размер игрового поля
     */
    public static Random rand = new Random();
    public static void main(String... args) {
        create_array();
    }
    /**
     * Создаем рандомное поле
     */
    public static void create_array() {
        String GRAY = "\u001B[48;5;102m";
        String RESET = "\u001B[0m";
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rand.nextInt(11) != 10) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 9;
                }

            }
        }
        /**
         * Считаем сколько бомб вогруг каждой клетки и присваеваем ей єто значение
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((j + 1) < N && array[i][j + 1] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((j + 1) < N && (i + 1) < N && array[i + 1][j + 1] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((j + 1) < N && (i - 1) >=0 && array[i - 1][j + 1] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((j - 1) >=0 && (i + 1) < N && array[i + 1][j - 1] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((i + 1) < N && array[i + 1][j] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((j - 1) >= 0 && array[i][j - 1] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((i - 1) >= 0 && array[i - 1][j] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
                if ((i - 1) >= 0 && (j - 1) >= 0 && array[i - 1][j - 1] == 9 && array[i][j] != 9) {
                    array[i][j]++;
                }
            }
        }
        /**
         * Отписовываем игровое поле в котором бомбой обозначена *
         */
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
            }
            System.out.print("\n");
            for (int j = 0; j < N; j++) {
                if(array[i][j]==0){
                    System.out.print(GRAY + BLACK+"|¯¯¯" + RESET);
                }
                if(array[i][j]==1){
                    System.out.print(GRAY + BLACK+"|¯"+BLUE +"1"+BLACK+"¯" + RESET);
                }
                if(array[i][j]==2){
                    System.out.print(GRAY + BLACK+"|¯"+GREEN +"2" +BLACK+"¯"+ RESET);
                }
                if(array[i][j]==3){
                    System.out.print(GRAY +BLACK+"|¯"+ RED +"3" +BLACK+"¯"+ RESET);
                }
                if(array[i][j]==4){
                    System.out.print(GRAY + BLACK+"|¯"+PURPLE +"4"+BLACK+"¯"+ RESET);
                }
                if(array[i][j]==5){
                    System.out.print(GRAY + BLACK+"|¯"+ YELLOW +"5"+BLACK+"¯" + RESET);
                }
                if(array[i][j]==6){
                    System.out.print(GRAY + BLACK+"|¯"+ RED +"6" +BLACK+"¯"+ RESET);
                }
                if(array[i][j]==7){
                    System.out.print(GRAY + BLACK+"|¯"+ BLUE +"7" +BLACK+"¯"+ RESET);
                }
                if(array[i][j]==8){
                    System.out.print(GRAY +BLACK+"|¯"+ GREEN +"8" +BLACK+"¯"+ RESET);
                }
                if(array[i][j]==9){
                    System.out.print(GRAY + BLACK + "|¯*¯" + RESET);

                }
            }
            System.out.print(GRAY + BLACK + "|" + RESET);
        }

    }
}
