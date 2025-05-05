package uga.lroc.cs4370.models;

public class User {

    public final String userId;
    private final String firstName;
    private final String lastName;
    private final String profileImagePath;

    public User(String userId, String firstName, String lastName, String profileImagePath) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImagePath = profileImagePath;
    }

    public User(String userId, String firstName, String lastName) {
        this(userId, firstName, lastName, getAvatarPath(userId));
    }

    private static String getAvatarPath(String userId) {
        int fileNo = (userId.hashCode() % 20) + 1;
        String avatarFileName = String.format("avatar_%d.png", fileNo);
        return "/avatars/" + avatarFileName;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }
}
