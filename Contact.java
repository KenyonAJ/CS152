package cs152;


public class Contact implements Comparable, Cloneable {

    private String firstName, lastName, phone;
    
    public Contact (String first, String last, String telephone) {
        
        firstName = first;
        lastName = last;
        phone = telephone;
    }
    
    public String toString () {
        return lastName + ", " + firstName + "\t" + phone;
    }
    
    public boolean equals (Object other) {
        return (lastName.equals(((Contact)other).getLastName()) && 
                firstName.equals(((Contact)other).getFirstName()));
    }
    
    public int compareTo (Object other) {
        int result;
        
        String otherFirst = ((Contact)other).getFirstName();
        String otherLast = ((Contact)other).getLastName();
        String otherPhone = ((Contact)other).getPhone();
        
        
        if (lastName.equals(otherLast)) {
            if (firstName.equals(otherFirst))
                result = phone.compareTo(otherPhone);
            else
                result = firstName.compareTo(otherFirst);
            }
        else
            result = lastName.compareTo(otherLast);
                    
       return result;
    }
    
    public String getFirstName () {
        return firstName;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public String getPhone () {
        return phone;
    }
    
    public Object clone () {
    	Contact contact = null;
    	try {
    		contact = (Contact)super.clone();
    	}
    	catch (CloneNotSupportedException e) {
    		// this was more effort than just copy-paste array in main()
    	}
    	return contact;
    }
    
}
