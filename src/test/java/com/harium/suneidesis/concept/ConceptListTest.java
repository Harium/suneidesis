package com.harium.suneidesis.concept;

import org.junit.Assert;
import org.junit.Test;

public class ConceptListTest {

    @Test
    public void testSimple() {
        ConceptList recipe = new ConceptList(ConceptType.MEASUREMENT);
        recipe.setName("Chocolate Cake");

        recipe.add(ingredient("all-purpose flour", "1 ½", "cup"));
        recipe.add(ingredient("white sugar", "1", "cup"));
        recipe.add(ingredient("cocoa powder", "¼", "cup"));
        recipe.add(ingredient("baking soda", "1", "teaspoon"));
        recipe.add(ingredient("salt", "½", "teaspoon"));
        recipe.add(ingredient("vegetable oil", "⅓", "cup"));
        recipe.add(ingredient("vanilla extract", "1", "teaspoon"));
        recipe.add(ingredient("distilled white vinegar", "1", "teaspoon"));
        recipe.add(ingredient("water", "1", "cup water"));

        Assert.assertEquals("white sugar", recipe.get(1).getName());
        Assert.assertEquals("water", recipe.get(8).getName());
        Assert.assertEquals(9, recipe.getSize());
    }

    @Test
    public void testRemove() {
        ConceptList recipe = new ConceptList(ConceptType.MEASUREMENT);
        recipe.setName("Incomplete Cake");

        recipe.add(ingredient("all-purpose flour", "1 ½", "cup"));
        recipe.add(ingredient("white sugar", "1", "cup"));
        recipe.add(ingredient("cocoa powder", "¼", "cup"));
        recipe.add(ingredient("baking soda", "1", "teaspoon"));
        Concept salt = ingredient("salt", "½", "teaspoon");
        recipe.add(salt);
        Concept oil = ingredient("vegetable oil", "⅓", "cup");
        recipe.add(oil);
        recipe.add(ingredient("vanilla extract", "1", "teaspoon"));
        recipe.add(ingredient("distilled white vinegar", "1", "teaspoon"));
        recipe.add(ingredient("water", "1", "cup water"));

        recipe.remove(salt);
        Assert.assertEquals("white sugar", recipe.get(1).getName());
        Assert.assertEquals("water", recipe.get(7).getName());
        Assert.assertEquals(8, recipe.getSize());

        recipe.remove(oil);
        Assert.assertEquals("water", recipe.get(6).getName());
        Assert.assertEquals(7, recipe.getSize());
    }

    private Concept ingredient(String name, String quantity, String unit) {
        Concept concept = new Concept(name);
        concept.set("quantity", new Measurement(quantity, unit));
        return concept;
    }


}
