import dao.AlbumDao;
import dao.ArtistDao;
import dao.TrackDao;
import entity.Album;
import entity.Artist;
import entity.Track;
import entity.entity_utils.Gender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Service {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ArtistDao artistDao = new ArtistDao();
    private final AlbumDao albumDao = new AlbumDao();
    private final TrackDao trackDao = new TrackDao();

    public void run() {
        System.out.println("Select your option");
        try {
            option();
            String c = reader.readLine();
            choice(c);
        } catch (IOException e) {
            System.out.println("Sorry, something went wrong. Try again.");
        }
    }

    private void option() {
        System.out.println();
        System.out.println("1 - Add new track");
        System.out.println("2 - Add new album");
        System.out.println("3 - Add new artist");
        System.out.println();
    }

    private void choice(String c) throws IOException {
        switch (c) {
            case "1":
                trackChoice();
            case "2":
                albumChoice();
            case "3":
                artistChoice();
        }
    }

    private void trackChoice() throws IOException {
        System.out.println("Enter title of new track: ");
        String title = reader.readLine();
        System.out.println("Enter release date of new track: ");
        String releaseDate = reader.readLine();
        System.out.println("Enter price of new track: ");
        String price = reader.readLine();

        Track track = new Track(title, releaseDate, price);
        trackDao.saveTrack(track);
    }

    private void albumChoice() throws IOException {
        System.out.println("Enter title of new album: ");
        String title = reader.readLine();
        System.out.println("Enter release date of album: ");
        String releaseDate = reader.readLine();
        System.out.println("Enter price of new album: ");
        String price = reader.readLine();
        System.out.println("Enter count of plays of new album: ");
        String plays = reader.readLine();

        Album album = new Album(title, releaseDate, price, plays);
        albumDao.saveAlbum(album);
    }

    private void artistChoice() throws IOException {
        System.out.println("Enter nickname of artist: ");
        String nickname = reader.readLine();
        System.out.println("Enter age of new artist: ");
        String age = reader.readLine();
        System.out.println("Enter gender of artist(male or female): ");
        String gender = reader.readLine();
        System.out.println("Enter count of plays of artist: ");
        String plays = reader.readLine();

        Artist artist = new Artist(nickname, Integer.parseInt(age), gender(gender), plays);
        artistDao.saveArtist(artist);
    }

    private Gender gender(String gender) {
        if (gender.equals("male")) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }
}
