package br.com.patiomile.visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JMenuBar menuBar;

	private JMenu mnCadastro;
	private JMenuItem mntmCadastroCargo;
	private JSeparator separator;
	private JMenuItem mntmCadastroSair;

	private JMenu mnConsulta;

	private JMenu mnRelatorio;
	private JMenuItem mntmConsultaCargo;
	private JMenuItem mntmCadastroUsuario;
	private JMenuItem mntmConsultaUsuario;
	private JMenuItem mntmConsultaMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		initGUI();
	}

	private void initGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);

		mntmCadastroCargo = new JMenuItem("Cargo");
		mntmCadastroCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaCadastrarCargo();
			}
		});
		mnCadastro.add(mntmCadastroCargo);

		mntmCadastroUsuario = new JMenuItem("Usu\u00E1rio");
		mntmCadastroUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaCadastrarUsuario();
			}
		});

		JMenuItem mntmCadastroMarca = new JMenuItem("Marca");
		mntmCadastroMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaCadastrarMarca();
			}
		});
		mnCadastro.add(mntmCadastroMarca);
		mnCadastro.add(mntmCadastroUsuario);

		separator = new JSeparator();
		mnCadastro.add(separator);

		mntmCadastroSair = new JMenuItem("Sair");
		mntmCadastroSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecharSistema();
			}
		});
		mnCadastro.add(mntmCadastroSair);

		mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);

		mntmConsultaCargo = new JMenuItem("Cargo");
		mntmConsultaCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaConsultarCargo();
			}
		});
		mnConsulta.add(mntmConsultaCargo);

		mntmConsultaUsuario = new JMenuItem("Usu\u00E1rio");
		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaConsultarUsuario();
			}
		});

		mntmConsultaMarca = new JMenuItem("Marca");
		mntmConsultaMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirJanelaConsultarMarca();
			}
		});
		mnConsulta.add(mntmConsultaMarca);
		mnConsulta.add(mntmConsultaUsuario);

		mnRelatorio = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorio);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void abrirJanelaCadastrarCargo() {
		TelaCadastrarCargo frmCargo = new TelaCadastrarCargo();
		frmCargo.setVisible(true);
	}

	private void abrirJanelaCadastrarMarca() {
		TelaCadastrarMarca frmMarca = new TelaCadastrarMarca();
		frmMarca.setVisible(true);
	}

	private void abrirJanelaCadastrarUsuario() {
		TelaCadastrarUsuario frmUsuario = new TelaCadastrarUsuario();
		frmUsuario.setVisible(true);
	}

	private void abrirJanelaConsultarCargo() {
		TelaConsultarCargo frmCargo = new TelaConsultarCargo();
		frmCargo.setVisible(true);
	}

	private void abrirJanelaConsultarMarca() {
		TelaConsultarMarca frmMarca = new TelaConsultarMarca();
		frmMarca.setVisible(true);
	}

	private void abrirJanelaConsultarUsuario() {
		TelaConsultarUsuario frmUsuario = new TelaConsultarUsuario();
		frmUsuario.setVisible(true);
	}

	public void fecharSistema() {
		int sair = -1;
		sair = JOptionPane.showConfirmDialog(null,
				"Tem certeza que deseja Sair do Sistema?", "Confirma Sair",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (sair == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else {
		}
	}
}
