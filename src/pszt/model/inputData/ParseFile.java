/**
 * 
 */
package pszt.model.inputData;

import java.io.File;
import java.io.IOException;

import javax.management.InvalidAttributeValueException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import pszt.model.clause.Clause;
import pszt.model.clause.Constant;
import pszt.model.clause.Function;
import pszt.model.clause.KnowledgeBase;
import pszt.model.clause.Predicate;
import pszt.model.clause.Variable;

/**
 * Parsuje plik xml przetwarzajac go na danne wejsciowe
 * 
 * @author pk
 *
 */
public class ParseFile
{
	/**
	 * Plik ktory prasujemy
	 */
	private final File fileInput;
	/**
	 * Otwiera plik do prasowania i zarzadza nim
	 * 
	 * @param pathFile droga do pliku ktory bedziemy pracowac
	 */
	public ParseFile(final String pathFile)
	{
		fileInput = new File(pathFile);
	}
	
	public KnowledgeBase run() throws InvalidAttributeValueException 
	{
		KnowledgeBase knowledgeBase = new KnowledgeBase();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Document document = null;
		try
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(fileInput);
		}
		catch (ParserConfigurationException | SAXException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = document.getDocumentElement();	//tu musi byc zwracane PSZT z XML
		if(!root.getTagName().equalsIgnoreCase("PSZT"))
		{
			throw new InvalidAttributeValueException("Nie ten plik XML albo nie poprawna struktura");
		}
		parseKnowlBase(root.getFirstChild().getNextSibling(), knowledgeBase);	//parsujemy kauzury
		parseTheses(root.getLastChild().getPreviousSibling(), knowledgeBase); //parsujemy teze
		return knowledgeBase;
	}
	
	/**
	 * Przetwarza baze wiedzy z dzieci drzewa elementu przekazanego i dodaje do obiektu 
	 * odpowiedzniego przekazanego jako referencje
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci klauzor z bazy wiedzy
	 * @param knowledgeBase	obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parseKnowlBase(final Node node, KnowledgeBase knowledgeBase) throws InvalidAttributeValueException
	{
		if(!node.getNodeName().equalsIgnoreCase("BaseKnowles"))
		{
			throw new InvalidAttributeValueException("W pliku XML zamiast BaseKnowles jest: " + node.getNodeName());
		}
		for(int i = 0; i < node.getChildNodes().getLength(); ++i)
		{
			if(!(node.getChildNodes().item(i) instanceof Element))
			{
				continue;
			}
			Clause clause = new Clause();
			boolean isNegatve = false;
			if(node.getAttributes().getNamedItem("negative") != null && 
					node.getAttributes().getNamedItem("negative").getNodeValue().equalsIgnoreCase("true"))
			{
				isNegatve = true;
			}
			clause.setNegative(isNegatve);
			parseClause(node.getChildNodes().item(i), clause);	//parsujemy kauzure
			knowledgeBase.addNewClause(clause); //dodajemy nowo utworzana klauzure do bazy wiedzy
		}
	}
	/**
	 * Parsuje klauzure dodajac ja do drugiego parametru  
	 * 
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci klauzor z bazy wiedzy
	 * @param clause	obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parseClause(final Node node, Clause clause) throws InvalidAttributeValueException
	{
		if(!node.getNodeName().equalsIgnoreCase("Clause"))
		{
			throw new InvalidAttributeValueException("W pliku XML zamiast Clause jest: " + node.getNodeName());
		}
		for(int i = 0; i < node.getChildNodes().getLength(); ++i)
		{
			if(!(node.getChildNodes().item(i) instanceof Element))
			{
				continue;
			}
			Node tmpNode = node.getChildNodes().item(i);
			String name = tmpNode.getAttributes().getNamedItem("name").getNodeValue();
			boolean isNegatve = false;
			if(tmpNode.getAttributes().getNamedItem("negative") != null && 
					tmpNode.getAttributes().getNamedItem("negative").getNodeValue().equalsIgnoreCase("true"))
			{
				isNegatve = true;
			}
			Predicate predicate = new Predicate(name, isNegatve);
			parsePredicate(tmpNode, predicate);	//parsujemy kauzure
			clause.addPredicate(predicate); 
		}
	}
	/**
	 * Parsuje predykat
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci klauzor z bazy wiedzy
	 * @param predicate	obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parsePredicate(final Node node, Predicate predicate) throws InvalidAttributeValueException
	{
		if(!node.getNodeName().equalsIgnoreCase("Predicate"))
		{
			throw new InvalidAttributeValueException("W pliku XML zamiast Predicate jest: " + node.getNodeName());
		}
		for(int i = 0; i < node.getChildNodes().getLength(); ++i)
		{
			Node tmpNode = node.getChildNodes().item(i);
			if(!(tmpNode instanceof Element))
			{	//tmpNode jest zwyklym tekstem, to nam nie jest potrzebne
				continue;
			}
			//czy ten term ma negacje w sobie
			boolean isNegative = false;
			if(tmpNode.getAttributes().getNamedItem("negative") != null && 
					tmpNode.getAttributes().getNamedItem("negative").getNodeValue().equalsIgnoreCase("true"))
			{
				isNegative = true;
			}
			if(tmpNode.getNodeName().equalsIgnoreCase("Variable"))
			{	//parsujemy zmienna
				Variable variable = new Variable();
				variable.setNegative(isNegative);
				parseVariable(tmpNode, variable);
				predicate.addNewTerm(variable);
			}
			else if(tmpNode.getNodeName().equalsIgnoreCase("Constant"))
			{	//prasujemy stala
				Constant constant = new Constant();
				constant.setNegative(isNegative);
				parseConstant(tmpNode, constant);
				predicate.addNewTerm(constant);
			}
			else if(tmpNode.getNodeName().equalsIgnoreCase("Function"))
			{	//prasujemy f-cje
				Function function = new Function();
				function.setNegative(isNegative);
				parseFunction(tmpNode, function);
				if(function.getName() != null)
				{	//czy udalo sie sprasowac jeszcze raz f-cje? gdy name == null to znaczy, ze nie ma co parsowac
					predicate.addNewTerm(function);
				}
			}
			else
			{
				throw new InvalidAttributeValueException("W predykat w pliku XML nie posiada odpowiedniej skladni");
			}
		}
	}
	/**
	 * Parsuje zmienna
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci klauzor z bazy wiedzy
	 * @param variable	obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parseVariable(final Node node, Variable variable) throws InvalidAttributeValueException
	{
		if(!node.getNodeName().equalsIgnoreCase("Variable"))
		{
			throw new InvalidAttributeValueException("W pliku XML zamiast BaseKnowles jest: " + node.getNodeName());
		}
		String name = node.getAttributes().getNamedItem("name").getNodeValue();
		variable.setName(name);
	}
	/**
	 * Parsuje zmienna
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci klauzor z bazy wiedzy
	 * @param constant obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parseConstant(final Node node, Constant constant) throws InvalidAttributeValueException
	{
		if(!node.getNodeName().equalsIgnoreCase("Constant"))
		{
			throw new InvalidAttributeValueException("W pliku XML zamiast BaseKnowles jest: " + node.getNodeName());
		}
		String name = node.getAttributes().getNamedItem("name").getNodeValue();
		constant.setName(name);
	}

	/**
	 * Parsuje f-cj
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci klauzor z bazy wiedzy
	 * @param function obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parseFunction(final Node node, Function function) throws InvalidAttributeValueException
	{
		if(!node.getNodeName().equalsIgnoreCase("Function"))
		{
			throw new InvalidAttributeValueException("W pliku XML zamiast BaseKnowles jest: " + node.getNodeName());
		}
		String name = node.getAttributes().getNamedItem("name").getNodeValue();
		function.setName(name);
		
		for(int i = 0; i < node.getChildNodes().getLength(); ++i)
		{
			Node tmpNode = node.getChildNodes().item(i);
			if(!(tmpNode instanceof Element))
			{	//tmpNode jest zwyklym tekstem, to nam nie jest potrzebne
				continue;
			}
			//czy ten term ma negacje w sobie
			boolean isNegative = false;
			if(tmpNode.getAttributes().getNamedItem("negative") != null && 
					tmpNode.getAttributes().getNamedItem("negative").getNodeValue().equalsIgnoreCase("true"))
			{
				isNegative = true;
			}
			if(tmpNode.getNodeName().equalsIgnoreCase("Variable"))
			{	//parsujemy zmienna
				Variable variable = new Variable();
				variable.setNegative(isNegative);
				parseVariable(tmpNode, variable);
				function.addNewTerm(variable);
			}
			else if(tmpNode.getNodeName().equalsIgnoreCase("Constant"))
			{	//prasujemy stala
				Constant constant = new Constant();
				constant.setNegative(isNegative);
				parseConstant(tmpNode, constant);
				function.addNewTerm(constant);
			}
			else if(tmpNode.getNodeName().equalsIgnoreCase("Function"))
			{	//prasujemy f-cje
				Function functionInside = new Function();
				functionInside.setNegative(isNegative);
				parseFunction(tmpNode, function);	
				if(function.getName() != null)
				{	//czy udalo sie sprasowac jeszcze raz f-cje? gdy name == null to znaczy, ze nie ma co parsowac
					function.addNewTerm(functionInside);
				}
			}
			else
			{
				throw new InvalidAttributeValueException("W predykat w pliku XML nie posiada odpowiedniej skladni");
			}
		}
	}
	/**
	 * Parsuje tagi z teza do udowodnienia z XML
	 * 
	 * @param node z drzewa ktory posiada dzieci w postaci tezy
	 * @param knowledgeBase obiekt gdzie zapisywana jest przetwarzana informacja
	 * @throws InvalidAttributeValueException 
	 */
	private void parseTheses(final Node node, KnowledgeBase knowledgeBase) throws InvalidAttributeValueException
	{
		Clause clause = new Clause();
		parseClause(node.getFirstChild().getNextSibling(), clause);
		knowledgeBase.setThesis(clause);
	}
}
