# IAT_data_analysis
## Experimental Design
During the task, participants were presented with a stimulus which was either a word or an image of a face. If the stimulus was a face, the participant had to indicate if the face belonged to a Black American or a White American, and if the stimulus was a word, the participant had to indicate if the word was good or bad. To make their response, the participant would press the left key (e) for one label and the right key (i) for the other.

The tables below show the stimuli presented and side associated with each label during each block of the experiment. There are two possible orders for the blocks, one where Black and good share a side first and one where White and good share a side first. The two orders were counterbalanced.

Block Sequence for Participants Assigned Black First

| Block | Number of Trials | Stimuli |Left Label | Right Label|
| --- | --- | --- | --- | --- |
| 1 | 20 | Face | Black | White |
| 2 | 20 | Word | Good | Bad |
| 3 | 20 | Face or Word | Black, Good | White, Bad|
| 4 | 40 | Face or Word | Black, Good | White, Bad|
| 5 | 20 | Face | White | Black |
| 6 | 20 | Face or Word | White, Good | Black, Bad|
| 7 | 40 | Face or Word | White, Good | Black, Bad|

Block Sequence for Participants Assigned White First

| Block | Number of Trials | Stimuli | Left Label | Right Label|
| --- | --- | --- | --- | --- |
| 1 | 20 | Face | White | Black |
| 2 | 20 | Word | Good | Bad |
| 3 | 20 | Face or Word | White, Good | Black, Bad|
| 4 | 40 | Face or Word | White, Good | Black, Bad|
| 5 | 20 | Face | Black | White |
| 6 | 20 | Face or Word | Black, Good | White, Bad|
| 7 | 40 | Face or Word | Black, Good | White, Bad|

The data from one run of the experiment was recorded in one log file.

## Log Cleanup
Each log initially contained three columns: time, level, and message. Messages recorded in the log include the start of the experiment, randomization of block order, presentation of instructions for each block, the start of each block, each stimulus presented, each keypress, and the end of the experiment. All keypresses were recorded with an entry with the level DATA. The final keypress, which was also the correct keypress, for each trial was also recorded with an additional entry with the level CRITICAL. All other types of messages had the level CRITICAL. The time that each message took place was recorded in seconds.

Only the entries with stimulus or final keypress messages (both level CRITICAL) from block 3, block 4, block 6, and block 7 were kept to be used for scoring. 

## Determining Trial Times
Each stimulus presented corresponded to one trial.

The time for each trial was calculated by taking the difference between time corresponding to the stimulus message and the time corresponding to the final keypress message immediately following the stimulus message. This method of calculating trial time was used for all trials, including error trials where the participant pressed the incorrect key before pressing the correct one.

## Scoring
One score was calculated for each log.

All trials with times greater that 10,000 ms or less than 300 ms were not included in the scoring.

First, the mean of all included trial times was calculated for block 3, block 4, block 6, and block 7. The standard deviation of the included trials times of blocks 3 and 6 combined and blocks 4 and 7 combined were also calculated.

Next, the difference between the means of block 6 and block 3 and the difference between the means of block 7 and block 4 were calculated.

These differences were then divided by the standard deviation of the trial times of the associated blocks (blocks 3 and 6, or blocks 4 and 7).

The final score was then calculated by averaging the two quotients.
