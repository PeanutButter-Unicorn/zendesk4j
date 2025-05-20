package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * CommentObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    CommentObject.JSON_PROPERTY_BODY,
    CommentObject.JSON_PROPERTY_LOCALE,
    CommentObject.JSON_PROPERTY_AUTHOR_ID,
    CommentObject.JSON_PROPERTY_CREATED_AT,
    CommentObject.JSON_PROPERTY_HTML_URL,
    CommentObject.JSON_PROPERTY_ID,
    CommentObject.JSON_PROPERTY_NON_AUTHOR_EDITOR_ID,
    CommentObject.JSON_PROPERTY_NON_AUTHOR_UPDATED_AT,
    CommentObject.JSON_PROPERTY_SOURCE_ID,
    CommentObject.JSON_PROPERTY_SOURCE_TYPE,
    CommentObject.JSON_PROPERTY_UPDATED_AT,
    CommentObject.JSON_PROPERTY_URL,
    CommentObject.JSON_PROPERTY_VOTE_COUNT,
    CommentObject.JSON_PROPERTY_VOTE_SUM,
})
public class CommentObject {

    public static final String JSON_PROPERTY_BODY = "body";
    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_AUTHOR_ID = "author_id";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_NON_AUTHOR_EDITOR_ID = "non_author_editor_id";
    public static final String JSON_PROPERTY_NON_AUTHOR_UPDATED_AT = "non_author_updated_at";
    public static final String JSON_PROPERTY_SOURCE_ID = "source_id";
    public static final String JSON_PROPERTY_SOURCE_TYPE = "source_type";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";
    public static final String JSON_PROPERTY_VOTE_COUNT = "vote_count";
    public static final String JSON_PROPERTY_VOTE_SUM = "vote_sum";

    /**
     * The comment made by the author. See <a href="#user-content">User content</a>
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_BODY)
    private String body;

    /**
     * The locale in which this comment was made
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_LOCALE)
    private String locale;

    /**
     * The id of the author of this comment. Writable on create by Help Center managers. See <a href="#create-comment">Create Comment</a>
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_AUTHOR_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer authorId;

    /**
     * The time the comment was created. Writable on create by Help Center managers. See <a href="#create-comment">Create Comment</a>
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * The url at which the comment is presented in Help Center
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Automatically assigned when the comment is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * The user id of whoever performed the most recent (if any) non-author edit. A non-author edit consists of an edit make by a user other than the author that creates or updates the &#x60;body&#x60; or &#x60;author_id&#x60;. Note that only edits made after May 17, 2021 will be reflected in this field. If no non-author edits have occured since May 17, 2021, then this field will be &#x60;null&#x60;.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_NON_AUTHOR_EDITOR_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer nonAuthorEditorId;

    /**
     * When the comment was last edited by a non-author user
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_NON_AUTHOR_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime nonAuthorUpdatedAt;

    /**
     * The id of the item on which this comment was made
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer sourceId;

    /**
     * The type of the item on which this comment was made. Currently only supports &#39;Article&#39;
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String sourceType;

    /**
     * The time at which the comment was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The API url of this comment
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The total number of upvotes and downvotes
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_VOTE_COUNT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer voteCount;

    /**
     * The sum of upvotes (+1) and downvotes (-1), which may be positive or negative
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_VOTE_SUM)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer voteSum;

    public CommentObject(String body, String locale) {
        this.body = body;
        this.locale = locale;
    }

    /**
     * The comment made by the author. See <a href="#user-content">User content</a>
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
     * @return The same instance of CommentObject for chaining.
     */
    public CommentObject body(String body) {
        this.body = body;
        return this;
    }

    /**
     * The locale in which this comment was made
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
     * @return The same instance of CommentObject for chaining.
     */
    public CommentObject locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * The id of the author of this comment. Writable on create by Help Center managers. See <a href="#create-comment">Create Comment</a>
     *
     * @return the authorId property value
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * Set the authorId property value
     *
     * @param authorId property value to set
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * Set authorId in a chainable fashion.
     *
     * @return The same instance of CommentObject for chaining.
     */
    public CommentObject authorId(Integer authorId) {
        this.authorId = authorId;
        return this;
    }

    /**
     * The time the comment was created. Writable on create by Help Center managers. See <a href="#create-comment">Create Comment</a>
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
     * Set createdAt in a chainable fashion.
     *
     * @return The same instance of CommentObject for chaining.
     */
    public CommentObject createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The url at which the comment is presented in Help Center
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
     * Automatically assigned when the comment is created
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
     * The user id of whoever performed the most recent (if any) non-author edit. A non-author edit consists of an edit make by a user other than the author that creates or updates the &#x60;body&#x60; or &#x60;author_id&#x60;. Note that only edits made after May 17, 2021 will be reflected in this field. If no non-author edits have occured since May 17, 2021, then this field will be &#x60;null&#x60;.
     *
     * @return the nonAuthorEditorId property value
     */
    public Integer getNonAuthorEditorId() {
        return nonAuthorEditorId;
    }

    /**
     * Set the nonAuthorEditorId property value
     *
     * @param nonAuthorEditorId property value to set
     */
    public void setNonAuthorEditorId(Integer nonAuthorEditorId) {
        this.nonAuthorEditorId = nonAuthorEditorId;
    }

    /**
     * When the comment was last edited by a non-author user
     *
     * @return the nonAuthorUpdatedAt property value
     */
    public ZonedDateTime getNonAuthorUpdatedAt() {
        return nonAuthorUpdatedAt;
    }

    /**
     * Set the nonAuthorUpdatedAt property value
     *
     * @param nonAuthorUpdatedAt property value to set
     */
    public void setNonAuthorUpdatedAt(ZonedDateTime nonAuthorUpdatedAt) {
        this.nonAuthorUpdatedAt = nonAuthorUpdatedAt;
    }

    /**
     * The id of the item on which this comment was made
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
     * The type of the item on which this comment was made. Currently only supports &#39;Article&#39;
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
     * The time at which the comment was last updated
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
     * The API url of this comment
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
     * The total number of upvotes and downvotes
     *
     * @return the voteCount property value
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * Set the voteCount property value
     *
     * @param voteCount property value to set
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     * The sum of upvotes (+1) and downvotes (-1), which may be positive or negative
     *
     * @return the voteSum property value
     */
    public Integer getVoteSum() {
        return voteSum;
    }

    /**
     * Set the voteSum property value
     *
     * @param voteSum property value to set
     */
    public void setVoteSum(Integer voteSum) {
        this.voteSum = voteSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var commentObject = (CommentObject) o;
        return Objects.equals(body, commentObject.body)
            && Objects.equals(locale, commentObject.locale)
            && Objects.equals(authorId, commentObject.authorId)
            && Objects.equals(createdAt, commentObject.createdAt)
            && Objects.equals(htmlUrl, commentObject.htmlUrl)
            && Objects.equals(id, commentObject.id)
            && Objects.equals(nonAuthorEditorId, commentObject.nonAuthorEditorId)
            && Objects.equals(nonAuthorUpdatedAt, commentObject.nonAuthorUpdatedAt)
            && Objects.equals(sourceId, commentObject.sourceId)
            && Objects.equals(sourceType, commentObject.sourceType)
            && Objects.equals(updatedAt, commentObject.updatedAt)
            && Objects.equals(url, commentObject.url)
            && Objects.equals(voteCount, commentObject.voteCount)
            && Objects.equals(voteSum, commentObject.voteSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, locale, authorId, createdAt, htmlUrl, id, nonAuthorEditorId, nonAuthorUpdatedAt, sourceId, sourceType, updatedAt, url, voteCount, voteSum);
    }

    @Override
    public String toString() {
        return "CommentObject("
            + "body: " + getBody() + ", "
            + "locale: " + getLocale() + ", "
            + "authorId: " + getAuthorId() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "id: " + getId() + ", "
            + "nonAuthorEditorId: " + getNonAuthorEditorId() + ", "
            + "nonAuthorUpdatedAt: " + getNonAuthorUpdatedAt() + ", "
            + "sourceId: " + getSourceId() + ", "
            + "sourceType: " + getSourceType() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl() + ", "
            + "voteCount: " + getVoteCount() + ", "
            + "voteSum: " + getVoteSum()
            + ")";
    }

}