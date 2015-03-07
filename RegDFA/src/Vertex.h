/*
 * Vertex.h
 *
 *  Created on: Feb 16, 2015
 *      Author: Deverick
 */

#ifndef VERTEX_H_
#define VERTEX_H_
#include <string>
#include <vector>
#include "Edge.h"

class Edge;
/*
 * stateId refers to the current state
 * Struct will represent a state node within the ADJList
 */
struct State{
	int stateId;
	bool rootState;
	bool finalState;
	State(){
		stateId=-1;
		finalState=false;
	    rootState=false;
	}
};

class Vertex{
public:
	Vertex();
	Vertex(const Vertex& T);
	Vertex& operator=(const Vertex& S);
	virtual ~Vertex();

	State thisState;
	Edge* out;
	Edge* out2;
};


#endif /* VERTEX_H_ */
