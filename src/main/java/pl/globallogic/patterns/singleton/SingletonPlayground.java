package pl.globallogic.patterns.singleton;

public class SingletonPlayground {
    public static void main(String[] args) {
        InternshipWebDriverManager manager1 = InternshipWebDriverManager.getInstance();
        InternshipWebDriverManager manager2 = InternshipWebDriverManager.getInstance();
        System.out.println(manager2 == manager1);

        WebDriverManagerEnum in1 = null;
        WebDriverManagerEnum in2 = WebDriverManagerEnum.INSTANCE;
        WebDriverManagerEnum in3 = WebDriverManagerEnum.INSTANCE;
        System.out.println(in1 == in2);
    }
}
