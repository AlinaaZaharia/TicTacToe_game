import javax.swing.*;

public class TicTacToeMain {
    public static void main(String[] args) {

        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView(model);
        TicTacToeController controller = new TicTacToeController(model, view);

        view.setVisible(true);
    }
}