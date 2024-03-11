package lian.comment;

import lian.video.Video;
import lian.comment.*;
public interface CommentMapper {
    int addComment(Comment comment);
    int replyComment(Comment comment);
}
