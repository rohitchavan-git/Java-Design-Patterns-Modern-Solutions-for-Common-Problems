package com.rohit.decorator;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Function;

class Camera {
    private Function<Color,Color> filters;

    @SafeVarargs
    public Camera(Function<Color,Color> ... filters) {
        this.filters  = Arrays.stream(filters)
                .reduce(Function.identity(), Function::andThen);
    }
    public Color snap(Color color) {
        return filters.apply(color);
    }
}

public class Sample {

    public static void main(String[] args) {
        print(new Camera(Color::darker));
        print(new Camera(Color::brighter));
        print(new Camera(Color::brighter,Color::darker));
    }

    private static void print(Camera camera) {
        camera.snap(new Color(125,125,125));
    }

}

