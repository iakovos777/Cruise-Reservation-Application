package cast.cruise.ui.reservation;

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
import javax.swing.border.EmptyBorder;

import cast.cruise.ui.DefaultJFrame;

@SuppressWarnings("serial")
public class EvaluationJFrame extends DefaultJFrame implements EvaluationView {

	private JPanel contentPane;
	private EvaluationPresenter presenter;

	private JTextField rateField;
	private JLabel rateLabel;
	private JTextField comField;
	private JLabel comLabel;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluationJFrame frame = new EvaluationJFrame();
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
	public EvaluationJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		rateLabel = new JLabel();
		rateLabel.setText("Rating of cruise");

		rateField = new JTextField();

		comLabel = new JLabel();
		comLabel.setText("Comments for cruise");

		comField = new JTextField();

		okButton = new JButton();
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okActionPerformed(e);
			}
		});
		okButton.setText("OK");

		cancelButton = new JButton();
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelButtonActionPerformed(e);
			}
		});
		cancelButton.setText("Cancel");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(rateLabel, GroupLayout.PREFERRED_SIZE, 140,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4).addComponent(rateField, GroupLayout.PREFERRED_SIZE, 142,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(comLabel, GroupLayout.PREFERRED_SIZE, 140,
												GroupLayout.PREFERRED_SIZE)
										.addGap(4).addComponent(comField, GroupLayout.PREFERRED_SIZE, 142,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(116)
										.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE)
										.addGap(16).addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 90,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(174, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(26).addGap(16)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
																.addComponent(rateLabel))
														.addComponent(rateField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(16)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
																.addComponent(comLabel))
														.addComponent(comField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))

												.addGap(58)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(okButton).addComponent(cancelButton))
												.addContainerGap(127, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void cancelButtonActionPerformed(ActionEvent e) {
		presenter.cancel();

	}

	protected void okActionPerformed(ActionEvent e) {
		presenter.evaluate();

	}

	@Override
	public void setPresenter(EvaluationPresenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public String getRating() {
		return rateField.getText();
	}

	@Override
	public String getComment() {
		return comField.getText();
	}

	@Override
	public void setRating(String rate) {
		rateField.setText(rate);

	}

	@Override
	public void setComment(String com) {
		comField.setText(com);

	}

}
