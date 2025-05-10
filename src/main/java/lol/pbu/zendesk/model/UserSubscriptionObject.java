package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Objects;

/**
 * UserSubscriptionObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    UserSubscriptionObject.JSON_PROPERTY_FOLLOWED_ID,
    UserSubscriptionObject.JSON_PROPERTY_FOLLOWER_ID,
    UserSubscriptionObject.JSON_PROPERTY_ID,
})
public class UserSubscriptionObject {

    public static final String JSON_PROPERTY_FOLLOWED_ID = "followed_id";
    public static final String JSON_PROPERTY_FOLLOWER_ID = "follower_id";
    public static final String JSON_PROPERTY_ID = "id";

    /**
     * The id of the user being followed
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FOLLOWED_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer followedId;

    /**
     * The id of the user doing the following
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FOLLOWER_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer followerId;

    /**
     * Automatically assigned when the subscription is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    public UserSubscriptionObject() {
    }

    /**
     * The id of the user being followed
     *
     * @return the followedId property value
     */
    public Integer getFollowedId() {
        return followedId;
    }

    /**
     * Set the followedId property value
     *
     * @param followedId property value to set
     */
    public void setFollowedId(Integer followedId) {
        this.followedId = followedId;
    }

    /**
     * The id of the user doing the following
     *
     * @return the followerId property value
     */
    public Integer getFollowerId() {
        return followerId;
    }

    /**
     * Set the followerId property value
     *
     * @param followerId property value to set
     */
    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    /**
     * Automatically assigned when the subscription is created
     *
     * @return the id property value
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id property value
     *
     * @param id property value to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var userSubscriptionObject = (UserSubscriptionObject) o;
        return Objects.equals(followedId, userSubscriptionObject.followedId)
            && Objects.equals(followerId, userSubscriptionObject.followerId)
            && Objects.equals(id, userSubscriptionObject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followedId, followerId, id);
    }

    @Override
    public String toString() {
        return "UserSubscriptionObject("
            + "followedId: " + getFollowedId() + ", "
            + "followerId: " + getFollowerId() + ", "
            + "id: " + getId()
            + ")";
    }

}