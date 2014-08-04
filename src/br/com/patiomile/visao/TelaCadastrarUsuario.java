package br.com.patiomile.visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patiomile.controle.UsuarioControle;
import br.com.patiomile.modelo.GrupoUsuario;
import br.com.patiomile.modelo.Usuario;

public class TelaCadastrarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel pnlTitulo;
	private JLabel lblTitulo;

	private JPanel pnlDados;
	private JLabel lblUsuarioID;
	private JTextField txtUsuarioID;
	private JLabel lblNomeUsuario;
	private JTextField txtNomeUsuario;
	private JLabel lblEmailUsuario;
	private JLabel lblLoginUsuario;
	private JFormattedTextField ftEmail;
	private JTextField txtLoginUsuario;
	private JLabel lblSenhaUsuario;
	private JPasswordField pfSenhaUsuario;
	private JLabel lblConfirmaSenha;
	private JPasswordField pfConfirmaSenha;
	private JLabel lblUsuarioAtivo;
	private JLabel lblGrupoUsuario;
	private JComboBox<String> cboGrupoUsuario;
	private JCheckBox chckbxUsuarioAtivo;

	private JPanel pnlBotoes;
	private JButton btnGravar;
	private JButton btnLimpar;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarUsuario frame = new TelaCadastrarUsuario();
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
	public TelaCadastrarUsuario() {
		initGUI();
	}

	private void initGUI() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				preencherComboGrupoUsuario();

			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 374);
		setTitle("Cadastrar Usuário");
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlTitulo = new JPanel();
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(10, 11, 471, 84);
		contentPane.add(pnlTitulo);
		pnlTitulo.setLayout(null);

		lblTitulo = new JLabel("Usu\u00E1rio");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 11, 451, 62);
		pnlTitulo.add(lblTitulo);

		pnlDados = new JPanel();
		pnlDados.setBounds(10, 106, 471, 175);
		contentPane.add(pnlDados);
		pnlDados.setLayout(null);

		lblUsuarioID = new JLabel("C\u00F3digo:");
		lblUsuarioID.setBounds(10, 9, 80, 14);
		pnlDados.add(lblUsuarioID);

		txtUsuarioID = new JTextField();
		txtUsuarioID.setEditable(false);
		txtUsuarioID.setBounds(100, 5, 50, 23);
		pnlDados.add(txtUsuarioID);
		txtUsuarioID.setColumns(10);

		lblNomeUsuario = new JLabel("Nome:");
		lblNomeUsuario.setBounds(10, 37, 80, 14);
		pnlDados.add(lblNomeUsuario);

		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(100, 33, 357, 23);
		pnlDados.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);

		lblEmailUsuario = new JLabel("E-mail:");
		lblEmailUsuario.setBounds(10, 65, 80, 14);
		pnlDados.add(lblEmailUsuario);

		ftEmail = new JFormattedTextField();
		ftEmail.setBounds(100, 61, 357, 23);
		pnlDados.add(ftEmail);

		lblLoginUsuario = new JLabel("Login:");
		lblLoginUsuario.setBounds(10, 93, 80, 14);
		pnlDados.add(lblLoginUsuario);

		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(100, 89, 130, 23);
		pnlDados.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);

		lblSenhaUsuario = new JLabel("Senha:");
		lblSenhaUsuario.setBounds(10, 121, 80, 14);
		pnlDados.add(lblSenhaUsuario);

		pfSenhaUsuario = new JPasswordField();
		pfSenhaUsuario.setBounds(100, 117, 130, 23);
		pnlDados.add(pfSenhaUsuario);

		lblUsuarioAtivo = new JLabel("Usu\u00E1rio Ativo:");
		lblUsuarioAtivo.setBounds(10, 150, 80, 14);
		pnlDados.add(lblUsuarioAtivo);

		lblGrupoUsuario = new JLabel("Grupo Usu\u00E1rio:");
		lblGrupoUsuario.setBounds(237, 150, 80, 14);
		pnlDados.add(lblGrupoUsuario);

		cboGrupoUsuario = new JComboBox<String>();
		cboGrupoUsuario.setBounds(327, 146, 130, 23);
		pnlDados.add(cboGrupoUsuario);

		chckbxUsuarioAtivo = new JCheckBox("Sim");
		chckbxUsuarioAtivo.setBounds(100, 145, 97, 23);
		pnlDados.add(chckbxUsuarioAtivo);

		lblConfirmaSenha = new JLabel("Confirma Senha:");
		lblConfirmaSenha.setBounds(237, 122, 80, 14);
		pnlDados.add(lblConfirmaSenha);

		pfConfirmaSenha = new JPasswordField();
		pfConfirmaSenha.setBounds(327, 117, 130, 23);
		pnlDados.add(pfConfirmaSenha);

		pnlBotoes = new JPanel();
		pnlBotoes.setBounds(10, 292, 471, 32);
		contentPane.add(pnlBotoes);
		pnlBotoes.setLayout(null);

		btnGravar = new JButton("Gravar");
		btnGravar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String senha, confirmaSenha;
				senha = String.valueOf(pfSenhaUsuario.getPassword());
				confirmaSenha = String.valueOf(pfConfirmaSenha.getPassword());

				if (senha.equals(confirmaSenha)) {
					if (gravarRegistro()) {
						JOptionPane.showMessageDialog(null,
								"Registro inserido com sucesso!");
						limparCampos();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"As senhas não são iguais!");
				}
			}
		});
		btnGravar.setBounds(51, 4, 89, 23);
		pnlBotoes.add(btnGravar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(191, 4, 89, 23);
		pnlBotoes.add(btnLimpar);

		btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecharForm();
			}
		});
		btnFechar.setBounds(331, 4, 89, 23);
		pnlBotoes.add(btnFechar);
	}

	private void preencherComboGrupoUsuario() {
		cboGrupoUsuario.removeAllItems();

		UsuarioControle usuarioControle = new UsuarioControle();

		List<GrupoUsuario> array = new ArrayList<GrupoUsuario>();
		array = usuarioControle.listarTodosGruposUsuarios();

		for (int i = 0; i < array.size(); i++) {
			cboGrupoUsuario.addItem(array.get(i).getNomeGrupoUsuario());
		}
	}

	private boolean gravarRegistro() {
		boolean inserido = false;
		int grupoUsuarioID = 0;

		Usuario usuario = new Usuario();
		UsuarioControle usuarioControle = new UsuarioControle();

		usuario.setNome(txtNomeUsuario.getText());
		usuario.setEmail(ftEmail.getText());
		usuario.setLogin(txtLoginUsuario.getText());
		usuario.setSenha(String.valueOf(pfSenhaUsuario.getPassword()));
		usuario.setUsuarioAtivo(chckbxUsuarioAtivo.isSelected());
		grupoUsuarioID = usuarioControle.buscarCodigo(String
				.valueOf(cboGrupoUsuario.getSelectedItem()));
		usuario.setGrupoUsuarioID(grupoUsuarioID);

		inserido = usuarioControle.inserirUsuario(usuario);

		return inserido;
	}

	private void limparCampos() {
		txtUsuarioID.setText("");
		txtNomeUsuario.setText("");
		ftEmail.setText("");
		txtLoginUsuario.setText("");
		pfSenhaUsuario.setText("");
		pfConfirmaSenha.setText("");
		chckbxUsuarioAtivo.setSelected(false);
		cboGrupoUsuario.setSelectedItem(null);
	}

	private void fecharForm() {
		dispose();
	}
}
