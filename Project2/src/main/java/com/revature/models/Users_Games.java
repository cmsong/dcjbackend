package com.revature.models;
public class Users_Games {
    
    private String username;
    private int g_id;
    
    public Users_Games() {
    }
    public Users_Games(String username, int g_id) {
        super();
        this.username = username;
        this.g_id = g_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getG_id() {
        return g_id;
    }
    public void setG_id(int g_id) {
        this.g_id = g_id;
    }
    @Override
    public String toString() {
        return "Users_Games [username=" + username + ", g_id=" + g_id + "]";
    }
    
    
    
}