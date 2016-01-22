package Beans;
/**
 * Created by  Alexis Espinoza on 11/09/15.
 */
public class AccessLog {
    private int accessId;
    private int byWho;
    private int whatPage;
    private String typeOfAccess;
    private String accessTime;
    public AccessLog(int accessId,int byWho,int whatPage, String typeOfAccess,String accessTime){
        this.accessId = accessId;
        this.byWho = byWho;
        this.whatPage = whatPage;
        this.typeOfAccess = typeOfAccess;
        this.accessTime = accessTime;
    }
    public int getAccessId() {
        return accessId;
    }
    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }
    public int getByWho() {
        return byWho;
    }
    public void setByWho(int byWho) {
        this.byWho = byWho;
    }

    public int getWhatPage() {
        return whatPage;
    }
    public void setWhatPage(int whatPage) {
        this.whatPage = whatPage;
    }
    public String getTypeOfAccess() {
        return typeOfAccess;
    }
    public void setTypeOfAccess(String typeOfAccess) {
        this.typeOfAccess = typeOfAccess;
    }
    public String getAccessTime() {
        return accessTime;
    }
    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }

}
