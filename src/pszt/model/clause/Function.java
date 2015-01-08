package pszt.model.clause;

import java.util.ArrayList;

/**
 * Klasa definujaca f-cje
 * 
 * @author pk - robilem tylko czesc
 *
 */
public class Function extends Term 
{

	/**
	 * Tu sa przechowywane termy, ktore sa dostarczane do f-cji jako parametry
	 */
	ArrayList<Term> lista;
	public Function()
	{
		type = 3;
		lista = new ArrayList<Term>();
	}
	
	public void addNewTerm(final Term term)
	{
		lista.add(term);
	}
	
	@Override
	public boolean unify(Term b, Substitution sub1, Substitution sub2)
	{
		Term a = this.substitute(sub1);
		b = b.substitute(sub2);
		
		//Jezeli a jest stala i b jest stala o tej samej nazwie to true
		if (a.type == 1 && b.type == 1 && b.getName().equals(a.getName()))
			return true;
		//Jezeli a jest stala, a b inna stala lub innym termem to false
		if (a.type == 1)
			return false;
		
		//Jezeli b jest funkcja i a jest zmienna to false
		if (b.type == 2 && a.type == 3)
			return false;
		
		//Jezeli b jest funkcja i a jest taka sama funkcja to podstaw argumenty
		if (a.type == 3 && b.type == 3 && b.getName().equals(a.getName()))
		{
			Function funa = (Function)a;
			Function funb = (Function)b;
			for (int i = 0; i < funa.lista.size(); ++i)
			{
				Term at = funa.lista.get(i);
				Term bt = funb.lista.get(i);
				
				if (!at.unify(bt, sub1, sub2) && !bt.unify(at, sub1, sub2))
					return false;
			}
		}
		
		return false;
	}

	@Override
	public Term substitute(Substitution sub)
	{
		//Sprawdz, czy podstawiamy stala
		Term s = sub.substitute(this);
		if (s.type == 1)
			return s;
		
		//Podstaw wszystkie argumenty
		for (Term i : lista)
			i.substitute(sub);
		
		return this;
	}

	public boolean equals(Term b)
	{
		return false;
	}
	
	@Override
	public String toString()
	{
		if(lista.isEmpty())	//lista jest pusta, nie ma sensu wykonywac te f-cje
			return "";
		String tmp = name;
		tmp += "(";
		for (Term term : lista)
		{
			tmp += term.toString();
			tmp += ",";
		}
		if(tmp.charAt(tmp.length() - 1) == ',')
			tmp = tmp.substring(0, tmp.length() - 1);	//usuwamy przecinek, nie ma argumentow wiecej po nim
		tmp += ")";
		return tmp;
	}
}
