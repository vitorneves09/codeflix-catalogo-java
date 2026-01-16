package br.com.neves.codeflix.domain.category;

import br.com.neves.codeflix.domain.AggregateRoot;
import br.com.neves.codeflix.domain.utils.InstantUtils;
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

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = CategoryID.unique();
        final var now = InstantUtils.now();
        final var deletedAt = isActive ? null : now;
        return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }

    public Category deactivate() {
        if(getDeletedAt() == null){
            this.deletedAt = Instant.now();
        }

        this.active = false;
        this.updatedAt = Instant.now();

        return this;
    }

    public Category activate() {
        if(getDeletedAt() != null){
            this.deletedAt = null;
        }

        this.active = true;
        this.updatedAt = Instant.now();

        return this;
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

    public Category update(String aName, String aDescription, boolean isActive) {
        if (isActive) {
            activate();
        }else {
            deactivate();
        }

        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.updatedAt = Instant.now();

        return this;
    }
}