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
 */
class SelectedAlgorithm2Strategy extends Strategy
{
	private Model model;
	private View view;
	/**
	 * 
	 */
	public SelectedAlgorithm2Strategy(final Model model, final View view)
	{
		this.model = model;
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see pszt.controller.Strategy#perform(pszt.common.events.MyEvent)
	 */
	@Override
	public void perform(MyEvent event)
	{
		view.setResult(model.runAlgorithm2(model.getKnowledgeBase()));
	}

}
