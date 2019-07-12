package ps;
import java.util.HashMap;
import java.util.Map;
/**
*
* @author Matheus Lindino
*/
public class SymbolTable
{
	private Map<String, Integer> table;

	public SymbolTable()
	{
		this.table = new HashMap<String, Integer>();
	}

	public int getSymbolEnd(String symbol)
	{
		if(table.get(symbol) != null)
		{
			return table.get(symbol);
		}
		else
		{
			return -1;
		}
	}

	public void insertSymbol(String symbol, int value)
	{
		Integer n;
		n = value;
		table.put(symbol, n);
	}
}