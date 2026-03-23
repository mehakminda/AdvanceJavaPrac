B+ trees:
self balancing trees

-----------------------------------------------------------------------------------------------------
Index: Indexes in SQL are special database structures that speed up data retrieval by allowing quick access to records instead of scanning the entire table.

https://www.atlassian.com/data/sql/how-indexing-works

Suppose we have a employee table which column employeeID, employee name, salary, department

salary column is not ordered, now if we want to get something using salary column we have to check each row. So instead of this we will create index on this column

this index will be like a table having column as index(asc/dsc) and row address

-> to check all the indexes created on a table (SQL server) we can use stored procedure/GUI
  execute sp_helpindex <table_name> -> sql server
     SHOW INDEXES FROM table_name;



Types of index

1. Clustered index:
unique indexes.
determines how/in what order the data is stored in the table.
primary key constraints creates a clustered index automatically if a clustered index doesn't exists

if our insertion data in not in increasing order of id, yet it gets inserted in ASC order, its because clustered index exists on id column.

any table can have only 1 clustered index. But this clustered index can have multiple columns(composite clustered index).
 -> create clustered index IX_<tablename>_<col1>_<col2> ON <tablename> (<col1> DESC, <col2> ASC)
	
2. nonclustered index:
data is stored in one place(one table) and index is stored in another place(another table)
this nonclustered index table has column, index key and row address.
since the nonclustered index is stored in separate table. a table can have more than 1 nonclustered index
in index table, the data can be stored in asc/desc order of the index key, which doesn't in anyway influence the storage of data in the table

this non-clustered index can have multiple columns(composite nonclustered index).

clustered index is faster than nonclustered
non-clustered index requires extra storage space.

3. Unique index:

Unique constraint and unique index is one and same thing

4. Non-unique index:













--------------------------------------------------------------------------------------------------------
JOINS:
