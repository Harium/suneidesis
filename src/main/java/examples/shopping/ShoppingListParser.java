package examples.shopping;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.harium.suneidesis.linguistic.english.box.MatcherUtils.*;

public class ShoppingListParser implements Parser {

    private static final String NAME_LIST = "list";

    public static final String MESSAGE_EMPTY = "Your shopping list is empty.";

    private final Map<Pattern, Integer> addPatterns = new HashMap<>();
    private final List<Pattern> queryPatterns = new ArrayList<>();
    private final List<String> shoppingList = new ArrayList<>();

    public ShoppingListParser() {
        addPattern(Pattern.compile(optional(can()+whiteSpace()) + optionalSentence()
                                        + "add" + whiteSpace()
                                        // Product name
                                        + someSentence()
                                        + whiteSpace() + "to"
                                        + someSentence() + NAME_LIST + someSentence(), Pattern.CASE_INSENSITIVE), 3);

        queryPatterns.add(Pattern.compile("What"+someSentence()+ whiteSpace() + once(have()) + someSentence() + whiteSpace() + NAME_LIST + someSentence(), Pattern.CASE_INSENSITIVE));
    }

    private void addPattern(Pattern pattern, int group) {
        addPatterns.put(pattern, group);
    }

    @Override
    public boolean parse(InputContext input, Output output) {
        String sentence = input.getSentence();

        // It's a command to add the product
        if (parseAddProduct(output, sentence)) {
            return true;
        }

        // It's a command to query the list
        if (parseQueryList(sentence, output)) {
            return true;
        }

        return false;
    }

    private boolean parseAddProduct(Output output, String sentence) {
        String product = getProduct(sentence);
        if (product != null && !product.isEmpty()) {
            shoppingList.add(product);
            output.print("Product " + product + " was added to the shopping list.");
            return true;
        }
        return false;
    }

    private String getProduct(String sentence) {
        for (Map.Entry<Pattern, Integer> entry : addPatterns.entrySet()) {
            Pattern pattern = entry.getKey();
            Matcher m = pattern.matcher(sentence);
            if (m.find()) {
                int group = entry.getValue();
                return m.group(group);
            }
        }
        return "";
    }

    private boolean parseQueryList(String sentence, Output output) {
        for (Pattern pattern : queryPatterns) {
            Matcher m = pattern.matcher(sentence);
            if (m.matches()) {
                output.print(printList());
                return true;
            }
        }
        return false;
    }

    private String printList() {
        if (shoppingList.isEmpty()) {
            return MESSAGE_EMPTY;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Your shopping list has: ");

        for (int i = 0; i < shoppingList.size(); i++) {
            String product = shoppingList.get(i);
            stringBuilder.append(product);
            if (i < shoppingList.size() - 2) {
                stringBuilder.append(", ");
            } else if (i == shoppingList.size() - 2) {
                stringBuilder.append(" and ");
            }
        }

        return stringBuilder.toString();
    }

}
