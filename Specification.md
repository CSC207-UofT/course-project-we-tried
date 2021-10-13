## Specification

This file is for specification.

Our program is a system for a delivery pickup station that receives and holds packages in storage until pickup. The station employees are users of the system, each with a unique username and password to log in. Each package (item) comes with an identification number, information about its sender and receiver, as well as the type of storage it requires. Based on this information, the system provides a suitable container for the user to store the package in.

We have three types of containers: locker, refrigerator and freezer, depending on the package type. The locker is for package storage at room temperature. The refrigerator stores grocery items under lower temperatures to keep them fresh. The freezer stores frozen items whose storage temperature is under 0 °C.  For each type of container, we can access the information of the capacity of the container, the number of items stored in the container, the number of empty storage spaces and verify whether the chosen location of the container has an item.

When someone comes to pick up their package, the user uses the item identification number to look up the location of its container and removes it from the system. During the process, the user must also check the credentials of the receiver and whether the item has exceeded its free storage time that requires a storage fee (fine). Since there can be multiple employees in the station, we can also look up the items each is responsible for when needed. 
