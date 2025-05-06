package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * CategoryObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    CategoryObject.JSON_PROPERTY_ID,
    CategoryObject.JSON_PROPERTY_LOCALE,
    CategoryObject.JSON_PROPERTY_NAME,
    CategoryObject.JSON_PROPERTY_CREATED_AT,
    CategoryObject.JSON_PROPERTY_DESCRIPTION,
    CategoryObject.JSON_PROPERTY_HTML_URL,
    CategoryObject.JSON_PROPERTY_OUTDATED,
    CategoryObject.JSON_PROPERTY_POSITION,
    CategoryObject.JSON_PROPERTY_SOURCE_LOCALE,
    CategoryObject.JSON_PROPERTY_UPDATED_AT,
    CategoryObject.JSON_PROPERTY_URL,
})
public class CategoryObject {

    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_OUTDATED = "outdated";
    public static final String JSON_PROPERTY_POSITION = "position";
    public static final String JSON_PROPERTY_SOURCE_LOCALE = "source_locale";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";

    /**
     * Automatically assigned when creating categories
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * The locale where the category is displayed
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_LOCALE)
    private String locale;

    /**
     * The name of the category
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_NAME)
    private String name;

    /**
     * The time at which the category was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime createdAt;

    /**
     * The description of the category
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String description;

    /**
     * The url of this category in Help Center
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Whether the category is out of date
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_OUTDATED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean outdated;

    /**
     * The position of this category relative to other categories
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_POSITION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer position;

    /**
     * The source (default) locale of the category
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String sourceLocale;

    /**
     * The time at which the category was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime updatedAt;

    /**
     * The API url of this category
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    public CategoryObject(String locale, String name) {
        this.locale = locale;
        this.name = name;
    }

    /**
     * Automatically assigned when creating categories
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
     * The locale where the category is displayed
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
     * @return The same instance of CategoryObject for chaining.
     */
    public CategoryObject locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * The name of the category
     *
     * @return the name property value
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property value
     *
     * @param name property value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set name in a chainable fashion.
     *
     * @return The same instance of CategoryObject for chaining.
     */
    public CategoryObject name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The time at which the category was created
     *
     * @return the createdAt property value
     */
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the createdAt property value
     *
     * @param createdAt property value to set
     */
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The description of the category
     *
     * @return the description property value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description property value
     *
     * @param description property value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set description in a chainable fashion.
     *
     * @return The same instance of CategoryObject for chaining.
     */
    public CategoryObject description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The url of this category in Help Center
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
     * Whether the category is out of date
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
     * The position of this category relative to other categories
     *
     * @return the position property value
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Set the position property value
     *
     * @param position property value to set
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Set position in a chainable fashion.
     *
     * @return The same instance of CategoryObject for chaining.
     */
    public CategoryObject position(Integer position) {
        this.position = position;
        return this;
    }

    /**
     * The source (default) locale of the category
     *
     * @return the sourceLocale property value
     */
    public String getSourceLocale() {
        return sourceLocale;
    }

    /**
     * Set the sourceLocale property value
     *
     * @param sourceLocale property value to set
     */
    public void setSourceLocale(String sourceLocale) {
        this.sourceLocale = sourceLocale;
    }

    /**
     * The time at which the category was last updated
     *
     * @return the updatedAt property value
     */
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt property value
     *
     * @param updatedAt property value to set
     */
    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * The API url of this category
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
        var categoryObject = (CategoryObject) o;
        return Objects.equals(id, categoryObject.id)
            && Objects.equals(locale, categoryObject.locale)
            && Objects.equals(name, categoryObject.name)
            && Objects.equals(createdAt, categoryObject.createdAt)
            && Objects.equals(description, categoryObject.description)
            && Objects.equals(htmlUrl, categoryObject.htmlUrl)
            && Objects.equals(outdated, categoryObject.outdated)
            && Objects.equals(position, categoryObject.position)
            && Objects.equals(sourceLocale, categoryObject.sourceLocale)
            && Objects.equals(updatedAt, categoryObject.updatedAt)
            && Objects.equals(url, categoryObject.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locale, name, createdAt, description, htmlUrl, outdated, position, sourceLocale, updatedAt, url);
    }

    @Override
    public String toString() {
        return "CategoryObject("
            + "id: " + getId() + ", "
            + "locale: " + getLocale() + ", "
            + "name: " + getName() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "description: " + getDescription() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "outdated: " + getOutdated() + ", "
            + "position: " + getPosition() + ", "
            + "sourceLocale: " + getSourceLocale() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl()
            + ")";
    }

}