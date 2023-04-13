package com.superior.test;

import java.util.ArrayList;
import java.util.Collections;

public class PokerTest {

    public static void main(String[] args) {

        //1.组成一副扑克牌
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] color = {"方块♦", "梅花♣", "红桃♥", "黑桃♠"};

        ArrayList poker = new ArrayList();

        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < num.length; j++) {
                poker.add(color[i] + " " + num[j]);
            }
        }

        poker.add("大王");
        poker.add("小王");

        //2.洗牌
        Collections.shuffle(poker);

        //3.发牌,创建三个角色和底牌对应的ArrayList
        ArrayList player1 = new ArrayList();
        ArrayList player2 = new ArrayList();
        ArrayList player3 = new ArrayList();

        ArrayList lastCard = new ArrayList();

        for (int i = 0; i < poker.size(); i++) {

            if (i >= poker.size() - 3) {
                lastCard.add(poker.get(i));
            } else if (i % 3 == 0) {
                player1.add(poker.get(i));
            } else if (i % 3 == 1) {
                player2.add(poker.get(i));
            } else if (i % 3 == 2) {
                player3.add(poker.get(i));
            }

        }

        System.out.println("player1 : " + player1);
        System.out.println("player2 : " + player2);
        System.out.println("player3 : " + player3);
        System.out.println("底牌 : " + lastCard);

    }

}
