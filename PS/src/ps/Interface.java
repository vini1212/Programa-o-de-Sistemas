package ps;
/**
 *
 * @author Matheus Antoniolli
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {

    private int i = 0, pc = 0, op = 0;
    private String aux = "", arq1 = "", arq2 = "", codMacro = "", line;
    private String file_out_macro = "/home/lindino/Documentos/5º Semestre/PS/Saida_Macro.txt";
    private String file_out_montador = "/home/lindino/Documentos/5º Semestre/PS/Saida_Montador.txt";
    private String[] code;
    private ArrayList<String> cod1, cod2, codComposto;
    private Ligador lgd;
    private String file_out_ligador = "/home/lindino/Documentos/5º Semestre/PS/Saida_Ligador.txt";
    List<String> intermediario;
    private ProcessadorDeMacros pmc;
    private Montador mtd;
    private Interpretador inter; 

    public Interface() {
        initComponents();
        this.cod1 = new ArrayList<>();
        this.cod2 = new ArrayList<>();
        this.codComposto = new ArrayList<>();
        code = new String[100];
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abrirArq = new javax.swing.JFileChooser();
        jFrame1 = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        background = new javax.swing.JPanel();
        textoEntrada = new javax.swing.JPanel();
        scrollPaneEntrada = new javax.swing.JScrollPane();
        areaTextoEntrada = new javax.swing.JTextArea();
        textoSaida = new javax.swing.JPanel();
        scrollPaneSaida = new javax.swing.JScrollPane();
        areaTextoSaida = new javax.swing.JTextArea();
        botoesComeco = new javax.swing.JPanel();
        executar = new javax.swing.JButton();
        arq1Btn = new javax.swing.JButton();
        arq2Btn = new javax.swing.JButton();
        labelEntrada = new javax.swing.JLabel();
        labelSaida = new javax.swing.JLabel();
        botoesAcao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRegistadores = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaInterpretada = new javax.swing.JTable();
        ligadorBtn = new javax.swing.JButton();
        montadorBtn = new javax.swing.JButton();
        macroBtn = new javax.swing.JButton();
        botaoExecucaoPassoAPasso = new javax.swing.JToggleButton();
        barraMenu = new javax.swing.JMenuBar();
        Arquivo = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        textoEntrada.setPreferredSize(new java.awt.Dimension(650, 614));

        areaTextoEntrada.setColumns(20);
        areaTextoEntrada.setRows(5);
        scrollPaneEntrada.setViewportView(areaTextoEntrada);

        javax.swing.GroupLayout textoEntradaLayout = new javax.swing.GroupLayout(textoEntrada);
        textoEntrada.setLayout(textoEntradaLayout);
        textoEntradaLayout.setHorizontalGroup(
            textoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textoEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        textoEntradaLayout.setVerticalGroup(
            textoEntradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textoEntradaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        textoSaida.setPreferredSize(new java.awt.Dimension(650, 614));

        areaTextoSaida.setColumns(20);
        areaTextoSaida.setRows(5);
        scrollPaneSaida.setViewportView(areaTextoSaida);

        javax.swing.GroupLayout textoSaidaLayout = new javax.swing.GroupLayout(textoSaida);
        textoSaida.setLayout(textoSaidaLayout);
        textoSaidaLayout.setHorizontalGroup(
            textoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textoSaidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        textoSaidaLayout.setVerticalGroup(
            textoSaidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textoSaidaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );

        executar.setText("Executar");
        executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executarActionPerformed(evt);
            }
        });

        arq1Btn.setText("Arq.1");
        arq1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arq1BtnActionPerformed(evt);
            }
        });

        arq2Btn.setText("Arq.2");
        arq2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arq2BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botoesComecoLayout = new javax.swing.GroupLayout(botoesComeco);
        botoesComeco.setLayout(botoesComecoLayout);
        botoesComecoLayout.setHorizontalGroup(
            botoesComecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesComecoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arq1Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arq2Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(executar)
                .addContainerGap())
        );
        botoesComecoLayout.setVerticalGroup(
            botoesComecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesComecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botoesComecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arq1Btn)
                    .addComponent(executar)
                    .addComponent(arq2Btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelEntrada.setText("Codigo de entrada");

        labelSaida.setText("Codigo de saida:");

        tabelaRegistadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A", null},
                {"D", null},
                {"M", null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaRegistadores);

        tabelaInterpretada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Linha", "Objeto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelaInterpretada);

        javax.swing.GroupLayout botoesAcaoLayout = new javax.swing.GroupLayout(botoesAcao);
        botoesAcao.setLayout(botoesAcaoLayout);
        botoesAcaoLayout.setHorizontalGroup(
            botoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesAcaoLayout.createSequentialGroup()
                .addGroup(botoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(botoesAcaoLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        botoesAcaoLayout.setVerticalGroup(
            botoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesAcaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ligadorBtn.setText("Ligador");
        ligadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ligadorBtnActionPerformed(evt);
            }
        });

        montadorBtn.setText("Montador");
        montadorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montadorBtnActionPerformed(evt);
            }
        });

        macroBtn.setText("Macro");
        macroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macroBtnActionPerformed(evt);
            }
        });

        botaoExecucaoPassoAPasso.setText("Executar Passo-a-Passo");
        botaoExecucaoPassoAPasso.setFocusable(false);
        botaoExecucaoPassoAPasso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoExecucaoPassoAPasso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoExecucaoPassoAPasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExecucaoPassoAPassoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(labelEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 805, Short.MAX_VALUE)
                        .addComponent(labelSaida)
                        .addGap(206, 206, 206))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botoesComeco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botoesAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(botaoExecucaoPassoAPasso, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(macroBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(montadorBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ligadorBtn)
                                .addGap(17, 17, 17))))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEntrada)
                    .addComponent(labelSaida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(botoesAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoExecucaoPassoAPasso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botoesComeco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ligadorBtn)
                                .addComponent(montadorBtn)
                                .addComponent(macroBtn)))))
                .addGap(18, 18, 18))
        );

        Arquivo.setText("File");

        Abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Arquivo.add(Abrir);

        barraMenu.add(Arquivo);

        jMenu2.setText("Edit");
        barraMenu.add(jMenu2);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        int returnVal = abrirArq.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = abrirArq.getSelectedFile();
            try {
                // What to do with the file, e.g. display it in a TextArea
                areaTextoEntrada.read(new FileReader(file.getAbsolutePath()), null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Problema ao acessar " + file.getAbsolutePath(), "Erro ao acessar o arquivo.", 0);
                System.out.println("Problema ao acessar " + file.getAbsolutePath());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso ao arquivo cancelado pelo usuario.", "Acesso cancelado", 1);
            System.out.println("Acesso ao arquivo cancelado pelo usuario.");
        }
    }//GEN-LAST:event_AbrirActionPerformed

    private void executarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executarActionPerformed
        int k;
        if (arq1.contentEquals("") && arq2.contentEquals("")) {
            JOptionPane.showMessageDialog(null, "Insira pelo menos um codigo para começar.", "Codigo nulo", 0);
        } else if (!arq1.contentEquals("") && arq2.contentEquals("")) {
            k = JOptionPane.showConfirmDialog(null, "Deseja começar apenas com o primeiro arquivo?", "Opçao de codigo", 0);
            if (k == JOptionPane.YES_OPTION) {
                arq2 = "\n";
                op = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Insira o segundo codigo para começar.", "Codigo nulo", 0);
                op = 0;
            }
        } else if (arq1.contentEquals("") && !arq2.contentEquals("")) {
            k = JOptionPane.showConfirmDialog(null, "Deseja começar apenas com o segundo arquivo?", "Opçao de codigo", 0);
            if (k == JOptionPane.YES_OPTION) {
                arq1 = "\n";
                op = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Insira o primeiro codigo para começar.", "Codigo nulo", 0);
                op = 0;
            }
        } else {
            op = 1;
        }
        if (op == 1) {
        
            this.lgd = new Ligador(this.cod1, this.cod2);
            this.codComposto = this.lgd.ligar();
        try
            {
                FileWriter arq  = new FileWriter(this.file_out_ligador);
                PrintWriter doc = new PrintWriter(arq);
                
                for(String s:this.codComposto){if(!s.isEmpty()){doc.println(s);}}
                
                arq.close();
            }
            catch(IOException e){}
        
        this.pmc = new ProcessadorDeMacros(this.file_out_ligador);
        try{
            if(this.pmc.verificaArquivo())
            {
                this.pmc.expandeMacro();
                this.intermediario = this.pmc.getIntermediario();
    
                try{
                    FileWriter arq = new FileWriter(this.file_out_macro);
                    PrintWriter doc = new PrintWriter(arq);
                    int aux = 0;
                    for(String s: this.intermediario){ if(!s.isEmpty())doc.println(s); aux++;}
                    arq.close();
                    }
                    catch(IOException e){System.out.println(e.getMessage());}
            }
            else
            {
                this.file_out_macro = this.arq1;
            }
            
        }
        catch(IOException e){}
        
        this.mtd = new Montador(this.file_out_macro);
        
        try{
            FileReader file_macro = new FileReader(this.file_out_macro);
            BufferedReader arq = new BufferedReader(file_macro);
            
            this.line = arq.readLine();
            
            while(this.line != null)
            {
                if(this.line.length() > 0 )
                {
                    this.mtd.createTable(this.line, this.pc);
                    if(!this.line.contains("(")) this.pc += 2;
                } 
                
               this.line = arq.readLine();
            }
           
           file_macro.close();
          
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
        
        try{
            
            FileReader file_macro = new FileReader(this.file_out_macro);
            BufferedReader arq = new BufferedReader(file_macro);
            
            this.line = arq.readLine();
         
            while(this.line != null)
            {
                if(this.line.length() > 0 && !this.line.contains("(") )
                {
                    this.code[this.i++] = this.mtd.translateLine(this.line);
                    
                } 
                
               this.line = arq.readLine();
            }
           
           file_macro.close();
          
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
        
        FileWriter write;
        try {
            write = new FileWriter(this.file_out_montador);
            PrintWriter writeDoc = new PrintWriter(write);
           
           for(int j = 0;j < this.i;j++){writeDoc.println(this.code[j]);}
           write.close();
        }
        
        catch (IOException ex) {
            Logger.getLogger(PS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileReader filek = new FileReader(this.file_out_macro);
            BufferedReader arq = new BufferedReader(filek);

            int count = 0;

            this.line = arq.readLine();
            while(this.line != null)
            {
                if(this.line.length() > 0 && !this.line.contains("(") )
               {
                    tabelaInterpretada.setValueAt(count, count, 0);
                    tabelaInterpretada.setValueAt(this.line, count++, 1);
               } 
                this.line = arq.readLine();
            }
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
            
        List<String> strList = new ArrayList<>();
        try {
            FileReader filek = new FileReader(this.file_out_montador);
            BufferedReader arq = new BufferedReader(filek);
                    
            line = arq.readLine();

            while(line != null)
            {
               strList.add(line);
               line = arq.readLine();
            }
           filek.close();
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
           
        this.inter = new Interpretador(strList,0,0,0);
          
        this.inter.interpretar();
           
        tabelaRegistadores.setValueAt(this.inter.getA(),0,1);
        tabelaRegistadores.setValueAt(this.inter.getD(),1,1);
        tabelaRegistadores.setValueAt(this.inter.getM(),2,1);
        
    }
    }//GEN-LAST:event_executarActionPerformed

    private void arq1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arq1BtnActionPerformed
        this.arq1 = this.areaTextoEntrada.getText();
        this.areaTextoEntrada.setText("");
        System.out.println("Conteudo do arquivo 1: \n" + this.arq1);
        while (i < this.arq1.length()) {
            if (this.arq1.charAt(i) != '\n') {
                aux = aux + this.arq1.charAt(i);
            } else {
                this.cod1.add(aux);
                aux = "";
            }
            i++;
        }
        i = 0;
        aux = "";
    }//GEN-LAST:event_arq1BtnActionPerformed

    private void arq2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arq2BtnActionPerformed
        arq2 = areaTextoEntrada.getText();
        this.areaTextoEntrada.setText("");
        System.out.println("Conteudo do arquivo 2: \n" + this.arq2);
        while (i < this.arq2.length()) {
            if (this.arq2.charAt(i) != '\n') {
                aux = aux + this.arq2.charAt(i);
            } else {
                this.cod2.add(aux);
                aux = "";
            }
            i++;
        }
        i = 0;
        aux = "";
    }//GEN-LAST:event_arq2BtnActionPerformed

    private void macroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macroBtnActionPerformed
        if (this.codComposto == null) {
            JOptionPane.showMessageDialog(null, "Nenhum codigo disponivel.", "Codigo nulo", 0);
        } else {
            String macro_out = "";
        try{
            FileReader file_macro = new FileReader(this.file_out_macro);
            BufferedReader arq = new BufferedReader(file_macro);
            this.line = arq.readLine();
            while(this.line != null)
            {
                if(this.line.length() > 0 )
                {
                    macro_out = macro_out + line + "\n";   
                } 
               this.line = arq.readLine();
            }
           file_macro.close();
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
      
        this.areaTextoSaida.setText(macro_out);
        }
    }//GEN-LAST:event_macroBtnActionPerformed

    private void ligadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligadorBtnActionPerformed
        if (this.codComposto == null) {
            JOptionPane.showMessageDialog(null, "Nenhum codigo disponivel.", "Codigo nulo", 0);
        } else {
        String ligador_out = "";
        try{
            FileReader file_ligador = new FileReader(this.file_out_ligador);
            BufferedReader arq = new BufferedReader(file_ligador);
            this.line = arq.readLine();
            while(this.line != null)
            {
                if(this.line.length() > 0 )
                {
                    ligador_out = ligador_out + line  + "\n";   
                } 
               this.line = arq.readLine();
            }
           file_ligador.close();
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
      
        this.areaTextoSaida.setText(ligador_out);
        }
    }//GEN-LAST:event_ligadorBtnActionPerformed

    private void montadorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montadorBtnActionPerformed
        if (this.codComposto == null) {
            JOptionPane.showMessageDialog(null, "Nenhum codigo disponivel.", "Codigo nulo", 0);
        } else {
        String montador_out = "";
        try{
            FileReader file_montador = new FileReader(this.file_out_montador);
            BufferedReader arq = new BufferedReader(file_montador);
            this.line = arq.readLine();
            while(this.line != null)
            {
                if(this.line.length() > 0 )
                {
                    montador_out = montador_out + line + "\n";   
                } 
               this.line = arq.readLine();
            }
           file_montador.close();
        }
        catch(FileNotFoundException e){System.out.println("Nao conseguiu abrir o arquivo");}
        catch(IOException e) {System.out.println("Nao conseguiu abrir o arquivo");}
      
        this.areaTextoSaida.setText(montador_out);
        }
    }//GEN-LAST:event_montadorBtnActionPerformed

    private void botaoExecucaoPassoAPassoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExecucaoPassoAPassoActionPerformed
            this.inter.interpretarPaP();
            
            
            tabelaRegistadores.setValueAt(this.inter.getA(),0,1);
            tabelaRegistadores.setValueAt(this.inter.getD(),1,1);
            tabelaRegistadores.setValueAt(this.inter.getM(),2,1);
    }//GEN-LAST:event_botaoExecucaoPassoAPassoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenu Arquivo;
    private javax.swing.JFileChooser abrirArq;
    private javax.swing.JTextArea areaTextoEntrada;
    private javax.swing.JTextArea areaTextoSaida;
    private javax.swing.JButton arq1Btn;
    private javax.swing.JButton arq2Btn;
    private javax.swing.JPanel background;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JToggleButton botaoExecucaoPassoAPasso;
    private javax.swing.JPanel botoesAcao;
    private javax.swing.JPanel botoesComeco;
    private javax.swing.JButton executar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelEntrada;
    private javax.swing.JLabel labelSaida;
    private javax.swing.JButton ligadorBtn;
    private javax.swing.JButton macroBtn;
    private javax.swing.JButton montadorBtn;
    private javax.swing.JScrollPane scrollPaneEntrada;
    private javax.swing.JScrollPane scrollPaneSaida;
    private javax.swing.JTable tabelaInterpretada;
    private javax.swing.JTable tabelaRegistadores;
    private javax.swing.JPanel textoEntrada;
    private javax.swing.JPanel textoSaida;
    // End of variables declaration//GEN-END:variables
}
