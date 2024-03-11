package lian.video;

import java.util.List;

public interface VideoMapper {
    int uploadVideo(Video video);
    int viewVideo(int videoId);

    int deleteVideoById(int videoId);
    int deleteCommentsByVideoId(int videoId);

    List<Video> sortByViewsCount();
    List<Video> sortByuploadTime();
}

