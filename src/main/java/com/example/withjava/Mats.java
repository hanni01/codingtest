package com.example.withjava;

public class Mats {
    class Solution {
        public int solution(int[] mats, String[][] park) {
            int answer = 0;
            boolean success = true;

            for(int mat = 0;mat < mats.length;mat++){
                for(int i = 0;i < park.length;i++){
                    for(int j = 0;j < park[0].length;j++){
                        if(park[i][j].equals("-1")){
                            System.out.println("park"+i+", "+j);
                            success = true;

                            loop:
                            for(int sizeh = 0;sizeh < mats[mat];sizeh++){
                                for(int size = 0;size < mats[mat];size++){
                                    if(i+sizeh >= park.length || j+size >= park[0].length){
                                        success = false;
                                        break loop;
                                    }
                                    if(!park[i+sizeh][j+size].equals("-1")) {
                                        success = false;
                                        break loop;
                                    }
                                }
                            }
                            if(success == true){
                                if(answer < mats[mat]) answer = mats[mat];
                            }
                        }else{
                            success = false;
                        }
                    }
                }
            }

            if(answer == 0) answer = -1;
            return answer;
        }
    }
}
