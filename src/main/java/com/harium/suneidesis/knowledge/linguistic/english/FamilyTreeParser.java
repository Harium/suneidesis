package com.harium.suneidesis.knowledge.linguistic.english;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.beign.ancestry.Ancestry;
import com.harium.suneidesis.knowledge.beign.ancestry.HeteroSexualCouple;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

public class FamilyTreeParser implements Parser {

    @Override
    public String parse(String query, Being beign) {

        String[] parts = query.replaceAll("\\?", "").split(" ");

        String relationship = parts[parts.length - 1];

        String name = "";

        if ("father".equalsIgnoreCase(relationship)) {
            name = findFather(beign);
        }

        if ("mother".equalsIgnoreCase(relationship)) {
            name = findMother(beign);
        }

        if (name.isEmpty()) {
            name = BaseParser.I_DON_T_KNOW;
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
