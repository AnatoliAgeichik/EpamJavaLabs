package by.epam.lab2.main;

import by.epam.lab2.entity.Post;
import by.epam.lab2.entity.User;
import by.epam.lab2.handler.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
    static Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        User[] users = new User[3];
        users[0] = new User("A", 1);
        users[1] = new User("B", 2);
        users[2] = new User("C", 3);

        Post[] posts = new Post[3];
        posts[0] = new Post("1");
        posts[1] = new Post("2");
        posts[2] = new Post("3");

        users[0].addPost(posts[0]);
        users[0].addPost(posts[1]);
        users[0].addPost(posts[2]);
        users[1].addPost(posts[0]);
        users[2].addPost(posts[1]);

        users[0].likePost(posts[0]);
        users[0].likePost(posts[0]);
        users[0].likePost(posts[0]);
        users[0].likePost(posts[1]);
        users[0].likePost(posts[2]);
        users[1].likePost(posts[0]);
        users[2].likePost(posts[1]);

        Arrays.stream(users).forEach(u -> System.out.println(u.toString()));
        Arrays.stream(users).forEach(u -> System.out.println(u.toString()));

        Handler handler = new Handler();
        System.out.println("Result: " + Arrays.toString(handler.minPostsUsers(users)));

        long startTime = System.nanoTime();
        Arrays.stream(users).filter(u -> u.getPosts().size() == 1);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        startTime = System.nanoTime();
        Arrays.stream(users).parallel().filter(u -> u.getPosts().size() == 1);
        endTime = System.nanoTime();

        long durationParallel = (endTime - startTime);
        System.out.println("Duration not parallel: " + duration + " Duration parallel: " + durationParallel);
        System.out.println("Difference duration - durationParallel = " + (duration - durationParallel));
    }
}
