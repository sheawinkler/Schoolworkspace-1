#!/bin/bash

if [ ! -e q1.txt ] 
then
    echo "Could not find testcase q1.txt, downloading .."
    wget http://cse.unl.edu/~xu/courses/automata/q1.txt
fi

rm -f projectoutput.txt
files=(*.java)
if [ -e "${files[0]}" ] 
then
    echo "Java files"
    javac *.java
    if [ $? == 0 ]
    then
        echo "Successfully compiles: 30 points"
    else
        echo "Could not compile the code"
        exit
    fi
    if [ -e project1.class ] 
    then
        echo "Successfully finds the executable file: 10 points"
        timeout 15s java project1 < q1.txt > projectoutput.txt
    elif [ -e Project1.class ] 
    then
        echo "Successfully finds the executable file: 10 points"
        timeout 15s java Project1 < q1.txt > projectoutput.txt
    else
        echo "Could not find class Project1.class"
        exit
    fi        
else
    echo "C/C++ files"
    if [ ! -e Makefile ] 
    then
        echo "Could not find Makefile"
        exit
    fi
    make
    if [ $? == 0 ]
    then
        echo "Successfully compiles: 30 points"
    else
        echo "Could not compile the code"
        exit
    fi
    if [ -e project1 ] 
    then
        echo "Successfully finds the executable file: 10 points"
        timeout 15s  ./project1 < q1.txt > projectoutput.txt
    elif [ -e Project1 ] 
    then
        echo "Successfully finds the executable file: 10 points"
        timeout 15s  ./Project1 < q1.txt > projectoutput.txt
    else
        echo "Could not find executable file project1"
        exit
    fi        
fi

if [ ! -e "a1.txt" ] 
then
    echo "Could not find output a1.txt, downloading .."
    wget http://cse.unl.edu/~xu/courses/automata/a1.txt
fi

wrong=$(diff -i -w -y --suppress-common-lines -N projectoutput.txt a1.txt | wc -l)
let "correct=6-$wrong"
echo "Number of correct outputs in the testcase:" $correct " points"

