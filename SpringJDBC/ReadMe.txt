when to user custom queries vs finder methods?

custom query:
Complex logic or multiple conditions: When a query involves many AND or OR conditions, the method name becomes long and unreadable (a "paragraph"), making a custom @Query annotation a better choice for clarity.

You can select only a few columns or a specific Data Transfer Object (DTO), rather than the entire entity, which can improve performance by retrieving less data from the database.

finder method(Derived Query Methods):  For basic CRUD operations or simple conditional searches

------------------------------------------------------------------------------------------------------------------
when to use crudrepository and when to use jpa repository


------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
