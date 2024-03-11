package lian.search;
import java.time.LocalDateTime;

public class SearchHistory {
    public int userId;
    public String searchKeyword;
    public LocalDateTime searchTime;

    public SearchHistory(int userId, String searchKeyword) {
        this.userId = userId;
        this.searchKeyword = searchKeyword;
        this.searchTime = LocalDateTime.now();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public LocalDateTime getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(LocalDateTime searchTime) {
        this.searchTime = searchTime;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "userId=" + userId +
                ", searchKeyword='" + searchKeyword + '\'' +
                ", searchTime=" + searchTime +
                '}';
    }

    public SearchHistory() {
    }
}
