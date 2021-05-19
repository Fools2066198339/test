package com.lk.javaTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author by LiuKui
 * @date 2021/3/14.
 */

//implements 是实现多个接口, 接口的方法一般为空的, 必须重写才能使用 ，ActionListener, KeyListener键盘监听、动作监听
public class Framers extends JFrame implements ActionListener, KeyListener {
    JTextArea t1;//留言框区域
    JButton but1, but2, but3, but4, but5, but6, but7;//按钮
    JComboBox<String> looks;//下拉表情列表组件
    JTextField lo;//文本框
    JLabel lbl1, lbl2, lbl3;//标签，构成留言框的每个部分
    ImageIcon imageIcon = null;
    ArrayList<String> expression ;



    //有参构造方法
    public Framers(String title) {
        super(title);//父类调用子类标题
        this.setSize(1000, 600);//设置留言框大小
        this.setFont(new Font("宋体", Font.BOLD, 14));
        this.setIconImage(new ImageIcon("src./favicon.jpg").getImage());//设置左上角图标

        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight();//获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示


        this.winInit();//留言框初始化
        this.setVisible(true);
    }

    //初始化窗口
    public void winInit() {
        lbl1 = new JLabel("留言板", 0);// horizontalAlignment: 标签内容（在标签内）的水平对其方式（竖直方向默认居中, 可通过方法设置）
        lbl2 = new JLabel("你");
        lbl3 = new JLabel("地说：");
        t1 = new JTextArea("留言内容：\n");
        t1.setLineWrap(true);//自动换行
        t1.setEditable(false);//设置留言板内容不可更改
        t1.setBackground(new Color(0xFF, 0xFF, 0xEE));//设置留言版的背景色
        imageIcon = new ImageIcon("src./favicon.jpg");

        t1.setForeground(new Color(0, 0, 255));//设置留言板字体颜色
        lo = new JTextField(35);//设置输入框长度
        looks = new JComboBox<>();
//        looks.addItem("哭着");
//        looks.addItem("笑着");
//        looks.addItem("哈哈哈哈");
//        looks.addItem("乐呵呵");
//        looks.addItem("笑嘻嘻");
//        looks.addItem("哭唧唧");
//        looks.addItem("哈哈哈");
//        looks.addItem("O(∩_∩)O哈哈~");
        this.loadExp();          //文件加载表情
        //创建按钮
        but1 = new JButton("提交");
        but2 = new JButton("清屏");
        but3 = new JButton("至顶");
        but4 = new JButton("至尾");
        but5 = new JButton("查看");
        but6 = new JButton("删除");
        but7 = new JButton("表情");
        //给标签、文本区域、按钮、表情下拉列表设置字体，宋体 加粗，大小：20磅
        lbl1.setFont(new Font("宋体", Font.BOLD, 20));
        lbl2.setFont(new Font("宋体", Font.BOLD, 20));
        lbl3.setFont(new Font("宋体", Font.BOLD, 20));
        t1.setFont(new Font("宋体", Font.BOLD, 20));
        lo.setFont(new Font("宋体", Font.BOLD, 20));
        but1.setFont(new Font("宋体", Font.BOLD, 20));
        but2.setFont(new Font("宋体", Font.BOLD, 20));
        but3.setFont(new Font("宋体", Font.BOLD, 20));
        but4.setFont(new Font("宋体", Font.BOLD, 20));
        but5.setFont(new Font("宋体", Font.BOLD, 20));
        but6.setFont(new Font("宋体", Font.BOLD, 20));
        but7.setFont(new Font("宋体", Font.BOLD, 20));
        looks.setFont(new Font("宋体", Font.BOLD, 20));
        // 添加和移除按钮的点击事件
        but1.addActionListener(this);  //提交
        but2.addActionListener(this);  //清屏
        but3.addActionListener(this);  //至顶
        but4.addActionListener(this);  //至尾
        but5.addActionListener(this);  //查看
        but6.addActionListener(this);  //删除
        but7.addActionListener(this);  //表情
        //键盘输入监听器
        lo.addKeyListener(this);
        //创建不同面板
        JPanel pEast = new JPanel();
        JPanel pSouth = new JPanel();
        JScrollPane scroll = new JScrollPane(t1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//加滚轮 垂直滚动条一直显示, 水平滚动条从不显示
        pEast.setLayout(new GridLayout(8, 1, 0, 30));//东方为网格布局 指定 行数 和 列数 的网格布局, 并指定 水平 和 竖直 网格间隙
        //面板
        pSouth.add(lbl2);
        pSouth.add(looks);
        pSouth.add(lbl3);
        pSouth.add(lo);
        pSouth.add(but1);
        pEast.add(but2);
        pEast.add(but3);
        pEast.add(but4);
        pEast.add(but5);
        pEast.add(but6);
        pEast.add(but7);
        //将面板加入窗口 位置
        add(scroll, "Center");
        add(lbl1, "North");
        add(pEast, "East");
        add(pSouth, "South");
        this.loadMsg();    //加载文件中的内容
        //将表情加到动态数组中，方便修改
        expression = new ArrayList<>();
        for (int i = 0; i < looks.getItemCount(); i++) {
            expression.add(looks.getItemAt(i));
        }
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
    }

    //加载文件中的表情
    public void loadExp() {
        looks.removeAllItems();
        try {
            FileReader Re = new FileReader("Expression.dat");
            BufferedReader br = new BufferedReader(Re);
            String exp;

            while ((exp = br.readLine()) != null) {
                looks.addItem(exp);
            }
            br.close();
        } catch (IOException e1) {
            System.out.println("读取文件失败" + e1);
        }
    }

    //加载文件中的留言内容
    public void loadMsg() {
        t1.setText("留言内容：\n");
        try {
            BufferedReader br = new BufferedReader(new FileReader("msg.dat"));
            String msg;
            while ((msg = br.readLine()) != null) {
                t1.insert(msg + "\n", 6);
            }
            br.close();
        } catch (IOException e1) {
            System.out.println("读文件失败" + e1);
        }
    }

    //提交修改的表情
    public void expSubmit() {
        PrintStream stream = null;
        try {
            stream = new PrintStream("Expression.dat");
            for (String s : expression) {
                stream.print(s + "\n");
            }
            stream.close();
        } catch (IOException e1) {
            System.out.println("写入文件失败" + e1);
        }
        loadExp();
    }

    //提交留言过程
    public void msgSubmit() {
        if (lo.getText().trim().length() == 0) return;
        //获取当前时间
        Date crr = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");//初始化时间格式
        String curr = sdf.format(crr);
        String loms = "[" + curr + "]" + "你" + looks.getSelectedItem() + "地说：" + lo.getText();
        t1.insert(loms + "\n", 6);
        //写入msg.dat文件
        File f = new File("Msg.dat");
        try {
            FileWriter fw = new FileWriter(f, true);//末尾追加
            fw.write(loms + "\r\n");
            fw.close();
        } catch (IOException e1) {
            System.out.println("写入文件失败" + e1);
        }
        lo.setText("");
    }

    //删除留言
    public void delete() {
        String lom = " ";
        File f = new File("Msg.dat");
        try {
            FileWriter fw = new FileWriter(f);//追加
            fw.write(lom + "\r\n");
            fw.close();
        } catch (IOException e1) {
            System.out.println("写入文件失败" + e1);
        }
    }

    //修改表情
    public void setException() {

        final JFrame jf = new JFrame("设置");
        jf.setSize(150, 150);
        jf.setLocationRelativeTo(null);

        // 删除
        JButton btn8 = new JButton("删除");
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * 返回用户点击的选项, 值为下面三者之一:
                 *     是:   JOptionPane.YES_OPTION
                 *     否:   JOptionPane.NO_OPTION
                 *     取消: JOptionPane.CANCEL_OPTION
                 *     关闭: JOptionPane.CLOSED_OPTION
                 */
                int result = JOptionPane.showConfirmDialog(jf, "确认删除？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    expression.remove((looks.getSelectedItem()));
                }
                expSubmit();
                //System.out.println("选择结果: " + result);
            }
        });

        //添加
        JButton btn9 = new JButton("添加");
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 显示输入对话框, 返回输入的内容
                String inputContent = JOptionPane.showInputDialog(jf, "输入你的表情:", looks.getSelectedItem());
                if (!expression.contains(inputContent)) {
                    expression.add(inputContent);
                }
                expSubmit();
                //System.out.println("输入的内容: " + inputContent);
            }
        });

        // 修改
        JButton btn10 = new JButton("修改");
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 显示输入对话框, 返回输入的内容
                String inputContent = JOptionPane.showInputDialog(jf, "输入你的表情:", looks.getSelectedItem());
                if (expression.contains((looks.getSelectedItem()))) {
                    expression.set(expression.indexOf(looks.getSelectedItem()), inputContent);
                }
                expSubmit();

                System.out.println("输入的内容: " + inputContent);
            }
        });

        // 垂直排列按钮
        Box vBox = Box.createVerticalBox();

        vBox.add(btn8);
        vBox.add(btn9);
        vBox.add(btn10);
        JPanel panel = new JPanel();
        panel.add(vBox);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    //动作监听器
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        switch (com) {
            case "提交": {
                msgSubmit();
                break;
            }
            case "清屏": {
                t1.setText("留言内容：\n");
                break;
            }
            case "至顶": {
                t1.setCaretPosition(0);
                break;
            }
            case "至尾": {
                t1.setCaretPosition(t1.getText().length() - 1);
                break;
            }
            case "查看": {
                this.loadMsg();
                break;
            }
            case "删除": {
                this.delete();
                this.loadMsg();
                break;
            }
            case "表情": {
                setException();
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e)  {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            msgSubmit();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}



