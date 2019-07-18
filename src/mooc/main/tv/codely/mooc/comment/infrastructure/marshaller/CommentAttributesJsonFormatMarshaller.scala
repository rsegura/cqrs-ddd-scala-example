package tv.codely.mooc.comment.infrastructure.marshaller

import java.util.UUID

import spray.json.{DeserializationException, JsNumber, JsString, JsValue, JsonFormat, _}
import tv.codely.mooc.comment.domain._

object CommentAttributesJsonFormatMarshaller {
  implicit object CommentIdMarshaller extends JsonFormat[CommentId]{
    override def write(value: CommentId): JsValue = value.value.toJson

    override def read(value: JsValue): CommentId = CommentId(value.convertTo[UUID])
  }

  implicit object VideoTitleMarshaller extends JsonFormat[CommentTitle] {
    override def write(value: CommentTitle): JsValue = JsString(value.value)

    override def read(value: JsValue): CommentTitle = value match {
      case JsString(title) => CommentTitle(title)
      case _              => throw DeserializationException("Expected 1 string for CommentTitle")
    }
  }

  implicit object VideoBodyMarshaller extends JsonFormat[CommentBody] {
    override def write(value: CommentBody): JsValue = JsString(value.value)

    override def read(value: JsValue): CommentBody = value match {
      case JsString(body) => CommentBody(body)
      case _              => throw DeserializationException("Expected 1 string for CommentBody")
    }
  }

}
