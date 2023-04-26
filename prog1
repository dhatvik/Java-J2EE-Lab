// Contact class

public class Contact {
String name;
Long number;
Contact(){}
Contact(String name, Long number) {
this.name = name;
this.number = number;
	}
}



// Main class

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
	
static void print(Contact c1) {
System.out.println("Name : " + c1.name);
System.out.println("Number : " + c1.number);
}

public static void main(String[] args) {
	
ArrayList<Contact> contactList = new ArrayList<Contact>();
int numberofContacts;
System.out.println("Enter the number of contacts to be saved : ");
Scanner sc = new Scanner(System.in);
numberofContacts = sc.nextInt();
for(int i=0; i<numberofContacts; i++) {
String cname;
Long cnumber;
System.out.println("Enter the name of the person : ");
sc.nextLine();
cname = sc.nextLine();
System.out.println("Enter the number of the person : ");
cnumber = sc.nextLong();
Contact c1 = new Contact(cname, cnumber);
contactList.add(c1);
}

for(Contact c : contactList) {
print(c);
}

int numberofMissedCalls;
System.out.println("Enter the number of missed calls ");
numberofMissedCalls = sc.nextInt();
HashMap<Long, String> missedCalls = new HashMap<Long, String>();
for(int i=0; i<numberofMissedCalls; i++) {
Long missednumber;
System.out.println("Enter the calling number : ");
missednumber = sc.nextLong();
String name="Private Caller";
for(Contact c : contactList) {
if(c.number.equals(missednumber)) {
name = c.name;
break;
}
}
missedCalls.put(missednumber, name);
}
missedCalls.forEach((number,name) -> System.out.println("Number : " + number + " Name: " + name));
Long delNumber;
System.out.println("Enter the number to delete : ");
delNumber = sc.nextLong();
Contact delContact = new Contact();
for(Contact c : contactList) {
if(c.number.equals(delNumber)) {
delContact = c;
break;
}
}
contactList.remove(delContact);
for(Contact c : contactList) {
print(c);
}
}
}
