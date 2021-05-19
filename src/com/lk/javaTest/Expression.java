package com.lk.javaTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Expression extends JFrame  {
    JButton btn03,btn04,btn05;

    public Expression() {
        super("设置");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.init();
        this.setVisible(true);
    }

//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
public void init(){
    btn03 = new JButton("删除");
    btn04 = new JButton("添加");
    btn05 = new JButton("修改");

    Box vBox = Box.createVerticalBox();

    vBox.add(btn03);
    vBox.add(btn04);
    vBox.add(btn05);
    JPanel panel = new JPanel();
    panel.add(vBox);
    this.setContentPane(panel);
}

    public static void main(String[] args) {
        Expression e=new Expression();
        e.setVisible(true);
    }

}
