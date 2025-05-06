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
 * TopicsResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(TopicsResponse.JSON_PROPERTY_TOPICS)
public class TopicsResponse {

    public static final String JSON_PROPERTY_TOPICS = "topics";

    @Nullable
    @JsonProperty(JSON_PROPERTY_TOPICS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid TopicObject> topics;

    /**
     * @return the topics property value
     */
    public List<@Valid TopicObject> getTopics() {
        return topics;
    }

    /**
     * Set the topics property value
     *
     * @param topics property value to set
     */
    public void setTopics(List<@Valid TopicObject> topics) {
        this.topics = topics;
    }

    /**
     * Set topics in a chainable fashion.
     *
     * @return The same instance of TopicsResponse for chaining.
     */
    public TopicsResponse topics(List<@Valid TopicObject> topics) {
        this.topics = topics;
        return this;
    }
    /**
     * Add an item to the topics property in a chainable fashion.
     *
     * @return The same instance of TopicsResponse for chaining.
     */
    public TopicsResponse addTopicsItem(TopicObject topicsItem) {
        if (topics == null) {
            topics = new ArrayList<>();
        }
        topics.add(topicsItem);
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
        var topicsResponse = (TopicsResponse) o;
        return Objects.equals(topics, topicsResponse.topics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topics);
    }

    @Override
    public String toString() {
        return "TopicsResponse("
            + "topics: " + getTopics()
            + ")";
    }

}