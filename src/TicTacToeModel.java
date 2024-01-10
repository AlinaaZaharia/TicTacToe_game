import javax.swing.*;
import java.awt.*;

public class TicTacToeModel {

    private int scorePlayerX;
    private int scorePlayerO;
    private String[] board;
    public boolean isSoundTurnedOn = true;
    private SoundManager soundManager;

    private TicTacToeView view;

    public TicTacToeModel() {
        //this.view= view;
        board = new String[9];
        resetGame();
        soundManager = new SoundManager();
    }

    public void resetScores() {
        scorePlayerX = 0;
        scorePlayerO = 0;
    }

    public int getScorePlayerX() {
        return scorePlayerX;
    }

    public int getScorePlayerO() {
        return scorePlayerO;
    }

    public void incrementScorePlayerX() {
        scorePlayerX++;
    }

    public void incrementScorePlayerO() {
        scorePlayerO++;
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = "";
        }
    }

    public void updatePlayerTurn() {
        if (getScorePlayerX() > getScorePlayerO()) {
            view.player1_turn = true;
            view.titleText.setText("O's turn");
        } else {
            view.player1_turn = false;
            view.titleText.setText("X's turn");
        }
    }
    public void turnOnOffSounds()
    {
        isSoundTurnedOn = !isSoundTurnedOn;
        if(!isSoundTurnedOn)
        {
            soundManager.disableSound();
        }
        else{
            soundManager.enableSound();
        }
    }
}