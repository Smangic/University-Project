package entity;

import java.util.Scanner;

public class Player {
    private String userName;//demo 中通过ran的随机数生成名字，好改。
    private int score = 0;
    private int mistake = 0;

    Scanner sc = new Scanner(System.in);
    /**
     * 通过特定名字初始化一个玩家对象。
     * @param userName 玩家的名字
     */
    public Player(String userName){
        this.userName = userName;
    }

    /**z
     * 通过默认名字初始化一个玩家对象。
     这个地方好改！！！！！！！！！！！！！！！！！！！！！！！！
     */
    public Player(){
            System.out.print("Please fill in your name: ");
            userName = sc.next();
    }

    /**
     * 为玩家加一分。
     */
    public void addScore(){
        score++;
    }

    /**
     * 为玩家扣一分。
     */
    public void costScore(){
        score--;
    }

    /**
     * 为玩家增加一次失误数。
     */
    public void addMistake() { mistake++; }


    public int getScore(){
        return score;
    }
    public String getUserName(){ return userName; }
    public int getMistake(){ return mistake; }

}
