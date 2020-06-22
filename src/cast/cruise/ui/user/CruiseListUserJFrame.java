package cast.cruise.ui.user;

import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cast.cruise.domain.Cruise;
import cast.cruise.ui.DefaultJFrame;

@SuppressWarnings("serial")
public class CruiseListUserJFrame extends DefaultJFrame implements CruiseListUserView {

	private JPanel contentPane;

	@SuppressWarnings("rawtypes")
	private JList cruiselist;

	private CruiseListUserPresenter presenter;
	private JButton btnReserve;
	private JTextField pos;
	private JLabel poslab;

	private JButton btnCancel;
	private DefaultListModel<Cruise> cruiseModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CruiseListUserJFrame frame = new CruiseListUserJFrame();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CruiseListUserJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pos = new JTextField();
		pos.setColumns(10);
		poslab = new JLabel("Positions to reserve");

		cruiseModel = new DefaultListModel();
		cruiselist = new JList();
		cruiselist.setModel(cruiseModel);

		cruiselist.setCellRenderer(new DefaultListCellRenderer() {

			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Cruise cruise = (Cruise) value;
				String line = String.valueOf("Cruise Id: " + cruise.getCruiseId()) + "," + " Destination: "
						+ cruise.getDestination() + "," + " Cost:  " + cruise.getCost() + "," + " Description: "
						+ cruise.getDescription() + "," + " Departure date: " + cruise.getDepartureDate() + ","
						+ " Arrival date: " + cruise.getArrivalDate() + "," + " State: " + cruise.getState() + ","
						+ " Positions: " + cruise.getPositions();

				return super.getListCellRendererComponent(list, line, index, isSelected, cellHasFocus);
			}
		});

		cruiselist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnReserve = new JButton("Reservation");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (presenter.reservation()) {
					presenter.refresh();
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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(btnReserve)

										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancel))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(poslab))
										.addPreferredGap(ComponentPlacement.RELATED, 27, 30)

										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(pos, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(cruiselist,
										GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(70, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
						.addComponent(cruiselist, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)

						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(pos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(poslab))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnReserve)
								.addComponent(btnCancel))
						.addContainerGap(74, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void setPresenter(CruiseListUserPresenter presenter) {
		this.presenter = presenter;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void setCruises(List<Cruise> cruises) {
		cruiseModel.clear();
		for (Cruise cruise : cruises) {
			cruiseModel.addElement(cruise);
		}
		cruiselist.setModel(cruiseModel);
	}

	@Override
	public Cruise getSelectedCruise() {
		return (Cruise) cruiselist.getSelectedValue();
	}

	@Override
	public int getPositions() {

		return Integer.parseInt(pos.getText());
	}

	@Override
	public void setPositions(int position) {
		pos.setText(Integer.toString(position));

	}

}
