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
 * ContentSubscriptionsResponse
 */
@Serdeable
@JsonPropertyOrder(ContentSubscriptionsResponse.JSON_PROPERTY_SUBSCRIPTIONS)
public class ContentSubscriptionsResponse {

    public static final String JSON_PROPERTY_SUBSCRIPTIONS = "subscriptions";

    @Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTIONS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid ContentSubscriptionObject> subscriptions;

    /**
     * @return the subscriptions property value
     */
    public List<@Valid ContentSubscriptionObject> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Set the subscriptions property value
     *
     * @param subscriptions property value to set
     */
    public void setSubscriptions(List<@Valid ContentSubscriptionObject> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * Set subscriptions in a chainable fashion.
     *
     * @return The same instance of ContentSubscriptionsResponse for chaining.
     */
    public ContentSubscriptionsResponse subscriptions(List<@Valid ContentSubscriptionObject> subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }
    /**
     * Add an item to the subscriptions property in a chainable fashion.
     *
     * @return The same instance of ContentSubscriptionsResponse for chaining.
     */
    public ContentSubscriptionsResponse addSubscriptionsItem(ContentSubscriptionObject subscriptionsItem) {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscriptionsItem);
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
        var contentSubscriptionsResponse = (ContentSubscriptionsResponse) o;
        return Objects.equals(subscriptions, contentSubscriptionsResponse.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptions);
    }

    @Override
    public String toString() {
        return "ContentSubscriptionsResponse("
            + "subscriptions: " + getSubscriptions()
            + ")";
    }

}