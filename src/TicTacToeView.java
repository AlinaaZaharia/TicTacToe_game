import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToeView extends JFrame{

     private TicTacToeModel model;
     private JFrame frame = new JFrame();
     private JPanel titlePanel = new JPanel();
     JLabel titleText = new JLabel();
     private JLabel buttonPanel = new JLabel();
     private JButton[] buttons = new JButton[9];
     private JPanel scorePanel = new JPanel();
     JLabel scoreText1 = new JLabel();
     JLabel scoreText2 = new JLabel();
     JButton resetButton = new JButton();
     JButton soundButton = new JButton();
     boolean player1_turn;


    TicTacToeView(TicTacToeModel model) {

        this.model = model;

            // frame
        frame.setSize(450, 510);
        frame.getContentPane().setBackground(new Color(255, 204, 229));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

            // Panel: title + soundButton (+ image speaker on/off)
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 100, 100);
        titlePanel.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 204), 4));

        titleText.setBackground(new Color(255, 153, 204));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        titleText.setForeground(new Color(255, 26, 140));
        titleText.setFont(new Font("Bauhaus 93", Font.PLAIN, 60));
        titleText.setText("TicTacToe");
        titleText.setOpaque(true);
        titlePanel.add(titleText);
        frame.add(titlePanel, BorderLayout.NORTH);

        soundButton.setText("");
        soundButton.setFont(new Font("Arial", Font.BOLD, 10));
        soundButton.setBackground(new Color(255, 153, 204));
        soundButton.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 204), 2));

        ImageIcon speakerOn = new ImageIcon("speaker_icons/speakerOn.png");
        soundButton.setIcon(speakerOn);
        soundButton.setFocusable(false);
        soundButton.setPreferredSize(new Dimension(60, 40));
        titlePanel.add(soundButton, BorderLayout.EAST);

            // game board
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(255, 255, 255));

        for(int i=0; i<9; i++)
        {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 80));
            buttons[i].setBackground(new Color(255, 204, 228));
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(255, 153, 204), 4));
            buttons[i].setFocusable(false);
        }
        frame.add(buttonPanel);

            // score
        scorePanel.setLayout(new GridLayout(1, 3));
        scorePanel.setBackground(new Color(255, 204, 228));

        JPanel scoreText1Panel = new JPanel();
        scoreText1Panel.setBackground(new Color(255, 204, 228));
        scoreText1Panel.setLayout(new BorderLayout());
        scoreText1.setText("X's score: 0");
        scoreText1Panel.add(scoreText1, BorderLayout.WEST);

        JPanel resetButtonPanel = new JPanel();
        resetButtonPanel.setLayout(new BorderLayout());
        resetButton.setBackground(new Color(255, 153, 204));
        resetButton.setBorder(BorderFactory.createLineBorder(new Color(255, 26, 140), 2));
        resetButton.setText("RESET");
        resetButton.setForeground(new Color(255, 26, 140));
        resetButtonPanel.add(resetButton, BorderLayout.CENTER);

        JPanel scoreText2Panel = new JPanel();
        scoreText2Panel.setBackground(new Color(255, 204, 228));
        scoreText2Panel.setLayout(new BorderLayout());
        scoreText2.setText("O's score: 0");
        scoreText2Panel.add(scoreText2, BorderLayout.EAST);

        scorePanel.add(scoreText1Panel);
        scorePanel.add(resetButtonPanel);
        scorePanel.add(scoreText2Panel);

        frame.add(scorePanel, BorderLayout.SOUTH);
        firstTurn();
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        player1_turn = false;
        titleText.setText("O's turn");
    }

    public JButton[] getButtons() {

        return buttons;
    }

    public void addButtonsListener(ActionListener btns) {

        for(int i=0; i<9; i++)
        {
            buttons[i].addActionListener(btns);
        }
    }

    public void resetGame() {

        for(int i=0; i<9; i++)
        {
            buttons[i].setText("");
            buttons[i].setBackground(new Color(255, 204, 228));
            buttons[i].setEnabled(true);
        }
    }


    public void updateScore(int x, int o)
    {
        scoreText1.setText("X's score: " + x);
        scoreText2.setText("O's score: " + o);
    }

    void addButtonResetListener(ActionListener rst)
    {
        resetButton.addActionListener(rst);
    }

    void addSoundButtonListener(ActionListener btn)
    {
        soundButton.addActionListener(btn);
    }

    public JButton getSoundButton()
    {
        return soundButton;
    }
}