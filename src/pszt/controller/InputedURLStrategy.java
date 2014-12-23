/**
 * 
 */
package pszt.controller;

import pszt.common.events.MyEvent;
import pszt.model.Model;
import pszt.view.View;

/**
 * @author pk
 *
 *Obsluguje zdarzenie kiedy zostal wprowadzony adress strony internetowej, przekazuje jego do modelu do obslugi
 *
 */
class InputedURLStrategy extends Strategy
{
	private Model model;
	private View view;
	
	/**
	 * Konstruktor inicjalizujacy
	 * 
	 * @param model referencja na model
	 * @param view	referencja na widok
	 */
	public InputedURLStrategy(final Model model, final View view)
	{
		this.model = model;
		this.view = view;
	}
	
	/* (non-Javadoc)
	 * @see tkom.controller.Strategy#perform(tkom.common.events.MyEvent)
	 */
	@Override
	public void perform(MyEvent event)
	{
		view.setWaitingPerformingWindow("Przekazywanie do modelu");
		// TODO Auto-generated method stub
	}

}
