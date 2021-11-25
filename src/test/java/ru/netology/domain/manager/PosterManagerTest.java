package ru.netology.domain.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmsPoster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();

    FilmsPoster first = new FilmsPoster(1, "first", "comedy", 10);
    FilmsPoster second = new FilmsPoster(2, "second", "comedy", 15);
    FilmsPoster third = new FilmsPoster(3, "third", "comedy", 23);
    FilmsPoster fourth = new FilmsPoster(4, "fourth", "comedy", 1);
    FilmsPoster fifth = new FilmsPoster(5, "fifth", "comedy", 17);
    FilmsPoster sixth = new FilmsPoster(6, "sixth", "comedy", 19);
    FilmsPoster seventh = new FilmsPoster(7, "seventh", "comedy", 21);
    FilmsPoster eighth = new FilmsPoster(8, "eighth", "comedy", 22);
    FilmsPoster ninth = new FilmsPoster(9, "ninth", "comedy", 23);
    FilmsPoster tenth = new FilmsPoster(10, "tenth", "comedy", 12);
    FilmsPoster eleventh = new FilmsPoster(11, "eleventh", "comedy", 13);
    FilmsPoster twelfth = new FilmsPoster(12, "twelfth", "comedy", 14);
    FilmsPoster thirteenth = new FilmsPoster(13, "thirteenth", "comedy", 15);


    @Test
    public void showInReverseOrder10() {// Показать в обратном порядке 10 последних
        PosterManager manager = new PosterManager(10);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{eleventh,tenth, ninth, eighth, seventh, sixth, fifth, fourth, third,second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showInReverseOrder5() {// Показать в обратном порядке 5 последних
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{ninth,eighth,seventh,sixth,fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showInReverseOrder() {// Показать в обратном порядке меньше лимита
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showInReverseWithCustomLength() { // Показать в обратном порядке, когда длина больше длины массива
        PosterManager manager = new PosterManager(12);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showInTenReverse() { // Показать в обратном порядке 10 добавленных фильмов
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shownInMoreLimit() { // Показать в обратном порядке 10 последних, когда добавлено 13 фильмов
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{thirteenth,twelfth,eleventh,tenth, ninth, eighth, seventh, sixth, fifth, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showInReverseWithCustomLength0() { // Показать в обратном порядке, когда длина лимита 0
        PosterManager manager = new PosterManager(0);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        FilmsPoster[] actual = manager.getLastFilms();
        FilmsPoster[] expected = new FilmsPoster[]{eleventh,tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}