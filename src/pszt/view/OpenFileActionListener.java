package pszt.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import pszt.common.events.MyEvent;
import pszt.common.events.SelectedFileEvent;

/**
 * Jest uzywany dla przciska, ktory sluzy do znalezienia i otwarcia pliku
 * Po stworzeniu tego obiektu automatycznie uruchamia JFileChoose po czym zglasza zdarzenie SelectedFileEvent do kolejki bloackingQueue
 * 
 * @author pk
 * 
 */
class OpenFileActionListener implements ActionListener
{
	private JFrame jFrame;
	private final BlockingQueue<MyEvent> blockingQueue;
	private JFileChooser fileChooser;
	public OpenFileActionListener(JFrame frame,final BlockingQueue<MyEvent> blockingQueue)
	{
		jFrame = frame;
		this.blockingQueue = blockingQueue; 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		fileChooser = new JFileChooser();
		int option = fileChooser.showOpenDialog(jFrame);
		if(option == JFileChooser.APPROVE_OPTION)
		{
			blockingQueue.add(new SelectedFileEvent(fileChooser.getSelectedFile().getPath()));
		}
		else
		{
			System.out.println("Open comander canceled by users");
		}
	}
}
