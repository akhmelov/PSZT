/**
 * 
 */
package pszt.controller;

import pszt.common.events.MyEvent;
import pszt.common.events.SelectedFileEvent;
import pszt.model.Model;
import pszt.view.View;

/**
 * Wykonuje strategie kiedy jest wybrany plik z wejsciowymi danymi
 * 
 * @author pk
 *
 */
public class SelectedFileStrategy extends Strategy
{
	private Model model;
	private View view;
	/**
	 * 
	 */
	public SelectedFileStrategy(final Model model, final View view)
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
		model.runParsingFile(((SelectedFileEvent)event).getPathFile());
		view.setInputInformation(model.getKnowledgeBase());
	}

}
