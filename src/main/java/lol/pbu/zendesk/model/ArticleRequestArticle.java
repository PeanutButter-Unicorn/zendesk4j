package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * ArticleRequestArticle
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    ArticleRequestArticle.JSON_PROPERTY_LOCALE,
    ArticleRequestArticle.JSON_PROPERTY_PERMISSION_GROUP_ID,
    ArticleRequestArticle.JSON_PROPERTY_TITLE,
    ArticleRequestArticle.JSON_PROPERTY_USER_SEGMENT_ID,
    ArticleRequestArticle.JSON_PROPERTY_BODY,
})
public class ArticleRequestArticle {

    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_PERMISSION_GROUP_ID = "permission_group_id";
    public static final String JSON_PROPERTY_TITLE = "title";
    public static final String JSON_PROPERTY_USER_SEGMENT_ID = "user_segment_id";
    public static final String JSON_PROPERTY_BODY = "body";

    @NotNull
    @JsonProperty(JSON_PROPERTY_LOCALE)
    private String locale;

    @NotNull
    @JsonProperty(JSON_PROPERTY_PERMISSION_GROUP_ID)
    private Integer permissionGroupId = 0;

    @NotNull
    @JsonProperty(JSON_PROPERTY_TITLE)
    private String title;

    /**
     * The id of the user segment which defines who can see this article.
     * <p>
     * See <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/user_segments/">User Segments</a>
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_USER_SEGMENT_ID)
    private Integer userSegmentId;

    @Nullable
    @JsonProperty(JSON_PROPERTY_BODY)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String body;

    public ArticleRequestArticle(String locale, Integer permissionGroupId, String title, Integer userSegmentId) {
        this.locale = locale;
        this.permissionGroupId = permissionGroupId;
        this.title = title;
        this.userSegmentId = userSegmentId;
    }

    /**
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
     * @return The same instance of ArticleRequestArticle for chaining.
     */
    public ArticleRequestArticle locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * @return the permissionGroupId property value
     */
    public Integer getPermissionGroupId() {
        return permissionGroupId;
    }

    /**
     * Set the permissionGroupId property value
     *
     * @param permissionGroupId property value to set
     */
    public void setPermissionGroupId(Integer permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    /**
     * Set permissionGroupId in a chainable fashion.
     *
     * @return The same instance of ArticleRequestArticle for chaining.
     */
    public ArticleRequestArticle permissionGroupId(Integer permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
        return this;
    }

    /**
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
     * @return The same instance of ArticleRequestArticle for chaining.
     */
    public ArticleRequestArticle title(String title) {
        this.title = title;
        return this;
    }

    /**
     * @return the userSegmentId property value
     */
    public Integer getUserSegmentId() {
        return userSegmentId;
    }

    /**
     * Set the userSegmentId property value
     *
     * @param userSegmentId property value to set
     */
    public void setUserSegmentId(Integer userSegmentId) {
        this.userSegmentId = userSegmentId;
    }

    /**
     * Set userSegmentId in a chainable fashion.
     *
     * @return The same instance of ArticleRequestArticle for chaining.
     */
    public ArticleRequestArticle userSegmentId(Integer userSegmentId) {
        this.userSegmentId = userSegmentId;
        return this;
    }

    /**
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
     * @return The same instance of ArticleRequestArticle for chaining.
     */
    public ArticleRequestArticle body(String body) {
        this.body = body;
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
        var articleRequestArticle = (ArticleRequestArticle) o;
        return Objects.equals(locale, articleRequestArticle.locale)
            && Objects.equals(permissionGroupId, articleRequestArticle.permissionGroupId)
            && Objects.equals(title, articleRequestArticle.title)
            && Objects.equals(userSegmentId, articleRequestArticle.userSegmentId)
            && Objects.equals(body, articleRequestArticle.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, permissionGroupId, title, userSegmentId, body);
    }

    @Override
    public String toString() {
        return "ArticleRequestArticle("
            + "locale: " + getLocale() + ", "
            + "permissionGroupId: " + getPermissionGroupId() + ", "
            + "title: " + getTitle() + ", "
            + "userSegmentId: " + getUserSegmentId() + ", "
            + "body: " + getBody()
            + ")";
    }

}