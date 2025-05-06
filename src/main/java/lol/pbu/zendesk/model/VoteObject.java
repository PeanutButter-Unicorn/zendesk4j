package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * VoteObject
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    VoteObject.JSON_PROPERTY_VALUE,
    VoteObject.JSON_PROPERTY_CREATED_AT,
    VoteObject.JSON_PROPERTY_ID,
    VoteObject.JSON_PROPERTY_ITEM_ID,
    VoteObject.JSON_PROPERTY_ITEM_TYPE,
    VoteObject.JSON_PROPERTY_UPDATED_AT,
    VoteObject.JSON_PROPERTY_URL,
    VoteObject.JSON_PROPERTY_USER_ID,
})
public class VoteObject {

    public static final String JSON_PROPERTY_VALUE = "value";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_ITEM_ID = "item_id";
    public static final String JSON_PROPERTY_ITEM_TYPE = "item_type";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";
    public static final String JSON_PROPERTY_USER_ID = "user_id";

    /**
     * The value of the vote
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_VALUE)
    private Integer value;

    /**
     * The time at which the vote was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * Automatically assigned when the vote is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * The id of the item for which this vote was cast
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ITEM_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer itemId;

    /**
     * The type of the item. Can be \&quot;Article\&quot;, \&quot;Comment\&quot;, \&quot;Post\&quot; or \&quot;PostComment\&quot;
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ITEM_TYPE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String itemType;

    /**
     * The time at which the vote was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The API url of this vote
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The id of the user who cast this vote
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer userId;

    public VoteObject(Integer value) {
        this.value = value;
    }

    /**
     * The value of the vote
     *
     * @return the value property value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Set the value property value
     *
     * @param value property value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Set value in a chainable fashion.
     *
     * @return The same instance of VoteObject for chaining.
     */
    public VoteObject value(Integer value) {
        this.value = value;
        return this;
    }

    /**
     * The time at which the vote was created
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
     * Automatically assigned when the vote is created
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
     * The id of the item for which this vote was cast
     *
     * @return the itemId property value
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * Set the itemId property value
     *
     * @param itemId property value to set
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * The type of the item. Can be \&quot;Article\&quot;, \&quot;Comment\&quot;, \&quot;Post\&quot; or \&quot;PostComment\&quot;
     *
     * @return the itemType property value
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Set the itemType property value
     *
     * @param itemType property value to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * The time at which the vote was last updated
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
     * The API url of this vote
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
     * The id of the user who cast this vote
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
        var voteObject = (VoteObject) o;
        return Objects.equals(value, voteObject.value)
            && Objects.equals(createdAt, voteObject.createdAt)
            && Objects.equals(id, voteObject.id)
            && Objects.equals(itemId, voteObject.itemId)
            && Objects.equals(itemType, voteObject.itemType)
            && Objects.equals(updatedAt, voteObject.updatedAt)
            && Objects.equals(url, voteObject.url)
            && Objects.equals(userId, voteObject.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, createdAt, id, itemId, itemType, updatedAt, url, userId);
    }

    @Override
    public String toString() {
        return "VoteObject("
            + "value: " + getValue() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "id: " + getId() + ", "
            + "itemId: " + getItemId() + ", "
            + "itemType: " + getItemType() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl() + ", "
            + "userId: " + getUserId()
            + ")";
    }

}