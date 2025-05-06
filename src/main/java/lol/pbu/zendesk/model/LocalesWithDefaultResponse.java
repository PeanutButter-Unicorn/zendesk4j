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
 * LocalesWithDefaultResponse
 */
@Serdeable
@JsonPropertyOrder({
    LocalesWithDefaultResponse.JSON_PROPERTY_DEFAULT_LOCALE,
    LocalesWithDefaultResponse.JSON_PROPERTY_LOCALES,
})
public class LocalesWithDefaultResponse {

    public static final String JSON_PROPERTY_DEFAULT_LOCALE = "default_locale";
    public static final String JSON_PROPERTY_LOCALES = "locales";

    @Nullable
    @JsonProperty(JSON_PROPERTY_DEFAULT_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String defaultLocale;

    @Nullable
    @JsonProperty(JSON_PROPERTY_LOCALES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> locales;

    /**
     * @return the defaultLocale property value
     */
    public String getDefaultLocale() {
        return defaultLocale;
    }

    /**
     * Set the defaultLocale property value
     *
     * @param defaultLocale property value to set
     */
    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    /**
     * Set defaultLocale in a chainable fashion.
     *
     * @return The same instance of LocalesWithDefaultResponse for chaining.
     */
    public LocalesWithDefaultResponse defaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
        return this;
    }

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
     * @return The same instance of LocalesWithDefaultResponse for chaining.
     */
    public LocalesWithDefaultResponse locales(List<@NotNull String> locales) {
        this.locales = locales;
        return this;
    }
    /**
     * Add an item to the locales property in a chainable fashion.
     *
     * @return The same instance of LocalesWithDefaultResponse for chaining.
     */
    public LocalesWithDefaultResponse addLocalesItem(String localesItem) {
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
        var localesWithDefaultResponse = (LocalesWithDefaultResponse) o;
        return Objects.equals(defaultLocale, localesWithDefaultResponse.defaultLocale)
            && Objects.equals(locales, localesWithDefaultResponse.locales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultLocale, locales);
    }

    @Override
    public String toString() {
        return "LocalesWithDefaultResponse("
            + "defaultLocale: " + getDefaultLocale() + ", "
            + "locales: " + getLocales()
            + ")";
    }

}