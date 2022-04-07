public class User {

    private int UserId;
    private String UserName;

    public User(int UserId, String UserName) {

        this.UserId = UserId;
        this.UserName = UserName;
    }

    public String getUserName() {return this.UserName;}
    
}
