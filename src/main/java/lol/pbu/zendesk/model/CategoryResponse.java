package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * CategoryResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(CategoryResponse.JSON_PROPERTY_CATEGORY)
public class CategoryResponse {

    public static final String JSON_PROPERTY_CATEGORY = "category";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_CATEGORY)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private CategoryObject category;

    /**
     * @return the category property value
     */
    public CategoryObject getCategory() {
        return category;
    }

    /**
     * Set the category property value
     *
     * @param category property value to set
     */
    public void setCategory(CategoryObject category) {
        this.category = category;
    }

    /**
     * Set category in a chainable fashion.
     *
     * @return The same instance of CategoryResponse for chaining.
     */
    public CategoryResponse category(CategoryObject category) {
        this.category = category;
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
        var categoryResponse = (CategoryResponse) o;
        return Objects.equals(category, categoryResponse.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

    @Override
    public String toString() {
        return "CategoryResponse("
            + "category: " + getCategory()
            + ")";
    }

}