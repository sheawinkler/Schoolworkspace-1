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
	virtual ~Vertex();

	State thisState;
	Edge* out;
	Edge* out2;
};




//-------------------------------GRAPH TABLE----------------------------------------//
class GraphTable{
	//list of stateNotes
	//Space is required between angled brackets
public:
	//Dont forget your copy constructor
	GraphTable();
	int numVert, numEdges;
	std::vector< std::vector<Edge*> > adjacencies;
	std::vector< std::vector<Edge*> > dfaList;
	void InsertEdgeByWeight(Vertex vertF,Vertex vertT, char weigh);
	void InsertEdgeByWeight(Vertex* vertF,Vertex vertT, char weigh);
	void Closure();
	void TravelMarker();
	void PrintTable();

};


#endif /* VERTEX_H_ */
