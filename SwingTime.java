import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;

public class SwingTime extends JFrame {
	private JTextField [] textField = new JTextField[4];
	private JLabel label;

	public SwingTime() {
		textField[0] = new JTextField(10);
		textField[1] = new JTextField(10);
		textField[2] = new JTextField(10);
		textField[3] = new JTextField(10);
		
		label = new JLabel("0.0");
		
		JButton button = new JButton("Add");
		button.addActionListener(new CalculateHandle());
		JButton ok = new JButton("OK");
		ok.addActionListener(new OkHandle());

		GridLayout gridLayout = new GridLayout(2,2);

		JPanel masterPanel = new JPanel();
		JPanel panel = new JPanel(gridLayout);
		JPanel flowPanel = new JPanel();
		masterPanel.add(panel,BorderLayout.CENTER);
		panel.add(textField[0]);
		panel.add(textField[1]);
		panel.add(textField[2]);
		panel.add(textField[3]);
	
		flowPanel.add(label);
		flowPanel.add(button);
		flowPanel.add(ok);
		flowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		masterPanel.add(flowPanel,BorderLayout.EAST);
		setContentPane(masterPanel);
	}

	public static void main(String[] args) {
		SwingTime driver = new SwingTime();
		driver.setSize(500,200);
		driver.setTitle("Calculator");
		driver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//driver.pack();
		driver.setVisible(true);
	}

	private class CalculateHandle implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double text1 = Double.parseDouble(textField[0].getText());
			double text2 = Double.parseDouble(textField[1].getText());
			double text3 = Double.parseDouble(textField[2].getText());
			double text4 = Double.parseDouble(textField[3].getText());
			double result = (text1 + text2 + text3 + text4);
			DecimalFormat format = new DecimalFormat("####.00");
			label.setText(String.valueOf(format.format(result)));
			JOptionPane.showMessageDialog(null, "The sum of your entries is:\n" + result);
		}
	}

	private class OkHandle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
