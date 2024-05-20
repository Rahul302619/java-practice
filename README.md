# java-practice
Java interview and hackthon questions

Singleton -> java.lang.Runtime#getRuntime()
-> We can use this design pattern to implement custom Cache class

Prototype -> java.lang.Object#clone()
-> Spring boot prototype scope bean is different then this design pattern because in spring boot 
on request each and every time we get the new prototype scope bean with default state but in this
DP we clone the existing state while creating the new object, we can use this with immutable class.

Builder -> java.lang.StringBuilder or java.lang.StringBuffer
-> If we have complex object than for creating object based on different different member variable
we use this design pattern.

Adapter -> java.util.Arrays#asList()
-> Suppose API need to provide EmpResponse as the output and we are fetching EmployeeEntity from DB
then we need to use this design pattern to convert object from EmployeeEntity to EmpResponse.

Factory -> java.util.Calendar#getInstance()
->DashboardViewFetcher -> BsuDVF, CcuDVF, RmDVF -> based on user type provide the different object.

Proxy -> java.rmi.Remote

Collection -
ArrayList -> Array 
-> get() {O(1)} because store object in the memory so by using the index we can directly fetch the object
-> add() or remove() {at the end-O(1), in the middle-O(n) + sifting of element}

LinkedList -> Doubly linked list 
-> get() {O(n)} because need to find the object by traversing through the list
-> add() or remove() {at the end-O(1), in the middle-O(n) for locating the element but no sifting of element}
