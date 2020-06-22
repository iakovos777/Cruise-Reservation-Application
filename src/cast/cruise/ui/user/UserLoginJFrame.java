package cast.cruise.ui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.DefaultJFrame;

@SuppressWarnings("serial")
public class UserLoginJFrame extends DefaultJFrame implements UserLoginView {

	private JPanel contentPane;
	private UserLoginPresenter presenter;

	private JPasswordField passJText;
	private JTextField emailJText;

	private JLabel passLabel;
	private JLabel emailLabel;

	private JButton loginButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginJFrame frame = new UserLoginJFrame();
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
	public UserLoginJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		passLabel = new JLabel();
		emailLabel = new JLabel();
		passLabel.setText("Password of user");
		emailLabel.setText("Email of user");

		passJText = new JPasswordField();
		emailJText = new JTextField();

		loginButton = new JButton();
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonActionPerformed(e);
			}
		});

		loginButton.setText("Login");

		cancelButton = new JButton();
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelButtonActionPerformed(e);
			}
		});
		cancelButton.setText("Cancel");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(loginButton)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(cancelButton))

								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(emailLabel).addComponent(passLabel))
										.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(emailJText).addComponent(passJText,
														GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
						.addGap(167)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)

						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(emailJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(emailLabel))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(passJText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passLabel))

						.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(loginButton)
								.addComponent(cancelButton))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		presenter.cancel();

	}

	private void loginButtonActionPerformed(ActionEvent evt) {
		presenter.verifyUser();
		if (presenter.isUserExist()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					presenter.cancel();
					UserJFrame uf = new UserJFrame();
					uf.setLocationRelativeTo(null);
					UserPresenter presenter2 = new UserPresenter(uf);
					presenter2.setUser(presenter.getUser());
					presenter2.start();
				}
			});
		}
	}

	@Override
	public void setPresenter(UserLoginPresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public String getPassword() {

		return String.valueOf(passJText.getPassword());
	}

	@Override
	public EmailAddress getEmail() {
		EmailAddress mail = new EmailAddress(emailJText.getText());
		return mail;

	}

}
