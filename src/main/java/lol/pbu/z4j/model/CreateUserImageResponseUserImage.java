package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * CreateUserImageResponseUserImage
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    CreateUserImageResponseUserImage.JSON_PROPERTY_CONTENT_TYPE,
    CreateUserImageResponseUserImage.JSON_PROPERTY_PATH,
    CreateUserImageResponseUserImage.JSON_PROPERTY_SIZE,
})
public class CreateUserImageResponseUserImage {

    public static final String JSON_PROPERTY_CONTENT_TYPE = "content_type";
    public static final String JSON_PROPERTY_PATH = "path";
    public static final String JSON_PROPERTY_SIZE = "size";

    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String contentType;

    @Nullable
    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String path;

    @Nullable
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private BigDecimal size;

    /**
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
     * Set contentType in a chainable fashion.
     *
     * @return The same instance of CreateUserImageResponseUserImage for chaining.
     */
    public CreateUserImageResponseUserImage contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * @return the path property value
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the path property value
     *
     * @param path property value to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Set path in a chainable fashion.
     *
     * @return The same instance of CreateUserImageResponseUserImage for chaining.
     */
    public CreateUserImageResponseUserImage path(String path) {
        this.path = path;
        return this;
    }

    /**
     * @return the size property value
     */
    public BigDecimal getSize() {
        return size;
    }

    /**
     * Set the size property value
     *
     * @param size property value to set
     */
    public void setSize(BigDecimal size) {
        this.size = size;
    }

    /**
     * Set size in a chainable fashion.
     *
     * @return The same instance of CreateUserImageResponseUserImage for chaining.
     */
    public CreateUserImageResponseUserImage size(BigDecimal size) {
        this.size = size;
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
        var createUserImageResponseUserImage = (CreateUserImageResponseUserImage) o;
        return Objects.equals(contentType, createUserImageResponseUserImage.contentType)
            && Objects.equals(path, createUserImageResponseUserImage.path)
            && Objects.equals(size, createUserImageResponseUserImage.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentType, path, size);
    }

    @Override
    public String toString() {
        return "CreateUserImageResponseUserImage("
            + "contentType: " + getContentType() + ", "
            + "path: " + getPath() + ", "
            + "size: " + getSize()
            + ")";
    }

}