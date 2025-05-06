package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * CreateUserImageResponse
 */
@Serdeable
@JsonPropertyOrder(CreateUserImageResponse.JSON_PROPERTY_USER_IMAGE)
public class CreateUserImageResponse {

    public static final String JSON_PROPERTY_USER_IMAGE = "user_image";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_USER_IMAGE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private CreateUserImageResponseUserImage userImage;

    /**
     * @return the userImage property value
     */
    public CreateUserImageResponseUserImage getUserImage() {
        return userImage;
    }

    /**
     * Set the userImage property value
     *
     * @param userImage property value to set
     */
    public void setUserImage(CreateUserImageResponseUserImage userImage) {
        this.userImage = userImage;
    }

    /**
     * Set userImage in a chainable fashion.
     *
     * @return The same instance of CreateUserImageResponse for chaining.
     */
    public CreateUserImageResponse userImage(CreateUserImageResponseUserImage userImage) {
        this.userImage = userImage;
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
        var createUserImageResponse = (CreateUserImageResponse) o;
        return Objects.equals(userImage, createUserImageResponse.userImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userImage);
    }

    @Override
    public String toString() {
        return "CreateUserImageResponse("
            + "userImage: " + getUserImage()
            + ")";
    }

}