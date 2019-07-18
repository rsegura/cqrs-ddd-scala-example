package tv.codely.mooc.comment.domain

import scala.concurrent.Future

trait CommentRepository {
  def all(): Future[Seq[Comment]]
  def save(comment: Comment): Future[Unit]
}
