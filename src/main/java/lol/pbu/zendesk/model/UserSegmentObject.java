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
import java.util.stream.Stream;

/**
 * <p>The <code>user_type</code> attribute takes one of the following values:</p>
 * <table>
 *   <thead>
 *   <tr>
 *     <th>Value</th>
 *     <th>Users</th>
 *   </tr>
 *   </thead>
 *   <tbody>
 *   <tr>
 *     <td>signed_in_users</td>
 *     <td>only authenticated users</td>
 *   </tr>
 *   <tr>
 *     <td>staff</td>
 *     <td>only agents and Help Center managers</td>
 *   </tr>
 *   </tbody>
 * </table>
 * <p>For <code>group_ids</code>, <code>organization_ids</code>, <code>tags</code>, and <code>or_tags</code>,
 *   an empty array means that access is not restricted by the attribute. For example,
 *   if no group ids are specified, then users don&#39;t have to be in any specific group to
 *   have access.</p>
 * <p>For <code>tags</code>, a user must have all the listed tags to have access. For <code>or_tags</code>, a
 *   user must have at least one of the listed tags to have access.</p>
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    UserSegmentObject.JSON_PROPERTY_USER_TYPE,
    UserSegmentObject.JSON_PROPERTY_ADDED_USER_IDS,
    UserSegmentObject.JSON_PROPERTY_BUILT_IN,
    UserSegmentObject.JSON_PROPERTY_CREATED_AT,
    UserSegmentObject.JSON_PROPERTY_GROUP_IDS,
    UserSegmentObject.JSON_PROPERTY_ID,
    UserSegmentObject.JSON_PROPERTY_NAME,
    UserSegmentObject.JSON_PROPERTY_OR_TAGS,
    UserSegmentObject.JSON_PROPERTY_ORGANIZATION_IDS,
    UserSegmentObject.JSON_PROPERTY_TAGS,
    UserSegmentObject.JSON_PROPERTY_UPDATED_AT,
})
public class UserSegmentObject {

    public static final String JSON_PROPERTY_USER_TYPE = "user_type";
    public static final String JSON_PROPERTY_ADDED_USER_IDS = "added_user_ids";
    public static final String JSON_PROPERTY_BUILT_IN = "built_in";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_GROUP_IDS = "group_ids";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_OR_TAGS = "or_tags";
    public static final String JSON_PROPERTY_ORGANIZATION_IDS = "organization_ids";
    public static final String JSON_PROPERTY_TAGS = "tags";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";

    /**
     * The set of users who can view content
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_USER_TYPE)
    private String userType;

    /**
     * The ids of users added specifically to this user segment, regardless of matching tags or other criteria
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ADDED_USER_IDS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull Long> addedUserIds;

    /**
     * Whether the user segment is built-in. Built-in user segments cannot be modified
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_BUILT_IN)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean builtIn;

    /**
     * When the user segment was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * The ids of the groups that have access
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_GROUP_IDS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull Long> groupIds;

    /**
     * Automatically assigned when the user segment is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Long id;

    /**
     * User segment name (localized to the locale of the current user for built-in user segments)
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String name;

    /**
     * A user must have at least one tag in the list to have access
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_OR_TAGS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> orTags;

    /**
     * The ids of the organizations that have access
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ORGANIZATION_IDS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull Long> organizationIds;

    /**
     * All the tags a user must have to have access
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull String> tags;

    /**
     * When the user segment was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    public UserSegmentObject(String userType) {
        setUserType(userType);
    }

    /**
     * The set of users who can view content
     *
     * @return the userType property value
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Set the userType property value
     *
     * @param userType property value to set
     */
    public void setUserType(String userType) {
        if (Stream.of("signed_in_users", "staff").noneMatch(userType::equalsIgnoreCase)) {
            throw new IllegalArgumentException("`userType` can only be \"signed_in_users\" or \"staff\". received: " + userType);
        }
        this.userType = userType.toLowerCase();
    }

    /**
     * Set userType in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject userType(String userType) {
        setUserType(userType);
        return this;
    }

    /**
     * The ids of users added specifically to this user segment, regardless of matching tags or other criteria
     *
     * @return the addedUserIds property value
     */
    public List<@NotNull Long> getAddedUserIds() {
        return addedUserIds;
    }

    /**
     * Set the addedUserIds property value
     *
     * @param addedUserIds property value to set
     */
    public void setAddedUserIds(List<@NotNull Long> addedUserIds) {
        this.addedUserIds = addedUserIds;
    }

    /**
     * Set addedUserIds in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject addedUserIds(List<@NotNull Long> addedUserIds) {
        this.addedUserIds = addedUserIds;
        return this;
    }

    /**
     * Add an item to the addedUserIds property in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject addAddedUserIdsItem(Long addedUserIdsItem) {
        if (addedUserIds == null) {
            addedUserIds = new ArrayList<>();
        }
        addedUserIds.add(addedUserIdsItem);
        return this;
    }

    /**
     * Whether the user segment is built-in. Built-in user segments cannot be modified
     *
     * @return the builtIn property value
     */
    public Boolean getBuiltIn() {
        return builtIn;
    }

    /**
     * Set the builtIn property value
     *
     * @param builtIn property value to set
     */
    public void setBuiltIn(Boolean builtIn) {
        this.builtIn = builtIn;
    }

    /**
     * When the user segment was created
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
     * The ids of the groups that have access
     *
     * @return the groupIds property value
     */
    public List<@NotNull Long> getGroupIds() {
        return groupIds;
    }

    /**
     * Set the groupIds property value
     *
     * @param groupIds property value to set
     */
    public void setGroupIds(List<@NotNull Long> groupIds) {
        this.groupIds = groupIds;
    }

    /**
     * Set groupIds in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject groupIds(List<@NotNull Long> groupIds) {
        this.groupIds = groupIds;
        return this;
    }

    /**
     * Add an item to the groupIds property in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject addGroupIdsItem(Long groupIdsItem) {
        if (groupIds == null) {
            groupIds = new ArrayList<>();
        }
        groupIds.add(groupIdsItem);
        return this;
    }

    /**
     * Automatically assigned when the user segment is created
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
     * User segment name (localized to the locale of the current user for built-in user segments)
     *
     * @return the name property value
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property value
     *
     * @param name property value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set name in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A user must have at least one tag in the list to have access
     *
     * @return the orTags property value
     */
    public List<@NotNull String> getOrTags() {
        return orTags;
    }

    /**
     * Set the orTags property value
     *
     * @param orTags property value to set
     */
    public void setOrTags(List<@NotNull String> orTags) {
        this.orTags = orTags;
    }

    /**
     * Set orTags in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject orTags(List<@NotNull String> orTags) {
        this.orTags = orTags;
        return this;
    }

    /**
     * Add an item to the orTags property in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject addOrTagsItem(String orTagsItem) {
        if (orTags == null) {
            orTags = new ArrayList<>();
        }
        orTags.add(orTagsItem);
        return this;
    }

    /**
     * The ids of the organizations that have access
     *
     * @return the organizationIds property value
     */
    public List<@NotNull Long> getOrganizationIds() {
        return organizationIds;
    }

    /**
     * Set the organizationIds property value
     *
     * @param organizationIds property value to set
     */
    public void setOrganizationIds(List<@NotNull Long> organizationIds) {
        this.organizationIds = organizationIds;
    }

    /**
     * Set organizationIds in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject organizationIds(List<@NotNull Long> organizationIds) {
        this.organizationIds = organizationIds;
        return this;
    }

    /**
     * Add an item to the organizationIds property in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject addOrganizationIdsItem(Long organizationIdsItem) {
        if (organizationIds == null) {
            organizationIds = new ArrayList<>();
        }
        organizationIds.add(organizationIdsItem);
        return this;
    }

    /**
     * All the tags a user must have to have access
     *
     * @return the tags property value
     */
    public List<@NotNull String> getTags() {
        return tags;
    }

    /**
     * Set the tags property value
     *
     * @param tags property value to set
     */
    public void setTags(List<@NotNull String> tags) {
        this.tags = tags;
    }

    /**
     * Set tags in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject tags(List<@NotNull String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Add an item to the tags property in a chainable fashion.
     *
     * @return The same instance of UserSegmentObject for chaining.
     */
    public UserSegmentObject addTagsItem(String tagsItem) {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        tags.add(tagsItem);
        return this;
    }

    /**
     * When the user segment was last updated
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var userSegmentObject = (UserSegmentObject) o;
        return Objects.equals(userType, userSegmentObject.userType)
                && Objects.equals(addedUserIds, userSegmentObject.addedUserIds)
                && Objects.equals(builtIn, userSegmentObject.builtIn)
                && Objects.equals(createdAt, userSegmentObject.createdAt)
                && Objects.equals(groupIds, userSegmentObject.groupIds)
                && Objects.equals(id, userSegmentObject.id)
                && Objects.equals(name, userSegmentObject.name)
                && Objects.equals(orTags, userSegmentObject.orTags)
                && Objects.equals(organizationIds, userSegmentObject.organizationIds)
                && Objects.equals(tags, userSegmentObject.tags)
                && Objects.equals(updatedAt, userSegmentObject.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userType, addedUserIds, builtIn, createdAt, groupIds, id, name, orTags, organizationIds, tags, updatedAt);
    }

    @Override
    public String toString() {
        return "UserSegmentObject("
                + "userType: " + getUserType() + ", "
                + "addedUserIds: " + getAddedUserIds() + ", "
                + "builtIn: " + getBuiltIn() + ", "
                + "createdAt: " + getCreatedAt() + ", "
                + "groupIds: " + getGroupIds() + ", "
                + "id: " + getId() + ", "
                + "name: " + getName() + ", "
                + "orTags: " + getOrTags() + ", "
                + "organizationIds: " + getOrganizationIds() + ", "
                + "tags: " + getTags() + ", "
                + "updatedAt: " + getUpdatedAt()
                + ")";
    }

}