/**
 * 
 */
package br.com.patiomile.teste;

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

import br.com.patiomile.controle.CargoControle;
import br.com.patiomile.modelo.Cargo;
import br.com.patiomile.tablemodel.CargoTableModel;
import br.com.patiomile.utilitario.MensagensType;

/**
 * @author Paulo Silva - Local
 * 
 */
public class TelaCargoTeste extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel pnlGrid;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel pnlDados;
	private JLabel lblNomeCargo;
	private JTextField txtCargoID;
	private JTextField txtNomeCargo;
	private JPanel pnlBotoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCargoTeste frame = new TelaCargoTeste();
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
	public TelaCargoTeste() {
		initGUI();
	}

	private void initGUI() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				preencherGrid();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlGrid = new JPanel();
		pnlGrid.setBorder(new TitledBorder(null,
				"Rela\u00E7\u00E3o dos Cargos", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlGrid.setBounds(10, 11, 414, 178);
		contentPane.add(pnlGrid);
		pnlGrid.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 394, 144);
		pnlGrid.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecionada = 0;
				linhaSelecionada = table.getSelectedRow();

				txtCargoID.setText(String.valueOf(table.getValueAt(
						linhaSelecionada, 0)));
				txtNomeCargo.setText(String.valueOf(table.getValueAt(
						linhaSelecionada, 1)));
			}
		});
		scrollPane.setViewportView(table);

		pnlDados = new JPanel();
		pnlDados.setBounds(10, 200, 414, 84);
		contentPane.add(pnlDados);
		pnlDados.setLayout(null);

		JLabel lblCargoID = new JLabel("C\u00F3digo:");
		lblCargoID.setBounds(10, 12, 80, 20);
		pnlDados.add(lblCargoID);

		lblNomeCargo = new JLabel("Cargo:");
		lblNomeCargo.setBounds(10, 47, 80, 20);
		pnlDados.add(lblNomeCargo);

		txtCargoID = new JTextField();
		txtCargoID.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCargoID.setEditable(false);
		txtCargoID.setBounds(100, 11, 60, 23);
		pnlDados.add(txtCargoID);
		txtCargoID.setColumns(10);

		txtNomeCargo = new JTextField();
		txtNomeCargo.setColumns(10);
		txtNomeCargo.setBounds(100, 46, 304, 23);
		pnlDados.add(txtNomeCargo);

		pnlBotoes = new JPanel();
		pnlBotoes.setBounds(10, 295, 414, 34);
		contentPane.add(pnlBotoes);
		pnlBotoes.setLayout(null);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gravarRegistro();
				limparCampos();
				preencherGrid();
			}
		});
		btnNovo.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNovo.setBounds(10, 5, 70, 23);
		pnlBotoes.add(btnNovo);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarRegistro();
				limparCampos();
				preencherGrid();
			}
		});
		btnAtualizar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAtualizar.setBounds(90, 5, 70, 23);
		pnlBotoes.add(btnAtualizar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(170, 5, 70, 23);
		pnlBotoes.add(btnLimpar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				excluirRegistro(Integer.parseInt(txtCargoID.getText()));
				limparCampos();
				preencherGrid();
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 11));
		btnExcluir.setBounds(250, 5, 70, 23);
		pnlBotoes.add(btnExcluir);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecharForm();
			}
		});
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFechar.setBounds(330, 5, 70, 23);
		pnlBotoes.add(btnFechar);
	}

	private void preencherGrid() {
		CargoTableModel tm = new CargoTableModel();

		Cargo cargo = new Cargo();
		CargoControle cc = new CargoControle();

		List<Cargo> listaCargo = new ArrayList<Cargo>();
		listaCargo = cc.listarTodosCargos(cargo);

		// Aqui eu adiciono cada linha da lista na jTable
		for (Cargo c : listaCargo) {
			tm.addRow(c);
		}

		table.setModel(tm);

		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);

		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);

	}

	private boolean gravarRegistro() {
		Cargo cargo = new Cargo();
		CargoControle cargoControle = new CargoControle();
		boolean retorno;

		cargo.setNomeCargo(txtNomeCargo.getText());

		retorno = cargoControle.gravarRegistro(cargo);

		if (retorno) {
			JOptionPane.showMessageDialog(null, MensagensType.INSERIDO);
		} else {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOINSERIR);
		}

		return retorno;
	}

	private boolean atualizarRegistro() {
		boolean atualizado;

		Cargo cargo = new Cargo();
		CargoControle cargoControle = new CargoControle();

		cargo.setCargoID(Integer.parseInt(txtCargoID.getText()));
		cargo.setNomeCargo(txtNomeCargo.getText());

		atualizado = cargoControle.atualizarRegistro(cargo);

		return atualizado;
	}

	private boolean excluirRegistro(int cargoID) {
		boolean excluido = false;

		CargoControle cargoControle = new CargoControle();
		excluido = cargoControle.excluirRegistro(cargoID);

		return excluido;
	}

	private void limparCampos() {
		txtCargoID.setText("");
		txtNomeCargo.setText("");
	}

	private void fecharForm() {
		dispose();
	}

}
