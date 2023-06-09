import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        //frame.getContentPane().setBackground(Color.RED);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.BLACK);
        textField.setForeground(new Color(250,250,250));
        textField.setFont(new Font("Arial",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TicTacToe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.GREEN);

        for (int i=0; i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Times New Roman",Font.PLAIN,70));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
        }
        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<9; i++) {
            if (e.getSource()==buttons[i]) {
                if(player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(15,10,100));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(150,0,15));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X turn");
                        check();
                    }

                }
            }
        }

    }
    public void firstTurn() {
        if (random.nextInt(2)==0){
            player1_turn=true;
            textField.setText("X turn");
        }
        else {
            player1_turn=false;
            textField.setText("O turn");
        }
    }
    public void check() {
        if(
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
                ){
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(2,4,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }
        if(
                (buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ){
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ){
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                 (buttons[8].getText()=="O")
        ){
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ){
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ){
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ){
            oWins(2,4,6);
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(new Color(250,150,10));
        buttons[b].setBackground(new Color(250,150,10));
        buttons[c].setBackground(new Color(250,150,10));

        for (int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins");


    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.DARK_GRAY);
        buttons[b].setBackground(Color.DARK_GRAY);
        buttons[c].setBackground(Color.DARK_GRAY);

        for (int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");


    }

}
