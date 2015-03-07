/*
 * GraphTable.h
 *
 *  Created on: Feb 16, 2015
 *      Author: Deverick
 */
#ifndef GRAPHTABLE_H_
#define GRAPHTABLE_H_
#include <string>
#include <vector>
#include "Edge.h"
#include "Vertex.h"

class Edge;

//-------------------------------GRAPH TABLE----------------------------------------//
class GraphTable{
	//list of stateNotes
	//Space is required between angled brackets on vector
public:
	//Dont forget your copy constructor
	GraphTable();
	int numVert, numEdges;
	std::vector< std::vector<Edge*>* > *adjacencies;
	//std::vector< std::vector<Edge*> > dfaList;

	void InsertEdgeByWeight(Vertex* vertF,Vertex* vertT, char weigh);
	void Closure();
	void TravelMarker();
	void PrintTable();

};



#endif /* GRAPHTABLE_H_ */
