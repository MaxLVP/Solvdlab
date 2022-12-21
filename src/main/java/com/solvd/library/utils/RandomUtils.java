package com.solvd.library.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int returnRandomIntWithSize(int size) {
        return random.nextInt(size);
    }

    public static int returnRandomInt() {
        return random.nextInt();
    }

    public static <T> T returnRandomObjectFromList(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
}
