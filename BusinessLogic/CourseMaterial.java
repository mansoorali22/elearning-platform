package BusinessLogic;

public class CourseMaterial {
    // Fields
    private Integer materialID;
    private String materialType;
    private String title;
    private String description;

    // Constructor
    public CourseMaterial(Integer materialID, String materialType, String title, String description) {
        this.materialID = materialID;
        this.materialType = materialType;
        this.title = title;
        this.description = description;
    }

    // Getters
    public Integer getMaterialID() { return materialID; }
    public String getMaterialType() { return materialType; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }

    // Setters
    public void setMaterialID(Integer materialID) { this.materialID = materialID; }
    public void setMaterialType(String materialType) { this.materialType = materialType; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }


    public void viewMaterial(String courseID) {
        // View material logic here
    }
}
