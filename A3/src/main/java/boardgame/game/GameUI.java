package boardgame.game;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import boardgame.TicTacToe.View;


public class GameUI extends JFrame{
    private JPanel gameContainer;
    private JMenuBar menuBar;
    //private Player player1;
    //private Player player2;


    public GameUI(String title){
        // call the superclass constructor
        super();    
        // set the size, title and default close of the jframe
        this.setSize(300, 200);
        this.setTitle(title);
        makeMenu();
        setJMenuBar(menuBar);
        gameContainer = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // make a new label to store messages
        
        add(gameContainer, BorderLayout.CENTER);
        add(makeButtonPanel(),BorderLayout.EAST);
        start();

    }
    private JPanel makeButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(makeTicButton());
        buttonPanel.add(makeNTicButton());
        return buttonPanel;
    }

    private JPanel startupMessage(){
        JPanel temp = new JPanel();
        temp.add(new JLabel("time to play some board games!"));
        return temp;

    }

    private JButton makeTicButton(){
        JButton button = new JButton("Play TicTacToe");
        button.addActionListener(e->tic());
        return button;
    }

    private JButton makeNTicButton(){
        JButton button = new JButton("Play Numerical TicTacToe");
        button.addActionListener(e->nTic());
        return button;
    }

    public void makeMenu(){
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem item = new JMenuItem("Save Game");
        JMenuItem item2 = new JMenuItem("Load Game");
        menu.add(item);
        menu.add(item2);
        menuBar.add(menu);
        item.addActionListener(e->saveSomething());
        //add load smth
    }



    public void start(){
        gameContainer.removeAll();
        gameContainer.add(startupMessage());
        getContentPane().repaint();
        getContentPane().revalidate();
        pack();
    }

    //make this later
    /**
     * 
     */
    protected void saveSomething(){
        JOptionPane.showMessageDialog(null,"This should prompt for save files"); 
    }

    protected void tic(){
        gameContainer.removeAll();
        gameContainer.add(new View(3, 3, this));
        getContentPane().repaint();
        getContentPane().revalidate();
        pack();
    }

    protected void nTic(){
    gameContainer.removeAll();
    gameContainer.add(new View(3, 3, this, 2));
    getContentPane().repaint();
    getContentPane().revalidate();
    pack();
     
    }

public static void main(String[] args){
    GameUI example = new GameUI("Play Games!");
    example.setVisible(true);
}
} 
