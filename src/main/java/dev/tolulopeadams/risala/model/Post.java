package dev.tolulopeadams.risala.model;

import java.util.ArrayList;

public class Post {
    private int post_id;
    private int author_id;
    private String content;
    private String dateCreated;
    private ArrayList<Integer> likes;
    private ArrayList<Integer> comments;
}
