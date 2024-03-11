package lian.search;

import lian.user.User;
import lian.video.Video;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchMapper {
    User searchUserById(int userId);
    List<Video> searchUserByVideoId(int VideoId);
    List<Video> searchUserByYear(int year);
    List<Video> searchUserByType(String type);
    List<Video> searchUserByTime(LocalDateTime uploadTime);
    int insertHistory(SearchHistory searchHistory);
}
