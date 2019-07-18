package tv.codely.mooc.comment.infrastructure.dependency_injection

import tv.codely.mooc.comment.application.create.CommentCreator
import tv.codely.mooc.comment.application.search.CommentSearcher
import tv.codely.mooc.comment.domain.CommentRepository
import tv.codely.mooc.comment.infrastructure.repository.DoobieMySqlCommentRepository
import tv.codely.shared.infrastructure.doobie.DoobieDbConnection

import scala.concurrent.ExecutionContext

final class CommentModuleDependencyContainer (
      doobieDbConnection: DoobieDbConnection
) (implicit executionContext: ExecutionContext) {
  val repository: CommentRepository = new DoobieMySqlCommentRepository(doobieDbConnection)

  val commentSearcher : CommentSearcher = new CommentSearcher(repository)
  val commentCreator: CommentCreator = new CommentCreator(repository)

}
