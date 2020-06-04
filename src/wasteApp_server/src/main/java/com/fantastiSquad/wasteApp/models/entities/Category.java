package com.fantastiSquad.wasteApp.models.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

public enum Category {
    CEREAL("Céréales"),
    MILK ("lait");

    private final String description;

    Category( String description) {
        this.description = description;
    }

    public static String getDescription(String description) {
        for (Category cat : Category.values()) {
            if (cat.description.equals(description)) return cat.description;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='" + this.description + '\'' +
                '}';
    }
}
