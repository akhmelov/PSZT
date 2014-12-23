/**
 * 
 */
package pszt.view;

import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pszt.common.events.MyEvent;

/**
 * @author pk
 *
 */
class Start extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Start(final BlockingQueue<MyEvent> blockingQueue,final JFrame jFrame)
	{	
		JPanel mainJPanel = new JPanel();	//towrzymy glowna panel
			JButton openFileButton = new JButton("Open file");
			
			
			openFileButton.addActionListener(new OpenFileActionListener(jFrame, blockingQueue));
		mainJPanel.add(openFileButton);
		this.add(mainJPanel);	
	}
}
