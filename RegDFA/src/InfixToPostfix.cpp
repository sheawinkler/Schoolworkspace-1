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
using namespace std;


InfixToPostfix::InfixToPostfix() {
	// TODO Auto-generated constructor stub

}

InfixToPostfix::~InfixToPostfix() {
	// TODO Auto-generated destructor stub
}

void InfixToPostfix :: convertToPostfix(std::string STRING){
	for(char& c : STRING) {
	   std::cout<<c<<std::endl;
	}
}


