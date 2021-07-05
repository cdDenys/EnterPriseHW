import entity.Address;
import entity.Book;
import entity.Contact;
import service.AddressService;
import service.BookService;
import service.ContactService;

public class Main {
    public static void main(String[] args) {

        Contact contact = new Contact();
        Address address = new Address();
        Book book = new Book();
        ContactService contactService = new ContactService();
        AddressService addressService = new AddressService();
        BookService bookService = new BookService();

        contact.setName("Main Name");
        contact.setSurname("Main surname");
        contactService.save(contact);
        System.out.println("contactService.getAll()  " + contactService.getAll());

        address.setCity("Main city");
        address.setStreet("Main Street");
        address.setHouseNumber(100000);
        addressService.save(address);
        System.out.println("addressService.getAll()  " + addressService.getAll());

        book.setContact_id(4);
        book.setAddress_id(41);
        bookService.save(book);
        System.out.println(bookService.getAllContacts());

    }
}
