/**
 * 
 */
package pszt.view;

import javax.swing.JPanel;

import pszt.model.clause.Data;
import pszt.model.clause.KnowledgeBase;

/**
 * @author pk
 *
 */
class ShowResultJPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShowResultJPanel(final Data data)
	{
		System.out.println("Nie ma implementacji dla tego typu, trzeba stworzyc, albo "
				+ "zwroc obiekt typu knowledBase");
	}
	public ShowResultJPanel(final KnowledgeBase knowledgeBase)
	{
		this.add(new ShowClausesJPanel(knowledgeBase));
	}
}
