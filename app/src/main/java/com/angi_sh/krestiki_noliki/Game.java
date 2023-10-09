package com.angi_sh.krestiki_noliki;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
    public Game(){
//        this.arr = arr;
    }
    public boolean goPlayer1(int x, int y){
        //when игрок выбирает клетку.
        //And игрок выбирает пустую клетку.
        if (this.arr[y][x] == 0) {
            //Then отмечаем ход на поле.
            this.arr[y][x] = 1;
            return true;
        }
        return false;
    }
    public boolean goPlayer2(int x, int y){
        //when игрок выбирает клетку.
        //And игрок выбирает пустую клетку.
        if (this.arr[y][x] == 0) {
            //Then отмечаем ход на поле.
            this.arr[y][x] = 2;
            return true;
        }
        return false;
    }
    //get pole
    public int[][] getPole(){
        return this.arr;
    }
    public int win(){
        //игрок1 выигрывает.
        if (this.winPlayer1())
            return 1;
        //игрок2 выигрывает.
        if (this.winPlayer2())
            return 2;
            //And игрок1 не выигрывает.
            //And игрок2 не выигрывает.
        else return 0;
    }
    public boolean checkDraw(){
        // игрок выбирает последнюю пустую клетку.
        int s=0;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                s+=this.arr[i][j];
            }
        }
        if (s == 13) return false;
        else return true;
    }
    private boolean winPlayer1(){
        Boolean flag = false;
        //1 диагональ
        if((arr[1][1]==1) && (arr[0][0]==1) && (arr[2][2]==1)) flag = true;
        else {
            //2 диагональ
            if((arr[1][1]==1) && (arr[0][2]==1) && (arr[2][0]==1)) flag = true;
            else{
                for (int i=0;i<3;i++){
                    if((arr[i][0] == arr[i][1]) &&  (arr[i][1] == arr[i][2]) && (arr[i][2] == 1)) flag = true;
                    if((arr[0][i] == arr[1][i]) &&  (arr[1][i] == arr[2][i]) && (arr[2][i] == 1)) flag = true;
                }
            }
        }
        return flag;
    }
    private boolean winPlayer2(){
        Boolean flag = false;
        //1 диагональ
        if((arr[1][1]==2) && (arr[0][0]==2) && (arr[2][2]==2)) flag = true;
        else {
            //2 диагональ
            if((arr[1][1]==2) && (arr[0][2]==2) && (arr[2][0]==2)) flag = true;
            else{
                for (int i=0;i<3;i++){
                    if((arr[i][0] == arr[i][1]) &&  (arr[i][1] == arr[i][2]) && (arr[i][2] == 2)) flag = true;
                    if((arr[0][i] == arr[1][i]) &&  (arr[1][i] == arr[2][i]) && (arr[2][i] == 2)) flag = true;
                }
            }
        }
        return flag;
    }

}
