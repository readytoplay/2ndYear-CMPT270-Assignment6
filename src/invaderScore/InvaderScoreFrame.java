package invaderScore;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameInfoProvider;

import java.awt.BorderLayout;


import java.awt.event.ActionListener;
import java.util.List;

import model.GameObserver;




/**
 * Create an Invader scores panel, with the invader scores, 
 * @param width   	the width of the panel
 * @param height  	the height of the panel
 * @param listener	the class listening for the event 
 *                	that signals the button was pressed
 */
public class InvaderScoreFrame extends JFrame implements GameObserver
{
	/**
	 * The object that provides information about the game.
	 */
	private GameInfoProvider gameInfo;
	
	/** The printout of Invaders and their Scores*/
	private String invaderScore;
	
	
	public InvaderScoreFrame(GameInfoProvider gameInfo)
	{
	setSize(400, 672);
	setLocation(805,0);
	setBackground(Color.BLACK);
	setLayout(new BorderLayout());
	this.gameInfo = gameInfo;
	
	JPanel panel = new JPanel();
	panel.setLayout(new BorderLayout());
	
	JLabel titleLabel = new JLabel("Invader Score");
	titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	add(titleLabel);
	InvaderScorePanel scorePanel = new InvaderScorePanel(gameInfo);
	this.add(scorePanel);
	//gameInfo.addObserver(scorePanel);
	this.setVisible(true);
	}
	public static final long serialVersionUID = 1;


	@Override
	public void gameChanged() {
		List<model.InvaderScore> invaderList;
		invaderList = gameInfo.getInvaderScore();
		invaderScore = invaderList.toString();
		
	}
}
