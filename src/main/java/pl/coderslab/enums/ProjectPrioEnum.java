package pl.coderslab.enums;

import java.util.ArrayList;
import java.util.List;

public enum ProjectPrioEnum {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private String val;

    ProjectPrioEnum(String val) {
        this.val = val;
    }

    public String getProjectPrioEnum() {
        return val;
    }

    public static List<String> getNames() {
        List<String> list = new ArrayList<String>();
        for (ProjectPrioEnum test : ProjectPrioEnum.values()) {
            list.add(test.toString());
        }
        return list;
    }


}
