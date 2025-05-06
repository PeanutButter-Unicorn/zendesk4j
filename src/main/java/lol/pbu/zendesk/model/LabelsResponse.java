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
 * LabelsResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(LabelsResponse.JSON_PROPERTY_LABELS)
public class LabelsResponse {

    public static final String JSON_PROPERTY_LABELS = "labels";

    @Nullable
    @JsonProperty(JSON_PROPERTY_LABELS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid LabelObject> labels;

    /**
     * @return the labels property value
     */
    public List<@Valid LabelObject> getLabels() {
        return labels;
    }

    /**
     * Set the labels property value
     *
     * @param labels property value to set
     */
    public void setLabels(List<@Valid LabelObject> labels) {
        this.labels = labels;
    }

    /**
     * Set labels in a chainable fashion.
     *
     * @return The same instance of LabelsResponse for chaining.
     */
    public LabelsResponse labels(List<@Valid LabelObject> labels) {
        this.labels = labels;
        return this;
    }
    /**
     * Add an item to the labels property in a chainable fashion.
     *
     * @return The same instance of LabelsResponse for chaining.
     */
    public LabelsResponse addLabelsItem(LabelObject labelsItem) {
        if (labels == null) {
            labels = new ArrayList<>();
        }
        labels.add(labelsItem);
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
        var labelsResponse = (LabelsResponse) o;
        return Objects.equals(labels, labelsResponse.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labels);
    }

    @Override
    public String toString() {
        return "LabelsResponse("
            + "labels: " + getLabels()
            + ")";
    }

}