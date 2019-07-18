package tv.codely.mooc.api

import tv.codely.mooc.api.controller.comment.{CommentGetController, CommentPostController}
import tv.codely.mooc.api.controller.status.StatusGetController
import tv.codely.mooc.api.controller.user.{UserGetController, UserPostController}
import tv.codely.mooc.api.controller.video.{VideoGetController, VideoPostController}
import tv.codely.mooc.comment.infrastructure.dependency_injection.CommentModuleDependencyContainer
import tv.codely.mooc.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.mooc.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

final class EntryPointDependencyContainer(
    userDependencies: UserModuleDependencyContainer,
    videoDependencies: VideoModuleDependencyContainer,
    commentDependencies: CommentModuleDependencyContainer
) {
  val statusGetController = new StatusGetController

  val userGetController  = new UserGetController(userDependencies.usersSearcher)
  val userPostController = new UserPostController(userDependencies.userRegistrar)

  val videoGetController  = new VideoGetController(videoDependencies.videosSearcher)
  val videoPostController = new VideoPostController(videoDependencies.videoCreator)

  val commentGetController = new CommentGetController(commentDependencies.commentSearcher)
  val commentPostController = new CommentPostController(commentDependencies.commentCreator)
}
