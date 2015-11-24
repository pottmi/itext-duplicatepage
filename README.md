# itext-duplicatepage
Simple iText based Java program that duplicates pages in a set of pdf files

---------
# here is a script for compiling and running:

#!/bin/bash

set -o errexit
set -o pipefail
set -o noclobber
set -o nounset

function traperrsimple
{
   # Use this function if the above function fails
   echo "ERROR: ${BASH_SOURCE[0]} ${LINENO}" >&2
   # if BASH_SUBSHELL is 0, then script will exit anyway.
   if (( $BASH_SUBSHELL >= 1 ))
   then
      kill $$
   fi
}
set -o errtrace
trap traperrsimple ERR

TOOLS=~/Tools
export GROOVY_HOME=$TOOLS/groovy-1.8.9
export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Home
export JAVA_OPTS=-Xmx512M

PATH=$GROOVY_HOME/bin:$PATH

TOOLS=~/TOOLS

groovy -classpath $TOOLS/itext/itextpdf-5.5.7.jar ./duplicatepage.groovy out.pdf inputs/*.pdf

---------
