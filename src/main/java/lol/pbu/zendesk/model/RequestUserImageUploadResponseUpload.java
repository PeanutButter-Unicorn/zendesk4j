package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * RequestUserImageUploadResponseUpload
 */
@Serdeable
@JsonPropertyOrder({
    RequestUserImageUploadResponseUpload.JSON_PROPERTY_HEADERS,
    RequestUserImageUploadResponseUpload.JSON_PROPERTY_TOKEN,
    RequestUserImageUploadResponseUpload.JSON_PROPERTY_URL,
})
public class RequestUserImageUploadResponseUpload {

    public static final String JSON_PROPERTY_HEADERS = "headers";
    public static final String JSON_PROPERTY_TOKEN = "token";
    public static final String JSON_PROPERTY_URL = "url";

    @Nullable
    @JsonProperty(JSON_PROPERTY_HEADERS)
    @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
    private Map<String, Object> headers;

    @Nullable
    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String token;

    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * @return the headers property value
     */
    public Map<String, Object> getHeaders() {
        return headers;
    }

    /**
     * Set the headers property value
     *
     * @param headers property value to set
     */
    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    /**
     * Set headers in a chainable fashion.
     *
     * @return The same instance of RequestUserImageUploadResponseUpload for chaining.
     */
    public RequestUserImageUploadResponseUpload headers(Map<String, Object> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Set the value for the key for the headers map property in a chainable fashion.
     *
     * @return The same instance of RequestUserImageUploadResponseUpload for chaining.
     */
    public RequestUserImageUploadResponseUpload putHeadersItem(String key, Object headersItem) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put(key, headersItem);
        return this;
    }

    /**
     * @return the token property value
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token property value
     *
     * @param token property value to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Set token in a chainable fashion.
     *
     * @return The same instance of RequestUserImageUploadResponseUpload for chaining.
     */
    public RequestUserImageUploadResponseUpload token(String token) {
        this.token = token;
        return this;
    }

    /**
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
     * Set url in a chainable fashion.
     *
     * @return The same instance of RequestUserImageUploadResponseUpload for chaining.
     */
    public RequestUserImageUploadResponseUpload url(String url) {
        this.url = url;
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
        var requestUserImageUploadResponseUpload = (RequestUserImageUploadResponseUpload) o;
        return Objects.equals(headers, requestUserImageUploadResponseUpload.headers)
            && Objects.equals(token, requestUserImageUploadResponseUpload.token)
            && Objects.equals(url, requestUserImageUploadResponseUpload.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headers, token, url);
    }

    @Override
    public String toString() {
        return "RequestUserImageUploadResponseUpload("
            + "headers: " + getHeaders() + ", "
            + "token: " + getToken() + ", "
            + "url: " + getUrl()
            + ")";
    }

}