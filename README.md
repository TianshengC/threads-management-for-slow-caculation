# threads management for slow caculation
 
This is a threads management system for a slow caculator. You could type the following command to control the operation of threads.

User Commands for the Solution.runCommand Method:

start N:

Description: Initiates a calculation with the input N.
Action: Calls SlowCalculator.run on a new thread.
Response: Returns the message “Started N”.


cancel N:

Description: Stops the ongoing calculation with the input N.
Action: Cancels the calculation with input N that's currently running. If the calculation has already completed or was never initiated, no action is taken.
Response: Returns the message “Cancelled N”.


running:

Description: Provides information about the currently active calculations.
Action: None.
Response: Returns a message indicating the total number of ongoing calculations (excluding completed ones) and their respective inputs N. For example: “3 calculations running: 12345, 43645, 42452”.


get N:

Description: Retrieves the result of the calculation for N.
Action: Checks the status of the calculation for N.
Response:
If the calculation is complete: “result is M”, where M is the integer result.
If the calculation is still ongoing: “calculating”.


finish:

Description: Waits for all previously requested calculations to complete.
Action: Allows all ongoing calculations to finish.
Response: Returns the message “Finished” after finishing all caculations.


abort:

Description: Halts all ongoing calculations immediately.
Action: Stops all running calculations.
Response: Returns the message “Aborted”.

For any unrecognized or malformed command (e.g., if N is not an integer), the method should return the message “Invalid command”.