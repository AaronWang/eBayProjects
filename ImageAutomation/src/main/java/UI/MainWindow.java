package UI;

import imageAutomation.ImageAutomation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import properties.PropertyAgent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private PropertyAgent pa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();

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
	public MainWindow() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pa.setProperty("watermark1", textField_1.getText());
				pa.setProperty("watermark2", textField_2.getText());
				pa.setProperty("watermark3", textField_3.getText());
				pa.setProperty("watermark4", textField_4.getText());

				pa.setProperty("folder1", textField_5.getText());
				pa.setProperty("folder2", textField_6.getText());
				pa.setProperty("folder3", textField_7.getText());
				pa.setProperty("folder4", textField_8.getText());
				pa.saveProperty();
			}
		});
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// hide but still can be set to be visible.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//terminate this Object.
		
		setBounds(100, 100, 612, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Process");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageAutomation tool = new ImageAutomation();

				File file1 = new File(".\\overlayer\\" + textField_1.getText());
				File file2 = new File(".\\overlayer\\" + textField_2.getText());
				File file3 = new File(".\\overlayer\\" + textField_3.getText());
				File file4 = new File(".\\overlayer\\" + textField_4.getText());

				tool.AddWarterMark(textField_5.getText(), file1);
				tool.AddWarterMark(textField_6.getText(), file2);
				tool.AddWarterMark(textField_7.getText(), file3);
				tool.AddWarterMark(textField_8.getText(), file4);
			}
		});

		btnNewButton.setBounds(108, 402, 89, 23);
		contentPane.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setBounds(108, 63, 179, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(108, 128, 179, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(108, 193, 179, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(108, 257, 179, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblWatermarks = new JLabel("WaterMarks");
		lblWatermarks.setBounds(108, 26, 156, 14);
		contentPane.add(lblWatermarks);

		JLabel lblOutputFolder = new JLabel("Output Folder");
		lblOutputFolder.setBounds(358, 26, 156, 14);
		contentPane.add(lblOutputFolder);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(358, 63, 179, 30);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(358, 128, 179, 30);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(358, 193, 179, 30);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(358, 257, 179, 30);
		contentPane.add(textField_8);

		pa = new PropertyAgent();
		textField_1.setText(pa.getProperty("watermark1"));
		textField_2.setText(pa.getProperty("watermark2"));
		textField_3.setText(pa.getProperty("watermark3"));
		textField_4.setText(pa.getProperty("watermark4"));
		textField_5.setText(pa.getProperty("folder1"));
		textField_6.setText(pa.getProperty("folder2"));
		textField_7.setText(pa.getProperty("folder3"));
		textField_8.setText(pa.getProperty("folder4"));
	}
}
