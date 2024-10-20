/* Y Nhi Tran
 * Group 4-Formation
 * Members: Huong Doan, Y Nhi Tran, Yue-Hsi Cheng
*/

package Mid_p1;

public class Profile {
    private String name;
    private Status status;
    private enum Status {
        ONLINE, OFFLINE, BUSY
    }
    private AList<String> friendList;
    private AList<String> networkList;

    public Profile(String inputName) {
        name = inputName;
        status = Status.ONLINE;
        friendList = new AList<String>();
        networkList = new AList<String>();
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public AList<String> getFriendList() {
        return friendList;
    }

    public AList<String> getNetworkList() {
        return networkList;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setStatusOnline() {
        status = Status.ONLINE;
    }

    public void setStatusOffline() {
        status = Status.OFFLINE;
    }

    public void setStatusBusy() {
        status = Status.BUSY;
    }

    public boolean addFriend(String name) {
        boolean result = false;
        if (!friendList.contains(name)) {
            friendList.add(name);
            result = true;
        }
        return result;
    }

    public String removeFriend(int idx) {
        return friendList.remove(idx);
    }

    public boolean addNetwork(String name) {
        boolean result = false;
        if (!networkList.contains(name)) {
            networkList.add(name);
            result = true;
        }
        return result;
    }

    public String removeNetwork(int idx) {
        return networkList.remove(idx);
    }
}
