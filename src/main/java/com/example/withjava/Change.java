package com.example.withjava;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int change = sc.nextInt();
        int five, two = 0;

        if((change / 5) > 0){
            if((change % 5) % 2 == 0){
                five = change / 5;
                change %= 5;
                two = change / 2;

                System.out.println(five+two);
            }else{
                five = (change / 5) - 1;
                change -= five*5;
                two = change / 2;

                System.out.println(five+two);
            }
        }else{
            if(change % 2 == 0){
                two = change / 2;

                System.out.println(two);
            }else{
                System.out.println(-1);
            }
        }
    }
}
