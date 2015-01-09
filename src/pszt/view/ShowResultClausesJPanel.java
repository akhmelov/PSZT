package pszt.view;

import java.awt.ScrollPane;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import pszt.model.clause.Clause;
import pszt.model.clause.KnowledgeBase;

public class ShowResultClausesJPanel extends ScrollPane
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
	public ShowResultClausesJPanel(final KnowledgeBase knowledgeBase)
	{ 
		//this.setLayout(new BorderLayout());
		JScrollPane jScrollPane = new JScrollPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("PSZT");
			DefaultMutableTreeNode clauses = new DefaultMutableTreeNode("Clauses");
			clauses.add(
					parseTreeClause(knowledgeBase.getListClauses().get(
							knowledgeBase.getListClauses().size() - 1)));
			//for (Clause clause : knowledgeBase.getListClauses())
			//{	//tworzymy drzewo klauzul
			//	clauses.add(parseTreeClause(clause));
			//}
			DefaultMutableTreeNode theses = new DefaultMutableTreeNode(knowledgeBase.getThesis().toString());
		root.add(clauses);
		root.add(theses);
		
		JTree jTree = new JTree(root);
		jScrollPane.add(jTree);
		this.add(jTree);
	}
	
	/**
	 * Buduje z wyprowadzonych klauzul drzewo
	 * 
	 * @param clause klazula ktora zostanie rozebrana na dzieci
	 * @return zwraca wezel drzewa na odpowiednim poziomie rozmioru klauzul
	 */
	private DefaultMutableTreeNode parseTreeClause(final Clause clause)
	{
		if(clause == null)	//jest koniec drzewa, nie ma dalej czego rozbierac
			return null;
		DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(clause);
		DefaultMutableTreeNode tmp;
		tmp = parseTreeClause(clause.getLeftNodeTree()); //rozbieramy lewe podrzewo
		if(tmp != null)	
		{
			treeNode.add(tmp);
		}
		tmp = parseTreeClause(clause.getRightNodeTree()); //rozbieramy prawe podrzewo
		if(tmp != null)
			treeNode.add(tmp);
		return treeNode;
	}
}
