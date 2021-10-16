# Phase 0 Report

### Specification:

Our program is a system for a delivery pickup station that receives and holds packages in storage until pick up. It is designed for station employees to operate, and requires identification for them to log in. When a package arrives, the system records its information and identifies the type of storage it requires. There are three kinds of containers: locker for regular items, and refrigerator/freezer for groceries. If there is space left for the required storage, the system returns a location for the employee to put the package in.

When a package is being picked up, its identification number is used to look up the location of its container. If the package is indeed in storage, based on the returned package information, the employee will check the credentials of the receiver. They will also need to check if the package has exceeded its free storage time and ask for a storage fee accordingly. If everything goes well, the package is removed from the system and pick up is successful. In case of inquiries, employees can be looked up to see which packages they were responsible for.

### CRC Model:

We have five entity classes,  User, Item, Locker, Freezer and Refrigerator in total. The User is the employee of the system, and the Item is the package. The entity classes Refrigerator, Locker and Freezer all implement the same interface, Container, which contains four methods. 

Moreover, we have two use case classes, ItemManager and Usermanager. ItemManager can store and provide operations on items while the UserManager includes information of each created user(employee) and the corresponding items they are responsible for. 

Besides, we have one controller, Pickupsystem, which calls the relevant use case class ItemManager or UserManager according to the input from the user interface. Lastly, we have two user interface classes, OperationUI and LoginUI. In OperationUI, the client can ask the system to pick up  or receive the packages while the LoginUI is used to login and logout users. In addition, our CRC model is inconsistent with the dependency inversion principle of the solid principles. Each outer layer class depends directly on the inside layer classes. In the future, we plan to add abstraction layers so both higher and lower layers can depend on abstractions.

### Scenario Walk-through:
We’ll go through two typical scenarios that provide specific examples of how our project works.

The first is the procedure of receiving and storing the package. The LoginUI will process the information from the system employee and log him in. OperationUI receives item info and activates the controller PickupSystem. It will generate two use cases, UserManager and ItemManager, and check the user status. By calling storeItem in PickupSystem, ItemManager will use the package information to create a new item, then calls the addItem to get the location to store the package. The employee will put the package in the locker accordingly.

In the pick-up procedure, OperationUI receives the item ID provided by the customer. It then calls the pickup method in PickupSystem to create an ItemManager that searches the item by its ID and returns location and storage fee. The employee picks it up and ItemManager calls removeItem to remove it from the system.


### Skeleton Program:

### Division of Work and Plans for Phase 1:
