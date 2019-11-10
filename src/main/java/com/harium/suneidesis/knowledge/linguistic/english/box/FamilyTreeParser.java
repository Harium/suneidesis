package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.ancestry.Ancestry;
import com.harium.suneidesis.beign.ancestry.HeteroSexualCouple;
import com.harium.suneidesis.input.InputContext;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.output.Output;

public class FamilyTreeParser implements Parser {

    public static final String FAMILY_FATHER = "father";
    public static final String FAMILY_MOTHER = "mother";

    public static final String WHO = "who";

    @Override
    public boolean matches(InputContext context) {
        String query = context.getSentence();
        String[] parts = query.split(" ");
        return BaseEnglishBox.checkAction(parts[0], WHO);
    }

    @Override
    public void parse(InputContext context) {
        String query = context.getSentence();
        Instance being = context.getInstance();
        Output output = context.getOutput();

        String[] parts = query.split(" ");

        String relationship = parts[parts.length - 1];

        String name = "";

        if (FAMILY_FATHER.equalsIgnoreCase(relationship)) {
            name = findFather(being);
        }

        if (FAMILY_MOTHER.equalsIgnoreCase(relationship)) {
            name = findMother(being);
        }

        if (name.isEmpty()) {
            name = "";
        }

        output.print(name);
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
