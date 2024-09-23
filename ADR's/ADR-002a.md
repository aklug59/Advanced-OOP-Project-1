# 2a: Consolidation and Separation of Positional State

**Status:** Implemented with additional enhancements pending. The additional enhancements will receive a second Architectural Design Record (number 2b).

To aid in following along with the specific versions being identified, the original version (most recent existing version, prior to changes) is commit 10099f65f001e715fec30056d2f66446b5e77074, and the modified version (oldest version impacted directly by the decision, after any changes) is commit a0815ca952e4f5cb591b42d7752c6b5c2b725d49.
Some unrelated changes will also be shown in git diffs, since these were done in between the start and end versions as we were getting up to speed with the project.

## Context/Forces at Play

One of the main requirements of this project is a way for the currently selected rover to be able to understand where it is currently.
Initially, we had implemented a few static properties to perform this duty.
We had a single `char` that represented the current heading which could either be "N", "E", "S", or "W"; representing the cardinal directions "North", "East", "South", and "West", respectively.
We also had an array of two `int`s that represented the current x and y position.
The `int` at index 0 represented the x coordinate, and the `int` at index 1 represented the y coordinate.
Furthermore, we had an array of the possible heading values expressed as an array of `char`s.

Empty data was provided for these properties prior to initialisation through the Rover's only constructor which takes an `ArrayList` of `Character` to initialise the array, with the elements corresponding to the initial x coordinate, the initial y coordinate, and the initial cardinal direction.
Extraneous elements in this `ArrayList` are ignored and exceptions are thrown when there is missing data.
Incorrectly formatted data for the initial x and y coordinates results in the value -1 being substituted for the incorrectly formatted coordinate(s) in question.
Values for the cardinal direction that are outside the valid values are stored without being checked.
This version of the code requires messy for loops and if statements to determine the current heading and update it according to any received commands to turn right and left.
Additionally, this version also had all the movement code within the rover class's determination as to which command it is currently processing.
As such, the code in the Rover class was—as of the original version—very difficult to understand at first glance, and to navigate.
Seeing the presence of this issue, Trevor Hafner proposed an initial consolidation which was later expanded to become an encapsulation of the code that manages the actions to be done considering the current command in use.

## Decision

The decision was to consolidate the positional information for the `Rover` class into a new `Position` class.
Moreover, within this new `Position` class, the heading information was consolidated into an enumeration called `CaridinalDirection`.

### Overview of the `CardinalDirection` enumeration

The `CardinalDirection` enumeration provides a simple interface to create and manipulate cardinal directions for the `Position` class whilst being checked to ensure that only the valid values are accepted.
The enumeration has four cases `NORTH`, `EAST`, `SOUTH`, and `WEST`.
A simple switch statement is used to convert a `char` into a `CardinalDirection`.
Given that there are only four possibilities, the small expense in time complexity was chosen over the likely larger space expense of using a hash table to represent the values.
If the provided `char` does not match any of the four options, `null` is returned.

For modifications, the `CardinalDirection` provides two methods that return a new `CardinalDirection` value corresponding to the new direction.
Due to limitations in Java, which automatically marks all possible enumeration values as final, it is not possible to make these methods directly mutate the underlying variable or constant in which they are stored. This detail is evident when the `Rover` class is evaluating commands from the `InputFilter` class.
Default cases are provided in these methods to handle the case when the current `CardinalDirection` resolves as `null`.

### Overview of the `Position` class

The `Position` class serves to provide a neat consolidation for the x coordinate, the y coordinate, and the cardinal direction, which together create a conceptual position that can more clearly be referred to elsewhere in the program.

It contains 3 instance variables: an `int` x representing the x coordinate, an `int` y representing the y coordinate, and a `CardinalDirection` value representing the heading.
The only constructor takes in these three values and initialises the instance variables accordingly.

The `Position` class also defines a number of methods, one of which provides the functionality of moving, and the remaining provide miscellaneous useful components that are used in the tests, or that can be used for debugging.
The `moveOne()` method checks the current direction and, if the position is not beyond the bounds of the global `Plateau`, the x or y value is either incremented or decremented according to the axis and direction of the move. The directional information is obtained through the `Position` object's `heading` value.
The remaining methods are provided as overrides to those defined on the Java base class `Object` and serve to aid with testing and debugging.

## Consequences

The consequence of the architectural decision is that the `Rover` class is much more readable when getting and setting its position.
The specific actions being taken to move one space, turn left, or turn right can be viewed in the appropriate type (`Position` for the former, and `CardinalDirection` for the two latter), as needed.
Developers working on this project can more easily add newer functionality without overcomplicating the code to an unmanageable degree.
This in turn, saves much time as all the information is still present, yet in a more smooth workflow such that more commonly used code can be access more directly.
For example, one can trace the code into the Rover.java file and step into code declared in the Position.java and/or CardinalDirection.java files when looking for a specific bug; the code can easily be skipped when this appears to be working as expected (this code, of course, can be accessed directly when necessary as well).

On top of that, some minor modifications that reduce the likelihood of bugs being introduced in code through the use of compiler checks were also integrated. For example, the initialisation of the position information is only done once in the constructor since there is no functional reason to provide filler data to initialise the properties prior to the running of the constructor. The first time they are accessed, is by the constructor to assign the known values to them.

These consequences are encouraging, however, while writing this decision report, it has come to the attention of Trevor that further work can be done to streamline future development and further separate concerns regarding the input processing, such as in the `Rover` class, which currently is required to do things outside what would be traditionally expected of a `Rover` and not any input processing (this would simplify implementations of alternative input methods, if and when that becomes a priority, as one example).
For more information on these proposed plans, see the ADR 2b which is to go into them in extensive detail.
