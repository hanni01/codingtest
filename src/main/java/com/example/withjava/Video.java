package com.example.withjava;

public class Video {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int[] video_arr = { Integer.parseInt(video_len.split(":")[0]), Integer.parseInt(video_len.split(":")[1])};

        int[] pos_arr = {Integer.parseInt(pos.split(":")[0]), Integer.parseInt(pos.split(":")[1])};

        int op_start_time = totalTime(op_start);
        int op_end_time = totalTime(op_end);
        int pos_time = totalTime(pos);

        if(pos_time >= op_start_time && pos_time <= op_end_time){
            pos_arr[0] = Integer.parseInt(op_end.split(":")[0]);
            pos_arr[1] = Integer.parseInt(op_end.split(":")[1]);
        }

        for(String command : commands){
            switch(command){
                case "next":
                    pos_arr[1] += 10;
                    if(pos_arr[1] >= 60){
                        pos_arr[0] += 1;
                        pos_arr[1] -= 60;
                    }
                    break;
                case "prev":
                    pos_arr[1] -= 10;
                    if(pos_arr[1] < 0){
                        pos_arr[0] -= 1;
                        pos_arr[1] += 60;
                    }
                    break;
            }

            if(pos_arr[0] < 0){
                pos_arr[0] = 0;
                pos_arr[1] = 0;
            }

            if((pos_arr[0] > video_arr[0]) || (pos_arr[0] == video_arr[0] && pos_arr[1] >= video_arr[1])){
                pos_arr[0] = video_arr[0];
                pos_arr[1] = video_arr[1];
            }
            int pos_arr_total = (pos_arr[0] * 60) + pos_arr[1];
            if(pos_arr_total >= op_start_time && pos_arr_total <= op_end_time){
                pos_arr[0] = Integer.parseInt(op_end.split(":")[0]);
                pos_arr[1] = Integer.parseInt(op_end.split(":")[1]);
            }
        }

        String minutes = Integer.toString(pos_arr[0]);
        String seconds = Integer.toString(pos_arr[1]);

        if(pos_arr[0] / 10 < 1) minutes = "0"+Integer.toString(pos_arr[0]);
        if(pos_arr[1] / 10 < 1) seconds = "0"+Integer.toString(pos_arr[1]);

        answer = minutes+":"+seconds;

        int testPosInt = totalTime(answer);
        if(testPosInt >= op_start_time && testPosInt <= op_end_time){
            answer = op_end;
        }

        return answer;
    }

    private int totalTime(String time){
        String[] arr = time.split(":");
        int _m = Integer.parseInt(arr[0]);
        int _s = Integer.parseInt(arr[1]);

        int time_total = (_m * 60) + _s;

        return time_total;
    }
}
