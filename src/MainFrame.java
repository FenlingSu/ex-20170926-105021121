import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends Frame {
    private Button btnAdd = new Button("Add");
    private Button btnSub = new Button("Sub");
    private Button btnexit = new Button("Exit");
    private Label lab = new Label(">uO");
    private int n = 0, labX = 50, labY = 50, r=255, g=255, b=255;
    private boolean flag=true;                                          //是否開關
    private Timer t1;                                                   //宣告計數器

    public MainFrame() {
        initComp();
    }

    public void initComp() {
        this.setBounds(100, 100, 500, 400);            //建立視窗

        this.addWindowListener(new WindowAdapter() {                    //設定右上X關閉視窗
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.setLayout(null);                                            //取消原件大小設定
        lab.setBounds(labX, labY, 30, 30);                  //設定標籤
        this.add(lab);                                                   //在視窗顯示標籤


        btnAdd.setBounds(30, 300, 130, 30);
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n++;
                MainFrame.this.setTitle(Integer.toString(n));
                t1.start();
                flag=true;                                                 //設定+為是
            }
        });

        this.getWidth();

        btnSub.setBounds(180, 300, 130, 30);
        this.add(btnSub);
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n--;
                MainFrame.this.setTitle(Integer.toString(n));
                flag=false;                                                //設定-為否
            }
        });

        btnexit.setBounds(330, 300, 130, 30);
        this.add(btnexit);
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        t1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    labX += 5;
                    lab.setLocation(labX, labY);
                    if (g - 3 > 0) {
                        g -= 3;
                        b -= 3;
                    }
                    if (labX > MainFrame.this.getWidth()) {
                        flag = false;
                    }
                } else {
                    labX -= 5;
                    lab.setLocation(labX, labY);
                    if (g + 3 < 255) {                              //顏色更動
                        g += 3;
                        b += 3;
                    }
                    if (labX < 0) {
                        flag = true;
                    }
                }
                lab.setBackground(new Color(r, g, b));
            }
        });
    }
}

