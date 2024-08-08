package exercises;

public record Customer(String id, String firstName, String lastName, String email, String phone) {
    Customer(String firstName, String lastName) {
        this("-1", firstName, lastName, "", "");

    }
}
