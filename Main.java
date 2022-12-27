import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new TicTacToe();

    }
}
class TicTacToe extends JFrame {
    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel txtfield_label = new JLabel();
    JButton[] button = new JButton[9];

    JButton exit_btn = new JButton("Exit");
    JButton reset_btn = new JButton("Reset");

    JPanel score_pan = new JPanel();
    JLabel xscore = new JLabel();
    JLabel oscore = new JLabel();
    boolean player1_turn;
    private int xCount = 0;
    private int oCount = 0;
    ImageIcon imageIcon;



            TicTacToe(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setSize(500,500);
        this.getContentPane().setBackground(Color.CYAN);
        this.setResizable(false);//turn off the maximize option
        this.setTitle("Tic Tac Toe");
        imageIcon = new ImageIcon(getClass().getResource("Picsart_22-12-27_12-49-48-936.png"));
        this.setIconImage(imageIcon.getImage());


//-----------text field -----------

        txtfield_label.setBackground(new Color(0xADA2FF));
        txtfield_label.setForeground(Color.WHITE);
        txtfield_label.setFont(new Font("Roboto Slab", Font.BOLD, 50));
        txtfield_label.setText("Tic Tac Toe");
        txtfield_label.setHorizontalAlignment(JLabel.CENTER);
        txtfield_label.setOpaque(true);

        this.add(score_pan,BorderLayout.SOUTH);
        score_pan.setBackground(new Color(0xADA2FF));
//-----------score------------------------
        score_pan.add(xscore,BorderLayout.WEST);
        xscore.setText("X : 0  ");
        xscore.setFont(new Font("Roboto Slab", Font.BOLD,50));
        score_pan.add(oscore,BorderLayout.EAST);
        oscore.setText("  0 : O");
        oscore.setFont(new Font("Roboto Slab", Font.BOLD,50));

//----------title panel---------------------

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,500,100);
        title_panel.add(txtfield_label);
        this.add(title_panel,BorderLayout.NORTH);

        title_panel .add(reset_btn,BorderLayout.EAST);
        reset_btn.setBackground(new Color(0xC0DEFF));
        reset_btn.setFocusable(false);

        title_panel.add(exit_btn,BorderLayout.WEST);
        exit_btn.setBackground(new Color(0xC0DEFF));
        exit_btn.setFocusable(false);

        exit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null,"Confirm exit?","Tic Tac Toe",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }
            }
        });
        reset_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < 9; i++) {
                        button[i].setText("");
                        button[i].setBackground(new Color(0xC0DEFF));
                    }
                    check();


            }
        });



//---------Button panel-------------

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.BLACK);
        this.add(button_panel);

        for (int i=0; i<9; i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("Roboto Slab", Font.BOLD,125));
            button[i].setFocusable(false);
            button[i].setBackground(new Color(0xC0DEFF));

            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i=0; i<9; i++){
                        if (e.getSource()==button[i]){
                            if (player1_turn){
                                if (button[i].getText()==""){
                                    button[i].setForeground(Color.RED);
                                    button[i].setText("X");
                                    player1_turn = false;
                                    txtfield_label.setText("It's O turn");
                                    check();
                                }
                            }
                            else {
                                if (button[i].getText()==""){
                                    button[i].setForeground(Color.BLUE);
                                    button[i].setText("O");
                                    player1_turn = true;
                                    txtfield_label.setText("It's X turn");
                                    check();
                                }
                            }
                        }
                    }
                }
            });
        }

        first_turn();

    }

    public void first_turn(){

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2)==0){
            player1_turn = true;
            txtfield_label.setText("It's X turn");
        }
        else {
            player1_turn = false;
            txtfield_label.setText("It's O turn");
        }
    }
    public void check(){
//---------------X win--------------------------------------
        if (button[0].getText()=="X" && button[1].getText()=="X" && button[2].getText()=="X"){
            xwin(0,1,2);
        }
        else if (button[3].getText()=="X" && button[4].getText()=="X" && button[5].getText()=="X"){
            xwin(3,4,5);
        }
        else if (button[6].getText()=="X" && button[7].getText()=="X" && button[8].getText()=="X"){
            xwin(6,7,8);
        }
        else if (button[0].getText()=="X" && button[3].getText()=="X" && button[6].getText()=="X"){
            xwin(0,3,6);
        }
        else if (button[1].getText()=="X" && button[4].getText()=="X" && button[7].getText()=="X"){
            xwin(1,4,7);
        }
        else if (button[2].getText()=="X" && button[5].getText()=="X" && button[8].getText()=="X"){
            xwin(2,5,8);
        }
        else if (button[0].getText()=="X" && button[4].getText()=="X" && button[8].getText()=="X"){
            xwin(0,4,8);
        }
        else if (button[2].getText()=="X" && button[4].getText()=="X" && button[6].getText()=="X"){
            xwin(2,4,6);
        }
//---------------------O win---------------------------------
        else if (button[0].getText()=="O" && button[1].getText()=="O" && button[2].getText()=="O"){
            owin(0,1,2);
        }
        else if (button[3].getText()=="O" && button[4].getText()=="O" && button[5].getText()=="O"){
            owin(3,4,5);
        }
        else if (button[6].getText()=="O" && button[7].getText()=="O" && button[8].getText()=="O"){
            owin(6,7,8);
        }
        else if (button[0].getText()=="O" && button[3].getText()=="O" && button[6].getText()=="O"){
            owin(0,3,6);
        }
        else if (button[1].getText()=="O" && button[4].getText()=="O" && button[7].getText()=="O"){
            owin(1,4,7);
        }
        else if (button[2].getText()=="O" && button[5].getText()=="O" && button[8].getText()=="O"){
            owin(2,5,8);
        }
        else if (button[0].getText()=="O" && button[4].getText()=="O" && button[8].getText()=="O"){
            owin(0,4,8);
        }
        else if (button[2].getText()=="O" && button[4].getText()=="O" && button[6].getText()=="O"){
            owin(2,4,6);
        }

    }
    public void xwin(int a, int b, int c){
        button[a].setBackground(new Color(0xADE792));
        button[b].setBackground(new Color(0xADE792));
        button[c].setBackground(new Color(0xADE792));
        for (int i=0; i<9; i++){
            //button[i].setEnabled(false);
        }
        //txtfield_label.setText("X Wins");
        JOptionPane.showMessageDialog(null,"X Wins","Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
        xCount++;
        xscore.setText(String.valueOf("X : "+xCount+"  "));

    }
    public void owin(int a, int b, int c){
        button[a].setBackground(new Color(0xADE792));
        button[b].setBackground(new Color(0xADE792));
        button[c].setBackground(new Color(0xADE792));
        for (int i=0; i<9; i++){
            //button[i].setEnabled(false);
        }
        //txtfield_label.setText("O Wins");
        JOptionPane.showMessageDialog(null,"O Wins","Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
        oCount++;
        oscore.setText(String.valueOf("  "+oCount+" : O"));
    }

}