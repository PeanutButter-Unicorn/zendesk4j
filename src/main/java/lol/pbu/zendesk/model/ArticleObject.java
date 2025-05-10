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
 * ArticleObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    ArticleObject.JSON_PROPERTY_LOCALE,
    ArticleObject.JSON_PROPERTY_PERMISSION_GROUP_ID,
    ArticleObject.JSON_PROPERTY_TITLE,
    ArticleObject.JSON_PROPERTY_AUTHOR_ID,
    ArticleObject.JSON_PROPERTY_BODY,
    ArticleObject.JSON_PROPERTY_COMMENTS_DISABLED,
    ArticleObject.JSON_PROPERTY_CONTENT_TAG_IDS,
    ArticleObject.JSON_PROPERTY_CREATED_AT,
    ArticleObject.JSON_PROPERTY_DRAFT,
    ArticleObject.JSON_PROPERTY_EDITED_AT,
    ArticleObject.JSON_PROPERTY_HTML_URL,
    ArticleObject.JSON_PROPERTY_ID,
    ArticleObject.JSON_PROPERTY_LABEL_NAMES,
    ArticleObject.JSON_PROPERTY_OUTDATED,
    ArticleObject.JSON_PROPERTY_OUTDATED_LOCALES,
    ArticleObject.JSON_PROPERTY_POSITION,
    ArticleObject.JSON_PROPERTY_PROMOTED,
    ArticleObject.JSON_PROPERTY_SECTION_ID,
    ArticleObject.JSON_PROPERTY_SOURCE_LOCALE,
    ArticleObject.JSON_PROPERTY_UPDATED_AT,
    ArticleObject.JSON_PROPERTY_URL,
    ArticleObject.JSON_PROPERTY_USER_SEGMENT_ID,
    ArticleObject.JSON_PROPERTY_USER_SEGMENT_IDS,
    ArticleObject.JSON_PROPERTY_VOTE_COUNT,
    ArticleObject.JSON_PROPERTY_VOTE_SUM,
})
public class ArticleObject implements SearchObjectResultsInner {

    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_PERMISSION_GROUP_ID = "permission_group_id";
    public static final String JSON_PROPERTY_TITLE = "title";
    public static final String JSON_PROPERTY_AUTHOR_ID = "author_id";
    public static final String JSON_PROPERTY_BODY = "body";
    public static final String JSON_PROPERTY_COMMENTS_DISABLED = "comments_disabled";
    public static final String JSON_PROPERTY_CONTENT_TAG_IDS = "content_tag_ids";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_DRAFT = "draft";
    public static final String JSON_PROPERTY_EDITED_AT = "edited_at";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_LABEL_NAMES = "label_names";
    public static final String JSON_PROPERTY_OUTDATED = "outdated";
    public static final String JSON_PROPERTY_OUTDATED_LOCALES = "outdated_locales";
    public static final String JSON_PROPERTY_POSITION = "position";
    public static final String JSON_PROPERTY_PROMOTED = "promoted";
    public static final String JSON_PROPERTY_SECTION_ID = "section_id";
    public static final String JSON_PROPERTY_SOURCE_LOCALE = "source_locale";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";
    public static final String JSON_PROPERTY_USER_SEGMENT_ID = "user_segment_id";
    public static final String JSON_PROPERTY_USER_SEGMENT_IDS = "user_segment_ids";
    public static final String JSON_PROPERTY_VOTE_COUNT = "vote_count";
    public static final String JSON_PROPERTY_VOTE_SUM = "vote_sum";

    /**
     * The locale that the article is being displayed in
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_LOCALE)
    private String locale;

    /**
     * The id of the permission group which defines who can edit and publish this article
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_PERMISSION_GROUP_ID)
   private Long permissionGroupId;

    /**
     * The title of the article
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_TITLE)
    private String title;

    /**
     * The id of the user who wrote the article (set to the user who made the request on create by default)
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_AUTHOR_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
   private Long authorId;

    /**
     * HTML body of the article. Unsafe tags and attributes may be removed before display. For a list of safe tags and
     * attributes, see <a href="https://support.zendesk.com/hc/en-us/articles/115015895948">Allowing unsafe HTML
     * in Help Center articles</a> in Zendesk help
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_BODY)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String body;

    /**
     * True if comments are disabled; false otherwise
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_COMMENTS_DISABLED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean commentsDisabled;

    /**
     * The list of content tags attached to the article
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_TAG_IDS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> contentTagIds;

    /**
     * The time the article was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * True if the translation for the current locale is a draft; false otherwise. false by default. Can be set when
     * creating but not when updating. For updating, see Translations
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DRAFT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean draft;

    /**
     * The time the article was last edited in its displayed locale
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_EDITED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String editedAt;

    /**
     * The url of the article in Help Center
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Automatically assigned when the article is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
   private Long id;

    /**
     * An array of label names associated with this article. By default, no label names are used. Only available on
     * certain plans
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_LABEL_NAMES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> labelNames;

    /**
     * Deprecated. Always false because the source translation is always the most up-to-date translation
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_OUTDATED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean outdated;

    /**
     * Locales in which the article was marked as outdated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_OUTDATED_LOCALES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> outdatedLocales;

    /**
     * The position of this article in the article list. 0 by default
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_POSITION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer position;

    /**
     * True if this article is promoted; false otherwise. false by default
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_PROMOTED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean promoted;

    /**
     * The id of the section to which this article belongs
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SECTION_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
   private Long sectionId;

    /**
     * The source (default) locale of the article
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String sourceLocale;

    /**
     * The time the article was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The API url of the article
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The id of the user segment which defines who can see this article. Set to null to make it accessible to everyone.
     * Either user_segment_id or user_segment_ids must be specified
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_SEGMENT_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
   private Long userSegmentId;

    /**
     * List of user segment ids which define who can view this article. Set to an empty list to make it accessible to
     * everyone. For Enterprise plans only this may contain more than one user_segment_id. Either user_segment_id or
     * user_segment_ids must be specified
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_SEGMENT_IDS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> userSegmentIds;

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

    public ArticleObject(String locale, Long permissionGroupId, String title) {
        this.locale = locale;
        this.permissionGroupId = permissionGroupId;
        this.title = title;
    }

    /**
     * The locale that the article is being displayed in
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
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * The id of the permission group which defines who can edit and publish this article
     *
     * @return the permissionGroupId property value
     */
    public Long getPermissionGroupId() {
        return permissionGroupId;
    }

    /**
     * Set the permissionGroupId property value
     *
     * @param permissionGroupId property value to set
     */
    public void setPermissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    /**
     * Set permissionGroupId in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject permissionGroupId(Long permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
        return this;
    }

    /**
     * The title of the article
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
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject title(String title) {
        this.title = title;
        return this;
    }

    /**
     * The id of the user who wrote the article (set to the user who made the request on create by default)
     *
     * @return the authorId property value
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * Set the authorId property value
     *
     * @param authorId property value to set
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * Set authorId in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject authorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    /**
     * HTML body of the article. Unsafe tags and attributes may be removed before display. For a list of safe tags and
     * attributes, see <a href="https://support.zendesk.com/hc/en-us/articles/115015895948">Allowing unsafe HTML in
     * Help Center articles</a> in Zendesk help
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
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject body(String body) {
        this.body = body;
        return this;
    }

    /**
     * True if comments are disabled; false otherwise
     *
     * @return the commentsDisabled property value
     */
    public Boolean getCommentsDisabled() {
        return commentsDisabled;
    }

    /**
     * Set the commentsDisabled property value
     *
     * @param commentsDisabled property value to set
     */
    public void setCommentsDisabled(Boolean commentsDisabled) {
        this.commentsDisabled = commentsDisabled;
    }

    /**
     * Set commentsDisabled in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject commentsDisabled(Boolean commentsDisabled) {
        this.commentsDisabled = commentsDisabled;
        return this;
    }

    /**
     * The list of content tags attached to the article
     *
     * @return the contentTagIds property value
     */
    public List<@NotNull String> getContentTagIds() {
        return contentTagIds;
    }

    /**
     * Set the contentTagIds property value
     *
     * @param contentTagIds property value to set
     */
    public void setContentTagIds(List<@NotNull String> contentTagIds) {
        this.contentTagIds = contentTagIds;
    }

    /**
     * Set contentTagIds in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject contentTagIds(List<@NotNull String> contentTagIds) {
        this.contentTagIds = contentTagIds;
        return this;
    }
    /**
     * Add an item to the contentTagIds property in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject addContentTagIdsItem(String contentTagIdsItem) {
        if (contentTagIds == null) {
            contentTagIds = new ArrayList<>();
        }
        contentTagIds.add(contentTagIdsItem);
        return this;
    }

    /**
     * The time the article was created
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
     * True if the translation for the current locale is a draft; false otherwise. false by default. Can be set when
     * creating but not when updating. For updating, see Translations
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
     * The time the article was last edited in its displayed locale
     *
     * @return the editedAt property value
     */
    public String getEditedAt() {
        return editedAt;
    }

    /**
     * Set the editedAt property value
     *
     * @param editedAt property value to set
     */
    public void setEditedAt(String editedAt) {
        this.editedAt = editedAt;
    }

    /**
     * The url of the article in Help Center
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
     * Automatically assigned when the article is created
     *
     * @return the id property value
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id property value
     *
     * @param id property value to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * An array of label names associated with this article. By default no label names are used. Only available on
     * certain plans
     *
     * @return the labelNames property value
     */
    public List<@NotNull String> getLabelNames() {
        return labelNames;
    }

    /**
     * Set the labelNames property value
     *
     * @param labelNames property value to set
     */
    public void setLabelNames(List<@NotNull String> labelNames) {
        this.labelNames = labelNames;
    }

    /**
     * Set labelNames in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject labelNames(List<@NotNull String> labelNames) {
        this.labelNames = labelNames;
        return this;
    }
    /**
     * Add an item to the labelNames property in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject addLabelNamesItem(String labelNamesItem) {
        if (labelNames == null) {
            labelNames = new ArrayList<>();
        }
        labelNames.add(labelNamesItem);
        return this;
    }

    /**
     * Deprecated. Always false because the source translation is always the most up-to-date translation
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
     * Locales in which the article was marked as outdated
     *
     * @return the outdatedLocales property value
     */
    public List<@NotNull String> getOutdatedLocales() {
        return outdatedLocales;
    }

    /**
     * Set the outdatedLocales property value
     *
     * @param outdatedLocales property value to set
     */
    public void setOutdatedLocales(List<@NotNull String> outdatedLocales) {
        this.outdatedLocales = outdatedLocales;
    }

    /**
     * The position of this article in the article list. 0 by default
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
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject position(Integer position) {
        this.position = position;
        return this;
    }

    /**
     * True if this article is promoted; false otherwise. false by default
     *
     * @return the promoted property value
     */
    public Boolean getPromoted() {
        return promoted;
    }

    /**
     * Set the promoted property value
     *
     * @param promoted property value to set
     */
    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
    }

    /**
     * Set promoted in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject promoted(Boolean promoted) {
        this.promoted = promoted;
        return this;
    }

    /**
     * The id of the section to which this article belongs
     *
     * @return the sectionId property value
     */
    public Long getSectionId() {
        return sectionId;
    }

    /**
     * Set the sectionId property value
     *
     * @param sectionId property value to set
     */
    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Set sectionId in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject sectionId(Long sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    /**
     * The source (default) locale of the article
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
     * The time the article was last updated
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
     * The API url of the article
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
     * The id of the user segment which defines who can see this article. Set to null to make it accessible to everyone.
     * Either user_segment_id or user_segment_ids must be specified
     *
     * @return the userSegmentId property value
     */
    public Long getUserSegmentId() {
        return userSegmentId;
    }

    /**
     * Set the userSegmentId property value
     *
     * @param userSegmentId property value to set
     */
    public void setUserSegmentId(Long userSegmentId) {
        this.userSegmentId = userSegmentId;
    }

    /**
     * Set userSegmentId in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject userSegmentId(Long userSegmentId) {
        this.userSegmentId = userSegmentId;
        return this;
    }

    /**
     * List of user segment ids which define who can view this article. Set to an empty list to make it accessible to
     * everyone. For Enterprise plans only this may contain more than one user_segment_id. Either user_segment_id or
     * user_segment_ids must be specified
     *
     * @return the userSegmentIds property value
     */
    public List<@NotNull String> getUserSegmentIds() {
        return userSegmentIds;
    }

    /**
     * Set the userSegmentIds property value
     *
     * @param userSegmentIds property value to set
     */
    public void setUserSegmentIds(List<@NotNull String> userSegmentIds) {
        this.userSegmentIds = userSegmentIds;
    }

    /**
     * Set userSegmentIds in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject userSegmentIds(List<@NotNull String> userSegmentIds) {
        this.userSegmentIds = userSegmentIds;
        return this;
    }
    /**
     * Add an item to the userSegmentIds property in a chainable fashion.
     *
     * @return The same instance of ArticleObject for chaining.
     */
    public ArticleObject addUserSegmentIdsItem(String userSegmentIdsItem) {
        if (userSegmentIds == null) {
            userSegmentIds = new ArrayList<>();
        }
        userSegmentIds.add(userSegmentIdsItem);
        return this;
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
        var articleObject = (ArticleObject) o;
        return Objects.equals(locale, articleObject.locale)
            && Objects.equals(permissionGroupId, articleObject.permissionGroupId)
            && Objects.equals(title, articleObject.title)
            && Objects.equals(authorId, articleObject.authorId)
            && Objects.equals(body, articleObject.body)
            && Objects.equals(commentsDisabled, articleObject.commentsDisabled)
            && Objects.equals(contentTagIds, articleObject.contentTagIds)
            && Objects.equals(createdAt, articleObject.createdAt)
            && Objects.equals(draft, articleObject.draft)
            && Objects.equals(editedAt, articleObject.editedAt)
            && Objects.equals(htmlUrl, articleObject.htmlUrl)
            && Objects.equals(id, articleObject.id)
            && Objects.equals(labelNames, articleObject.labelNames)
            && Objects.equals(outdated, articleObject.outdated)
            && Objects.equals(outdatedLocales, articleObject.outdatedLocales)
            && Objects.equals(position, articleObject.position)
            && Objects.equals(promoted, articleObject.promoted)
            && Objects.equals(sectionId, articleObject.sectionId)
            && Objects.equals(sourceLocale, articleObject.sourceLocale)
            && Objects.equals(updatedAt, articleObject.updatedAt)
            && Objects.equals(url, articleObject.url)
            && Objects.equals(userSegmentId, articleObject.userSegmentId)
            && Objects.equals(userSegmentIds, articleObject.userSegmentIds)
            && Objects.equals(voteCount, articleObject.voteCount)
            && Objects.equals(voteSum, articleObject.voteSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, permissionGroupId, title, authorId, body, commentsDisabled, contentTagIds,
                createdAt, draft, editedAt, htmlUrl, id, labelNames, outdated, outdatedLocales, position, promoted,
                sectionId, sourceLocale, updatedAt, url, userSegmentId, userSegmentIds, voteCount, voteSum);
    }

    @Override
    public String toString() {
        return "ArticleObject("
            + "locale: " + getLocale() + ", "
            + "permissionGroupId: " + getPermissionGroupId() + ", "
            + "title: " + getTitle() + ", "
            + "authorId: " + getAuthorId() + ", "
            + "body: " + getBody() + ", "
            + "commentsDisabled: " + getCommentsDisabled() + ", "
            + "contentTagIds: " + getContentTagIds() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "draft: " + getDraft() + ", "
            + "editedAt: " + getEditedAt() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "id: " + getId() + ", "
            + "labelNames: " + getLabelNames() + ", "
            + "outdated: " + getOutdated() + ", "
            + "outdatedLocales: " + getOutdatedLocales() + ", "
            + "position: " + getPosition() + ", "
            + "promoted: " + getPromoted() + ", "
            + "sectionId: " + getSectionId() + ", "
            + "sourceLocale: " + getSourceLocale() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl() + ", "
            + "userSegmentId: " + getUserSegmentId() + ", "
            + "userSegmentIds: " + getUserSegmentIds() + ", "
            + "voteCount: " + getVoteCount() + ", "
            + "voteSum: " + getVoteSum()
            + ")";
    }

}