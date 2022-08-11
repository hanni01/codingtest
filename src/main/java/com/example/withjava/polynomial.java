package com.example.withjava;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//폴리오미노
public class polynomial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] board = input.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        int xnum = 0;

        for(int i = 0;i < board.length;i++){
            if(Objects.equals(board[i], 'X')){
                xnum++;
                continue;
            }else{
                if(xnum == 0){
                    if(Objects.equals(board[i], '.')){
                        result.add(".");
                    }
                    continue;
                }
                if(xnum % 2 != 0){
                    break;
                }else{
                    if(xnum % 4 == 2){
                        if(xnum == 2){
                            result.add("BB");
                        }else{
                            int Anum = xnum / 4;
                            for(int j = 1;j <= Anum;j++){
                                result.add("AAAA");
                            }
                            result.add("BB");
                        }
                    }else if(xnum % 4 == 0){
                        int Anum = xnum / 4;
                        for(int j = 1;j <= Anum;j++){
                            result.add("AAAA");
                        }
                    }
                    result.add(".");
                    xnum = 0;
                }
            }
        }
        if(xnum % 2 != 0){
            System.out.println(-1);
        }else{
            if(xnum % 4 == 2){
                if(xnum == 2){
                    result.add("BB");
                }else{
                    int Anum = xnum / 4;
                    for(int j = 1;j <= Anum;j++){
                        result.add("AAAA");
                    }
                    result.add("BB");
                }
            }else if(xnum % 4 == 0){
                int Anum = xnum / 4;
                for(int j = 1;j <= Anum;j++){
                    result.add("AAAA");
                }
            }
            for(String element: result){
                System.out.print(element);
            }
        }
        System.out.println();
    }
}
