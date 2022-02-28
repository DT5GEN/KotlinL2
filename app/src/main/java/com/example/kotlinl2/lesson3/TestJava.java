package com.example.kotlinl2.lesson3;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
    @NotNull
    private String toBeOrNotToBe;

    @Nullable
    public String toBeOrNotToBe (@NotNull String names) {

        int i = 2;
        Integer ii = 2;

        List<String> strings = new ArrayList();
        List <? extends Object> objects = strings;
        //objects.add(8); // нельзя добавлять
        Object obj = objects.get(0); // но можно получить значение
        List<CharSequence> chars = new ArrayList<>();
        List<? super String> stringi = chars;
        stringi.add("dfgf"); // можно добавлять строчки

        String str = (String) stringi.get(0);  // контрвариантность, элементы должны являться суперклассaми по отношению к стрингу
                                      // как решение нужно закастить (String)
        return toBeOrNotToBe;
    }
}
