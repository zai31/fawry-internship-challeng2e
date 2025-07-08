package services;

public class MailingServices {
    public static void send(String productTitle, String email) {
        System.out.println("Quantum bookstore: [MailService] Sending '" + productTitle + "' to " + email);
    }
}
