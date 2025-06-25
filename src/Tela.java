import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame{

    private CadastroDePessoa cdp;     
    private JTable tblListaGeral, tblListaProfessor, tblListaAluno;
    private DefaultTableModel tableModelGeral, tableModelProfessor, tableModelAluno;
    private JRadioButton jrbCliente, jrbVeiculo;
    private CardLayout cardLayoutAplicacao;
    private JPanel jpAplicacao;
    private JTextField tfNome, tfTelefone, tfCPF, tfEndereco;
    private JTextField tfNomeV, tfLimitePeso, tfLimiteVolume, tfPlaca;

    public Tela() {
        super("Tela de cadastro");

        cdp = new CadastroDePessoa();

        // Construção do layout da tela
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        // Contrucao CardLayout de Cliente Veículos
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        cardLayoutAplicacao = new CardLayout();
        jpAplicacao= new JPanel(cardLayoutAplicacao);

        // Criação dos Componentes e Jpanel para o Cliente
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        JPanel jpCliente = new JPanel();
        jpCliente.setLayout(new BoxLayout(jpCliente, BoxLayout.Y_AXIS));

        // Cria um painel para agrupar a Label e o Campo de Texto do nome do cliente
        // e adiciona ao painel principal jpCliente
        JPanel jpLinhaNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNome = new JLabel("Nome: ");
        tfNome = new JTextField(50);
        jpLinhaNome.add(lblNome);
        jpLinhaNome.add(tfNome);
        jpCliente.add(jpLinhaNome);

        // Cria um painel para agrupar a Label e o Campo de Texto do telefone do cliente
        // e adiciona ao painel principal jpCliente
        JPanel jpLinhaTelefone = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTelefone = new JLabel("Telefone:");
        tfTelefone = new JTextField(50);
        jpLinhaTelefone.add(lblTelefone);
        jpLinhaTelefone.add(tfTelefone);
        jpCliente.add(jpLinhaTelefone);

        // Cria um painel para agrupar a Label e o Campo de Texto do CPF do cliente
        // e adiciona ao painel principal jpCliente
        JPanel jpLinhaCPF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCPF = new JLabel("CPF:");
        tfCPF = new JTextField(50);
        jpLinhaCPF.add(lblCPF);
        jpLinhaCPF.add(tfCPF);
        jpCliente.add(jpLinhaCPF);

        // Cria um painel para agrupar a Label e o Campo de Texto do endereço do cliente
        // e adiciona ao painel principal jpCliente
        JPanel jpLinhaEndereco = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblEndereco = new JLabel("Endereço:");
        tfEndereco = new JTextField(50);
        jpLinhaEndereco.add(lblEndereco);
        jpLinhaEndereco.add(tfEndereco);
        jpCliente.add(jpLinhaEndereco);

        // Criação dos Componentes e Jpanel para o Veiculo
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        JPanel jpVeiculo = new JPanel();
        jpVeiculo.setLayout(new BoxLayout(jpVeiculo, BoxLayout.Y_AXIS));

        // Cria um painel para agrupar a Label e o Campo de Texto do nome do veículo
        // e adiciona ao painel principal jpVeiculo
        JPanel jpLinhaNomeV = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNomeV = new JLabel("Nome:");
        tfNomeV = new JTextField(50);
        jpLinhaNomeV.add(lblNomeV);
        jpLinhaNomeV.add(tfNomeV);
        jpVeiculo.add(jpLinhaNomeV);

        // Cria um painel para agrupar a Label e o Campo de Texto da placa do veículo
        // e adiciona ao painel principal jpVeiculo
        JPanel jpLinhaPlaca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPlaca = new JLabel("Placa: ");
        tfPlaca = new JTextField(50);
        jpLinhaPlaca.add(lblPlaca);
        jpLinhaPlaca.add(tfPlaca);
        jpVeiculo.add(jpLinhaPlaca);

        // Cria um painel para agrupar a Label e o Campo de Texto do limite de peso do veículo
        // e adiciona ao painel principal jpVeiculo
        JPanel jpLinhaLimitePeso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblLimitePeso = new JLabel("Limite de Peso:");
        tfLimitePeso = new JTextField(50);
        jpLinhaLimitePeso.add(lblLimitePeso);
        jpLinhaLimitePeso.add(tfLimitePeso);
        jpVeiculo.add(jpLinhaLimitePeso);

        // Cria um painel para agrupar a Label e o Campo de Texto do limite de volume do veículo
        // e adiciona ao painel principal jpVeiculo
        JPanel jpLinhaLimiteVolume = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblLimiteVolume = new JLabel("Limite de Volume:");
        tfLimiteVolume = new JTextField(50);
        jpLinhaLimiteVolume.add(lblLimiteVolume);
        jpLinhaLimiteVolume.add(tfLimiteVolume);
        jpVeiculo.add(jpLinhaLimiteVolume);

        // Cria um painel para agrupar a Label e os Checkboxes do tipo de veículo
        // e adiciona ao painel principal jpVeiculo
        JPanel jpLinhaTipoVeiculo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblTipoVeiculo = new JLabel("Tipo de Veículo:");
        JRadioButton jcbBicicleta = new JRadioButton("B");
        JRadioButton jcbMotocicleta = new JRadioButton("M");
        JRadioButton jcbVeiculoConvencional = new JRadioButton("VC");
        JRadioButton jcbCaminhao = new JRadioButton("C");
        JRadioButton jcbCaminhaoRefrigerado = new JRadioButton("CR");

        // Cria um ButtonGroup para agrupar os JRadioButtons
        // Isso garante que apenas um dos tipos de veículo possam ser selecionados por vez
        ButtonGroup bgTipoVeiculo = new ButtonGroup();
        bgTipoVeiculo.add(jcbBicicleta);
        bgTipoVeiculo.add(jcbMotocicleta);
        bgTipoVeiculo.add(jcbVeiculoConvencional);
        bgTipoVeiculo.add(jcbCaminhao);
        bgTipoVeiculo.add(jcbCaminhaoRefrigerado);
        
        // Adiciona a Label
        jpLinhaTipoVeiculo.add(lblTipoVeiculo);
        // Adiciona as radioboxes à linha de tipo de veículo
        jpLinhaTipoVeiculo.add(jcbBicicleta);
        jpLinhaTipoVeiculo.add(jcbMotocicleta);
        jpLinhaTipoVeiculo.add(jcbVeiculoConvencional);
        jpLinhaTipoVeiculo.add(jcbCaminhao);
        jpLinhaTipoVeiculo.add(jcbCaminhaoRefrigerado);

        jpVeiculo.add(jpLinhaTipoVeiculo);

        // Adicioma os painéis de Cliente e Veículo ao CardLayout
        jpAplicacao.add(jpCliente, "CLIENTE");
        jpAplicacao.add(jpVeiculo, "VEICULO");

        jrbCliente = new JRadioButton("Cliente");
        jrbCliente.setSelected(true);
        jrbVeiculo = new JRadioButton("Veículo");
        ButtonGroup bgTipo = new ButtonGroup();
        bgTipo.add(jrbCliente);
        bgTipo.add(jrbVeiculo);
        JPanel l5 = new JPanel(new FlowLayout());
        l5.add(jrbCliente);
        l5.add(jrbVeiculo);

        JCheckBox jcbAtivo = new JCheckBox("Cadastro ativo");
        jcbAtivo.setSelected(true);

        JButton btnAdicionar = new JButton("Adicionar");
        
        // Codificação da tabela Geral para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNames = {"Tipo","Matrícula", "Nome", "Idade", "Peso"};
        tableModelGeral = new DefaultTableModel(columnNames, 0);

        tblListaGeral = new JTable(tableModelGeral);
        tblListaGeral.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaGeral.setFillsViewportHeight(true);
        JScrollPane spTableGeral = new JScrollPane(tblListaGeral);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=      

        // Codificação da tabela Geral para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesProfessor = {"Matrícula", "Nome", "Idade", "Peso", "Salario"};
        tableModelProfessor = new DefaultTableModel(columnNamesProfessor, 0);

        tblListaProfessor = new JTable(tableModelProfessor);
        tblListaProfessor.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaProfessor.setFillsViewportHeight(true);
        JScrollPane spTableProfessor = new JScrollPane(tblListaProfessor);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=      

        // Codificação da tabela Geral para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesAluno = {"Matrícula", "Nome", "Idade", "Peso", "Curso"};
        tableModelAluno = new DefaultTableModel(columnNamesAluno, 0);

        tblListaAluno = new JTable(tableModelAluno);
        tblListaAluno.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaAluno.setFillsViewportHeight(true);
        JScrollPane spTableAluno = new JScrollPane(tblListaAluno);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=      

        // Cria tabs
        JTabbedPane tbPessoas = new JTabbedPane();
        // Tab Geral
        tbPessoas.addTab("Geral", spTableGeral);
        // Tab Professor
        tbPessoas.addTab("Professores", spTableProfessor);
        // Tab Aluno
        tbPessoas.addTab("Alunos", spTableAluno);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        // this.add(l1);
        // this.add(l2);
        // this.add(l3);
        // this.add(l4);
        this.add(jpAplicacao);
        this.add(l5);
        this.add(jcbAtivo);
        this.add(btnAdicionar);
        //this.add(spTableGeral);           
        this.add(tbPessoas);           
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        // Elaboração de um menu inicial
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        JMenu mArquivo = new JMenu("Arquivo");
        JMenuItem miSalvar = new JMenuItem("Salvar");
        mArquivo.add(miSalvar);
        JMenuBar mbMain = new JMenuBar();
        mbMain.add(mArquivo);
        this.setJMenuBar(mbMain);

        // Inicialização de componentes
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        carregaDadosDoArquivo(cdp);

        // Definição da interação na tela
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        jrbCliente.addActionListener(
            al -> {
                System.out.println("Ação do botão Cliente");
                cardLayoutAplicacao.show(jpAplicacao, "CLIENTE");
                // Limpa os campos
                tfNome.setText("");
                tfTelefone.setText("");
                tfCPF.setText("");
                tfEndereco.setText("");
            }
        );

        jrbVeiculo.addActionListener(
            al -> {
                System.out.println("Ação do botão Veículo");
                cardLayoutAplicacao.show(jpAplicacao, "VEICULO");
                // Limpa os campos
                tfNomeV.setText("");
                tfPlaca.setText("");
                tfLimitePeso.setText("");
                tfLimiteVolume.setText("");
            }
        );

        btnAdicionar.addActionListener( 
            al -> {
                System.out.println("Iniciando a ação do botão");

                String nome, telefone, cpf, endereco;
                String nomeV, placa, limitePeso, limiteVolume;

                Boolean cadastroAtivo = jcbAtivo.isSelected();

                if (jrbCliente.isSelected()) {
                    nome = tfNome.getText().trim();
                    telefone = tfTelefone.getText().trim();
                    cpf = tfCPF.getText().trim();
                    endereco = tfEndereco.getText().trim();

                    if (nome.isEmpty() || telefone.isEmpty() || cpf.isEmpty() || endereco.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Todos os campos do Cliente devem ser preenchidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Aqui você pode criar e adicionar um objeto Cliente, se existir
                    // Exemplo:
                    // Cliente cliente = new Cliente(nome, telefone, cpf, endereco, cadastroAtivo);
                    // cdp.adicionaPessoa(cliente);

                } else if (jrbVeiculo.isSelected()) {
                    nomeV = tfNomeV.getText().trim();
                    placa = tfPlaca.getText().trim();
                    limitePeso = tfLimitePeso.getText().trim();
                    limiteVolume = tfLimiteVolume.getText().trim();

                    if (nomeV.isEmpty() || placa.isEmpty() || limitePeso.isEmpty() || limiteVolume.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Todos os campos do Veículo devem ser preenchidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Aqui você pode criar e adicionar um objeto Veiculo, se existir
                    // Exemplo:
                    // Veiculo veiculo = new Veiculo(nomeV, placa, limitePeso, limiteVolume, cadastroAtivo);
                    // cdp.adicionaPessoa(veiculo);

                }

                updateTables(cdp);
            }
        );

        // Ação associada ao menu Salvar
        miSalvar.addActionListener( al -> {
            try {
                salvarEmArquivo();              
            } catch (Exception e) {
                System.out.println("Erro ao salvar os dados no arquivo");
            }

        });

        //Ação associada ao fechamento da janela
        this.addWindowListener(
            new windowOperations()
        );

        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

        //CLASSE INTERNA DE SUPORTE A TABELA JTABLE

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);      

    }

    private void salvarEmArquivo() throws IOException{
        PrintWriter pw = new PrintWriter("data.dat");
        pw.println("#tipo;matricula;nome;idade;peso;ativo;extra");
        for(Pessoa p: cdp.pessoal()){
            if(p instanceof Professor)
                pw.println("p;"+p.getMatricula()+";"+p.getNome()+";"+p.getIdade()+";"+p.getPeso()+";"+p.getAtivo()+";"+((Professor)p).getSalario());
            else
                pw.println("a;"+p.getMatricula()+";"+p.getNome()+";"+p.getIdade()+";"+p.getPeso()+";"+p.getAtivo()+";"+((Aluno)p).getCurso());
        }           
        pw.close();
    }

    private class windowOperations extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            int opcao = JOptionPane.showConfirmDialog(Tela.this,"A tela está sendo fechada","Fechar a janela?", JOptionPane.YES_NO_OPTION);

            if(opcao==JOptionPane.YES_OPTION){
                try {
                    salvarEmArquivo();    
                } catch (Exception l) {
                    System.out.println("Erro durante o fechamento do software. \n  O arquivo não pode ser salvo");
                }            
                System.exit(0);
            }
        }
    }

    private void carregaDadosDoArquivo(CadastroDePessoa lcpd){

        BufferedReader reader;
        try {
            Path path1 = Paths.get("data.dat");
            reader = Files.newBufferedReader(path1, Charset.forName("utf8"));
            String line = null;
            // primeira linha apresenta a ordem dos campos disponiveis
            line=reader.readLine();

            while((line=reader.readLine())!=null){
                String data [] = line.split(";");
                String tipo = data[0].trim();
                String matricula = data[1].trim();
                String nome = data[2].trim();
                String strIdade = data[3].trim();
                String strPeso = data[4].trim();
                String strAtivo = data[5].trim();
                String strOutro = data[6].trim();

                Pessoa p;
                if(tipo.trim().toLowerCase().equals("p"))
                    p = new Professor(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso), Boolean.parseBoolean(strAtivo), Double.parseDouble(strOutro));
                else
                    p = new Aluno(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso), Boolean.parseBoolean(strAtivo), strOutro);
                //Pessoa p = new Pessoa(matricula, nome, Integer.parseInt(strIdade), Double.parseDouble(strPeso));
                lcpd.adicionaPessoa(p);
            }           
            reader.close();

            updateTables(lcpd);

            
        } catch (Exception e) {
            System.out.println("Erro ao consumir o arquivo");
        }

    }

    private void updateTables(CadastroDePessoa lcdp){
        DefaultTableModel dtmG=tableModelGeral;
        DefaultTableModel dtmP=tableModelProfessor;
        DefaultTableModel dtmA=tableModelAluno;

        dtmG.setNumRows(0);
        dtmP.setNumRows(0);
        dtmA.setNumRows(0);

        for(Pessoa aux: cdp.pessoal()){
            Object [] novaLinha = new Object[5];
            Object [] nlProfessor = new Object[5];          
            Object [] nlAluno = new Object[5];

            nlProfessor[0] = nlAluno[0]=novaLinha[1]=aux.getMatricula();
            nlProfessor[1] = nlAluno[1]=novaLinha[2]=aux.getNome();
            nlProfessor[2] = nlAluno[2]=novaLinha[3]=aux.getIdade();
            nlProfessor[3] = nlAluno[3]=novaLinha[4]=aux.getPeso();
            if(aux instanceof Professor){
                novaLinha[0]   = "Professor";
                nlProfessor[4] = ((Professor) aux).getSalario();    
                dtmP.addRow(nlProfessor);
                }
            else{
                novaLinha[0]   = "Aluno";
                nlAluno[4]     = ((Aluno) aux).getCurso();
                dtmA.addRow(nlAluno);
            }
            dtmG.addRow(novaLinha);
        }
        
        System.out.println("Dados foram adicionados na matriz da tabela");

    }

    public static void main(String[] args) {
        Tela tl = new Tela();
    }



    
}