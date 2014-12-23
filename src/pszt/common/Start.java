package pszt.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import pszt.common.events.MyEvent;
import pszt.controller.Controller;
import pszt.model.Model;
import pszt.view.View;

public class Start 
{
	public static void main(String[] args)
	{
		BlockingQueue<MyEvent> blockingQueue = new LinkedBlockingQueue<MyEvent>();	//tworzenie kolejki
		Model model = new Model();
		View view = new View(blockingQueue);
		Controller controller = new Controller(view, model, blockingQueue);
		
		controller.start();	//uruchamiamy kontroler
	}
}
