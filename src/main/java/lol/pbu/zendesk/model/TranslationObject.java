package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * TranslationObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    TranslationObject.JSON_PROPERTY_LOCALE,
    TranslationObject.JSON_PROPERTY_TITLE,
    TranslationObject.JSON_PROPERTY_BODY,
    TranslationObject.JSON_PROPERTY_CREATED_AT,
    TranslationObject.JSON_PROPERTY_CREATED_BY_ID,
    TranslationObject.JSON_PROPERTY_DRAFT,
    TranslationObject.JSON_PROPERTY_HTML_URL,
    TranslationObject.JSON_PROPERTY_ID,
    TranslationObject.JSON_PROPERTY_OUTDATED,
    TranslationObject.JSON_PROPERTY_SOURCE_ID,
    TranslationObject.JSON_PROPERTY_SOURCE_TYPE,
    TranslationObject.JSON_PROPERTY_UPDATED_AT,
    TranslationObject.JSON_PROPERTY_UPDATED_BY_ID,
    TranslationObject.JSON_PROPERTY_URL,
})
public class TranslationObject {

    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_TITLE = "title";
    public static final String JSON_PROPERTY_BODY = "body";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_CREATED_BY_ID = "created_by_id";
    public static final String JSON_PROPERTY_DRAFT = "draft";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_OUTDATED = "outdated";
    public static final String JSON_PROPERTY_SOURCE_ID = "source_id";
    public static final String JSON_PROPERTY_SOURCE_TYPE = "source_type";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_UPDATED_BY_ID = "updated_by_id";
    public static final String JSON_PROPERTY_URL = "url";

    /**
     * The locale of the translation
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_LOCALE)
    private String locale;

    /**
     * The title of the translation
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_TITLE)
    private String title;

    /**
     * HTML body of the translation. Empty by default
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_BODY)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String body;

    /**
     * The time at which the translation was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * The id of the user who created the translation
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_BY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer createdById;

    /**
     * True if the translation is a draft; false otherwise. False by default
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DRAFT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean draft;

    /**
     * The url of the translation in Help Center
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Automatically assigned when a translation is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * True if the translation is outdated; false otherwise. False by default
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_OUTDATED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean outdated;

    /**
     * The id of the item that has this translation
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer sourceId;

    /**
     * The type of the item that has this translation. Can be \&quot;article\&quot;, \&quot;section\&quot;, or \&quot;category\&quot;.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String sourceType;

    /**
     * The time at which the translation was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The id of the user who last updated the translation
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_BY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer updatedById;

    /**
     * The API url of the translation
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    public TranslationObject(String locale, String title) {
        this.locale = locale;
        this.title = title;
    }

    /**
     * The locale of the translation
     *
     * @return the locale property value
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Set the locale property value
     *
     * @param locale property value to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Set locale in a chainable fashion.
     *
     * @return The same instance of TranslationObject for chaining.
     */
    public TranslationObject locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * The title of the translation
     *
     * @return the title property value
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title property value
     *
     * @param title property value to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set title in a chainable fashion.
     *
     * @return The same instance of TranslationObject for chaining.
     */
    public TranslationObject title(String title) {
        this.title = title;
        return this;
    }

    /**
     * HTML body of the translation. Empty by default
     *
     * @return the body property value
     */
    public String getBody() {
        return body;
    }

    /**
     * Set the body property value
     *
     * @param body property value to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Set body in a chainable fashion.
     *
     * @return The same instance of TranslationObject for chaining.
     */
    public TranslationObject body(String body) {
        this.body = body;
        return this;
    }

    /**
     * The time at which the translation was created
     *
     * @return the createdAt property value
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the createdAt property value
     *
     * @param createdAt property value to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The id of the user who created the translation
     *
     * @return the createdById property value
     */
    public Integer getCreatedById() {
        return createdById;
    }

    /**
     * Set the createdById property value
     *
     * @param createdById property value to set
     */
    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    /**
     * True if the translation is a draft; false otherwise. False by default
     *
     * @return the draft property value
     */
    public Boolean getDraft() {
        return draft;
    }

    /**
     * Set the draft property value
     *
     * @param draft property value to set
     */
    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    /**
     * Set draft in a chainable fashion.
     *
     * @return The same instance of TranslationObject for chaining.
     */
    public TranslationObject draft(Boolean draft) {
        this.draft = draft;
        return this;
    }

    /**
     * The url of the translation in Help Center
     *
     * @return the htmlUrl property value
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Set the htmlUrl property value
     *
     * @param htmlUrl property value to set
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * Automatically assigned when a translation is created
     *
     * @return the id property value
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id property value
     *
     * @param id property value to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * True if the translation is outdated; false otherwise. False by default
     *
     * @return the outdated property value
     */
    public Boolean getOutdated() {
        return outdated;
    }

    /**
     * Set the outdated property value
     *
     * @param outdated property value to set
     */
    public void setOutdated(Boolean outdated) {
        this.outdated = outdated;
    }

    /**
     * Set outdated in a chainable fashion.
     *
     * @return The same instance of TranslationObject for chaining.
     */
    public TranslationObject outdated(Boolean outdated) {
        this.outdated = outdated;
        return this;
    }

    /**
     * The id of the item that has this translation
     *
     * @return the sourceId property value
     */
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     * Set the sourceId property value
     *
     * @param sourceId property value to set
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * The type of the item that has this translation. Can be \&quot;article\&quot;, \&quot;section\&quot;, or \&quot;category\&quot;.
     *
     * @return the sourceType property value
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Set the sourceType property value
     *
     * @param sourceType property value to set
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * The time at which the translation was last updated
     *
     * @return the updatedAt property value
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt property value
     *
     * @param updatedAt property value to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * The id of the user who last updated the translation
     *
     * @return the updatedById property value
     */
    public Integer getUpdatedById() {
        return updatedById;
    }

    /**
     * Set the updatedById property value
     *
     * @param updatedById property value to set
     */
    public void setUpdatedById(Integer updatedById) {
        this.updatedById = updatedById;
    }

    /**
     * The API url of the translation
     *
     * @return the url property value
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the url property value
     *
     * @param url property value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var translationObject = (TranslationObject) o;
        return Objects.equals(locale, translationObject.locale)
            && Objects.equals(title, translationObject.title)
            && Objects.equals(body, translationObject.body)
            && Objects.equals(createdAt, translationObject.createdAt)
            && Objects.equals(createdById, translationObject.createdById)
            && Objects.equals(draft, translationObject.draft)
            && Objects.equals(htmlUrl, translationObject.htmlUrl)
            && Objects.equals(id, translationObject.id)
            && Objects.equals(outdated, translationObject.outdated)
            && Objects.equals(sourceId, translationObject.sourceId)
            && Objects.equals(sourceType, translationObject.sourceType)
            && Objects.equals(updatedAt, translationObject.updatedAt)
            && Objects.equals(updatedById, translationObject.updatedById)
            && Objects.equals(url, translationObject.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, title, body, createdAt, createdById, draft, htmlUrl, id, outdated, sourceId, sourceType, updatedAt, updatedById, url);
    }

    @Override
    public String toString() {
        return "TranslationObject("
            + "locale: " + getLocale() + ", "
            + "title: " + getTitle() + ", "
            + "body: " + getBody() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "createdById: " + getCreatedById() + ", "
            + "draft: " + getDraft() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "id: " + getId() + ", "
            + "outdated: " + getOutdated() + ", "
            + "sourceId: " + getSourceId() + ", "
            + "sourceType: " + getSourceType() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "updatedById: " + getUpdatedById() + ", "
            + "url: " + getUrl()
            + ")";
    }

}