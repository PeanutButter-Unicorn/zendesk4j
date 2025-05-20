package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Objects;

/**
 * ContentSubscriptionObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    ContentSubscriptionObject.JSON_PROPERTY_LOCALE,
    ContentSubscriptionObject.JSON_PROPERTY_CONTENT_ID,
    ContentSubscriptionObject.JSON_PROPERTY_CONTENT_TYPE,
    ContentSubscriptionObject.JSON_PROPERTY_CREATED_AT,
    ContentSubscriptionObject.JSON_PROPERTY_ID,
    ContentSubscriptionObject.JSON_PROPERTY_INCLUDE_COMMENTS,
    ContentSubscriptionObject.JSON_PROPERTY_SOURCE_LOCALE,
    ContentSubscriptionObject.JSON_PROPERTY_UPDATED_AT,
    ContentSubscriptionObject.JSON_PROPERTY_URL,
    ContentSubscriptionObject.JSON_PROPERTY_USER_ID,
})
public class ContentSubscriptionObject {

    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_CONTENT_ID = "content_id";
    public static final String JSON_PROPERTY_CONTENT_TYPE = "content_type";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_INCLUDE_COMMENTS = "include_comments";
    public static final String JSON_PROPERTY_SOURCE_LOCALE = "source_locale";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";
    public static final String JSON_PROPERTY_USER_ID = "user_id";

    /**
     * The locale of the subscribed item
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String locale;

    /**
     * The id of the subscribed item
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer contentId;

    /**
     * The type of the subscribed item
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String contentType;

    /**
     * The time at which the subscription was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * Automatically assigned when the subscription is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * Subscribe also to article comments / post comments. Only for section / topic subscriptions.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_INCLUDE_COMMENTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean includeComments;

    /**
     * Used only for <a href="#create-section-subscription">Create Section Subscription</a> and <a href="#create-article-subscription">Create Article Subscription</a>, where it&#39;s mandatory. Selects the locale of the content to be subscribed
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String sourceLocale;

    /**
     * The time at which the subscription was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The API url of the subscription
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The id of the user who has this subscription
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer userId;

    public ContentSubscriptionObject() {
    }

    /**
     * The locale of the subscribed item
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
     * The id of the subscribed item
     *
     * @return the contentId property value
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * Set the contentId property value
     *
     * @param contentId property value to set
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * The type of the subscribed item
     *
     * @return the contentType property value
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Set the contentType property value
     *
     * @param contentType property value to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * The time at which the subscription was created
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
     * Automatically assigned when the subscription is created
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
     * Subscribe also to article comments / post comments. Only for section / topic subscriptions.
     *
     * @return the includeComments property value
     */
    public Boolean getIncludeComments() {
        return includeComments;
    }

    /**
     * Set the includeComments property value
     *
     * @param includeComments property value to set
     */
    public void setIncludeComments(Boolean includeComments) {
        this.includeComments = includeComments;
    }

    /**
     * Used only for <a href="#create-section-subscription">Create Section Subscription</a> and <a href="#create-article-subscription">Create Article Subscription</a>, where it&#39;s mandatory. Selects the locale of the content to be subscribed
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
     * Set sourceLocale in a chainable fashion.
     *
     * @return The same instance of ContentSubscriptionObject for chaining.
     */
    public ContentSubscriptionObject sourceLocale(String sourceLocale) {
        this.sourceLocale = sourceLocale;
        return this;
    }

    /**
     * The time at which the subscription was last updated
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
     * The API url of the subscription
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

    /**
     * The id of the user who has this subscription
     *
     * @return the userId property value
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Set the userId property value
     *
     * @param userId property value to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var contentSubscriptionObject = (ContentSubscriptionObject) o;
        return Objects.equals(locale, contentSubscriptionObject.locale)
            && Objects.equals(contentId, contentSubscriptionObject.contentId)
            && Objects.equals(contentType, contentSubscriptionObject.contentType)
            && Objects.equals(createdAt, contentSubscriptionObject.createdAt)
            && Objects.equals(id, contentSubscriptionObject.id)
            && Objects.equals(includeComments, contentSubscriptionObject.includeComments)
            && Objects.equals(sourceLocale, contentSubscriptionObject.sourceLocale)
            && Objects.equals(updatedAt, contentSubscriptionObject.updatedAt)
            && Objects.equals(url, contentSubscriptionObject.url)
            && Objects.equals(userId, contentSubscriptionObject.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, contentId, contentType, createdAt, id, includeComments, sourceLocale, updatedAt, url, userId);
    }

    @Override
    public String toString() {
        return "ContentSubscriptionObject("
            + "locale: " + getLocale() + ", "
            + "contentId: " + getContentId() + ", "
            + "contentType: " + getContentType() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "id: " + getId() + ", "
            + "includeComments: " + getIncludeComments() + ", "
            + "sourceLocale: " + getSourceLocale() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl() + ", "
            + "userId: " + getUserId()
            + ")";
    }

}