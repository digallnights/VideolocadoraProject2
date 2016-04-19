package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

import java.awt.SystemColor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;


public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/view/logo.fw.png")));
		setTitle("IO MIDIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 78, 414, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Imagemlogo = new JLabel("");
		Imagemlogo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/IO_MEDIA.fw.png")));
		Imagemlogo.setBounds(0, 0, 414, 173);
		panel.add(Imagemlogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Salvar como...");
		mnArquivo.add(mntmSair);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ClickSair(evt);
			}
		});
		mnArquivo.add(mntmNewMenuItem);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmNovoCliente = new JMenuItem("Novo Cliente");
		mnCadastro.add(mntmNovoCliente);
		mntmNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CadastroCliente frame = new CadastroCliente();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		JMenuItem mntmNovoGnero = new JMenuItem("Novo G\u00EAnero");
		mnCadastro.add(mntmNovoGnero);
		
		JMenuItem mntmNovaMidia = new JMenuItem("Nova M\u00EDdia");
		mnCadastro.add(mntmNovaMidia);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnLocao = new JMenu("Pesquisa");
		menuBar.add(mnLocao);
		
		JMenuItem mntmClientes = new JMenuItem("Pesquisar...");
		mnLocao.add(mntmClientes);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rio");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmRelatrios = new JMenuItem("Relat\u00F3rios...");
		mnRelatrios.add(mntmRelatrios);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Sobre frame = new Sobre();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		panel_1.setBounds(10, 32, 414, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Nova Loca\u00E7\u00E3o");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/view/new.png")));
		btnNewButton.setBounds(0, 0, 147, 34);
		panel_1.add(btnNewButton);
	}
	private void ClickSair(java.awt.event.ActionEvent evt) {
		System.exit(0);

	}
}
