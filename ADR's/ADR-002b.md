# Streamlining of Input Processing

**Status:** 

## Context/Forces at Play

After the completion of ADR-002a, it became clear to Trevor Hafner that there was still some more to be desired regarding the way that the input processing subsystem is configured.
Prior to the implementation of the ADR, the input processing is done mostly in the `InputFilter` class with the value conversion being performed by the `Rover` class.
Additionally, it would be desireable to have the ability to have the subsystem responsible for input processing to be able to provide errors in cases where invalid values are provided to the program.

## Decision 

The constructor for the `Rover` class is to be reconfigured to only take a single Position object, marking its current position. 