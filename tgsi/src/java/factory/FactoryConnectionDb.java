
package factory;

/**
 *
 * @author jp
 */
public class FactoryConnectionDb {
    public static final  int MYSQL=1;
    public static  String[] configMYSQL={"diabete","root",""};
    
    
    public static ConectionDB open(int typeDb){
        switch(typeDb){
            case FactoryConnectionDb.MYSQL:
                return new  MySQLConnectionFacory(configMYSQL);
            default:
                return null;
                
                    
        }
    }
          
            
    
}
