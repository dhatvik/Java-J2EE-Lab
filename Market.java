package p4;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Market implements ActionListener{
	
	JFrame f1=new JFrame("Customer details");
	
	JLabel jl1=new JLabel("Enter Customer Phone Number");
	JTextField phone=new JTextField(20);
	JLabel jl2=new JLabel(" Customer ID");
	JTextField cid=new JTextField(20);
	JButton check=new JButton("check_user");

	JLabel jl3=new JLabel("#1 Apple Rs 150/kg #2 Mango Rs100/kg");
	JLabel jl4=new JLabel("Enter Item Number u want to purchase");
	JTextField item_no=new JTextField(20);
	JLabel jl5=new JLabel("Enter Quantity");
	JTextField Kg=new JTextField(20);
	
	JRadioButton rb1=new JRadioButton("Discount 30%");
	JButton Bill =new JButton("Bill amount");
	JTextField am=new JTextField(20);
	
	HashMap<String , Integer>hm=new HashMap<String , Integer>();
	HashMap<Integer , Double>item=new HashMap<Integer , Double>();
	
	void add_coll() {
		hm.put("6362688458",121);
		hm.put("6362690510",122);
		hm.put("8217263545",123);
	}
	void add_item() {
		item.put(1,150.0);
		item.put(2, 100.0);
	}
	
	Market(){
		String uname=JOptionPane.showInputDialog(null,"Enter User Name=");
		String psw=JOptionPane.showInputDialog(null,"Enter Password=");
		add_coll();
		add_item();
		if(uname.equalsIgnoreCase("abc") && psw.equals("123")) {
			JOptionPane.showMessageDialog(null, "Valid User");
			f1.setSize(500,500);
			f1.setVisible(true);
			f1.setLayout(new FlowLayout());
			f1.add(jl1);
			f1.add(phone);
			f1.add(check);
			f1.add(jl2);
			f1.add(cid);
			check.addActionListener(this);
			f1.add(jl3);
			f1.add(jl4);
			f1.add(item_no);
			f1.add(jl5);
			f1.add(Kg);
			f1.add(rb1);
			f1.add(Bill);
			f1.add(am);
			Bill.addActionListener(this);		
		}
		else {
			JOptionPane.showMessageDialog(null,"Invalid User");
		}
		
	}
	public static void main(String[] args) {
		Market ob=new Market();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check) {
			String p1=phone.getText();
			if(hm.containsKey(p1)) {
				JOptionPane.showMessageDialog(null,"Old user id "+hm.get(p1));
				cid.setText(Integer.toString(hm.get(p1)));
			}
			else {
				hm.put(p1, 124);
				JOptionPane.showMessageDialog(null,"Old user id "+"124");
				cid.setText(Integer.toString(hm.get(p1)));
				
			}
		}
		
		else {
			double amount=0;
			if(item_no.getText().equals("1")) {
				amount=150*Integer.parseInt(Kg.getText());
			}
			if(item_no.getText().equals("2")) {
				amount=100*Integer.parseInt(Kg.getText());
			}
			if(rb1.isSelected()) {
				amount=amount-(amount*0.30);
			}
			am.setText("After Discount "+amount);
		}
	}
}
