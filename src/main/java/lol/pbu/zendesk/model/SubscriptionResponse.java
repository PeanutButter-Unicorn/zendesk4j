package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * SubscriptionResponse
 */
@Serdeable
@JsonPropertyOrder(SubscriptionResponse.JSON_PROPERTY_SUBSCRIPTION)
public class SubscriptionResponse {

    public static final String JSON_PROPERTY_SUBSCRIPTION = "subscription";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ContentSubscriptionObject subscription;

    /**
     * @return the subscription property value
     */
    public ContentSubscriptionObject getSubscription() {
        return subscription;
    }

    /**
     * Set the subscription property value
     *
     * @param subscription property value to set
     */
    public void setSubscription(ContentSubscriptionObject subscription) {
        this.subscription = subscription;
    }

    /**
     * Set subscription in a chainable fashion.
     *
     * @return The same instance of SubscriptionResponse for chaining.
     */
    public SubscriptionResponse subscription(ContentSubscriptionObject subscription) {
        this.subscription = subscription;
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
        var subscriptionResponse = (SubscriptionResponse) o;
        return Objects.equals(subscription, subscriptionResponse.subscription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscription);
    }

    @Override
    public String toString() {
        return "SubscriptionResponse("
            + "subscription: " + getSubscription()
            + ")";
    }

}