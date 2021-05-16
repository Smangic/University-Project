package components;

import controller.GameController;
import entity.Player;
import javafx.scene.image.Image;
import minesweeper.MainFrame;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Starter extends JPanel {

    public static Player player1 = new Player();
    public static Player player2 = new Player();
    public static  MainFrame mainFrame;

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
    JFrame CharacterChooser = new JFrame("请P1选择角色");
    final int HEIGHT = 450;
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


        //低级模式
        NewBee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data.mineCount = 10;
                Data.xCount = 9;
                Data.yCount = 9;
                SwingUtilities.invokeLater(() -> {
                    mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
            }
        });

        //中级模式
        Pioneer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data.mineCount = 40;
                Data.xCount = 16;
                Data.yCount = 16;
                SwingUtilities.invokeLater(() -> {
                    mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
            }
        });


        //高级模式
        Hell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data.mineCount = 99;
                Data.xCount = 16;
                Data.yCount = 30;
                SwingUtilities.invokeLater(() -> {
                    mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                });
            }
        });



        //输入玩家姓名
        Offline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Box vBox = Box.createVerticalBox();
                Box hBox = Box.createHorizontalBox();
                Players.add(vBox);
                JLabel p1 = new JLabel("请第一位玩家输入姓名：");
                p1.setForeground(Color.BLUE);

                JLabel p2 = new JLabel("请第二位玩家输入姓名：");
                p2.setForeground(Color.RED);
                JLabel move = new JLabel("请选择每回合步数");
                JRadioButton c1 = new JRadioButton("1",true);
                JRadioButton c2 = new JRadioButton("2");
                JRadioButton c3 = new JRadioButton("3");
                JRadioButton c4 = new JRadioButton("4");
                JRadioButton c5 = new JRadioButton("5");
                ButtonGroup step = new ButtonGroup();

                c1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.times=1;
                    }
                });
                c2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.times=2;
                    }
                });
                c3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.times=3;
                    }
                });
                c4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.times=4;
                    }
                });
                c5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GameController.times=5;
                    }
                });

                step.add(c1);
                step.add(c2);
                step.add(c3);
                step.add(c4);
                step.add(c5);

                JTextField p1Name = new JTextField(10);
                p1Name.setForeground(Color.BLUE);
                JTextField p2Name = new JTextField(10);
                p2Name.setForeground(Color.RED);
                JButton ok = new JButton("确定");
                vBox.add(p1);
                vBox.add(p1Name);
                vBox.add(p2);
                vBox.add(p2Name);
                vBox.add(Box.createVerticalStrut(20));
                vBox.add(move);
                vBox.add(hBox);
                hBox.add(c1);
                hBox.add(c2);
                hBox.add(c3);
                hBox.add(c4);
                hBox.add(c5);
                vBox.add(Box.createVerticalStrut(20));


                vBox.add(ok);

                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        player1.setUserName(p1Name.getText());
                        player2.setUserName(p2Name.getText());
                        //CharacterChooser.setVisible(true);
                        game.setVisible(true);
                    }
                });
                Players.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-500)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-250)/2, 500, 250);
                Players.setVisible(true);

            }
        });


        Icon RedWolfHead = new ImageIcon("MineSweeper-Demo/src/Icon/RedWolfHead.png");
        Icon RedWolf = new ImageIcon("MineSweeper-Demo/src/Icon/RedWolf.png");
        Icon GrayWolfHead = new ImageIcon("MineSweeper-Demo/src/Icon/GrayWolfHead.png");
        Icon GrayWolf = new ImageIcon("MineSweeper-Demo/src/Icon/GrayWolf.png");
        JLabel gwSkill = new JLabel("技能：\n安全的点开下一个方块，\n若是雷,插旗并加一分，\n若无雷显示周边雷数");
        JLabel rwSkill = new JLabel("技能：\n使下一位玩家的活动时间减少5秒");




        JRadioButton greyWolf = new JRadioButton();
        greyWolf.setIcon(GrayWolf);
        JRadioButton redWolf = new JRadioButton();
        redWolf.setIcon(RedWolf);
        JComboBox character = new JComboBox();
        character.add(redWolf);
        character.add(greyWolf);
        Box v1Box = Box.createVerticalBox();
        Box v2Box = Box.createVerticalBox();
        Box hBox = Box.createHorizontalBox();
        CharacterChooser.add(hBox);
        hBox.add(v1Box);
        hBox.add(v2Box);
        v1Box.add(greyWolf);
        v1Box.add(gwSkill);
        v2Box.add(redWolf);
        v2Box.add(rwSkill);
        CharacterChooser.setBounds((cn.itcast.util.ScreenUtils.getScreenWidth()-700)/2, (cn.itcast.util.ScreenUtils.getScreenHeight()-600)/2, 700, 600);

        greyWolf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1.setCharacter(new Character("灰太狼"));
            }
        });





        frame.add(this.vBox);
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
                JLabel mine = new JLabel("请输入雷数(雷数不多于总格数的一半)： ");
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
                                    Data.mineCount = Integer.parseInt(mineNum.getText());
                                    Data.xCount = Integer.parseInt(xNum.getText());
                                    Data.yCount = Integer.parseInt(yNum.getText());
                                    SwingUtilities.invokeLater(() -> {
                                        mainFrame = new MainFrame();
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


        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Object saving =  readObjectFromFile();
              MainFrame frame = (MainFrame) saving;
                SwingUtilities.invokeLater(() -> {
                    mainFrame = frame;
                    mainFrame.setVisible(true);
                });
            }
        });



    }


    public static Object readObjectFromFile()
    {
        Object temp=null;
        File file =new File("MineSweeper-Demo/src/Save/test.txt");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.Init();
    }
}


