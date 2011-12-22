package ui.login;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GeminiSkin;

//VS4E -- DO NOT REMOVE THIS LINE!
public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private LoginPanel loginPanel = null;

	private JTabbedPane jTabbedPane0;

	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public LoginForm() {
		
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJTabbedPane0(), new Constraints(new Leading(47, 400, 10, 10), new Leading(25, 370, 10, 10)));
		setSize(500, 479);
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();

			jTabbedPane0.addTab("Login", getLoginPanel());

		}
		return jTabbedPane0;
	}

	private LoginPanel getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new LoginPanel();
		}
		return loginPanel;
	}

	private static void installLnF() {
		try {

			SubstanceLookAndFeel.setSkin(new GeminiSkin());

		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginForm frame = new LoginForm();
				frame.setDefaultCloseOperation(LoginForm.EXIT_ON_CLOSE);
				frame.setTitle("LoginForm");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
