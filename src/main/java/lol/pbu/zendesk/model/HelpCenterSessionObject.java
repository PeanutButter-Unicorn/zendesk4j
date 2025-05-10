package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Objects;

/**
 * HelpCenterSessionObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(HelpCenterSessionObject.JSON_PROPERTY_CSRF_TOKEN)
public class HelpCenterSessionObject {

    public static final String JSON_PROPERTY_CSRF_TOKEN = "csrf_token";

    @Nullable
    @JsonProperty(JSON_PROPERTY_CSRF_TOKEN)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String csrfToken;

    /**
     * @return the csrfToken property value
     */
    public String getCsrfToken() {
        return csrfToken;
    }

    /**
     * Set the csrfToken property value
     *
     * @param csrfToken property value to set
     */
    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }

    /**
     * Set csrfToken in a chainable fashion.
     *
     * @return The same instance of HelpCenterSessionObject for chaining.
     */
    public HelpCenterSessionObject csrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
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
        var helpCenterSessionObject = (HelpCenterSessionObject) o;
        return Objects.equals(csrfToken, helpCenterSessionObject.csrfToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csrfToken);
    }

    @Override
    public String toString() {
        return "HelpCenterSessionObject("
            + "csrfToken: " + getCsrfToken()
            + ")";
    }

}