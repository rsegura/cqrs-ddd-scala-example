package tv.codely.mooc.comment.infrastructure.repository

import doobie.implicits._
import tv.codely.mooc.comment.domain.{Comment, CommentRepository}
import tv.codely.shared.infrastructure.doobie.DoobieDbConnection

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMySqlCommentRepository(db: DoobieDbConnection) (implicit executionContext: ExecutionContext)
  extends CommentRepository{

  override def all(): Future[Seq[Comment]] =
    db.read(sql"SELECT comment_id, title, body, creator_id FROM comments".query[Comment].to[Seq] )

  override def save(comment: Comment): Future[Unit] =
    sql"INSERT INTO comments(comment_id, title, body, creator_id) VALUES(${comment.id}, ${comment.title}, ${comment.body}, ${comment.creatorId})".update.run
    .transact(db.transactor)
    .unsafeToFuture()
    .map(_ =>())
}
