/*
 * RegDFA.h
 *
 *  Created on: Feb 16, 2015
 *      Author: Deverick
 */

#ifndef REGDFA_H_
#define REGDFA_H_
#include <string>

using namespace std;

class RegDFA {
public:
	RegDFA();
	struct State;
	virtual ~RegDFA();
	void fileParser();
	void toNFA(string Postfix);
	void charTransition(char c);
	Vertex* createStart();
	Vertex* createFinal();
	void kleene();
	void orSelection();
	void concatState();




private:

};




#endif /* REGDFA_H_ */
