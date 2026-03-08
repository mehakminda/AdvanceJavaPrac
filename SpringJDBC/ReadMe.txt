when to user custom queries vs finder methods?

custom query:
Complex logic or multiple conditions: When a query involves many AND or OR conditions, the method name becomes long and unreadable (a "paragraph"), making a custom @Query annotation a better choice for clarity.

You can select only a few columns or a specific Data Transfer Object (DTO), rather than the entire entity, which can improve performance by retrieving less data from the database.

finder method(Derived Query Methods):  For basic CRUD operations or simple conditional searches

------------------------------------------------------------------------------------------------------------------
when to use crudrepository and when to use jpa repository?

Use the CrudRepository when you only require basic Create, Read, Update, and Delete operations and desire a generic, persistence-agnostic interface. Use the JpaRepository (which extends CrudRepository) when you need additional JPA-specific features like pagination, sorting, batch operations, or immediate flushing of the persistence context. 


------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
