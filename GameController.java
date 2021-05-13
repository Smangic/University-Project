package controller;

import minesweeper.GamePanel;
import entity.Player;
import minesweeper.MainFrame;
import minesweeper.ScoreBoard;

import javax.swing.*;
import java.util.Scanner;


public class GameController {

    private Player p1;
    private Player p2;

    private Player onTurn;

    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;

    private int numberOfLandmineBoom = 0;
    private int numberOfLandmineFlag = 0;


    Scanner sc = new Scanner(System.in);
    int times = 0;
    int click = 0;

    public GameController(Player p1, Player p2) {
        this.init(p1, p2);
        this.onTurn = p1;
    }

    /**
     * 初始化游戏。在开始游戏前，应先调用此方法，给予游戏必要的参数。
     *
     * @param p1 玩家1
     * @param p2 玩家2
     */
    public void init(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.onTurn = p1;


        System.out.println("Please enter a number to determine how many times(1-5) a player can click in one turn:");//用来表示一个人可以走多少步
        times = sc.nextInt();
        //TODO: 在初始化游戏的时候，还需要做什么？
    }

    /**
     * 进行下一个回合时应调用本方法。
     * 在这里执行每个回合结束时需要进行的操作。
     * <p>
     * (目前这里没有每个玩家进行n回合的计数机制的，请自行修改完成哦~）
     */
    public void nextTurn() {
        JOptionPane jOptionPane = new JOptionPane();

        if (onTurn == p1 && click == times) {
            onTurn = p2;
        } else if (onTurn == p2 && click == times) {
            onTurn = p1;
        }


        System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
        if (p1.getP1score() != p2.getP2score()) {
            if (Math.abs(p1.getP1score()) - p2.getP2score() > MainFrame.mineCount - getNumberOfLandmineBoom() - getNumberOfLandmineFlag()) {
                if (p1.getP1score() > p2.getP2score()) {
                    String winner = new String(p1.getUserName());
                    JOptionPane.showMessageDialog(null, "The winner is " + winner, "Game Over", JOptionPane.PLAIN_MESSAGE);
//P1 win the game
                } else if (p1.getP1score() < p2.getP2score()) {
                    String winner = new String(p2.getUserName());
                    JOptionPane.showMessageDialog(null, "The winner is " + winner, "Game Over", JOptionPane.PLAIN_MESSAGE);
                }
//P2 win the game
            }
        }

        else if (MainFrame.mineCount == getNumberOfLandmineBoom() + getNumberOfLandmineFlag()) {
            if (p1.getP1Mistake() < p2.getP2Mistake()) {
                String winner = new String(p1.getUserName());
                JOptionPane.showMessageDialog(null, "The winner is " + winner, "Game Over", JOptionPane.PLAIN_MESSAGE);
//P1 win the game
            } else if (p1.getP1Mistake() > p2.getP2Mistake()) {
                String winner = new String(p2.getUserName());
                JOptionPane.showMessageDialog(null, "The winner is " + winner, "Game Over", JOptionPane.PLAIN_MESSAGE);
//P2 win the game
            } else if (p1.getP1Mistake() == p2.getP2Mistake()) {
                JOptionPane.showMessageDialog(null, "A Dead Heat", "Game Over", JOptionPane.PLAIN_MESSAGE);
//平局(A Dead Heat)
            }
        }


        //TODO: 在每个回合结束的时候，还需要做什么 (例如...检查游戏是否结束？)

    }


    /**
     * 获取正在进行当前回合的玩家。
     *
     * @return 正在进行当前回合的玩家
     */
    public Player getOnTurnPlayer() {
        return onTurn;
    }


    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }


    //将玩家与棋盘绑定
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }


    public void readFileData(String fileName) {
        //todo: read date from file

    }

    public void writeDataToFile(String fileName) {
        //todo: write data into file
    }

    public void addClick() {
        click++;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getClick() {
        return click;
    }

    public int getTimes() {
        return times;
    }

    public void addNumberOfLandmineFlag() {
        numberOfLandmineFlag++;
    }

    public void addNumberOfLandmineBoom() {
        numberOfLandmineBoom++;
    }

    public int getNumberOfLandmineBoom() {
        return numberOfLandmineBoom;
    }

    public int getNumberOfLandmineFlag() {
        return numberOfLandmineFlag;
    }

}
