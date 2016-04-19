package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/view/logo.fw.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("IO MIDIA");
		lblNewLabel.setIcon(new ImageIcon(Sobre.class.getResource("/view/logoico.fw.png")));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 71, 414, 24);
		contentPane.add(panel_1);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o");
		panel_1.add(lblVerso);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 97, 414, 24);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("1.00.00_01");
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 120, 414, 51);
		contentPane.add(panel_3);
	}
}
