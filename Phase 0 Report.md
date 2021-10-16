# Phase 0 Report

### Specification

Our program is a system for a delivery pickup station that receives and holds packages in storage until pick up. It is designed for station employees to operate, and requires identification for them to log in. When a package arrives, the system records its information and identifies the type of storage it requires. There are three kinds of containers: locker for regular items, and refrigerator/freezer for groceries. If there is space left for the required storage, the system returns a location for the employee to put the package in.

When a package is being picked up, its identification number is used to look up the location of its container. If the package is indeed in storage, based on the returned package information, the employee will check the credentials of the receiver. They will also need to check if the package has exceeded its free storage time and ask for a storage fee accordingly. If everything goes well, the package is removed from the system and pick up is successful. In case of inquiries, employees can be looked up to see which packages they were responsible for.

### CRC Model

We have five entity classes,  User, Item, Locker, Freezer and Refrigerator in total. The User is the employee of the system, and the Item is the package. The entity classes Refrigerator, Locker and Freezer all implement the same interface, Container, which contains four methods. 

Moreover, we have two use case classes, ItemManager and Usermanager. ItemManager can store and provide operations on items while the UserManager includes information of each created user(employee) and the corresponding items they are responsible for. 

Besides, we have one controller, Pickupsystem, which calls the relevant use case class ItemManager or UserManager according to the input from the user interface. Lastly, we have two user interface classes, OperationUI and LoginUI. In OperationUI, the client can ask the system to pick up  or receive the packages while the LoginUI is used to login and logout users. In addition, our CRC model is inconsistent with the dependency inversion principle of the solid principles. Each outer layer class depends directly on the inside layer classes. In the future, we plan to add abstraction layers so both higher and lower layers can depend on abstractions.

### Scenario Walk-through
We’ll go through two typical scenarios that provide specific examples of how our project works.

The first is the procedure of receiving and storing the package. The LoginUI will process the information from the system employee and log him in. OperationUI receives item info and activates the controller PickupSystem. It will generate two use cases, UserManager and ItemManager, and check the user status. By calling storeItem in PickupSystem, ItemManager will use the package information to create a new item, then calls the addItem to get the location to store the package. The employee will put the package in the locker accordingly.

In the pick-up procedure, OperationUI receives the item ID provided by the customer. It then calls the pickup method in PickupSystem to create an ItemManager that searches the item by its ID and returns location and storage fee. The employee picks it up and ItemManager calls removeItem to remove it from the system.

### Skeleton Program

In the skeleton program of phase 0, we finished the pick-up function of our delivery system. Specifically, the searchItem method and the removeItem method under Itemmanager. The part is used for searching and picking up an item as shown in DemoMain.java. We manually set up two possible items (i1 and i2) and add them into the lockers(iman). With actions of entering 1 or 2 (may vary as we modify the UI during next phases), users are able to search and pick(optional) the item. We have also designed a unittest for the method RemoveItem. In the test, we check if the method could return the location stored in Item, and if it can be successfully removed after running the method.

In order to keep this use case able to run, we comment part of our controller classes. We also wrote a simplified version of the addItem method, leaving the rest of its functions as Todos.

### Division of Work and Plans for Phase 1

In terms of the division of work for phase 0, we have been working collaboratively with quite even contributions. There wasn’t a clear separation of tasks, meaning that so far everyone has contributed in every part of the project. We did the specification, CRC cards, scenario walk-through, and skeleton program synchronously and with shared documents, so even though certain people were doing the writing, it was while everyone was offering ideas and suggestions. The writing of the progress report was however clearly distributed, with Jane and Alan in charge of the CRC model, Queenie in charge of the scenario walk-through; Everett and Martin in charge of the skeleton program; and Juliet in charge of the specification, summary of current work division, and future plans.

Moving on from phase 0, we have divided the workload as following:

- Implement controller (PickupSystem) and UI (Operation UI & Login UI): Jane and Alan
- Add abstraction layer: Queenie and Juliet
- Read txt add item information: Everett and Martin

### Summary and Open Question

So far, our basic framework of the project is almost complete, including entities, use cases, controllers, and UIs. We have written first drafts of all our entity classes, code for a basic scenario walk-through for a pickup, as well as one unit test to remove an item. The implementation has been going smoothly and we are quite happy with our progress.

An open question we have is regarding the abstraction layers, we are confused about how to add them and we’d really appreciate feedback on that. We are also wondering how design patterns could be implemented in part of our project.
