package com.example;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.RowIterator;
import io.vertx.mutiny.sqlclient.RowSet;

import java.time.OffsetDateTime;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
class ExampleResource {
    @Inject
    PgPool storage;

    @GET
    public Uni<OffsetDateTime> get() {
        return storage
                .preparedQuery("SELECT NOW()")
                .mapping(row -> row.getOffsetDateTime(0))
                .execute()
                .map(RowSet::iterator)
                .map(RowIterator::next);

        // This works (not using Postgres)
//        return Uni.createFrom().item(OffsetDateTime.now());
    }
}
