package test;

import java.util.HashMap;
import java.util.Map;

public class SqlQueryBuilder {
    public static void main(String[] args) {
        String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        Map<String, String> filter = new HashMap<>();
        filter.put("name", "Ivanov");
        filter.put("country", "Russia");
        filter.put("city", "Moscow");
        filter.put("age", null);

        StringBuilder queryBuilder = new StringBuilder("select * from students where ");

        boolean isFirstFilter = true;
        for (Map.Entry<String, String> entry : filter.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                continue; 
            }

            if (!isFirstFilter) {
                queryBuilder.append(" AND ");
            } else {
                isFirstFilter = false;
            }

            queryBuilder.append(key).append(" = ").append(value);
        }

        String query = queryBuilder.toString();
        System.out.println(query);
    }
}
