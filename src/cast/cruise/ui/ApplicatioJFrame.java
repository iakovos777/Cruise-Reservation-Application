package cast.cruise.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;

import cast.cruise.datastore.Data;
//import cast.cruise.datastore.DataWrite;
import cast.cruise.memory.DataMemory;
//import cast.cruise.memory.DataWriteMemory;
import cast.cruise.ui.cruise.CruiseListJFrame;
import cast.cruise.ui.cruise.CruiseListPresenter;
import cast.cruise.ui.host.HostLoginJFrame;
import cast.cruise.ui.host.HostLoginPresenter;
import cast.cruise.ui.host.NewHostJFrame;
import cast.cruise.ui.host.NewHostPresenter;
import cast.cruise.ui.user.NewUserJFrame;
import cast.cruise.ui.user.NewUserPresenter;
import cast.cruise.ui.user.UserLoginJFrame;
import cast.cruise.ui.user.UserLoginPresenter;

import javax.swing.LayoutStyle.ComponentPlacement;

public class ApplicatioJFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Data data = new DataMemory();
		// DataWrite write = new DataWriteMemory();
		data.readData();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicatioJFrame window = new ApplicatioJFrame();

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// write.saveData();
	}

	/**
	 * Create the frame.
	 */
	public ApplicatioJFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btncruiseList = new JButton("Cruises");
		btncruiseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						CruiseListJFrame inst = new CruiseListJFrame();
						CruiseListPresenter presenter = new CruiseListPresenter(inst);
						presenter.start();
					}

				});
			}
		});

		JButton btnNewUser = new JButton("New User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUserButtonActionPerformed(e);
			}
		});

		JButton btnLoginUser = new JButton("Login of user");
		btnLoginUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUserButtonActionPerformed(e);
			}
		});

		JButton btnNewHost = new JButton("New host");
		btnNewHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newHostButtonActionPerformed(e);
			}
		});

		JButton btnLoginHost = new JButton("Login of host");
		btnLoginHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginHostButtonActionPerformed(e);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnLoginUser, GroupLayout.PREFERRED_SIZE, 138,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewHost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnLoginHost, GroupLayout.PREFERRED_SIZE, 132,
												GroupLayout.PREFERRED_SIZE))
								.addGap(51))
				.addGroup(groupLayout.createSequentialGroup().addGap(132)
						.addComponent(btncruiseList, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(147, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLoginUser, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoginHost, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGap(44)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewUser, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewHost, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addComponent(btncruiseList, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
	}

	private void loginUserButtonActionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UserLoginJFrame inst = new UserLoginJFrame();
				inst.setLocationRelativeTo(null);
				UserLoginPresenter presenter = new UserLoginPresenter(inst);
				presenter.start();
			}
		});
	}

	private void newUserButtonActionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewUserJFrame inst = new NewUserJFrame();
				inst.setLocationRelativeTo(null);
				NewUserPresenter presenter = new NewUserPresenter(inst);
				presenter.start();
			}
		});
	}

	private void loginHostButtonActionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HostLoginJFrame inst = new HostLoginJFrame();
				inst.setLocationRelativeTo(null);
				HostLoginPresenter presenter = new HostLoginPresenter(inst);
				presenter.start();
			}
		});
	}

	private void newHostButtonActionPerformed(ActionEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewHostJFrame inst = new NewHostJFrame();
				inst.setLocationRelativeTo(null);
				NewHostPresenter presenter = new NewHostPresenter(inst);
				presenter.start();
			}
		});

	}

}
