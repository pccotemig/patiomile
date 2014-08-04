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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patiomile.controle.UsuarioControle;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel pnlTitulo;
	private JLabel lblTitulo;

	private JPanel pnlLogin;
	private JLabel lblNomeUsuario;
	private JTextField txtNomeUsuario;
	private JLabel lblSenha;
	private JPasswordField pfSenhaUsuario;

	private JPanel pnlBotoes;
	private JButton btnLogin;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frmLogin = new TelaLogin();
					frmLogin.setTitle("Login");
					frmLogin.setLocationRelativeTo(null);
					frmLogin.setResizable(false);
					frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		initGUI();
	}

	private void initGUI() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 329, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlTitulo = new JPanel();
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(10, 11, 292, 84);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);

		lblTitulo = new JLabel("Login");
		lblTitulo
				.setIcon(new ImageIcon(
						"C:\\Users\\Paulo Silva\\workspace\\PatioMile\\img\\iconlogin.png"));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 11, 272, 62);
		pnlTitulo.add(lblTitulo);

		pnlLogin = new JPanel();
		pnlLogin.setBounds(10, 106, 292, 84);
		contentPane.add(pnlLogin);
		pnlLogin.setLayout(null);

		lblNomeUsuario = new JLabel("Nome Usu\u00E1rio:");
		lblNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNomeUsuario.setBounds(45, 18, 76, 14);
		pnlLogin.add(lblNomeUsuario);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(131, 14, 113, 23);
		pnlLogin.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSenha.setBounds(45, 50, 76, 14);
		pnlLogin.add(lblSenha);

		pfSenhaUsuario = new JPasswordField();
		pfSenhaUsuario.setBounds(131, 45, 113, 23);
		pnlLogin.add(pfSenhaUsuario);

		pnlBotoes = new JPanel();
		pnlBotoes.setBounds(10, 201, 292, 32);
		contentPane.add(pnlBotoes);
		pnlBotoes.setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean autenticado = false;

				autenticado = autenticarUsuario(txtNomeUsuario.getText(),
						String.valueOf(pfSenhaUsuario.getPassword()));

				if (autenticado) {
					TelaPrincipal frmPrincipal = new TelaPrincipal();
					frmPrincipal.setVisible(true);
				} else {
					JOptionPane
							.showMessageDialog(null,
									"Erro ao logar no sistema.\nNome de usuário ou senha inválidos!");
				}
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLogin.setBounds(38, 5, 89, 23);
		pnlBotoes.add(btnLogin);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(165, 5, 89, 23);
		pnlBotoes.add(btnLimpar);
	}

	private boolean autenticarUsuario(String strLogin, String strSenha) {
		boolean autenticado = false;
		UsuarioControle uc = new UsuarioControle();

		autenticado = uc.autenticarUsuario(strLogin, strSenha);

		return autenticado;
	}

	private void limparCampos() {
		txtNomeUsuario.setText("");
		pfSenhaUsuario.setText("");
	}
}
