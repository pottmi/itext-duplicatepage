# itext-duplicatepage
Simple iText based Groovy program that duplicates pages in a set of pdf files

This is open sourced to comply with iText license agreement:
http://itextpdf.com/agpl

You will want to read that license agreement carefully.

Here is a bash script that runs the program.  You will need to adjust the paths.

```bash
#!/bin/bash

TOOLS=~/Tools
export GROOVY_HOME=$TOOLS/groovy-1.8.9
export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Home
export JAVA_OPTS=-Xmx512M

PATH=$GROOVY_HOME/bin:$PATH

TOOLS=~/TOOLS

groovy -classpath $TOOLS/itext/itextpdf-5.5.7.jar ./duplicatepage.groovy out.pdf inputs/*.pdf
```

