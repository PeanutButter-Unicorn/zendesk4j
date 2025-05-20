package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * UnifiedSearchResult
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    UnifiedSearchResult.JSON_PROPERTY_TITLE,
    UnifiedSearchResult.JSON_PROPERTY_TYPE,
    UnifiedSearchResult.JSON_PROPERTY_UPDATED_AT,
    UnifiedSearchResult.JSON_PROPERTY_URL,
})
public class UnifiedSearchResult {

    public static final String JSON_PROPERTY_TITLE = "title";
    public static final String JSON_PROPERTY_TYPE = "type";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";

    @Nullable
    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String title;

    @Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private UnifiedSearchResultType type;

    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime updatedAt;

    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * @return the title property value
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title property value
     *
     * @param title property value to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set title in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResult for chaining.
     */
    public UnifiedSearchResult title(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return the type property value
     */
    public UnifiedSearchResultType getType() {
        return type;
    }

    /**
     * Set the type property value
     *
     * @param type property value to set
     */
    public void setType(UnifiedSearchResultType type) {
        this.type = type;
    }

    /**
     * Set type in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResult for chaining.
     */
    public UnifiedSearchResult type(UnifiedSearchResultType type) {
        this.type = type;
        return this;
    }

    /**
     * @return the updatedAt property value
     */
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt property value
     *
     * @param updatedAt property value to set
     */
    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Set updatedAt in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResult for chaining.
     */
    public UnifiedSearchResult updatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * @return the url property value
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the url property value
     *
     * @param url property value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Set url in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResult for chaining.
     */
    public UnifiedSearchResult url(String url) {
        this.url = url;
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
        var unifiedSearchResult = (UnifiedSearchResult) o;
        return Objects.equals(title, unifiedSearchResult.title)
            && Objects.equals(type, unifiedSearchResult.type)
            && Objects.equals(updatedAt, unifiedSearchResult.updatedAt)
            && Objects.equals(url, unifiedSearchResult.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, updatedAt, url);
    }

    @Override
    public String toString() {
        return "UnifiedSearchResult("
            + "title: " + getTitle() + ", "
            + "type: " + getType() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl()
            + ")";
    }

}