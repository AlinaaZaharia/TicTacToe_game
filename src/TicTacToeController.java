import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeController {

    private TicTacToeModel model;
    private TicTacToeView view;
    private boolean player1Turn;
    private SoundManager soundManager;

    TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        this.soundManager = new SoundManager();

        view.addButtonsListener(new buttonsListener());
        view.addButtonResetListener(new buttonResetListener());
        view.addSoundButtonListener(new soundButtonListener());
    }

    class buttonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton[] buttons = view.getButtons();
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == buttons[i]) {
                    {
                        if (buttons[i].getText().isEmpty()) {
                            if (player1Turn) {
                                soundManager.playButtonSound(soundManager.getSoundState());
                                buttons[i].setForeground(new Color(255, 0, 191));
                                buttons[i].setText("X");
                                player1Turn = false;
                                view.titleText.setText("O's turn");
                                winCheck();
                            } else {
                                soundManager.playButtonSound(soundManager.getSoundState());
                                buttons[i].setForeground(new Color(204, 0, 255));
                                buttons[i].setText("O");
                                player1Turn = true;
                                view.titleText.setText("X's turn");
                                winCheck();
                            }
                        } else {
                            soundManager.playButtonErrorSound(soundManager.getSoundState());
                            showMessageError("Caseta este deja ocupata, alegeti alta.", buttons[i]);
                        }
                    }
                }
            }
        }
    }

    private void showMessageError(String message, Component parentComponent) {
        JOptionPane.showMessageDialog(parentComponent, message, "Eroare", JOptionPane.ERROR_MESSAGE);
    }

    class buttonResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.resetGame();
            model.resetScores();
            view.updateScore(model.getScorePlayerX(), model.getScorePlayerO());
            view.resetGame();
        }
    }

    class soundButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.turnOnOffSounds();
            updateSoundButtonImage();
        }
    }

    private void updateSoundButtonImage() {
        ImageIcon speakerOn = new ImageIcon("speaker_icons/speakerOn.png");
        ImageIcon speakerOff = new ImageIcon("speaker_icons/speakerOff.png");

        if (model.isSoundTurnedOn) {
            view.getSoundButton().setIcon(speakerOn);
        } else {
            view.getSoundButton().setIcon(speakerOff);
        }
    }

    public void winCheck() {
        JButton[] buttons = view.getButtons();
        boolean win = false;

        boolean allOccupied = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                allOccupied = false;
            }
        }

        // X wins
        if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X")))
        {
            win=true;
            xWins(0, 1, 2);
        }
        if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X")))
        {
            win=true;
            xWins(3, 4, 5);
        }
        if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X")))
        {
            win=true;
            xWins(6, 7, 8);
        }
        if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X")))
        {
            win=true;
            xWins(0, 3, 6);
        }
        if((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X")))
        {
            win=true;
            xWins(1, 4, 7);
        }
        if((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X")))
        {
            win=true;
            xWins(2, 5, 8);
        }
        if((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X")))
        {
            win=true;
            xWins(0, 4, 8);
        }
        if((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X")))
        {
            win=true;
            xWins(2, 4, 6);
        }

        // O wins
        if((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O")))
        {
            win=true;
            oWins(0, 1, 2);
        }
        if((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O")))
        {
            win=true;
            oWins(3, 4, 5);
        }
        if((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O")))
        {
            win=true;
            oWins(6, 7, 8);
        }
        if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O")))
        {
            win=true;
            oWins(0, 3, 6);
        }
        if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O")))
        {
            win=true;
            oWins(1, 4, 7);
        }
        if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O")))
        {
            win=true;
            oWins(2, 5, 8);
        }
        if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O")))
        {
            win=true;
            oWins(0, 4, 8);
        }
        if((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O")))
        {
            win=true;
            oWins(2, 4, 6);
        }


        if(allOccupied && !win) {

            soundManager.noWinnerSound(soundManager.getSoundState());
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    SwingUtilities.invokeLater(() ->
                    {
                        view.resetGame();
                        model.updatePlayerTurn();
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    public void xWins(int a, int b, int c){
        soundManager.congratulationSound(soundManager.getSoundState());
        model.incrementScorePlayerX();
        JButton[] buttons = view.getButtons();

        buttons[a].setBackground(new Color(255, 102, 179));
        buttons[b].setBackground(new Color(255, 102, 179));
        buttons[c].setBackground(new Color(255, 102, 179));

        for(int i=0; i<9; i++)
        {
            buttons[i].setEnabled(false);
        }
        view.titleText.setText("X wins");
        view.updateScore(model.getScorePlayerX(), model.getScorePlayerO());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                SwingUtilities.invokeLater(() -> view.resetGame());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        player1Turn = true;
    }

    public void oWins(int a, int b, int c){
        soundManager.congratulationSound(soundManager.getSoundState());
        model.incrementScorePlayerO();
        JButton[] buttons = view.getButtons();

        buttons[a].setBackground(new Color(255, 102, 179));
        buttons[b].setBackground(new Color(255, 102, 179));
        buttons[c].setBackground(new Color(255, 102, 179));

        for(int i=0; i<9; i++)
        {
            buttons[i].setEnabled(false);
        }
        view.titleText.setText("O wins");
        view.updateScore(model.getScorePlayerX(), model.getScorePlayerO());
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                SwingUtilities.invokeLater(() -> view.resetGame());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        player1Turn = false;
    }
}