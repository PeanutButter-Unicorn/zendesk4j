package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CategoriesResponse
 */
@Serdeable
@JsonPropertyOrder(CategoriesResponse.JSON_PROPERTY_CATEGORIES)
public class CategoriesResponse {

    public static final String JSON_PROPERTY_CATEGORIES = "categories";

    @Nullable
    @JsonProperty(JSON_PROPERTY_CATEGORIES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid CategoryObject> categories;

    /**
     * @return the categories property value
     */
    public List<@Valid CategoryObject> getCategories() {
        return categories;
    }

    /**
     * Set the categories property value
     *
     * @param categories property value to set
     */
    public void setCategories(List<@Valid CategoryObject> categories) {
        this.categories = categories;
    }

    /**
     * Set categories in a chainable fashion.
     *
     * @return The same instance of CategoriesResponse for chaining.
     */
    public CategoriesResponse categories(List<@Valid CategoryObject> categories) {
        this.categories = categories;
        return this;
    }
    /**
     * Add an item to the categories property in a chainable fashion.
     *
     * @return The same instance of CategoriesResponse for chaining.
     */
    public CategoriesResponse addCategoriesItem(CategoryObject categoriesItem) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(categoriesItem);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var categoriesResponse = (CategoriesResponse) o;
        return Objects.equals(categories, categoriesResponse.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories);
    }

    @Override
    public String toString() {
        return "CategoriesResponse("
            + "categories: " + getCategories()
            + ")";
    }

}