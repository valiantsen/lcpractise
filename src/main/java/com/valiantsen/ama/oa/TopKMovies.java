package main.java.com.valiantsen.ama.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKMovies {


    public List<Movie> getNearest(Movie movie, int k) {
        PriorityQueue<Movie> minHeap = new PriorityQueue<>(k, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if (o1.rating > o2.rating) {
                    return 1;
                } else if (o1.rating == o2.rating) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        Set<Integer> visited = new HashSet<>();
        Queue<Movie> queue = new LinkedList<>();
        queue.add(movie);
        visited.add(movie.id);
        while (!queue.isEmpty()) {
            Movie now = queue.poll();
            if (now.similars != null) {
                for (Movie simi : now.similars) {
                    if (!visited.contains(simi.id)) {
                        queue.add(simi);
                        visited.add(simi.id);
                    }
                }
            }

            if (minHeap.contains(now) || now.id == movie.id) {
                continue;
            }
            if (minHeap.size() < k) {
                minHeap.add(now);
            } else if (minHeap.size() == k && minHeap.peek().rating < now.rating) {
                minHeap.poll();
                minHeap.add(now);
            }
        }
        List<Movie> result = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public class Movie {
        int id;

        float rating;

        List<Movie> similars;

        public Movie(int id, float rating) {
            this.id = id;
            this.rating = rating;
        }

        public boolean equals(Movie obj) {
            return this.id == obj.id;
        }
    }

    public Movie newMovie(int id, float rating) {
        return new Movie(id, rating);
    }

    public static void main(String[] args) {
        TopKMovies a = new TopKMovies();
        Movie m1 = a.newMovie(1, 10.99f);
        Movie m2 = a.newMovie(2, 0.99f);
        Movie m3 = a.newMovie(3, 11.99f);
        Movie m4 = a.newMovie(4, 12.99f);
        Movie m5 = a.newMovie(5, 11.99f);
        Movie m6 = a.newMovie(6, 8.99f);
        Movie m7 = a.newMovie(7, 7.99f);
        Movie m8 = a.newMovie(8, 8.99f);
        List<Movie> l1 = Arrays.asList(m2, m3, m4);
        List<Movie> l2 = Arrays.asList(m2, m1, m4);
        List<Movie> l3 = Arrays.asList(m2, m3, m5);
        List<Movie> l4 = Arrays.asList(m1, m3, m6);
        List<Movie> l5 = Arrays.asList(m5, m6, m7);
        List<Movie> l6 = Arrays.asList(m7, m8, m6);
        m1.similars = l1;
        m2.similars = l2;
        m3.similars = l3;
        m4.similars = l4;
        m5.similars = l5;
        m6.similars = l6;

        List<Movie> result = a.getNearest(m1, 4);
        for (Movie mo : result) {
            System.out.println(mo.id + ":" + mo.rating);
        }

    }
}


