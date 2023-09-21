package pl.globallogic.streams.examples;

import java.util.stream.IntStream;

public class StreamCreationPlayground {
    public static void main(String[] args) {
        // of
        // builder
        // generate
        // iterate
        var str = IntStream.generate(() -> (int)(Math.random() * 1000)).limit(20).boxed().toList();
        System.out.println(str);
    }
}
