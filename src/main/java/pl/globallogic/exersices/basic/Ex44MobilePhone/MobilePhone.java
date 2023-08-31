package pl.globallogic.exersices.basic.Ex44MobilePhone;

import java.util.ArrayList;
import java.util.Arrays;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    MobilePhone(String phoneNumber) {
        this.myNumber = phoneNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    private boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exist");
            return false;
        }
        myContacts.add(contact);
        System.out.printf("Added %s to your contacts \n", contact.getName());
        return true;
    }

    private boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }
        myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    private boolean removeContact(Contact contact) {
        int contactIndex = findContact(contact);
        if (contactIndex > 0) {
            myContacts.remove(contactIndex);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void printContacts() {
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }

    public static void main(String[] args) {
        MobilePhone myPhone = new MobilePhone("123456789");

        Contact contact1 = Contact.createContact("Bob", "31415926");
        Contact contact2 = Contact.createContact("Alice", "16180339");
        Contact contact3 = Contact.createContact("Tom", "11235813");
        Contact contact4 = Contact.createContact("Jane", "23571113");

        myPhone.addNewContact(contact1);
        myPhone.addNewContact(contact2);
        myPhone.addNewContact(contact3);
        myPhone.addNewContact(contact4);

        myPhone.printContacts();

        Contact newContact = Contact.createContact("Ewa", "3217487912");
        myPhone.updateContact(contact2, newContact);

        myPhone.printContacts();

        myPhone.removeContact(contact3);

        System.out.println("**********************");
        myPhone.printContacts();

    }

}
