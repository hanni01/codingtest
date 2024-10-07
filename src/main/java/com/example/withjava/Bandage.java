package com.example.withjava;

public class Bandage {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int answer = 0;

            int skillTime = bandage[0];
            int heal = bandage[1];
            int addHeal = bandage[2];

            int maxHealth = health;
            int continousHeal = 0;
            int idx = 0;

            for(int i = 1;i <= attacks[attacks.length-1][0];i++){

                continousHeal++;

                if(attacks[idx][0] == i){
                    health -= attacks[idx][1];
                    if(health <= 0){
                        answer = -1;
                        return answer;
                    }
                    idx++;
                    continousHeal = 0;
                }else{
                    health = AddHealth(health, heal, maxHealth);
                }

                if(continousHeal >= skillTime) {
                    health = AddHealth(health, addHeal, maxHealth);
                    continousHeal = 0;
                }

            }

            answer = health;

            return answer;
        }

        public int AddHealth(int health, int heal, int maxH){
            health += heal;
            if(health >= maxH) health = maxH;

            return health;
        }
    }
}
