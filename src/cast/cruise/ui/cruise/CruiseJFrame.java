package cast.cruise.ui.cruise;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cast.cruise.contacts.EmailAddress;
import cast.cruise.ui.DefaultJFrame;

public class CruiseJFrame extends DefaultJFrame implements CruiseView {

	private static final long serialVersionUID = 2986246662691677145L;

	private CruisePresenter presenter;

	private JPanel contentPane;

	private JTextField positionsJText;
	private JTextField cruiseIdJText;
	private JTextField costJText;
	private JTextField infoEmailJText;
	private JTextField prePaidAmountJText;
	private JTextField departureDateJText;
	private JTextField arrivalDateJText;
	private JTextField durationJText;
	private JTextField startJText;
	private JTextField destinationJText;
	private JTextField descriptionJText;
	private JTextField prePaidAllJText;

	private JButton btnSave;

	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CruiseJFrame frame = new CruiseJFrame();
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
	public CruiseJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		positionsJText = new JTextField();
		positionsJText.setColumns(10);

		cruiseIdJText = new JTextField();
		cruiseIdJText.setColumns(10);

		costJText = new JTextField();
		costJText.setColumns(10);

		infoEmailJText = new JTextField();
		infoEmailJText.setColumns(10);

		prePaidAmountJText = new JTextField();
		prePaidAmountJText.setColumns(10);

		prePaidAllJText = new JTextField();
		prePaidAllJText.setColumns(10);

		durationJText = new JTextField();
		durationJText.setColumns(10);

		descriptionJText = new JTextField();
		descriptionJText.setColumns(10);

		destinationJText = new JTextField();
		destinationJText.setColumns(10);

		departureDateJText = new JTextField();
		departureDateJText.setColumns(10);

		arrivalDateJText = new JTextField();
		arrivalDateJText.setColumns(10);

		startJText = new JTextField();
		startJText.setColumns(10);

		JLabel lblPositions = new JLabel("Positions");

		JLabel lblCruiseId = new JLabel("Cruise Id");

		JLabel lblCost = new JLabel("Cost");

		JLabel lblDescription = new JLabel("Description of cruise");

		JLabel lblDestination = new JLabel("Destination of cruise");

		JLabel lblStart = new JLabel("From where starts the cruise");

		JLabel lblArrivalDate = new JLabel("Arrival Date");

		JLabel lblDepartureDate = new JLabel("Departure Date");

		JLabel lblInfoMail = new JLabel("Email for informations");

		JLabel lblDuration = new JLabel("Duration of cruise");

		JLabel lblPrePaidAll = new JLabel("Pre paid all the amount(YES/NO)");

		JLabel lblPrePaidAmount = new JLabel("Pre paid amount ");

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.save();
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
																.addComponent(lblCruiseId).addComponent(lblCost)
																.addComponent(lblPositions).addComponent(lblDescription)
																.addComponent(lblDestination)
																.addComponent(lblArrivalDate).addComponent(lblStart)
																.addComponent(lblDepartureDate)
																.addComponent(lblInfoMail).addComponent(lblPrePaidAll)
																.addComponent(lblPrePaidAmount)
																.addComponent(lblDuration))
														.addPreferredGap(ComponentPlacement.RELATED, 27,
																Short.MAX_VALUE)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(cruiseIdJText).addComponent(costJText)
																.addComponent(positionsJText)
																.addComponent(descriptionJText)
																.addComponent(destinationJText)
																.addComponent(arrivalDateJText).addComponent(startJText)
																.addComponent(departureDateJText)
																.addComponent(infoEmailJText)
																.addComponent(prePaidAllJText)
																.addComponent(prePaidAmountJText)
																.addComponent(durationJText, GroupLayout.DEFAULT_SIZE,
																		169, Short.MAX_VALUE))))
										.addGap(167)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)

						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cruiseIdJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCruiseId))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(costJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCost))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(positionsJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPositions))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(descriptionJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescription))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(destinationJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDestination))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(arrivalDateJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblArrivalDate))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(startJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStart))
						.addPreferredGap(ComponentPlacement.UNRELATED)

						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(departureDateJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDepartureDate))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(infoEmailJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInfoMail))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(prePaidAllJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrePaidAll))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(prePaidAmountJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrePaidAmount))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(durationJText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDuration))
						.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE).addGroup(gl_contentPane
								.createParallelGroup(Alignment.BASELINE).addComponent(btnSave).addComponent(btnCancel))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}

	@Override
	public void setPresenter(CruisePresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public int getCruiseId() {
		return Integer.parseInt(cruiseIdJText.getText());
	}

	@Override
	public void setCruiseId(int cruiseNo) {
		cruiseIdJText.setText(Integer.toString(cruiseNo));

	}

	@Override
	public int getPositions() {
		return Integer.parseInt(positionsJText.getText());
	}

	@Override
	public void setPositions(int positions) {
		positionsJText.setText(Integer.toString(positions));

	}

	@Override
	public String getDepartureDate() {
		return departureDateJText.getText();
	}

	@Override
	public void setDepartureDate(String dp) {
		departureDateJText.setText(dp);

	}

	@Override
	public String getArrivalDate() {
		return arrivalDateJText.getText();
	}

	@Override
	public void setArrivalDate(String ap) {
		arrivalDateJText.setText(ap);

	}

	@Override
	public String getStart() {
		return startJText.getText();
	}

	@Override
	public void setStart(String st) {
		startJText.setText(st);

	}

	@Override
	public String getDestination() {
		return destinationJText.getText();
	}

	@Override
	public void setDestination(String dst) {
		destinationJText.setText(dst);

	}

	@Override
	public String getDescription() {
		return descriptionJText.getText();
	}

	@Override
	public void setDescription(String dsc) {
		descriptionJText.setText(dsc);

	}

	@Override
	public int getCost() {
		return Integer.parseInt(costJText.getText());
	}

	@Override
	public void setCost(int cst) {
		costJText.setText(Integer.toString(cst));

	}

	@Override
	public int getPrePaidAmount() {
		return Integer.parseInt(prePaidAmountJText.getText());
	}

	@Override
	public void setPrePaidAmount(int ppa) {
		prePaidAmountJText.setText(Integer.toString(ppa));

	}

	@Override
	public int getDuration() {
		return Integer.parseInt(durationJText.getText());
	}

	@Override
	public void setDuration(int drt) {
		durationJText.setText(Integer.toString(drt));

	}

	@Override
	public EmailAddress getEmail() {
		EmailAddress mail = new EmailAddress(infoEmailJText.getText());
		return mail;
	}

	@Override
	public void setEmail(EmailAddress mail) {
		
		infoEmailJText.setText(String.valueOf(mail));
		

	}

	@Override
	public boolean getPrePaidAll() {
		if (infoEmailJText.getText().equalsIgnoreCase("Yes")) {
			return true;
		}
		return false;
	}

	@Override
	public void setPrePaidAll(boolean all) {
		prePaidAllJText.setText(String.valueOf(all));

	}

}
