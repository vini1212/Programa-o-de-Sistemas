package ps;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
*
* @author Matheus Lindino
*/
public class Montador
{
    private Map<String, Integer> mem;
    private SymbolTable table;
    private Map<String, String> assemblerComp;
    private Map<String, String> assemblerJump;
    private Map<String, String> assemblerDest;
    private String filename;
    private List<String> memVar;

    public Montador(String filename)
    {
        this.mem = new HashMap<>();
        this.table = new SymbolTable();
        this.assemblerComp = new HashMap<>();
        this.assemblerJump = new HashMap<>();
        this.assemblerDest = new HashMap<>();
        this.filename = filename;
        this.memVar = new ArrayList<>();
        iniciateAssembler();
    }

    //Mapea cada instrução, variavel e codigo de maquina do hacks
    private void iniciateAssembler()
    {
        this.assemblerComp.put("0", "0101010");
        this.assemblerComp.put("1", "0111111");
        this.assemblerComp.put("-1","0111010");
        this.assemblerComp.put("D", "0001100");
        this.assemblerComp.put("A", "0110000");
        this.assemblerComp.put("!D","0001101");
        this.assemblerComp.put("!A","0110001");
        this.assemblerComp.put("-D","0001111");
        this.assemblerComp.put("-A","0110011");
        this.assemblerComp.put("D+1","0011111");
        this.assemblerComp.put("A+1","0110111");
        this.assemblerComp.put("A-1","0110010");
        this.assemblerComp.put("D-1","0001110");
        this.assemblerComp.put("D+A","0000010");
        this.assemblerComp.put("D-A","0010011");
        this.assemblerComp.put("A-D","0000111");
        this.assemblerComp.put("D&A","0000000");
        this.assemblerComp.put("D|A","0010101");
        this.assemblerComp.put("M","1110000");
        this.assemblerComp.put("!M","1110001");
        this.assemblerComp.put("M+1","1110111");
        this.assemblerComp.put("M-1","1110010");
        this.assemblerComp.put("D+M","1000010");
        this.assemblerComp.put("D-M","1010011");
        this.assemblerComp.put("M-D","1000111");
        this.assemblerComp.put("D&M","1000000");
        this.assemblerComp.put("D|M","1010101");

        this.assemblerDest.put("M","001");
        this.assemblerDest.put("D","010");
        this.assemblerDest.put("MD","011");
        this.assemblerDest.put("A","100");
        this.assemblerDest.put("AM","101");
        this.assemblerDest.put("AD","110");
        this.assemblerDest.put("AMD","111");

        this.assemblerJump.put("JGT","001");
        this.assemblerJump.put("JEQ","010");
        this.assemblerJump.put("JLT","100");
        this.assemblerJump.put("JNE","101");
        this.assemblerJump.put("JLE","110");
        this.assemblerJump.put("JMP","111");
    }

    public static boolean isNumeric(String str)
    {
            for(char c : str.toCharArray())
            {
                    if(!Character.isDigit(c))
                    {
                            return false;
                    }
            }
            return true;
    }

//Cria  a tabela
    public void createTable(String line, int pc)
    {
        if(line.charAt(0) == '(' && !isNumeric((line.charAt(1)+"")) && line.charAt(line.length()-1) == ')')
        {
                String symbol;
                symbol = line.substring(1, line.length() - 1);
                table.insertSymbol(symbol, pc);
        }
        else
        {
            String key;
            if(line.charAt(0) == '@')
            {
                key = line.substring(1);
                if(isNumeric(key) == false)
                {
                    if(table.getSymbolEnd(key) == -1)
                        table.insertSymbol(key, -1);
                }
            }
        }
    }

    public String translateLine(String line)
    {
        String key;
        if(line.charAt(0) == '@')
        {
            if(isNumeric(line.substring(1)))
            {
                key = line.substring(1);
                Integer i;
                i = Integer.parseInt(key);
                key = Integer.toBinaryString(i);
                while(key.length() < 16)
                {
                    key = '0' + key;
                }
            }
            else
            {
                if(table.getSymbolEnd(line.substring(1)) == -1)
                {
                    if(memVar.size() == 15) 
                    {
                        memVar.remove(0);
                    }
                    if(memVar.contains(line.substring(1)))
                    {
                        Integer i;
                        i = memVar.indexOf(line.substring(1));
                        key = Integer.toBinaryString(i);
                        while(key.length() < 16)
                        {
                            key = '0' + key;
                        }
                    }
                    else
                    {
                        memVar.add(line.substring(1));
                        Integer i;
                        i = memVar.indexOf(line.substring(1));
                        key = Integer.toBinaryString(i);
                        while(key.length() < 16)
                        {
                            key = '0' + key;
                        }
                    }
                }
                else
                {
                    Integer i;
                    i = table.getSymbolEnd(line.substring(1));
                    key = Integer.toBinaryString(i);
                    while(key.length() < 16)
                    {
                        key = '0' + key;
                    }
                }
        }
    }

       //Define o destino a operação e o jump em cada instrução
    else
    {
        String comp;
        String dest;
        String jump;
        if(!line.contains("="))
        {
           dest = "000";
           comp = assemblerComp.get(line.substring(0,line.indexOf(';')));
           jump = assemblerJump.get(line.substring(line.indexOf(';')+1));
        }
        else
        {
            if(!line.contains(";"))
            {
                dest = assemblerDest.get(line.substring(0, line.indexOf('=')));
                comp = assemblerComp.get(line.substring(line.indexOf('=')+1));
                jump = "000";
            }
            else
            {
                dest = assemblerDest.get(line.substring(0, line.indexOf('=')));
                comp = assemblerComp.get(line.substring(line.indexOf('=')+1,line.indexOf(';') ));
                jump = assemblerJump.get(line.substring(line.indexOf(';')+1));
            }
        }
       key = "111" + comp + dest + jump;

       //Caso não tiver o numero necessário de bits, intrução inválida
       if(key.length() < 16)
            {
                return null;
            }
   }
   return key;
}

}
