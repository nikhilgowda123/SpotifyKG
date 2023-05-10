package com.kde.groupe.frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//create class and extend with JFrame
public class Welcome extends JFrame {
	private static final long serialVersionUID = 1L;
	// declare variable
	private JPanel contentPane;

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
					// Create object of OldWindow
					Welcome frame = new Welcome();
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
	public Welcome()// constructor
	{
		// set frame title
		setTitle("Welcome to Musicology");
		// set default close operation
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// set bounds of the frame
		setBounds(100, 100, 700, 500);
		// create object of JPanel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		// set border
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// set ContentPane
		setContentPane(contentPane);

		// create object of JButton and set label on it
		JButton btnNewFrame = new JButton("Click here to Explore");
		btnNewFrame.setBackground(Color.decode("#00ACFF"));
		btnNewFrame.setForeground(Color.decode("#FFFFFF"));
		btnNewFrame.setOpaque(true);
		btnNewFrame.setBorderPainted(false);
		btnNewFrame.setFocusPainted(false);
		// add actionListener
		btnNewFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// call the object of NewWindow and set visible true
				QueryWindow frame = new QueryWindow();
				frame.setVisible(true);
				// set default close operation
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		// set font of the Button
		btnNewFrame.setFont(new Font("Menlo", Font.BOLD, 14));

		// set Label in the frame
		JLabel lblThisIsOld = new JLabel("Musicology");
		lblThisIsOld.setHorizontalAlignment(SwingConstants.CENTER);
		// set foreground color to the label
		lblThisIsOld.setForeground(SystemColor.inactiveCaptionText);
		// set font of that label
		lblThisIsOld.setFont(new Font("Avenir", Font.BOLD, 27));

		JLabel lblByKdeGroup = new JLabel("By Group - E");
		lblByKdeGroup.setForeground(Color.BLACK);
		lblByKdeGroup.setFont(new Font("Menlo", Font.BOLD, 13));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image musicology = new ImageIcon(this.getClass().getResource("/musicology_logo.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(musicology));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblThisIsOld, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(199)
						.addComponent(btnNewFrame, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE).addGap(204))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(578, Short.MAX_VALUE).addComponent(lblByKdeGroup).addGap(22)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
						.addGap(12)
						.addComponent(lblThisIsOld, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addComponent(btnNewFrame, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE).addGap(8)
						.addComponent(lblByKdeGroup, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)));
		contentPane.setLayout(gl_contentPane);
	}
}