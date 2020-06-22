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

import cast.cruise.contacts.Address;
import cast.cruise.contacts.EmailAddress;

import cast.cruise.ui.DefaultJFrame;
import cast.cruise.ui.ViewRegistry;

@SuppressWarnings("serial")
public class NewHostJFrame extends DefaultJFrame implements NewHostView {

	private NewHostPresenter presenter;
	private JPanel contentPane;
	private JTextField hostIdJText;
	private JTextField nameJText;
	private JTextField addressJText;
	private JTextField emailJText;
	private JPasswordField passJText;

	private JButton btnSave;

	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewHostJFrame frame = new NewHostJFrame();
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
	public NewHostJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		hostIdJText = new JTextField();
		hostIdJText.setColumns(10);

		nameJText = new JTextField();
		nameJText.setColumns(10);

		addressJText = new JTextField();
		addressJText.setColumns(10);

		emailJText = new JTextField();
		emailJText.setColumns(10);

		passJText = new JPasswordField();
		passJText.setColumns(10);

		JLabel lblHostId = new JLabel("Host Id");

		JLabel lblAddress = new JLabel("Company Address");

		JLabel lblName = new JLabel("Company name");

		JLabel lblEmail = new JLabel("Email ");

		JLabel lblPass = new JLabel("Password for account");

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.save();
				if (!presenter.IdCommon()) {
					CruiseListHostView clView = ViewRegistry.getCruiseListHostView();
					CruiseListHostPresenter clPresenter = new CruiseListHostPresenter(clView);
					clPresenter.setHost(presenter.getHost());
					clPresenter.start();
					presenter.cancel();
				}
			}
		});

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.cancel();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnSave)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnCancel))

												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(lblHostId).addComponent(lblName)
																.addComponent(lblAddress).addComponent(lblEmail)
																.addComponent(lblPass))

														.addPreferredGap(ComponentPlacement.RELATED, 27,
																Short.MAX_VALUE)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(hostIdJText).addComponent(nameJText)
																.addComponent(addressJText).addComponent(emailJText)

																.addComponent(passJText, GroupLayout.DEFAULT_SIZE, 169,
																		Short.MAX_VALUE))))
										.addGap(167)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)

						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(hostIdJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHostId))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(nameJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(addressJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddress))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(emailJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(passJText,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPass))

						.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(btnSave).addComponent(btnCancel))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}

	@Override
	public void setPresenter(NewHostPresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public int getHostId() {

		return Integer.parseInt(hostIdJText.getText());
	}

	@Override
	public void setHostId(int HostNo) {
		hostIdJText.setText(Integer.toString(HostNo));

	}

	@Override
	public String getCompanyName() {

		return nameJText.getText();
	}

	@Override
	public void setCompanyName(String companyName) {
		nameJText.setText(companyName);

	}

	@Override
	public Address getCompanyAddress() {
		String add = addressJText.getText();
		Address address = new Address();
		String[] addr = add.split(",");
		if (addr.length == 5) {
			address.setStreet(addr[0]);
			address.setNumber(addr[1]);
			address.setCity(addr[2]);
			address.setCountry(addr[4]);
			address.setZipCode(addr[3]);
			return address;
		} else {
			return null;
		}
	}

	@Override
	public void setCompanyAddress(Address address) {
		String a = address.toString();
		addressJText.setText(a);

	}

	@Override
	public EmailAddress getCompanyEmail() {
		EmailAddress mail = new EmailAddress(emailJText.getText());
		return mail;
	}

	@Override
	public void setCompanyEmail(EmailAddress email) {
		emailJText.setText(email.toString());

	}

	@Override
	public String getPwd() {
		return String.valueOf(passJText.getPassword());
	}

	@Override
	public void setPwd(String pwd) {
		passJText.setText(pwd);

	}

}
