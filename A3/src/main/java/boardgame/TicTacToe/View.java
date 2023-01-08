package boardgame.TicTacToe;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import boardgame.bGame.ui.PositionAwareButton;
import boardgame.game.GameUI;

public class View extends JPanel {

    private JLabel messageLabel;
    private Game game;
    private PositionAwareButton[][] buttons;

    private GameUI root;
    private int count = 0;

    public View(int wide, int tall, GameUI gameFrame) {
        super();
        setLayout(new BorderLayout());
        root = gameFrame;

        setGameController(new Game(wide, tall));

        messageLabel = new JLabel("Welcome to TicTacToe");
        add(messageLabel, BorderLayout.NORTH); // Messages go on top
        add(makeNewGameButton(), BorderLayout.SOUTH);
        add(makeQuitButton(), BorderLayout.EAST);
        add(makeButtonGrid(tall, wide), BorderLayout.CENTER);
    }

    //Numerical tictactoe constructor
    public View(int wide, int tall, GameUI gameFrame, int num) {
        super();
        setLayout(new BorderLayout());
        root = gameFrame;

        setGameController(new Game(wide, tall));

        messageLabel = new JLabel("Welcome to Numerical TicTacToe");
        add(messageLabel, BorderLayout.NORTH); // Messages go on top
        add(makeNewGameButton(), BorderLayout.SOUTH);
        add(makeQuitButton(), BorderLayout.EAST);
        add(makeButtonGrid2(tall, wide), BorderLayout.CENTER);
    }

    // public KakuroView(int wide, int tall, GameUI gameFrame){
    // // call the superclass constructor
    // super();
    // setLayout(new BorderLayout());
    // root = gameFrame;

    // // instantiate the controller
    // setGameController(new KakuroGame(wide,tall));

    // // make a new label to store messages
    // messageLabel = new JLabel("Welcome to Kakuro");
    // add(messageLabel, BorderLayout.NORTH); // Messages go on top
    // add(makeNewGameButton(),BorderLayout.EAST);
    // add(makeButtonGrid(tall,wide), BorderLayout.CENTER);
    // }

    public void setGameController(Game controller) {
        this.game = controller;
    }

    private JButton makeNewGameButton() {
        JButton button = new JButton("New Game");
        button.addActionListener(e -> newGame());
        return button;
    }

    private JButton makeQuitButton() {
        JButton button = new JButton("Quit");
        button.addActionListener(e -> quitGame());
        return button;
    }

    private JPanel makeButtonGrid(int tall, int wide) {

        JPanel panel = new JPanel();
        buttons = new PositionAwareButton[tall][wide];
        panel.setLayout(new GridLayout(wide, tall));
        for (int y = 0; y < wide; y++) {
            for (int x = 0; x < tall; x++) {
                // Create buttons and link each button back to a coordinate on the grid
                buttons[y][x] = new PositionAwareButton(" ");
                buttons[y][x].setAcross(x + 1); // made the choice to be 1-based
                buttons[y][x].setDown(y + 1);
                //buttons[y][x].setSize(500, 500);
                buttons[y][x].addActionListener(e -> {
                    makeMove(e);
                    statusCheck();
                });
                panel.add(buttons[y][x]);
            }
        }
        return panel;
    }
    

    private JPanel makeButtonGrid2(int tall, int wide) {

        JPanel panel = new JPanel();
        buttons = new PositionAwareButton[tall][wide];
        panel.setLayout(new GridLayout(wide, tall));
        for (int y = 0; y < wide; y++) {
            for (int x = 0; x < tall; x++) {
                // Create buttons and link each button back to a coordinate on the grid
                buttons[y][x] = new PositionAwareButton(" ");
                buttons[y][x].setAcross(x + 1); // made the choice to be 1-based
                buttons[y][x].setDown(y + 1);
                //buttons[y][x].setSize(500, 500);
                buttons[y][x].addActionListener(e -> {

                    makeNumMove(e);
                    //statusCheck();
                });
                panel.add(buttons[y][x]);
            }
        }
        return panel;
    }

    /* controller methods start here */

    private void statusCheck(){
        JOptionPane gameOver = new JOptionPane();
        int selection = 0;
        if(count == 9){
            game.changePlayer();
            JOptionPane.showMessageDialog(null, "The game was a tie");
            selection = gameOver.showConfirmDialog(null, "Do you want to play again?");
            if (selection == JOptionPane.NO_OPTION) {
                root.start();
            } else {
                newGame();
            }
        }
        for(int i = 1; i < 3; i++){
            if(game.rowCheck(i) || game.columnCheck(i)){
                game.changePlayer();
                JOptionPane.showMessageDialog(null, "Player " + game.getPlayer() + " won!");
                selection = gameOver.showConfirmDialog(null, "Do you want to play again?");
                if (selection == JOptionPane.NO_OPTION) {
                    root.start();
                } else {
                    newGame();
            }
        }
        statusCheck2(gameOver, selection);
    }
    }

    private void statusCheck2(JOptionPane gameOver, int selection){
        if(game.diagonalCheck()){
            game.changePlayer();
            JOptionPane.showMessageDialog(null, "Player " + game.getPlayer() + " won!");
            selection = gameOver.showConfirmDialog(null, "Do you want to play again?");
            if (selection == JOptionPane.NO_OPTION) {
                root.start();
            } else {
                newGame(); 
            }
        }
    }

    protected void updateView() {
        // update the labels on the buttons according to the model
        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidth(); x++) {
                buttons[y][x].setText(game.getCell(buttons[y][x].getAcross(), buttons[y][x].getDown()));
            }
        }

    }

    protected void newGame() {
        game.setPlayer("X");
        game.newGame();
        updateView();
    }

    protected void quitGame() {
        root.start();
    }

    private void makeMove(ActionEvent e) {
        // get input from user
        String player = game.getPlayer();
        // send input to game and update view
        PositionAwareButton clicked = ((PositionAwareButton) (e.getSource()));
        if(clicked.getText() == " "){
            count++;
            game.takeTurn(clicked.getAcross(), clicked.getDown(), player);
            clicked.setText(player);
        }
    }

    private void makeNumMove(ActionEvent e){
        PositionAwareButton clicked = ((PositionAwareButton)(e.getSource()));
        if(clicked.getText() == " "){
            //get input from user
            String tmp = JOptionPane.showInputDialog("Please input a value");

            int player = game.getNumPlayer();

            int num = Integer.parseInt(tmp);  
            while(true){
                if(num < 0 || num > 9){
                    tmp = JOptionPane.showInputDialog("Input incorrect enter another number");
                    num = Integer.parseInt(tmp);
                }else if(player == 2 && num % 2 == 0){
                    tmp = JOptionPane.showInputDialog("Input incorrect enter another number");
                    num = Integer.parseInt(tmp);
                }else if(player == 1 && num % 2 == 1){
                    tmp = JOptionPane.showInputDialog("Input incorrect enter another number");
                    num = Integer.parseInt(tmp);
                }else{
                    if(game.takeTurn(clicked.getAcross(), clicked.getDown(),tmp)){
                        game.changeNumPlayer();
                        clicked.setText(game.getCell(clicked.getAcross(),clicked.getDown()));
                    }
                    break;
                }
            }

        }
    }

}
