Clean Code - Functions - Testable Html
======================================

This repository show how to refactor a big function to a more readable
code code step by step from Uncle Bob (UB) who is the author of Clean
Code.

Flowing this repository will let you know following questions ?

- How big should a function be? 20 Lines? A screenful? Is there a way
to know if your functions are the right size?

- Object Oriented Design involves the art of breaking applications into
classes. But have you found all the classes in the design of your
application? Is there a way to know?

- Functions are supposed to do "One Thing", do it well, and do it only.
But what is "One Thing". Is there a way to tell if your functions are
obeying that rule?

- The answer to all these questions is yes! And not just with some fuzzy
hand-waving platitudes either. There are fool-proof and unambiguous
answers to these questions.

## Install

step1: clone this repo:
```bash
git clone https://github.com/classtag/clean_code_functions_testable_html.git
```

step2: import the repo into your [IDEA](https://www.jetbrains.com/idea/?fromMenu),
then add jars in `lib` folder into classpath.

## Refactor History
run command ```git hist```
```bash
* 0a59fcd <anduo> (HEAD -> master) (13 seconds ago)
|         rename the class name and invoke name more meaningful
* 3cf27c4 <anduo> (2 minutes ago)
|         extract surroundPageWithSetupsAndTeardowns functions
* a9aa5f3 <anduo> (4 minutes ago)
|         extract isTestPage function for more readable code
* 93d53e2 <anduo> (5 minutes ago)
|         merge the if block into one together
* 29d061c <anduo> (6 minutes ago)
|         cut the stringbuffer with funcitons return string
* 78d7bf6 <anduo> (14 minutes ago)
|         extract includeSetups and includeTearDowns functions
lines 1-12...skipping...
* 0a59fcd <anduo> (HEAD -> master) (13 seconds ago)
|         rename the class name and invoke name more meaningful
* 3cf27c4 <anduo> (2 minutes ago)
|         extract surroundPageWithSetupsAndTeardowns functions
* a9aa5f3 <anduo> (4 minutes ago)
|         extract isTestPage function for more readable code
* 93d53e2 <anduo> (5 minutes ago)
|         merge the if block into one together
* 29d061c <anduo> (6 minutes ago)
|         cut the stringbuffer with funcitons return string
* 78d7bf6 <anduo> (14 minutes ago)
|         extract includeSetups and includeTearDowns functions
* 26370b9 <anduo> (21 minutes ago)
|         extract includeIfInherited function
* 9720018 <anduo> (24 minutes ago)
|         use String.format replace String + String
* e128112 <anduo> (25 minutes ago)
|         extract includePage function for 4 same block
* 436fbd7 <anduo> (27 minutes ago)
|         extract mode variable
* 606332f <anduo> (32 minutes ago)
|         extract the duplicated get crawler logic into a class field , initial it
|         at construct method
* 5ce25d5 <anduo> (35 minutes ago)
|         extract common variable into construct method
* d1b8e50 <anduo> (49 minutes ago)
|         extract the function to a class
* 091dd74 <anduo> (54 minutes ago)
          init with no-refactored code
```
The full version of the refactor steps can find at [history](https://github.com/classtag/clean_code_functions_testable_html/commits/master/src/clean/code/testable/html/TestableHtml.java)

## Thanks

More rules about clean code - functions can find at [clean-code-episode-3](https://cleancoders.com/episode/clean-code-episode-3/show)
