package lol.pbu.z4j.model;

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
 * TranslationsResponse
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(TranslationsResponse.JSON_PROPERTY_TRANSLATIONS)
public class TranslationsResponse {

    public static final String JSON_PROPERTY_TRANSLATIONS = "translations";

    @Nullable
    @JsonProperty(JSON_PROPERTY_TRANSLATIONS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid TranslationObject> translations;

    /**
     * @return the translations property value
     */
    public List<@Valid TranslationObject> getTranslations() {
        return translations;
    }

    /**
     * Set the translations property value
     *
     * @param translations property value to set
     */
    public void setTranslations(List<@Valid TranslationObject> translations) {
        this.translations = translations;
    }

    /**
     * Set translations in a chainable fashion.
     *
     * @return The same instance of TranslationsResponse for chaining.
     */
    public TranslationsResponse translations(List<@Valid TranslationObject> translations) {
        this.translations = translations;
        return this;
    }
    /**
     * Add an item to the translations property in a chainable fashion.
     *
     * @return The same instance of TranslationsResponse for chaining.
     */
    public TranslationsResponse addTranslationsItem(TranslationObject translationsItem) {
        if (translations == null) {
            translations = new ArrayList<>();
        }
        translations.add(translationsItem);
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
        var translationsResponse = (TranslationsResponse) o;
        return Objects.equals(translations, translationsResponse.translations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(translations);
    }

    @Override
    public String toString() {
        return "TranslationsResponse("
            + "translations: " + getTranslations()
            + ")";
    }

}