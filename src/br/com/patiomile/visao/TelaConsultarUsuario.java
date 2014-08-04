package br.com.patiomile.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.patiomile.controle.UsuarioControle;
import br.com.patiomile.modelo.GrupoUsuario;
import br.com.patiomile.modelo.Usuario;
import br.com.patiomile.utilitario.MensagensType;

public class TelaConsultarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel pnlTitulo;
	private JLabel lblTitulo;

	private JPanel pnlPesquisar;
	private JLabel lblPesquisar;
	private JTextField txtPesquisar;
	private JButton btnPesquisar;

	private JPanel pnlGrid;
	private JScrollPane scrollPane;
	private JTable table;

	private JPanel pnlDados;
	private JLabel lblUsuarioID;
	private JTextField txtUsuarioID;
	private JLabel lblNomeUsuario;
	private JTextField txtNomeUsuario;
	private JLabel lblEmailUsuario;
	private JFormattedTextField ftEmail;
	private JLabel lblLoginUsuario;
	private JTextField txtLoginUsuario;
	private JLabel lblSenhaUsuario;
	private JPasswordField pfSenhaUsuario;
	private JLabel lblConfirmaSenha;
	private JPasswordField pfConfirmaSenha;
	private JLabel lblUsuarioAtivo;
	private JCheckBox chckbxUsuarioAtivo;
	private JLabel lblGrupoUsuario;
	private JComboBox<String> cboGrupoUsuario;

	private JPanel pnlBotoes;
	private JButton btnNovo;
	private JButton btnAtualizar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultarUsuario frame = new TelaConsultarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultarUsuario() {
		initGUI();
	}

	private void initGUI() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Usuario usuario = new Usuario();
				preencherGrid(usuario);
				preencherComboGrupoUsuario();
				txtNomeUsuario.requestFocus();

				btnAtualizar.setEnabled(false);
				btnLimpar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Consultar Usu\u00E1rios");
		setBounds(100, 100, 544, 571);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlTitulo = new JPanel();
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(10, 11, 509, 84);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);

		lblTitulo = new JLabel("Usu\u00E1rios");
		lblTitulo
				.setIcon(new ImageIcon(
						"C:\\Users\\Paulo Silva\\workspace\\PatioMile\\img\\cargo1.jpg"));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 11, 489, 62);
		pnlTitulo.add(lblTitulo);

		pnlGrid = new JPanel();
		pnlGrid.setBounds(10, 165, 509, 130);
		contentPane.add(pnlGrid);
		pnlGrid.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 490, 110);
		pnlGrid.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selecionarRegistroGrid();
			}
		});
		scrollPane.setViewportView(table);

		pnlDados = new JPanel();
		pnlDados.setBounds(10, 306, 509, 176);
		contentPane.add(pnlDados);
		pnlDados.setLayout(null);

		lblUsuarioID = new JLabel("C\u00F3digo:");
		lblUsuarioID.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsuarioID.setBounds(10, 13, 80, 14);
		pnlDados.add(lblUsuarioID);

		lblNomeUsuario = new JLabel("Nome:");
		lblNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNomeUsuario.setBounds(10, 40, 80, 14);
		pnlDados.add(lblNomeUsuario);

		lblEmailUsuario = new JLabel("E-mail:");
		lblEmailUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmailUsuario.setBounds(10, 67, 80, 14);
		pnlDados.add(lblEmailUsuario);

		lblLoginUsuario = new JLabel("Login:");
		lblLoginUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLoginUsuario.setBounds(10, 94, 80, 14);
		pnlDados.add(lblLoginUsuario);

		lblSenhaUsuario = new JLabel("Senha:");
		lblSenhaUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSenhaUsuario.setBounds(10, 121, 80, 14);
		pnlDados.add(lblSenhaUsuario);

		lblConfirmaSenha = new JLabel("Confirma Senha:");
		lblConfirmaSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		lblConfirmaSenha.setBounds(268, 124, 80, 14);
		pnlDados.add(lblConfirmaSenha);

		lblUsuarioAtivo = new JLabel("Usu\u00E1rio Ativo:");
		lblUsuarioAtivo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsuarioAtivo.setBounds(10, 148, 80, 14);
		pnlDados.add(lblUsuarioAtivo);

		lblGrupoUsuario = new JLabel("Grupo Usuario:");
		lblGrupoUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGrupoUsuario.setBounds(268, 151, 80, 14);
		pnlDados.add(lblGrupoUsuario);

		txtUsuarioID = new JTextField();
		txtUsuarioID.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUsuarioID.setEditable(false);
		txtUsuarioID.setBounds(100, 9, 50, 23);
		pnlDados.add(txtUsuarioID);
		txtUsuarioID.setColumns(10);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(100, 36, 399, 23);
		pnlDados.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);

		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(100, 90, 141, 23);
		pnlDados.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);

		cboGrupoUsuario = new JComboBox<String>();
		cboGrupoUsuario.setBounds(358, 147, 141, 23);
		pnlDados.add(cboGrupoUsuario);

		pfSenhaUsuario = new JPasswordField();
		pfSenhaUsuario.setBounds(100, 118, 141, 23);
		pnlDados.add(pfSenhaUsuario);

		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(358, 118, 141, 23);
		pnlDados.add(pfConfirmaSenha);

		ftEmail = new JFormattedTextField();
		ftEmail.setBounds(100, 64, 399, 20);
		pnlDados.add(ftEmail);

		chckbxUsuarioAtivo = new JCheckBox("Sim");
		chckbxUsuarioAtivo.setBounds(96, 144, 97, 23);
		pnlDados.add(chckbxUsuarioAtivo);

		pnlBotoes = new JPanel();
		pnlBotoes.setBounds(10, 493, 509, 32);
		contentPane.add(pnlBotoes);
		pnlBotoes.setLayout(null);

		btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novoRegistro();
			}
		});
		btnNovo.setBounds(10, 4, 89, 23);
		pnlBotoes.add(btnNovo);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Usuario usuario = new Usuario();
				if (atualizarRegistro()) {
					JOptionPane.showMessageDialog(null,
							MensagensType.ATUALIZADO);
					limparCampos();
					preencherGrid(null);
				} else {
					JOptionPane.showMessageDialog(null,
							MensagensType.ERROAOATUALIZAR);
				}
			}
		});
		btnAtualizar.setBounds(109, 4, 89, 23);
		pnlBotoes.add(btnAtualizar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(208, 4, 89, 23);
		pnlBotoes.add(btnLimpar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int usuarioID = 0;
				usuarioID = Integer.parseInt(txtUsuarioID.getText());

				if (usuarioID == 0) {
					JOptionPane.showMessageDialog(null,
							MensagensType.IDIGUALZERO);
				} else if (usuarioID != 0) {
					excluirRegistro(usuarioID);
					JOptionPane.showMessageDialog(null, MensagensType.EXCLUIDO);
					limparCampos();
					preencherGrid(null);
				} else {
					JOptionPane.showMessageDialog(null,
							MensagensType.ERROAOEXCLUIR);
				}
			}
		});
		btnExcluir.setBounds(307, 4, 89, 23);
		pnlBotoes.add(btnExcluir);

		btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecharForm();
			}
		});
		btnFechar.setBounds(406, 4, 89, 23);
		pnlBotoes.add(btnFechar);

		pnlPesquisar = new JPanel();
		pnlPesquisar.setBounds(10, 106, 508, 48);
		contentPane.add(pnlPesquisar);
		pnlPesquisar.setLayout(null);

		lblPesquisar = new JLabel("Digite o nome do usu\u00E1rio:");
		lblPesquisar.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPesquisar.setBounds(10, 17, 127, 14);
		pnlPesquisar.add(lblPesquisar);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(143, 13, 223, 23);
		pnlPesquisar.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarNomeGrid(txtPesquisar.getText());
			}
		});
		btnPesquisar.setBounds(388, 13, 98, 23);
		pnlPesquisar.add(btnPesquisar);
	}

	private void preencherComboGrupoUsuario() {
		cboGrupoUsuario.removeAllItems();

		UsuarioControle usuarioControle = new UsuarioControle();

		List<GrupoUsuario> array = new ArrayList<GrupoUsuario>();
		array = usuarioControle.listarTodosGruposUsuarios();

		for (int i = 0; i <= array.size(); i++) {
			cboGrupoUsuario.addItem(array.get(i).getNomeGrupoUsuario());
		}
	}

	private void preencherGrid(Usuario usuario) {
		UsuarioControle usuarioControle = new UsuarioControle();

		DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(new Object[] { "ID", "Nome Usuário", "E-mail",
				"Login", "Senha", "Ativo", "Grupo ID", "Grupo de Usuário" });

		List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();
		listaTodosUsuarios = usuarioControle.listarTodosUsuariosAtivos();

		for (Usuario u : listaTodosUsuarios) {
			df.addRow(new Object[] { u.getUsuarioID(), u.getNome(),
					u.getEmail(), u.getLogin(), u.getSenha(),
					u.isUsuarioAtivo(), u.getUsuarioID(),
					u.getGrupoUsuario().getNomeGrupoUsuario() });
		}

		pnlGrid.setBorder(new javax.swing.border.TitledBorder(
				"Relação dos Usuários"));
		table.setModel(df);
		scrollPane.setViewportView(table);
		pnlGrid.add(scrollPane);

		// Tamanho das colunas
		
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		
		/*
		 * // Coluna ID
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		// Coluna Nome
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		// Coluna E-mail
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		// Coluna Login
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		// Coluna Senha
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		// Coluna Ativo
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		// Coluna ID do Grupo Usuário
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		// Coluna Nome do Grupo de Usuário
		table.getColumnModel().getColumn(7).setPreferredWidth(100);

		 * */
		
		// Alinhamento do conteudo do JTable
		DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

		esquerda.setHorizontalAlignment(SwingConstants.LEFT);
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		direita.setHorizontalAlignment(SwingConstants.RIGHT);

		table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(1).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(2).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(3).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(4).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(5).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(6).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(7).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(8).setCellRenderer(esquerda);

		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
	}

	private void selecionarRegistroGrid() {
		int linhaSelecionada = 0;

		linhaSelecionada = table.getSelectedRow(); // pega a linha selecionada

		txtUsuarioID.setText(String.valueOf(table.getValueAt(linhaSelecionada,
				0)));
		txtNomeUsuario.setText(String.valueOf(table.getValueAt(
				linhaSelecionada, 1)));
		ftEmail.setText(String.valueOf(table.getValueAt(linhaSelecionada, 2)));
		txtLoginUsuario.setText(String.valueOf(table.getValueAt(
				linhaSelecionada, 3)));
		pfSenhaUsuario.setText(String.valueOf(table.getValueAt(
				linhaSelecionada, 4)));
		pfConfirmaSenha.setText(String.valueOf(table.getValueAt(
				linhaSelecionada, 4)));
		chckbxUsuarioAtivo.setSelected(Boolean.parseBoolean(String
				.valueOf(table.getValueAt(linhaSelecionada, 5))));
		cboGrupoUsuario.setSelectedItem(String.valueOf(table.getValueAt(
				linhaSelecionada, 8)));

		btnNovo.setEnabled(false);
		btnAtualizar.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnFechar.setEnabled(false);
	}

	private void pesquisarNomeGrid(String nomeUsuario) {
		UsuarioControle usuarioControle = new UsuarioControle();

		DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(new Object[] { "ID", "Nome Usuário", "E-mail",
				"Login", "Senha", "Ativo", "Grupo ID", "Grupo de Usuário" });

		List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();
		listaTodosUsuarios = usuarioControle.listarUsuarioPorNome(nomeUsuario);

		for (Usuario u : listaTodosUsuarios) {
			df.addRow(new Object[] { u.getUsuarioID(), u.getNome(),
					u.getEmail(), u.getLogin(), u.getSenha(),
					u.isUsuarioAtivo(), u.getUsuarioID(),
					u.getGrupoUsuario().getNomeGrupoUsuario() });
		}

		pnlGrid.setBorder(new javax.swing.border.TitledBorder(
				"Relação dos Usuários"));
		table.setModel(df);
		scrollPane.setViewportView(table);
		pnlGrid.add(scrollPane);

		// Tamanho das colunas
		// Coluna ID
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		// Coluna Nome
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		// Coluna E-mail
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		// Coluna Login
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		// Coluna Senha
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		// Coluna Ativo
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		// Coluna ID do Grupo Usuário
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setPreferredWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		// Coluna Nome do Grupo de Usuário
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);

		// Alinhamento do conteudo do JTable
		DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

		esquerda.setHorizontalAlignment(SwingConstants.LEFT);
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		direita.setHorizontalAlignment(SwingConstants.RIGHT);

		table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(1).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(2).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(3).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(4).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(5).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(6).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(7).setCellRenderer(esquerda);
		table.getColumnModel().getColumn(8).setCellRenderer(esquerda);

		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
	}

	private void novoRegistro() {
		TelaCadastrarCargo frmCargo = new TelaCadastrarCargo();
		frmCargo.setVisible(true);
	}

	private boolean atualizarRegistro() {
		boolean atualizado;
		int grupoUsuarioID = 0;

		Usuario usuario = new Usuario();
		UsuarioControle usuarioControle = new UsuarioControle();

		usuario.setUsuarioID(Integer.parseInt(txtUsuarioID.getText()));
		usuario.setNome(txtNomeUsuario.getText());
		usuario.setEmail(ftEmail.getText());
		usuario.setLogin(txtLoginUsuario.getText());
		usuario.setSenha(String.valueOf(pfSenhaUsuario.getPassword()));
		usuario.setUsuarioAtivo(chckbxUsuarioAtivo.isSelected());
		grupoUsuarioID = usuarioControle.buscarCodigo(String
				.valueOf(cboGrupoUsuario.getSelectedItem()));
		usuario.setGrupoUsuarioID(grupoUsuarioID);

		atualizado = usuarioControle.atualizarUsuario(usuario);

		return atualizado;
	}

	private boolean excluirRegistro(int usuarioID) {
		boolean excluido;

		UsuarioControle usuarioControle = new UsuarioControle();
		excluido = usuarioControle.excluirUsuario(usuarioID);

		return excluido;
	}

	private void limparCampos() {
		txtPesquisar.setText("");
		txtUsuarioID.setText("");
		txtNomeUsuario.setText("");
		ftEmail.setText("");
		txtLoginUsuario.setText("");
		pfSenhaUsuario.setText("");
		pfConfirmaSenha.setText("");
		chckbxUsuarioAtivo.setSelected(false);
		cboGrupoUsuario.setSelectedItem(null);

		btnNovo.setEnabled(true);
		btnAtualizar.setEnabled(false);
		btnLimpar.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnFechar.setEnabled(true);
	}

	private void fecharForm() {
		dispose();
	}
}
