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
    static final MyLogger LOGGER = MyLogger.getInstance();
    private static final File FILE = new File("src/main/resources/fileWithInfoFromClass.txt");

    public static Class<?> getInformationFromClass(String className) {
        Class<?> c = null;
        try {
            c = Class.forName(className);
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getDeclaredMethods();
            Constructor<?>[] constructors = c.getDeclaredConstructors();
            writeInfoFromClassToFile(c, fields, methods, constructors);
        } catch (ClassNotFoundException ex) {
            LOGGER.warn(ex.getMessage());
        }
        return c;
    }

    public static void writeInfoFromClassToFile(Class<?> c, Field[] fields, Method[] methods, Constructor<?>[] constructors) {
        try {
            FileUtils.write(FILE, "", StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(FILE, "Класс: " + c.getName() + "\n", StandardCharsets.UTF_8, true);
            FileUtils.writeStringToFile(FILE, "Его суперклас: " + c.getSuperclass().getName() + "\n", StandardCharsets.UTF_8, true);
            FileUtils.writeStringToFile(FILE, "Его интерфейсы: " + Arrays.toString(c.getInterfaces()) + "\n", StandardCharsets.UTF_8, true);
            for (Field field: fields) {
                String data = "Поле: " + field.getName() + ", его тип: " + field.getType() + ", его модификаторы: " + Modifier.toString(field.getModifiers()) + "\n";
                FileUtils.writeStringToFile(FILE, data, StandardCharsets.UTF_8, true);
            }
            for (Method method: methods) {
                String data = "Метод: " + method.getName() + ", его параметры: " + Arrays.toString(method.getParameters()) + ", его модификаторы: " + Modifier.toString(method.getModifiers()) +
                        ", его возвращаемый тип: " + method.getReturnType() + "\n";
                FileUtils.writeStringToFile(FILE, data, StandardCharsets.UTF_8, true);
            }
            for (Constructor<?> constructor: constructors) {
                String data = "Конструктор: " + constructor.getName() + ", его параметры: " + Arrays.toString(constructor.getParameters()) + ", его модификаторы: " + Modifier.toString(constructor.getModifiers()) + "\n";
                FileUtils.writeStringToFile(FILE, data, StandardCharsets.UTF_8, true);
            }
            FileUtils.writeStringToFile(FILE, "" + "\n", StandardCharsets.UTF_8, true);
        } catch (IOException ex) {
            LOGGER.warn(ex.getMessage());
        }

    }
}
