package exercises.model;

public record Customer(String id, String firstName, String lastName, String email, String phone) {
    public Customer(String firstName, String lastName) {
        this("-1", firstName, lastName, "", "");

    }
}
