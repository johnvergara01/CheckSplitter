package com.johnv.checksplitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.johnv.checksplitter.GlobalVariables.numOfPpl;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Person {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PersonItem> ITEMS = new ArrayList<PersonItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PersonItem> ITEM_MAP = new HashMap<String, PersonItem>();

    private static final int COUNT = numOfPpl;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPersonItem(i));
        }
    }

    private static void addItem(PersonItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PersonItem createPersonItem(int position) {
        return new PersonItem(String.valueOf(position), "", makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PersonItem {
        public final String id;
        public final String content;
        public final String details;

        public PersonItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
