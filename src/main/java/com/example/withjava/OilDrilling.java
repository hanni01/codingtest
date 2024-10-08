package com.example.withjava;

import java.util.*;

public class OilDrilling {
    class Solution {

        int n, m;
        int[] oil;

        public int solution(int[][] land) {
            int answer = 0;

            n = land.length;
            m = land[0].length;
            oil = new int[m];

            boolean[][] visited = new boolean[n][m];

            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    if (land[i][j] == 1 && visited[i][j] == false) {
                        bfs(land, visited, i, j);
                    }
                }
            }

            answer = Arrays.stream(oil).max().getAsInt();

            return answer;
        }

        public void bfs(int[][] land, boolean[][] visited, int x, int y){
            visited[x][y] = true;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x, y});

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int cnt = 1;
            Set<Integer> set = new HashSet<>();

            while(!q.isEmpty()){
                int[] current = q.poll();
                set.add(current[1]);

                for(int i = 0;i < 4;i++){
                    int nx = current[0] + dx[i];
                    int ny = current[1] + dy[i];

                    if(!isValidLandSize(nx, ny)) continue;

                    if(land[nx][ny] == 1 && visited[nx][ny] == false){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        cnt += 1;
                    }
                }
            }

            for (int index : set){
                oil[index] += cnt;
            }
        }

        public boolean isValidLandSize(int x, int y){
            if(x < 0 || x >= n || y < 0 || y >= m){
                return false;
            }
            return true;
        }
    }
}
