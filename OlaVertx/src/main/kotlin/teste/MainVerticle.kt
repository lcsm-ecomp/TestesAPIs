package teste

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.*

class MainVerticle : AbstractVerticle() {

  override fun start() {
    val server = vertx.createHttpServer()

    val router = Router.router(vertx)

    router.route("/ola.txt").handler {
        it.response().end("ola para todos")
    }
    
    router.route().handler(StaticHandler.create());
    
    /*router.route().handler { req ->
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!")
      }
    */
    server.requestHandler(router)  
      .listen(8888)

  }
}
