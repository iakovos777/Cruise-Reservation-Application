package cast.cruise.ui.reservation;

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

import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cast.cruise.domain.Reservation;
import cast.cruise.ui.DefaultJFrame;

@SuppressWarnings("serial")
public class ReservationListJFrame extends DefaultJFrame implements ReservationListView {

	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JList reslist;

	private ReservationListPresenter presenter;
	private JButton btnEval;
	private JButton btnPay;
	private JButton btnPrePay;

	private DefaultListModel<Reservation> resModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationListJFrame frame = new ReservationListJFrame();
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
	public ReservationListJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		resModel = new DefaultListModel();
		reslist = new JList();
		reslist.setModel(resModel);
		reslist.setCellRenderer(new DefaultListCellRenderer() {

			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Reservation res = (Reservation) value;
				String line = String.valueOf("Reservation Id: " + res.getReservationId()) + " Cruise id: "
						+ String.valueOf(res.getCruise().getCruiseId()) + " Destination: "
						+ res.getCruise().getDestination() + " Description: " + res.getCruise().getDescription()
						+ " State: " + String.valueOf(res.getCruise().getState()) + " Reservation date: "
						+ res.getReservationDate().toString();

				return super.getListCellRendererComponent(list, line, index, isSelected, cellHasFocus);
			}
		});

		reslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnEval = new JButton("Evaluate cruise");
		btnEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.evaluate();
			}
		});

		btnPay = new JButton("Pay for reservation");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.pay();
			}
		});

		btnPrePay = new JButton("Pre-pay for reservation");
		btnPrePay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.prePay();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(btnEval)

										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPay)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPrePay))

								.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(reslist,
										GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(70, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
								.addComponent(reslist, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGap(18)

								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnEval)
										.addComponent(btnPay).addComponent(btnPrePay))
								.addContainerGap(74, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

	@Override
	public void setPresenter(ReservationListPresenter presenter) {
		this.presenter = presenter;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void setReservations(List<Reservation> reserves) {
		resModel.clear();
		for (Reservation reserve : reserves) {
			resModel.addElement(reserve);
		}
		reslist.setModel(resModel);

	}

	@Override
	public Reservation getSelectedReserve() {
		return (Reservation) reslist.getSelectedValue();
	}

}
