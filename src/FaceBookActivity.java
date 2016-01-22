/**
 * Created by alexis on 10/09/15.
 */
import Dao.*;
import DaoImpl.AccessLogObjectDaoImpl;
import DaoImpl.MyPageObjectDaoImpl;
import DaoImpl.FriendsObjectDaoImpl;
import IO.GenerateCSV;

public class FaceBookActivity {
    public static void main(String args[]){
        ObjectDao myPageDao = new MyPageObjectDaoImpl();
        ObjectDao friendsDao = new FriendsObjectDaoImpl();
        ObjectDao accessLogDao = new AccessLogObjectDaoImpl(myPageDao,friendsDao);
        GenerateCSV.generateCsvFile(myPageDao, accessLogDao, friendsDao);
    }
}
