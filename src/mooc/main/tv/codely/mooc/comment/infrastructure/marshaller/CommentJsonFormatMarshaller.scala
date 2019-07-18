package tv.codely.mooc.comment.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import tv.codely.mooc.comment.domain.{Comment, CommentBody, CommentId, CommentTitle}
import tv.codely.mooc.shared.domain.user.UserId

object CommentJsonFormatMarshaller extends DefaultJsonProtocol{
  implicit val commentFormat: RootJsonFormat[Comment] = jsonFormat(
    Comment.apply(_:CommentId, _:CommentTitle, _:CommentBody, _:UserId),
    "id",
    "title",
    "body",
    "creator_id"
  )

}
