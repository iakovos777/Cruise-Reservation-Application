package cast.cruise.ui.host;

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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cast.cruise.ui.DefaultJFrame;
import cast.cruise.ui.ViewRegistry;

@SuppressWarnings("serial")
public class HostLoginJFrame extends DefaultJFrame implements HostLoginView {

	private JPanel contentPane;
	private HostLoginPresenter presenter;

	private JPasswordField pwdJText;
	private JTextField cnameJText;
	private JLabel pwdLabel;
	private JLabel cnameLabel;
	private JButton loginButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostLoginJFrame frame = new HostLoginJFrame();
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
	public HostLoginJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pwdLabel = new JLabel();
		cnameLabel = new JLabel();
		pwdLabel.setText("Password of Host");
		cnameLabel.setText("The name of company");

		pwdJText = new JPasswordField();
		cnameJText = new JTextField();

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
												.addComponent(cnameLabel).addComponent(pwdLabel))
										.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(cnameJText).addComponent(pwdJText,
														GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
						.addGap(167)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)

						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cnameJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cnameLabel))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(pwdJText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwdLabel))

						.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(loginButton)
								.addComponent(cancelButton))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}

	@Override
	public void setPresenter(HostLoginPresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public String getPwd() {

		return String.valueOf(pwdJText.getPassword());
	}

	@Override
	public String getCompanyName() {
		return cnameJText.getText();
	}

	private void loginButtonActionPerformed(ActionEvent evt) {
		if (presenter.verifyHost()) {
			presenter.cancel();
			CruiseListHostView clView = ViewRegistry.getCruiseListHostView();
			CruiseListHostPresenter clPresenter = new CruiseListHostPresenter(clView);
			clPresenter.setHost(presenter.getHost());
			clPresenter.start();
		}
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		presenter.cancel();
	}

}
