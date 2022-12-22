package com.solvd.library.others;

import com.solvd.library.MyLogger;

import static com.solvd.library.storage.NewsFactory.addNews;

public class Newspaper extends Periodicals implements IReading, Comparable<Newspaper>{
    static final MyLogger LOGGER = MyLogger.getInstance();

    public Newspaper(String name, String genre) {
        super(genre, name);
    }

    @Override
    public int compareTo(Newspaper news) {
       return  this.getName().compareTo(news.getName());
    }

    @Override
    public void returnPeriodicals(Periodicals periodicals) {
        addNews((Newspaper) periodicals);
        LOGGER.info(this.getName() + " возвращена");
    }

    @Override
    public String toString() {
        return "Газета '" + this.getName() + '\'' +
                " жанр '" + this.getTopic() + '\'';
    }


}
