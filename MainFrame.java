package minesweeper;


import components.GridComponent;
import components.Starter;
import controller.GameController;
import entity.Player;

import javax.swing.*;
import java.util.Scanner;

public class MainFrame extends JFrame {
    public static GameController controller;
    public static int xCount;
    public static int yCount;
    public static int mineCount;


    public MainFrame() {
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
//        Scanner input = new Scanner(System.in);
//        System.out.print("Please enter the number of row: ");
//        this.xCount = input.nextInt();//grid of row
//        System.out.print("Please enter the number of column: ");
//        this.yCount = input.nextInt();// grid of column
//        System.out.print("Please enter the number of mine: ");
//        mineCount = input.nextInt();// mine count

        this.setTitle("扫雷英雄！！！！！");
        this.setLayout(null);
        this.setSize(yCount * GridComponent.gridSize + 400, xCount * GridComponent.gridSize + 200);
        this.setLocation((cn.itcast.util.ScreenUtils.getScreenWidth()-(yCount * GridComponent.gridSize + 400))/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-(xCount * GridComponent.gridSize + 200))/2);

        Player p1 = Starter.player1;
        Player p2 = Starter.player2;

        controller = new GameController(p1, p2);
        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount);
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard(p1, p2, xCount, yCount);
        controller.setScoreBoard(scoreBoard);

        this.add(gamePanel);
        this.add(scoreBoard);


        JButton clickBtn = new JButton("Click");
        clickBtn.setSize(80, 20);
        clickBtn.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn);
        clickBtn.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "input here");
            System.out.println("fileName :"+fileName);

//            controller.readFileData(fileName);
//            controller.writeDataToFile(fileName);
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public int getMineCount() {
        return mineCount;
    }
}
