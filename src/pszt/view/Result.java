package pszt.view;

import java.awt.Dimension;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pszt.common.events.MyEvent;

class Result extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Result(final BlockingQueue<MyEvent> blockingQueue, final String status)
	{
		Dimension dimensionWindow = new Dimension(400, 400);
		this.setTitle(status);
		this.setSize(dimensionWindow);	//ustawiamy rozmiar
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //co robimy z programem po zamjnieciu okna
		
		JPanel mainJPanel = new JPanel();	//towrzymy glowna panel
			JLabel inputURL = new JLabel(status);	//Komunikat co sie dzieje 
			
			mainJPanel.add(inputURL);
		this.add(mainJPanel);	
		
		this.setVisible(true); 	//robimy okno widoczne
	}
	
	public void setStatus(final String status)
	{
		this.setTitle(status);
	}
}
