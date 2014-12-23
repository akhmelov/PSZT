package pszt.common.events;

/**
 * Klasa ktora jest zglaszana kiedy uzytkownik wybiera plik z wejsciowymi klauzurami
 * 
 * @author pk
 *
 */
public class SelectedFileEvent extends MyEvent
{
	/**
	 *	Przechowuje droge do wybranego pliku 
	 */
	private final String pathFile;
	
	/**
	 * @param path droga do wybranego pliku
	 */
	public SelectedFileEvent(final String path)
	{
		pathFile = path;
	}

	/**
	 * @return the pathFile
	 */
	public final String getPathFile()
	{
		return pathFile;
	}

}
