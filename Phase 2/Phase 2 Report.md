## Phase 2 - Design Document
### Updated specification
Our program is a system for a delivery pickup station that receives and holds packages in storage until pickup. The station employees are users of the system, each with a unique username and password to log in,  both of which are restricted between 4-12 numbers or letters. Each package (item) comes with an identification number, information about its sender and receiver, as well as the type of storage it requires. The employee will input this information in the system and store the package in the vacant location returned. 

We have three types of containers: **locker**, **refrigerator** and **freezer**, depending on the package type. The locker is for package storage at room temperature. The refrigerator stores grocery items under lower temperatures to keep them fresh. The freezer stores frozen items whose storage temperature is under 0 °C. The system has a pre-set series of containers for use.

When someone comes to pick up their package, the user uses the item identification number to look up the location of its container and removes it from the system. During the process, the user must also check the credentials of the receiver and match it to the receiver information attached with the package. In addition, the system will also display whether the receiver needs to pay any storage fees, which only happens if the package has been in storage too long that it has passed its free storage period. Our program also has functionalities to delete the current user, considering employees may resign or for some reason need a new account. A lookup processed item function is included for any inquiries or unexpected situations, this will show all the packages this employee has handled. Finally, there are visualizations for each type of container to see what packages are in each one.

### Design Decision
We made several important decisions during the process of designing our program. 

Firstly, we worked together, scanned the skeleton of the project and decided the workload of each part. After that, we assigned each part of the work to each person. This decision made our whole work in a methodical way. 

A second important decision is about our design pattern. We initially decided to use an iterator as our design pattern. However, when we designed our project, we found that the Iterator pattern could not fit our project. In this case, we decided to change our design pattern from Iterator to facade pattern. 

The third important decision is that we decided to separate our controller into two parts. The aim of this operation is that we want our project to be concise. This could be helpful in case there are some bugs in the future. 

Another important decision is to reduce some functions of our project for Phase 1. Our group designed lots of possible functions of our project at the very beginning, but found some of them are hard to realize. As a result, we decided to reduce some functions of the project and aimed at completing the basic function of the delivery system. 

During Phase 2 period, the most important decision that our group has made is we upgraded the way of searching. We added a user-friendly function that can easily find the situation of every single location. For example, it may contain which item or they may be empty.

### Clean Architecture
A brief scenario walk-through that demonstrates clean architecture:
- **Receive and store package**
  -  `UI` register and login user by input username and password
  - `LoginController` initializes `UserManager` and uses username and password from `UI` to register and login user in usermanager and record currentUser
  - `UI` receives “Deposit item” command and item ID, info and storage requirement, then activates the controller `PickupSystem`
  - `PickupSystem` set the processor to current user by `UserManager` and store the item by `ItemManager`
  - `UserManager` will record the item id to the user’s processed item list
  - `ItemManager` and `ItemStorer`
    - reads package information, checks storage requirement, set store time and expiration time
    - creates a new item by info
    - calls AddItem to store the item in nextVacantLocation provided by specific container
  - The system information is stored in database

- **Pick up package**
  - `UI` reads the item ID provided by people who come in to pick up packages and command “pick up item” by user.
  - `PickupSystem` calls the search method and creates an `ItemManager`
  - The `ItemManager` and `ItemSearcher` search the item by its ID and return item info, item storage location and required fee.
  - `UI` receives “pick up the item” command
  - `PickupSystem` calls the pickup method
  - Then `ItemManager` and `ItemPicker` will call removeItem to remove it from the system and database.     

The `UI` is dependent on `LoginController` and `PickupSystem` from the outer layer to the inner layer, and these two controllers are dependent on use cases `UserManager` and `ItemManager`. `ItemManager` is dependent on the entities item, freezer, locker, and refrigerator, whereas `UserManager` is dependent on the entity user. As a result, each layer is dependent on the layer above it; the Dependency Rule is consistently followed.

### SOLID
We have satisfied the single responsibility for most of our classes. For example, before we put all operations methods such as add, search, store, item all in the `ItemManager` class. Then we use a façade design pattern to adhere to the single responsibility. We create a single class for each responsibility and a façade front called `ItemManager` to keep those responsibilities.  For example, we have a new class, `ItemPicker`, which has a single responsibility for pick-up package operation.

Also, our entity class satisfies the interface segregation principle. The interface inside the entity class package is called `Container`. The interface is small and contains all relevant methods to entity classes. Therefore, the interface is easy to extend and modify.

### Design Pattern
Our group uses a Facade design pattern in our use cases. This is mainly implemented in phase 1 (pull request #17). In phase 0, all responsibilities to operate on items are fulfilled in the `ItemManager` use case. However, this violates the single responsibility principle, as all the responsibilities such as storing items, picking up items and searching items are all in the same class.

To solve this problem, we make the original `ItemManager` class a Facade front. It then delegates its original responsibilities to four classes: `ItemStorer`, `ItemSearcher`, `ItemPicker`, and `ItemTimer`. 

`ItemStorer` is responsible for storing an item. It has the create and add methods, along with several helpers, to fulfill the original responsibility to add items in `ItemManager`. Then the addItem method in `ItemManger` simply calls the create and add methods to add an item. All implementations of the process to add an item are hidden in the `ItemStorer`. 

`ItemTimer`, which is one of our new functions of Phase 2, use calendars to track the time when the item is processed. It automatically calculate the expiration date of an item’s free storage and calculate extra fee. `ItemManager` will call the checkFee method to get the information regarding the timer.
In this case, the complex `ItemManager` is simplified. 

`ItemSearcher` has the search method, and `ItemPicker` has the remove method and several helpers. The searchItem method in `ItemManager` will call search method in `ItemSearcher`, and the removeItem method in `ItemManager` will call search method in `ItemSearcher` and remove method in `ItemPicker`. 
In this way, the complex `ItemManager` is simplified and adheres to the single responsibility principle.

Another design pattern we use is a Simple Factory to create our container classes, the 3 entities. 
Before we implement this pattern, all creations of the instances are done in the `ItemManager`. Now, the `ItemManager` will ask the container factory to create an instance of the entity via the getContainer method. The method will then create the entity based on the input accordingly. 
In this way we separate the responsibility of creating containers from `ItemManager`.

### Progress Report

#### Summary of work since phase 1:
**Everett**: Fix some bugs relating to file storage functions remaining in Phase 1. Add a new storing logic(don’t need to close the program to create new files). Find the bugs & logic problems among use cases, controller, and UI and fix them.

**Juliet**: Added new functionalities (delete user, processed items, and lookup container) to GUI (login page, menu page, and container map). Optimized and integrated GUI appearance and added logo. 

**Alan**: Fixing the controller class pickup system which has functionalities like pick up, remove, search items,  user login, user log out etc.Then split one controller class pick up system into two controller classes, pickup system and login controller. Also write tests for some entities, use case and controller classes.

**Queenie**: Implementing new functionalities (look up processor’s processed item history, delete user) in use cases and controllers. Writing test for use case classes, controller classes and some entity classes

**Jane**: Implement the timer function of our system. (This method will keep track of the time an item is processed and calculate when its free storage expires.) Fix errors, update use cases and entities as required.

**Martin**: Added three visualization classes for three containers (Freezer, Refrigerator, Locker). Optimized and integrated GUI appearance.

#### Link to significant pull request:

**Jane**: Implementing Timer function\
[Timer 1.0 by GJJJJJANE · Pull Request #50 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/50)\
[Timer 1.3 - Bug fixed by GJJJJJANE · Pull Request #52 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/52)

**Everett**: Add the file storage function & refine its logic\
[File 3.333 by Everett02 · Pull Request #28 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/28)\
[File storage logic changed by Everett02 · Pull Request #73 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/73)

**Queenie**: Implementing look up processor’s processed item functionality, delete user functionality & test for use case classes and some entity classes\
[UM+Test x.0 by Waannng · Pull Request #47 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/47)\
[UserManager4.0 and Test by Waannng · Pull Request #14 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/14)

**Juliet**: GUI updated for all new functionalities in phase 2\
[UI update by teiluj · Pull Request #70 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/70)

**Alan**: Both two login and pickup system controller classes.Also some tests of entity classes and controller classes.\
[Alan phase1 branch by alanchen34 · Pull Request #18 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/18)

**Martin**: GUI for basic functions: Search, Extraction, Store, Menu, Login.\
[Merge UI 2.5 by QI777Q · Pull Request #22 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/22)
[Vis closets by QI777Q · Pull Request #77 · CSC207-UofT/course-project-we-tried (github.com)](https://github.com/CSC207-UofT/course-project-we-tried/pull/77)


### Code Organization
Our packaging strategy is by layer. The Repository is the data of the closets (Refrigerator, Freezer, Locker), which contains the items that already exist. It also contains the users’ usernames and passwords. Both data is stored outside the service sector (in a txt file). 
The Controller layer is on the other end, independent from the service as well. It makes the main moves.
The service segment is in between, uses the data and is used by the controller to fulfill a variety of tasks that the controller gives us. 
 
### Use of GitHub Features, Code Style and Documentation:
We made use of the various features of GitHub to facilitate development of our code. We have created and used 18 local branches and made 122 pull requests and 379 commits. Throughout this process, we made sure to leave useful comments to each other’s pull request as well as making approvals if everything is correct. Javadoc is used appropriately throughout the program for better understanding of what our code does. Finally, we eliminated all fixable warnings in our code,  and we have also made sure that all our naming makes sense for other people to understand.

### Refactoring:
We have made efforts to refactor our code in meaningful ways throughout the project. For example, adding the Facade design pattern (#17), simple factory design pattern (#46). We also fixed magic numbers to eliminate code smells (#106).

### Testing :
The test coverage for entities, use cases, controllers is almost _100%_.
We have written java unit tests for all our entity, use case and controller classes except the UI class. Since our graphical user interface allows users to interact with the app using a mouse, writing unit tests for GUI is very difficult. Therefore, we decided to do a manual test for GUI. We perform different sets of operations on the GUI to visually check whether each functionality and graphical elements are fulfilled. 

## Accessibility Report
 
1. For each principle:
- `Equitable Use`: Our program adheres to this principle. The program provides the same means for all users to use, and it will not segregate any users. The username and password verification provides equal provisions for privacy, security, and safety to users.  
- `Flexibility in Use`: We don’t have such features. In the future, features like adjusting font size and color of page can be implemented. We currently depend on clicking, but in the future keyboard access may be provided to adhere to the principle. 
- `Simple and Intuitive Use`: Our design adheres to this principle. Our program is easy to use, all buttons are labelled clearly and the visualization does not require much literacy and language skills. Most important information is emphasized with large fonts, and there are effective promptings.
- `Perceptible information`: Our program uses different colors and font size of buttons to make distinctions between the major function and other support functions. It provides compatibility between Windows and MacOS.
- `Tolerance for Error`: Our program does not end unexpectedly. All actions that may cause exceptions are properly caught to guarantee the smooth flow of the program. There are proper instructions and alert to discourage unwanted behaviors
- `Low Physical Effort`: Our design does not require high physical effort, and it can be used with a minimum of fatigue. There are not many repetitive actions and we can easily navigate between pages without much effort.
- `Size and Space for Approach and Use`: Our program adheres to this principle. Our UI display can be adjusted. So it provides a clear line of sight to important elements for the comfortable use of any seated or standing user. It also provides adequate space for the use of assistive devices or personal assistance.

2. Our program will be mainly marketed to pick up station management teams and employees. This program has its functions specifically designed as a pickup station management system. We expect it to be used following the instructions and basic functions, which will be helpful to support pickup-station workers.

3. This is less likely to be used by people that are not related to package delivery or pick up. As mentioned above, it is a program with specific functions and situations to use. Among employees, the program will be less likely used by people with visual disabilities since its functions largely depend on visual display. 

