package tv.codely.mooc.api.controller.comment

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import tv.codely.mooc.comment.application.create.CommentCreator
import tv.codely.mooc.comment.domain.{CommentBody, CommentId, CommentTitle}
import tv.codely.mooc.shared.domain.user.UserId

final class CommentPostController(creator: CommentCreator) {

  def post(id: String, title: String, body: String, creatorId:String): StandardRoute = {
    creator.create(CommentId(id), CommentTitle(title), CommentBody(body), UserId(creatorId))

    complete(HttpResponse(NoContent))
  }

}
