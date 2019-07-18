package tv.codely.mooc.comment.application.search

import tv.codely.mooc.comment.domain.{Comment, CommentRepository}

import scala.concurrent.Future

final class CommentSearcher(repository: CommentRepository) {
    def all(): Future[Seq[Comment]] = repository.all()
}
