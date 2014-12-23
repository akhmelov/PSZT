package pszt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import pszt.common.events.InputedURLEvent;
import pszt.common.events.MyEvent;
import pszt.common.events.SelectedAlgorithm1Event;
import pszt.common.events.SelectedAlgorithm2Event;
import pszt.common.events.SelectedAlgorithm3Event;
import pszt.common.events.SelectedFileEvent;
import pszt.model.Model;
import pszt.view.View;

public class Controller	extends Thread
{
	private BlockingQueue<MyEvent>	blockingQueue;
	private Model model;
	private View view;
	
	private Map<Class<? extends MyEvent>, Strategy> strategyMap;	//mapa strategij
	
	public Controller(View view, Model model, BlockingQueue<MyEvent> blockingQueue)
	{
		this.view = view;
		this.model = model;
		this.blockingQueue = blockingQueue;
		
		strategyMap = new HashMap<Class<? extends MyEvent>,	Strategy>();	//tworzymy hash mape
		strategyMap.put(SelectedFileEvent.class, new SelectedFileStrategy(model, view));
		strategyMap.put(SelectedAlgorithm1Event.class, new SelectedAlgorithm1Strategy(model, view));
		strategyMap.put(SelectedAlgorithm2Event.class, new SelectedAlgorithm2Strategy(model, view));
		strategyMap.put(SelectedAlgorithm3Event.class, new SelectedAlgorithm3Strategy(model, view));
		//strategyMap.put(InputedURLEvent.class, new InputedURLStrategy(model, view));
	}
	
	@Override
	public void run()
	{	//uruchamiamy watek i czekamy na strategie
		try
		{
			while(true)	//czekamy na strategie
			{
				MyEvent event = blockingQueue.take();	//pobieramy zdarzenie
				strategyMap.get(event.getClass()).perform(event);	//wykanujemy odpowiadajaca strategie
			}
		}
		catch(Exception e)
		{
			System.out.print("Zgloszony wyjatek nie ma strategii do eventa w controller.run: " + e);
		}
		super.run();
	}
}
