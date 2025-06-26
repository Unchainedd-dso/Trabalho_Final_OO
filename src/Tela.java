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

import trabalho.cliente.CadastroClientes;
import trabalho.cliente.Cliente;
import trabalho.veiculos.Bicicleta;
import trabalho.veiculos.CadastroVeiculos;
import trabalho.veiculos.Caminhao;
import trabalho.veiculos.CaminhaoRefrigerado;
import trabalho.veiculos.Motocicleta;
import trabalho.veiculos.Veiculo;
import trabalho.veiculos.VeiculoConvencional;
import trabalho.viagem.CadastroViagens;
import trabalho.viagem.Viagem;

public class Tela extends JFrame{

    private CadastroClientes cadastroDeClientes;
    private CadastroVeiculos cadastroDeVeiculos;
    private CadastroViagens cadastroDeViagens;
    private JTable tblListaCliente, tblListaVeiculo, tblListaViagem;
    private DefaultTableModel tableModelCliente, tableModelVeiculo, tableModelViagem;
    private JRadioButton jrbCliente, jrbVeiculo, jrbViagem;
    private CardLayout cardLayoutAplicacao;
    private JPanel jpAplicacao;
    private JTextField tfNome, tfTelefone, tfCPF, tfEndereco;
    private JTextField tfNomeV, tfLimitePeso, tfLimiteVolume, tfPlaca;
    private JTextField tfPesoViagem, tfVolumeViagem, tfValorAproximado, tfDistanciaViagem;

    public Tela() {
        super("Tela de cadastro");

        cadastroDeClientes = new CadastroClientes();
        cadastroDeVeiculos = new CadastroVeiculos();
        cadastroDeViagens = new CadastroViagens();

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

        // Criação dos Componentes e Jpanel para a
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        JPanel jpViagem = new JPanel();
        jpViagem.setLayout(new BoxLayout(jpViagem, BoxLayout.Y_AXIS));

        // Cria um painel para agrupar a Label e o Campo de Texto do Peso do item a ser transportado
        // e adiciona ao painel principal jpViagem
        JPanel jpLinhaPeso = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblPeso = new JLabel("Peso: ");
        tfPesoViagem = new JTextField(50);
        jpLinhaPeso.add(lblPeso);
        jpLinhaPeso.add(tfPesoViagem);
        jpViagem.add(jpLinhaPeso);

        // Cria um painel para agrupar a Label e o Campo de Texto do Volume do item a ser transportado
        // e adiciona ao painel principal jpViagem
        JPanel jpLinhaVolume = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblVolume = new JLabel("Volume:");
        tfVolumeViagem = new JTextField(50);
        jpLinhaVolume.add(lblVolume);
        jpLinhaVolume.add(tfVolumeViagem);
        jpViagem.add(jpLinhaVolume);

        // Cria um painel para agrupar a Label e o Campo de Texto do Valor Aproximado do item a ser transportado
        // e adiciona ao painel principal jpViagem
        JPanel jpLinhaValor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblValor = new JLabel("Valor Aproximado:");
        tfValorAproximado = new JTextField(50);
        jpLinhaValor.add(lblValor);
        jpLinhaValor.add(tfValorAproximado);
        jpViagem.add(jpLinhaValor);

        // Cria um painel para agrupar a Label e o Campo de Texto da distância do item a ser transportado
        // e adiciona ao painel principal jpViagem
        JPanel jpLinhaDistancia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblDistancia = new JLabel("Distância:");
        tfDistanciaViagem = new JTextField(50);
        jpLinhaDistancia.add(lblDistancia);
        jpLinhaDistancia.add(tfDistanciaViagem);
        jpViagem.add(jpLinhaDistancia);

        // Cria um painel para agrupar a Label e o Checkbox de Urgência do item a ser transportado
        // e adiciona ao painel principal jpViagem
        JPanel jpLinhaUrgencia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblUrgencia = new JLabel("Urgência:");
        JCheckBox jcbUrgente = new JCheckBox();
        jpLinhaUrgencia.add(lblUrgencia);
        jpLinhaUrgencia.add(jcbUrgente);
        jpViagem.add(jpLinhaUrgencia);

        JPanel jpLinhaSensivelAoFrio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblSensivelAoFrio = new JLabel("Sensível ao Frio:");
        JCheckBox jcbSensivelAoFrio = new JCheckBox();
        jpLinhaSensivelAoFrio.add(lblSensivelAoFrio);
        jpLinhaSensivelAoFrio.add(jcbSensivelAoFrio);
        jpViagem.add(jpLinhaSensivelAoFrio);

        // Cria um painel para agrupar a Label e o Campo do telefone do cliente
        // e adiciona ao painel principal jpCliente
        JPanel jpLinhaCliente = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCliente = new JLabel("Telefone Cliente:");
        JTextField tfCliente = new JTextField(50);
        jpLinhaCliente.add(lblCliente);
        jpLinhaCliente.add(tfCliente);
        jpViagem.add(jpLinhaCliente);

        // Cria um painel para agrupar a Label e o Campo do nome do veículo
        // e adiciona ao painel principal jpVeiculo
        JPanel jpLinhaVeiculo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblVeiculo = new JLabel("Nome Veículo:");
        JTextField tfVeiculo = new JTextField(50);
        jpLinhaVeiculo.add(lblVeiculo);
        jpLinhaVeiculo.add(tfVeiculo);
        jpViagem.add(jpLinhaVeiculo);

        // Adiciona os painéis de Cliente, Veículo e Viagem ao CardLayout
        jpAplicacao.add(jpCliente, "CLIENTE");
        jpAplicacao.add(jpVeiculo, "VEICULO");
        jpAplicacao.add(jpViagem, "VIAGEM");

        jrbCliente = new JRadioButton("Cliente");
        jrbCliente.setSelected(true);
        jrbVeiculo = new JRadioButton("Veículo");
        jrbViagem = new JRadioButton("Viagem");
        ButtonGroup bgTipo = new ButtonGroup();
        bgTipo.add(jrbCliente);
        bgTipo.add(jrbVeiculo);
        bgTipo.add(jrbViagem);
        JPanel l5 = new JPanel(new FlowLayout());
        l5.add(jrbCliente);
        l5.add(jrbVeiculo);
        l5.add(jrbViagem);

        JCheckBox jcbAtivo = new JCheckBox("Cadastro ativo");
        jcbAtivo.setSelected(true);

        JButton btnAdicionar = new JButton("Adicionar");     

        // Codificação da tabela Clientes para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesCliente = {"Nome", "Telefone", "CPF", "Endereço"};
        tableModelCliente = new DefaultTableModel(columnNamesCliente, 0);

        tblListaCliente = new JTable(tableModelCliente);
        tblListaCliente.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaCliente.setFillsViewportHeight(true);
        JScrollPane spTableCliente = new JScrollPane(tblListaCliente);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=      

        // Codificação da tabela Veiculos para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesVeiculo = {"Nome", "Placa", "Limite de Peso", "Limite de Volume"};
        tableModelVeiculo = new DefaultTableModel(columnNamesVeiculo, 0);

        tblListaVeiculo = new JTable(tableModelVeiculo);
        tblListaVeiculo.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaVeiculo.setFillsViewportHeight(true);
        JScrollPane spTableVeiculo = new JScrollPane(tblListaVeiculo);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
        
        // Codificação da tabela Viagens para garantir dinamicidade
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        String [] columnNamesViagem = {"Peso", "Volume", "Preço do Produto", "Distância", "Urgente", "Sensível ao Frio", "Telefone Cliente", "Nome Veículo", "Preço"};
        tableModelViagem = new DefaultTableModel(columnNamesViagem, 0);

        tblListaViagem = new JTable(tableModelViagem);
        tblListaViagem.setPreferredScrollableViewportSize(new Dimension(300, 50));
        tblListaViagem.setFillsViewportHeight(true);
        JScrollPane spTableViagem = new JScrollPane(tblListaViagem);
        //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=   

        // Cria tabs
        JTabbedPane tbCadastros = new JTabbedPane();
        // Tab Clientes
        tbCadastros.addTab("Clientes", spTableCliente);
        // Tab Veículos
        tbCadastros.addTab("Veículos", spTableVeiculo);
        // Tab Viagens
        tbCadastros.addTab("Viagens", spTableViagem);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(jpAplicacao);
        this.add(l5);
        this.add(jcbAtivo);
        this.add(btnAdicionar);
        //this.add(spTableGeral);
        this.add(tbCadastros);

        // Carrega os dados dos arquivos já presentes depois da inicialização de TableModelCliente e TableModelVeiculo
        carregaDadosDoArquivo(cadastroDeClientes, cadastroDeVeiculos, cadastroDeViagens);
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
        // carregaDadosDoArquivo(cdp);

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

        jrbViagem.addActionListener(
            al -> {
                System.out.println("Ação do botão Viagem");
                cardLayoutAplicacao.show(jpAplicacao, "VIAGEM");
                // Limpa os campos
                tfPesoViagem.setText("");
                tfVolumeViagem.setText("");
                tfValorAproximado.setText("");
                tfDistanciaViagem.setText("");
                tfCliente.setText("");
                tfVeiculo.setText("");
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


                    // Os parâmetros obrigatórios para Cliente
                    if (nome.isEmpty() || telefone.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Todos os campos do Cliente devem ser preenchidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        // Cria um novo Cliente e adiciona ao CadastroDeClientes
                        // CPF e endereço podem ser String vazias
                        Cliente cliente = new Cliente(
                            nome, 
                            telefone, 
                            cpf == null? "" : cpf, // Se o CPF for nulo, atribiu uma string vazia, para fins de consistencia e salvamento do arquivo
                            endereco == null? "" : endereco
                        );
                        cadastroDeClientes.adicionaCliente(cliente);
                    }
                } else if (jrbVeiculo.isSelected()) {
                    nomeV = tfNomeV.getText().trim();
                    placa = tfPlaca.getText().trim();
                    limitePeso = tfLimitePeso.getText().trim();
                    limiteVolume = tfLimiteVolume.getText().trim();

                    boolean condicaoComBicicleta = nomeV.isEmpty() || !jcbBicicleta.isSelected() || limitePeso.isEmpty() || limiteVolume.isEmpty() || bgTipoVeiculo.getSelection() == null;
                    boolean condicaoSemBicicletaa = nomeV.isEmpty() || placa.isEmpty() || limitePeso.isEmpty() || limiteVolume.isEmpty() || bgTipoVeiculo.getSelection() == null;
                    if (condicaoSemBicicletaa && condicaoComBicicleta) {
                        JOptionPane.showMessageDialog(this, "Todos os campos do Veículo devem ser preenchidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else{   
                        if(jcbBicicleta.isSelected()){
                            // Cria uma Bicicleta
                            Bicicleta bicicleta = new Bicicleta(nomeV, Integer.parseInt(limitePeso), Integer.parseInt(limiteVolume));
                            cadastroDeVeiculos.adicionaVeiculo(bicicleta);
                        } else if(jcbMotocicleta.isSelected()){
                            // Cria um novo Veículo Motocicleta
                            Motocicleta motocicleta = new Motocicleta(nomeV, Integer.parseInt(limitePeso), Integer.parseInt(limiteVolume), placa);
                            cadastroDeVeiculos.adicionaVeiculo(motocicleta);
                        } else if(jcbVeiculoConvencional.isSelected()){
                            // Cria um novo Veículo Convencional
                            VeiculoConvencional veiculoConvencional = new VeiculoConvencional(nomeV, Integer.parseInt(limitePeso), Integer.parseInt(limiteVolume), placa);
                            cadastroDeVeiculos.adicionaVeiculo(veiculoConvencional);
                        } else if(jcbCaminhao.isSelected()){
                            // Cria um novo Caminhão
                            Caminhao caminhao = new Caminhao(nomeV, Integer.parseInt(limitePeso), Integer.parseInt(limiteVolume), placa);
                            cadastroDeVeiculos.adicionaVeiculo(caminhao);
                        } else if(jcbCaminhaoRefrigerado.isSelected()){
                            // Cria um novo Caminhão Refrigerado
                            CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado(nomeV, Integer.parseInt(limitePeso), Integer.parseInt(limiteVolume), placa);
                            cadastroDeVeiculos.adicionaVeiculo(caminhaoRefrigerado);
                        }
                    }

                    // Aqui você pode criar e adicionar um objeto Veiculo, se existir
                    // Exemplo:
                    // Veiculo veiculo = new Veiculo(nomeV, placa, limitePeso, limiteVolume, cadastroAtivo);
                    // cdp.adicionaPessoa(veiculo);
                }else if(jrbViagem.isSelected()){
                    Double peso = Double.parseDouble(tfPesoViagem.getText().trim());
                    Double volume = Double.parseDouble(tfVolumeViagem.getText().trim());
                    Double valorAproximado = Double.parseDouble(tfValorAproximado.getText().trim());
                    Double distancia = Double.parseDouble(tfDistanciaViagem.getText().trim());
                    String telefoneCliente = tfCliente.getText().trim();
                    String nomeVeiculo = tfVeiculo.getText().trim();
                    boolean urgente = jcbUrgente.isSelected();
                    boolean sensivelAoFrio = jcbSensivelAoFrio.isSelected();

                    // Verifica se os campos obrigatórios estão preenchidos
                    if (peso == null || volume == null || valorAproximado == null || distancia == null || telefoneCliente.isEmpty() || nomeVeiculo.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Todos os campos da Viagem devem ser preenchidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if(cadastroDeClientes.buscaClientePorTelefone(telefoneCliente) == null || cadastroDeVeiculos.buscaVeiculoPorNome(nomeVeiculo) == null){
                        // Se o telefone do cliente não existir no cadastro de clientes
                        JOptionPane.showMessageDialog(this, "Telefone do cliente não encontrado ou Veiculo não encontrado.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else if(volume > cadastroDeVeiculos.buscaVeiculoPorNome(nomeVeiculo).getLimiteVolume()){
                        JOptionPane.showMessageDialog(this, "O volume da carga excede o limite do veículo escolhido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    }else if(peso > cadastroDeVeiculos.buscaVeiculoPorNome(nomeVeiculo).getLimiteKG()){
                        JOptionPane.showMessageDialog(this, "O peso da carga excede o limite do veículo escolhido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    }else {
                        // Procura na lista, utilizando do número de telefone, o cliente
                        Cliente cliente = cadastroDeClientes.buscaClientePorTelefone(telefoneCliente);
                        // Procura na lista, utilizando do nome do veículo, o veículo
                        Veiculo veiculo = cadastroDeVeiculos.buscaVeiculoPorNome(nomeVeiculo);
                        // Cria uma nova Viagem e adiciona ao CadastroDeViagens
                        Viagem viagem = new Viagem(peso, volume, valorAproximado, distancia, urgente, sensivelAoFrio, cliente, veiculo, Viagem.valorViagem(distancia, peso, urgente, sensivelAoFrio, veiculo));
                        cadastroDeViagens.adicionarViagem(viagem);
                    }
                }

                updateTables(cadastroDeVeiculos, cadastroDeClientes, cadastroDeViagens);
            }
        );

        // Ação associada ao menu Salvar
        miSalvar.addActionListener( al -> {
            if(jrbCliente.isSelected()){
                try {
                    salvarEmArquivoCliente();
                } catch (Exception e) {
                    System.out.println("Erro ao salvar os dados dos clientes no arquivo");
                }
            } else if(jrbVeiculo.isSelected()){
                try {
                    salvarEmArquivoVeiculos();
                } catch (Exception e) {
                    System.out.println("Erro ao salvar os dados dos veículos no arquivo");
                }
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

    private void salvarEmArquivoVeiculos() throws IOException{
        PrintWriter pw = new PrintWriter("data_veiculos.dat");
        pw.println("#nome;placa;limiteDePeso;limiteDeVolume;tipo");
        for(Veiculo v: cadastroDeVeiculos.veiculos()){
            if(v instanceof Bicicleta)
                // Bicicleta não tem placa
                pw.println(v.getNome()+";"+";"+v.getLimiteKG()+";"+v.getLimiteVolume()+";Bicicleta");
            else if(v instanceof Motocicleta)
                pw.println(v.getNome()+";"+((Motocicleta)v).getPlaca()+";"+v.getLimiteKG()+";"+v.getLimiteVolume()+";Motocicleta");
            else if(v instanceof VeiculoConvencional)
                pw.println(v.getNome()+";"+((VeiculoConvencional)v).getPlaca()+";"+v.getLimiteKG()+";"+v.getLimiteVolume()+";VeiculoConvencional");
            else if(v instanceof Caminhao)
                pw.println(v.getNome()+";"+((Caminhao)v).getPlaca()+";"+v.getLimiteKG()+";"+v.getLimiteVolume()+";Caminhao");
            else if(v instanceof CaminhaoRefrigerado)
                pw.println(v.getNome()+";"+((CaminhaoRefrigerado)v).getPlaca()+";"+v.getLimiteKG()+";"+v.getLimiteVolume()+";CaminhaoRefrigerado");
        }           
        pw.close();
    }

    private void salvarEmArquivoCliente() throws IOException{
        PrintWriter pw = new PrintWriter("data_clientes.dat");
        pw.println("#nome;telefone;cpf;endereco");
        for(Cliente c: cadastroDeClientes.clientes()){
            pw.println(c.getNome()+";"+c.getTelefone()+";"+c.getCpf()+";"+c.getEndereco());
        }           
        pw.close();
    }

    private void salvarEmArquivoViagem() throws IOException{
        PrintWriter pw = new PrintWriter("data_viagens.dat");
        pw.println("#peso;volume;valorAproximadoCarga;distancia;urgencia;sensivelAoFrio;cliente;veiculo;preco");
        for(Viagem v: cadastroDeViagens.viagens()){
            pw.println(v.getPeso()+";"+v.getVolume()+";"+v.getValorAproximadoCarga()+";"+v.getDistancia()+";"+v.isUrgencia()+";"+v.isSensivelAoFrio()+";"+v.getCliente().getTelefone()+";"+v.getVeiculo().getNome() +";"+v.getPreco());
        }           
        pw.close();
    }

    private class windowOperations extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            int opcao = JOptionPane.showConfirmDialog(Tela.this,"A tela está sendo fechada","Fechar a janela?", JOptionPane.YES_NO_OPTION);
            if(jrbCliente.isSelected()){
                try {
                    salvarEmArquivoCliente();
                } catch (Exception error) {
                    System.out.println("Erro ao salvar os dados dos clientes no arquivo");
                }
            }else if(jrbVeiculo.isSelected()){
                try {
                    salvarEmArquivoVeiculos();
                } catch (Exception error) {
                    System.out.println("Erro ao salvar os dados dos veículos no arquivo");
                }
            }else if(jrbViagem.isSelected()){
                try {
                    salvarEmArquivoViagem();
                } catch (Exception error) {
                    System.out.println("Erro ao salvar os dados das viagens no arquivo");
                }
            }
            System.exit(opcao);
        }
    }

    private void carregaDadosDoArquivo(CadastroClientes cadastroDeClientes, CadastroVeiculos cadastroDeVeiculos, CadastroViagens cadastroDeViagens) {

        BufferedReader reader;
        try {
            Path path1 = Paths.get("data_clientes.dat");
            reader = Files.newBufferedReader(path1, Charset.forName("utf8"));
            String line = null;
            // primeira linha apresenta a ordem dos campos disponiveis
            line=reader.readLine();

            while((line=reader.readLine())!=null){
                String data [] = line.split(";");
                String nome = data[0].trim();
                String telefone = data[1].trim();
                String cpf = data[2].trim();
                String endereco = data[3].trim();
                // Cria um novo Cliente e adiciona ao CadastroDeClientes
                Cliente cliente = new Cliente(nome, telefone, cpf, endereco);
                cadastroDeClientes.adicionaCliente(cliente);
            }           
            reader.close();

        } catch (Exception e) {
            System.out.println("Erro ao consumir o arquivo de clientes " + e);
        }
        
        try {
            Path path1 = Paths.get("data_veiculos.dat");
            reader = Files.newBufferedReader(path1, Charset.forName("utf8"));
            String line = null;
            // primeira linha apresenta a ordem dos campos disponiveis
            line=reader.readLine();

            while((line=reader.readLine())!=null){
                String data [] = line.split(";");
                String nome = data[0].trim();
                String placa = data[1].trim();
                int limiteDePeso = Integer.parseInt(data[2].trim());
                int limiteDeVolume = Integer.parseInt(data[3].trim());
                String tipo = data[4].trim();
                
                switch(tipo){
                    case "Bicicleta":
                        // Cria uma Bicicleta
                        Bicicleta bicicleta = new Bicicleta(nome, limiteDePeso, limiteDeVolume);
                        cadastroDeVeiculos.adicionaVeiculo(bicicleta);
                        break;
                    case "Motocicleta":
                        // Cria um novo Veículo Motocicleta
                        Motocicleta motocicleta = new Motocicleta(nome, limiteDePeso, limiteDeVolume, placa);
                        cadastroDeVeiculos.adicionaVeiculo(motocicleta);
                        break;
                    case "VeiculoConvencional":
                        // Cria um novo Veículo Convencional
                        VeiculoConvencional veiculoConvencional = new VeiculoConvencional(nome, limiteDePeso, limiteDeVolume, placa);
                        cadastroDeVeiculos.adicionaVeiculo(veiculoConvencional);
                        break;
                    case "Caminhao":
                        // Cria um novo Caminhão
                        Caminhao caminhao = new Caminhao(nome, limiteDePeso, limiteDeVolume, placa);
                        cadastroDeVeiculos.adicionaVeiculo(caminhao);
                        break;
                    case "CaminhaoRefrigerado":
                        // Cria um novo Caminhão Refrigerado
                        CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado(nome, limiteDePeso, limiteDeVolume, placa);
                        cadastroDeVeiculos.adicionaVeiculo(caminhaoRefrigerado);
                        break;
                    default:
                        System.out.println("Tipo de veículo desconhecido: " + tipo);
                }
            }
            reader.close();
            updateTables(cadastroDeVeiculos, cadastroDeClientes, cadastroDeViagens);
        } catch (Exception e) {
            System.out.println("Erro ao consumir o arquivo de Veiculos " + e);
        }
        try{
            Path path1 = Paths.get("data_viagens.dat");
            reader = Files.newBufferedReader(path1, Charset.forName("utf8"));
            String line = null;
            // primeira linha apresenta a ordem dos campos disponiveis
            line=reader.readLine();

            while((line=reader.readLine())!=null){
                String[] data = line.split(";");
                double peso = Double.parseDouble(data[0]);
                double volume = Double.parseDouble(data[1]);
                double valorAproximadoCarga = Double.parseDouble(data[2]);
                double distancia = Double.parseDouble(data[3]);
                boolean urgente = Boolean.parseBoolean(data[4]);
                boolean sensivelAoFrio = Boolean.parseBoolean(data[5]);
                String telefoneCliente = data[6];
                String nomeVeiculo = data[7];
                double preco = Double.parseDouble(data[8]);
                
                // Busca o cliente e o veículo
                Cliente cliente = cadastroDeClientes.buscaClientePorTelefone(telefoneCliente);
                Veiculo veiculo = cadastroDeVeiculos.buscaVeiculoPorNome(nomeVeiculo);
                // Verificação extra, verifica se o arquivo não fo
                Viagem viagem = new Viagem(peso, volume, valorAproximadoCarga, distancia, urgente, sensivelAoFrio, cliente, veiculo, preco);
                cadastroDeViagens.adicionarViagem(viagem);
            }           
            updateTables(cadastroDeVeiculos, cadastroDeClientes, cadastroDeViagens);
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro ao consumir o arquivo de Viagens " + e);
        }

    }

    private void updateTables(CadastroVeiculos lcadastroDeVeiculos, CadastroClientes lcadastroDeClientes, CadastroViagens lcadastroDeViagens) {
        DefaultTableModel dtmC=tableModelCliente;
        DefaultTableModel dtmV=tableModelVeiculo;
        DefaultTableModel dtmVi=tableModelViagem;

        dtmC.setNumRows(0);
        dtmV.setNumRows(0);
        dtmVi.setNumRows(0);

        for(Veiculo aux: lcadastroDeVeiculos.veiculos()){
            Object [] nlVeiculo = new Object[4];          

            nlVeiculo[0] = aux.getNome();
            if(aux instanceof Bicicleta) {
                nlVeiculo[1] = ""; // Bicicleta não tem placa
            } else {
                if(aux instanceof Motocicleta) {
                    nlVeiculo[1] = ((Motocicleta)aux).getPlaca();
                } else if(aux instanceof VeiculoConvencional) {
                    nlVeiculo[1] = ((VeiculoConvencional)aux).getPlaca();
                } else if(aux instanceof Caminhao) {
                    nlVeiculo[1] = ((Caminhao)aux).getPlaca();
                } else if(aux instanceof CaminhaoRefrigerado) {
                    nlVeiculo[1] = ((CaminhaoRefrigerado)aux).getPlaca();
                }
            }
            nlVeiculo[2] = aux.getLimiteKG();
            nlVeiculo[3] = aux.getLimiteVolume();
            
            dtmV.addRow(nlVeiculo);
        }

        for(Cliente aux: lcadastroDeClientes.clientes()){
            Object [] nlCliente = new Object[4];
            nlCliente[0] = aux.getNome();
            nlCliente[1] = aux.getTelefone();
            nlCliente[2] = aux.getCpf();
            nlCliente[3] = aux.getEndereco();
            
            dtmC.addRow(nlCliente);
        }

        for(Viagem aux: lcadastroDeViagens.viagens()){
            Object [] nlViagem = new Object[9];
            nlViagem[0] = aux.getPeso();
            nlViagem[1] = aux.getVolume();
            nlViagem[2] = aux.getValorAproximadoCarga();
            nlViagem[3] = aux.getDistancia();
            nlViagem[4] = aux.isUrgencia();
            nlViagem[5] = aux.isSensivelAoFrio();
            nlViagem[6] = aux.getCliente().getTelefone();
            nlViagem[7] = aux.getVeiculo().getNome();
            nlViagem[8] = Viagem.valorViagem(aux.getDistancia(), aux.getPeso(), aux.isUrgencia(), aux.isSensivelAoFrio(), aux.getVeiculo());

            dtmVi.addRow(nlViagem);
        }
        
        System.out.println("Dados foram adicionados na matriz da tabela");

    }

    public static void main(String[] args) {
        Tela tl = new Tela();
    }
}