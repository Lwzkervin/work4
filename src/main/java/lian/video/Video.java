package lian.video;

import java.time.LocalDateTime;
import java.util.List;

public class Video {
    public int videoId;
    public String videoUrl;
    public String description;
    public LocalDateTime uploadTime;
    public int  viewsCount;
    public int userId;
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Video(int videoId, String videoUrl, String description, int userId) {
        this.videoId = videoId;
        this.videoUrl = videoUrl;
        this.description = description;
        this.uploadTime = LocalDateTime.now();
        this.viewsCount = 0;
        this.userId = userId;
    }
    public Video() {

    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", videoUrl='" + videoUrl + '\'' +
                ", description='" + description + '\'' +
                ", uploadTime=" + uploadTime +
                ", viewsCount=" + viewsCount +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                '}';
    }
}
