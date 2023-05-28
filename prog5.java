//Main Class

package prog5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
public class Main extends JFrame implements ActionListener {
	JFrame jf = new JFrame("JDBC");
	JPanel jp = new JPanel();
	static Connection c;
	static Statement s;
	JLabel cno = new JLabel("Enter a cutomer no : ");
	JTextField cNumber = new JTextField(20);
	JLabel cn = new JLabel("Enter a customer name : ");
	JTextField cName = new JTextField(20);
	JLabel cs = new JLabel("Enter a cutomer state : ");
	JTextField cState = new JTextField(20);
	JLabel ccl = new JLabel("Enter a cutomer credit limit : ");
	JTextField cCreditlimit = new JTextField(20);
	JLabel crepNo = new JLabel("Enter a repno of customer : ");
	JTextField crepNumber = new JTextField(20);
	JButton jb1 = new JButton("Submit");
	public Main() {
		jf.setSize(500,500);
		jf.add(jp);
		jp.add(cno);
		jp.add(cNumber);
		jp.add(cn);
		jp.add(cName); jp.add(cs);
		jp.add(cState);
		jp.add(ccl);
		jp.add(cCreditlimit);
		jp.add(crepNo);
		jp.add(crepNumber);
		jp.add(jb1);
		jb1.addActionListener(this);
		jf.setVisible(true); }
	public static void main(String [] args) throws Exception {

		Main s1 = new Main();
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "msrit");
		System.out.println(c.toString());
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			int customernumber = Integer.parseInt(cNumber.getText());
			String customername = cName.getText();
			String customerstate = cState.getText();
			int customercreditlimit = Integer.parseInt(cCreditlimit.getText());
			int customerreponumber = Integer.parseInt(crepNumber.getText());
			if(customercreditlimit > 15000) {
				System.out.println(customernumber);
				System.out.println(customername);System.out.println(customerstate);
				System.out.println(customercreditlimit);
				System.out.println(customerreponumber); }
			try{
				s =(Statement)c.createStatement();
				String queryToExecute = String.format("insert into customer (custno, custname, state, creditLimit,repNo) values (%d, '%s', '%s', %d, %d)", customernumber ,customername , customerstate,customercreditlimit, customerreponumber);
				int rs = s.executeUpdate(queryToExecute);
				String custAbove15k = String.format("select * from customer where creditLimit > 15000");
				ResultSet rs1 = s.executeQuery(custAbove15k);
				while(rs1.next()){
					System.out.print("ID: " + rs1.getInt("custno"));
					System.out.print(", Name: " + rs1.getString("custname"));
					System.out.print(", Last: " + rs1.getString("state"));
					System.out.print(", CreditLimit: " +
							rs1.getInt("creditLimit"));
					System.out.println(", Rep No: " + rs1.getInt("repNo")); }
				s.close();
				c.close();
			}catch(Exception err){
				System.out.println(err);
			}
		}
	}
}




// method2

package p5;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class GUI_1 implements ActionListener{
	static Connection con;
	
	static JFrame jf=new JFrame("JDBC + SWINGS");
	static JTextField cusno=new JTextField(20);
	static JTextField cusname=new JTextField(20);
	static JTextField cusstate=new JTextField(20);
	static JTextField cuscredlim=new JTextField(20);
	static JTextField cusrepo=new JTextField(20);
	static JButton insertbutton=new JButton("Insert");
	static JButton f=new JButton("Cred>15k");
	static JTextArea res=new JTextArea(50,50);
	
	static void eastablishDbConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="123";
		con=DriverManager.getConnection(url,username,password);
		if(con!=null) {
			System.out.println("Connection established Successfully");
			
		}
		else
			System.out.println("Connection not established");
	}
	
	public static void main(String[] args) throws Exception{
		eastablishDbConnection();
		
		jf.setSize(800,600);
		jf.setLayout(new BoxLayout(jf.getContentPane(),BoxLayout.Y_AXIS));
		jf.add(new JLabel("Enter Customer Number"));
		jf.add(cusno);
		jf.add(new JLabel("Enter Customer Name"));
		jf.add(cusname);
		jf.add(new JLabel("Enter Customer state"));
		jf.add(cusstate);
		jf.add(new JLabel("Enter Customer Creditlimit"));
		jf.add(cuscredlim);
		jf.add(new JLabel("Enter Customer Repo"));
		jf.add(cusrepo);
		jf.add(insertbutton);
		
		jf.add(new JLabel("Click below to display cred lim>15k"));
		jf.add(f);
		
		jf.add(res);
		
		insertbutton.addActionListener(new GUI_1());
		f.addActionListener(new GUI_1());
		
		jf.setVisible(true);
		jf.pack();	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insertbutton) {
			System.out.println("Hell");
			try {
				
				Statement s=con.createStatement();
				String InsertQ="insert into customer values ("+cusno.getText()+",'"+cusname.getText()+"','"+cusstate.getText()+"',"+cuscredlim.getText()+","+cusrepo.getText()+")";
				s.executeUpdate(InsertQ);
			}
			catch(SQLException s) {
				System.out.println(s.toString());
			}
			
		}
		if(e.getSource()==f ) {
			try {
				Statement s=con.createStatement();
				String ins;
				ins="select * from customer where cust_cl>15000";
				ResultSet rs=s.executeQuery(ins);
				res.setText(null);
				res.append("cust_no \t cust_name \t cust_state \t cust_cl \t cust_repo \n");
				while(rs.next()) {
					res.append(rs.getString("cust_no"));
					res.append("\t");
					res.append(rs.getString("cust_name"));
					res.append("\t");
					res.append(rs.getString("cust_state"));
					res.append("\t");
					res.append(rs.getString("cust_cl"));
					res.append("\t");
					res.append(rs.getString("cust_repo"));
					res.append("\n");
					
				jf.pack();	
				}
			}
			catch(SQLException s) {
				System.out.println(s.toString());
			}
		}
	}
}



