package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * RequestUserImageUploadResponse
 */
@Serdeable
@JsonPropertyOrder(RequestUserImageUploadResponse.JSON_PROPERTY_UPLOAD)
public class RequestUserImageUploadResponse {

    public static final String JSON_PROPERTY_UPLOAD = "upload";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_UPLOAD)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private RequestUserImageUploadResponseUpload upload;

    /**
     * @return the upload property value
     */
    public RequestUserImageUploadResponseUpload getUpload() {
        return upload;
    }

    /**
     * Set the upload property value
     *
     * @param upload property value to set
     */
    public void setUpload(RequestUserImageUploadResponseUpload upload) {
        this.upload = upload;
    }

    /**
     * Set upload in a chainable fashion.
     *
     * @return The same instance of RequestUserImageUploadResponse for chaining.
     */
    public RequestUserImageUploadResponse upload(RequestUserImageUploadResponseUpload upload) {
        this.upload = upload;
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
        var requestUserImageUploadResponse = (RequestUserImageUploadResponse) o;
        return Objects.equals(upload, requestUserImageUploadResponse.upload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upload);
    }

    @Override
    public String toString() {
        return "RequestUserImageUploadResponse("
            + "upload: " + getUpload()
            + ")";
    }

}