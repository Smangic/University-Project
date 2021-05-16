package components;

import entity.GridStatus;
import minesweeper.MainFrame;

import java.awt.*;//换swing
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.text.IconView;

public class GridComponent extends BasicComponent implements Serializable {
    public static int gridSize = 50;//调整大小需要改这个


    private static final Image grid = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/Grass.png");
    private static final Image Base = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/BaseGround.jpg");
    private static final Image Mine = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/TNT.jpg");
    private static final Image Flag = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/Flag.png");
    private static final Image zero = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/0.png");
    private static final Image one = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/1.png");
    private static final Image two = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/2.png");
    private static final Image three = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/3.png");
    private static final Image four = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/4.png");
    private static final Image five = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/5.png");
    private static final Image six = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/6.png");
    private static final Image seven = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/7.png");
    private static final Image eight = Toolkit.getDefaultToolkit().getImage("MineSweeper-Demo/src/Icon/8.png");
    private int row;
    private int col;
    private GridStatus status = GridStatus.Covered;//可以考虑于Square进行衔接
    private String content;
    private MouseAdapter adapter;

    public GridComponent(int x, int y) {
        this.setSize(gridSize, gridSize);//调整大小需要改这个
        this.row = x;
        this.col = y;
        this.addMouseListener(adapter);

    }


    @Override
    public void onMouseLeftClicked() {
        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);
        if (this.status == GridStatus.Covered) {
            this.status = GridStatus.Clicked;
            repaint();


            if (content.equals("-1")) {
                if (Starter.mainFrame.controller.getOnTurnPlayer() == Starter.mainFrame.controller.getP1()) {
                    Starter.mainFrame.controller.getP1().costp1Score();
                    Starter.mainFrame.controller.addNumberOfLandmineBoom();
                    System.out.println("Yes");
                } else if (Starter.mainFrame.controller.getOnTurnPlayer() == Starter.mainFrame.controller.getP2()) {
                    Starter.mainFrame.controller.getP2().costp2Score();
                    Starter.mainFrame.controller.addNumberOfLandmineBoom();
                }
            }
            Starter.mainFrame.controller.getScoreBoard().update();


            Starter.mainFrame.controller.addClick();
            if (Starter.mainFrame.controller.getClick() == Starter.mainFrame.controller.getTimes()) {
                Starter.mainFrame.controller.nextTurn();
                Starter.mainFrame.controller.setClick(0);

            }

            //TODO: 在左键点击一个格子的时候，还需要做什么？

        }
    }

    @Override
    public void onMouseRightClicked() {
        System.out.printf("Gird (%d,%d) is right-clicked.\n", row ,col);
        if (this.status == GridStatus.Covered) {
            this.status = GridStatus.Flag;
            repaint();
            Starter.mainFrame.controller.addClick();

            if (content.equals("-1") && this.status == GridStatus.Flag) {
                if (Starter.mainFrame.controller.getOnTurnPlayer() == Starter.mainFrame.controller.getP1()) {
                    Starter.mainFrame.controller.getP1().addp1Score();
                    Starter.mainFrame.controller.addNumberOfLandmineFlag();
                } else if (Starter.mainFrame.controller.getOnTurnPlayer() == Starter.mainFrame.controller.getP2()) {
                    Starter.mainFrame.controller.getP2().addp2Score();
                    Starter.mainFrame.controller.addNumberOfLandmineFlag();
                }
            }
            if (!content.equals("-1") && this.status == GridStatus.Flag) {
                if (Starter.mainFrame.controller.getOnTurnPlayer() == Starter.mainFrame.controller.getP1()) {
                    Starter.mainFrame.controller.getP1().addp1mistake();
                } else if (Starter.mainFrame.controller.getOnTurnPlayer() == Starter.mainFrame.controller.getP2()) {
                    Starter.mainFrame.controller.getP2().addp2mistake();
                }
            }
            Starter.mainFrame.controller.getScoreBoard().update();

            if (Starter.mainFrame.controller.getClick() == Starter.mainFrame.controller.getTimes()) {
                Starter.mainFrame.controller.nextTurn();
                Starter.mainFrame.controller.setClick(0);

            }
        }

        //TODO: 在右键点击一个格子的时候，还需要做什么？
    }

    public void draw(Graphics g) {

        if (this.status == GridStatus.Covered) {
            g.drawImage(grid, 0, 0, getWidth() - 1, getHeight() - 1, this);
            //if(this.mouseExited())
        }
        if (this.status == GridStatus.Clicked) {
            if (Integer.parseInt(content) == -1) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(Mine, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 0) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(zero, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 1) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(one, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 2) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(two, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 3) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(three, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 4) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(four, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 5) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(five, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 6) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(six, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 7) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(seven, 0, 0, getWidth() - 1, getHeight() - 1, this);
            } else if (Integer.parseInt(content) == 8) {
                g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
                g.drawImage(eight, 0, 0, getWidth() - 1, getHeight() - 1, this);
            }

//            if (Integer.parseInt(content)>=0&&Integer.parseInt(content)<=9){
//                g.drawImage(Base,0, 0, getWidth() - 1, getHeight() - 1,this);
//                g.setColor(Color.GREEN);
//                g.drawString(content, getWidth() / 2 - 5, getHeight() / 2 + 5);
//            }else {
//                g.drawImage(Mine,0, 0, getWidth() - 1, getHeight() - 1,this);
//            }
        }
        if (this.status == GridStatus.Flag) {
            g.drawImage(Base, 0, 0, getWidth() - 1, getHeight() - 1, this);
            g.drawImage(Flag, 0, 0, getWidth() - 1, getHeight() - 1, this);
        }
    }

    public void setContent(int content) {
        this.content = String.valueOf(content);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        draw(g);
    }

    @Override
    public String toString() {
        return "GridComponent{" +
                "row=" + row +
                ", col=" + col +
                ", status=" + status +
                ", content='" + content + '\'' +
                '}';
    }
}
