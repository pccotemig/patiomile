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

import br.com.patiomile.controle.MarcaControle;
import br.com.patiomile.modelo.Marca;
import br.com.patiomile.utilitario.MensagensType;

public class TelaCadastrarMarca extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel pnlTitulo;
	private JLabel lblTitulo;

	private JPanel pnlDados;
	private JLabel lblMarcaID;
	private JTextField txtMarcaID;
	private JLabel lblNomeMarca;
	private JTextField txtNomeMarca;

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
					TelaCadastrarMarca frame = new TelaCadastrarMarca();
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
	public TelaCadastrarMarca() {
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

		lblTitulo = new JLabel("Marcas");
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

		lblMarcaID = new JLabel("C\u00F3digo:");
		lblMarcaID.setFont(new Font("Arial", Font.PLAIN, 11));
		lblMarcaID.setBounds(10, 18, 46, 14);
		pnlDados.add(lblMarcaID);

		txtMarcaID = new JTextField();
		txtMarcaID.setEditable(false);
		txtMarcaID.setBounds(66, 14, 50, 23);
		pnlDados.add(txtMarcaID);
		txtMarcaID.setColumns(10);

		lblNomeMarca = new JLabel("Marca:");
		lblNomeMarca.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNomeMarca.setBounds(10, 50, 46, 14);
		pnlDados.add(lblNomeMarca);

		txtNomeMarca = new JTextField();
		txtNomeMarca.setBounds(66, 46, 269, 23);
		pnlDados.add(txtNomeMarca);
		txtNomeMarca.setColumns(10);

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
		Marca marca = new Marca();
		MarcaControle marcaControle = new MarcaControle();
		boolean inserido;

		marca.setNomeMarca(txtNomeMarca.getText());
		inserido = marcaControle.gravarRegistro(marca);

		if (inserido) {
			JOptionPane.showMessageDialog(null, MensagensType.INSERIDO);
		} else {
			JOptionPane.showMessageDialog(null, MensagensType.ERROAOINSERIR);
		}
		
		return inserido;
	}

	public void limparCampos() {
		txtMarcaID.setText("");
		txtNomeMarca.setText("");
	}

	public void fecharForm() {
		dispose();
	}

}
