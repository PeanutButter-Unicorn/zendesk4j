package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Objects;

/**
 * ArticleAttachmentObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    ArticleAttachmentObject.JSON_PROPERTY_ARTICLE_ID,
    ArticleAttachmentObject.JSON_PROPERTY_CONTENT_TYPE,
    ArticleAttachmentObject.JSON_PROPERTY_CONTENT_URL,
    ArticleAttachmentObject.JSON_PROPERTY_CREATED_AT,
    ArticleAttachmentObject.JSON_PROPERTY_FILE,
    ArticleAttachmentObject.JSON_PROPERTY_FILE_NAME,
    ArticleAttachmentObject.JSON_PROPERTY_GUIDE_MEDIA_ID,
    ArticleAttachmentObject.JSON_PROPERTY_ID,
    ArticleAttachmentObject.JSON_PROPERTY_INLINE,
    ArticleAttachmentObject.JSON_PROPERTY_LOCALE,
    ArticleAttachmentObject.JSON_PROPERTY_SIZE,
    ArticleAttachmentObject.JSON_PROPERTY_UPDATED_AT,
    ArticleAttachmentObject.JSON_PROPERTY_URL,
})
public class ArticleAttachmentObject {

    public static final String JSON_PROPERTY_ARTICLE_ID = "article_id";
    public static final String JSON_PROPERTY_CONTENT_TYPE = "content_type";
    public static final String JSON_PROPERTY_CONTENT_URL = "content_url";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_FILE = "file";
    public static final String JSON_PROPERTY_FILE_NAME = "file_name";
    public static final String JSON_PROPERTY_GUIDE_MEDIA_ID = "guide_media_id";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_INLINE = "inline";
    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_SIZE = "size";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";

    /**
     * The associated article, if present
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ARTICLE_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer articleId;

    /**
     * The file type. Example: image/png
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String contentType;

    /**
     * URL where the attachment file can be downloaded
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String contentUrl;

    /**
     * The time the article attachment was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * File to upload, applicable only during creation.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FILE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Object file;

    /**
     * The file name
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FILE_NAME)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String fileName;

    /**
     * Unique identifier for the guide-media to associate with this attachment, applicable only during creation.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_GUIDE_MEDIA_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String guideMediaId;

    /**
     * Assigned ID when the article attachment is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * The attached file is shown in the admin interface for inline attachments. Its URL can be referenced in the
     * article&#39;s HTML body. Inline attachments are image files directly embedded in the article body. If false,
     * the attachment is listed in the list of attachments. The default value is false
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_INLINE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean inline;

    /**
     * The locale of translation that the attachment will be attached to and can only be set on inline attachments
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String locale;

    /**
     * The attachment file size in bytes
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer size;

    /**
     * The time the article attachment was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The URL of the article attachment
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The associated article, if present
     *
     * @return the articleId property value
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * Set the articleId property value
     *
     * @param articleId property value to set
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Set articleId in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentObject for chaining.
     */
    public ArticleAttachmentObject articleId(Integer articleId) {
        this.articleId = articleId;
        return this;
    }

    /**
     * The file type. Example: image/png
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
     * URL where the attachment file can be downloaded
     *
     * @return the contentUrl property value
     */
    public String getContentUrl() {
        return contentUrl;
    }

    /**
     * Set the contentUrl property value
     *
     * @param contentUrl property value to set
     */
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    /**
     * The time the article attachment was created
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
     * File to upload, applicable only during creation.
     *
     * @return the file property value
     */
    public Object getFile() {
        return file;
    }

    /**
     * Set the file property value
     *
     * @param file property value to set
     */
    public void setFile(Object file) {
        this.file = file;
    }

    /**
     * Set file in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentObject for chaining.
     */
    public ArticleAttachmentObject file(Object file) {
        this.file = file;
        return this;
    }

    /**
     * The file name
     *
     * @return the fileName property value
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Set the fileName property value
     *
     * @param fileName property value to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Unique identifier for the guide-media to associate with this attachment, applicable only during creation.
     *
     * @return the guideMediaId property value
     */
    public String getGuideMediaId() {
        return guideMediaId;
    }

    /**
     * Set the guideMediaId property value
     *
     * @param guideMediaId property value to set
     */
    public void setGuideMediaId(String guideMediaId) {
        this.guideMediaId = guideMediaId;
    }

    /**
     * Set guideMediaId in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentObject for chaining.
     */
    public ArticleAttachmentObject guideMediaId(String guideMediaId) {
        this.guideMediaId = guideMediaId;
        return this;
    }

    /**
     * Assigned ID when the article attachment is created
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
     * The attached file is shown in the admin interface for inline attachments. Its URL can be referenced in the article&#39;s HTML body. Inline attachments are image files directly embedded in the article body. If false, the attachment is listed in the list of attachments. The default value is false
     *
     * @return the inline property value
     */
    public Boolean getInline() {
        return inline;
    }

    /**
     * Set the inline property value
     *
     * @param inline property value to set
     */
    public void setInline(Boolean inline) {
        this.inline = inline;
    }

    /**
     * Set inline in a chainable fashion.
     *
     * @return The same instance of ArticleAttachmentObject for chaining.
     */
    public ArticleAttachmentObject inline(Boolean inline) {
        this.inline = inline;
        return this;
    }

    /**
     * The locale of translation that the attachment will be attached to and can only be set on inline attachments
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
     * @return The same instance of ArticleAttachmentObject for chaining.
     */
    public ArticleAttachmentObject locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * The attachment file size in bytes
     *
     * @return the size property value
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Set the size property value
     *
     * @param size property value to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * The time the article attachment was last updated
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
     * The URL of the article attachment
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
        var articleAttachmentObject = (ArticleAttachmentObject) o;
        return Objects.equals(articleId, articleAttachmentObject.articleId)
            && Objects.equals(contentType, articleAttachmentObject.contentType)
            && Objects.equals(contentUrl, articleAttachmentObject.contentUrl)
            && Objects.equals(createdAt, articleAttachmentObject.createdAt)
            && Objects.equals(file, articleAttachmentObject.file)
            && Objects.equals(fileName, articleAttachmentObject.fileName)
            && Objects.equals(guideMediaId, articleAttachmentObject.guideMediaId)
            && Objects.equals(id, articleAttachmentObject.id)
            && Objects.equals(inline, articleAttachmentObject.inline)
            && Objects.equals(locale, articleAttachmentObject.locale)
            && Objects.equals(size, articleAttachmentObject.size)
            && Objects.equals(updatedAt, articleAttachmentObject.updatedAt)
            && Objects.equals(url, articleAttachmentObject.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, contentType, contentUrl, createdAt, file, fileName, guideMediaId, id, inline, locale, size, updatedAt, url);
    }

    @Override
    public String toString() {
        return "ArticleAttachmentObject("
            + "articleId: " + getArticleId() + ", "
            + "contentType: " + getContentType() + ", "
            + "contentUrl: " + getContentUrl() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "file: " + getFile() + ", "
            + "fileName: " + getFileName() + ", "
            + "guideMediaId: " + getGuideMediaId() + ", "
            + "id: " + getId() + ", "
            + "inline: " + getInline() + ", "
            + "locale: " + getLocale() + ", "
            + "size: " + getSize() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl()
            + ")";
    }

}