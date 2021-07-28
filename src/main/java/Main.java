import dao.ArtistDao;
import dao.CustomerDao;
import dao.OrderDao;
import entity.*;
import entity.entity_utils.Gender;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ArtistDao artistDao = new ArtistDao();
        CustomerDao customerDao = new CustomerDao();
        OrderDao orderDao = new OrderDao();

        Customer customer = new Customer("Bruce", "Wayne", 30, Gender.MALE);
        Customer customer2 = new Customer("Ben", "Affleck", 48, Gender.MALE);
        Order order = new Order(UUID.randomUUID());
        //Order order1 = new Order(UUID.randomUUID());
        Order order2 = new Order(UUID.randomUUID());
        Artist artist = new Artist("MORGENSHTERN", 20, Gender.MALE, "100000000");
        Album album = new Album("Легендарная пыль", "2000", "12/10/2020", "20000000");
        Track track = new Track("Съел деда", "200", "01/02/2020");

        Artist artist1 = new Artist("Валя Карнавал", 19, Gender.FEMALE, "8000000");
        Track track1 = new Track("Истерика", "100", "01/02/2020");

        Artist artist3 = new Artist("Slava Marlow", 18, Gender.MALE, "9999999");
        Track track3 = new Track("Ты горишь как огонь", "250", "01/02/2020");

        album.getTracks().add(track);
        album.getArtists().add(artist);
        album.getArtists().add(artist3);
        artist.getAlbums().add(album);
        artist.getTracks().add(track);

        artist1.getTracks().add(track1);
        artist3.getTracks().add(track3);

        order2.getTracks().add(track1);
        order2.getTracks().add(track3);
        customer2.getOrders().add(order2);

        order.getAlbums().add(album);
        order.getTracks().add(track);
        customer.getOrders().add(order);

        artistDao.saveArtist(artist1);
        artistDao.saveArtist(artist);
        customerDao.saveCustomer(customer);
        customerDao.saveCustomer(customer2);

        orderDao.batchInsert(2000000);
    }
}
