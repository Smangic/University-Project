package entity;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String userName;//demo 中通过ran的随机数生成名字，好改。
    private int p1score = 0;
    private int p2score = 0;
    private int p1mistake = 0;
    private int p2mistake = 0;


    Scanner sc = new Scanner(System.in);

    /**
     * 通过特定名字初始化一个玩家对象。
     *
     * @param userName 玩家的名字
     */
    public Player(String userName) {
        this.userName = userName;
    }

    /**
     * z
     * 通过默认名字初始化一个玩家对象。
     * 这个地方好改！！！！！！！！！！！！！！！！！！！！！！！！
     */
    public Player() {
        //System.out.print("Please fill in your name: ");
    }

    /**
     * 为玩家加一分。
     */
    public void addp1Score() {
        p1score++;
    }

    public void addp2Score() {
        p2score++;
    }

    /**
     * 为玩家扣一分。
     */
    public void costp1Score() {
        p1score--;
    }

    public void costp2Score() {
        p2score--;
    }

    /**
     * 为玩家增加一次失误数。
     */
    public void addp1mistake() {
        p1mistake++;
    }

    public void addp2mistake() {
        p2mistake++;
    }


    public int getP1score() {
        return p1score;
    }


    public int getP2score() {
        return p2score;

    }


    public String getUserName() {
        return userName;
    }


    public int getP1Mistake() {
        return p1mistake;
    }


    public void setP1mistake(int p1mistake) {
        this.p1mistake = p1mistake;
    }


    public int getP2Mistake() {
        return p2mistake;
    }

    public void setP2mistake(int p2mistake) {
        this.p2mistake = p2mistake;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
