/*
 * InfixToPostfix.cpp
 *
 *  Created on: Feb 16, 2015
 *      Author: Deverick
 */
#include <string>
#include "InfixToPostfix.h"
#include <iostream>
#include <cstdlib>
#include <queue>
#include <map>
#include <stack>

using namespace std;
std::map<char, int> precedenceMap;

InfixToPostfix::InfixToPostfix() {
	precedenceMap['(']=1;
	precedenceMap['|']=2;
	precedenceMap['.']=3;
	precedenceMap['*']=4;
	//precedenceMap[')']=1'
	//For later usage
	//precedenceMap.erase("");
	//std::cout<<"The map size is"<<precedenceMap.size()<<std::endl;
}
InfixToPostfix::~InfixToPostfix() {
	// TODO Auto-generated destructor stub


}

string InfixToPostfix :: addConcat(std::string STRING){
	string concatREG;
	//Check statement
	//cout<< STRING<<endl;
	const char concat = '.';
	for(std::string::size_type i = 0; i < STRING.size(); ++i) {
		concatREG.push_back(STRING[i]);
		if((STRING[i]==('a')||STRING[i]==('b')) && (STRING[i+1] == ('a')||STRING[i+1] == ('b'))){
			concatREG.push_back(concat);
		}else if(STRING[i]==(')') && STRING[i+1]=='('){
			concatREG.push_back(concat);
		}else if(STRING[i]=='*' && STRING[i+1]=='('){
			concatREG.push_back(concat);
		}else if((STRING[i]=='*') && (STRING[i+1]=='a'||STRING[i+1]=='b')  ){
			concatREG.push_back(concat);
		}
	}
	//Check statement
	//cout<<"here is the concat  "<<concatREG<<endl;
	return concatREG;
}


/*
 * Returns the <int> precedence value of the input
 *
 */
int InfixToPostfix :: returnPrecedence(char inputChar){
	//return precedenceMap.
	int valuePrecedence=6;
	std::map<char,int>::iterator p = precedenceMap.find(inputChar);;
		if(p!= precedenceMap.end()){
			valuePrecedence= p->second;
		}
		return valuePrecedence;
}


/*
 * Returns true if the current character
 * has higher precedence than the comparing
 * Need to check if EQUALITY IS ACCEPETED AS HIGHER PRECEDENCE
 */
int InfixToPostfix:: higherPrecedence(char inputChar, char comparingChar){
	if(returnPrecedence(inputChar)>=returnPrecedence(comparingChar)){
		return true;
	}
	return false;
}



//Need to return the Postfix string
string InfixToPostfix :: convertToPostfix(std::string STRING){
	std::deque<char> outputQueue;
	//To push operators
	std::stack<char> operatorStack;
	//WILL NEED TO CHANGE FOR CSE STANDARDS!!
	for(char& c : STRING) {
		   switch ( c ) {
		   case 'a':
			   // append operand to end of PE
			   outputQueue.push_back(c);
			   break;
		   case 'b':
			   // append operand to end of PE
			   outputQueue.push_back(c);
			   break;
		   case '(':
			   // save �(� on stack
			   operatorStack.push(c);
			 break;
		   case ')':
			 //  pop stack until matching �(�
			   while(operatorStack.size()>0 && ( '('!=operatorStack.top()  )  ){
				   //Add all operators to the output
				   	 outputQueue.push_back(operatorStack.top());
				   	 operatorStack.pop();
			   }
			   if(operatorStack.size()==0){
				   cout<<"Mismatched parenthesis detected."<<endl;
			   }
			   //Removing contributing '(' char
			   operatorStack.pop();
			   break;
		   default:
			   /* Add it to the stack only after we have popped off everything of higher precedence
			    * if operator is left associative, we pop operators of equal precedence
			    * if it is right associative we do not
			    * This may or may not be right.  May need to skip if ( or )
			    */
			   // process stack operators of greater precedence
			   	 while(operatorStack.size() > 0 && ('('!=operatorStack.top()) && higherPrecedence(operatorStack.top(),c) ){
			   		 	 //If operator stack precedence is greater or equal to char
			   		 		 	outputQueue.push_back(operatorStack.top());
			   		 		 	operatorStack.pop();
			   	 }
			   		 operatorStack.push(c);	//Save new char

			   	 break;
		   }
	}
	while(operatorStack.size()>0){
	   	 outputQueue.push_back(operatorStack.top());
	   	 operatorStack.pop();
	}
	std::string output_string(outputQueue.begin(), outputQueue.end());
	outputQueue.clear();
	//return string
	cout<<"HEre is the final output String  "<<output_string<<endl;
	cout<<"Above should be the postfix output to console "<<endl;
	//while stack has operators..enqueue into outputQueue
	if(operatorStack.size()>0){
		cout<<"There are still items on the stack, mismatch occurred"<<endl;
	}
	return output_string;
}


