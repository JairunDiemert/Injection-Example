
package injection;

/**
 *
 * @author bowsnickiklewe
 */
public class Injection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Password.validate("Ringo","s3cr3t"));
        System.out.println(PasswordSafe.validate("Ringo","s3cr3t"));
        System.out.println(Password.validate("Ringo","pass"));
        System.out.println(PasswordSafe.validate("Ringo","pass"));
        String inject = "\" or \"\"=\"";
        System.out.println(Password.validate(inject,inject));
        System.out.println(PasswordSafe.validate(inject,inject));
    }
    
}