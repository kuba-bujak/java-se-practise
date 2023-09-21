package pl.globallogic.patterns.singleton;

public enum WebDriverManagerEnum {
    INSTANCE("Default arguments") {
        @Override
        void method1() {
            System.out.println("Method in instance");
        }
    };

    private String params;
    WebDriverManagerEnum(String params) {
        this.params = params;
        System.out.println("Make all heavyweight job once");
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    abstract void method1();
}
