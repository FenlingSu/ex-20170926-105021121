import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {
    private Button btnAdd = new Button("Add");
    private Button btnexit = new Button("Exit");
    private Label lab = new Label(">__<");
    private int n=0;
    public MainFrame(){
        initComp();
    }

    public void initComp(){
        this.setBounds(100,100,500,400);            //建立視窗

        this.addWindowListener(new WindowAdapter() {                    //設定右上X關閉視窗
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.setLayout(null);                                            //取消原件大小設定
        lab.setBounds(50,50,130,50);                  //設定標籤
        this.add(lab);                                                   //在視窗顯示標籤
        //this.setBackground(new Color(0xC2F5CD));                         更改顏色

        btnAdd.setBounds(100,100,130,50);
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n++;
                MainFrame.this.setTitle(Integer.toString(n));
                lab.setText(Integer.toString(n));
            }
        });
        btnexit.setBounds(100,200,130,50);
        this.add(btnexit);
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        }
    }

