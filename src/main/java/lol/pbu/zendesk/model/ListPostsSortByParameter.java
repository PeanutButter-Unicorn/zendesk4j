package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Gets or Sets ListPosts_sort_by_parameter
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
public enum ListPostsSortByParameter {

    @JsonProperty("created_at")
    CREATED_AT("created_at"),
    @JsonProperty("edited_at")
    EDITED_AT("edited_at"),
    @JsonProperty("updated_at")
    UPDATED_AT("updated_at"),
    @JsonProperty("recent_activity")
    RECENT_ACTIVITY("recent_activity"),
    @JsonProperty("votes")
    VOTES("votes"),
    @JsonProperty("comments")
    COMMENTS("comments"),
    ;

    public static final Map<String, ListPostsSortByParameter> VALUE_MAPPING = Map.copyOf(Arrays.stream(values())
        .collect(Collectors.toMap(v -> v.value, Function.identity())));

    private final String value;

    ListPostsSortByParameter(String value) {
        this.value = value;
    }

    /**
     * @return The value represented by this enum
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Create this enum from a value.
     *
     * @param value The value
     *
     * @return The enum
     */
    @JsonCreator
    public static ListPostsSortByParameter fromValue(String value) {
        if (!VALUE_MAPPING.containsKey(value)) {
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
        return VALUE_MAPPING.get(value);
    }
}