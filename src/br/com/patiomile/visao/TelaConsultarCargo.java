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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.patiomile.controle.CargoControle;
import br.com.patiomile.dao.CargoDAO;
import br.com.patiomile.modelo.Cargo;
import br.com.patiomile.tablemodel.CargoTableModel;
import br.com.patiomile.utilitario.MensagensType;

public class TelaConsultarCargo extends JFrame {

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
	private JLabel lblCargoID;
	private JTextField txtCargoID;
	private JLabel lblNomeCargo;
	private JTextField txtNomeCargo;

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
					TelaConsultarCargo frame = new TelaConsultarCargo();
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
	public TelaConsultarCargo() {
		initGUI();
	}

	private void initGUI() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				preencherGrid();
				txtNomeCargo.requestFocus();

				btnAtualizar.setEnabled(false);
				btnLimpar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Consultar Cargos");
		setBounds(100, 100, 544, 484);
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

		lblTitulo = new JLabel("Cargos");
		lblTitulo
				.setIcon(new ImageIcon(
						"C:\\Users\\Paulo Silva\\workspace\\PatioMile\\img\\cargo1.jpg"));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 11, 489, 62);
		pnlTitulo.add(lblTitulo);

		pnlGrid = new JPanel();
		pnlGrid.setBorder(new TitledBorder(null,
				"Rela\u00E7\u00E3o dos Cargos", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlGrid.setBounds(10, 165, 509, 130);
		contentPane.add(pnlGrid);
		pnlGrid.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 490, 99);
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
		pnlDados.setBounds(10, 306, 509, 84);
		contentPane.add(pnlDados);
		pnlDados.setLayout(null);

		lblCargoID = new JLabel("C\u00F3digo:");
		lblCargoID.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCargoID.setBounds(10, 18, 46, 14);
		pnlDados.add(lblCargoID);

		txtCargoID = new JTextField();
		txtCargoID.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCargoID.setEditable(false);
		txtCargoID.setBounds(66, 14, 50, 23);
		pnlDados.add(txtCargoID);
		txtCargoID.setColumns(10);

		lblNomeCargo = new JLabel("Cargo:");
		lblNomeCargo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNomeCargo.setBounds(10, 50, 46, 14);
		pnlDados.add(lblNomeCargo);

		txtNomeCargo = new JTextField();
		txtNomeCargo.setBounds(66, 46, 270, 23);
		pnlDados.add(txtNomeCargo);
		txtNomeCargo.setColumns(10);

		pnlBotoes = new JPanel();
		pnlBotoes.setBounds(10, 401, 509, 32);
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
				atualizarRegistro();
				limparCampos();
				preencherGrid();
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
				excluirRegistro(Integer.parseInt(txtCargoID.getText()));
				limparCampos();
				preencherGrid();
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

		lblPesquisar = new JLabel("Digite o nome do cargo:");
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

	private void preencherGrid() {
		Cargo cargo = new Cargo();
		CargoControle cc = new CargoControle();
		CargoTableModel tm = new CargoTableModel();
		
		List<Cargo> listaCargo = new ArrayList<Cargo>();
		listaCargo = cc.listarTodosCargos(cargo);

		// Aqui eu adiciono cada linha da lista na jTable
		for (Cargo c : listaCargo) {
			tm.addRow(c);
		}

		table.setModel(tm);

		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);

		// Alinhamento do conteudo do JTable
		DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

		esquerda.setHorizontalAlignment(SwingConstants.LEFT);
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(1).setCellRenderer(esquerda);

		table.getTableHeader().setReorderingAllowed(true);
		// table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
	}

	private void selecionarRegistroGrid() {
		int linhaSelecionada = 0;

		linhaSelecionada = table.getSelectedRow(); // pega a linha selecionada

		txtCargoID
				.setText(String.valueOf(table.getValueAt(linhaSelecionada, 0)));
		txtNomeCargo.setText(String.valueOf(table.getValueAt(linhaSelecionada,
				1)));

		btnNovo.setEnabled(false);
		btnAtualizar.setEnabled(true);
		btnLimpar.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnFechar.setEnabled(false);
	}

	private void pesquisarNomeGrid(String nomeCargo) {
		CargoTableModel tm = new CargoTableModel();
		CargoControle cc = new CargoControle();

		List<Cargo> listaCargo = new ArrayList<Cargo>();
		listaCargo = cc.listarCargoPorNome(nomeCargo);

		// Aqui eu adiciono cada linha da lista na jTable
		for (Cargo c : listaCargo) {
			tm.addRow(c);
		}

		table.setModel(tm);

		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);

		// Alinhamento do conteudo do JTable
		DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();

		esquerda.setHorizontalAlignment(SwingConstants.LEFT);
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		table.getColumnModel().getColumn(1).setCellRenderer(esquerda);

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

		Cargo cargo = new Cargo();
		CargoControle cargoControle = new CargoControle();

		cargo.setCargoID(Integer.parseInt(txtCargoID.getText()));
		cargo.setNomeCargo(txtNomeCargo.getText());

		atualizado = cargoControle.atualizarRegistro(cargo);

		if (atualizado) {
			JOptionPane.showMessageDialog(null, MensagensType.ATUALIZADO);
		} else {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOATUALIZAR);
		}

		return atualizado;
	}

	private boolean excluirRegistro(int cargoID) {
		boolean excluido = false;

		CargoDAO cargoDAO = new CargoDAO();
		excluido = cargoDAO.excluirRegistro(cargoID);

		if (excluido) {
			JOptionPane.showMessageDialog(null, MensagensType.EXCLUIDO);
		} else {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOEXCLUIR);
		}

		return excluido;
	}

	private void limparCampos() {
		txtPesquisar.setText("");
		txtCargoID.setText("");
		txtNomeCargo.setText("");

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
