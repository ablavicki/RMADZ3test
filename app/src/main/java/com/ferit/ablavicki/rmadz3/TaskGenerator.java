package com.ferit.ablavicki.rmadz3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TaskGenerator {

    private static final Random generator = new Random();

    public static Task generate(){
        int id = generator.nextInt(); // Does not guarantee uniqueness
        String title = TITLES[generator.nextInt(TITLES.length)];
        String category = CATEGORIES[generator.nextInt(CATEGORIES.length)];
        int priority = generator.nextInt(4);
        return new Task(id, priority, title, category);

    }

    public static List<Task> generate(int count){
        List<Task> books = new ArrayList<Task>();
        for (int i=0; i<count; i++){
            books.add(TaskGenerator.generate());
        }
        return books;
    }

    private static final String[] TITLES = new String[]{
            "jedan",
            "dva",
            "tri"
    };

    private static final String[] CATEGORIES = new String []{
            "prva",
            "druga",
            "treca"
    };


}
