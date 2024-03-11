package lian.user;

public interface UserServiceInterface {
    String registerUser(String username, String password,String email,String avatar_url);
    String login(int userid,String password);


}
