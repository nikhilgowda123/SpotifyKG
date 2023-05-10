package com.kde.groupe.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.kde.groupe.constants.CommonConstants;

//create class and extend with JFrame
public class QueryWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	// declare variable
	private JPanel contentPane;
	private JButton questionButton_1;
	private JButton questionButton_2;
	private JButton questionButton_4;
	private JButton questionButton_5;
	private JButton questionButton_6;
	private JButton questionButton_7;
	private JButton questionButton_8;
	private JButton questionButton_9;
	private JButton questionButton_10;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	private JLabel lblNewLabel_1_6;
	private JLabel lblNewLabel_1_7;
	private JLabel lblNewLabel_1_8;

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
					QueryWindow frame = new QueryWindow();
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
	 */
	public QueryWindow() // constructor
	{
		// set frame title
		setTitle("Competency Questions");
		// set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// set bounds of the frame
		setBounds(100, 100, 1280, 960);

		// create object of JPanel
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		// set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// set ContentPane
		setContentPane(contentPane);

		// label in the frame
		JLabel lblWelcome = new JLabel("Please select a Question of your choice");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		// set fore ground color to the label
		lblWelcome.setForeground(Color.decode("#0462B6"));
		// set font to the label
		lblWelcome.setFont(new Font("Menlo", Font.BOLD, 24));

		JButton questionButton_3 = new JButton(
				CommonConstants.QUERY_3_TEXT);
		questionButton_3.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_3.setBackground(Color.decode("#B1E5FE"));
		questionButton_3.setOpaque(true);
		questionButton_3.setBorderPainted(false);
		questionButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_3, CommonConstants.QUERY_3_HEADERS, 3);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_1 = new JButton(
				CommonConstants.QUERY_1_TEXT);
		questionButton_1.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_1.setBackground(Color.decode("#B1E5FE"));
		questionButton_1.setOpaque(true);
		questionButton_1.setBorderPainted(false);
		questionButton_1.setFocusPainted(false);
		questionButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_1, CommonConstants.QUERY_1_HEADERS, 1);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_2 = new JButton(
				CommonConstants.QUERY_2_TEXT);
		questionButton_2.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_2.setBackground(Color.decode("#B1E5FE"));
		questionButton_2.setOpaque(true);
		questionButton_2.setBorderPainted(false);
		questionButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_2, CommonConstants.QUERY_2_HEADERS, 2);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_4 = new JButton(CommonConstants.QUERY_4_TEXT);
		questionButton_4.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_4.setBackground(Color.decode("#00ACFF"));
		questionButton_4.setForeground(Color.decode("#FFFFFF"));
		questionButton_4.setOpaque(true);
		questionButton_4.setBorderPainted(false);
		questionButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_4, CommonConstants.QUERY_4_HEADERS, 4);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_5 = new JButton(CommonConstants.QUERY_5_TEXT);
		questionButton_5.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_5.setBackground(Color.decode("#00ACFF"));
		questionButton_5.setForeground(Color.decode("#FFFFFF"));
		questionButton_5.setOpaque(true);
		questionButton_5.setBorderPainted(false);
		questionButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_5, CommonConstants.QUERY_5_HEADERS, 5);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_6 = new JButton(
				CommonConstants.QUERY_6_TEXT);
		questionButton_6.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_6.setBackground(Color.decode("#B1E5FE"));
		questionButton_6.setOpaque(true);
		questionButton_6.setBorderPainted(false);
		questionButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_6, CommonConstants.QUERY_6_HEADERS, 6);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_7 = new JButton(CommonConstants.QUERY_7_TEXT);
		questionButton_7.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_7.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_7.setBackground(Color.decode("#B1E5FE"));
		questionButton_7.setOpaque(true);
		questionButton_7.setBorderPainted(false);
		questionButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_7, CommonConstants.QUERY_7_HEADERS, 7);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_8 = new JButton(CommonConstants.QUERY_8_TEXT);
		questionButton_8.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_8.setBackground(Color.decode("#B1E5FE"));
		questionButton_8.setOpaque(true);
		questionButton_8.setBorderPainted(false);
		questionButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_8, CommonConstants.QUERY_8_HEADERS, 8);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_9 = new JButton(CommonConstants.QUERY_9_TEXT);
		questionButton_9.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_9.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_9.setBackground(Color.decode("#B1E5FE"));
		questionButton_9.setOpaque(true);
		questionButton_9.setBorderPainted(false);
		questionButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_9, CommonConstants.QUERY_9_HEADERS, 9);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		questionButton_10 = new JButton(
				CommonConstants.QUERY_10_TEXT);
		questionButton_10.setFont(new Font("Menlo", Font.BOLD, 15));
		questionButton_10.setHorizontalAlignment(SwingConstants.LEFT);
		questionButton_10.setBackground(Color.decode("#B1E5FE"));
		questionButton_10.setOpaque(true);
		questionButton_10.setBorderPainted(false);
		questionButton_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ResultsWindow frame;
				frame = new ResultsWindow(CommonConstants.QUERY_10, CommonConstants.QUERY_10_HEADERS, 10);
				frame.setVisible(true);

				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		lblNewLabel = new JLabel("1");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		JLabel lblNewLabel_1_1 = new JLabel("3");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		JLabel lblNewLabel_1_2 = new JLabel("4");
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1_3 = new JLabel("5");
		lblNewLabel_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1_4 = new JLabel("6");
		lblNewLabel_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1_5 = new JLabel("7");
		lblNewLabel_1_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1_6 = new JLabel("8");
		lblNewLabel_1_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1_7 = new JLabel("9");
		lblNewLabel_1_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		lblNewLabel_1_8 = new JLabel("10");
		lblNewLabel_1_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(10)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWelcome, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 9,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 9,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 9,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 9,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 9,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 9,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 9,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 9,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel_1_8, GroupLayout.PREFERRED_SIZE, 19,
										GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(questionButton_1, GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
										.addComponent(questionButton_10, GroupLayout.DEFAULT_SIZE, 1034,
												Short.MAX_VALUE)
										.addComponent(questionButton_6, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
										.addComponent(questionButton_5, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
										.addComponent(questionButton_4, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
										.addComponent(questionButton_3, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(questionButton_2, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
										.addComponent(questionButton_7, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
										.addComponent(questionButton_8, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)
										.addComponent(questionButton_9, GroupLayout.DEFAULT_SIZE, 1034,
												Short.MAX_VALUE))))
				.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_1, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addGap(27)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_2, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_3, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_4, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_5, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(31)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_6, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_7, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_8, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_6, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(questionButton_9, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_7, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE))
								.addGap(32)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_8, GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(questionButton_10, GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(92, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}