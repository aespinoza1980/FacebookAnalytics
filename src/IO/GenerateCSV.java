package IO;
import Beans.MyPage;
import Beans.AccessLog;
import Beans.Friends;
import Dao.ObjectDao;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexis on 10/09/15.
 */
public class GenerateCSV {
    private static String MyPage=System.getProperty("user.dir")+"/src/Files/OutPut/MyPage.csv";
    private static String FriendsCSV=System.getProperty("user.dir")+"/src/Files/OutPut/Friends.csv";
    private static String AccessLogs=System.getProperty("user.dir")+"/src/Files/OutPut/AccessLogs.csv";

    public static void generateCsvFile( ObjectDao myPageDao, ObjectDao accessLogDao, ObjectDao friendsDao)
    {
        try
        {
            FileWriter writer = new FileWriter(MyPage);
            List<MyPage> myPageList= new ArrayList<MyPage>();
            myPageList=(List)myPageDao.getAllObjects();
            for(int i=0;i<myPageList.size();i++){
                writer.append(String.valueOf(myPageList.get(i).getId()));
                writer.append(',');
                writer.append(myPageList.get(i).getName());
                writer.append(',');
                writer.append(myPageList.get(i).getNationality());
                writer.append(',');
                writer.append(String.valueOf(myPageList.get(i).getCountryCode()));
                writer.append(',');
                writer.append(myPageList.get(i).getHobby());
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileWriter writer = new FileWriter(AccessLogs);
            List<AccessLog> accessLogList= new ArrayList<AccessLog>();
            accessLogList=(List)accessLogDao.getAllObjects();
            for(int i=0;i<accessLogList.size();i++){
                writer.append(String.valueOf(accessLogList.get(i).getAccessId()));
                writer.append(',');
                writer.append(String.valueOf(accessLogList.get(i).getByWho()));
                writer.append(',');
                writer.append(String.valueOf(accessLogList.get(i).getWhatPage()));
                writer.append(',');
                writer.append(String.valueOf(accessLogList.get(i).getTypeOfAccess()));
                writer.append(',');
                writer.append(String.valueOf(accessLogList.get(i).getAccessTime()));
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        try
        {
            FileWriter writer = new FileWriter(FriendsCSV);
            List<Friends> friendsList= new ArrayList<Friends>();
            friendsList=(List)friendsDao.getAllObjects();
            for(int i=0;i<friendsList.size();i++){
                writer.append(String.valueOf(friendsList.get(i).getFriendRel()));
                writer.append(',');
                writer.append(String.valueOf(friendsList.get(i).getPersonId()));
                writer.append(',');
                writer.append(String.valueOf(friendsList.get(i).getMyFriend()));
                writer.append(',');
                writer.append(String.valueOf(friendsList.get(i).getDateOfFriendShip()));
                writer.append(',');
                writer.append(String.valueOf(friendsList.get(i).getDesc()));
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
