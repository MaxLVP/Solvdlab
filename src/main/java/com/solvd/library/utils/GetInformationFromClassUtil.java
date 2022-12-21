package com.solvd.library.utils;

import com.solvd.library.MyLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class GetInformationFromClassUtil {
    static final MyLogger logger = MyLogger.getInstance();

    public static Class<?> getInformationFromClass(String className) {
        Class<?> c = null;
        try {
            c = Class.forName(className);
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getDeclaredMethods();
            Constructor<?>[] constructors = c.getDeclaredConstructors();
            writeInfoFromClassToFile(fields, methods, constructors);
        } catch (ClassNotFoundException ex) {
            logger.warn(ex.getMessage());
        }
        return c;
    }

    public static void writeInfoFromClassToFile(Field[] fields, Method[] methods, Constructor<?>[] constructors) {
        try {
            for (Field field: fields) {
                String data = "Поле: " + field.getName() + ", его тип: " + field.getType() + ", его модификаторы: " + Modifier.toString(field.getModifiers()) + "\n";
                FileUtils.writeStringToFile(new File("src/main/resources/fileWithInfoFromClass.txt"), data, StandardCharsets.UTF_8, true);
            }
            for (Method method: methods) {
                String data = "Метод: " + method.getName() + ", его параметры: " + Arrays.toString(method.getParameters()) + ", его модификаторы: " + Modifier.toString(method.getModifiers()) +
                        ", его возвращаемый тип: " + method.getReturnType() + "\n";
                FileUtils.writeStringToFile(new File("src/main/resources/fileWithInfoFromClass.txt"), data, StandardCharsets.UTF_8, true);
            }
            for (Constructor<?> constructor: constructors) {
                String data = "Конструктор: " + constructor.getName() + ", его параметры: " + Arrays.toString(constructor.getParameters()) + ", его модификаторы: " + Modifier.toString(constructor.getModifiers()) + "\n";
                FileUtils.writeStringToFile(new File("src/main/resources/fileWithInfoFromClass.txt"), data, StandardCharsets.UTF_8, true);
            }
        } catch (IOException ex) {
            logger.warn(ex.getMessage());
        }

    }
}
