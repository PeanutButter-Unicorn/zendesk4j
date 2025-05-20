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
 * UserSubscriptionsResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(UserSubscriptionsResponse.JSON_PROPERTY_USER_SUBSCRIPTIONS)
public class UserSubscriptionsResponse {

    public static final String JSON_PROPERTY_USER_SUBSCRIPTIONS = "user_subscriptions";

    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_SUBSCRIPTIONS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid UserSubscriptionObject> userSubscriptions;

    /**
     * @return the userSubscriptions property value
     */
    public List<@Valid UserSubscriptionObject> getUserSubscriptions() {
        return userSubscriptions;
    }

    /**
     * Set the userSubscriptions property value
     *
     * @param userSubscriptions property value to set
     */
    public void setUserSubscriptions(List<@Valid UserSubscriptionObject> userSubscriptions) {
        this.userSubscriptions = userSubscriptions;
    }

    /**
     * Set userSubscriptions in a chainable fashion.
     *
     * @return The same instance of UserSubscriptionsResponse for chaining.
     */
    public UserSubscriptionsResponse userSubscriptions(List<@Valid UserSubscriptionObject> userSubscriptions) {
        this.userSubscriptions = userSubscriptions;
        return this;
    }
    /**
     * Add an item to the userSubscriptions property in a chainable fashion.
     *
     * @return The same instance of UserSubscriptionsResponse for chaining.
     */
    public UserSubscriptionsResponse addUserSubscriptionsItem(UserSubscriptionObject userSubscriptionsItem) {
        if (userSubscriptions == null) {
            userSubscriptions = new ArrayList<>();
        }
        userSubscriptions.add(userSubscriptionsItem);
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
        var userSubscriptionsResponse = (UserSubscriptionsResponse) o;
        return Objects.equals(userSubscriptions, userSubscriptionsResponse.userSubscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSubscriptions);
    }

    @Override
    public String toString() {
        return "UserSubscriptionsResponse("
            + "userSubscriptions: " + getUserSubscriptions()
            + ")";
    }

}