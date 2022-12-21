package com.solvd.library.storage;

import com.solvd.library.MyLogger;
import com.solvd.library.others.Newspaper;
import com.solvd.library.utils.custom_lambda.IConvert;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.PriorityQueue;

public class NewsFactory {
    static final MyLogger logger = MyLogger.getInstance();
    private final static PriorityQueue<Newspaper> NEWS = new PriorityQueue<>();

    public static void fillInNews() {
        NEWS.add(new Newspaper(1, "Finance times", "Economic"));
        NEWS.add(new Newspaper(2, "New York Times", "Politic"));
        NEWS.add(new Newspaper(3, "Washington Post", "All"));
        NEWS.add(new Newspaper(4, "The Athletic", "Sport"));
    }

    public static void addNews(Newspaper newspaper) {
        NEWS.add(newspaper);
    }

    public static void getNewsNames() {
        List<String> newsNames = NEWS.stream().map(news -> StringUtils.upperCase(news.getName())).toList();
        logger.info("Газеты: " + newsNames);
    }

    public static void getNewsCount() {
        IConvert<Integer, String> convert = Object::toString;
        logger.info("Количество газет: " + convert.convert(NEWS.size()));
    }

    public static Newspaper getNews() {
        return NEWS.poll();
    }
}
