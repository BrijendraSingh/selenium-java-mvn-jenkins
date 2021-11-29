package builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer {
    public String email;
    public String password;
    public String repeatPassword;
    public String maidenName;
    public boolean clickRegister;

    @Override
    public String toString(){
        return "Email: " + email + " | Password: " + password + " | Repeat Password: " + repeatPassword + " | Maiden Name: " + maidenName + " | Click Register: " + clickRegister;
    }
}
