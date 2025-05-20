package lol.pbu.z4j.model;

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
 * UserSegmentsResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(UserSegmentsResponse.JSON_PROPERTY_USER_SEGMENTS)
public class UserSegmentsResponse {

    public static final String JSON_PROPERTY_USER_SEGMENTS = "user_segments";

    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_SEGMENTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid UserSegmentObject> userSegments;

    /**
     * @return the userSegments property value
     */
    public List<@Valid UserSegmentObject> getUserSegments() {
        return userSegments;
    }

    /**
     * Set the userSegments property value
     *
     * @param userSegments property value to set
     */
    public void setUserSegments(List<@Valid UserSegmentObject> userSegments) {
        this.userSegments = userSegments;
    }

    /**
     * Set userSegments in a chainable fashion.
     *
     * @return The same instance of UserSegmentsResponse for chaining.
     */
    public UserSegmentsResponse userSegments(List<@Valid UserSegmentObject> userSegments) {
        this.userSegments = userSegments;
        return this;
    }
    /**
     * Add an item to the userSegments property in a chainable fashion.
     *
     * @return The same instance of UserSegmentsResponse for chaining.
     */
    public UserSegmentsResponse addUserSegmentsItem(UserSegmentObject userSegmentsItem) {
        if (userSegments == null) {
            userSegments = new ArrayList<>();
        }
        userSegments.add(userSegmentsItem);
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
        var userSegmentsResponse = (UserSegmentsResponse) o;
        return Objects.equals(userSegments, userSegmentsResponse.userSegments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSegments);
    }

    @Override
    public String toString() {
        return "UserSegmentsResponse("
            + "userSegments: " + getUserSegments()
            + ")";
    }

}