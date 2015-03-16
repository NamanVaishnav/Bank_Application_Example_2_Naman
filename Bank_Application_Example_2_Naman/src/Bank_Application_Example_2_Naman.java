import java.io.*;
import java.util.*; // this package supports Arraylist

/*
    first of all we are taking a Customer class which is having four things in it
    acc no , name , address and balance we are creating a construyctor of a class parameterized 
    because we want to create object with specific name and adress and all the things :)
*/
class Customer
{
    Long acno;
    String name;
    String add;
    Long bal;
    
    Customer(Long acno,String name,String add,Long bal)
    {
        this.acno = acno;
        this.name = name;
        this.add = add;
        this.bal = bal;
    }
    
}

public class Bank_Application_Example_2_Naman
{
      ArrayList<Object> naman = new ArrayList<Object>();// object is a class < this is what generic is :)> you can play directly with an Objects...
      /*
      ArrayList is same as array 
      but the major difference is ArrayList cat store objects
      array can only hold int,string etc but ArrayList can hold all this plus OBJECTS too
      */
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // it only stores Strings so if u want to enter Integer than use ParseInt method
    //-------------------------------------------------------------------------------------
    // begining of the other methods
    
    
    // Add Customer Method
    public void addCustomer() throws Exception   
    {
        System.out.println("---- Enter Customer Data ----");
        System.out.println("Enter Customer Name : ");
        String nm = br.readLine();    // read line?? you want customer to use keyboard than this thing helps you || accepts strings word by wrd
        System.out.println("Enter Customer Address : ");
        String ad = br.readLine();
        System.out.println("Enter Customer Account Number : ");
        Long ac = Long.parseLong(br.readLine()); // Converts string into long and stores intto BufferReader
        System.out.println("Enter Customer Initial Balance : ");
        Long bl = Long.parseLong(br.readLine());
        
        //it will create new customer by using entered values
        Customer c = new Customer(ac,nm,ad,bl);
        
        naman.add(c);
        // it will put new customer into ArrayList so here we stored object in a ArrayList
        
        System.out.println("New Customer Added Successfully");
        System.out.println("Welcome to Naman Bank  Mr./Ms."+c.name);
    
    }
    //-----end of add customer
    
    //delete customer method
    public void delCustomer() throws Exception
    {
        System.out.println("Enter Account Number to be Delete"); 
        Long ac = Long.parseLong(br.readLine());
        
        /*
        here we are checking all the objects stored in ArrayList by using iterating it
        its an inbuilt method
        */
        Iterator it = naman.iterator(); // Iterator checks the list one by one  
        while(it.hasNext()) // if arraylist have any object than || hasNext() checks the boolean Values  
        {
           
            Customer c = (Customer)it.next(); //temporary customer for comparision
            /*
            it will create new customer from that arraylist till we found appropriate customer
          */
            if(ac == c.acno) //if we found matched account number
            {
                String c_name = c.name; //to say bye we first store name before remove the object
                naman.remove(c); // removed customer
                System.out.println("Customer " +ac+ "Removed Successfully");
                System.out.println("Mr./Ms. " +c_name+ " You are no longer associated with Naman Bank");
                break;
            }
        }
    }
    
    //----end of delete customer method
    
    //update customer method
    public void upCustomer() throws Exception
    {
        System.out.println("Enter Account Number to be Update :  ");
        Long ac = Long.parseLong(br.readLine());
        
        Iterator it = naman.iterator(); //same as above
        while(it.hasNext())
        {
            Customer c = (Customer)it.next();
            if(ac == c.acno) // if match found than
            {
                System.out.println("Current Data is : ");
                System.out.println("Customer Name : " +c.name);
                System.out.println("New Name....??");
                String nm = br.readLine();
                System.out.println("Customer Address : " +c.add);
                String ad = br.readLine();
                Long old_bal = c.bal;
                Long old_ac_no = c.acno;
                /*
                        back up all from the object because in java ArrayList there is no such method to
                update the Array List so we store old items we needed than we delete entire object
                and than we create new object by using old backed up data PLUS new data we entered from the
                keyboard
                
                same thing implemented bellow
                */
                
                naman.remove(c);
                Customer new_c = new Customer(old_ac_no,nm,ad,old_bal);
                naman.add(new_c);
                System.out.println("Successfully updated both Name and Address");
                System.out.println("**************************************************");
                System.out.println("New Data is : ");
                System.out.println("Customer Name : " +new_c.name);
                System.out.println("Customer Address : " +new_c.add);
                System.out.println("Customer Account Number : " +new_c.acno);
                System.out.println("Customer Balance : " +new_c.bal);
                System.out.println("**************************************************");
            }
        }
        
    }
    //----end of update customer method
    
    //get cusomer info method
    public void getCustomer() throws Exception
    {
        System.out.println("Enter Account Number To View Customer : ");
        Long ac = Long.parseLong(br.readLine());
        
        Iterator it = naman.iterator();
        while(it.hasNext()) // if araylist have objects than
        {
            Customer c = (Customer)it.next(); // it will create objects untill match found
            if(ac == c.acno) //if match found
            {
                System.out.println("Here is Your Customer :");
                System.out.println("**************************************************");
                System.out.println("Customer Name : " +c.name);
                System.out.println("Customer Address : " +c.add);
                System.out.println("Customer Account Number : " +c.acno);
                System.out.println("Customer Ballance : " +c.bal);
                System.out.println("**************************************************");
            }
        }
        
    }
    //---end of customer info method
    
    
    
    //end of other mathods
   
    
    //-------------------------------------------------------------------------------------
    // Main Method of the class Bank_Application_Example_2_Naman
    
    public static void main(String[] args) throws Exception
    {
        Bank_Application_Example_2_Naman obj = new Bank_Application_Example_2_Naman();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("-----------------------------------------------------");
        System.out.println("Welcome To Naman Bank");
        System.out.println("-----------------------------------------------------");
        
       
        
        String next = "yes";
        while(next.equalsIgnoreCase("yes"))
        {
            System.out.println("-------------------- MENU ---------------------------");
            System.out.println("-----------------------------------------------------");
        
            System.out.println(" 1 for Add new Customer");
            System.out.println(" 2 for Delete Existing Customer");
            System.out.println(" 3 for Update Existing Customer");
            System.out.println(" 4 for Get Customer Information");
        
            System.out.println("-----------------------------------------------------");
            System.out.println("-----------------------------------------------------");
            System.out.println("Enter Your Choice from 1 to 4 : ");
            
            int choice = Integer.parseInt(br.readLine());
            
            switch(choice)
            {
                case 1 :
                            obj.addCustomer();
                            break;
                case 2 : 
                            obj.delCustomer();
                            break;
                case 3 : 
                            obj.upCustomer();
                            break;
                case 4 : 
                            obj.getCustomer();
                            break;
                default : 
                            System.out.println("Enter Valid Choice Dear User");
                            break;
            }
            System.out.println("Want to Continue...??");
            next = br.readLine();
            
            if(next.equalsIgnoreCase("no"))
            {
                System.exit(0);
            }
        }
        
        
                
    }
}
