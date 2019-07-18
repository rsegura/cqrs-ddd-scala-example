package tv.codely.mooc.api.controller.comment

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.StandardRoute
import akka.http.scaladsl.server.Directives.complete
import spray.json.DefaultJsonProtocol
import tv.codely.mooc.comment.application.search.CommentSearcher
import tv.codely.mooc.comment.infrastructure.marshaller.CommentJsonFormatMarshaller._

final class CommentGetController(searcher: CommentSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())

}
