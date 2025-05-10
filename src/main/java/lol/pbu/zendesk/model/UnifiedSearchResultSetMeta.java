package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Objects;

/**
 * UnifiedSearchResultSetMeta
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    UnifiedSearchResultSetMeta.JSON_PROPERTY_AFTER_CURSOR,
    UnifiedSearchResultSetMeta.JSON_PROPERTY_BEFORE_CURSOR,
    UnifiedSearchResultSetMeta.JSON_PROPERTY_HAS_MORE,
})
public class UnifiedSearchResultSetMeta {

    public static final String JSON_PROPERTY_AFTER_CURSOR = "after_cursor";
    public static final String JSON_PROPERTY_BEFORE_CURSOR = "before_cursor";
    public static final String JSON_PROPERTY_HAS_MORE = "has_more";

    @Nullable
    @JsonProperty(JSON_PROPERTY_AFTER_CURSOR)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String afterCursor;

    @Nullable
    @JsonProperty(JSON_PROPERTY_BEFORE_CURSOR)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String beforeCursor;

    @Nullable
    @JsonProperty(JSON_PROPERTY_HAS_MORE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean hasMore;

    /**
     * @return the afterCursor property value
     */
    public String getAfterCursor() {
        return afterCursor;
    }

    /**
     * Set the afterCursor property value
     *
     * @param afterCursor property value to set
     */
    public void setAfterCursor(String afterCursor) {
        this.afterCursor = afterCursor;
    }

    /**
     * Set afterCursor in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResultSetMeta for chaining.
     */
    public UnifiedSearchResultSetMeta afterCursor(String afterCursor) {
        this.afterCursor = afterCursor;
        return this;
    }

    /**
     * @return the beforeCursor property value
     */
    public String getBeforeCursor() {
        return beforeCursor;
    }

    /**
     * Set the beforeCursor property value
     *
     * @param beforeCursor property value to set
     */
    public void setBeforeCursor(String beforeCursor) {
        this.beforeCursor = beforeCursor;
    }

    /**
     * Set beforeCursor in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResultSetMeta for chaining.
     */
    public UnifiedSearchResultSetMeta beforeCursor(String beforeCursor) {
        this.beforeCursor = beforeCursor;
        return this;
    }

    /**
     * @return the hasMore property value
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * Set the hasMore property value
     *
     * @param hasMore property value to set
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    /**
     * Set hasMore in a chainable fashion.
     *
     * @return The same instance of UnifiedSearchResultSetMeta for chaining.
     */
    public UnifiedSearchResultSetMeta hasMore(Boolean hasMore) {
        this.hasMore = hasMore;
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
        var unifiedSearchResultSetMeta = (UnifiedSearchResultSetMeta) o;
        return Objects.equals(afterCursor, unifiedSearchResultSetMeta.afterCursor)
            && Objects.equals(beforeCursor, unifiedSearchResultSetMeta.beforeCursor)
            && Objects.equals(hasMore, unifiedSearchResultSetMeta.hasMore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(afterCursor, beforeCursor, hasMore);
    }

    @Override
    public String toString() {
        return "UnifiedSearchResultSetMeta("
            + "afterCursor: " + getAfterCursor() + ", "
            + "beforeCursor: " + getBeforeCursor() + ", "
            + "hasMore: " + getHasMore()
            + ")";
    }

}