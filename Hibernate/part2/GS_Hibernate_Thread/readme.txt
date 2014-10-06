c3po http://www.mchange.com/projects/c3p0/#what_is

http://www.mkyong.com/hibernate/how-to-configure-the-c3p0-connection-pool-in-hibernate/




http://stackoverflow.com/questions/9802684/hibernate-config-connection-pool-size

From the Hibernate API Docs (http://docs.jboss.org/hibernate/orm/3.3/reference/en/html/session-configuration.html#configuration-hibernatejdbc).

Hibernate's own connection pooling algorithm is, however, quite rudimentary.
It is intended to help you get started and is not intended for use in a production system, or even for performance testing.
You should use a third party pool for best performance and stability. Just replace the hibernate.connection.pool_size property with connection pool specific settings.
 This will turn off Hibernate's internal pool. For example, you might like to use c3p0.

connection.pool_size indicates the maximum number of pooled connections.
So it is better to keep it at a logical count. It depends on your application and DB how much it can handle.
10 is a reasonable count that will typically used as it is sufficient for most cases.