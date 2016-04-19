package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import exceptions.ClienteException;
import persistencia.ClienteDAO;





public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	JLabel lblValidacao = new JLabel("New label");
	private JTextField txtNome;
	private JTextField txtidade;
	private JProgressBar progressBar = new JProgressBar();
	private static boolean retornou = false;
	private static boolean startProcess = false;
	JButton btnProgress = new JButton("Salvar Progress");
	 

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		progressBar.setVisible(false);
		URL iconURL = getClass().getResource("icon.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroCliente.class.getResource("/view/logoico.fw.png")));
		
		lblValidacao.setVisible(false);
		setTitle("Cadastro de Clientes");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBounds(0, 0, 434, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTexto = new JLabel("Informe os dados do cliente");
		lblTexto.setBounds(10, 11, 287, 14);
		panel.add(lblTexto);
		
		lblValidacao.setForeground(new Color(139, 0, 0));
		lblValidacao.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblValidacao.setBounds(10, 36, 414, 14);
		panel.add(lblValidacao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(139, 0, 0));
		panel_1.setBounds(0, 220, 434, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(CadastroCliente.class.getResource("/view/save.png")));
		btnSalvar.setForeground(new Color(0, 0, 0));
		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.setBounds(168, 11, 111, 23);
		panel_1.add(btnSalvar);
		
		btnNewButton = new JButton("Limpar");
		btnNewButton.setIcon(new ImageIcon(CadastroCliente.class.getResource("/view/limpar.png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(307, 11, 117, 23);
		panel_1.add(btnNewButton);
		btnProgress.setBackground(new Color(255, 255, 255));
		btnProgress.setIcon(new ImageIcon(CadastroCliente.class.getResource("/view/save.png")));
		
		btnProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				progressBar.setVisible(true);
				progressBar.setValue(0);
				retornou = false;
				startProcess = false;
				btnProgress.setEnabled(false);
				new Thread() {
					@Override
					public void run() {
						while(!retornou) {
							try {
								SwingUtilities.invokeLater(new Runnable() {
									public void run() {
										progressBar.setValue(progressBar.getValue() + 1);
									}
								});
								Thread.sleep(5);
							} catch (Exception e1) {
							}
						}
						
					}
				}.start();
				
				new Thread() {
					@Override
					public void run() {
						if (!startProcess) {
							startProcess = true;
						 	salvarCliente();
				 			retornou = true;
							progressBar.setVisible(false);
							btnProgress.setEnabled(true);
						}
					}
					}.start();					
			}
		});
		btnProgress.setBounds(10, 11, 134, 23);
		panel_1.add(btnProgress);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 67, 414, 142);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Nome");
		label.setBounds(10, 11, 129, 14);
		panel_2.add(label);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.BLACK);
		txtNome.setColumns(10);
		txtNome.setBackground(Color.WHITE);
		txtNome.setBounds(10, 36, 159, 20);
		panel_2.add(txtNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 64, 46, 14);
		panel_2.add(lblIdade);
		
		txtidade = new JTextField();
		txtidade.setColumns(10);
		txtidade.setBounds(10, 89, 159, 20);
		panel_2.add(txtidade);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(100);
		
		progressBar.setBounds(106, 120, 226, 14);
		panel_2.add(progressBar);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtidade.setText("");
				txtNome.setText("");
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				salvarCliente();
			}

			
		});
	}
	
	private void salvarCliente() {
		boolean validacao = false;
		lblValidacao.setVisible(false);
		
		if (txtNome.getText().equals("")){
			lblValidacao.setText("O campo nome é obrigatório");
			validacao = true;
		}else if (txtidade.getText().equals("")){
			lblValidacao.setText("O campo cpf é obrigatório");
			validacao = true;
		}
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			Integer idade = Integer.parseInt(txtidade.getText());
			clienteDAO.salvar(txtNome.getText(),idade);
			
		} catch (ClienteException e1) {
			validacao = true;
			lblValidacao.setText(e1.getMessage());
		}
			
		if (validacao) {
			lblValidacao.setForeground(new Color(139, 0, 0));
		}else{
			lblValidacao.setForeground(new Color(0, 0, 255));
			lblValidacao.setText("Cliente salvo com sucesso!");
		}
		
		
		lblValidacao.setVisible(true);
	}
}
