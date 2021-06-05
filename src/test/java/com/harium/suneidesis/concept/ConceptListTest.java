package com.harium.suneidesis.concept;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

        recipe.removeByName(salt.getName());
        Assert.assertEquals("white sugar", recipe.get(1).getName());
        Assert.assertEquals("water", recipe.get(7).getName());
        Assert.assertEquals(8, recipe.getSize());

        recipe.removeByName(oil.getName());
        Assert.assertEquals("water", recipe.get(6).getName());
        Assert.assertEquals(7, recipe.getSize());
    }

    @Test
    public void testGetAll() {
        ConceptList list = new ConceptList("Just a List");

        list.add(new Concept("item 1"));
        list.add(new Concept("item 2"));
        list.add(new Concept("item 3"));

        List<Concept> result = list.getAll();

        Assert.assertEquals(3, result.size());
        Assert.assertEquals("item 1", list.get(0).getName());
        Assert.assertEquals("item 2", list.get(1).getName());
        Assert.assertEquals("item 3", list.get(2).getName());

        list.removeByName("item 2");
        list.add(new Concept("item 2"));

        Assert.assertEquals(3, result.size());
        Assert.assertEquals("item 1", list.get(0).getName());
        Assert.assertEquals("item 3", list.get(1).getName());
        Assert.assertEquals("item 2", list.get(2).getName());
    }

    @Test
    public void testWrap() {
        Concept list = new Concept("Just a List");

        list.has("0", new Concept("item 0"));
        list.has("1", new Concept("item 1"));

        ConceptList wrapped = new ConceptList("list").wrap(list);

        Assert.assertEquals(2, wrapped.getSize());
        Assert.assertEquals("item 0", wrapped.get(0).getName());
        Assert.assertEquals("item 1", wrapped.get(1).getName());
        Assert.assertTrue(wrapped.get(2).isUnknown());
    }

    @Test
    public void testClear() {
        ConceptList list = new ConceptList("Just a List");

        list.add(new Concept("item 1"));
        list.add(new Concept("item 2"));

        list.clear();

        Assert.assertEquals(0, list.getSize());
        Assert.assertTrue(list.get(0).isUnknown());
    }

    private Concept ingredient(String name, String quantity, String unit) {
        Concept concept = new Concept(name);
        concept.set("quantity", new Measurement(quantity, unit));
        return concept;
    }


}
