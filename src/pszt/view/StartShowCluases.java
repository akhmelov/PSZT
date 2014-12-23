/**
 * 
 */
package pszt.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pszt.common.events.MyEvent;
import pszt.common.events.SelectedAlgorithm1Event;
import pszt.common.events.SelectedAlgorithm2Event;
import pszt.common.events.SelectedAlgorithm3Event;
import pszt.model.clause.KnowledgeBase;

/**
 * @author pk
 *
 */
class StartShowCluases extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param blockingQueue kolejka zglaszania zdarzen
	 * @param knowledgeBase klauzury do wyswietlania
	 */
	public StartShowCluases(BlockingQueue<MyEvent> blockingQueue, final KnowledgeBase knowledgeBase,
			JFrame jFrame) 
	{
		Dimension dimensionWindow = new Dimension(400, 400);
		this.setSize(dimensionWindow);	//ustawiamy rozmiar
		this.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		ShowClausesJPanel showClausesJPanel = new ShowClausesJPanel(knowledgeBase);
		showClausesJPanel.setBackground(Color.GREEN);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.anchor = GridBagConstraints.PAGE_START;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		this.add(showClausesJPanel, gridBagConstraints);
		showClausesJPanel.setSize(dimensionWindow);
		//przyciski dla algorytmow wedlug ktorych chcemy liczyc
		gridBagConstraints = new GridBagConstraints();
		JPanel algorithmsJPanel = new JPanel();
		algorithmsJPanel.setLayout(new GridLayout(3, 0));
		JButton algorithm1JButton = new JButton("Algorithm 1");
		algorithm1JButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				blockingQueue.add(new SelectedAlgorithm1Event());
			}
		});
		algorithmsJPanel.add(algorithm1JButton);
		
		JButton algorithm2JButton = new JButton("Algorithm 2");
		algorithm2JButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				blockingQueue.add(new SelectedAlgorithm2Event());
			}
		});
		algorithmsJPanel.add(algorithm2JButton);
		
		JButton algorithm3JButton = new JButton("Algorithm 3");
		algorithm3JButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				blockingQueue.add(new SelectedAlgorithm3Event());
			}
		});
		algorithmsJPanel.add(algorithm3JButton);
		gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(algorithmsJPanel, gridBagConstraints);
		
		JButton openFileButton = new JButton("Open another file");
		openFileButton.addActionListener(new OpenFileActionListener(jFrame, blockingQueue));
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		this.add(openFileButton, gridBagConstraints);
		this.setVisible(true);
	}
}
