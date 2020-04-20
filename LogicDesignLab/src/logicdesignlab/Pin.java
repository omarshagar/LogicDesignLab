package logicdesignlab;
public class Pin extends PinObservee implements PinObserver{
  private int value;//1 for +5volt    0 for  0 volt   -1 for ground 
  private int width;
  private int height;
  private Component parentComponent;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Component getParentComponent() {
        return parentComponent;
    }

    public void setParentComponent(Component parentComponent) {
        this.parentComponent = parentComponent;
    }
  
  
  
  
  
    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void changeValue(int val)
    {
        this.value=val;
        
        //continue code of changing value
    }
  
}
