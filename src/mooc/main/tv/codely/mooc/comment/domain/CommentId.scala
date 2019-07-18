package tv.codely.mooc.comment.domain

import java.util.UUID

object CommentId{
  def apply(value: String): CommentId = new CommentId(UUID.fromString(value))
}

case class CommentId (value: UUID)
