package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "Total Correct Answer = " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			 label.setText("Q1:  Which of the following doesn't have a superclass?");
			radioButton[0].setText("System");
			radioButton[1].setText("Object");
			radioButton[2].setText("Lang");
			radioButton[3].setText("Exception");
		}
		if (current == 1) {
			label.setText("Q2:  Which provides runtime environment for java byte code to excute?");
			radioButton[0].setText("JDK");
			radioButton[1].setText("JVM");
			radioButton[2].setText("JRE");
			radioButton[3].setText("JAVAC");
		}
		if (current == 2) {
			label.setText("Q3: Which of the following is not a Java features.");
			radioButton[0].setText("Dynamic");
			radioButton[1].setText("Architecture Neutral");
			radioButton[2].setText("Use of pointers");
			radioButton[3].setText("Object-oriented");
		}
		if (current == 3) {
			label.setText("Q4: What is the return type of the hashCode() method in the Object class?");
			radioButton[0].setText("Object");
			radioButton[1].setText("int");
			radioButton[2].setText("long");
			radioButton[3].setText("void");
		}
		if (current == 4) {
			label.setText("Q5:  In which process, a local variable has the same name as one of the instance variables?");
			radioButton[0].setText("Serialization");
			radioButton[1].setText("Variable Shadowing");
			radioButton[2].setText("Abstraction");
			radioButton[3].setText("Multi-threading");
		}
		if (current == 5) {
			label.setText("Q6: Which package contains the Random class?");
			radioButton[0].setText("java.util package");
			radioButton[1].setText("java.lang package");
			radioButton[2].setText("java.awt package");
			radioButton[3].setText("java.io package");
		}
		if (current == 6) {
			label.setText("Q7:  In java, jar stands for_____?");
			radioButton[0].setText("Java Archive Runner");
			radioButton[1].setText("Java Application Resource");
			radioButton[2].setText("Java Application Runner");
			radioButton[3].setText("None of the above");
		}
		if (current == 7) {
			label.setText("Q8:  Which one is a template for creating different objects?");
			radioButton[0].setText("An Array");
			radioButton[1].setText("A class");
			radioButton[2].setText("Interface");
			radioButton[3].setText("Method");
		}
		if (current == 8) {
			label.setText("Q9: Which of the following are not Java keywords.");
			radioButton[0].setText("double");
			radioButton[1].setText("switch");
			radioButton[2].setText("then");
			radioButton[3].setText("instanceof");
		}
		if (current == 9) {
			label.setText("Q10: Which of these is returned by operator '&'?");
			radioButton[0].setText("Integer");
			radioButton[1].setText("Character");
			radioButton[2].setText("Boolean");
			radioButton[3].setText("Float");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[1].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[3].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {new OnlineTest("Online Quiz");
	}

}
