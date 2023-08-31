package pl.globallogic.lessons.Enums;

import java.util.HashMap;
import java.util.Map;

public class EnumExample {
    public enum Answer {
        TAK(true),
        NIE(false),
        T(true),
        N(false),
        YES(true),
        NO(false),
        OK(true),
        SURE(true),
        NOPE(false);

        private boolean value;

        private Answer(boolean value) {
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
    }

    public enum Element implements Labeled {
        H("Hydrogen"),
        HE("Helium"),
        LI("Lithium"),
        BE("Beryllium"),
        B("Boron"),
        C("Carbon"),
        N("Nitrogen"),
        O("Oxygen"),
        F("Fluorine"),
        NE("Neon");

        public final String label;

        private Element(String label) {
            this.label = label;
        }

        private static final Map<String, Element> BY_LABEL = new HashMap<>();

        static {
            for (Element e: values()) {
                BY_LABEL.put(e.label, e);
            }
        }
        public static Element valueOfLabel(String label) {
            return BY_LABEL.get(label);
        }

        public String toString() {
            return this.label;
        }

        @Override
        public String label() {
            return label;
        }
    }

    public interface Labeled {
        String label();
    }

    public static void main(String[] args) {
        EnumExample test = new EnumExample();
        String[] userValues = {"tak", "TAK", "OK", "ta", "nie", "niewiem", "NoPe" };

        test.simplePrint("==ENTRANCE==", "==OUTPUT==");
        test.simplePrint("-----------", "-----------");

        for(String value : userValues) {
            test.simplePrint(value, test.userAnswerString(value));
        }
    }

    public String userAnswerString(String value) {
        try {
            return userAnswer(value) ? "positive" : "negative";
        } catch (UnknownAnswerException e) {
            return "unknown";
        }
    }

    public boolean userAnswer(String value) throws UnknownAnswerException {
        for (Answer answer : Answer.values()) {
            if (answer.toString().equalsIgnoreCase(value))
                return answer.getValue();
        }
        throw new UnknownAnswerException();
    }

    private void simplePrint(String one, String two) {
        System.out.printf("%15s  |  %10s\n", one, two);
    }
}
