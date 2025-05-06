package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * HelpCenterSessionResponse
 */
@Serdeable
@JsonPropertyOrder(HelpCenterSessionResponse.JSON_PROPERTY_CURRENT_SESSION)
public class HelpCenterSessionResponse {

    public static final String JSON_PROPERTY_CURRENT_SESSION = "current_session";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_CURRENT_SESSION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private HelpCenterSessionObject currentSession;

    /**
     * @return the currentSession property value
     */
    public HelpCenterSessionObject getCurrentSession() {
        return currentSession;
    }

    /**
     * Set the currentSession property value
     *
     * @param currentSession property value to set
     */
    public void setCurrentSession(HelpCenterSessionObject currentSession) {
        this.currentSession = currentSession;
    }

    /**
     * Set currentSession in a chainable fashion.
     *
     * @return The same instance of HelpCenterSessionResponse for chaining.
     */
    public HelpCenterSessionResponse currentSession(HelpCenterSessionObject currentSession) {
        this.currentSession = currentSession;
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
        var helpCenterSessionResponse = (HelpCenterSessionResponse) o;
        return Objects.equals(currentSession, helpCenterSessionResponse.currentSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentSession);
    }

    @Override
    public String toString() {
        return "HelpCenterSessionResponse("
            + "currentSession: " + getCurrentSession()
            + ")";
    }

}