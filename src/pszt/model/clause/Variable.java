package pszt.model.clause;

public class Variable extends Term 
{
	private String text;
	
	public Variable()
	{
		type = 2;
	}
	
	@Override
	public boolean unify(Term b, Substitution sub1, Substitution sub2) 
	{
		Term a = this.substitute(sub1);
		Term tmp = b;
		b = b.substitute(sub2);
		
		//Jezeli a jest stala i b jest stala o tej samej nazwie to true
		if (a.type == 1 && b.type == 1 && b.getName().equals(a.getName()))
			return true;
		//Jezeli a jest stala, a b inna stala lub innym termem to false
		if (a.type == 1)
			return false;
		
		//Jezeli a jest zmienna i nie bylo jeszcze zamieniane to podstaw b za a, 
		//ale tylko wtedy, kiedy b tez nie bylo podmieniane
		if (a.type == 2 && a == this && tmp == b)
		{
			sub1.add(a, b);
			return true;
		}
		//Jezeli a jest zmienna i bylo podstawiane to true tylko jesli ponownie to samo podstawienie.
		//Nie dodawac tego samego podstawienia ponownie do listy.
		if (a.type == 2 && b.name.equals(a.name))
			return true;
		
		//Jezeli a jest funkcja i b jest taka sama funkcja, to unifikuj ich argumenty
		if (a.type == 3 && b.type == 3 && b.getName().equals(a.getName()))
			return a.unify(b, sub1, sub2);
		
		//W kazdym innym przypadku false
		return false;
	}

	@Override
	public Term substitute(Substitution sub)
	{
		return sub.substitute(this);
	}

	@Override
	public String toString()
	{
		return name;
	}
}


