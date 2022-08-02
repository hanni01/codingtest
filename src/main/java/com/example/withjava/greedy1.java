package com.example.withjava;

import java.util.Scanner;

public class greedy1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = (sc.next()).split("");

        int result = Integer.parseInt(s[0]);
        for(int i = 1;i < s.length;i++){
            if(result == 0 || result == 1){
                result += Integer.parseInt(s[i]);
            }else{
                result *= Integer.parseInt(s[i]);
            }
        }

        System.out.println(result);
    }
}