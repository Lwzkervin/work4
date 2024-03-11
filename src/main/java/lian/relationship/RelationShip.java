package lian.relationship;

public class RelationShip {
    int userId;
    int followedUserId;

    @Override
    public String toString() {
        return "RelationShip{" +
                "user_id=" + userId +
                ", followed_user_id=" + followedUserId +
                '}';
    }

    public RelationShip(int userId, int followedUserId) {
        this.userId = userId;
        this.followedUserId = followedUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(int followedUserId) {
        this.followedUserId = followedUserId;
    }
}
