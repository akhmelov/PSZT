package pszt.model.clause;

public class Constant extends Term 
{
	
	public Constant()
	{
		type = 1;
	}
	
	@Override
	public boolean unify(Term b, Substitution sub1, Substitution sub2) {
		//Je¿eli b jest stala o tej samej nazwie, to true
		if (b.type == 1 && b.getName().equals(name))
			return true;
		return false;
	}

	@Override
	public Term substitute(Substitution sub)
	{
		return this;
	}

	@Override
	public String toString()
	{
		return name;
	}

}
