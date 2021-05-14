package components;

import entity.Player;
import minesweeper.MainFrame;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Starter extends JPanel {

    public static Player player1 = new Player();
    public static Player player2 = new Player();

//    public Player getPlayer1() {
//        return player1;
//    }
//
//    public Player getPlayer2() {
//        return player2;
//    }

    JFrame frame = new JFrame("扫雷");
    Box vBox = Box.createVerticalBox();
    JButton setting = new JButton("游戏设置");
    JButton NewBee = new JButton("扫雷菜鸟");
    JButton Pioneer = new JButton("扫雷先锋");
    JButton Hell = new JButton("扫雷终结者");
    JButton Continue = new JButton("继续游戏");
    JButton Start = new JButton("新的游戏");//点击进入模式选择
    JButton Online = new JButton("联机模式");
    JButton Offline = new JButton("单机模式");
    //JButton Return = new JButton("返回上级菜单");
    JButton Quit = new JButton("退出游戏");
    JButton SelfMode = new JButton("自定义模式");
    JFrame Players = new JFrame("请输入玩家姓名");

    Box Game = Box.createVerticalBox(); ;//选择难度
    JFrame game = new JFrame("选择难度");
    Box ModePanel = Box.createVerticalBox();//选择模式
    JFrame modePanel = new JFrame("选择模式");
    final int HEIGHT = 400;
    final int WIDTH = 600;


    public void Init() {
        modePanel.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-WIDTH)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-HEIGHT)/2, WIDTH, HEIGHT);
        game.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-WIDTH)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-HEIGHT)/2, WIDTH, HEIGHT);
        frame.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-WIDTH)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-HEIGHT)/2, WIDTH, HEIGHT);
        //vBox.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-WIDTH)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-HEIGHT)/2, WIDTH, HEIGHT);
        vBox.add(Start);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(Continue);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(setting);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(Quit);



        //Dimension d = new Dimension(400,400);
        //vBox.setPreferredSize(d);

        modePanel.add(ModePanel);
        ModePanel.add(Offline);
        ModePanel.add(Box.createVerticalStrut(30));
        ModePanel.add(Online);
        //ModePanel.add(Return);



        game.add(Game);
        Game.add(NewBee);
        Game.add(Box.createVerticalStrut(30));
        Game.add(Pioneer);
        Game.add(Box.createVerticalStrut(30));
        Game.add(Hell);
        Game.add(Box.createVerticalStrut(30));
        Game.add(SelfMode);
        //Game.add(Return);

        NewBee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mineCount = 10;
                MainFrame.xCount = 9;
                MainFrame.yCount = 9;
                SwingUtilities.invokeLater(() -> {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
            }
        });
        Pioneer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mineCount = 40;
                MainFrame.xCount = 16;
                MainFrame.yCount = 16;
                SwingUtilities.invokeLater(() -> {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
            }
        });
        Hell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
                MainFrame.mineCount = 99;
                MainFrame.xCount = 16;
                MainFrame.yCount = 30;
            }
        });



        //输入玩家姓名
        Offline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Box vBox = Box.createVerticalBox();
                Players.add(vBox);
                JLabel p1 = new JLabel("请第一位玩家输入姓名：");
                JLabel p2 = new JLabel("请第二位玩家输入姓名：");
                JTextField p1Name = new JTextField(10);
                JTextField p2Name = new JTextField(10);
                JButton ok = new JButton("确定");
                vBox.add(p1);
                vBox.add(p1Name);
                vBox.add(p2);
                vBox.add(p2Name);
                vBox.add(Box.createVerticalStrut(20));
                vBox.add(ok);

                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player1.setUserName(p1Name.getText());
                        player2.setUserName(p2Name.getText());
                        game.setVisible(true);
                    }
                });
                Players.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-500)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-200)/2, 500, 200);
                Players.setVisible(true);

            }
        });


        frame.add(vBox);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //frame.pack();
        frame.setVisible(true);


        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Start is clicked");
                modePanel.setVisible(true);
            }
        });


        //自定义模式
        SelfMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame self = new JFrame("自定义模式");
                JLabel mine = new JLabel("请输入雷数： ");
                JLabel x = new JLabel("请输入行数(在5到20之间)： ");
                JLabel y =  new JLabel("请输入列数(在5到30之间)： ");
                JTextField xNum = new JTextField(1);
                JTextField yNum = new JTextField(1);
                JTextField mineNum = new JTextField(1);
                JButton sure =  new JButton("确定");
                Box v2Box = Box.createVerticalBox();
                Box vBox = Box.createVerticalBox();
                Box hBox = Box.createHorizontalBox();
                self.add(hBox);
                hBox.add(vBox);
                vBox.add(x);
                vBox.add(Box.createVerticalStrut(20));
                vBox.add(y);
                vBox.add(Box.createVerticalStrut(20));
                vBox.add(mine);
                hBox.add(v2Box);
                v2Box.add(xNum);
                v2Box.add(Box.createVerticalStrut(20));
                v2Box.add(yNum);
                v2Box.add(Box.createVerticalStrut(20));
                v2Box.add(mineNum);
                v2Box.add(sure);


                sure.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(5<=Integer.parseInt(xNum.getText())&&Integer.parseInt(xNum.getText())<=20&&5<=Integer.parseInt(yNum.getText())&&Integer.parseInt(yNum.getText())<=30&&Integer.parseInt(mineNum.getText())>0&&Integer.parseInt(mineNum.getText())<=(Integer.parseInt(xNum.getText())*Integer.parseInt(yNum.getText()))/2){
                                    MainFrame.mineCount = Integer.parseInt(mineNum.getText());
                                    MainFrame.xCount = Integer.parseInt(xNum.getText());
                                    MainFrame.yCount = Integer.parseInt(yNum.getText());
                                    SwingUtilities.invokeLater(() -> {
                                        MainFrame mainFrame = new MainFrame();
                                        mainFrame.setVisible(true);
                                    });
                            }else{
                                JFrame Err = new JFrame("请重新输入相关数值。");
                                JButton ok = new JButton("确定");
                                Err.add(ok);
                                ok.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        Err.setVisible(false);
                                    }
                                });
                                Err.setVisible(true);
                                Err.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-300)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-100)/2, 300, 100);
                            }


                        }catch (NumberFormatException numberFormatException){
                            JButton ok = new JButton("确定");
                            JFrame Err = new JFrame("输入不合法!!!!");
                            Err.add(ok);
                            ok.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Err.setVisible(false);
                                }
                            });
                            Err.setVisible(true);
                            Err.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-300)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-100)/2, 300, 100);
                        }
                    }
                });



                self.setVisible(true);
                self.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-WIDTH)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-HEIGHT)/2, WIDTH, HEIGHT-200);
            }
        });



    }
}


