package lian.comment;

import java.time.LocalDateTime;
import lian.video.*;

public class Comment {
    int videoId;
    int userId;
    String commentText;
    int parentCommentId;
    LocalDateTime commentTime;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public Comment(int videoId, int userId, String commentText) {
        this.videoId = videoId;
        this.userId = userId;
        this.commentText = commentText;
        this.commentTime = LocalDateTime.now();
    }

    public Comment(int videoId, int userId, String commentText, int parentCommentId) {
        this.videoId = videoId;
        this.userId = userId;
        this.commentText = commentText;
        this.parentCommentId = parentCommentId;
        this.commentTime = LocalDateTime.now();
    }
}
