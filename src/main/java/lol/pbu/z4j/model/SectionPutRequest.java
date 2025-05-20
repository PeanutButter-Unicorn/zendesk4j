package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * SectionPutRequest
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(SectionPutRequest.JSON_PROPERTY_SECTION)
public class SectionPutRequest {

    public static final String JSON_PROPERTY_SECTION = "section";

    @NotNull
    @Valid
    @JsonProperty(JSON_PROPERTY_SECTION)
    private SectionPutRequestSection section;

    public SectionPutRequest(SectionPutRequestSection section) {
        this.section = section;
    }

    /**
     * @return the section property value
     */
    public SectionPutRequestSection getSection() {
        return section;
    }

    /**
     * Set the section property value
     *
     * @param section property value to set
     */
    public void setSection(SectionPutRequestSection section) {
        this.section = section;
    }

    /**
     * Set section in a chainable fashion.
     *
     * @return The same instance of SectionPutRequest for chaining.
     */
    public SectionPutRequest section(SectionPutRequestSection section) {
        this.section = section;
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
        var sectionPutRequest = (SectionPutRequest) o;
        return Objects.equals(section, sectionPutRequest.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section);
    }

    @Override
    public String toString() {
        return "SectionPutRequest("
            + "section: " + getSection()
            + ")";
    }

}