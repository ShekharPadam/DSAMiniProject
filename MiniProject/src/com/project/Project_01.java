package com.project;
import java.util.*;
class patient
{ 
int id; 
String name; 
int age; 
String place;
int room;
String aDate;
String dDate;
String status;
patient next;
	
} 

class HospitalManagement 
{ 
	patient head = null; 

void addData(int id, String name, int age,String place,int room, String aDate,String dDate, String status) 
{ 
	patient trav=head;
boolean b= true ;
	while(trav!=null) {
	if(trav.id==id) {
		b=false;
		System.out.println("This ID already exists.");
		break;
	}
	trav=trav.next;
	}
	if(b) {
	patient newPatient = new patient(); 
	newPatient.id = id; 
	newPatient.name = name; 
	newPatient.age = age;
	newPatient.place= place;
	newPatient.room=room;
	newPatient.aDate=aDate; 
	newPatient.dDate=dDate; 
	newPatient.status=status; 
		
	newPatient.next = null; 
    if (head == null) 
    { 
        head = newPatient; 
    } 
    else
    { 
    	patient temp = head; 
        while (temp.next != null)
        { 
            temp = temp.next; 
        } 
        temp.next = newPatient; 
    } 
} 
}
void showData() 
{ 
	patient temp = head;
	
	if(head==null){ 
        System.out.println("NO PATIENT IS ADDIMITED TILL NOW!!!!!"); 
        return; 
	}
    while (temp != null) 
    { 
        System.out.println("PATIENT_ID : " + temp.id + "| PATIENT_NAME : " + temp.name + "| PATIENT_AGE : " + temp.age+ "| PATIENT_ADDRESS : "+ temp.place +"| PATIENT_ADDIMATED_DATE : "+ temp.aDate+"| PATIENT_DISCHARGED_DATE : "+ temp.dDate+"| PATIENT_STATUS : "+temp.status); 
        temp = temp.next; 
    } 
} 
void SearchData(int id) 
{
	if(head==null){ 
        System.out.println("NO PATIENT IS ADDIMITED TILL NOW!!!!!"); 
        return; 
    } 
	patient temp=head;
	boolean b=true;
	try {	
	while(b) {if(temp.id == id) {
		 System.out.println("PATIENT_ID : " + temp.id + "| PATIENT_NAME : " + temp.name + "| PATIENT_AGE : " + temp.age+ "| PATIENT_ADDRESS : "+ temp.place +"| PATIENT_ADDIMATED_DATE : "+ temp.aDate+"| PATIENT_DISCHARGED_DATE : "+ temp.dDate+"| PATIENT_STATUS : "+temp.status);
		 b=false;
	 }
	 temp=temp.next;
	
}
	}catch(Exception e) {
		System.out.println("data is not found!!!!");
	}
	
}
void removeData(int id) 
{ 
	if(head==null){ 
        System.out.println("NO PATIENT IS ADDIMITED TILL NOW!!!!!"); 
        return; 
    } 
	patient temp = head, prev = null; 
    if (temp != null && temp.id == id) 
    { 
        head = temp.next; 
        return; 
    } 
    while (temp != null && temp.id != id) 
    { 
        prev = temp; 
        temp = temp.next; 
    } 
    if (temp == null) return; 
    prev.next = temp.next; 
}
void updateData(int id,String dDate, String status){ 
    
	if(head==null) {
        System.out.println("NO PATIENT IS ADDIMITED TILL NOW!!!!!"); 
        return; 
	}
    if(id==head.id){ 
    	head.id = id;  
    	head.dDate=dDate; 
    	head.status=status;
        return; 
    } 
    patient temp=head; 
    while(temp.next!=null){ 
        if(temp.next.id==id){ 
        	patient t=temp.next; 
        	t.dDate=dDate; 
        	t.status=status;
            return; 
        } 
        temp=temp.next; 
    	}	
	}
}

//Main Method starts 
public class Project_01
{ 
public static void main(String[] args) 
{ 
	HospitalManagement H = new HospitalManagement(); 
    int id; 
    String name; 
    int age; 
    String place;
    int room;
    String aDate;
    String dDate;
    String status;
    boolean b = true;
    Scanner sc = new Scanner(System.in); 
    while (b) 
    { 
        System.out.println("1. Add Data"); 
        System.out.println("2. Remove Data"); 
        System.out.println("3. Show Data"); 
        System.out.println("4. Search Data");
        System.out.println("5. update data");
        System.out.println("0. Exit"); 
        System.out.print("Enter Your Choice : "); 
        int choice = sc.nextInt(); 
        switch (choice) 
        { 
        case 1: 
            System.out.print("Enter Id : "); 
            id = sc.nextInt(); 
            System.out.print("Enter Name : "); 
            name = sc.next(); 
            System.out.print("Enter Age : "); 
            age = sc.nextInt(); 
            System.out.print("Enter Address : "); 
            place = sc.next();
            
            System.out.print("Enter Addimited Room NO : "); 
            room = sc.nextInt(); 
            
            System.out.print("Enter Addimited Date : "); 
            aDate = sc.next();
            
            System.out.print("Enter Discharged Date : "); 
            dDate = sc.next();  
            
            System.out.print("Enter Status : "); 
            status = sc.next();
        
            H.addData(id, name, age, place, room, aDate, dDate, status); 
            break; 
        case 2: 
            System.out.print("Enter Id : "); 
            id = sc.nextInt(); 
            H.removeData(id); 
            break; 
        case 3: 
            H.showData(); 
            break; 
        case 4: 
        	System.out.print("Enter Id : "); 
      	  id=sc.nextInt();
            H.SearchData(id); 
            break;
        case 5:if(H.head==null)break;
        	System.out.print("Enter Id : "); 
            id = sc.nextInt(); 
            
            System.out.print("Enter Discharged Date : "); 
            dDate = sc.next();  
            
            System.out.print("Enter Status : "); 
            status = sc.next(); 
            H.updateData(id, dDate, status); 
            break; 
        case 0: 
        	
           System.out.println("EXIT"); 
           b = false;
            break; 
            
            default: {
            	System.out.println("Invalid Entry");
             }
          }
    	}
	}
}