//CSC 285 Session 1 HW
// Mouad Tiahi
// Java core packages
// @HW@
// add grade average point GPA
//

import java.io.Serializable;

public class AccountRecord implements Serializable { // if it is interface it
    // should be implements
    // (tagging interface); Marker interface

    private static final long serialVersionUID = 3417040053089159204L;
    private int account;
    private String firstName;
    private String lastName;
    private String address;
    private String socsec;
    private double balance;
    private double gpa;
    private String title;

    // no-argument constructor calls other constructor with
    // default values
    public AccountRecord() {
        this(0, "", "", "", ""); // default way of private variables.
    }



    // initialize a record
    public AccountRecord(int account, String firstName, String lastName, String address, String socsec) {//, double balance, double gpa, String title) {
        setAccount(account);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setSocsec(socsec);
        setBalance(balance);
        setGpa(gpa);
        setTitle(title);
    }

    // set account number
    public void setAccount(int account) {
        this.account = account;
    }

    // get account number
    public int getAccount() {
        return account;
    }

    // set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // set the address
    public void setAddress(String address) {   //Step 5  Now add the mutator and the accessor
        this.address = address;
    }

    // get the address
    public String getAddress() {
        return address;
    }

    // set the social security
    public void setSocsec(String socsec) {
        this.socsec = socsec;

    }

    // get the social security
    public String getSocsec() {
        return socsec;
    }

    // get the title
    public String getTitle() {
        return title;
    }

    // set the title
    public void setTitle(String title) {
        this.title = title;
    }

    // get gpa
    public double getGpa() {
        return gpa;
    }

    // set gpa
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // get balance
    public double getBalance() {
        return balance;
    }

    // set balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}