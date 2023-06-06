package Models;

public class ParameterTable {
    private String name;
    private String displayName;
    private String description;
    private String usedBy;
    private String fieldType;
    private String allowMultiple;

    public ParameterTable(String name, String displayName, String description, String usedBy, String fieldType, String allowMultiple) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.usedBy = usedBy;
        this.fieldType = fieldType;
        this.allowMultiple = allowMultiple;
    }

    public String getName() {
        return name;
    }
    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public String getFieldType() {
        return fieldType;
    }

    public String getAllowMultiple() {
        return allowMultiple;
    }
}