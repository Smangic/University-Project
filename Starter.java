package components;

import javax.swing.*;

public class Starter extends JPanel {
    JFrame frame = new JFrame("扫雷");
    JPanel panel = new JPanel();
    JButton mode = new JButton("模式选择");
    JButton setting = new JButton("游戏设置");
    JButton NewBee = new JButton("扫雷菜鸟");
    JButton Pioneer = new JButton("扫雷先锋");
    JButton Hell = new JButton("扫雷终结者");
    JButton Continue = new JButton("继续游戏");
    JButton Start = new JButton("新的游戏");//点击进入模式选择
    JButton Online = new JButton("联机模式");
    JPanel Game = new JPanel();
    JPanel ModePanel = new JPanel();




    public void Init(){
        frame.add(panel);
        panel.add(setting);
        panel.add(Continue);
        panel.add(Start);
        Game.add(mode);


    }


}
