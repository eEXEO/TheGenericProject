package top;

import entity.Officials;
import entity.Owners;
import javafx.scene.layout.AnchorPane;

public class SessionHolder 
{
    static private Officials servant;
    static private Owners owner;
    static private AnchorPane ap;

    public static AnchorPane getAnchor() 
    {
        return ap;
    }

    public static void setAnchor(AnchorPane ap) 
    {
        SessionHolder.ap = ap;
    }
    
    static public Officials getServant() 
    {
        return servant;
    }

    static public void setServant(Officials servant) 
    {
        SessionHolder.servant = servant;
    }
    
    static public Owners getOwner() 
    {
        return owner;
    }

    static public void setOwner(Owners owner) 
    {
        SessionHolder.owner = owner;
    }
    
}
