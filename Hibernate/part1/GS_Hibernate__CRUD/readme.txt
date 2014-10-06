openSession vs CurrentSession

When you create a hibernate session using any of the sessionFactory.openSession(...) methods the session factory will 'bind' the session to the current context. The default context is 'thread' which means the sesion factory will bind the session to the thread from which openSession(...) is called.
This is useful because you can later call sessionFactory.getCurrentSession() which will return the session that is bound to the currently running thread.

http://stackoverflow.com/questions/8046662/hibernate-opensession-vs-getcurrentsession







get vs load

1. session.load()
It will always return a “proxy” (Hibernate term) without hitting the database. In Hibernate, proxy is an object with the given identifier value, its properties are not initialized yet, it just look like a temporary fake object.
If no row found , it will throws an ObjectNotFoundException.
Get method never returns a proxy, it either returns null or fully initialized Object, while load() method may return proxy, which is the object with ID but without initializing other properties, which is lazily initialized. If you are just using returned object for creating relationship and only need Id then load() is the way to go.
Read more: http://javarevisited.blogspot.com/2012/07/hibernate-get-and-load-difference-interview-question.html#ixzz2WzTySJvX

2. session.get()
It always hit the database and return the real object, an object that represent the database row, not proxy.
If no row found , it return null.
