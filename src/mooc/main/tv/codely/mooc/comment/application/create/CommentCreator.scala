package tv.codely.mooc.comment.application.create

import tv.codely.mooc.comment.domain._
import tv.codely.mooc.shared.domain.user.UserId

final class CommentCreator(repository: CommentRepository) {

  def create(
    id: CommentId,
    title: CommentTitle,
    body: CommentBody,
    creatorId: UserId
  ): Unit = {
    val comment = Comment(id, title, body, creatorId)

    repository.save(comment)
  }
}
