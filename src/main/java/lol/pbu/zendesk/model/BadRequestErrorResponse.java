package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * BadRequestErrorResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(BadRequestErrorResponse.JSON_PROPERTY_ERRORS)
public class BadRequestErrorResponse {

    public static final String JSON_PROPERTY_ERRORS = "errors";

    @Nullable
    @JsonProperty(JSON_PROPERTY_ERRORS)
    @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
    private Map<String, Object> errors;

    /**
     * @return the errors property value
     */
    public Map<String, Object> getErrors() {
        return errors;
    }

    /**
     * Set the errors property value
     *
     * @param errors property value to set
     */
    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }

    /**
     * Set errors in a chainable fashion.
     *
     * @return The same instance of BadRequestErrorResponse for chaining.
     */
    public BadRequestErrorResponse errors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }

    /**
     * Set the value for the key for the errors map property in a chainable fashion.
     *
     * @return The same instance of BadRequestErrorResponse for chaining.
     */
    public BadRequestErrorResponse putErrorsItem(String key, Object errorsItem) {
        if (errors == null) {
            errors = new HashMap<>();
        }
        errors.put(key, errorsItem);
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
        var badRequestErrorResponse = (BadRequestErrorResponse) o;
        return Objects.equals(errors, badRequestErrorResponse.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        return "BadRequestErrorResponse("
            + "errors: " + getErrors()
            + ")";
    }

}