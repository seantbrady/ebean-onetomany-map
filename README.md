The purpose of this project is to demonstrate a possible bug in Ebean.  This is a play project that can be run at the command line after downloading Play 2.0.x.  Simply run "play test" to see the following error:

models.Role cannot be cast to java.util.Map$Entry
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.saveAssocManyDetails(DefaultPersister.java:877)
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.saveMany(DefaultPersister.java:799)
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.saveAssocMany(DefaultPersister.java:704)
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.update(DefaultPersister.java:442)
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.saveEnhanced(DefaultPersister.java:343)
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.saveRecurse(DefaultPersister.java:315)
[error]     at com.avaje.ebeaninternal.server.persist.DefaultPersister.save(DefaultPersister.java:282)
[error]     at com.avaje.ebeaninternal.server.core.DefaultServer.save(DefaultServer.java:1577)
[error]     at com.avaje.ebeaninternal.server.core.DefaultServer.save(DefaultServer.java:1567)
[error]     at com.avaje.ebean.Ebean.save(Ebean.java:538)
