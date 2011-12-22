package ui.login;

import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;


//VS4E -- DO NOT REMOVE THIS LINE!
public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextField0;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JButton jButton0;
	private JPasswordField jPasswordField0;
	private JCheckBox jCheckBox0;

	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel2;

	private String URL = null;
	private ODatabaseDocumentTx database = null;
	private JLabel jLabel3;
	private JLabel jLabel4;
	public LoginPanel() {

		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(71, 10, 10), new Leading(47, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(71, 59, 10, 10), new Leading(109, 10, 10)));
		add(getJTextField0(), new Constraints(new Leading(178, 159, 10, 10), new Leading(41, 29, 12, 12)));
		add(getJPasswordField0(), new Constraints(new Leading(178, 159, 10, 10), new Leading(101, 29, 10, 10)));
		add(getJLabel2(), new Constraints(new Leading(71, 59, 10, 10), new Leading(162, 12, 12)));
		add(getJButton2(), new Constraints(new Leading(178, 12, 12), new Leading(157, 27, 10, 187)));
		add(getJButton0(), new Constraints(new Leading(256, 81, 12, 12), new Leading(287, 27, 10, 10)));
		add(getJCheckBox0(), new Constraints(new Leading(73, 10, 10), new Leading(229, 27, 10, 10)));
		add(getJButton1(), new Constraints(new Leading(205, 132, 12, 12), new Leading(228, 27, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(338, 10, 10), new Leading(99, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(259, 12, 12), new Leading(158, 10, 188)));
		setSize(400, 370);
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setVisible(false);
			jLabel4.setIcon(new ImageIcon(getClass().getResource("/icons/key-bindings-icon.png")));
			jLabel4.setText("");
		}
		return jLabel4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setVisible(false);
			jLabel3.setIcon(new ImageIcon(getClass().getResource("/icons/database-accept-icon.png")));
			jLabel3.setText("Selected");
		}
		return jLabel3;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Database");
		}
		return jLabel2;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Select");
			jButton2.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton2MouseMouseClicked(event);
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Forget Password");

		}
		return jButton1;
	}

	private JCheckBox getJCheckBox0() {
		if (jCheckBox0 == null) {
			jCheckBox0 = new JCheckBox();
			jCheckBox0.setText("Remember Me");
		}
		return jCheckBox0;
	}

	private JPasswordField getJPasswordField0() {
		if (jPasswordField0 == null) {
			jPasswordField0 = new JPasswordField();
			jPasswordField0.setEchoChar('•');
			jPasswordField0.addKeyListener(new KeyAdapter() {

				public void keyPressed(KeyEvent event) {
					jPasswordField0KeyKeyPressed(event);
				}
			});
			jPasswordField0.addFocusListener(new FocusAdapter() {

				public void focusGained(FocusEvent event) {
					jPasswordField0FocusFocusGained(event);
				}
			});
		}
		return jPasswordField0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("LogIn");
			jButton0.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jButton0MouseMouseClicked(event);
				}
			});
		}
		return jButton0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Password");
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Username");
		}
		return jLabel0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();

		}
		return jTextField0;
	}

	private String choosenDatabase(){

		JFileChooser chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Select Database Directory ...");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);


		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 

			return "local:/" + chooser.getSelectedFile().getPath();
		}

		return null;
	}

	private void jButton2MouseMouseClicked(MouseEvent event) {

		URL = choosenDatabase();
		
		if (URL != null) {
			
			jLabel3.setVisible(true);	
			
		} else {
			
			jLabel3.setVisible(false);
		}

	}

	private void jButton0MouseMouseClicked(MouseEvent event) {

		if (processLogin()) {
			
			JOptionPane.showMessageDialog(this, "WELCOME TO THE DASHBOARD!");
		}
		
	}

	private boolean processLogin(){

		String username = jTextField0.getText();
		String password = jPasswordField0.getText();

		if (URL != null) {

			try {

				database = new ODatabaseDocumentTx (URL).open(username, password);
				
				return true;
				
			} catch (Exception e) {

				JOptionPane.showMessageDialog(this, "PLEASE CHECK USERNAME OR PASSWORD");
			}

		} else {

			JOptionPane.showMessageDialog(this, "PLEASE SELECT DATABASE");
		}
		
		return false;
	}

	private void jPasswordField0FocusFocusGained(FocusEvent event) {

		boolean isCapsLockOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

		if (isCapsLockOn) {

			Toolkit.getDefaultToolkit().beep();
			jLabel4.setVisible(true);
			
		} else {
			
			jLabel4.setVisible(false);
		}

	}

	private void jPasswordField0KeyKeyPressed(KeyEvent event) {

		boolean isCapsLockOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

		if (isCapsLockOn) {

			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(this, "WARNING, CAPS LOCK ON");
			
		} else {
			
			jLabel4.setVisible(false);
		}
	}

}
