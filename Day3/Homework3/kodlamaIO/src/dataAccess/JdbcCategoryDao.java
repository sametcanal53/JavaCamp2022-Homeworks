package dataAccess;

import entities.Category;

public class JdbcCategoryDao implements CategoryDao {
    @Override
    public void add(Category category) {
        System.out.println("Category added with JDBC : " + category.getCategoryName());
    }

    @Override
    public void update(Category category) {
        System.out.println("Category updated with JDBC : " + category.getCategoryName());
    }

    @Override
    public void delete(Category category) {
        System.out.println("Category deleted with JDBC : " + category.getCategoryName());
    }
}
