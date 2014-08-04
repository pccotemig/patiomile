package br.com.patiomile.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patiomile.controle.CargoControle;
import br.com.patiomile.modelo.Cargo;
import br.com.patiomile.utilitario.MensagensType;

public class TelaCadastrarCargo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel pnlTitulo;
	private JLabel lblTitulo;

	private JPanel pnlDados;
	private JLabel lblCargoID;
	private JTextField txtCargoID;
	private JLabel lblNomeCargo;
	private JTextField txtNomeCargo;

	private JPanel pnlBotoes;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarCargo frame = new TelaCadastrarCargo();
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
	public TelaCadastrarCargo() {
		initGUI();
	}

	private void initGUI() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 275);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlTitulo = new JPanel();
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(10, 11, 345, 84);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);

		lblTitulo = new JLabel("Cargos");
		lblTitulo
				.setIcon(new ImageIcon(
						"C:\\Users\\Paulo Silva\\workspace\\PatioMile\\img\\cargo1.jpg"));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 11, 310, 62);
		pnlTitulo.add(lblTitulo);

		pnlDados = new JPanel();
		pnlDados.setBounds(10, 106, 345, 84);
		contentPane.add(pnlDados);
		pnlDados.setLayout(null);

		lblCargoID = new JLabel("C\u00F3digo:");
		lblCargoID.setBounds(10, 18, 46, 14);
		pnlDados.add(lblCargoID);

		txtCargoID = new JTextField();
		txtCargoID.setEditable(false);
		txtCargoID.setBounds(66, 14, 50, 23);
		pnlDados.add(txtCargoID);
		txtCargoID.setColumns(10);

		lblNomeCargo = new JLabel("Cargo:");
		lblNomeCargo.setBounds(10, 50, 46, 14);
		pnlDados.add(lblNomeCargo);

		txtNomeCargo = new JTextField();
		txtNomeCargo.setBounds(66, 46, 269, 23);
		pnlDados.add(txtNomeCargo);
		txtNomeCargo.setColumns(10);

		pnlBotoes = new JPanel();
		pnlBotoes.setBounds(10, 201, 345, 32);
		contentPane.add(pnlBotoes);
		pnlBotoes.setLayout(null);

		btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gravarRegistro();
				limparCampos();
			}
		});
		btnGravar.setBounds(19, 4, 89, 23);
		pnlBotoes.add(btnGravar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(127, 4, 89, 23);
		pnlBotoes.add(btnLimpar);

		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecharForm();
			}
		});
		btnSair.setBounds(235, 4, 89, 23);
		pnlBotoes.add(btnSair);
	}

	public boolean gravarRegistro() {
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

	public void limparCampos() {
		txtCargoID.setText("");
		txtNomeCargo.setText("");
	}

	public void fecharForm() {
		dispose();
	}

}
