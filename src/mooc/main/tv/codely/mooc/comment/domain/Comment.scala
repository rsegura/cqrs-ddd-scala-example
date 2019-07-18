package tv.codely.mooc.comment.domain

import tv.codely.mooc.shared.domain.user.UserId

object Comment {
  def apply(id: String, title: String, body: String, userId:String): Comment =
    Comment(
      CommentId(id),
      CommentTitle(title),
      CommentBody(body),
      UserId(userId))
}

case class Comment(id: CommentId, title: CommentTitle, body: CommentBody, creatorId: UserId)
