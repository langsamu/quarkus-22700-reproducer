Reproduces https://github.com/quarkusio/quarkus/issues/22700

**Fixed by [22615](https://github.com/quarkusio/quarkus/pull/22615) in [2.6.2](https://github.com/quarkusio/quarkus/milestone/169).**

To run:
```bash
$ ./mvnw quarkus:dev
```

To invoke:
```bash
$ curl http://localhost:8080
```

Result:
```
Request failed: java.lang.ClassCastException: class io.vertx.sqlclient.impl.tracing.QueryRequest cannot be cast to class io.vertx.core.spi.observability.HttpRequest (io.vertx.sqlclient.impl.tracing.QueryRequest and io.vertx.core.spi.observability.HttpRequest are in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @1e4a7dd4)
        at io.quarkus.opentelemetry.runtime.tracing.vertx.OpenTelemetryVertxTracer.sendRequest(OpenTelemetryVertxTracer.java:138)
        at io.quarkus.opentelemetry.runtime.tracing.vertx.OpenTelemetryVertxTracer.sendRequest(OpenTelemetryVertxTracer.java:42)
        at io.vertx.sqlclient.impl.tracing.QueryTracer.sendRequest(QueryTracer.java:86)
        at io.vertx.sqlclient.impl.QueryExecutor.executeExtendedQuery(QueryExecutor.java:144)
        at io.vertx.sqlclient.impl.SqlClientBase$PreparedQueryImpl.execute(SqlClientBase.java:155)
        at io.vertx.sqlclient.impl.SqlClientBase$PreparedQueryImpl.execute(SqlClientBase.java:151)
        at io.vertx.sqlclient.impl.SqlClientBase$QueryImpl.execute(SqlClientBase.java:109)
        at io.vertx.mutiny.sqlclient.PreparedQuery.lambda$execute$1(PreparedQuery.java:94)
        at io.smallrye.context.impl.wrappers.SlowContextualConsumer.accept(SlowContextualConsumer.java:21)
        at io.smallrye.mutiny.vertx.AsyncResultUni.subscribe(AsyncResultUni.java:31)
        at io.smallrye.mutiny.operators.AbstractUni.subscribe(AbstractUni.java:36)
        at io.smallrye.mutiny.operators.uni.UniOnItemTransform.subscribe(UniOnItemTransform.java:22)
        at io.smallrye.mutiny.operators.AbstractUni.subscribe(AbstractUni.java:36)
        at io.smallrye.mutiny.operators.uni.UniOnItemTransform.subscribe(UniOnItemTransform.java:22)
        at io.smallrye.mutiny.operators.AbstractUni.subscribe(AbstractUni.java:36)
        at io.smallrye.mutiny.groups.UniSubscribe.withSubscriber(UniSubscribe.java:50)
        at io.smallrye.mutiny.groups.UniSubscribe.with(UniSubscribe.java:90)
        at org.jboss.resteasy.reactive.server.handlers.UniResponseHandler.handle(UniResponseHandler.java:17)
        at org.jboss.resteasy.reactive.server.handlers.UniResponseHandler.handle(UniResponseHandler.java:8)
        at org.jboss.resteasy.reactive.common.core.AbstractResteasyReactiveContext.run(AbstractResteasyReactiveContext.java:141)
        at org.jboss.resteasy.reactive.server.handlers.RestInitialHandler.beginProcessing(RestInitialHandler.java:49)
        at org.jboss.resteasy.reactive.server.vertx.ResteasyReactiveVertxHandler.handle(ResteasyReactiveVertxHandler.java:17)
        at org.jboss.resteasy.reactive.server.vertx.ResteasyReactiveVertxHandler.handle(ResteasyReactiveVertxHandler.java:7)
        at io.vertx.ext.web.impl.RouteState.handleContext(RouteState.java:1193)
        at io.vertx.ext.web.impl.RoutingContextImplBase.iterateNext(RoutingContextImplBase.java:163)
        at io.vertx.ext.web.impl.RoutingContextImpl.next(RoutingContextImpl.java:141)
        at io.quarkus.vertx.http.runtime.VertxHttpRecorder$5.handle(VertxHttpRecorder.java:362)
        at io.quarkus.vertx.http.runtime.VertxHttpRecorder$5.handle(VertxHttpRecorder.java:340)
        at io.vertx.ext.web.impl.RouteState.handleContext(RouteState.java:1193)
        at io.vertx.ext.web.impl.RoutingContextImplBase.iterateNext(RoutingContextImplBase.java:163)
        at io.vertx.ext.web.impl.RoutingContextImpl.next(RoutingContextImpl.java:141)
        at io.quarkus.vertx.http.runtime.devmode.VertxHttpHotReplacementSetup$5.handle(VertxHttpHotReplacementSetup.java:196)
        at io.quarkus.vertx.http.runtime.devmode.VertxHttpHotReplacementSetup$5.handle(VertxHttpHotReplacementSetup.java:185)
        at io.vertx.core.impl.future.FutureImpl$3.onSuccess(FutureImpl.java:141)
        at io.vertx.core.impl.future.FutureBase.lambda$emitSuccess$0(FutureBase.java:54)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:164)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:469)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:503)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:986)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:829)
```
