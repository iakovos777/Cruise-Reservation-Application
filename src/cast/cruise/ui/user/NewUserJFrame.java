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

import cast.cruise.contacts.Address;
import cast.cruise.contacts.CardElements;
import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.DefaultJFrame;

@SuppressWarnings("serial")
public class NewUserJFrame extends DefaultJFrame implements NewUserView {

	private NewUserPresenter presenter;
	private JPanel contentPane;
	private JTextField userIdJText;
	private JTextField fnameJText;
	private JTextField addressJText;
	private JTextField emailJText;
	private JPasswordField passJText;
	private JTextField lnameJText;
	private JTextField cardJText;
	private JTextField telJText;

	private JButton btnSave;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserJFrame frame = new NewUserJFrame();
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
	public NewUserJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		userIdJText = new JTextField();
		userIdJText.setColumns(10);

		fnameJText = new JTextField();
		fnameJText.setColumns(10);

		lnameJText = new JTextField();
		lnameJText.setColumns(10);

		addressJText = new JTextField();
		addressJText.setColumns(10);

		emailJText = new JTextField();
		emailJText.setColumns(10);

		cardJText = new JTextField();
		cardJText.setColumns(10);

		telJText = new JTextField();
		telJText.setColumns(10);

		passJText = new JPasswordField();

		passJText.setColumns(10);

		JLabel lblUserId = new JLabel("User Id");

		JLabel lblAddress = new JLabel("Your address");

		JLabel lblFname = new JLabel("Firstname");

		JLabel lblLname = new JLabel("Lastname");

		JLabel lblEmail = new JLabel("Email ");

		JLabel lblCard = new JLabel("Data of your credit card ");

		JLabel lblTel = new JLabel("Your telephone's number");

		JLabel lblPass = new JLabel("Password for account");

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.save();
				if (!presenter.IdCommon()) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							UserJFrame uf = new UserJFrame();
							uf.setLocationRelativeTo(null);
							UserPresenter presenter2 = new UserPresenter(uf);
							presenter2.setUser(presenter.getUser());
							presenter2.start();
						}
					});

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
																.addComponent(lblUserId).addComponent(lblLname)
																.addComponent(lblFname).addComponent(lblAddress)
																.addComponent(lblEmail).addComponent(lblTel)
																.addComponent(lblCard).addComponent(lblPass))

														.addPreferredGap(ComponentPlacement.RELATED, 27,
																Short.MAX_VALUE)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(userIdJText).addComponent(lnameJText)
																.addComponent(fnameJText).addComponent(addressJText)
																.addComponent(emailJText).addComponent(telJText)
																.addComponent(cardJText).addComponent(passJText,
																		GroupLayout.DEFAULT_SIZE, 169,
																		Short.MAX_VALUE))))
										.addGap(167)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)

						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(userIdJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUserId))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lnameJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLname))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(fnameJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFname))
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
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(telJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTel))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cardJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCard))
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
	public void setPresenter(NewUserPresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public int getUserId() {

		return Integer.parseInt(userIdJText.getText());
	}

	@Override
	public void setUserId(int usNo) {
		userIdJText.setText(Integer.toString(usNo));

	}

	@Override
	public String getFirstName() {
		return fnameJText.getText();
	}

	@Override
	public void setFirstName(String firstname) {
		fnameJText.setText(firstname);

	}

	@Override
	public String getLastName() {
		return lnameJText.getText();
	}

	@Override
	public void setLastName(String lastname) {
		lnameJText.setText(lastname);

	}

	@Override
	public Address getAddress() {
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
	public void setAddress(Address address) {
		addressJText.setText(address.toString());

	}

	@Override
	public EmailAddress getEmail() {
		EmailAddress mail = new EmailAddress(emailJText.getText());
		return mail;
	}

	@Override
	public void setEmail(EmailAddress email) {
		emailJText.setText(email.toString());
	}

	@Override
	public String getPassword() {
		return String.valueOf(passJText.getPassword());
	}

	@Override
	public void setPassword(String pass) {
		passJText.setText(pass);

	}

	@Override
	public CardElements getCard() {
		String card = cardJText.getText();

		String[] crc = card.split(",");
		if (crc.length == 4) {
			CardElements ce = new CardElements();
			ce.setNumberCard(crc[0]);
			ce.setExpireDate(crc[1]);
			ce.setName(crc[2]);
			ce.setCV(crc[3]);
			return ce;
		} else {
			return null;
		}
	}

	@Override
	public void setCard(CardElements crd) {
		cardJText.setText(crd.toString());

	}

	@Override
	public void setTelephone(int tel) {
		telJText.setText(String.valueOf(tel));

	}

	@Override
	public int getTelephone() {
		return Integer.parseInt(telJText.getText());
	}

}
