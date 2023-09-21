package pl.globallogic.patterns.singleton;

public class InternshipWebDriverManager {
    private static final InternshipWebDriverManager instance = new InternshipWebDriverManager();

    private InternshipWebDriverManager() {
        System.out.println("Can not be used to create instance because it's a SINGLETON!!!!!");
    }

    public static InternshipWebDriverManager getInstance() {
        if (instance == null) return new InternshipWebDriverManager();
        return instance;
    }
}
