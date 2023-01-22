package com.donghwan.study.design.singleton;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonTest {

    @DisplayName("싱글턴 깨기 1 : 리플랙션")
    @Test
    void singleton_test_1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        DoubleCheckSingleton singleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton singleton2 = DoubleCheckSingleton.getInstance();

        assertEquals(singleton1, singleton2);

        Constructor<DoubleCheckSingleton> constructor = DoubleCheckSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        DoubleCheckSingleton singleton3 = constructor.newInstance();
        DoubleCheckSingleton singleton4 = constructor.newInstance();

        assertNotEquals(singleton1, singleton3);
        assertNotEquals(singleton1, singleton4);
        assertNotEquals(singleton2, singleton3);
        assertNotEquals(singleton2, singleton4);
        assertNotEquals(singleton3, singleton4);
    }

    @DisplayName("싱글턴 꺠기 2 : 직렬화, 역직렬화")
    @Test
    void singleton_test_2() throws IOException, ClassNotFoundException {
        LazyInitByHolderSingleton singleton1 = LazyInitByHolderSingleton.getInstance();
        LazyInitByHolderSingleton singleton2 = LazyInitByHolderSingleton.getInstance();

        assertEquals(singleton1, singleton2);

        LazyInitByHolderSingleton singleton3 = null;
        //직렬화
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.obj"))) {
            out.writeObject(singleton1);
        }

        //역직렬화
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.obj"))) {
            singleton3 = (LazyInitByHolderSingleton) in.readObject();
        }

        assertNotEquals(singleton1, singleton3);
        assertNotEquals(singleton2, singleton3);
    }

}