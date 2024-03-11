package lian.user;

import lian.SnowflakeIdWorker;

public class User{
    public String username;
    public int id;

    public String password;
    public String email;
    public String avatar_url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public User() {
    }
    public User(String username, String password, String email, String avatar_url) {
        this.username = username;
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        id = (int)idWorker.nextId();
        this.password = password;
        this.email = email;
        this.avatar_url = avatar_url;
    }
    public User(String username, String password, String email) {
        this.username = username;
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        id = (int)idWorker.nextId();
        this.password = password;
        this.email = email;
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
