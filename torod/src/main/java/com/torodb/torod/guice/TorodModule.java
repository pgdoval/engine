
package com.torodb.torod.guice;

import akka.actor.ActorSystem;
import akka.dispatch.ExecutionContexts;
import akka.stream.ActorMaterializer;
import akka.stream.ActorMaterializerSettings;
import akka.stream.Materializer;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.torodb.core.dsl.backend.BackendTransactionJobFactory;
import com.torodb.torod.pipeline.InsertPipelineFactory;
import com.torodb.torod.pipeline.akka.AkkaInsertSubscriberFactory;
import java.util.concurrent.ExecutorService;

/**
 *
 */
public class TorodModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides @Singleton @TorodLayer
    ActorSystem createTorodActorSystem(@TorodLayer ExecutorService executorService) {
        return ActorSystem.create("torod-layer", null, null,
                ExecutionContexts.fromExecutorService(
                        executorService
                )
        );
    }

    @Provides @Singleton
    InsertPipelineFactory createPipelineFactory(@TorodLayer ActorSystem actorSystem,
            BackendTransactionJobFactory backendTransactionJobFactory) {
        Materializer materializer = ActorMaterializer.create(ActorMaterializerSettings.create(actorSystem), actorSystem, "insert");

        return new AkkaInsertSubscriberFactory(materializer, backendTransactionJobFactory, 100);
    }

}
