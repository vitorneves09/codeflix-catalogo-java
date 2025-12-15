package br.com.neves.codeflix.domain.category;

import br.com.neves.codeflix.domain.pagination.CategorySearchQuery;
import br.com.neves.codeflix.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {
    Category create(Category category);
    void deleteById(CategoryID categoryID);
    Optional<Category> findById(CategoryID categoryID);
    Category update(Category category);
    Pagination<Category> findAll(CategorySearchQuery aQuery);
}
