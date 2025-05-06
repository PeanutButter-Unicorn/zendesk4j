package lol.pbu.zendesk.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Objects;

/**
 * SectionPutRequestSection
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    SectionPutRequestSection.JSON_PROPERTY_CATEGORY_ID,
    SectionPutRequestSection.JSON_PROPERTY_DESCRIPTION,
    SectionPutRequestSection.JSON_PROPERTY_NAME,
    SectionPutRequestSection.JSON_PROPERTY_PARENT_SECTION_ID,
    SectionPutRequestSection.JSON_PROPERTY_POSITION,
    SectionPutRequestSection.JSON_PROPERTY_SORTING,
    SectionPutRequestSection.JSON_PROPERTY_THEME_TEMPLATE,
})
public class SectionPutRequestSection {

    public static final String JSON_PROPERTY_CATEGORY_ID = "category_id";
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_PARENT_SECTION_ID = "parent_section_id";
    public static final String JSON_PROPERTY_POSITION = "position";
    public static final String JSON_PROPERTY_SORTING = "sorting";
    public static final String JSON_PROPERTY_THEME_TEMPLATE = "theme_template";

    /**
     * The id of the category to which this section belongs
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CATEGORY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer categoryId;

    /**
     * The description of the section
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String description;

    /**
     * The name of the section
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String name;

    /**
     * The id of the section to which this section belongs. Only writable for Guide Enterprise customers
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_SECTION_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer parentSectionId;

    /**
     * The position of this section in the section list. Used when sorting is set to ´manual´.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_POSITION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer position;

    @Nullable
    @JsonProperty(JSON_PROPERTY_SORTING)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private SectionPutRequestSectionSorting sorting;

    /**
     * The theme template name used to display this section in Help Center.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_THEME_TEMPLATE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String themeTemplate;

    /**
     * The id of the category to which this section belongs
     *
     * @return the categoryId property value
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * Set the categoryId property value
     *
     * @param categoryId property value to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Set categoryId in a chainable fashion.
     *
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection categoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    /**
     * The description of the section
     *
     * @return the description property value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description property value
     *
     * @param description property value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set description in a chainable fashion.
     *
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The name of the section
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
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The id of the section to which this section belongs. Only writable for Guide Enterprise customers
     *
     * @return the parentSectionId property value
     */
    public Integer getParentSectionId() {
        return parentSectionId;
    }

    /**
     * Set the parentSectionId property value
     *
     * @param parentSectionId property value to set
     */
    public void setParentSectionId(Integer parentSectionId) {
        this.parentSectionId = parentSectionId;
    }

    /**
     * Set parentSectionId in a chainable fashion.
     *
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection parentSectionId(Integer parentSectionId) {
        this.parentSectionId = parentSectionId;
        return this;
    }

    /**
     * The position of this section in the section list. Used when sorting is set to ´manual´.
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
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection position(Integer position) {
        this.position = position;
        return this;
    }

    /**
     * @return the sorting property value
     */
    public SectionPutRequestSectionSorting getSorting() {
        return sorting;
    }

    /**
     * Set the sorting property value
     *
     * @param sorting property value to set
     */
    public void setSorting(SectionPutRequestSectionSorting sorting) {
        this.sorting = sorting;
    }

    /**
     * Set sorting in a chainable fashion.
     *
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection sorting(SectionPutRequestSectionSorting sorting) {
        this.sorting = sorting;
        return this;
    }

    /**
     * The theme template name used to display this section in Help Center.
     *
     * @return the themeTemplate property value
     */
    public String getThemeTemplate() {
        return themeTemplate;
    }

    /**
     * Set the themeTemplate property value
     *
     * @param themeTemplate property value to set
     */
    public void setThemeTemplate(String themeTemplate) {
        this.themeTemplate = themeTemplate;
    }

    /**
     * Set themeTemplate in a chainable fashion.
     *
     * @return The same instance of SectionPutRequestSection for chaining.
     */
    public SectionPutRequestSection themeTemplate(String themeTemplate) {
        this.themeTemplate = themeTemplate;
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
        var sectionPutRequestSection = (SectionPutRequestSection) o;
        return Objects.equals(categoryId, sectionPutRequestSection.categoryId)
            && Objects.equals(description, sectionPutRequestSection.description)
            && Objects.equals(name, sectionPutRequestSection.name)
            && Objects.equals(parentSectionId, sectionPutRequestSection.parentSectionId)
            && Objects.equals(position, sectionPutRequestSection.position)
            && Objects.equals(sorting, sectionPutRequestSection.sorting)
            && Objects.equals(themeTemplate, sectionPutRequestSection.themeTemplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, description, name, parentSectionId, position, sorting, themeTemplate);
    }

    @Override
    public String toString() {
        return "SectionPutRequestSection("
            + "categoryId: " + getCategoryId() + ", "
            + "description: " + getDescription() + ", "
            + "name: " + getName() + ", "
            + "parentSectionId: " + getParentSectionId() + ", "
            + "position: " + getPosition() + ", "
            + "sorting: " + getSorting() + ", "
            + "themeTemplate: " + getThemeTemplate()
            + ")";
    }

}