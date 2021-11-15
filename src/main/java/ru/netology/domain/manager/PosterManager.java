package ru.netology.domain.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmsPoster;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PosterManager {
    private FilmsPoster[] films = new FilmsPoster[0];

    private int posterLength;
    private int resultLength = 10;


    public PosterManager(int posterLength) {
        this.posterLength = posterLength;
    }

    public void add(FilmsPoster film) {
        int length = films.length + 1;
        FilmsPoster[] tmp = new FilmsPoster[length];
        System.arraycopy(films, 0, tmp, 0,films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public FilmsPoster[] getLastFilms() {
        int filmCount = films.length;
        if ((resultLength < films.length) && (posterLength == 0)) {
            filmCount = resultLength;
        } else if ((posterLength > 0) && (posterLength < films.length)) {
            filmCount = posterLength;
        }
        FilmsPoster[] result = new FilmsPoster[filmCount];
        for (int i = 0; i < filmCount; i++) {
            int index = filmCount - 1 -i;
            result[i] = films[index];
        }
        return result;
    }
}
