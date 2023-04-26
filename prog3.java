//Student Class

package prog3;

public class Student {
String name;
String USN;
String address;
int age;
double cgpa;
Student(String name, int age, String USN, String address, double cgpa) {
this.name = name;
this.age = age;
this.USN = USN;
this.address = address;
this.cgpa = cgpa;
  }

String printDetails(){
return "----Printing the Details----\n" + "\nName : " + this.name + "\nAge : " +
this.age + "\nUSN : " + this.USN + "\nAddress : " + this.address + "\nCGPA : " +
this.cgpa;
}

}


//StudentClass

package prog3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentClass implements ActionListener {
	ArrayList<Student> studentList = new ArrayList<Student>();
	JFrame jf1 = new JFrame("Student INFO Index");
	JFrame jf2 = new JFrame("Student List");
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	
	JLabel jl1 = new JLabel("Enter name : ");
	JTextField jtf1 = new JTextField(20);
	JLabel jl2 = new JLabel("Enter USN : ");
	JTextField jtf2 = new JTextField(20);
	JLabel jl3 = new JLabel("Enter age : ");
	JTextField jtf3 = new JTextField(20);
	JLabel jl4 = new JLabel("Enter Address : ");
	JTextField jtf4 = new JTextField(20);
	JLabel jl5 = new JLabel("Enter sem 1 : ");
	JTextField jtf5 = new JTextField(20);
	JLabel jl6 = new JLabel("Enter sem 2 : ");
	JTextField jtf6 = new JTextField(20);
	JLabel jl7 = new JLabel("Enter sem 3 : ");
	JTextField jtf7 = new JTextField(20);
	JLabel jl8 = new JLabel("Enter sem 4 : ");
	JTextField jtf8 = new JTextField(20);
	JLabel jl9 = new JLabel("Enter sem 5 : ");
	JTextField jtf9 = new JTextField(20);
	JLabel jl10 = new JLabel("Enter sem 6 : ");
	JTextField jtf10 = new JTextField(20);
	JLabel jl11 = new JLabel("Enter sem 7 : ");
	JTextField jtf11 = new JTextField(20);
	JLabel jl12 = new JLabel("Enter sem 8 : ");
	JTextField jtf12 = new JTextField(20);
	JLabel jl20 = new JLabel("Result : ");
	JTextField jtf20 = new JTextField(20);
	
	JTextArea stud_list_display = new JTextArea(200,200);
	JButton jb1 = new JButton("Compute");
	JButton jb2 = new JButton("Done");
	JButton jb3 = new JButton("Display");
	
	StudentClass() {
		jf1.setSize(500,500);
		jf2.setSize(500,500);
		jf2.add(stud_list_display);
		
		jf1.add(jp1);
		
		jp1.add(jl1);
		jp1.add(jtf1);
		jp1.add(jl2);
		jp1.add(jtf2);
		jp1.add(jl3);
		jp1.add(jtf3);
		jp1.add(jl4);
		jp1.add(jtf4);
		jp1.add(jl5);
		jp1.add(jtf5);
		jp1.add(jl6);
		jp1.add(jtf6);
		jp1.add(jl7);
		jp1.add(jtf7);
		jp1.add(jl8);
		jp1.add(jtf8);
		jp1.add(jl9);
		jp1.add(jtf9);
		jp1.add(jl10);
		jp1.add(jtf10);
		jp1.add(jl11);
		jp1.add(jtf11);
		jp1.add(jl12);
		jp1.add(jtf12);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jl20);
		jp1.add(jtf20);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jf1.setVisible(true);
		jf2.setVisible(true);
	}
	
	public static void main(String[] args) {
		StudentClass sc1 = new StudentClass();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			System.out.println("Clicked To Compute CGPA");
			try
			{
				int v1=Integer.parseInt(jtf3.getText());
				if(v1<18 || v1>35)
				{
					JOptionPane.showMessageDialog(jtf1, "Enter valid Age");
					jtf3.requestFocus();
				}
			}
			catch(Exception exce) {
				JOptionPane.showMessageDialog(jtf1, "Invalid entry");
				jtf3.requestFocus();
			}
			checkSGPA(jtf5);
			checkSGPA(jtf6);
			checkSGPA(jtf7);
			checkSGPA(jtf8);
			checkSGPA(jtf9);
			checkSGPA(jtf10);
			checkSGPA(jtf11);
			checkSGPA(jtf12);
			double studentCGPA = calculateCGPA();
			jtf20.setText(Double.toString(studentCGPA));
		}
		else if(e.getSource()==jb2) {
			System.out.println("Clicked to Save the Student");
			Student s1 = new
					Student(jtf1.getText(),Integer.parseInt(jtf3.getText()),jtf2.getText(),jtf4.getText(),Double.parseDouble(jtf20.getText()));
			studentList.add(s1);
		}
		else{
			System.out.println("Clicked to display the collections");
			jtf1.setVisible(false);
			jtf2.setVisible(true);
			jtf2.setSize(500,500);
			stud_list_display.setText(" ");
			for(Student s:studentList)
			{
				stud_list_display.append(s.printDetails());
				stud_list_display.append("\n");
			}
			jtf1.setVisible(true);
		}
	}
	void checkSGPA(JTextField sgpa) {
		try {
			double gpa = Double.parseDouble(sgpa.getText());
			if(( gpa> 10)) {
				JOptionPane.showMessageDialog(sgpa, "Enter valid SGPA");
				sgpa.requestFocus();
			}
		}catch(Exception exec) {
			JOptionPane.showMessageDialog(sgpa, "Invalid Entry");
			sgpa.requestFocus();
		}
	}
	double calculateCGPA() {
		double v1 = Float.parseFloat(jtf5.getText());
		double v2 = Float.parseFloat(jtf6.getText());
		double v3 = Float.parseFloat(jtf7.getText());
		double v4 = Float.parseFloat(jtf8.getText());
		double v5 = Float.parseFloat(jtf9.getText());
		double v6 = Float.parseFloat(jtf10.getText());
		double v7 = Float.parseFloat(jtf11.getText());
		double v8 = Float.parseFloat(jtf12.getText());
		return (v1+v2+v3+v4+v5+v6+v7+v8)/8;
	}
}
