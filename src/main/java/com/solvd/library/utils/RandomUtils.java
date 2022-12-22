package com.solvd.library.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int returnRandomIntWithSize(int size) {
        return RANDOM.nextInt(size);
    }

    public static int returnRandomIntInRange(int start, int end) {
        return RANDOM.nextInt(start, end);
    }

    public static <T> T returnRandomObjectFromList(List<T> list) {
        return list.get(RANDOM.nextInt(list.size()));
    }
}
