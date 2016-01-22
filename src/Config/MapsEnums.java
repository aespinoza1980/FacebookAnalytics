package Config; /**
 * Created by Alexis Espinoza on 10/09/15.
 */
import java.util.ArrayList;

import IO.ReadFile;
public class MapsEnums {
    public enum TYPEOFACCESS {justViewed,leftANote,AddedAFriendShip;}
    public static final String fileHobbies="hobbies.txt";
    public static final String fileNationalities="nationalities.txt";
    public static final String fileTypeFriends="typeoffriends.txt";
    public static final String fileNames="names.txt";
    public static final String fileLastNames="lastnames.txt";
    public static final int limitAccesLog=100000;//Maximun number of all possible logs
    public static final int limitMyPage=50000;//Maximun number of users
    public  static ArrayList<String> getListFromFile(String file){
        return ReadFile.readFileIntoArrayList(System.getProperty("user.dir")+"/src/Files/Input/"+file);
    }
}
