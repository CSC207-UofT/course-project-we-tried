# Phase 1 - Design Document
### Updated specification
Our program is a system for a delivery pickup station that receives and holds packages in storage until pickup. The station employees are users of the system, each with a unique username and password to log in. Each package (item) comes with an identification number, information about its sender and receiver, as well as the type of storage it requires. Based on this information, the system provides a suitable container and a vacant location for the user to store the package in.\
\
We have three types of containers: locker, refrigerator and freezer, depending on the package type. The locker is for package storage at room temperature. The refrigerator stores grocery items under lower temperatures to keep them fresh. The freezer stores frozen items whose storage temperature is under 0 °C. The system has a pre-set series of containers for use.\
\
When someone comes to pick up their package, the user uses the item identification number to look up the location of its container and removes it from the system. During the process, the user must also check the credentials of the receiver and match it to the receiver information attached with the package.

### Design Decision
We made several important decisions during the process of designing our program. Firstly, we worked together, scanned the skeleton of the project and decided the workload of each part. After that, we assigned each part of the work to each person. This decision made our whole work in a methodical way. A second important decision is about our design pattern. We initially decided to use an iterator as our design pattern. However, when we designed our project, we found that the Iterator pattern could not fit our project. In this case, we decided to change our design pattern from Iterator to facade pattern. The third important decision is that we decided to separate our controller into two parts. The aim of this operation is that we want our project to be concise which could be helpful in case there are some bugs in the future. Another important decision is to reduce some functions for Phase 1. Our group designed lots of possible functions of our project at the very beginning, but found some of them are hard to realize. As a result, we decided to reduce some functions of the project and aimed at completing the basic function of the delivery system.

### Clean Architecture
A brief scenario walk-through that demonstrates clean architecture:\
\
Receive and store package
  - UI register and login user by input username and password
  - LoginController initializes UserManager and uses username and password from UI to register and login user in usermanager and record currentUser.
  - UI receives “Deposit item” command and typed-in item ID, info and storage requirement and activates controller PickupSystem
  - PickupSystem uses UserManager to get the processor and ItemManager to store the item
  - ItemManager and ItemStorer
    - reads package information, checks storage requirement
    - creates a new item by info
    - calls AddItem to store the item in nextVacantLocation provided by container

\
Pick up package
- UI reads the item ID provided by people who come in to pick up packages and command “pick up item” by user.
- PickupSystem calls the search method and creates an ItemManager
- The ItemManager and ItemSearcher search the item by its ID and return string that contains the item storage location.
- UI receives “pick up the item” command
- PickupSystem calls the pickup method
- Then ItemManager and ItemPicker will call removeItem to remove it from the system.


From the outer layer to the inner layer, the UI is dependent on LoginController and PickupSystem, and these two controllers are dependent on use cases UserManager and ItemManager. UserManager is dependent on the entity user, while ItemManager is dependent on the entities: item, freezer, locker, and refrigerator. As a result, each layer is dependent on its neighbouring layer; the Dependency Rule is consistently followed.

### SOLID
We have satisfied the single responsibility for most of our classes. For example, before we put all operations methods such as add, search, store, item all in the ItemManager class. Then we use a façade design pattern to adhere to the single responsibility. We create a single class for each responsibility and a façade front called ItemManager to keep those responsibilities.  For example, we have a new class, ItemPicker, which has a single responsibility for pick-up package operation.\
\
Also, our entity class satisfies the interface segregation principle. The interface inside the entity class package is called Container. The interface is small and contains all relevant methods to entity classes. Therefore, the interface is easy to extend and modify.

### Design Pattern
Our group uses a Facade design pattern in our use cases. In phase 0, all responsibilities to operate on items are fulfilled in the ItemManager use case. However, this violates the single responsibility principle, as all the responsibilities such as storing items, picking up items and searching items are all in the same class.\
\
To solve this problem, we make the original ItemManager class a Facade front. It then delegates its original responsibilities to four classes: ItemStorer, ItemSearcher, ItemPicker, and ItemTimer(this will be implemented in Phase 2).\
\
ItemStorer is responsible for storing an item. It has the create and add methods, along with several helpers, to fulfill the original responsibility to add items in itemManager. Then the addItem method in ItemManger simply calls the create and add methods to add an item. All implementations of the process to add an item are hidden in the ItemStorer.\
\
ItemSearcher has the search method, and ItemPicker has the remove method and several helpers. The searchItem method in ItemManager will call search method in ItemSearcher, and the removeItem method in ItemManager will call search method in ItemSearcher and remove method in ItemPicker.\
\
In this way, the complex ItemManager is simplified and adheres to the single responsibility principle.\
\
In Github, this implementation is roughly done through the pull request Design pattern Completed #17, with some modifications in the following pull requests to add some features and to guarantee that it works as expected.\
\
In the future, we plan to implement more design patterns. One possible choice is the observer design pattern. Since currently our program does not provide access from outside to the information of the containers, it’s hard to track the containers’ contents and how they change as we add or remove items. An observer design pattern may help us deal with this problem by allowing notifications to outside each time our container is modified. However, this pattern may not be the best solution as we don’t have many observers but multiple items to be observed.

### Progress Report
The first open question we have is that we aren’t able to get IntelliJ to show our code coverage. Secondly, there are still some problems with our serialization that cause our program to not run as well as we’d hoped. We speculate that this is due to some errors when overwriting the files.\
\
Nevertheless, by using packaging by layer and dividing the work accordingly, our responsibilities and communication have been very clear and effective. Our project design overall is quite easy to understand. Everyone has contributed evenly to phase 1 of our project. Jane was responsible for the ItemManager part of the use case layer as well as implementing the Façade design pattern. Queenie was responsible for the UserManager part of the use case layer and testing. Alan was responsible for the controller layer and testing. Juliet was responsible for the Login and Menu pages of the UI. Martin was responsible for the extraction, search, and store aspects of the UI. Finally, Everett was responsible for the read file function as well as data serialization.\
\
Moving on into Phase 2, we have divided the remaining work as following:\
Add reverse search function (use item location to search item) - Jane\
Add fee features - Queenie\
Add search vacancy function - Alan\
Add search processor function to return handled items - Martin \
Delete registered user - Everett\
Improve UI format and appearance - Juliet\
\
In addition, everyone will be responsible for adding and improving styling and documentation of the classes they implemented, as well as refactoring in a meaningful way.

