package top;

import entity.Officials;

public class SessionHolder 
{
    static private Officials servant;

    static public Officials getServant() 
    {
        return servant;
    }

    static public void setServant(Officials servant) 
    {
        SessionHolder.servant = servant;
    }
    
}
