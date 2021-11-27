package builder;

public class Customer {
    private final String email;
    private final String password;
    private final String repeatPassword;
    private final String maidenName;
    private final boolean clickRegister;

    public Customer(CustomerBuilder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.repeatPassword = builder.repeatPassword;
        this.clickRegister = builder.clickRegister;
        this.maidenName = builder.maidenName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public boolean getClickRegister() {
        return clickRegister;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public static class CustomerBuilder{
        private  String email;
        private  String password;
        private  String repeatPassword;
        private  boolean clickRegister;
        private  String maidenName;

        public CustomerBuilder email(String email){
            this.email= email;
            return this;
        }
        public CustomerBuilder password(String password){
            this.password= password;
            return this;
        }
        public CustomerBuilder repeatPassword(String repeatPassword){
            this.repeatPassword= repeatPassword;
            return this;
        }
        public CustomerBuilder clickRegister(boolean clickRegister){
            this.clickRegister= clickRegister;
            return this;
        }
        public CustomerBuilder maidenName(String maidenName){
            this.maidenName= maidenName;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

}
