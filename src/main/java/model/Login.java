package model;

public class Login {
    private String account;
    private String pass;

    public Login() {
    }

    public Login(String account, String pass) {
        this.account = account;
        this.pass = pass;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
