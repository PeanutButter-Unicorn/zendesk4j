package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * TopicResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(TopicResponse.JSON_PROPERTY_TOPIC)
public class TopicResponse {

    public static final String JSON_PROPERTY_TOPIC = "topic";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_TOPIC)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private TopicObject topic;

    /**
     * @return the topic property value
     */
    public TopicObject getTopic() {
        return topic;
    }

    /**
     * Set the topic property value
     *
     * @param topic property value to set
     */
    public void setTopic(TopicObject topic) {
        this.topic = topic;
    }

    /**
     * Set topic in a chainable fashion.
     *
     * @return The same instance of TopicResponse for chaining.
     */
    public TopicResponse topic(TopicObject topic) {
        this.topic = topic;
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
        var topicResponse = (TopicResponse) o;
        return Objects.equals(topic, topicResponse.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic);
    }

    @Override
    public String toString() {
        return "TopicResponse("
            + "topic: " + getTopic()
            + ")";
    }

}