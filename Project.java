

public class Project {
    private String name;
    private String description = "";  
    
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        
    }
    Project() {
        
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    
    public String toText() {
        return "This project has the description: " + description;
    }
}