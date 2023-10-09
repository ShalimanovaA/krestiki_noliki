package com.angi_sh.krestiki_noliki;

import junit.framework.TestCase;

public class GameTest extends TestCase {

    public void testGoPlayer1() {
        Game game = new Game();
        game.goPlayer1(1,1);
        game.goPlayer1(0,2);
        int[][] arr = game.getPole();
        System.out.println("Первый игрок");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void testGoPlayer2() {
        Game game = new Game();
        game.goPlayer2(0,0);
        game.goPlayer2(1,2);
        int[][] arr = game.getPole();
        System.out.println("Второй игрок");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void testGoPlayers() {
        Game game = new Game();
        game.goPlayer1(0,0);
        game.goPlayer2(1,2);
        game.goPlayer1(0,1);
        game.goPlayer2(1,0);
        int[][] arr = game.getPole();
        System.out.println("Оба игрока");
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void testGetArr() {
        System.out.println("Тестирование вывода");
        Game game = new Game();
        int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
        arr = game.getPole();
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void testWin() {
        Game game = new Game();
        game.goPlayer1(0,0);
        game.goPlayer2(2,2);
        game.goPlayer1(0,1);
        game.goPlayer2(1,0);
        game.goPlayer1(0,2);
        if(game.win() == 1) System.out.println("Выиграл 1");
        else System.out.println("Выиграл 2");
    }
    //ход
    public void testScenario1(){
        Game game = new Game();
        int[][] arr = game.getPole();
        // Given поле для хода игрока
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        //when игрок выбирает клетку.
        //And игрок выбирает пустую клетку.
        //Then отмечаем ход на поле.
        if(game.goPlayer1(0,0)){
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
    //победа
    public void testScenario2(){
        // Given поле для хода игрока
        Game game = new Game();
        //when игрок выбирает клетку.
        //And игрок выбирает пустую клетку.
        //Then отмечаем ход на поле.
        if(game.goPlayer1(0,0)){
            if(game.goPlayer1(1,1)){
                if(game.goPlayer1(2,2))
                    //And игрок поставил свои 3 фигуры в ряд.
                    if(game.win()==1) System.out.println("Выиграл 1 игрок");
                //Then игрок выигрывает.
            }
        }
    }

    //ничья
    public void testScenario3(){
        // Given поле для хода игрока
        Game game = new Game();
        //when игрок выбирает клетку.
        //And игрок выбирает пустую клетку.
        if(game.goPlayer1(0,0)){
            if(game.goPlayer2(1,1)){
                if(game.goPlayer1(2,2)){
                    if(game.goPlayer2(2,0)){
                        if(game.goPlayer1(0,2)){
                            if(game.goPlayer2(1,2)){
                                if(game.goPlayer1(1,0)){
                                    if(game.goPlayer2(0,1)){
                                        if(game.goPlayer1(2,1)){
                                            //And игрок1 не выигрывает.
                                            //And игрок2 не выигрывает.
                                            //And игрок выбирает последнюю пустую клетку.
                                            if((game.win()==0) && (!game.checkDraw())){
                                                int[][] arr = game.getPole();
                                                //Then ничья.
                                                for (int i=0;i<3;i++){
                                                    for (int j=0;j<3;j++){
                                                        System.out.print(arr[i][j]);
                                                    }
                                                    System.out.println();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}