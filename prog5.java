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
