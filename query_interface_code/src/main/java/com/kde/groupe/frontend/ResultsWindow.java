package com.kde.groupe.frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.lang3.StringUtils;

import com.kde.groupe.backend.QueryProcessor;
import com.kde.groupe.constants.CommonConstants;

//create class and extend with JFrame
public class ResultsWindow extends JFrame {
	private static final long serialVersionUID = 1621359396860895774L;
	// declare variable
	private JPanel contentPane;
	private JTable table;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	static String queryText;
	static int QueryNumber;
	static String[] tableHeaders;

	/**
	 * Launch the application.
	 */
	// main method
	public static void main(String[] args) {
		/*
		 * It posts an event (Runnable)at the end of Swings event list and is processed
		 * after all other GUI events are processed.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// try - catch block
				try {
					// Create object of NewWindow
					ResultsWindow frame = new ResultsWindow(queryText, tableHeaders, QueryNumber);
					frame.setPreferredSize(new Dimension(1024, 768));
					frame.pack();
					frame.setLocationRelativeTo(null);
					// set frame visible true
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public ResultsWindow(String queryText, String[] headerNames, int queryNumber) // constructor
	{
		// set frame title
		setTitle("Results");
		// set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// set bounds of the frame
		setBounds(100, 100, 1280, 960);

		// create object of JPanel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		// set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// set ContentPane
		setContentPane(contentPane);

		// label in the frame
		JLabel lblWelcome = new JLabel("Results");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		// set fore ground color to the label
		lblWelcome.setForeground(Color.decode("#0462B6"));
		// set font to the label
		lblWelcome.setFont(new Font("Menlo", Font.BOLD, 24));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(32)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)));

		ArrayList<String[]> sdg = QueryProcessor.processQuery(queryText);
		int columns = headerNames.length;
		int rows = sdg.size();
		Object[][] newArray = new Object[rows][columns];
		int count = 0;
		for (String[] array : sdg) {
			for (int i = 0; i < array.length; i++) {

				if (array[i].startsWith("https://")) {
					
					try {
						
						URL url = new URL(array[i]);
						BufferedImage image = ImageIO.read(url);
						ImageIcon imageIcon = new ImageIcon(image);
						newArray[count][i] = scaleImage(imageIcon, 150, 150);
					}
					catch(IOException e)
					{
						newArray[count][i] = "Not able to load Image";
					}
				} else if (array[i].contains("^^")) {
					double num = Double.parseDouble(StringUtils.substringBefore(array[i], "^^"));
					newArray[count][i] = df.format(num);
				} else if (array[i].contains("\\n") && queryNumber == 1) {
					String ns = array[i].replace("\\n", "<br>");
					ns = ns.replace("[\\", "<html><br><br>");
					ns = ns.substring(0, ns.length() - 1) + "<br></html>";
					ns = ns.replace(CommonConstants.QUERY_1_LYRICS_HIGHLIGHT_WORD,
							"<span style=\"font-size:18px;color:#FF5D00\"><strong><u>"+CommonConstants.QUERY_1_LYRICS_HIGHLIGHT_WORD+"<u></strong></span>");
					newArray[count][i] = ns;
				} else
					newArray[count][i] = array[i];
			}
			count++;
		}

		DefaultTableModel model = new DefaultTableModel(newArray, headerNames);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {
				if (queryNumber == 1 || queryNumber == 7 || queryNumber == 8)
					return Object.class;
				else
					return (column == 1) ? Icon.class : Object.class;
			}

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				@SuppressWarnings("unused")
				JComponent jc = (JComponent) c;

				// Alternate row color

				if (!isRowSelected(row))
					c.setBackground(row % 2 == 0 ? Color.decode("#DFF6FF") : Color.decode("#FFFFFF"));

				return c;
			}

		};

		table.setFont(new Font("Menlo", Font.BOLD, 14));

		if (queryNumber == 1)
			updateRowHeights(1, 200, table);
		else {
			table.setRowHeight(150);
			table.setRowMargin(10);
		}
		table.getTableHeader().setFont(new Font("Menlo", Font.BOLD, 18));
		table.getTableHeader().setBackground(Color.decode("#38B0FF"));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setOpaque(true);
		UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

	}

	public static void updateRowHeights(int column, int width, JTable table) {
		for (int row = 0; row < table.getRowCount(); row++) {
			int rowHeight = table.getRowHeight();
			Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
			Dimension d = comp.getPreferredSize();
			// first set the size to the new width
			comp.setSize(new Dimension(width, d.height));
			// then get the preferred size
			d = comp.getPreferredSize();
			rowHeight = Math.max(rowHeight, d.height);
			// finally set the height of the table
			table.setRowHeight(row, rowHeight);
		}
	}

	public ImageIcon scaleImage(ImageIcon icon, int w, int h) {
		int nw = icon.getIconWidth();
		int nh = icon.getIconHeight();

		if (icon.getIconWidth() > w) {
			nw = w;
			nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
		}

		if (nh > h) {
			nh = h;
			nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
		}

		return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
	}

}
