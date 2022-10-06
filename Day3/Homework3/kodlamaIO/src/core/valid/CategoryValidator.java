package core.valid;

import entities.Category;
import java.util.List;

public class CategoryValidator {
    public static void isUnique(List<Category> categories,Category category) throws Exception {
        for (Category c : categories) {
            if (c.getCategoryName().equals(category.getCategoryName())) {
                throw new Exception("This category name is already registered in the system. Cannot be re-registered");
            }
        }

    }
}
