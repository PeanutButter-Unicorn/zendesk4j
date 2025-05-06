package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * HelpCenterLocalesResponse
 */
@Serdeable
@JsonPropertyOrder(HelpCenterLocalesResponse.JSON_PROPERTY_LOCALES)
public class HelpCenterLocalesResponse {

    public static final String JSON_PROPERTY_LOCALES = "locales";

    @Nullable
    @JsonProperty(JSON_PROPERTY_LOCALES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> locales;

    /**
     * @return the locales property value
     */
    public List<@NotNull String> getLocales() {
        return locales;
    }

    /**
     * Set the locales property value
     *
     * @param locales property value to set
     */
    public void setLocales(List<@NotNull String> locales) {
        this.locales = locales;
    }

    /**
     * Set locales in a chainable fashion.
     *
     * @return The same instance of HelpCenterLocalesResponse for chaining.
     */
    public HelpCenterLocalesResponse locales(List<@NotNull String> locales) {
        this.locales = locales;
        return this;
    }
    /**
     * Add an item to the locales property in a chainable fashion.
     *
     * @return The same instance of HelpCenterLocalesResponse for chaining.
     */
    public HelpCenterLocalesResponse addLocalesItem(String localesItem) {
        if (locales == null) {
            locales = new ArrayList<>();
        }
        locales.add(localesItem);
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
        var helpCenterLocalesResponse = (HelpCenterLocalesResponse) o;
        return Objects.equals(locales, helpCenterLocalesResponse.locales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locales);
    }

    @Override
    public String toString() {
        return "HelpCenterLocalesResponse("
            + "locales: " + getLocales()
            + ")";
    }

}