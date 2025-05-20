package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * TranslationResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(TranslationResponse.JSON_PROPERTY_TRANSLATION)
public class TranslationResponse {

    public static final String JSON_PROPERTY_TRANSLATION = "translation";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_TRANSLATION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private TranslationObject translation;

    /**
     * @return the translation property value
     */
    public TranslationObject getTranslation() {
        return translation;
    }

    /**
     * Set the translation property value
     *
     * @param translation property value to set
     */
    public void setTranslation(TranslationObject translation) {
        this.translation = translation;
    }

    /**
     * Set translation in a chainable fashion.
     *
     * @return The same instance of TranslationResponse for chaining.
     */
    public TranslationResponse translation(TranslationObject translation) {
        this.translation = translation;
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
        var translationResponse = (TranslationResponse) o;
        return Objects.equals(translation, translationResponse.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(translation);
    }

    @Override
    public String toString() {
        return "TranslationResponse("
            + "translation: " + getTranslation()
            + ")";
    }

}