package pszt.view;

import java.awt.Button;
import java.awt.Dimension;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

import pszt.common.events.MyEvent;
import pszt.model.clause.Data;
import pszt.model.clause.KnowledgeBase;

public class View
{
	/**
	 * Kolejka zglaszenia zdarzen
	 */
	private BlockingQueue<MyEvent>	blockingQueue;
	/**
	 * Referencja do obecnego okna
	 */
	private JFrame window;
	
	public View(BlockingQueue<MyEvent> blockingQueue)
	{
		this.blockingQueue = blockingQueue;
		Dimension dimensionWindow = new Dimension(400, 400);
		window = new JFrame();
		window.setTitle("Wprowadz nazwe pliku");	//tworzymy kontener typu jFrame
		window.setSize(dimensionWindow);	//ustawiamy rozmiar
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //co robimy z programem po zamjnieciu okna
		window.setVisible(true);
		setInputWindow();
	}
	
	/**
	 * Ustawia okna w ktorym wprowadzamy adres strony ktora chemy przetworzyc
	 */
	public void setInputWindow()
	{
		JPanel tmpJPanel = new Start(blockingQueue, window); 
		setNewWindow(tmpJPanel, "Select file");
	}
	
	/**
	 * Ustawia okno ktore pokazuje klauzure wejsciowe oraz teze
	 * 
	 * @param knowledgeBase klauzury do wyswietlenia 
	 */
	public void setInputInformation(final KnowledgeBase knowledgeBase)
	{
		JPanel jPanel = new StartShowCluases(blockingQueue, knowledgeBase, window);
		setNewWindow(jPanel, "Content of selected file. Please choose algorithm!");
	}
	/**
	 * Wyswietla wyniki
	 * 
	 * @param data skad ma to wszystko wyswietlic
	 */
	public void setResult(final Data data)
	{
		JPanel jPanel = new ShowResultJPanel(data);
		setNewWindow(jPanel, "Result of calculation");
	}
	/**
	 * Wystwietla wyniki obliczenia algorytmu
	 * 
	 * @param knowledgeBase skad bedziemy brac wyniki do wyswietlenia
	 */
	public void setResult(final KnowledgeBase knowledgeBase)
	{
		JPanel jPanel = new ShowResultJPanel(knowledgeBase);
		setNewWindow(jPanel, "Result of calculation");
	}
	/**
	 * Odswierza okno podmieniajac wyswietlanie w nim na jPanel przekazana przez parametr
	 * 
	 * @param jPanel glowna panel ktora ma zostac podmieniona w obecnym oknie
	 * @param title naglowek wyswietlanego okna
	 */
	private void setNewWindow(JPanel jPanel, final String title)
	{		
		window.getContentPane().removeAll();
		window.add(jPanel);
		window.setTitle(title);
		window.getContentPane().invalidate();
		window.getContentPane().validate();
		window.repaint();
	}
}
