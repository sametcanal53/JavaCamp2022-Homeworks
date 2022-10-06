package business;

import core.logging.Logger;
import core.valid.CategoryValidator;
import dataAccess.CategoryDao;
import entities.Category;

import java.util.List;

public class CategoryManager {
    private List<Category> categories;
    private CategoryDao categoryDao;
    private Logger[] loggers;

    public CategoryManager(List<Category> categories,CategoryDao categoryDao, Logger[] loggers) {
        this.categories = categories;
        this.categoryDao = categoryDao;
        this.loggers = loggers;
    }

    public void add(Category category) throws Exception {
        CategoryValidator.isUnique(categories,category);
        this.categories.add(category);
        this.categoryDao.add(category);
        for (Logger logger : loggers) {
            logger.log(category.getCategoryName());
        }
    }

    public void update(Category category) {
        this.categoryDao.update(category);
        for (Logger logger : loggers) {
            logger.log(category.getCategoryName());
        }
    }

    public void delete(Category category) {
        this.categoryDao.delete(category);
        for (Logger logger : loggers) {
            logger.log(category.getCategoryName());
        }
    }

}
