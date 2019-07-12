package ps;
/**
 *
 * @author Matheus Lindino
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PS {
    public static void main(String[] args) {
        
        String file_1 = "/home/lindino/Documentos/5º Semestre/PS/Codigo_1.txt";
        String file_2 = "/home/lindino/Documentos/5º Semestre/PS/Codigo_2.txt";
        String file_out_ligador = "/home/lindino/Documentos/5º Semestre/PS/Saida_Ligador.txt";
        String file_out_macro = "/home/lindino/Documentos/5º Semestre/PS/Saida_Macro.txt";
        String file_out_montador = "/home/lindino/Documentos/5º Semestre/PS/Saida_Montador.txt";
        ProcessadorDeMacros macro;
        ArrayList<String> resul_ligador;
        ArrayList<String> code_1;
        ArrayList<String> code_2;
        List<String> intermediario;
        Montador montador;
        String[] code;
        code = new String[100];
        Ligador ligador;
        String line;
        int pc = 0;
        int i = 0;
        
        code_1 = new ArrayList<>();
        code_2 = new ArrayList<>();
        
        try{
            FileReader file_aux_1 = new FileReader(file_1);
            BufferedReader arq = new BufferedReader(file_aux_1);
            
            line = arq.readLine();
            
            while(line != null)
            {
                if(line.length() > 0 )
                {
                    code_1.add(line);
                } 
                
               line = arq.readLine();
            }
           
           file_aux_1.close();
          
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
        
        try{
            FileReader file_aux_2 = new FileReader(file_2);
            BufferedReader arq = new BufferedReader(file_aux_2);
            
            line = arq.readLine();
            
            while(line != null)
            {
                if(line.length() > 0 )
                {
                    code_2.add(line);
                } 
                
               line = arq.readLine();
            }
           
           file_aux_2.close();
          
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
        
        ligador = new Ligador(code_1, code_2);
        resul_ligador = ligador.ligar();
        //System.out.print(code_1 + "\n" + code_2 + "\n");
        //System.out.print(resul_ligador);
        try
            {
                FileWriter arq  = new FileWriter(file_out_ligador);
                PrintWriter doc = new PrintWriter(arq);
                
                for(String s:resul_ligador){if(!s.isEmpty()){doc.println(s);}}
                
                arq.close();
            }
            catch(IOException e){}
        macro = new ProcessadorDeMacros(file_out_ligador);
        try{
            if(macro.verificaArquivo())
            {
                macro.expandeMacro();
                intermediario = macro.getIntermediario();
    
                try{
                    FileWriter arq = new FileWriter(file_out_macro);
                    PrintWriter doc = new PrintWriter(arq);
                    int k = 0;
                    for(String s: intermediario){ if(!s.isEmpty())doc.println(s); k++;}
                    arq.close();
                    }
                    catch(IOException e){System.out.println(e.getMessage());}
            }
            else
            {
                file_out_macro = file_1;
            }
            
        }
        catch(IOException e){}
        
        montador = new Montador(file_out_macro);
        
        try{
            FileReader filek = new FileReader(file_out_macro);
            BufferedReader arq = new BufferedReader(filek);
            
            line = arq.readLine();
            
            while(line != null)
            {
                if(line.length() > 0 )
                {
                    montador.createTable(line, pc);
                    if(!line.contains("(")) pc += 2;
                } 
                
               line = arq.readLine();
            }
           
           filek.close();
          
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
        
        try{
            
            FileReader filek = new FileReader(file_out_macro);
            BufferedReader arq = new BufferedReader(filek);
            
            line = arq.readLine();
         
            while(line != null)
            {
                if(line.length() > 0 && !line.contains("(") )
                {
                    code[i++] = montador.translateLine(line);
                    
                } 
                
               line = arq.readLine();
            }
           
           filek.close();
          
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
        
        FileWriter write;
        try {
            write = new FileWriter(file_out_montador);
            PrintWriter writeDoc = new PrintWriter(write);
           
           for(int j = 0;j < i;j++){writeDoc.println(code[j]);}
           write.close();
        }
        
        catch (IOException ex) {
            Logger.getLogger(PS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
}