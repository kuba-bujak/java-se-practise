package pl.globallogic.exersices.basic.Ex48Interface;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> savedValues);
}
