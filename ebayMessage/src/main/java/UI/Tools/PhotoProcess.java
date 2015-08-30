package UI.Tools;

import imageAutomation.ImageAutomation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import properties.PropertyAgent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashMap;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhotoProcess extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_8;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private PropertyAgent pa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhotoProcess frame = new PhotoProcess();
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
	public PhotoProcess() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("WaterMarks");

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setText("");
		textField_8.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setText("");
		textField_7.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setColumns(10);

		JLabel label_1 = new JLabel("Output Folder");

		pa = new PropertyAgent();
		textField_1.setText(pa.getProperty("watermark1"));
		textField_2.setText(pa.getProperty("watermark2"));
		textField_3.setText(pa.getProperty("watermark3"));
		textField_4.setText(pa.getProperty("watermark4"));
		textField_5.setText(pa.getProperty("folder1"));
		textField_6.setText(pa.getProperty("folder2"));
		textField_7.setText(pa.getProperty("folder3"));
		textField_8.setText(pa.getProperty("folder4"));

		JButton button = new JButton("Process");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file1 = new File(".\\overlayer\\" + textField_1.getText());
				File file2 = new File(".\\overlayer\\" + textField_2.getText());
				File file3 = new File(".\\overlayer\\" + textField_3.getText());
				File file4 = new File(".\\overlayer\\" + textField_4.getText());

				HashMap<String, File> accountWatermark = new HashMap<String, File>();
				accountWatermark.put(textField_5.getText(), file1);
				accountWatermark.put(textField_6.getText(), file1);
				accountWatermark.put(textField_7.getText(), file1);
				accountWatermark.put(textField_8.getText(), file1);
				PhotoProcessSequence photoProcess = new PhotoProcessSequence();
				photoProcess.processPhoto(accountWatermark);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(106)
						.addGroup(
								gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(label, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE).addGap(94)
														.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
														.addGap(71).addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
														.addGap(71).addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
														.addGap(71).addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_contentPane.createSequentialGroup().addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
														.addGap(71).addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(246, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(52)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label).addComponent(label_1))
						.addGap(23)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(35)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addGroup(
								gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)).addGap(72)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addContainerGap(80, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
