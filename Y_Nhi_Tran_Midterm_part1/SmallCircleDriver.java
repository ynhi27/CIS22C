/* Y Nhi Tran
 * Group 4-Formation
 * Members: Huong Doan, Y Nhi Tran, Yue-Hsi Cheng
*/

package Mid_p1;
import java.util.Scanner;

public class SmallCircleDriver {

    public static void main(String[] args) {
        HashedDictionary<String, Profile> profileLib = new HashedDictionary<String, Profile>();
        AList<String> networkLib = new AList<String>();
        networkLib.add("CIS Study Group");
        networkLib.add("Math Club");
        networkLib.add("Physics 101");
        Profile currentUser = null;
        String pageChoice = "Landing";

        while (!pageChoice.equals("Exit")) {
            if (pageChoice.equals("Landing")) {
                pageChoice = drawLanding();
            } else if (pageChoice.equals("CreateProfile")) {
                Profile newProfile = createProfile();
                String name = newProfile.getName();
                profileLib.add(name, newProfile);
                currentUser = newProfile;
                pageChoice = "UserPage";
            } else if (pageChoice.equals("UserPage")) {
                pageChoice = drawUserPage(currentUser, profileLib);
            } else if (pageChoice.equals("Login")) {
                Profile user = drawLogin(profileLib);
                if (user != null) {
                    currentUser = user;
                    pageChoice = "UserPage";
                } else {
                    currentUser = null;
                    pageChoice = "Landing";
                }
            } else if (pageChoice.equals("LogOut")) {
                currentUser = null;
                pageChoice = "Landing";
            } else if (pageChoice.equals("ChangeStatus")) {
                changeStatus(currentUser);
                pageChoice = "UserPage";
            } else if (pageChoice.equals("ChangeName")) {
                String oldName = currentUser.getName();
                Profile changedUser = changeName(currentUser);
                if (changedUser != null) {
                    profileLib.add(changedUser.getName(), changedUser);
                    profileLib.remove(oldName);
                }
                pageChoice = "UserPage";
            } else if (pageChoice.equals("EditFriend")) {
                editFriend(currentUser, profileLib);
                pageChoice = "UserPage";
            } else if (pageChoice.equals("EditNetwork")) {
                editNetwork(currentUser, networkLib);
                pageChoice = "UserPage";
            } else {
                pageChoice = "Landing";
            }
        }
    }

    private static String drawLanding() {
        Scanner input;
        System.out.println("==================================================");
        System.out.println("Welcome to SmallCircle!");
        System.out.println();
        System.out.println("1. Login");
        System.out.println("2. Create Profile");
        System.out.println("3. Exit");
        System.out.println("==================================================");
        input = new Scanner(System.in);
        int result = 0;
        while (result < 1 || result > 3) {
            result = input.nextInt();
        }
        if (result == 1) {
            return "Login";
        } else if (result == 2) {
            return "CreateProfile";
        } else {
            return "Exit";
        }
    }

    private static Profile createProfile() {
        Scanner input;
        System.out.println("Creating Profile");
        System.out.println("Please Enter Your Name:");
        input = new Scanner(System.in);
        String inputName = input.nextLine().trim();
        Profile newProfile = new Profile(inputName);
        return newProfile;
    }

    private static String drawUserPage(Profile userProfile, HashedDictionary<String, Profile> pLib) {
        Scanner input;
        System.out.println("==================================================");
        System.out.println("Welcome " + userProfile.getName());
        System.out.println("Status: " + userProfile.getStatus());
        System.out.println();
        System.out.println("Networks: ");
        drawNetworks(userProfile.getNetworkList());
        System.out.println("Friends:");
        drawFriends(userProfile, pLib);
        System.out.println("1.Change Status 2.Change Name 3.Add/Remove Friend 4.Join/Leave Network 5.Log Out");
        System.out.println("==================================================");
        input = new Scanner(System.in);
        int result = 0;
        while (result < 1 || result > 5) {
            result = input.nextInt();
        }
        if (result == 1) {
            return "ChangeStatus";
        } else if (result == 2) {
            return "ChangeName";
        } else if (result == 3) {
            return "EditFriend";
        } else if (result == 4) {
            return "EditNetwork";
        } else {
            return "LogOut";
        }
    }

    private static void drawNetworks(AList<String> nList) {
        int n = nList.getLength();
        for (int i = 1; i < n + 1; i++) {
            String network = nList.getEntry(i);
            System.out.println(i + ". " + network);
        }
    }

    private static void drawFriends(Profile user, HashedDictionary<String, Profile> pLib) {
        AList<String> fList = user.getFriendList();
        int n = fList.getLength();
        for (int i = 1; i < n + 1; i++) {
            String friend = fList.getEntry(i);
            Profile friendProfile = pLib.getValue(friend);
            if (friendProfile == null) {
                user.removeFriend(i);
                i--;
            } else {
                System.out.println(i + ". " + friend + ": " + friendProfile.getStatus());
            }
        }
    }

    private static Profile drawLogin(HashedDictionary<String, Profile> pLib) {
        Scanner input;
        System.out.println("Logging In");
        System.out.println("Please Enter Your Name:");
        input = new Scanner(System.in);
        String inputName = input.nextLine().trim();
        Profile userProfile = pLib.getValue(inputName);
        if (userProfile == null) {
            System.out.println("User Not Found.");
            System.out.println();
        }
        return userProfile;
    }

    private static void changeStatus(Profile user) {
        Scanner input;
        System.out.println("Changing Status To");
        System.out.println("1.Online 2.Offline 3.Busy");
        input = new Scanner(System.in);
        int result = 0;
        while (result < 1 || result > 3) {
            result = input.nextInt();
        }
        if (result == 1) {
            user.setStatusOnline();
        } else if (result == 2) {
            user.setStatusOffline();
        } else {
            user.setStatusBusy();
        }
    }

    private static Profile changeName(Profile user) {
        Profile result = null;
        Scanner input;
        System.out.println("Changing Name");
        System.out.println("Please Enter Your New Name:");
        input = new Scanner(System.in);
        String newName = input.nextLine().trim();
        if (newName.isEmpty()) {
            System.out.println("Changing Name Failed");
            return result;
        } else {
            user.setName(newName);
            result = user;
            return result;
        }
    }

    private static void editFriend(Profile user, HashedDictionary<String, Profile> profileLib) {
        Scanner input;
        System.out.println("Adding/Removing Friend");
        System.out.println("1.Add Friend 2.Remove Friend");
        input = new Scanner(System.in);
        int result = 0;
        while (result < 1 || result > 2) {
            result = input.nextInt();
        }
        if (result == 1) {
            Boolean done = false;
            while (!done) {
                System.out.println("Adding Friend");
                System.out.println("Please Enter Your Friend's Name:");
                input = new Scanner(System.in);
                String friendName = input.nextLine().trim();
                if (profileLib.contains(friendName) && user.addFriend(friendName)) {
                    System.out.println(friendName + " Added to Your Friend List");
                    System.out.println();
                    done = true;
                } else {
                    System.out.println("Adding Friend Failed");
                    System.out.println("1.Add Friend 2.Back to User Page");
                    int result2 = 0;
                    while (result2 < 1 || result2 > 2) {
                        result2 = input.nextInt();
                    }
                    if (result2 == 2) {
                        done = true;
                    }
                }
            }
        } else {
            if (user.getFriendList().isEmpty()) {
                System.out.println("Your Friend List Is Empty");
                System.out.println();
            } else {
                drawFriends(user, profileLib);
                System.out.println("Enter the Number You Want to Remove");
                int friendIdx = input.nextInt();
                try {
                    String oldFriendName = user.removeFriend(friendIdx);
                    System.out.println(oldFriendName + " Removed from Your Friend List");
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Removing Friend Failed");
                    System.out.println();
                }
            }
        }
    }

    private static void editNetwork(Profile user, AList<String> networkList) {
        Scanner input;
        AList<String> userNetworkList = user.getNetworkList();
        System.out.println("Join/Leave Network");
        System.out.println("1.Joining a Network 2.Leaving a Network");
        input = new Scanner(System.in);
        int result = 0;
        while (result < 1 || result > 2) {
            result = input.nextInt();
        }
        if (result == 1) {
            drawNetworks(networkList);
            System.out.println("Please Enter Network's Number You Want to Join");
            int networkIdx = input.nextInt();
            try {
                String newNetwork = networkList.getEntry(networkIdx);
                if (user.addNetwork(newNetwork)) {
                    System.out.println("You Joined " + newNetwork);
                    System.out.println();
                } else {
                    System.out.println("You Are Already In " + newNetwork);
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Joining Network Failed");
                System.out.println();
            }
        } else {
            if (userNetworkList.isEmpty()) {
                System.out.println("You Are Not In Any Network");
                System.out.println();
            } else {
                drawNetworks(userNetworkList);
                System.out.println("Please Enter Network's Number You Want to Leave");
                int networkIdx = input.nextInt();
                try {
                    String oldNetwork = user.removeNetwork(networkIdx);
                    System.out.println("You Left " + oldNetwork);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("Leaving Network Failed");
                    System.out.println();
                }
            }
        }
    }
}
