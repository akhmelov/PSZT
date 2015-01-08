/**
 * 
 */
package pszt.view;

import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import pszt.model.clause.Clause;
import pszt.model.clause.KnowledgeBase;

/**
 * @author pk
 *
 */
public class ShowClausesJPanel extends ScrollPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Kontruktor buduje panel ktora zawiera w sobie JTreee z klauzurami oraz teza do wyswietlania
	 * 
	 * @param knowledgeBase wiedza pobrana z pliku
	 */
	public ShowClausesJPanel(final KnowledgeBase knowledgeBase)
	{ 
		//this.setLayout(new BorderLayout());
		JScrollPane jScrollPane = new JScrollPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("PSZT");
			DefaultMutableTreeNode clauses = new DefaultMutableTreeNode("Clauses");
			for (Clause clause : knowledgeBase.getListClauses())
			{	//tworzymy drzewo klauzul
				clauses.add(new DefaultMutableTreeNode(clause.toString()));
			}
			DefaultMutableTreeNode theses = new DefaultMutableTreeNode(knowledgeBase.getThesis().toString());
		root.add(clauses);
		root.add(theses);
		
		JTree jTree = new JTree(root);
		jScrollPane.add(jTree);
		this.add(jTree);
	}
}
