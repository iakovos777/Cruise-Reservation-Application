package cast.cruise.ui.host;

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

import cast.cruise.domain.Cruise;
import cast.cruise.ui.DefaultJFrame;

@SuppressWarnings("serial")
public class CruiseListHostJFrame extends DefaultJFrame implements CruiseListHostView {

	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JList cruiselist;

	private CruiseListHostPresenter presenter;
	private JButton btnAdd;

	private JButton btnRefresh;
	private DefaultListModel<Cruise> cruiseModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CruiseListHostJFrame frame = new CruiseListHostJFrame();
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
	public CruiseListHostJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.editSelected();
			}
		});

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
						+ " Positions: " + cruise.getPositions() + " Evaluation: " + cruise.getEvaluations();

				return super.getListCellRendererComponent(list, line, index, isSelected, cellHasFocus);
			}
		});

		cruiselist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.addCruise();
			}
		});

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presenter.refresh();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(btnAdd)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnEdit)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRefresh))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(18).addComponent(cruiselist,
										GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(70, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
										.addComponent(cruiselist, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnAdd).addComponent(btnEdit).addComponent(btnRefresh))
										.addContainerGap(74, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public void setPresenter(CruiseListHostPresenter presenter) {
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

}
