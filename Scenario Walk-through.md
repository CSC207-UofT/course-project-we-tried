## Scenario Walk-Through

### Receive and store package
Package arrives with the following information:

    ID: 207
    Item info: CSC (SenderName),
               6666 (SenderNumber),
               WeTried (ReceiverName),
               5415454321 (ReceiverNumber),
               This is a package! (Description)
    Storage requirement: L (Locker)

`LoginUI` reads username and password that the employee types in and calls the controller.
`OperationUI` reads item information and actions (store item) input by the login user and calls the controller to do the operations.

The controller `PickupSystem` creates new `UserManager` and `ItemManager` instances.

`UserManager` uses _userLogin_ to check user status, and _recordUser_ to record this user for further action related to items.

`PickupSystem` calls _storeItem_ method and makes operations with `ItemManager`.

`ItemManager` will:
- read package information, check storage requirement
- create a new item by info
- call _addItem_, get nextVacantLocation via `Locker`
- store the item in `Locker` at this location


### Pick up package
`OperationUI` reads the item ID provided by people who come in to pick up packages and actions (pick up) input by the user.

`PickupSystem` calls _pickup_ method and creates a use case instance of `ItemManager` with item information.

The `ItemManager` calls _searchItem_ to search the item by its ID and return string that contains item location and needed storage fee.

Then `ItemManager` will call removeItem to remove it from the system.
     

