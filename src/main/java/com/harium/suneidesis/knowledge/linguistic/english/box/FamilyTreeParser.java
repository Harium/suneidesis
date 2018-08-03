package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.ancestry.Ancestry;
import com.harium.suneidesis.beign.ancestry.HeteroSexualCouple;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

public class FamilyTreeParser implements Parser {

    public static final String FAMILY_FATHER = "father";
    public static final String FAMILY_MOTHER = "mother";

    public static final String WHO = "who";

    @Override
    public boolean matches(String query) {
        String[] parts = query.split(" ");
        return BaseEnglishBox.checkAction(parts[0], WHO);
    }

    @Override
    public String parse(String query, Instance beign) {

        String[] parts = query.split(" ");

        String relationship = parts[parts.length - 1];

        String name = "";

        if (FAMILY_FATHER.equalsIgnoreCase(relationship)) {
            name = findFather(beign);
        }

        if (FAMILY_MOTHER.equalsIgnoreCase(relationship)) {
            name = findMother(beign);
        }

        if (name.isEmpty()) {
            name = "";
        }

        return name;
    }

    private String findFather(Being beign) {
        Ancestry ancestry = beign.getAncestry();
        if (ancestry instanceof HeteroSexualCouple) {
            Being father = ((HeteroSexualCouple) ancestry).getFather();

            if (father != null) {
                return father.getName();
            }
        }

        return "";
    }

    private String findMother(Being beign) {
        Ancestry ancestry = beign.getAncestry();
        if (ancestry instanceof HeteroSexualCouple) {
            Being mother = ((HeteroSexualCouple) ancestry).getMother();

            if (mother != null) {
                return mother.getName();
            }
        }

        return "";
    }

}
