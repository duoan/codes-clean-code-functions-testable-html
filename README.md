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

- [init with no-refactored code](https://github.com/classtag/clean_code_functions_testable_html/commit/091dd74c80909a60f451114bdac14d5290b008c6#diff-2852df592e38c08a07afcc7e41838082)
- [extract the function to a class](https://github.com/classtag/clean_code_functions_testable_html/commit/d1b8e508460dd06849ccf4c51931b4ba843ac857#diff-2852df592e38c08a07afcc7e41838082)
- [extract the duplicated get crawler logic into a class field , initial it at construct method](https://github.com/classtag/clean_code_functions_testable_html/commit/5ce25d545345b4a07306dc712e65bcabbcd9003d#diff-2852df592e38c08a07afcc7e41838082)
- [extract mode variable](https://github.com/classtag/clean_code_functions_testable_html/commit/436fbd74af02a5b9637550ce04142d85581aa7ba#diff-2852df592e38c08a07afcc7e41838082)
- [extract includePage function for 4 same block](https://github.com/classtag/clean_code_functions_testable_html/commit/e1281124a5f822b3db61a9b4c910903cb5641d4d#diff-2852df592e38c08a07afcc7e41838082)
- [use String.format replace String + String](https://github.com/classtag/clean_code_functions_testable_html/commit/9720018e0163b4c6932d9a962c1ede42866132ac#diff-2852df592e38c08a07afcc7e41838082)
- [extract includeIfInherited function](https://github.com/classtag/clean_code_functions_testable_html/commit/26370b9667640a895463c38fd078e4416ed0bda2#diff-2852df592e38c08a07afcc7e41838082)
- [extract includeSetups and includeTearDowns functions](https://github.com/classtag/clean_code_functions_testable_html/commit/78d7bf63c49158f242348852b945447da2183079#diff-2852df592e38c08a07afcc7e41838082)
- [cut the StringBuffer with funcitons return string](https://github.com/classtag/clean_code_functions_testable_html/commit/29d061ccde64ae8e1f0879693fb0a8e3d16e9597#diff-2852df592e38c08a07afcc7e41838082)
- [merge the if block into one together](https://github.com/classtag/clean_code_functions_testable_html/commit/93d53e2f23faad13933921e642c0cafb104269ae#diff-2852df592e38c08a07afcc7e41838082)
- [extract isTestPage function for more readable code](https://github.com/classtag/clean_code_functions_testable_html/commit/a9aa5f37ab79720d1d9338447dc3f5403b178995#diff-2852df592e38c08a07afcc7e41838082)
- [extract surroundPageWithSetupsAndTeardowns functions](https://github.com/classtag/clean_code_functions_testable_html/commit/3cf27c4c653d97a5336f5e835c9f6cd9263cf332#diff-2852df592e38c08a07afcc7e41838082)
- [rename the class name and invoke name more meaningful](https://github.com/classtag/clean_code_functions_testable_html/commit/0a59fcd4db51258f15683369580c80459871e3cd#diff-2852df592e38c08a07afcc7e41838082)

These bellow refactor history shows how to refactor a big fucntion into very small functions.
It makes sure each function just do one thing, and simple, very nice for reading.


run command ```git hist``` to see the refactor history.
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
