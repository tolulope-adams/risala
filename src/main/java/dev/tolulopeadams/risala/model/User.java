package dev.tolulopeadams.risala.model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    private ArrayList<String> followersList;
    private ArrayList<String> followingList;
    private ArrayList<String> posts;

}
