package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * LabelResponse
 */
@Serdeable
@JsonPropertyOrder(LabelResponse.JSON_PROPERTY_LABEL)
public class LabelResponse {

    public static final String JSON_PROPERTY_LABEL = "label";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_LABEL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private LabelObject label;

    /**
     * @return the label property value
     */
    public LabelObject getLabel() {
        return label;
    }

    /**
     * Set the label property value
     *
     * @param label property value to set
     */
    public void setLabel(LabelObject label) {
        this.label = label;
    }

    /**
     * Set label in a chainable fashion.
     *
     * @return The same instance of LabelResponse for chaining.
     */
    public LabelResponse label(LabelObject label) {
        this.label = label;
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
        var labelResponse = (LabelResponse) o;
        return Objects.equals(label, labelResponse.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "LabelResponse("
            + "label: " + getLabel()
            + ")";
    }

}