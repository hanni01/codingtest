package com.example.withjava;
import java.util.Arrays;
public class MostReceiveGift {
    public int solution(String[] friends, String[] gifts) {
        int answer;
        String giver;
        String getter;
        int[][] logs = new int[friends.length][friends.length];
        int[] nextMonth = new int[friends.length];

        for (String gift : gifts) {
            String[] data = gift.split(" ");
            giver = data[0];
            getter = data[1];

            logs[Arrays.asList(friends).indexOf(giver)][Arrays.asList(friends).indexOf(getter)]++;
        }

        for(int i = 0;i < friends.length;i++){
            for(int j = i+1;j < friends.length;j++){
                if(logs[i][j] != logs[j][i]){
                    if(logs[i][j] > logs[j][i]){
                        nextMonth[i]++;
                    }else if(logs[i][j] < logs[j][i]){
                        nextMonth[j]++;
                    }
                }
                else{
                    int f1giveSum = Arrays.stream(logs[i]).sum();
                    int f1getSum = 0;

                    for (int[] log : logs) {
                        f1getSum += log[i];
                    }
                    int f1total = f1giveSum - f1getSum;

                    int f2giveSum = Arrays.stream(logs[j]).sum();
                    int f2getSum = 0;

                    for (int[] log : logs) {
                        f2getSum += log[j];
                    }
                    int f2total = f2giveSum - f2getSum;

                    if(f1total > f2total){
                        nextMonth[i]++;
                    }else if(f2total > f1total){
                        nextMonth[j]++;
                    }
                }
            }
        }

        answer = Arrays.stream(nextMonth).max().getAsInt();

        return answer;
    }
}
