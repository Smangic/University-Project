package minesweeper;

import components.GridComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private GridComponent[][] mineField;
    //private int[][] chessboard;
    private Square[][] board; //格子棋盘
    //private final Random random = new Random();

    /**
     * 初始化一个具有指定行列数格子、并埋放了指定雷数的雷区。
     *
     * @param xCount    count of grid in column
     * @param yCount    count of grid in row
     * @param mineCount mine count
     */
    public GamePanel(int xCount, int yCount, int mineCount) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setSize(GridComponent.gridSize * yCount, GridComponent.gridSize * xCount);//棋子大小是固定的。。。。。

        initialGame(xCount, yCount, mineCount);

        repaint();
    }

    public void initialGame(int xCount, int yCount, int mineCount) {
        mineField = new GridComponent[xCount][yCount];

        generateChessBoard(xCount, yCount, mineCount);

        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                GridComponent gridComponent = new GridComponent(i, j);
                if (board[i+1][j+1].isHasLandMine()) {
                    gridComponent.setContent(-1);
                } else {
                    gridComponent.setContent(board[i+1][j+1].getNumberOfLandMine());
                }
                //gridComponent.setContent(chessboard[i+1][j+1]);
                gridComponent.setLocation(j * GridComponent.gridSize, i * GridComponent.gridSize);
                mineField[i][j] = gridComponent;
                this.add(mineField[i][j]);
            }
        }
    }

    //key!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void generateChessBoard(int xCount, int yCount, int mineCount) {
        int[] MineLocation = GamePanel.random(mineCount, xCount * yCount +1);//埋下给定数量的雷，并确定埋雷的“一维坐标”
        //todo:还没有实现避免首发踩雷。
        //chessboard = new int[xCount + 2][yCount + 2];//周边雷数
        board = new Square[xCount + 2][yCount + 2];
        for (int i = 0; i < xCount + 2; i++) {
            for (int j = 0; j < yCount + 2; j++) {
                board[i][j] = new Square();//生成空棋盘，棋盘外围多一圈，好写判断
            }
        }
        //埋雷（可能有问题）
        for (int i = 0; i < mineCount; i++) {
            board[locationDecider(MineLocation[i],yCount)[0]][locationDecider(MineLocation[i],yCount)[1]].setHasLandMine(true);//将一维坐标转为二维坐标
            //chessboard[(MineLocation[i] / yCount) + 1][MineLocation[i] % yCount] = -1;
        }
        //开始数雷
        for (int i = 1; i < xCount + 1; i++) {
            for (int j = 1; j < yCount + 1; j++) {
                //本身有雷的格子跳过
                if (!board[i][j].isHasLandMine()) {
                    Square[] surrounding = {board[i - 1][j - 1], board[i - 1][j], board[i - 1][j + 1], board[i][j - 1], board[i][j + 1], board[i + 1][j - 1], board[i + 1][j], board[i + 1][j + 1]};//每个格子的周边8个格子
                    int num = 0;
                    for (int k = 0; k < 8; k++) {
                        if (surrounding[k].isHasLandMine()) {
                            num++;
                        }
                    }
                    //chessboard[i][j] = num;//demo自带的，照顾一下
                    board[i][j].setNumberOfLandMine(num);//设置到格子的属性中去
                }
            }
        }
    }

    /**
     * 获取一个指定坐标的格子。
     * 注意请不要给一个棋盘之外的坐标哦~
     *
     * @param x 第x列
     * @param y 第y行
     * @return 该坐标的格子
     */
    public GridComponent getGrid(int x, int y) {
        try {
            return mineField[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    //生成指定数量雷
    private static int[] random(int t, int k) {//t//数组长度 k //整数随机的取值范围,n必须小于等于k
        int[] a = new int[t];
        int n;
        boolean flag;
        for (int i = 0; i < a.length; i++) {
            do {
                flag = false;
                n = 1 + new Random().nextInt(k);
                for (int j = 0; j <= i; j++) {
                    if (n == a[j]) {
                        flag = true;
                        break;
                    }
                }
            } while (flag);
            a[i] = n;
        }
        return a;
    }
    private static int[] locationDecider(int MineLocation,int y){
        int[] Location = new int[2];
        if(MineLocation%y==0){
            Location[0] = MineLocation/y;
            Location[1] = y;
        }else {
            Location[0] = MineLocation/y+1;
            Location[1] = MineLocation%y;
        }
        return Location;
    }

    public Square getSquare(int row, int col) {
    return board[row][col];
    }
}