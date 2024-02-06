package Assignment1_2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Movie {
    private int movieId;
    private String title;
    private String genre;
    private int releaseYear;
    private boolean available;

    public Movie(int movieId, String title, String genre, int releaseYear) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.available = true;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Customer {
    private int customerId;
    private String name;
    private String membershipStatus;

    public Customer(int customerId, String name, String membershipStatus) {
        this.customerId = customerId;
        this.name = name;
        this.membershipStatus = membershipStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }
}

class Rental {
    private int movieId;
    private int customerId;

    public Rental(int movieId, int customerId) {
        this.movieId = movieId;
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getCustomerId() {
        return customerId;
    }
}

class InventoryControlSystem {
    private List<Movie> movies;
    private List<Customer> customers;
    private List<Rental> rentals;

    public InventoryControlSystem() {
        this.movies = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Movie added successfully.");
    }

    public void rentMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Movie ID to rent: ");
        int movieId = scanner.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        Movie movie = findMovieById(movieId);
        Customer customer = findCustomerById(customerId);

        if (movie != null && customer != null && movie.isAvailable()) {
            movie.setAvailable(false);
            rentals.add(new Rental(movieId, customerId));
            System.out.println("Movie rented successfully.");
        } else {
            System.out.println("Unable to rent the movie. Please check Movie ID and Customer ID.");
        }
    }
    public void returnMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Movie ID to return: ");
        int movieId = scanner.nextInt();

        Rental rental = findRentalByMovieId(movieId);

        if (rental != null) {
            findMovieById(movieId).setAvailable(true);
            rentals.remove(rental);
            System.out.println("Movie returned successfully.");
        } else {
            System.out.println("Unable to return the movie.");
        }
    }

    public void listAvailableMovies() {
        System.out.println("Available Movies:");
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                System.out.println(movie.getTitle() + " (" + movie.getReleaseYear() + ")");
            }
        }
    }

    public void listRentedMovies() {
        System.out.println("Rented Movies:");
        for (Rental rental : rentals) {
            Movie movie = findMovieById(rental.getMovieId());
            System.out.println(movie.getTitle() + " (" + movie.getReleaseYear() + ")");
        }
    }

    public void displayCustomerRentals() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        System.out.println("Rentals for Customer " + customerId + ":");
        for (Rental rental : rentals) {
            if (rental.getCustomerId() == customerId) {
                Movie movie = findMovieById(rental.getMovieId());
                System.out.println(movie.getTitle() + " (" + movie.getReleaseYear() + ")");
            }
        }
    }

    private Movie findMovieById(int movieId) {
        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    private Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    private Rental findRentalByMovieId(int movieId) {
        for (Rental rental : rentals) {
            if (rental.getMovieId() == movieId) {
                return rental;
            }
        }
        return null;
    }
    public void addMovieFromMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Movie ID: ");
        int movieId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Movie Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Movie Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Release Year: ");
        int releaseYear = scanner.nextInt();

        Movie newMovie = new Movie(movieId, title, genre, releaseYear);
        addMovie(newMovie);
    }

    public void addCustomerFromMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Membership Status: ");
        String membershipStatus = scanner.nextLine();

        Customer newCustomer = new Customer(customerId, name, membershipStatus);
        addCustomer(newCustomer);
    }

    public void displayMenu() {
        System.out.println("\n=== Video Rental Store Menu ===");
        System.out.println("1. Add Movie");
        System.out.println("2. Rent Movie");
        System.out.println("3. Return Movie");
        System.out.println("4. List Available Movies");
        System.out.println("5. List Rented Movies");
        System.out.println("6. Display Customer Rentals");
        System.out.println("7. Add Customer");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMovieFromMenu();
                    break;
                case 2:
                    rentMovie();
                    break;
                case 3:
                    returnMovie();
                    break;
                case 4:
                    listAvailableMovies();
                    break;
                case 5:
                    listRentedMovies();
                    break;
                case 6:
                    displayCustomerRentals();
                    break;
                case 7:
                    addCustomerFromMenu();
                    break;
                case 0:
                    System.out.println("Exiting the Video Rental Store. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryControlSystem system = new InventoryControlSystem();
//        system.addMovie(new Movie(1, "Inception", "Sci-Fi", 2010));
//        system.addMovie(new Movie(2, "The Shawshank Redemption", "Drama", 1994));
//        system.addMovie(new Movie(3, "The Dark Knight", "Action", 2008));

        system.run();
    }
}
