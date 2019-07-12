package ps;

import java.util.Scanner;

/**
 *
 * @author Matheus Lindino
 */
public class Binario {
    
    private String inicial;
    private Boolean label;
    private String comp;
    private String dest;
    private String jump;
    private Boolean a;
    private String binario;
    
    private Scanner ler = new Scanner(System.in);

    Binario() {
        this.comp = "";
        this.dest = "";
        this.jump = "";
        this.a = false;
        this.inicial = "";
        this.binario = "";
        this.label = false;
    }
    
    Binario(String binario) {
        this.inicial = "";
        this.comp = "";
        this.dest = "";
        this.jump = "";
        this.a = false;
        this.label = false;
        this.binario = binario;       
        separaArquivo();  //vai dividir os bits 
       // System.out.println(   this.comp+ " " + this.dest + this.inicial + this.jump);
    }
    
    private void separaArquivo(){   //pega o binario completo e separa em inicial (A OU C), comp, dest e jump
        System.out.println(this.binario);
        this.inicial = this.binario.substring(0, 3);
        
        this.comp = this.binario.substring(4, 10);
        this.dest = this.binario.substring(10, 13);
        this.jump = this.binario.substring(13);
        
        if (this.inicial.equals("000")){
            this.label = true;
        }
        else this.label = false;
        
        if (this.binario.charAt(3) == '1'){
            this.a = true;
        }
        else this.a =false;
    }
    
    private String normalizaBits(String binario){
        
        binario = binario.replaceAll(" ", "");
        
        return binario;
    }

    public String getComp() {
        return comp;
    }

    public String getDest() {
        return dest;
    }

    public String getJump() {
        return jump;
    }

    public String getBinario() {
        return binario;
    }
    
    public String getInicial() {
        return inicial;
    }
    
    public Boolean getLabel() {
        return label;
    }
    public Boolean getA() {
        return a;
    }
    
    
    
               
}
