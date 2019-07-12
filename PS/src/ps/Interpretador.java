package ps;
import java.util.List;

/**
 *
 * @author Christian Gressler
 */
public class Interpretador{
    private Binario[] bin;
    private int M, A, D, operation, counter = 0;

    public int getM() {
        return M;
    }

    public int getA() {
        return A;
    }

    public int getD() {
        return D;
    }

    public Interpretador(List<String> input, int M, int A, int D)
    {
       
        bin = new Binario[input.size() -1 ];
        
        this.M = M;
        this.A = A;
        this.D = D;
        
        for(int i = 0; i < input.size() - 1;i++)
        {
            
                System.out.println(input.get(i));
                bin[i] = new Binario(input.get(i));
          
        }
    }
    
    void interpretar()
    {
        for(int i = 0; i < bin.length; i++)
        {
            if(bin[i].getLabel())       
            {
                //System.out.println(Integer.parseInt(s)bin[i].getBinario());
                A = Integer.parseInt(bin[i].getBinario());
            }
            else
            {
                if(bin[i].getA())
                {
                    if(bin[i].getComp() == "101010")
                    {
                        operation = 0;
                    }
                    else if(bin[i].getComp() == "111111")
                    {
                        operation = 1;
                    }
                    else if(bin[i].getComp() == "111010")
                    {
                        operation = -1;
                    }
                    else if(bin[i].getComp() == "001100")
                    {
                        operation = D;
                    }
                    else if(bin[i].getComp() == "110000")
                    {
                        operation = A;
                    }        
                    else if(bin[i].getComp() == "001101")
                    {
                        operation = -D - 1;
                    }
                    else if(bin[i].getComp() == "110001")
                    {
                        operation = -A - 1;
                    }
                    else if(bin[i].getComp() == "001111")
                    {
                        operation = -D;
                    }
                    else if(bin[i].getComp() == "110011")
                    {
                        operation = -A;
                    }
                    else if(bin[i].getComp() == "011111")
                    {
                        operation = D + 1;
                    }
                    else if(bin[i].getComp() == "110111")
                    {
                        operation = A + 1;
                    }
                    else if(bin[i].getComp() == "001110")
                    {
                        operation = D - 1;
                    }
                    else if(bin[i].getComp() == "110010")
                    {
                        operation = A - 1;
                    }
                    else if(bin[i].getComp() == "000010")
                    {
                        operation = D + A;
                    }
                    else if(bin[i].getComp() == "010011")
                    {
                        operation = D - A;
                    }
                    else if(bin[i].getComp() == "000111")
                    {
                        operation = A - D;
                    }
                    else if(bin[i].getComp() == "000000")
                    {
                        operation = D & A;
                    }
                    else if(bin[i].getComp() == "010101")
                    {
                        operation = D | A;
                    }
                }
                else
                {
                    if(bin[i].getComp() == "110000")
                    {
                        operation = M;
                    }
                    else if(bin[i].getComp() == "110001")
                    {
                        operation = -M - 1;
                    }
                    else if(bin[i].getComp() == "110011")
                    {
                        operation = -M;
                    }
                    else if(bin[i].getComp() == "110111")
                    {
                        operation = M + 1;
                    }
                    else if(bin[i].getComp() == "110010")
                    {
                        operation = M - 1;
                    }
                    else if(bin[i].getComp() == "000010")
                    {
                        operation = D + M;
                    }
                    else if(bin[i].getComp() == "010011")
                    {
                        operation = D - M;
                    }
                    else if(bin[i].getComp() == "000111")
                    {
                        operation = M - D;
                    }
                    else if(bin[i].getComp() == "000000")
                    {
                        operation = D & M;
                    }
                    else if(bin[i].getComp() == "010101")
                    {
                        operation = D | M;
                    }
                }

                if(bin[i].getDest() == "001")
                {
                    M = operation;
                }
                else if(bin[i].getDest() == "010")
                {
                    D = operation;
                }
                else if(bin[i].getDest() == "011")
                {
                    M = operation;
                    D = operation;
                }
                else if(bin[i].getDest() == "100")
                {
                    A = operation;
                }
                else if(bin[i].getDest() == "101")
                {
                    A = operation;
                    M = operation;
                }
                else if(bin[i].getDest() == "110")
                {
                    A = operation;
                    D = operation;
                }
                else if(bin[i].getDest() == "111")
                {
                    A = operation;
                    D = operation;
                    M = operation;
                }

                if(bin[i].getJump() == "001")
                {
                    if(operation > 0)
                    {
                        i = A;
                    }
                }
                else if(bin[i].getJump() == "010")
                {
                    if(operation == 0)
                    {
                        i = A;
                    }
                }
                else if(bin[i].getJump() == "011")
                {
                    if(operation >= 0)
                    {
                        i = A;
                    }
                }
                else if(bin[i].getJump() == "100")
                {
                    if(operation < 0)
                    {
                        i = A;
                    }
                }
                else if(bin[i].getJump() == "101")
                {
                    if(operation != 0)
                    {
                        i = A;
                    }
                }
                else if(bin[i].getJump() == "110")
                {
                    if(operation <= 0)
                    {
                        i = A;
                    }
                }
                else if(bin[i].getJump() == "111")
                {
                    i = A;
                }
            }
        }
    }
    
    void interpretarPaP()
    {
        int i = counter;
        if(bin[i].getLabel())       
        {
           A = Integer.parseInt(bin[i].getBinario());
        }
        else
        {
            if(bin[i].getA())
            {
                if(bin[i].getComp() == "101010")
                {
                    operation = 0;
                }
                else if(bin[i].getComp() == "111111")
                {
                    operation = 1;
                }
                else if(bin[i].getComp() == "111010")
                {
                    operation = -1;
                }
                else if(bin[i].getComp() == "001100")
                {
                    operation = D;
                }
                else if(bin[i].getComp() == "110000")
                {
                    operation = A;
                }        
                else if(bin[i].getComp() == "001101")
                {
                    operation = -D - 1;
                }
                else if(bin[i].getComp() == "110001")
                {
                    operation = -A - 1;
                }
                else if(bin[i].getComp() == "001111")
                {
                    operation = -D;
                }
                else if(bin[i].getComp() == "110011")
                {
                    operation = -A;
                }
                else if(bin[i].getComp() == "011111")
                {
                    operation = D + 1;
                }
                else if(bin[i].getComp() == "110111")
                {
                    operation = A + 1;
                }
                else if(bin[i].getComp() == "001110")
                {
                    operation = D - 1;
                }
                else if(bin[i].getComp() == "110010")
                {
                    operation = A - 1;
                }
                else if(bin[i].getComp() == "000010")
                {
                    operation = D + A;
                }
                else if(bin[i].getComp() == "010011")
                {
                    operation = D - A;
                }
                else if(bin[i].getComp() == "000111")
                {
                    operation = A - D;
                }
                else if(bin[i].getComp() == "000000")
                {
                    operation = D & A;
                }
                else if(bin[i].getComp() == "010101")
                {
                    operation = D | A;
                }
            }
            else
            {
                if(bin[i].getComp() == "110000")
                {
                    operation = M;
                }
                else if(bin[i].getComp() == "110001")
                {
                    operation = -M - 1;
                }
                else if(bin[i].getComp() == "110011")
                {
                    operation = -M;
                }
                else if(bin[i].getComp() == "110111")
                {
                    operation = M + 1;
                }
                else if(bin[i].getComp() == "110010")
                {
                    operation = M - 1;
                }
                else if(bin[i].getComp() == "000010")
                {
                    operation = D + M;
                }
                else if(bin[i].getComp() == "010011")
                {
                    operation = D - M;
                }
                else if(bin[i].getComp() == "000111")
                {
                    operation = M - D;
                }
                else if(bin[i].getComp() == "000000")
                {
                    operation = D & M;
                }
                else if(bin[i].getComp() == "010101")
                {
                    operation = D | M;
                }
            }

            if(bin[i].getDest() == "001")
            {
                M = operation;
            }
            else if(bin[i].getDest() == "010")
            {
                D = operation;
            }
            else if(bin[i].getDest() == "011")
            {
                M = operation;
                D = operation;
            }
            else if(bin[i].getDest() == "100")
            {
                A = operation;
            }
            else if(bin[i].getDest() == "101")
            {
                A = operation;
                M = operation;
            }
            else if(bin[i].getDest() == "110")
            {
                A = operation;
                D = operation;
            }
            else if(bin[i].getDest() == "111")
            {
                A = operation;
                D = operation;
                M = operation;
            }

            if(bin[i].getJump() == "001")
            {
                if(operation > 0)
                {
                    counter = A - 1;
                }
            }
            else if(bin[i].getJump() == "010")
            {
                if(operation == 0)
                {
                    counter = A - 1;
                }
            }
            else if(bin[i].getJump() == "011")
            {
                if(operation >= 0)
                {
                    counter = A - 1;
                }
            }
            else if(bin[i].getJump() == "100")
            {
                if(operation < 0)
                {
                    counter = A - 1;
                }
            }
            else if(bin[i].getJump() == "101")
            {
                if(operation != 0)
                {
                    counter = A - 1;
                }
            }
            else if(bin[i].getJump() == "110")
            {
                if(operation <= 0)
                {
                    counter = A - 1;
                }
            }
            else if(bin[i].getJump() == "111")
            {
                counter = A - 1;
            }

            
        }
        counter++;
    }
}
