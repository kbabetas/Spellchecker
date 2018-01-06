package gr.aueb.dmst.dirtybits;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpellcheckerGui {

	public static void main(String[] args) {
		new SpellcheckerGui();

	}
	private Font font = new Font("Calibri", Font.BOLD, 15);
	
	private final String[] languageOptions = {"Greek/Ελληνικά", "English/Αγγλικά"};
	final JPanel languagePanel = new JPanel();
	JLabel languageLabel = new JLabel("Language/Γλώσσα:");
	
	final JComboBox languageTitle = new JComboBox(languageOptions);
	JButton confirmBut = new JButton("Confirm");
	final JPanel inputPanel = new JPanel();
	
	JLabel inputLabel = new JLabel("Κείμενο");
	final String[] englishInputOptions = {"Type a text","Give a file"};
	final String[] greekInputOptions = {"Δώσε ένα δικό σου κείμενο", "Δώσε ένα αρχείο της επιλογής σου"};
	JComboBox inputTitle = new JComboBox(greekInputOptions);
	int flag;
	
	public SpellcheckerGui() {
		JFrame guiFrame = new JFrame();
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Spellchecker");
		guiFrame.setSize(450,350);
		guiFrame.setLocationRelativeTo(null);
		
		
		languageTitle.setFont(font);
		languagePanel.add(languageLabel);
		languagePanel.add(languageTitle);
		languagePanel.setVisible(true);
		inputPanel.setVisible(false);	
		confirmBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String[] l;
				languagePanel.setVisible(false);
				int choice = languageTitle.getSelectedIndex();
				if (choice == 0) {
					l = greekInputOptions;
				} else {
					l = englishInputOptions;
				}
				inputPanel.add(inputLabel);
				inputPanel.add(inputTitle);
				inputPanel.setVisible(true);

				
			}
		 });
		guiFrame.add(languagePanel, BorderLayout.NORTH);
		guiFrame.add(inputPanel, BorderLayout.CENTER);
		guiFrame.add(confirmBut,BorderLayout.SOUTH);
		guiFrame.setVisible(true);
	}
}

