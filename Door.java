
/**
 * Write a description of class Door here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private String name;
    private boolean isOpen;
    private String color;
    private double height; 
    private double width;
    
    public Door(String initialName, boolean initialState, String initialColor, double initialHeight, double initialWidth)
    {
        this.name = initialName;
        this.isOpen = initialState; 
        this.color = initialColor;
        this.height = initialHeight;
        this.width = initialWidth;
    }
    
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setState(boolean newState)
    {
        this.isOpen = newState;
    }
    
    public boolean getState()
    {
        return this.isOpen;
    }
    
    public void setColor(String newColor)
    {
        this.color = newColor;
    }
    
    public String getColor()
    {
        return this.color;
    }
}
