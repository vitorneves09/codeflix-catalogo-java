package br.com.neves.codeflix.domain.category;

import br.com.neves.codeflix.domain.AggregateRoot;
import br.com.neves.codeflix.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(
            final CategoryID aid,
            final  String aName,
            final  String aDescription,
            final boolean aActive,
            final Instant aCreatedAt,
            final Instant aUpdatedAt,
            final Instant aDeletedAt) {

        super(aid);
        this.name = aName;
        this.description = aDescription;
        this.active = aActive;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;
        this.deletedAt =  aDeletedAt;
    }

    public static Category  newCategory(String name,String description, boolean active) {
        return new Category(CategoryID.unique(), name, description, active, Instant.now(), Instant.now(), Instant.now());
    }


    public Instant getDeletedAt() {
        return deletedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new CategoryValidator(this,handler).validate();
    }
}