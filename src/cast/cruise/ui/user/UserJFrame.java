package cast.cruise.ui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.SwingUtilities;

import cast.cruise.ui.DefaultJFrame;
import cast.cruise.ui.reservation.ReservationListJFrame;
import cast.cruise.ui.reservation.ReservationListPresenter;

@SuppressWarnings("serial")
public class UserJFrame extends DefaultJFrame implements UserView {

	private JPanel contentPane;
	private UserPresenter presenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserJFrame frame = new UserJFrame();
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
	public UserJFrame() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnvr = new JButton("View reservations");
		btnvr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewreserveButtonActionPerformed(e);
			}
		});

		JButton btnmr = new JButton("Make reservation");
		btnmr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makereserveButtonActionPerformed(e);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(159)
										.addComponent(btnvr, GroupLayout.PREFERRED_SIZE, 138,
												GroupLayout.PREFERRED_SIZE)
										.addGap(148))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addContainerGap(160, Short.MAX_VALUE).addComponent(btnmr,
														GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
												.addGap(149)));

		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(50)
						.addComponent(btnvr, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(50)
						.addComponent(btnmr, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	private void viewreserveButtonActionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReservationListJFrame inst = new ReservationListJFrame();
				inst.setLocationRelativeTo(null);
				ReservationListPresenter presenter2 = new ReservationListPresenter(inst);
				presenter2.setUser(presenter.getUser());
				presenter2.start();
			}
		});

	}

	private void makereserveButtonActionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CruiseListUserJFrame inst = new CruiseListUserJFrame();
				inst.setLocationRelativeTo(null);
				CruiseListUserPresenter presenter2 = new CruiseListUserPresenter(inst);
				presenter2.setUser(presenter.getUser());
				presenter2.start();
			}
		});
	}

	@Override
	public void setPresenter(UserPresenter presenter) {
		this.presenter = presenter;

	}

}
