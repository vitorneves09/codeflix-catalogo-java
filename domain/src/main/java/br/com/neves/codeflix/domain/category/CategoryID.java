package br.com.neves.codeflix.domain.category;

import br.com.neves.codeflix.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String valeu;

    public CategoryID(String valeu) {
        this.valeu = valeu;
    }

    public static CategoryID unique(){
        return  CategoryID.from(UUID.randomUUID().toString());
    }

    public static CategoryID from(final String anId){
        return new CategoryID(anId);
    }

    public static CategoryID from(final UUID anId){
        return new CategoryID(anId.toString().toLowerCase());
    }

    public String getValeu() {
        return valeu;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryID that = (CategoryID) o;
        return Objects.equals(getValeu(), that.getValeu());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValeu());
    }
}


