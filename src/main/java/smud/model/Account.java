package smud.model;

/**
 * An account will track the users progress, as well as hold data necessary for persistence.
 * An account is accessed by entering the correct credentials.
 *
 * @author Sydney Wilson
 */
public class Account {
    private String username;
    private String hashedPassword;

    public Account(String username, String password) {
        this.username = username;
        this.hashedPassword = hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        String hashedInputPassword = hashPassword(password);
        return hashedInputPassword.equals(hashedPassword);
    }

    private static String hashPassword(String password) {
        int prime = 7;
        int hash = 0;

        for (int i = 0; i < password.length(); i++) {
            hash = prime * hash + password.charAt(i);
        }

        return Integer.toHexString(hash);
    }

    public static void main(String[] args) {
        String username = "sydney";
        String pword = "abcdefg";
        Account a = new Account(username, pword);
        boolean works = a.authenticate(pword);
        System.out.println(works);
    }
}