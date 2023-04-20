package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void addZeroFilm() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneNewFilm() {
        MovieManager manager = new MovieManager();

        manager.add("Film1");

        String[] expected = {"Film1"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSeveralNewFilm() {
        MovieManager manager = new MovieManager();

        manager.add("Film1");
        manager.add("Film2");
        manager.add("Film3");

        String[] expected = {"Film1", "Film2", "Film3"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void nextAddFilm() {
        MovieManager manager = new MovieManager();

        manager.add("Film1");
        manager.add("Film2");
        manager.add("Film3");

        String[] expected = {"Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastZeroFilm() {
        MovieManager manager = new MovieManager();


        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testLimitFindLast() {
        MovieManager manager = new MovieManager();

        manager.add("Film1");
        manager.add("Film2");
        manager.add("Film3");
        manager.add("Film4");
        manager.add("Film5");

        String[] expected = {"Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOverLimitFindLast() {
        MovieManager manager = new MovieManager();

        manager.add("Film1");
        manager.add("Film2");
        manager.add("Film3");
        manager.add("Film4");
        manager.add("Film5");
        manager.add("Film6");

        String[] expected = {"Film6","Film5", "Film4", "Film3", "Film2"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAnotherLimitFilm() {
        MovieManager manager = new MovieManager(8);

        manager.add("Film1");
        manager.add("Film2");
        manager.add("Film3");
        manager.add("Film4");
        manager.add("Film5");
        manager.add("Film6");
        manager.add("Film7");
        manager.add("Film8");

        String[] expected = {"Film8","Film7","Film6","Film5", "Film4", "Film3", "Film2","Film1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
