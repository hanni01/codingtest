package com.example.withjava;

import java.util.Scanner;

public class adventure {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0;i < num;i++) {
            arr[i] = sc.nextInt();
        }
        int tmp, cnt = 0;
        while(true){
            for(int i = 0;i < num;i++){
                if(i + 1 == num) break;
                if(arr[i] > arr[i+1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            if(++cnt == num - 1){
                break;
            }
        }
        int human = 0;
        int group = 0;

        for(int i = 0;i < num;i++){
            human += 1;
            if(human >= arr[i]){
                group += 1;
                human = 0;
            }
        }

        System.out.println(group);


    }
}
